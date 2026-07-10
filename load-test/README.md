# Load-testing kit (k6)

Measures the practical capacity of the Spring Boot backend (`ai-labor-rights-guide`) with
[k6](https://k6.io/). Three scripts, one per endpoint class:

| Script | Endpoint | Throttled? | What it measures |
|---|---|---|---|
| `calc-capacity.js`   | `POST /api/calc/gross-to-net` | No  | Raw server capacity (CPU/thread-bound, pure function). |
| `search-capacity.js` | `GET  /api/search`            | 50/min/IP | The per-IP cap (429s) + raw search throughput when bypassed. |
| `chat-capacity.js`   | `POST /api/chat`              | 15/min, 60/hr, 300/day per IP | That blocked virtual threads are cheap. **Hits real DeepSeek — gated.** |

The server runs on **Java 25 with virtual threads** (`spring.threads.virtual.enabled=true`), so
I/O-bound requests park their carrier thread while blocked. There is no ~200-thread Tomcat ceiling
on concurrency, and a flood of slow chat calls cannot starve the cheap `/api/calc` and `/api/wiki`
endpoints (no shared-pool head-of-line blocking).

---

## Endpoints under test (verified by reading the source)

Verified against `controller/CalculatorController.java`, `controller/SearchController.java`,
`controller/ChatController.java`, the `dto/` records, and `config/WebConfig.java`
(interceptor registration) + `ratelimit/*` (limits).

### `POST /api/calc/gross-to-net` — unthrottled
```jsonc
// request  (record GrossToNetRequest)
{ "gross": 1500, "children": 2, "months": 14, "disability": false }

// response (record GrossToNetResult)
{ "netMonthly": ..., "efkaEmployee": ..., "incomeTaxMonthly": ...,
  "effectiveTaxRatePct": ..., "employerCost": ..., "efkaEmployer": ... }
```
`gross` must be `> 0` (the service throws otherwise). The script asserts `netMonthly > 0`.
`WebConfig` registers the rate-limit interceptor on `/api/chat` + `/api/search` **only**, so every
`/api/calc/*` endpoint is unthrottled — ideal for measuring raw capacity.

### `GET /api/search?q=<term>&limit=<n>` — 50 req/min/IP
**This is a GET with query params, not a POST with a body.** Confirmed in `SearchController`
(`@GetMapping`, `@RequestParam String q`, `@RequestParam(defaultValue="5") int limit`). Returns a
JSON array of `SearchResult { title, url, category, excerpt }`. Over the cap → HTTP `429` with a
`Retry-After` header and body `{ "error": ..., "retryAfterSeconds": ... }`.

### `POST /api/chat` — 15/min (burst 5) + 60/hr + 300/day per IP
```jsonc
// request  (ChatRequestDto)
{ "messages": [ { "role": "user", "content": "..." } ] }

// response (ChatMessageDto)
{ "role": "ai", "content": "..." }
```
Calls the **real DeepSeek API** (costs money). Daily-quota breach → 1 h cooldown + alert (not a ban).

### How per-IP limiting resolves the client IP (important for spoofing)
`ratelimit/RateLimitInterceptor.clientIp()` resolves the IP in this order:
1. `X-Real-IP` header (set by nginx to the true peer),
2. last hop of `X-Forwarded-For`,
3. socket remote address.

**Production nginx overwrites `X-Real-IP`** (`proxy_set_header X-Real-IP $remote_addr` in
`nginx/templates/app.conf.template`). So through prod nginx, a single-source load test all counts as
**one IP** and gets throttled on chat/search. Spoofing `X-Real-IP` per-VU (the `SPOOF_IP` mode below)
only works when you hit the **app port directly** (local/staging, bypassing nginx).

---

## Install k6

**Windows**
```powershell
winget install k6 --source winget
# or
choco install k6
```

**Linux (Debian/Ubuntu apt)**
```bash
sudo gpg -k
sudo gpg --no-default-keyring --keyring /usr/share/keyrings/k6-archive-keyring.gpg \
  --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys C5AD17C747E3415A3642D57D77C6C491D6AC1D69
echo "deb [signed-by=/usr/share/keyrings/k6-archive-keyring.gpg] https://dl.k6.io/deb stable main" \
  | sudo tee /etc/apt/sources.list.d/k6.list
sudo apt-get update && sudo apt-get install k6
```

**Linux (standalone binary)**
```bash
curl -L https://github.com/grafana/k6/releases/latest/download/k6-vX.Y.Z-linux-amd64.tar.gz \
  | tar xz && sudo mv k6-*/k6 /usr/local/bin/
```
Verify: `k6 version`.

---

## Run

All scripts read `BASE_URL` from the environment (default `http://localhost:8080`). Run from the repo
root. Use a **direct app URL** (`http://localhost:8080`) when you need IP spoofing or the master
rate-limit switch; use the **prod URL** (`https://<your-domain>`) to test the real edge (nginx + TLS).

```bash
# 1) Raw capacity (unthrottled calc). Local:
k6 run load-test/calc-capacity.js
# Against prod:
k6 run -e BASE_URL=https://your-domain.example load-test/calc-capacity.js

# 2) Search — single IP, SEE the 50/min cap as 429s (custom rate_limited_* metrics):
k6 run load-test/search-capacity.js
#    Search — bypass per-IP cap with a unique X-Real-IP per VU (DIRECT app URL only; prod nginx
#    overwrites X-Real-IP so this has no effect through prod):
k6 run -e SPOOF_IP=true -e BASE_URL=http://localhost:8080 load-test/search-capacity.js

# 3) Chat — GATED. Refuses to run (and spends $0) unless you opt in:
k6 run load-test/chat-capacity.js                         # prints warning, aborts
k6 run -e RUN_CHAT=true load-test/chat-capacity.js        # hits REAL DeepSeek ($$)
k6 run -e RUN_CHAT=true -e VUS=3 -e DURATION=30s load-test/chat-capacity.js
```

Tip: to watch the virtual-threads benefit, run `chat-capacity.js` and `calc-capacity.js` in two
terminals at once — calc p95 should stay flat while many chat requests are parked on DeepSeek.

---

## Measuring TRUE max concurrency in prod despite per-IP limiting

The per-IP limiter means a single load generator hitting prod nginx is capped at 50 search/min and
~15 chat/min regardless of how many VUs you spin up — so you'd be measuring the limiter, not the
server. To find the server's real ceiling:

**Recommended — disable throttling for the test window, then re-enable.**
1. Set `APP_RATELIMIT_ENABLED=false` (binds to `app.ratelimit.enabled`; `RateLimitingService.checkChat`
   / `checkSearch` then short-circuit to "allow") and restart/redeploy the backend.
2. Run the ramps against the real edge:
   ```bash
   k6 run -e BASE_URL=https://your-domain.example load-test/calc-capacity.js
   k6 run -e BASE_URL=https://your-domain.example load-test/search-capacity.js
   ```
   (With the limiter off you can also drop `SPOOF_IP`; no header tricks are needed.)
3. Record the **knee**: the highest VU stage where `http_req_duration` p95 stays within your budget
   **and** `http_req_failed` stays `< 1%`. Note the corresponding `http_reqs`/s.
4. **Re-enable**: `APP_RATELIMIT_ENABLED=true`, restart. Do not leave throttling off — it's the abuse
   + DeepSeek-cost guard.

Keep the window short and announce it; while it's off the server is unprotected.

**Alternative — distributed load from many real IPs.** Run k6 from several machines / a cloud
fleet (e.g. k6 Cloud or one runner per region) so each source is a distinct IP and the per-IP cap
applies per source instead of in aggregate. No app config change, but more setup, and the chat cost
ceiling still applies.

> The `SPOOF_IP=true` mode in `search-capacity.js` is the *local/staging* equivalent of the above —
> it fakes many IPs by setting `X-Real-IP` per VU. It does **not** work through prod nginx, which
> overwrites `X-Real-IP`. For prod, use the master switch.

---

## Interpreting results → "max concurrent users"

There is no single "max users" number; it depends on which endpoint dominates your traffic.

- **(a) Cheap endpoints (`/api/calc`, `/api/wiki`) are CPU/thread-bound and scale high.** With virtual
  threads they aren't pool-limited; the ceiling is CPU and GC. Report the knee from
  `calc-capacity.js`: the VU level where p95 is still acceptable and `http_req_failed < 1%`, plus the
  sustained `http_reqs`/s there. That req/s ÷ (your assumed requests-per-user-per-second) ≈ concurrent
  users the box can carry for calc-type load.
- **(b) The chat ceiling is the DeepSeek upstream + your daily cost budget, NOT your server.** Your
  server holds blocked chat requests cheaply (parked virtual threads), so it is almost never the
  bottleneck. The real limits are DeepSeek's provider rate/quota and `app.cost.daily-alert-threshold`.
  And one user **cannot exceed 15 chat/min** anyway (per-IP cap), so per-user chat load is bounded by
  design — don't derive "max users" from a chat stress test.
- **(c) Always report `req/s` and `p95` at the knee**, per endpoint, not just a peak VU count. Peak VUs
  without latency context is meaningless.

### Reading the k6 end-of-test summary (worked example)
```
     http_reqs......................: 184523  1537.6/s
     iterations.....................: 184523  1537.6/s
     vus............................: 400     min=0  max=400
     http_req_duration..............: avg=61ms  min=2ms med=48ms  p(90)=120ms p(95)=180ms max=1.2s
       { endpoint:calc-gross-to-net }: ...                              p(95)=175ms
     http_req_failed................: 0.42%   774 out of 184523
```
Read it as:
- `http_reqs` / `iterations` — total requests and the **req/s** rate (here ~1538/s). For these
  scripts one iteration = one request, so they track.
- `vus` — concurrency reached (max 400). Cross-reference with the stage timeline to find which stage
  the p95 crossed your budget.
- `http_req_duration` **p(95)** — the latency budget check; here 180 ms overall, 175 ms for the tagged
  calc request. If your threshold is `p(95)<250`, you're under it → 400 VUs is still inside the knee.
- `http_req_failed` — 0.42% `< 1%` ✔. If this had been, say, 6% at the 400-VU stage, the knee is below
  400; re-read the per-stage numbers to find where it crossed 1%.

For `search-capacity.js` in single-IP mode, also look at the custom metrics:
```
     rate_limited_429...............: 9123     (count of 429s)
     rate_limited_rate..............: 71.4%
```
A high `rate_limited_rate` is the **expected** demonstration of the 50/min cap — not a server problem.
In `SPOOF_IP=true` mode (direct app URL) it should drop to ~0 and `http_reqs`/s then reflects true
search throughput.

For `chat-capacity.js`, the custom counters `chat_200` / `chat_429` / `chat_5xx` break down outcomes:
real (paid) answers vs throttling vs upstream/server errors.

---

## How timeouts bound held connections under chat load

Blocked chat connections are held for as long as the upstream/proxy allow:

- **`spring.http.client.read-timeout=90s`** (`application.properties`) is **per DeepSeek HTTP call**.
  A chat turn may make several sequential calls (`search_articles` → `get_article` → answer), so the
  whole turn can exceed 90 s even though no single call does.
- **nginx `proxy_read_timeout 120s`** (`nginx/templates/app.conf.template`, the `/api/` location) caps
  how long nginx waits on the backend before returning 504. Keep it `≥` the worst-case sum of the
  per-call read-timeouts, or valid-but-slow turns get cut off at the edge as 504s.

Under load these two values determine the maximum lifetime of a parked virtual thread per in-flight
chat request. `chat-capacity.js` sets a k6-side `timeout: '150s'` (above nginx's 120 s) so k6 doesn't
abandon a request before nginx/Spring would have answered — letting you observe the real held-connection
behaviour rather than a client-side cutoff.

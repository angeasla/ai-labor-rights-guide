# Cost & Abuse Hardening — Work Log

Session record of the LLM cost-control / abuse-mitigation work on the AI chatbot backend
and frontend, plus the supporting verification tooling. Companion to `MERGE_PR_PLAN.md`.

- **Date:** 2026-06-15
- **Repos touched** (both are working copies, **not git repos locally** — changes must be
  applied into the real upstream repos and committed there):
  - Backend — `ai-labor-rights-guide`
    (Spring Boot 4, Spring AI 2.0.0-M6, Java 25, virtual threads; LLM = DeepSeek `deepseek-chat`)
  - Frontend — `Angular-frontend` (Angular, ngx-markdown)
  - Planning docs — `worker-rights-guide` (this repo)
- **Nothing is committed.** The backend is not even `git init`-ed locally.

---

## 1. Context — what triggered this

A per-IP rate-limiting package (`ratelimit/**` — bucket4j token buckets, CIDR-aware shared-IP
multiplier, 429 + `Retry-After` interceptor, daily-quota cooldown + alert) already existed in the
backend from a prior session. We audited it against a Greek **cost-control + abuse-pattern
checklist** and found the rate limiter is **volumetric throttling only** — it did not cover most of
the checklist. This session closed those gaps.

### Audit result (checklist vs. code, before this session)

| # | Checklist item | Status before |
|---|---|---|
| 1 | Max input ~8k tokens / request | ❌ none (frontend `slice(-6)` is a bypassable message-count window) |
| 2 | Max output ~1k tokens | ❌ no `max-tokens` set |
| 3 | Server timeout 30s / LLM call | ⚠️ exists but 90s, per-HTTP-call |
| 4 | Cost logging + daily-spend alert | ❌ only request-count alert, no € |
| 5 | Provider outage → static msg + no retry | ❌❌ no fallback; **Spring AI default ~10× retry was ON** |
| 6 | Bot dedup 60s / IP | ❌ none |
| 7 | Prompt stuffing → truncate | ❌ none |
| 8 | Machine-speed → 2s min gap | ⚠️ token-bucket burst≈5, not a hard 2s gap |
| 9 | Jailbreak → system prompt | ✅ `system-prompt.md` §Ασφάλεια |

---

## 2. Backend changes — LLM cost controls + outage fallback (maps to plan PR #7)

All verified compiling on **JDK 25** and all unit tests green (see §6).

### 2.1 Config (`src/main/resources/application.properties`)

```properties
# Disable Spring AI's default retry (~10 attempts) — a retried turn multiplies cost during a
# DeepSeek incident/rate-limit. 1 = one attempt, no retry.
spring.ai.retry.max-attempts=1
# Cap completion length (most expensive tokens).
spring.ai.deepseek.chat.options.max-tokens=1000

# Inbound payload guards (chars; ~2.5 chars/token heuristic for Greek — approximate).
app.chat.max-input-chars=20000      # ≈ 8k tokens across the conversation
app.chat.max-message-chars=1500     # ≈ 500 tokens per message; longer is truncated

# Cost accounting (rates per 1,000,000 tokens — PLACEHOLDERS, verify vs current DeepSeek pricing).
app.cost.input-per-1m-tokens=0.27
app.cost.output-per-1m-tokens=1.10
app.cost.daily-alert-threshold=10.0
```

### 2.2 Java

| File | Change |
|---|---|
| `service/ChatInputGuard.java` *(new, `@Service`)* | `sanitize(messages)`: truncates any message over `max-message-chars`, then drops oldest messages until under `max-input-chars` (always keeps the most-recent). Logs counts/lengths only — never content. The real prompt-stuffing defense (items #1, #7). |
| `service/UsageCostService.java` *(new, `@Service`)* | `record(promptTokens, completionTokens)`: computes estimated cost, logs one `CHAT_COST tokensIn=… tokensOut=… estCost=… dailyTotal=…` line, accumulates an in-memory daily total (resets at `LocalDate` rollover), and fires a **one-shot** daily-spend alert on threshold crossing. Cost values formatted to **4 dp** via `String.format(Locale.ROOT, "%.4f", …)` (locale-independent `.` separator; internal accumulator keeps full precision). Items #4, #5. |
| `ratelimit/AlertService.java` *(edited)* | Added `dailyCostThresholdExceeded(double spent, double threshold)` → stable WARN line `COST_ALERT daily estimated spend exceeded spent={} threshold={}`. |
| `service/AiChatService.java` *(edited)* | Wiring: `sanitize()` → build messages → `.call().chatResponse()` → `recordUsage()` (null-safe usage extraction) → return `getResult().getOutput().getText()`. Return type still `String`; `ChatController` untouched. **No try/catch** — provider failures intentionally propagate to the advice below. |
| `controller/ChatExceptionHandler.java` *(new)* | `@RestControllerAdvice(assignableTypes = ChatController.class)` — chat-scoped so it can't mask other controllers. Catches `TransientAiException`/`NonTransientAiException`, `RestClientException` (covers 5xx + timeouts), and an `Exception` backstop. Returns **HTTP 200** with a Greek fallback bubble (graceful degradation so the frontend renders it). Items #4-outage, #5-fallback. |

Tests added: `ChatInputGuardTest` (7), `UsageCostServiceTest` (6), `ChatExceptionHandlerTest` (5) — pure-POJO, no Spring context.

### 2.3 Dead-link fix found during review

The outage fallback originally linked to `/search`, which **does not exist** in the SPA
(routes: `''`, `wiki`, `wiki/:folder/:file`, `tools` — search is a toolbar box on every page).
Repointed to a real route:

```
⚠️ Προσωρινό πρόβλημα με τον βοηθό — δοκίμασε ξανά σε λίγο. Στο μεταξύ, μπορείς να ψάξεις από τη
μπάρα αναζήτησης στην κορυφή της σελίδας ή να δεις [τον οδηγό](/wiki).
```

---

## 3. Frontend change — 429 handling (maps to plan PR #4)

`src/app/services/chat.service.ts` — added `errorMessage(error: HttpErrorResponse)` + `formatWait(seconds)`:

- **429** → shows the backend's Greek message (`error.error.error`) + wait time, e.g.
  *"Υπερβήκατε το ημερήσιο όριο… (δοκίμασε ξανά σε 2 λεπτά)"*. Prefers the JSON body field
  `retryAfterSeconds` over the `Retry-After` header (the header is CORS-gated cross-origin in dev).
- **status 0** → connection-lost message.
- **other** → the original generic message.

Reviewer fixed a Greek singular-second grammar bug (`1 δευτερόλεπτο` vs `δευτερόλεπτα`).
The rendered string flows to the chat UI as an `ai` bubble (ngx-markdown).

> **Not run through `tsc`** — the frontend `node_modules` is not installed in this checkout.
> Verified type-correct by inspection + review. Confirm with `ng build` after `npm install`.

---

## 4. Verification kit — prove retry is off (`ai-labor-rights-guide/scripts/verify-no-retry/`)

For use on a personal laptop after deploy.

- `mock-deepseek.js` — zero-dependency Node HTTP server; returns **500** to any path, counts +
  logs each request, prints `TOTAL REQUESTS RECEIVED: n` on Ctrl-C.
- `README.md` — full steps.

**Procedure:** start the mock → boot the app with `SPRING_AI_DEEPSEEK_BASE_URL=http://localhost:9999`,
`DEEPSEEK_API_KEY=<dummy>`, JDK 25, `--spring.profiles.active=local`, Meilisearch up → send one
`POST /api/chat`.

**Expected:** mock logs **exactly 1** request (→ retry is off) and the HTTP response is **200**
containing "Προσωρινό πρόβλημα" (→ outage fallback works). **Negative control:**
`--spring.ai.retry.max-attempts=5` → mock logs ~5 requests.

Verified facts (by decompiling the M6 jar): base-URL property is `spring.ai.deepseek.base-url`
(env `SPRING_AI_DEEPSEEK_BASE_URL`), completions path `/chat/completions`; a blank API key trips an
autoconfig assertion so a non-empty dummy is required; `application-local.properties` sets
`spring.main.lazy-initialization=true`. Reviewer fixed a **PowerShell 5.1 UTF-8 decode footgun**
(IRM decodes the JSON body as ISO-8859-1, garbling Greek and false-failing the success assertion) —
README now uses `Invoke-WebRequest` + explicit `[Text.Encoding]::UTF8`.

---

## 5. Load-test kit — max concurrent users (`ai-labor-rights-guide/load-test/`)

k6 scripts + README. Endpoints verified against the controllers:

| Script | Target | Notes |
|---|---|---|
| `calc-capacity.js` | `POST /api/calc/gross-to-net` body `{gross,children,months,disability}` | **Unthrottled** → raw server/virtual-thread capacity. Ramp 10→50→100→200→400 VUs; thresholds p95 + `http_req_failed<1%`. |
| `search-capacity.js` | `GET /api/search?q=&limit=` | Default single-IP demonstrates the 50/min cap (429s, custom metrics). `SPOOF_IP=true` = unique `X-Real-IP`/VU — **only works hitting the app directly** (prod nginx overwrites `X-Real-IP`). |
| `chat-capacity.js` | `POST /api/chat` | **Gated behind `RUN_CHAT=true`** ($0 otherwise); calls real DeepSeek and is capped at 15/min/IP anyway. |

**Measuring true prod concurrency despite per-IP limiting:** temporarily set
`APP_RATELIMIT_ENABLED=false` for the test window, run the calc/search ramps, record the VU "knee"
(p95 acceptable + `http_req_failed < 1%`), then **re-enable**. Chat capacity is bound by the DeepSeek
upstream + daily cost budget, not the server. Reviewer confirmed all three scripts run cleanly under
`k6 run`; flagged a minor `SPOOF_IP` last-octet collision only above 255 VUs.

---

## 6. Verification status

- **Backend build:** compiles on JDK 25 (`JAVA_HOME` here defaults to 17; JDK 25 at
  `C:\development\tools\jdk-25.0.3+9`).
- **Tests:** 43 run, **0 failures**, 1 error — `AiLaborRightsGuideApplicationTests.contextLoads`.
  Green: ChatExceptionHandlerTest (5), ChatInputGuardTest (7), UsageCostServiceTest (6),
  RateLimitingServiceTest (6), CalculatorTest (10), LeaveBonusCalculatorTest (8).
- **The one error is PRE-EXISTING and unrelated:** the Spring AI transformers embedder tries to
  download a tokenizer from `raw.githubusercontent.com` and the corporate proxy blocks it
  (chain: `adminController → documentIngestionService → meilisearchService → embeddingModel`). None of
  our beans are involved; it works on a personal laptop off the corporate network.
- **Cost rounding confirmed in logs:** `estCost=0.2700`, `1.3700`, `0.4100` (float noise gone).
- **Review pass:** 3 independent agents reviewed the frontend 429 change, the load-test kit, and the
  retry-verification kit. Fixes applied: grammar bug (frontend), PowerShell UTF-8 footgun + mock
  robustness (retry kit). Load-test kit: no correctness bugs.
- **Housekeeping:** `mvn clean` removed `target/`; no node artifacts anywhere. Repos are source-only
  and lean (backend 0.8 MB / 161 files, frontend 0.9 MB / 99 files) — ready to zip.

---

## 7. Plan doc updates (`MERGE_PR_PLAN.md` in this repo)

- Backend section → **7 PRs** (added **#6 rate limiting**, **#7 cost controls + outage fallback**).
- Frontend section → **4 PRs** (added **#4 AI chat UI**); fixed stale #1 (part-time leave is
  server-side now) and #3 (leftover `wiki-index.json`).
- Rewrote the **Known gaps** section to reflect what #7 closed vs. what remains.
- Noted files that straddle PRs (`application.properties`, `WebConfig.java`, `AlertService.java`,
  `pom.xml`) and that backend `README.md` + `.github/workflows/backend-ci.yml` aren't in any PR list.

---

## 8. Open TODOs

| # | Item | Priority |
|---|---|---|
| 1 | **Verify `max-tokens` actually binds** in Spring AI 2.0.0-M6 — couldn't boot the full context here (embedder proxy). Inspect a real response length during the laptop deploy. | High-ish |
| 2 | **Verify the DeepSeek cost rates** in `application.properties` (`app.cost.*-per-1m-tokens`) — currently placeholders. | Med |
| 3 | **Land the PRs** — apply changes into the real `ai-labor-rights-guide` / `Angular-frontend` repos and commit per `MERGE_PR_PLAN.md` (7 backend + 4 frontend PRs). Backend isn't a git repo yet. | Med |
| 4 | Frontend **search 429** still unhandled (cheap path, 50/min; reviewer judged acceptable). | Low |
| 5 | Backend CORS `exposedHeaders("Retry-After")` if you want the header *fallback* to work cross-origin in dev (body field already covers it). | Low |

### Lower-priority refinements (from the audit, not yet done)
- Read-timeout is 90s per call, not the checklist's 30s; no 60s identical-query dedup; no hard 2s
  inter-request gap (token-bucket burst≈5 is the current approximation). The bucket already blunts
  volumetric abuse, so these are refinements.
- Already covered: jailbreak resistance (system prompt §Ασφάλεια); per-IP throttling + shared-CIDR
  multiplier + 429/`Retry-After`; and all of §2 above.

---

## 9. Quick reference — running the kits

```bash
# Prove retry is off (personal laptop; Meilisearch up, JDK 25)
node scripts/verify-no-retry/mock-deepseek.js          # terminal A
# terminal B: boot app with SPRING_AI_DEEPSEEK_BASE_URL=http://localhost:9999, DEEPSEEK_API_KEY=dummy
curl -X POST http://localhost:8080/api/chat -H "Content-Type: application/json" \
  -d '{"messages":[{"role":"user","content":"δοκιμή"}]}'
# expect: mock logs exactly 1 request; response 200 contains "Προσωρινό πρόβλημα"

# Load test (k6)
k6 run load-test/calc-capacity.js                      # raw unthrottled capacity
k6 run load-test/search-capacity.js                    # shows 50/min cap; add -e SPOOF_IP=true (direct app only)
k6 run -e RUN_CHAT=true load-test/chat-capacity.js     # gated; hits real DeepSeek ($)
# true prod concurrency: temporarily APP_RATELIMIT_ENABLED=false, run ramps, find the knee, re-enable
```

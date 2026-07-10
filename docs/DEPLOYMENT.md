# Deployment Guide — AI Labor Rights Guide

End-to-end deployment of the full stack: Spring Boot backend (DeepSeek chat + labor-law calculators +
hybrid search + wiki), Meilisearch, ChromaDB, the Angular frontend, and nginx/TLS.

> **Two RAG modes.** The chatbot's *grounding* (the `search_articles`/`get_article` tools the LLM
> calls) can run on **Meilisearch hybrid** (default) or **ChromaDB**, chosen at deploy time with one
> env var. The user-facing search box (`/api/search`) **always** uses Meilisearch. Both engines are
> provisioned and indexed, so you can flip the mode with no re-index. See §7.

---

## 1. Stack at a glance

| Service | Image / source | Port (prod) | Exposed? | Role |
|---|---|---|---|---|
| `nginx` | nginx:alpine | 80/443 | **public** | TLS termination, reverse proxy, wiki cache, static SPA |
| `frontend` | GHCR release image | 80 (internal) | no | Angular SPA (served by nginx) |
| `backend` | GHCR release image | 8080 (internal) | no | Chat, calculators, search, wiki, ingestion |
| `meilisearch` | getmeili/meilisearch:v1.12 | 7700 (internal) | no | Search box + (default) chat RAG |
| `chromadb` | chromadb/chroma:0.6.3 | 8000 (internal) | no | Alternative chat RAG |
| `certbot` | certbot/certbot | — | no | Let's Encrypt renewal |

```
                 ┌─────────── nginx (443) ───────────┐
   Internet ───▶ │  /            → frontend (SPA)     │
                 │  /api/wiki/   → backend (cached)   │
                 │  /api/        → backend            │
                 └──────────────────┬─────────────────┘
                          internal network
        ┌──────────────┬───────────┴──────────┬───────────────┐
     backend ──────▶ meilisearch           chromadb         frontend
        │  (search box + default RAG)   (alt RAG)
        └─▶ DeepSeek API (outbound HTTPS)
```

Dev (`docker-compose.yml`) exposes 8080/7700/8000/4200 directly and skips nginx/TLS.

---

## 2. Prerequisites

- **Docker Engine + Compose v2.**
- **Dev only:** the **Angular frontend repo checked out as a sibling directory** — the dev compose file
  builds it from `../Angular-frontend`. Production pulls the published GHCR images instead. Layout:
  ```
  projects/
  ├── ai-labor-rights-guide/      ← this repo (run compose from here)
  └── Angular-frontend/
  ```
- A **DeepSeek API key** (https://platform.deepseek.com).
- **Prod only:** access to the GHCR packages. If they are private, authenticate the server first with a
  GitHub token that has `read:packages`: `echo "$CR_PAT" | docker login ghcr.io -u <github-user> --password-stdin`.
- The **ONNX embedding model file** (~90 MB) — fetched once (§4.3). The tokenizer is bundled in a
  dependency jar; only the model needs providing.
- **Prod only:** a domain's A/AAAA record pointing at the server, for Let's Encrypt.
- JDK/Maven are **not** required on the host — the backend image builds itself in a multi-stage
  Docker build. (To build/run outside Docker you need JDK 25 + Maven.)

---

## 3. TL;DR (production)

```bash
# 0. production checkout (the frontend checkout is only needed for dev), then:
cd ai-labor-rights-guide
cp .env.example .env && $EDITOR .env          # §4.2 — fill secrets and release image tags
bash scripts/fetch-embedding-model.sh          # §4.3 — run where there is internet → ./models
bash scripts/init-ssl.sh                        # §4.4 — one-time TLS bootstrap
docker compose -f docker-compose.prod.yml pull
docker compose -f docker-compose.prod.yml up -d
# index the guide into BOTH engines (run curl from the meili container, on the internal network):
docker compose -f docker-compose.prod.yml exec meilisearch \
  curl -s -X POST http://backend:8080/api/admin/ingest
```

Dev equivalent (no TLS, ports exposed):
```bash
cp .env.example .env && $EDITOR .env
bash scripts/fetch-embedding-model.sh
docker compose up -d --build
curl -X POST http://localhost:8080/api/admin/ingest
```

---

## 4. Step by step

### 4.1 Get the code
Clone this repo and `Angular-frontend` as siblings (§2). Run all `docker compose` commands from
`ai-labor-rights-guide/`.

### 4.2 Configure `.env`
`cp .env.example .env` and set:

| Var | How to set |
|---|---|
| `DEEPSEEK_API_KEY` | Your DeepSeek key. Required for chat (calculators/search/wiki work without it). |
| `MEILI_MASTER_KEY` | A strong random secret: `openssl rand -base64 32`. Used by Meili and the backend. |
| `DOMAIN` / `EMAIL` | **Prod only** — your domain + an email for Let's Encrypt. |
| `GHCR_OWNER` | GitHub owner/organization that publishes the images (default: `angeasla`). |
| `BACKEND_IMAGE_TAG` / `FRONTEND_IMAGE_TAG` | **Prod only** — explicit published release tags, e.g. `v1.2.3`. |
| `CORS_ALLOWED_ORIGINS` | Leave empty in prod (same-origin via nginx). Dev: `http://localhost:4200`. |
| `APP_RAG_PROVIDER` | `meili` (default) or `chroma` — see §7. Optional. |

Never commit `.env`.

### 4.3 Provide the embedding model
The chat/search embed text with a local ONNX model (`all-MiniLM-L6-v2`). Two files are needed at
startup:
- **`tokenizer.json`** — already ships inside the `spring-ai-transformers` jar → loaded from the
  classpath, **never downloaded**.
- **`model.onnx`** (~90 MB) — **not** bundled. Provide it locally:
  ```bash
  bash scripts/fetch-embedding-model.sh      # or scripts\fetch-embedding-model.ps1 on Windows
  # → ./models/all-MiniLM-L6-v2/model.onnx
  ```
  Run this **on a machine with internet** (it pulls from githubusercontent). Both compose files mount
  `./models` read-only into the backend, so the file is used with no startup download.

If `./models` is empty, the backend **falls back to downloading** the model at first boot (fine on a
server with open internet; blocked behind an SSL-intercepting corporate proxy — fetch the file first
there). See §8.

### 4.4 (Prod) TLS bootstrap
`bash scripts/init-ssl.sh` provisions the initial Let's Encrypt certificate for `$DOMAIN`. nginx then
serves 443 using `nginx/templates/app.conf.template`; certbot renews every 12 h and nginx reloads
every 6 h.

### 4.5 Bring the stack up
```bash
# prod (pulls the explicit GHCR release tags from .env)
docker compose -f docker-compose.prod.yml pull
docker compose -f docker-compose.prod.yml up -d
# dev
docker compose up -d --build
```
Startup order: meilisearch (health-gated) and chromadb (start-gated) come up before the backend.

### 4.6 Index the guide content
The articles live in `src/main/resources/docs/**`. Ingestion parses them and indexes **one document
per article into both Meilisearch and ChromaDB** (Chroma is best-effort — skipped with a warning if
unreachable). Trigger it once after first boot, and again whenever content changes:
```bash
# prod (internal network — curl from the meili container, which has curl):
docker compose -f docker-compose.prod.yml exec meilisearch \
  curl -s -X POST http://backend:8080/api/admin/ingest
# dev:
curl -X POST http://localhost:8080/api/admin/ingest
```
Response example: `Indexed 94 articles into Meilisearch. Indexed 94 into ChromaDB.`

> **Security note:** `/api/admin/ingest` is currently **unauthenticated** and is reachable through
> nginx (`/api/`). Before going public, restrict it — e.g. an nginx `location = /api/admin/ingest {
> allow <admin-ip>; deny all; }`, or move admin endpoints behind auth. Do not leave it open.

### 4.7 Smoke test
```bash
# search box (always Meili):
curl 'http://localhost:8080/api/search?q=υπερωρία&limit=5'      # dev
# wiki index:
curl http://localhost:8080/api/wiki/index
# chat (needs DEEPSEEK_API_KEY):
curl -X POST http://localhost:8080/api/chat -H 'Content-Type: application/json' \
  -d '{"messages":[{"role":"user","content":"Τι ισχύει για την υπερωρία;"}]}'
```
For the full chat/RAG/tool validation, see **`RAG_TESTING.md`**.

---

## 5. Environment variable reference

All `app.*` / `spring.*` properties are env-overridable via Spring's relaxed binding
(`app.rag.provider` → `APP_RAG_PROVIDER`, `app.ratelimit.chat.per-day` → `APP_RATELIMIT_CHAT_PER_DAY`,
etc.). The vars below are the ones wired in the compose files / `.env.example`.

| Env var | Default | Required | Purpose |
|---|---|---|---|
| `DEEPSEEK_API_KEY` | — | for chat | DeepSeek LLM key. |
| `MEILI_MASTER_KEY` | — | yes | Meili admin key; also the backend's `MEILISEARCH_KEY`. |
| `MEILISEARCH_URL` | `http://localhost:7700` | (compose sets `http://meilisearch:7700`) | Meili endpoint. |
| `MEILISEARCH_KEY` | falls back to `MEILI_MASTER_KEY` | yes | Backend→Meili auth. |
| `APP_RAG_PROVIDER` | `meili` | no | Chat RAG engine: `meili` or `chroma` (§7). |
| `CHROMA_HOST` | `http://localhost` | (compose sets `http://chromadb`) | Chroma host. |
| `CHROMA_PORT` | `8000` | no | Chroma port. |
| `CHROMA_COLLECTION` | `labor_guide_v3` | no | Chroma collection name. |
| `EMBEDDING_MODEL_PATH` | `models/all-MiniLM-L6-v2/model.onnx` | no | Local ONNX model path (§8). |
| `EMBEDDING_TOKENIZER_PATH` | `classpath:/onnx/all-MiniLM-L6-v2/tokenizer.json` | no | Tokenizer (bundled). |
| `CORS_ALLOWED_ORIGINS` | `http://localhost:4200` | no | Comma-separated; empty in prod. |
| `DOMAIN` / `EMAIL` | — | prod | TLS (nginx + certbot). |
| `APP_RATELIMIT_ENABLED` | `true` | no | Set `false` to disable per-IP throttling (e.g. load/RAG tests). |
| `JAVA_OPTS` | `-XX:MaxRAMPercentage=60 -XX:InitialRAMPercentage=40` | no | JVM heap sizing (relative to the container `mem_limit`). |

---

## 6. Configuration knobs (`application.properties`)

Defaults are sensible; override via env where needed.

**Performance / lifecycle**
- `spring.threads.virtual.enabled=true` — virtual threads (Java 25); the concurrency ceiling becomes
  the DeepSeek upstream, not the Tomcat pool.
- `server.shutdown=graceful` + `spring.lifecycle.timeout-per-shutdown-phase=30s` — in-flight chats
  finish on redeploy.

**LLM / cost**
- `spring.ai.deepseek.chat.options.model=deepseek-chat`
- `spring.ai.deepseek.chat.options.max-tokens=1000` — caps completion length (cost ceiling).
- `spring.ai.retry.max-attempts=1` — retry **off** (a retried turn multiplies cost during an outage).
- `spring.http.client.{connect,read}-timeout=5s/90s` — outbound timeout to DeepSeek (per HTTP call).
- `app.chat.max-input-chars=20000`, `app.chat.max-message-chars=1500` — inbound payload guards
  (anti prompt-stuffing).
- `app.cost.{input,output}-per-1m-tokens`, `app.cost.daily-alert-threshold` — cost accounting +
  one-shot daily-spend alert. **Rates are placeholders — verify against current DeepSeek pricing.**

**Search / RAG**
- `meilisearch.index=articles`, `meilisearch.semantic-ratio=0.5` (0=keyword … 1=semantic),
  `meilisearch.embedder=default`.
- `app.rag.provider=meili|chroma` (§7).
- `spring.ai.vectorstore.chroma.*` — Chroma connection + `collection-name` + `initialize-schema=true`.
- `app.embedding.{model,tokenizer}-path` (§8).

**Rate limiting** (per client IP; see `RAG_TESTING.md` §0 to disable during tests)
- chat: `per-minute=15`, `burst=5`, `per-hour=60`, `per-day=300`, `block-duration=1h`
  (exceeding the daily quota → temporary cooldown + alert, never a permanent ban).
- search: `per-minute=50`.
- `shared-cidrs` (CSV CIDRs of VPN/NAT exits) get `shared-multiplier`× the limits.

---

## 7. Selecting the RAG backend at runtime

The chatbot's grounding tools query either Meili (hybrid keyword+vector) or Chroma (vector). The
**search box is always Meili.** Both engines are provisioned and ingested, so switching is just an
env flip + a backend restart — no re-index.

```bash
# switch to ChromaDB grounding
APP_RAG_PROVIDER=chroma docker compose -f docker-compose.prod.yml up -d --force-recreate backend
# back to Meili (default)
APP_RAG_PROVIDER=meili  docker compose -f docker-compose.prod.yml up -d --force-recreate backend
```
(Or set `APP_RAG_PROVIDER` in `.env` and recreate the backend.)

**Confirm which engine is active:** in `chroma` mode, the `chromadb` container logs similarity queries
during a chat; in `meili` mode it does not (it only sees ingestion). `docker compose logs -f chromadb`
while sending a chat message is the simplest external proof. See `RAG_TESTING.md`.

---

## 8. The local embedding model

- **Resolution order** (per file), by `EmbeddingModelLocationPostProcessor`: an explicit
  `spring.ai.embedding.transformer.{onnx.model-uri,tokenizer.uri}` wins; else the configured local
  path (`app.embedding.*`) if the file/classpath resource exists; else Spring AI's remote default
  (download).
- **Tokenizer** → bundled in the `spring-ai-transformers` jar → never downloads.
- **Model** → `./models/all-MiniLM-L6-v2/model.onnx`, mounted read-only into the backend. Fetch with
  `scripts/fetch-embedding-model.*`. `models/` is gitignored (no 90 MB blob in the repo).
- **Memory:** the ONNX runtime uses **off-heap native** memory on top of the JVM heap — that's why the
  backend's heap is capped at `MaxRAMPercentage=60` (leaving headroom under the container `mem_limit`).
- **Offline / behind a proxy:** provide the model file; then nothing reaches the network at startup.

---

## 9. Re-indexing & cache

- **Content changed?** Re-run ingestion (§4.6). It clears and rebuilds both indexes.
- **Wiki edge cache:** nginx caches `/api/wiki/*` for 24 h on disk. A backend restart does **not**
  bust it — after a content redeploy, force-refresh:
  ```bash
  docker compose -f docker-compose.prod.yml exec nginx sh -c 'rm -rf /var/cache/nginx/wiki/* && nginx -s reload'
  ```
- **SPA shell:** `index.html` is served `no-cache` (hashed assets are immutable/1y), so a new frontend
  deploy is picked up without a hard refresh.

---

## 10. Operations

- **Logs:** `docker compose -f docker-compose.prod.yml logs -f backend` (also `meilisearch`,
  `chromadb`, `nginx`). Watch for `CHAT_COST …`, `COST_ALERT …`, `RATE_LIMIT_ALERT …`.
- **TLS renewal:** automatic (certbot 12 h / nginx reload 6 h).
- **Backups:** the `meili_data` and `chroma_data` named volumes (re-ingestion can rebuild both from
  `docs/**`, so they're regenerable, not precious).
- **Memory budget (8 GB box):** Meili 2 GB, Chroma 1 GB, backend 2.5 GB (heap ~1.5 GB + ONNX native),
  nginx/frontend/certbot ~0.45 GB → ~1.2 GB headroom. Post-trial, dropping the unused RAG engine
  reclaims ~1 GB.

---

## 11. Dev vs prod

| | Dev (`docker-compose.yml`) | Prod (`docker-compose.prod.yml`) |
|---|---|---|
| TLS / nginx | none | nginx + Let's Encrypt |
| Exposed ports | 8080, 7700, 8000, 4200 | 80/443 only |
| Network | default bridge | `internal` (only nginx public) |
| CORS | `http://localhost:4200` | empty (same-origin) |
| Memory limits | none | per-service `mem_limit` |

**Bare-metal dev** (no Docker): use the `local` Spring profile —
`java -jar target/*.jar --spring.profiles.active=local` — which lazy-inits beans so the app boots even
if the embedder model / Chroma aren't present yet.

---

## 12. Troubleshooting

| Symptom | Cause / fix |
|---|---|
| Startup fails `PKIX path building failed` / model download error | Embedder model download blocked (corporate SSL proxy). Provide `./models/.../model.onnx` (§4.3). |
| App won't boot without Chroma (non-lazy) | Adding the Chroma starter means a normal boot expects Chroma reachable (`initialize-schema=true`). Deployments run Chroma; for bare-metal use the `local` profile. |
| Meili `invalid api key` / 403 | `MEILI_MASTER_KEY` (meili) and `MEILISEARCH_KEY` (backend) must match. |
| Chat returns a “Προσωρινό πρόβλημα …” bubble | DeepSeek key missing/invalid or upstream outage — the chat-scoped handler degrades gracefully (HTTP 200). Check `DEEPSEEK_API_KEY` + logs. |
| HTTP 429 from chat/search | Rate limits (15/min chat, 50/min search). For testing set `APP_RATELIMIT_ENABLED=false`. |
| `chromadb` healthcheck unhealthy | The heartbeat path is `/api/v2/heartbeat` for Chroma 0.5+/0.6; the backend only waits for `service_started`, so this is informational — adjust the path if you pin another image. |
| Search box empty in chroma mode | It shouldn't be — the box is always Meili. Check Meili is up and ingested. |
| Stale wiki content after deploy | nginx wiki cache — purge it (§9). |

For chat/tool/RAG correctness validation, see **`RAG_TESTING.md`**.

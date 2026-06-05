# DevOps Guide — AI Labor Rights Guide (Backend)

---

## Branching Strategy — GitHub Flow

This project follows [GitHub Flow](https://docs.github.com/en/get-started/using-github/github-flow), a lightweight branching model suited for continuous delivery.

### Rules

- `main` is **always production-ready**. Never push broken code directly to main.
- All work happens on **short-lived feature branches** cut from main.
- A **Pull Request** is the only way to merge into main.
- Once merged, the CI pipeline automatically versions, releases, and builds the Docker image.

### Branch naming conventions

```
feature/add-rate-limiting
fix/handle-empty-messages
refactor/simplify-chat-service
docs/update-swagger
chore/upgrade-dependencies
```

### Typical workflow

```
1. Pull latest main
   git checkout main && git pull

2. Create a feature branch
   git checkout -b feature/my-feature

3. Make changes, commit using conventional commits (see below)
   git commit -m "feat: add rate limiting to chat endpoint"

4. Push and open a Pull Request to main
   git push -u origin feature/my-feature

5. PR is reviewed and merged → CI pipeline triggers automatically
```

---

## Commit Message Convention

This project uses [Conventional Commits](https://www.conventionalcommits.org/) to drive automatic semantic versioning.

| Prefix | Version bump | Example |
|--------|-------------|---------|
| `feat:` | Minor (1.0.0 → 1.1.0) | `feat: add swagger UI` |
| `feature:` | Minor | `feature: support multi-language` |
| `fix:` | Patch (1.0.0 → 1.0.1) | `fix: handle null message list` |
| `bugfix:` | Patch | `bugfix: correct overtime calculation` |
| `perf:` | Patch | `perf: cache ChromaDB results` |
| `refactor:` | Patch | `refactor: simplify ingestion logic` |
| `major:` | Major (1.0.0 → 2.0.0) | `major: redesign chat API` |
| `breaking:` | Major | `breaking: remove v1 endpoints` |
| `docs:` | No release | `docs: update README` |
| `chore:` | No release | `chore: upgrade dependencies` |
| `test:` | No release | `test: add unit tests for chat service` |

> Commits with no release impact (`docs`, `chore`, `test`) are still good practice — they just won't trigger a new version.

---

## CI Pipeline

The pipeline is defined in `.github/workflows/backend-ci.yml` and runs on GitHub-hosted runners (free, no setup required).

### Triggers

| Event | What runs |
|-------|-----------|
| Push to `main` (backend files changed) | Full pipeline: version → release → Docker build & push |
| Pull Request to `main` | *(gap — build check job to be added)* |
| Manual (`workflow_dispatch`) | Full pipeline from any branch |

### Pipeline jobs

```
release job
  ├── Calculate next version (ietf-tools/semver-action)
  │     Reads conventional commits since last tag
  │     feat → minor, fix/perf/refactor → patch, major/breaking → major
  ├── Skip if no version bump (docs/chore commits)
  ├── Create Git tag  (e.g. v1.2.3)
  └── Create GitHub Release (auto-generated release notes)

docker-build job  (only runs if release job created a new version)
  ├── Login to GitHub Container Registry (ghcr.io)
  ├── Build Docker image
  └── Push with 3 tags:
        ghcr.io/<owner>/<repo>:latest
        ghcr.io/<owner>/<repo>:v1.2.3
        ghcr.io/<owner>/<repo>:abc1234  (git SHA)
```

### First-time setup

Before the pipeline can calculate versions, an initial tag must exist in the repo:

```bash
git tag v0.0.0
git push origin v0.0.0
```

### Where are the images stored?

Images are pushed to **GitHub Container Registry (ghcr.io)** — free for public repos, no extra account needed. Auth is handled automatically via `GITHUB_TOKEN`.

Pull an image:
```bash
docker pull ghcr.io/<your-github-username>/ai-labor-rights-guide:latest
docker pull ghcr.io/<your-github-username>/ai-labor-rights-guide:v1.2.3
```

---

## Local Development Environment

### Prerequisites

- Docker Desktop
- A DeepSeek API key — get one at [platform.deepseek.com](https://platform.deepseek.com)

### Setup

```bash
# 1. Clone the repo
git clone https://github.com/<your-org>/ai-labor-rights-guide.git
cd ai-labor-rights-guide

# 2. Create your local secrets file (never commit this)
cp .env.example .env
# Edit .env and fill in your keys:
#   DEEPSEEK_API_KEY=sk-...
#   ADMIN_SECRET=choose-a-local-secret

# 3. Start all services
docker compose up --build -d

# 4. Seed ChromaDB — only needed on first run or after volume deletion
curl -X POST http://localhost:8080/api/admin/ingest \
  -H "X-Admin-Secret: <your-local-admin-secret>"

# 5. Open the app
open http://localhost:4200
```

### Local service ports

| Service | URL |
|---------|-----|
| Angular frontend | http://localhost:4200 |
| Spring Boot backend | http://localhost:8080 |
| Swagger UI | http://localhost:8080/swagger-ui/index.html |
| ChromaDB | http://localhost:8000 |

### Stopping and cleaning up

```bash
# Stop containers (data preserved in volume)
docker compose down

# Stop and delete all data including ChromaDB volume
docker compose down -v
```

> After `docker compose down -v` you will need to re-run the ingest curl on next startup.

---

## Production Environment

### Key differences from local

| | Local | Production |
|---|---|---|
| Secrets | `.env` file | Environment variables injected by host / secret manager |
| Image source | Built locally | Pulled from `ghcr.io` |
| Ingest trigger | Manual curl | CI/CD pipeline step after deployment |
| Swagger UI | Enabled | Consider disabling (`springdoc.api-docs.enabled=false`) |

### Deploying a new version

Production always runs a versioned image, never `latest`:

```bash
# On your production server or in your deploy script:
docker pull ghcr.io/<owner>/ai-labor-rights-guide:v1.2.3

# Update your production docker-compose to use the versioned tag
# then restart
docker compose up -d
```

### Re-ingesting documents in production

Only needed when the markdown docs in `src/main/resources/docs/` change.
In CI/CD, add a conditional step after deployment:

```yaml
- name: Re-ingest documents (only if docs changed)
  if: contains(steps.changed-files.outputs.all, 'src/main/resources/docs/')
  run: |
    curl -X POST https://your-domain.com/api/admin/ingest \
      -H "X-Admin-Secret: ${{ secrets.ADMIN_SECRET }}"
```

### Environment variables required in production

| Variable | Description |
|----------|-------------|
| `DEEPSEEK_API_KEY` | DeepSeek API key |
| `ADMIN_SECRET` | Secret header value for `/api/admin/ingest` |

---

## Security Notes

- `.env` is gitignored — never commit it
- The Docker image contains **no secrets** — all credentials are injected at runtime
- `/api/admin/ingest` is protected by the `X-Admin-Secret` header
- Consider disabling Swagger UI in production by adding to `application.properties`:
  ```properties
  springdoc.api-docs.enabled=false
  springdoc.swagger-ui.enabled=false
  ```

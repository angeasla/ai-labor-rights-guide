# Verify: no DeepSeek retry + graceful chat fallback

A self-contained kit to **prove on your own laptop** that:

- **(a) no retry** — when DeepSeek fails, the app calls upstream **exactly once** (`spring.ai.retry.max-attempts=1`), and
- **(b) graceful fallback** — `POST /api/chat` returns **HTTP 200** with the Greek outage bubble (`"Προσωρινό πρόβλημα …"`, link `[τον οδηγό](/wiki)`) instead of a raw 500.

It works by pointing the app's DeepSeek base-URL at a tiny local mock (`mock-deepseek.js`) that **always returns HTTP 500** and **counts every request**. The request count is the proof.

Nothing here touches the app code or `target/`. You only run a Node process + the already-built app.

---

## What was verified in the code (so you can trust the commands below)

| Thing | Value | How it was confirmed |
|---|---|---|
| Chat endpoint | `POST /api/chat`, body `{"messages":[{"role":"user","content":"…"}]}`, response `{"role":"ai","content":"…"}` | `controller/ChatController.java`, `dto/ChatRequestDto.java`, `dto/ChatMessageDto.java` |
| Retry knob | `spring.ai.retry.max-attempts` (default ~10; repo sets `1`) | Decompiled `SpringAiRetryProperties` → `CONFIG_PREFIX = "spring.ai.retry"`, field `maxAttempts`. Set at `application.properties` line 31. |
| **DeepSeek base-URL property** | **`spring.ai.deepseek.base-url`** (env: `SPRING_AI_DEEPSEEK_BASE_URL`) | Decompiled `DeepSeekConnectionProperties` → `CONFIG_PREFIX = "spring.ai.deepseek"`, `DEFAULT_BASE_URL = "https://api.deepseek.com"`; base-url field lives on its superclass `DeepSeekParentProperties` (`getBaseUrl`/`setBaseUrl`). See "Base-URL details" below. |
| Fallback bubble | HTTP 200, content has `Προσωρινό πρόβλημα` + `[τον οδηγό](/wiki)` | `controller/ChatExceptionHandler.java` (`@RestControllerAdvice(assignableTypes = ChatController.class)`) |
| Retry log line | `Retry error. Retry count:{}` at **WARN** | Decompiled `SpringAiRetryAutoConfiguration$1` (the `RetryListener`) — logger `org.springframework.ai.retry.autoconfigure.SpringAiRetryAutoConfiguration` |

### Base-URL details (read this if a command 404s or hits the real API)

- The DeepSeek client builds the request URL as **`<base-url>` + `<completions-path>`**, where the default completions path is **`/chat/completions`** (`DeepSeekChatProperties.DEFAULT_COMPLETIONS_PATH`). So setting base-url to `http://localhost:9999` makes the app POST to `http://localhost:9999/chat/completions`.
- The mock accepts **any** path, so you don't have to match the path exactly.
- Precedence (from the decompiled `DeepSeekChatAutoConfiguration.deepSeekApi(...)`): a chat-scoped `spring.ai.deepseek.chat.base-url` is used **if set**, otherwise the connection-scoped `spring.ai.deepseek.base-url`. **Use `spring.ai.deepseek.base-url`** — it's the standard one and the repo doesn't set the chat-scoped variant.
- Set base-url to the bare origin `http://localhost:9999` (no `/v1`, no trailing path) — same shape as the real default `https://api.deepseek.com`.

---

## Prerequisites (the app context must boot)

1. **JDK 25.** `java -jar` and `mvnw` must run on a JDK 25.
   - On this machine: `C:\development\tools\jdk-25.0.3+9`. Set `JAVA_HOME` to it (commands below do this).
2. **Meilisearch reachable.** The app context wires a Meilisearch client at startup. From the repo root:
   ```
   docker compose up -d meilisearch
   ```
   (You do **not** need to ingest documents — chat fails at the DeepSeek call, which is the point.)
3. **Transformers embedder.** The `spring-ai-starter-model-transformers` bean downloads its ONNX tokenizer/model from `raw.githubusercontent.com` on first creation. On a personal laptop with no SSL-intercepting corporate proxy this **just works** (auto-download). Behind a corporate proxy it fails — do this test off-VPN, or use the `local` profile below.
4. **`DEEPSEEK_API_KEY` = any non-empty dummy.** A **blank** key trips the autoconfig assertion *"DeepSeek API key must be set"* when the chat bean is created. The value is never validated against DeepSeek (we never reach the real API), so `dummy-key` is fine.
5. **`local` profile (optional, recommended).** `src/main/resources/application-local.properties` sets `spring.main.lazy-initialization=true`. Add `--spring.profiles.active=local` to boot lazily — the app starts even if the embedder/Meili aren't perfect, and the DeepSeek chat bean is built **on the first `/api/chat` call** rather than at startup. Either way the dummy key is still required for that first call.
6. **A built jar** at `target/ai-labor-rights-guide-0.0.1-SNAPSHOT.jar`, **or** use the `mvnw spring-boot:run` variant. Build it once (in a separate checkout/terminal if another process shares `target/`): `./mvnw -DskipTests package`.

> The mock listens on **9999**, the app on **8080**, Meilisearch on **7700** — no clashes.

---

## Procedure

Run the three steps in **three terminals** (mock keeps running; app keeps running; you fire the request from the third). Start each from the **repo root** `…\projects\ai-labor-rights-guide`.

### Step 1 — start the mock upstream (Terminal A)

PowerShell **and** bash (identical):
```
node scripts/verify-no-retry/mock-deepseek.js
```
Expected first lines:
```
mock-deepseek listening on http://localhost:9999  (every request -> HTTP 500)
Set the app DeepSeek base-url to the URL above, then send ONE /api/chat request.
```
Leave it running.

### Step 2 — start the app, pointing DeepSeek at the mock (Terminal B)

Pick **one** of A/B (jar) and use the matching shell, or C (Maven).

#### 2A — PowerShell, run the built jar
```powershell
$env:JAVA_HOME = "C:\development\tools\jdk-25.0.3+9"
$env:DEEPSEEK_API_KEY = "dummy-key"
$env:SPRING_AI_DEEPSEEK_BASE_URL = "http://localhost:9999"
& "$env:JAVA_HOME\bin\java.exe" -jar target\ai-labor-rights-guide-0.0.1-SNAPSHOT.jar --spring.profiles.active=local
```

#### 2B — bash (Git Bash / WSL / macOS / Linux), run the built jar
```bash
export JAVA_HOME="/c/development/tools/jdk-25.0.3+9"     # adjust on macOS/Linux
export DEEPSEEK_API_KEY="dummy-key"
export SPRING_AI_DEEPSEEK_BASE_URL="http://localhost:9999"
"$JAVA_HOME/bin/java" -jar target/ai-labor-rights-guide-0.0.1-SNAPSHOT.jar --spring.profiles.active=local
```

#### 2C — Maven (no jar needed) — PowerShell
```powershell
$env:JAVA_HOME = "C:\development\tools\jdk-25.0.3+9"
$env:DEEPSEEK_API_KEY = "dummy-key"
.\mvnw.cmd spring-boot:run "-Dspring-boot.run.profiles=local" "-Dspring-boot.run.arguments=--spring.ai.deepseek.base-url=http://localhost:9999"
```
> The base-URL is passed as a Spring arg here (equivalent to the `SPRING_AI_DEEPSEEK_BASE_URL` env var). Note: `mvnw spring-boot:run` may want to recompile into `target/` — if another process is using `target/`, prefer 2A/2B with a pre-built jar.

Wait until the log shows `Tomcat started on port 8080` / `Started AiLaborRightsGuideApplication`.

### Step 3 — fire exactly ONE chat request (Terminal C)

PowerShell. The response is JSON sent as `application/json` **without** a `charset`, so Windows
PowerShell 5.1 (this machine) decodes the Greek body as ISO-8859-1 and shows mojibake — and a
naive `$r.content -like '*Προσωρινό*'` then returns `False` even on success. Use `Invoke-WebRequest`
and decode the raw bytes as UTF-8 yourself:
```powershell
$resp = Invoke-WebRequest -Method Post -Uri http://localhost:8080/api/chat `
  -ContentType "application/json; charset=utf-8" `
  -Body ([System.Text.Encoding]::UTF8.GetBytes('{"messages":[{"role":"user","content":"δοκιμή"}]}'))
$resp.StatusCode                                                  # -> 200
[System.Text.Encoding]::UTF8.GetString($resp.RawContentStream.ToArray())   # correct Greek body
```
(`Invoke-RestMethod` works too and won't error on a 200, but on PS 5.1 its `.content` Greek text is
garbled by the same decoding bug — don't trust a string match against it. PowerShell 7+ is immune.)

bash / `curl`:
```bash
curl -s -X POST http://localhost:8080/api/chat \
  -H "Content-Type: application/json" \
  -d '{"messages":[{"role":"user","content":"δοκιμή"}]}'
```

---

## Expected result (the proof)

**Terminal A (mock)** logs **exactly one** line, then nothing more:
```
#1 POST /chat/completions
```
Stop the mock with **Ctrl-C** to confirm:
```
TOTAL REQUESTS RECEIVED: 1
```
`1` ⇒ **no retry**. (Default Spring AI would have produced ~10.)

**Terminal C (response)** is HTTP **200** with the Greek fallback, e.g.:
```json
{"role":"ai","content":"⚠️ Προσωρινό πρόβλημα με τον βοηθό — δοκίμασε ξανά σε λίγο. Στο μεταξύ, μπορείς να ψάξεις από τη μπάρα αναζήτησης στην κορυφή της σελίδας ή να δεις [τον οδηγό](/wiki)."}
```
Content contains **`Προσωρινό πρόβλημα`** and the link **`[τον οδηγό](/wiki)`** ⇒ **graceful fallback**, not a raw 500.

> Quick PowerShell assertions (optional). Decode the body as UTF-8 first (see the note above) so the
> Greek string match is reliable on Windows PowerShell 5.1:
> ```powershell
> $resp = Invoke-WebRequest -Method Post -Uri http://localhost:8080/api/chat -ContentType "application/json; charset=utf-8" -Body ([System.Text.Encoding]::UTF8.GetBytes('{"messages":[{"role":"user","content":"δοκιμή"}]}'))
> $body = [System.Text.Encoding]::UTF8.GetString($resp.RawContentStream.ToArray())
> $resp.StatusCode                          # -> 200
> ($body -like '*Προσωρινό πρόβλημα*')      # -> True
> ($body -like '*[τον οδηγό](/wiki)*')      # -> True
> ```

**Terminal B (app)** logs one WARN from the fallback handler (proves the advice fired):
```
… WARN … c.a.a.controller.ChatExceptionHandler : DeepSeek chat call failed; returning graceful fallback to /api/chat
```

---

## Negative control (prove the test can detect retries)

Re-run **Step 2 with retry turned back on** (`max-attempts=5`), so you can see the mock count climb. Stop the app from Step 2, restart it with the override added:

PowerShell (jar):
```powershell
$env:JAVA_HOME = "C:\development\tools\jdk-25.0.3+9"
$env:DEEPSEEK_API_KEY = "dummy-key"
$env:SPRING_AI_DEEPSEEK_BASE_URL = "http://localhost:9999"
& "$env:JAVA_HOME\bin\java.exe" -jar target\ai-labor-rights-guide-0.0.1-SNAPSHOT.jar --spring.profiles.active=local --spring.ai.retry.max-attempts=5
```

bash (jar):
```bash
export JAVA_HOME="/c/development/tools/jdk-25.0.3+9"
export DEEPSEEK_API_KEY="dummy-key"
export SPRING_AI_DEEPSEEK_BASE_URL="http://localhost:9999"
"$JAVA_HOME/bin/java" -jar target/ai-labor-rights-guide-0.0.1-SNAPSHOT.jar --spring.profiles.active=local --spring.ai.retry.max-attempts=5
```

Maven (PowerShell):
```powershell
.\mvnw.cmd spring-boot:run "-Dspring-boot.run.profiles=local" "-Dspring-boot.run.arguments=--spring.ai.deepseek.base-url=http://localhost:9999 --spring.ai.retry.max-attempts=5"
```

Fire the **same single** request from Step 3. Now the mock logs ~**5** lines for the one turn:
```
#1 POST /chat/completions
#2 POST /chat/completions
#3 POST /chat/completions
#4 POST /chat/completions
#5 POST /chat/completions
```
`TOTAL REQUESTS RECEIVED: 5` on Ctrl-C. Seeing 5 here and 1 in the main run is what makes the "1 = no retry" result trustworthy. The response is still the 200 fallback (the handler catches it after retries are exhausted).

> The exact number can be 5 (= `max-attempts`). If the upstream-500 is treated as retryable it retries up to the attempt cap; either way it is clearly **> 1** and tracks the value you set, which is the whole point of the control.

---

## Secondary signal — the retry log line

The Spring AI retry layer logs **once per retry** at **WARN** from logger
`org.springframework.ai.retry.autoconfigure.SpringAiRetryAutoConfiguration`,
with the message `Retry error. Retry count:{}` (verified by decompiling the bundled `RetryListener`).

Because it's **WARN**, it shows in the app log **by default** — you do **not** need to raise the log
level to see (or not see) it. Just watch Terminal B's output:

- **Main run (`max-attempts=1`):** **no** `Retry error. Retry count:` lines — the first failure is not retried.
- **Negative control (`max-attempts=5`):** lines `Retry error. Retry count:1`, `…:2`, `…:3`, `…:4` as it retries up to the cap.

This corroborates the mock's request count from inside the app's own logs. (If you want more retry/AI
detail, you *can* add `--logging.level.org.springframework.ai=DEBUG` — env form
`LOGGING_LEVEL_ORG_SPRINGFRAMEWORK_AI=DEBUG` — but it is not required for the WARN line above.)

---

## Cleanup

- Ctrl-C the app (Terminal B) and the mock (Terminal A).
- `docker compose stop meilisearch` if you don't need it running.
- Nothing persistent was created; no app files were modified.

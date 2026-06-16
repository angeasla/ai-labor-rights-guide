// chat-capacity.js — GATED, low-volume probe of the chat endpoint.
//
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// !!  WARNING — THIS HITS THE REAL DeepSeek API. EVERY 200 COSTS MONEY and consumes provider quota. !!
// !!  Do NOT run it as a throughput/stress test. It is DISABLED unless RUN_CHAT=true is passed.       !!
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//
// Target: POST /api/chat   (ChatController.chat)
//   Request  (ChatRequestDto)  : { "messages": [ { "role": "user", "content": "..." } ] }
//   Response (ChatMessageDto)  : { "role": "ai", "content": "..." }
//
// Rate limit (per client IP, bucket4j): 15/min (burst 5) + 60/hr + 300/day. Over the per-minute/hour
// band => transient 429; exceeding the daily quota => 1h cooldown + alert. A single source therefore
// CANNOT exceed ~15 chat calls/min anyway, so this script is intentionally tiny.
//
// PURPOSE — not raw throughput, but to demonstrate the virtual-threads property:
//   chat requests block for seconds on the DeepSeek round-trip (often 2-3 sequential LLM/tool calls).
//   With spring.threads.virtual.enabled=true each blocked request parks its carrier thread, so the
//   server happily holds many concurrent in-flight chat requests without exhausting a thread pool —
//   and crucially WITHOUT starving the cheap /api/calc + /api/wiki endpoints (no shared-pool
//   head-of-line blocking). Run calc-capacity.js in parallel to see calc latency stay flat while
//   these chat requests are parked.
//
// Run (must opt in):
//   k6 run -e RUN_CHAT=true load-test/chat-capacity.js
//   k6 run -e RUN_CHAT=true -e BASE_URL=http://localhost:8080 -e VUS=3 -e DURATION=30s load-test/chat-capacity.js

import http from 'k6/http';
import { check } from 'k6';
import { Counter } from 'k6/metrics';
import exec from 'k6/execution';

const BASE_URL = __ENV.BASE_URL || 'http://localhost:8080';
const RUN_CHAT = (__ENV.RUN_CHAT || '').toLowerCase() === 'true';
const VUS = parseInt(__ENV.VUS || '3', 10);          // keep tiny — see the per-IP 15/min cap above
const DURATION = __ENV.DURATION || '30s';

// Track outcomes separately: real answers vs throttling vs upstream/server failures.
const ok200 = new Counter('chat_200');     // a real (paid) DeepSeek answer
const throttled429 = new Counter('chat_429'); // hit the per-IP rate limit
const serverErr5xx = new Counter('chat_5xx'); // upstream timeout / DeepSeek error / our 5xx

export const options = {
  scenarios: {
    chat: {
      executor: 'constant-vus',
      vus: VUS,
      duration: DURATION,
    },
  },
  thresholds: {
    // Long blocking calls are EXPECTED here; this just flags pathological hangs beyond nginx's
    // proxy_read_timeout (120s) / Spring's read-timeout (90s per upstream call). Informational.
    'http_req_duration{endpoint:chat}': ['p(95)<120000'],
  },
};

// setup() runs once. If not opted in, abort the whole test immediately with a loud message so no
// money is spent and no DeepSeek quota is burned.
export function setup() {
  if (!RUN_CHAT) {
    console.warn('');
    console.warn('=========================================================================');
    console.warn(' chat-capacity.js is DISABLED. It calls the REAL DeepSeek API ($$).');
    console.warn(' Re-run with  -e RUN_CHAT=true  ONLY if you accept the cost + provider');
    console.warn(' rate limits. The per-IP cap (15/min, 60/hr, 300/day) bounds it anyway.');
    console.warn('=========================================================================');
    console.warn('');
    exec.test.abort('RUN_CHAT not set — refusing to spend money on DeepSeek.');
  }
  console.warn(`chat-capacity: hitting REAL DeepSeek via ${BASE_URL}/api/chat with ${VUS} VUs for ${DURATION}.`);
}

const PARAMS = {
  headers: { 'Content-Type': 'application/json' },
  tags: { endpoint: 'chat' },
  // Give k6 headroom beyond nginx proxy_read_timeout (120s) so a slow-but-valid answer isn't cut
  // off as a k6-side timeout before the server/nginx would have returned it.
  timeout: '150s',
};

// One short, on-topic Greek question. Single-turn keeps token cost (and thus $) minimal.
const PAYLOAD = JSON.stringify({
  messages: [
    { role: 'user', content: 'Πόσες μέρες άδεια δικαιούμαι τον πρώτο χρόνο εργασίας;' },
  ],
});

export default function () {
  const res = http.post(`${BASE_URL}/api/chat`, PAYLOAD, PARAMS);

  if (res.status === 200) ok200.add(1);
  else if (res.status === 429) throttled429.add(1);
  else if (res.status >= 500) serverErr5xx.add(1);

  check(res, {
    'status is 200 / 429 / 5xx (known outcomes)': (r) =>
      r.status === 200 || r.status === 429 || r.status >= 500,
    '200 has non-empty content': (r) => {
      if (r.status !== 200) return true;
      try {
        const c = r.json('content');
        return typeof c === 'string' && c.length > 0;
      } catch (_e) {
        return false;
      }
    },
  });
}

// search-capacity.js — load against the rate-limited search endpoint.
//
// Target: GET /api/search?q=<term>&limit=<n>   (SearchController.search)
//   NOTE: search is a GET with query params, NOT a POST with a JSON body. Confirmed by reading
//   SearchController.java (@GetMapping, @RequestParam String q, @RequestParam int limit=5).
//
// Rate limit: 50 requests / minute / client IP (app.ratelimit.search.per-minute=50), enforced by
// RateLimitInterceptor -> RateLimitingService.checkSearch via a bucket4j token bucket. Over the
// limit returns HTTP 429 with a Retry-After header and a JSON body { error, retryAfterSeconds }.
//
// Two modes (env-selected):
//   DEFAULT (single IP): every VU shares one client identity, so the 50/min cap is hit fast and you
//     SEE the 429s. We count them with custom metrics (rate_limited_429 + rate_limited_rate) to make
//     the cap visible in the summary. This is the realistic "one abuser / one NAT" picture.
//
//   SPOOF_IP=true: each VU sends a unique X-Real-IP header so every VU gets its own token bucket and
//     the per-IP cap effectively disappears — this measures raw search throughput (Meilisearch +
//     local embedding) rather than the limiter.
//     !!! IMPORTANT: X-Real-IP spoofing ONLY works when you hit the Spring app PORT directly
//     (e.g. http://localhost:8080, or staging with the limiter on). In PRODUCTION, nginx sets
//     `proxy_set_header X-Real-IP $remote_addr` (see nginx/templates/app.conf.template), OVERWRITING
//     whatever the client sent — so through prod nginx every request collapses to ONE IP (the nginx
//     peer) and you'll be throttled regardless. To bypass per-IP limits in prod, instead temporarily
//     set APP_RATELIMIT_ENABLED=false for the test window (see README).
//
// Run:
//   k6 run load-test/search-capacity.js                                  # single IP, expect 429s
//   k6 run -e SPOOF_IP=true load-test/search-capacity.js                 # bypass per-IP cap (direct only)
//   k6 run -e BASE_URL=https://your-domain.example load-test/search-capacity.js

import http from 'k6/http';
import { check } from 'k6';
import { Counter, Rate } from 'k6/metrics';

const BASE_URL = __ENV.BASE_URL || 'http://localhost:8080';
const SPOOF_IP = (__ENV.SPOOF_IP || '').toLowerCase() === 'true';

// Custom metrics so 429s are first-class in the end-of-test summary.
const rateLimited429 = new Counter('rate_limited_429'); // absolute count of throttled requests
const rateLimitedRate = new Rate('rate_limited_rate');  // fraction of requests that were throttled

// A few realistic Greek query terms drawn from the content domains (overtime, leave, severance...).
const QUERIES = [
  'υπερωρία',
  'άδεια',
  'αποζημίωση απόλυσης',
  'δώρο Πάσχα',
  'νυχτερινή εργασία',
  'σύνταξη',
  'ασφάλιση',
  'ανεργία',
];

export const options = {
  // Comfortably above 50/min so the cap (default mode) bites; in SPOOF mode this is just throughput.
  stages: [
    { duration: '30s', target: 20 },
    { duration: '60s', target: 60 },
    { duration: '60s', target: 120 },
    { duration: '30s', target: 0 },
  ],
  thresholds: {
    // We expect 429s in default mode, so DON'T gate on http_req_failed here (429 counts as a failure
    // to k6's default check). Instead we observe rate_limited_rate. In SPOOF mode 429s should vanish.
    'http_req_duration{endpoint:search}': ['p(95)<800'],
    // Informational threshold: in SPOOF mode this should hold; in single-IP mode it will (correctly)
    // be violated, which is the whole point of the demo. Comment in/out as you like.
    // 'rate_limited_rate': ['rate<0.01'],
  },
};

export default function () {
  const q = QUERIES[Math.floor(Math.random() * QUERIES.length)];
  const url = `${BASE_URL}/api/search?q=${encodeURIComponent(q)}&limit=5`;

  const headers = {};
  if (SPOOF_IP) {
    // Unique per-VU IP => unique bucket4j bucket. 10.x.x.x is private/non-routable; fine as a label.
    // Works ONLY when hitting the app directly (prod nginx overwrites X-Real-IP — see header comment).
    headers['X-Real-IP'] = `10.${(__VU >> 16) & 0xff}.${(__VU >> 8) & 0xff}.${(__VU & 0xff) || 1}`;
  }

  const res = http.get(url, { headers, tags: { endpoint: 'search' } });

  const throttled = res.status === 429;
  rateLimited429.add(throttled ? 1 : 0);
  rateLimitedRate.add(throttled);

  check(res, {
    'status 200 or 429': (r) => r.status === 200 || r.status === 429,
    '200 returns a JSON array': (r) => {
      if (r.status !== 200) return true; // don't penalise expected 429s
      try {
        return Array.isArray(r.json());
      } catch (_e) {
        return false;
      }
    },
    '429 carries Retry-After': (r) => r.status !== 429 || r.headers['Retry-After'] !== undefined,
  });
}

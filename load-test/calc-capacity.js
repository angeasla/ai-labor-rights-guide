// calc-capacity.js — raw server capacity against an UNTHROTTLED calculator endpoint.
//
// Target: POST /api/calc/gross-to-net  (CalculatorController.grossToNet)
//   - No rate limiting (WebConfig registers the interceptor on /api/chat + /api/search only).
//   - Pure CPU-bound function (WageCalculators.grossToNet), no I/O, no DeepSeek, no Meilisearch.
//   - Therefore this is the cleanest probe of "how many req/s + concurrent requests can the
//     JVM/Tomcat-on-virtual-threads actually serve" before latency degrades.
//
// Request body  (record GrossToNetRequest): { gross, children, months, disability }
// Response body (record GrossToNetResult) :
//   { netMonthly, efkaEmployee, incomeTaxMonthly, effectiveTaxRatePct, employerCost, efkaEmployer }
// We assert `netMonthly` is present and positive to make sure we're measuring real work,
// not a fast error/4xx path.
//
// Run:
//   k6 run load-test/calc-capacity.js
//   k6 run -e BASE_URL=https://your-domain.example load-test/calc-capacity.js

import http from 'k6/http';
import { check } from 'k6';

const BASE_URL = __ENV.BASE_URL || 'http://localhost:8080';

export const options = {
  // Staged ramp: push concurrency up in steps, hold each step so percentiles stabilise,
  // then ramp back down. The VU level at which p95 stays under threshold and errors stay
  // <1% is the "knee" / practical max concurrency for this endpoint (see README).
  stages: [
    { duration: '30s', target: 10 },
    { duration: '30s', target: 50 },
    { duration: '45s', target: 100 },
    { duration: '45s', target: 200 },
    { duration: '60s', target: 400 },
    { duration: '30s', target: 0 },
  ],
  thresholds: {
    // p95 latency budget for a pure in-memory calculation. Tune to your hardware.
    'http_req_duration{endpoint:calc-gross-to-net}': ['p(95)<250'],
    // Almost nothing should fail; >1% failures means we've passed the knee.
    'http_req_failed': ['rate<0.01'],
  },
};

const PARAMS = {
  headers: { 'Content-Type': 'application/json' },
  // Tag every request so the threshold + the summary break out this endpoint specifically.
  tags: { endpoint: 'calc-gross-to-net' },
};

// A valid, representative body. gross > 0 is required (the service throws otherwise);
// months=14 exercises the 14-salary path, children/disability exercise the tax-credit branch.
const PAYLOAD = JSON.stringify({
  gross: 1500,
  children: 2,
  months: 14,
  disability: false,
});

export default function () {
  const res = http.post(`${BASE_URL}/api/calc/gross-to-net`, PAYLOAD, PARAMS);

  check(res, {
    'status is 200': (r) => r.status === 200,
    'has positive netMonthly': (r) => {
      try {
        return r.json('netMonthly') > 0;
      } catch (_e) {
        return false;
      }
    },
  });
}

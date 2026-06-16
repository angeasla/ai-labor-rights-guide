// Mock DeepSeek upstream for the "no-retry + graceful fallback" verification.
//
// Zero dependencies (built-in `http` only). Point the Spring app's DeepSeek base-url at
// this server (e.g. http://localhost:9999); every chat turn the app makes lands here.
//
// Behaviour: counts EVERY inbound request and always answers HTTP 500. Spring AI's DeepSeek
// client appends "/chat/completions" (or "/v1/chat/completions") to the base-url, so we accept
// any path. The request count is the proof: with retry disabled (max-attempts=1) one chat turn
// => exactly 1 request here; with retry on (e.g. max-attempts=5) one turn => ~5 requests.
//
// Run:  node mock-deepseek.js            (listens on 9999)
//       PORT=9001 node mock-deepseek.js  (override the port)
// Stop: Ctrl-C — prints the total it received.

const http = require('http');

const PORT = process.env.PORT || 9999;
let count = 0;

const server = http.createServer((req, res) => {
  count += 1;
  // One line per inbound call so you can watch the retries (or lack of them) live.
  console.log(`#${count} ${req.method} ${req.url}`);

  // Drain the request body (the chat payload) so the keep-alive socket stays clean, then answer 500.
  req.on('data', () => {});
  req.on('end', () => {
    res.writeHead(500, { 'Content-Type': 'application/json' });
    // Shape mimics an OpenAI/DeepSeek-style error body; the app only cares that it's a 5xx.
    res.end(JSON.stringify({ error: { message: 'mock upstream failure', type: 'server_error' } }));
  });
  // If the client aborts mid-request, swallow the error so one flaky socket can't crash the test.
  req.on('error', () => {});
});

server.listen(PORT, () => {
  console.log(`mock-deepseek listening on http://localhost:${PORT}  (every request -> HTTP 500)`);
  console.log('Set the app DeepSeek base-url to the URL above, then send ONE /api/chat request.');
});

// On Ctrl-C, print the tally — this number is the whole point of the test.
process.on('SIGINT', () => {
  console.log(`\nTOTAL REQUESTS RECEIVED: ${count}`);
  process.exit(0);
});

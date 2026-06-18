# Οδηγός Ενσωμάτωσης LLM

Λειτουργικός οδηγός για την ενσωμάτωση του chatbot σε παραγωγή.

---

## Rate limiting ανά IP

Τα LLM calls κοστίζουν χρήμα και χρόνο. Προτεινόμενα όρια:

- **10 req/min** ανά IP (burst 5)
- **50 req/hour** ανά IP
- **200 req/day** ανά IP — μετά 1ωρο block + alert (όχι μόνιμο ban)

Σε υπέρβαση: HTTP 429 με _«Περιμένετε λίγο πριν στείλετε νέο μήνυμα.»_

nginx (αρκεί χωρίς extra dependencies):
```nginx
limit_req_zone $binary_remote_addr zone=llm:10m rate=10r/m;
location /api/chat {
    limit_req zone=llm burst=5 nodelay;
    limit_req_status 429;
    proxy_pass http://backend;
}
```

---

## VPN και shared IPs

**Μην blocklist-άρεις VPN ranges.** Θα κόψεις ακριβώς τους ανθρώπους που στοχεύεις (εργαζόμενοι σε IT/τηλεπικοινωνίες, ευαίσθητες ομάδες). Το per-IP rate limit αρκεί — μια κοινόχρηστη IP αυτοπεριορίζεται.

Καμιά προσπάθεια fingerprinting / VPN-detection.

---

## Έλεγχος κόστους

- **Max input:** 8.000 tokens ανά request — κόβει prompt stuffing.
- **Max output:** 1.000 tokens — οι απαντήσεις είναι σύντομες.
- **Server-side timeout:** 30s ανά LLM call.
- **Cost logging:** κατέγραψε εκτιμώμενο κόστος ανά request. Alert αν ημερήσια δαπάνη > threshold (όρισε με βάση τον budget σου, ξεκίνα από €5–10/μέρα).
- **Provider outage:** αν το LLM endpoint γυρίσει 5xx ή timeout, επέστρεψε στατικό μήνυμα _«Προσωρινό πρόβλημα — δοκίμασε σε λίγο»_ και link στο `/search` της σελίδας ως fallback. Μην κάνεις retry στο ίδιο request (διπλασιάζει κόστος σε rate-limit incidents).

---

## Πρότυπα κατάχρησης

| Πρότυπο | Σύμπτωμα | Αντιμετώπιση |
|---|---|---|
| Bot scraping | Πανομοιότυπα queries | Dedup window 60s ανά IP |
| Prompt stuffing | Μηνύματα >500 tokens | Truncate πριν το LLM |
| Machine-speed | <1s μεταξύ μηνυμάτων | Min gap 2s (client + server) |
| Jailbreak | «Ξέχνα τις οδηγίες…» | Το system prompt το χειρίζεται |

---

## Content moderation

Δεν χρειάζεται ξεχωριστό moderation API. Domain-specific scope + ισχυρό system prompt αρκούν. Αν το LLM αρνείται νόμιμες ερωτήσεις, το πρόβλημα είναι υπερ-περιοριστικό prompt — δες `CHATBOT_SYSTEM_PROMPT.md`.

---

## Ασφάλεια infrastructure

- MCP server: εκτεθειμένο μόνο μέσω nginx + TLS, με auth header. Δεν δέχεται καλέσεις απευθείας από το frontend — μόνο από τον backend που τρέχει το LLM.
- Meilisearch: loopback ή εσωτερικό δίκτυο, ποτέ δημόσιο.
- `MEILI_MASTER_KEY`, LLM API keys, MCP auth token: σε environment variables, εκτός repo.
- Frontend search key: **read-only**, ποτέ master.
- Logs: μην αποθηκεύεις πλήρη user messages μακροπρόθεσμα. Αρκεί IP hash + token count + tool name + timestamp για debugging και cost analysis.

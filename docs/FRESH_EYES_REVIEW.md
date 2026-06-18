# Fresh-eyes review — what could be better / what's missing

_A step-back critique of the worker-rights guide (content + frontend + Spring backend + chatbot), 2026-06-16._
_Grounded in a read of the content tree (~95 articles), `content/index.md`, and `content/symvasi/syndikalismos.md`._

> First instinct was "the anarcho-syndicalist soul is probably missing." It isn't — _"τα δικαιώματά σου δεν
> χαρίστηκαν, κερδήθηκαν με αγώνα"_, the _"οργανώσου τώρα, χρειάζεσαι 9 συναδέλφους"_ close, the _"τι κάνω αν
> παραβιάζονται"_ enforcement sections, collective-over-individual framing throughout. The voice is there.
> Everything below is about everything else.

---

## The one cross-cutting tension

**The values and the architecture point in opposite directions on privacy.** This is a tool that tells
workers to organize against their boss and report employers to the state — yet:

- `src/index.html` pulls **Pico CSS + marked.js from public CDNs**. Every visitor's IP + the exact article
  they're reading leaks to jsdelivr/cdnjs (and anyone who can read or subpoena those logs). For *this*
  audience that's not a nitpick — it's a values bug. **Self-host both**; it also makes the site
  airgappable and trivially forkable.
- The chat path **IP-buckets every request** (the rate-limiting hardening) and ships queries to
  **DeepSeek**, a third-party foreign API. A worker typing _"how do I prove undeclared work against my
  employer"_ is now IP-tracked and sent abroad. Needs an explicit **no-logs / ephemeral / no-analytics /
  Tor-tolerant** stance, stated on the site.

The abuse-hardening and the audience's threat model are in genuine tension. Treat privacy as a design
principle, not a patch.

---

## Worker / product

- **Staleness has no detection process — and it's already biting.** The συνδικαλισμός article tells workers
  to report to **"ΣΕΠΕ, sepe.gov.gr."** ΣΕΠΕ was reorganized into the independent **Επιθεώρηση Εργασίας**
  by the very law it cites (Ν.4808/2021). _Verify_, but that's exactly the drift that kills trust.
  `dates.json` is git-last-modified, **not** legal-verification date.
  → Add a per-article _"ισχύει ως προς νομοθεσία: &lt;date&gt;"_ stamp + a watch-list of pending changes.
  This is the existential risk for a legal tool.
- **Content gaps for precisely the most-exploited:**
  - **Platform / delivery workers** (efood/Wolt) — the hottest organizing front in Greece, no dedicated article.
  - **Αδήλωτη εργασία** — how to prove it, the penalty regime, how to report. (Touched obliquely by
    `ergani` / `karta-ergasias`, not worker-facing "you're in this situation, here's the move.")
  - **Μπλοκάκι / ψευδώς αυτοαπασχολούμενος** — the fake-freelancer trap. Very common, no article.
- **Migrant workers are unreachable.** Agriculture/tourism/delivery in Greece is heavily
  Albanian/Bengali/Urdu-speaking — the people most exposed to wage theft can't read a Greek-only guide.
  Even the 3–4 critical pages (report wage theft, undeclared work) in 2–3 languages would widen reach a lot.
- **Output isn't evidence yet.** Calculators give a number; pair each result with its legal basis + a
  printable _"here's what I'm owed and the law that says so"_ record the worker can hand to the Επιθεώρηση /
  a lawyer / show the boss. That's the step from *information* to *leverage* — a natural extension of the
  existing PDF export.
- **No feedback loop.** A privacy-respecting _"this is wrong / law changed / my case isn't covered"_ channel
  is both the error-catcher and the content roadmap.

---

## Technical

- **JS-required SPA over static markdown.** Content is already markdown but only renders via the hash-routed
  JS app — no-JS / locked-down browser / flaky 3G = blank page. Progressive enhancement (serve HTML, enhance
  with JS) maximizes reach on exactly the cheap phones the audience has.
- **Greek search linguistics.** Confirm Meilisearch folds tonos/final-sigma and stems — a worker types
  "υπερωριες"/"αδεια" without accents and must hit "υπερωρίες"/"άδεια." Easy to get subtly wrong;
  make-or-break for usability.
- **Sustainability vs. the LLM.** Two frontends (static prototype + Angular) + Spring + Meili + Chroma +
  DeepSeek is a large operational/cost surface for a movement project. The chatbot is the most expensive,
  least durable, highest-liability piece — a whole session went into hardening it against abuse, which is
  itself a signal. For a trial, fine. The honest question: does excellent **search + calculators** serve
  workers better, cheaper, and with zero hallucination risk than a chatbot? Don't assume the LLM earns its
  place — measure it.
- **No correctness eval for the chatbot.** There are unit/load/rate-limit tests but no eval set of real
  worker questions → known-good answers, run against the RAG, to catch the LLM regressing into wrong legal
  advice. For a tool advising vulnerable people, that's the test that matters most.

---

## If I had to pick three

1. **Self-host the CDN assets + publish a no-logs privacy stance** — cheap, and it's the values-critical one.
2. **Legal-verification-date stamp + staleness watch-list** — fix the ΣΕΠΕ-class drift before it erodes trust.
3. **Decide the LLM's fate deliberately** — eval it against search+calculators; if it stays, gate it behind a
   privacy posture and a correctness eval.

---

## Things checked that turned out fine (don't re-litigate)

- Anarcho-syndicalist voice and framing — present and strong.
- Content breadth — ~95 articles across all 9 categories; covers harassment (mobbing, sexual, pregnancy),
  collective/unfair dismissal, strikes, works councils, atypical contracts, domestic/construction/hotel workers.
- Home-page disclaimer ("συμβουλεύσου το συνδικάτο σου ή εξειδικευμένο δικηγόρο") — appropriate.

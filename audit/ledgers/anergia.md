# LEDGER — anergia/ unemployment fact-check

**Scope.** 2 files: `anergia/epidoma.md` (Επίδομα Ανεργίας ΔΥΠΑ), `anergia/index.md` (Ανεργία landing).
**Date:** 2026-07-13. **Method:** every checkable claim (days, months, €, %, deadlines, laws/ΥΑ)
cross-checked against `audit/CURRENCY-BRIEF.md` §4 AND a live fetch of a primary/authoritative source
(mitos.gov.gr = Εθνικό Μητρώο Διοικητικών Διαδικασιών; ypergasias.gov.gr = Υπ. Εργασίας;
e-nomothesia.gr; taxheaven.gr, which mirrors ΔΥΠΑ text). `kepea.gr`/`et.gr` return 403 to automated
fetch (per brief) → not used for verbatim. **No corpus file edited.**
**Verdict key:** OK / WRONG / OUTDATED / IMPRECISE / UNVERIFIABLE.

**Primary/authoritative sources used (quoted per row):**
- Τακτική Επιδότηση Ανεργίας (διάρκεια, min 5 / max 12 μήνες) — https://mitos.gov.gr/index.php/%CE%94%CE%94:%CE%A4%CE%B1%CE%BA%CF%84%CE%B9%CE%BA%CE%AE_%CE%95%CF%80%CE%B9%CE%B4%CF%8C%CF%84%CE%B7%CF%83%CE%B7_%CE%91%CE%BD%CE%B5%CF%81%CE%B3%CE%AF%CE%B1%CF%82
- Duration table + 125/200-day eligibility + age-49 rule (verbatim) — https://www.taxheaven.gr/circulars/7927/arora-epidoma-anergias-proypooeseis-posa-diarkeia-epidothshs
- Ποσό + κλιμάκωση + 10%/προστατευόμενο μέλος — https://www.e-nomothesia.gr/nomikes-plirofories/dupa-taktike-epidotese-anergias-khrestikos-odigos-gia-to-epidoma-anergias.html
- 2026 full amount €564,98 (from 1.4.2026) + up-to-€1.375 new benefit — https://www.newmoney.gr/roh/ergasiaka/katotatos-misthos-2026-pia-ine-ta-20-epidomata-pou-afxanonte-i-megali-ofelimeni/
- Νέο (ανταποδοτικό) επίδομα — 175 ημέρες, 70% κατ. ημερομισθίου — https://ypergasias.gov.gr/neo-epidoma-anergias-me-perissotera-kinitra-gia-ergasia-pio-dikaio-pio-antapodotiko/
- Ειδικό εποχικό βοήθημα δικαιούχοι (list incl. τουρισμού/επισιτισμού) — https://mitos.gov.gr/index.php/%CE%94%CE%94:%CE%95%CE%B9%CE%B4%CE%B9%CE%BA%CF%8C_%CE%B5%CF%80%CE%BF%CF%87%CE%B9%CE%BA%CF%8C_%CE%B2%CE%BF%CE%AE%CE%B8%CE%B7%CE%BC%CE%B1_%CE%94%CE%A5%CE%A0%CE%91
- Pilot instrument (ΚΥΑ 54427/2024) — https://www.forin.gr/articles/article/82694/kua-54427-2024 (locate only)

---

## FILE 1 — `anergia/epidoma.md`

**Counts:** WRONG 3 · OUTDATED 1 · IMPRECISE 1 · UNVERIFIABLE 2 · GAP 1 · OK ~6.

### A1.1 — duration table: wrong basis, wrong brackets, wrong months — WRONG (MAJOR) — confidence HIGH
- **Current (lines 31–44):**
  > Η διάρκεια εξαρτάται από τις **ημέρες ασφάλισης στα τελευταία 4 χρόνια** πριν την απόλυση:
  >
  > | Ημέρες ασφάλισης (τελευταίοι 4 χρόνοι) | Διάρκεια επιδότησης |
  > |---|---|
  > | 125–149 | 2 μήνες |
  > | 150–179 | 3 μήνες |
  > | 180–219 | 4 μήνες |
  > | 220–259 | 5 μήνες |
  > | 260–299 | 6 μήνες |
  > | 300–424 | 8 μήνες |
  > | 425–599 | 10 μήνες |
  > | ≥600 | 12 μήνες |
- **Proposed replacement:**
  > Η διάρκεια εξαρτάται από τις **ημέρες ασφάλισης στους τελευταίους 14 μήνες** πριν την απόλυση —
  > **όχι** στα 4 χρόνια:
  >
  > | Ημέρες ασφάλισης (τελευταίοι 14 μήνες) | Διάρκεια επιδότησης |
  > |---|---|
  > | 125–149 | **5 μήνες** |
  > | 150–179 | **6 μήνες** |
  > | 180–219 | **8 μήνες** |
  > | 220–249 | **10 μήνες** |
  > | 250 και άνω | **12 μήνες** |
  >
  > Το **ελάχιστο** επίδομα είναι **5 μήνες** — μη δεχτείς λιγότερο. Ειδικά: αν έχεις **210 ημέρες
  > και έχεις κλείσει το 49ο έτος**, δικαιούσαι **12 μήνες**. (Η τετραετία μετράει μόνο για το
  > ανώτατο όριο των 400 επιδοτούμενων ημερών σε 4 χρόνια — δεν είναι η βάση υπολογισμού της διάρκειας.)
- **Legal basis:** Ν.1545/1985 (as amended); ΔΥΠΑ κανονισμός. Corpus conflated the 14-month qualifying
  window with the separate 4-year/400-day cap; every bracket and month value is wrong (min is 5, not 2).
- **Primary URL:** taxheaven circular 7927; mitos.gov.gr (min 5 / max 12).
- **Verbatim quote:** taxheaven table: «125-149 → 5 μήνες · 150-179 → 6 μήνες · 180-219 → 8 μήνες ·
  220-249 → 10 μήνες · **250 και άνω → 12 μήνες**»; age rule «**210** και συμπλήρωση του **49ου** έτους
  ηλικίας» → 12 μήνες. mitos: «το ελάχιστο χρονικό διάστημα είναι **5 μήνες** και μπορεί να φτάσει τους **12**».

### A1.2 — eligibility excludes "last month" (should be last TWO) + missing 200/2yr alternative — WRONG — confidence HIGH
- **Current (line 15):**
  > 1. **Τουλάχιστον 125 ημέρες ασφάλισης** στους τελευταίους 14 μήνες, χωρίς να μετράει ο τελευταίος μήνας πριν την απόλυση.
- **Proposed replacement:**
  > 1. **Τουλάχιστον 125 ημέρες ασφάλισης** στους τελευταίους 14 μήνες πριν την απόλυση, **χωρίς να
  >    μετρούν οι δύο τελευταίοι μήνες**. **Εναλλακτικά** καλύπτεσαι και με **200 ημέρες ασφάλισης
  >    στα τελευταία 2 χρόνια** (πάλι χωρίς τους 2 τελευταίους μήνες), από τις οποίες **τουλάχιστον
  >    80 ημέρες κάθε χρόνο**.
- **Legal basis:** Ν.1545/1985· ΔΥΠΑ κανονισμός. Corpus says "last month"; law excludes the **last two**;
  the 200-day/2-year route is a genuine alternative the corpus omits entirely.
- **Primary URL:** taxheaven circular 7927; mitos.gov.gr; brief §4.
- **Verbatim quote:** «Το τελευταίο όμως 14μηνο πρέπει να έχει συμπληρώσει **125 ημέρες** εργασίας,
  χωρίς να υπολογίζονται **οι τελευταίοι δύο μήνες**.» + «**200 ημέρες** εργασίας (χωρίς να
  υπολογίζονται οι δύο τελευταίοι μήνες), από τις οποίες **80 ημέρες**, το λιγότερο το χρόνο.»

### A1.3 — amount "55% του μέσου ημερομισθίου" — OUTDATED/WRONG characterization — confidence HIGH
- **Current (lines 21–25):**
  > Το επίδομα υπολογίζεται ως **55% του μέσου ημερομισθίου** της τελευταίας περιόδου ασφάλισης, αλλά:
  > - Δεν μπορεί να πέσει **κάτω από ένα ελάχιστο όριο**…
  > - Δεν μπορεί να ξεπεράσει ένα **ανώτατο όριο** (οροφή).
  > - Για τα τρέχοντα ποσά έλεγξε το dypa.gov.gr…
- **Proposed replacement:**
  > Το επίδομα είναι πλέον **σταθερό ποσό συνδεδεμένο με τον κατώτατο μισθό** — **όχι** ποσοστό του
  > δικού σου μισθού. Από **1.4.2026** το πλήρες μηνιαίο επίδομα είναι **564,98 € (≈565 €)**, δηλαδή
  > **22,60 €/ημέρα** (55% του κατώτατου ημερομισθίου × 25 ημέρες):
  > - **+10% για κάθε προστατευόμενο μέλος** της οικογένειάς σου.
  > - Για πολύ χαμηλές μέσες αποδοχές το ποσό μειώνεται κλιμακωτά (κατά προσέγγιση ~423,75 € και
  >   ~282,50 €).
  > - **Ανεβαίνει αυτόματα** κάθε φορά που αυξάνεται ο κατώτατος μισθός — γι' αυτό έλεγξε το τρέχον
  >   ποσό στο dypa.gov.gr.
- **Legal basis:** amount pegged to κατώτατο ημερομίσθιο (55% × min daily wage × 25), min wage €920/
  €41,09 from 1.4.2026 (ΚΥΑ 8934/2026, brief §2). "55% του **μέσου** ημερομισθίου" describes the
  pre-2012 individualised formula; today it is a flat, min-wage-pegged amount for everyone.
- **Primary URL:** newmoney (€564,98 from 1.4.2026); e-nomothesia (κλιμάκωση + 10%); brief §4.
- **Verbatim quote:** «το τακτικό επίδομα ανεργίας διαμορφώνεται στα **564,98 ευρώ**… ακολουθώντας την
  αύξηση του κατώτατου ημερομισθίου»; e-nomothesia: «Τα παραπάνω ποσά **προσαυξάνονται κατά 10% για
  κάθε προστατευόμενο μέλος** της οικογένειας του δικαιούχου.»
- **Note:** exact lower-tier 2026 figures (€423,75 / €282,50) are from the brief (the 3-tier *structure*
  is web-confirmed; the precise 2026 lower amounts are brief-sourced) → confidence MED on those two
  numbers, HIGH on the €565 full amount + 10%/dependent.

### A1.4 — Ν.5217/2025 new contributory benefit — GAP (add forward note) — confidence MED-HIGH
- **Current:** no mention anywhere.
- **Proposed addition (new subsection):**
  > ## Νέο ανταποδοτικό επίδομα (πιλοτικό — Ν. 5217/2025)
  > Από τον Απρίλιο 2025 τρέχει πιλοτικά ένα **νέο, ανταποδοτικό** επίδομα ανεργίας: σταθερό μέρος
  > στο **70% του κατώτατου ημερομισθίου** + προσαύξηση ανάλογα με τα ένσημά σου, που φτάνει **έως
  > 1.375 €/μήνα** (χρειάζεται **175 ημέρες ασφάλισης** στους 14 μήνες, χωρίς τους 2 τελευταίους). Η
  > πιλοτική φάση **έληξε στις 30.6.2026**· μέχρι να γενικευτεί, ισχύει το κλασικό τακτικό επίδομα
  > που περιγράφεται εδώ. Κανένας δικαιούχος δεν παίρνει συνολικά λιγότερα απ' ό,τι με το παλιό καθεστώς.
- **Legal basis:** Ν.5217/2025 (per brief); pilot set by **ΚΥΑ 54427/2024**. Instrument-number pairing
  Ν.5217/2025 ↔ pilot is brief-sourced → MED; the figures (175 days, 70%, €1.375, pilot→30.6.2026) are
  web-confirmed.
- **Primary URL:** ypergasias.gov.gr; newmoney; forin.gr (ΚΥΑ 54427/2024).
- **Verbatim quote:** «συμπλήρωση **175 ημερών ασφάλισης** κατ' ελάχιστο»; «Εκκινεί από **επιδότηση 70%
  του νομοθετημένου κατώτατου ημερομισθίου**»; «επίδομα ανεργίας **έως 1.375 ευρώ**».

### A1.5 — ΥΑ 42429/2022 as the amount/procedure basis — UNVERIFIABLE — confidence LOW (no edit)
- **Current (line 92):** `ΥΑ 42429/2022 — Ύψος επιδόματος, διαδικασία, όρια`
- **Finding:** could not confirm that ΥΑ 42429/2022 is the instrument fixing benefit amount/procedure.
  The current pilot instrument is **ΚΥΑ 54427/2024**; the classic benefit rests on Ν.1545/1985 +
  ΔΥΠΑ κανονισμός. Brief §4 does **not** list ΥΑ 42429/2022. Not confirmed wrong → **no edit**; flag
  for human check of the exact ΥΑ number.
- **Primary URL:** none confirming; searched mitos/forin/e-nomothesia.

### A1.6 — ιατροφαρμακευτική κάλυψη "αυτόματα για 12 μήνες" — UNVERIFIABLE — confidence LOW (no edit)
- **Current (line 74):** coverage continues «αυτόματα για **12 μήνες**» from last insurance day.
- **Finding:** plausible simplification, but no primary source fetched confirming a flat automatic
  12-month rule for everyone (statutory coverage duration historically scales with insurance days /
  benefit status). Not in brief §4. Left as-is; **no edit**; recommend primary check (e-EFKA/ΕΟΠΥΥ).

### OK (no change) in File 1
- **125 ημέρες / 14 μήνες** core figures (line 15) — OK (only the "last month" exclusion is wrong → A1.2).
- **Εγγραφή/αίτηση εντός 60 ημερών** (lines 17, 48) — OK (brief §4 confirms 60-day deadline).
- **Ένσταση εντός 30 ημερών** (line 84) — OK (brief §4 confirms 30-day appeal).
- **Εξαναγκαστική παραίτηση via ΣΕΠΕ** (line 16) — OK (established route).
- **Right to benefit independent of employer's unpaid contributions** (lines 78–80) — OK.
- **Ν.1545/1985** + **Ν.4921/2022 (ΔΥΠΑ)** (lines 90–91) — OK (brief §4 basis).
- Monthly payment to IBAN (line 27) — OK (now often a ΔΥΠΑ prepaid card too; not wrong).

---

## FILE 2 — `anergia/index.md`

**Counts:** WRONG 0 · IMPRECISE 1 · UNVERIFIABLE 1 · GAP(optional) 1 · OK ~8. (Landing page; defers
detail to `epidoma.md`, so it carries few hard numbers.)

### A2.1 — legislation footer cites Ν.4808/2021 for unemployment — IMPRECISE — confidence MED
- **Current (line 67):** `Ν. 4808/2021 — Τροποποιήσεις εργατικού δικαίου`
- **Finding:** Ν.4808/2021 is not a governing instrument for the unemployment benefit; on this page it
  is a weak/irrelevant citation. Not false (the law exists), but out of place.
- **Proposed:** drop it, or replace with the operative basis — **Ν.1545/1985** (πλαίσιο) + **Ν.4921/2022**
  (ΔΥΠΑ, ψηφιακό ατομικό σχέδιο δράσης). Low priority.
- **Legal basis:** brief §4 (basis = Ν.1545/1985, Ν.4921/2022).

### A2.2 — ιατροφαρμακευτική κάλυψη "12 μήνες" (lines 24, 44, 53) — UNVERIFIABLE — confidence LOW (no edit)
- Same as A1.6 — repeated three times here. No primary confirmation of a flat automatic 12-month rule;
  not asserted wrong; **no edit**; human check recommended.

### A2.3 — Ν.5217/2025 new benefit not mentioned on landing page — GAP (optional) — confidence MED
- The landing page lists ΔΥΠΑ benefits but omits the new (pilot) contributory benefit. Optional: add a
  one-line pointer mirroring A1.4. Lower priority than the `epidoma.md` note.

### OK (no change) in File 2
- **ΔΥΠΑ succeeded ΟΑΕΔ in 2022 (Ν.4921/2022)** (line 13) — OK.
- **Ειδικό εποχιακό επίδομα → ξενοδοχεία/τουρισμός** (lines 20, 51) — **OK** (verified: the ειδικό
  εποχικό βοήθημα list explicitly includes «**εργαζόμενοι τουρισμού και επισιτισμού**»). Minor: it
  covers many other trades too (οικοδόμοι, δασεργάτες, ηθοποιοί, μουσικοί…), but the example is valid.
- **Επίδομα μακροχρονίως ανέργων → 12+ μήνες, εισοδηματικά κριτήρια** (lines 21, 52) — OK (broadly
  correct; income-tested long-term-unemployment benefit).
- **125 ημέρες** minimum reference (lines 32, 50) — OK (detail deferred to `epidoma.md`).
- **60-day registration deadline** (lines 36, 38) — OK.
- **Ν.1545/1985**, **Ν.4921/2022** (lines 66, 68) — OK.
- ΔΥΠΑ 1599 / ΣΕΠΕ 1555 contact numbers (lines 59–60) — OK (not independently re-verified; standard).

---

## UNVERIFIABLE / HUMAN-REVIEW

1. **ΥΑ 42429/2022** (`epidoma.md` line 92) — cannot confirm this ΥΑ fixes benefit amount/procedure;
   brief §4 doesn't cite it; pilot instrument is ΚΥΑ 54427/2024. **No edit**; verify the exact ΥΑ number
   before keeping the citation. Confidence the current cite is safe: LOW.
2. **Ιατροφαρμακευτική κάλυψη "αυτόματα 12 μήνες"** (`epidoma.md` line 74; `index.md` lines 24/44/53) —
   no primary source confirming a flat, universal, automatic 12-month rule; statutory coverage may scale
   with insurance days/benefit status. **No edit**; verify against e-EFKA/ΕΟΠΥΥ + Ν.4611/2019.
3. **Lower amount tiers €423,75 / €282,50** (proposed in A1.3) — the 3-tier *structure* and the +10%/
   dependent rule are web-confirmed; the exact 2026 lower-tier euro figures are **brief-sourced** (older
   published tables show pre-2026 values). Confirm the 2026 reduced amounts on dypa.gov.gr before publishing.
4. **Ν.5217/2025 instrument number** (A1.4) — the pilot's figures are web-confirmed via ypergasias.gov.gr;
   the pilot decision found is **ΚΥΑ 54427/2024**. Pairing the pilot with "Ν.5217/2025" is brief-sourced —
   confirm the statute number if it will be cited verbatim.

## COVERAGE GAPS (content the cluster should add)

- **200-days/2-year eligibility alternative** — absent from both files (added via A1.2).
- **Correct 14-month duration basis + min-5-months floor + age-49/210-days rule** — the whole duration
  table is wrong (A1.1); this is the batch's single most important fix.
- **Min-wage-pegged flat amount (~€565) + 10%/dependent + reduced tiers** — corpus gives no number and a
  stale "55% of your average wage" formula (A1.3).
- **Ν.5217/2025 new contributory benefit (up to €1.375, 175 days, pilot→30.6.2026)** — forward note
  missing (A1.4; optionally A2.3).
- **ΔΥΠΑ prepaid benefit card** — payment channel modernised; corpus mentions only IBAN (minor).

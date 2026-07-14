# Legal-Accuracy Ledger — Batch `orario-days`

**Auditor role:** Greek labour lawyer (εργατολόγος) fact-check · **Date:** 2026-07-13
**Baseline:** `audit/CURRENCY-BRIEF.md` §1 (Working time), §9 (citation bugs)
**Files:** `orario/vardiakia.md`, `orario/ekti-imera.md`, `orario/argies.md`, `orario/index.md`
**Rule applied:** no edits to corpus files; unconfirmable → UNVERIFIABLE; no invented facts.

**Primary/authoritative sources consulted (fresh fetch, 2026-07-13):**
- Επιθεώρηση Εργασίας (hli.gov.gr) — Αμοιβή για Απασχόληση κατά Κυριακή ή Ημέρα Αργίας: https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/amoivi/kyriaki-argies-amoivi/amoivi-gia-apascholisi-kata-kyriaki-i-imera-argias-2/
- e-nomothesia / ΕΛΙΝΥΑΕ — Ν.435/1976 (ΦΕΚ Α΄251/20.09.1976): https://www.e-nomothesia.gr/kat-ergasia-koinonike-asphalise/n-435-1976.html · https://www.elinyae.gr/ethniki-nomothesia/n-4351976-fek-251a-2091976
- taxheaven — Ν.5053/2023 (6η ημέρα): https://www.taxheaven.gr/news/64928/
- ot.gr — εξαήμερη 5053/2023: https://www.ot.gr/2024/07/09/apopseis/experts/eksaimeri-apasxolisi-me-ton-nomo-5053-2023-poious-afora/
- advisor.samoscci.gr — πλαίσιο αργιών (υποχρεωτικές/κατ'έθιμον, με νομικές παραπομπές): https://advisor.samoscci.gr/knowledgebase/το-πλαίσιο-των-όρων-αμοιβής-και-εργασί/
- e-forologia — Εργασία τις Κυριακές και τις ημέρες αργίας: https://www.e-forologia.gr/cms/viewContents.aspx?id=235855
- odigostoupoliti — Καθαρά Δευτέρα 2026 (καθεστώς ιδιωτικού τομέα): https://www.odigostoupoliti.eu/kathara-deftera-2026-ti-ischyei-gia-ergazomenous-kai-katastimata/
- e-nomothesia — Ν.3385/2005 (ΦΕΚ Α΄210/19.08.2005): https://www.e-nomothesia.gr/kat-ergasia-koinonike-asphalise/n-3385-2005.html
- Υπ. Ανάπτυξης / nomoskopio — Ν.4177/2013 art.16 (λειτουργία καταστημάτων Κυριακές), όπως τροπ. Ν.5157/2024
- (kepea.gr HTTP 403 to fetch — used hli/e-forologia/samoscci mirrors per brief guidance)

---

## VERDICT TALLY

| File | OK | WRONG | OUTDATED | IMPRECISE | UNVERIFIABLE |
|---|---|---|---|---|---|
| vardiakia.md | 6 | 0 | 1 (gap: Ν.5239/2025) | 2 | 1 |
| ekti-imera.md | 1 | 3 | — | 1 | — |
| argies.md | 4 | 3 | 1 | 3 | 1 |
| index.md | 3 | 1 | 1 (gap: Ν.5239/2025) | 2 | 0 |

---

## FILE 1 — `orario/vardiakia.md` (Βάρδιες / Βαρδιακή Εργασία)

Mostly sound. Values are correct; the defects are missing article-precision and the OUTDATED omission of the 2025 working-time reform.

### 1.1 — OK claims
- Night window **22:00–06:00** → OK (ΠΔ 88/1999 art.2; brief §1).
- **11 συνεχόμενες ώρες** rest between shifts → OK value (brief §1 confirms 11h daily rest).
- Employer must register/declare the shift schedule in **ΕΡΓΑΝΗ** before it applies, and declare changes → OK (ΕΡΓΑΝΗ ΙΙ / ψηφιακή κάρτα regime, Ν.4808/2021 arts 73-74).
- Pregnant workers exempt from night shift once employer notified → OK (ΠΔ 176/1997 / Ν.1483/1984 maternity-protection line).
- Minors <18 barred from night work 22:00–06:00 → OK (Ν.1837/1989; ΠΔ 62/1998).
- Periodic health monitoring for rotating night-shift workers, free → OK (ΠΔ 88/1999 art.9 health-assessment duty).

### 1.2 — IMPRECISE — 11h rest citation lacks article
- **Verdict:** IMPRECISE (value correct; article missing).
- **Snippet (verbatim, line 28):** "Μεταξύ δύο βαρδιών πρέπει να μεσολαβούν τουλάχιστον **11 συνεχόμενες ώρες ανάπαυσης** (ΠΔ 88/1999)."
- **Proposed:** add the article — "…11 συνεχόμενες ώρες ανάπαυσης (**ΠΔ 88/1999 άρθρο 3**· το όριο μειώθηκε από 12 σε 11 ώρες με τον Ν.4093/2012)."
- **Legal basis:** ΠΔ 88/1999 art.3 (daily rest); reduction 12→11h by Ν.4093/2012. Brief §1.
- **Confidence:** HIGH. (Note: the brief flags `ores-ergasias.md` for wrongly citing **art.5** — vardiakia.md does NOT make that error; it simply omits the article. Recommend adding art.3 for consistency.)

### 1.3 — IMPRECISE — Ν.3385/2005 description
- **Verdict:** IMPRECISE.
- **Snippet (verbatim, line 66):** "Ν. 3385/2005 — Τροποποιήσεις ωραρίου και βαρδιών"
- **Issue:** Ν.3385/2005 is not a "shift-work" law. Full title: **«Ρυθμίσεις για την προώθηση της απασχόλησης, την ενίσχυση της κοινωνικής συνοχής και άλλες διατάξεις»** (ΦΕΚ Α΄210/19.08.2005). It reformed **διευθέτηση του χρόνου εργασίας** and **υπερεργασία** (41η–45η ώρα), not shift systems as such.
- **Proposed:** "Ν. 3385/2005 — ρυθμίσεις χρόνου εργασίας / διευθέτηση & υπερεργασία (όχι ειδικά για βάρδιες)."
- **Greek quote (source):** law title as above.
- **Source:** https://www.e-nomothesia.gr/kat-ergasia-koinonike-asphalise/n-3385-2005.html
- **Confidence:** HIGH.

### 1.4 — OUTDATED (GAP) — omits Ν.5239/2025 / ΚΕΔ framework
- **Verdict:** OUTDATED (structural gap, per brief §1).
- **Issue:** The whole `orario` cluster predates **ΠΔ 62/2025 (ΚΕΔ)** and **Ν.5239/2025**. For shift/continuous-operation work the newly relevant points are: 13-hour day now lawful **with a single employer** (consent + **right to refuse**, ≤4h overtime/day @ +40%, ≤150h/yr), and the **11h daily rest remains inviolable** — directly material to shift scheduling.
- **Proposed:** add a militant note: the 11h floor between shifts is now explicitly "απαραβίαστη" even under the 13ωρη ημέρα (Ν.5239/2025)· κανείς δεν σε υποχρεώνει σε 13ωρο — **έχεις δικαίωμα άρνησης χωρίς αντίποινα**.
- **Legal basis:** Ν.5239/2025 (Α΄178/17.10.2025); ΚΕΔ ΠΔ 62/2025 art.194 (overtime). Brief §0, §1.
- **Confidence:** HIGH (that it's a gap).

### 1.5 — UNVERIFIABLE — shift premium "15–25% επί του βασικού"
- **Verdict:** UNVERIFIABLE (no edit).
- **Snippet (verbatim, line 38):** "Χαρακτηριστικά κυμαίνεται μεταξύ **15–25% επί του βασικού μισθού**."
- **Issue:** No statutory shift premium exists; it is purely ΣΣΕ-set, which the file already states. The 15–25% "typical range" cannot be tied to a primary source and varies by κλάδος.
- **Action:** leave as-is; the ΣΣΕ attribution is correct. No statutory figure to assert.
- **Confidence:** n/a (correctly framed as ΣΣΕ-dependent).

---

## FILE 2 — `orario/ekti-imera.md` (Εργασία 6ης Ημέρας / Σάββατο)

**Highest-error file in the batch.** The headline premium and the citation are both wrong, and the scope is over-broad.

### 2.1 — WRONG — 6th-day premium is +40%, not +30% (TOP FIX)
- **Verdict:** WRONG.
- **Snippet (verbatim, lines 10-11 & 15-16):**
  - "Αν σε καλούν χωρίς να πληρώνουν το νόμιμο **+30%**, έχεις δικαίωμα να αρνηθείς ή να διεκδικήσεις αναδρομικά."
  - "Αμοιβή κανονικής ημέρας **+ 30%** επί του ωρομισθίου (άρθρο 2, Ν. 435/1968)"
  - "Εναλλακτικά, ισοδύναμη ανάπαυση άλλη ημέρα + **30%** προσαύξηση"
- **Proposed replacement:** "Αμοιβή της ημέρας **προσαυξημένη κατά +40%** (Ν.5053/2023, άρθρα 25-26). Τα αφεντικά που σε βάζουν 6η μέρα και σου κόβουν το +40% σε κλέβουν — διεκδίκησέ το αναδρομικά."
- **Legal basis:** **Ν.5053/2023 άρθρα 25-26** (Α΄158/26.09.2023).
- **Source:** https://www.taxheaven.gr/news/64928/ · https://www.ot.gr/2024/07/09/apopseis/experts/eksaimeri-apasxolisi-me-ton-nomo-5053-2023-poious-afora/
- **Greek quote (verbatim, from Ν.5053/2023 art.25):** "…ημερομίσθιο **προσαυξημένο κατά σαράντα τοις εκατό (40%)**."
- **Confidence:** HIGH. (Note per brief: confirm it is NOT stated as 50% — corpus states 30%, so the "50%" concern does not arise; the error is 30%→40%.)

### 2.2 — WRONG — citation "Ν. 435/1968" (wrong law AND wrong year)
- **Verdict:** WRONG (citation bug, brief §9).
- **Snippet (verbatim, lines 16 & 24):** "(άρθρο 2, Ν. 435/1968)" and "Ν. 435/1968 — Ρύθμιση εργασίας 6ης ημέρας"
- **Issue (two-fold):**
  1. **Wrong year:** the real instrument is **Ν.435/1976** (ΦΕΚ Α΄251/20.09.1976), not 435/1968. There is no substantive labour-law "435/1968".
  2. **Wrong topic:** even Ν.435/1976 **art.2** governs the **75% Sunday/holiday premium**, NOT 6th-day pay. The 6th-day premium is a 2023 creation (Ν.5053/2023 arts 25-26).
- **Proposed:** replace both with "Ν.5053/2023 άρθρα 25-26 — εργασία 6ης ημέρας (+40%)"; if referencing the Sunday/holiday 75% base elsewhere, cite **Ν.435/1976 art.2** + **ΝΔ 3755/1957 art.2**.
- **Greek quote (Ν.435/1976 art.1/2, per ΕΛΙΝΥΑΕ):** art.1 = παράνομη υπερωρία → 100%; art.2 = Κυριακή/αργία → 75%.
- **Source:** https://www.e-nomothesia.gr/kat-ergasia-koinonike-asphalise/n-435-1976.html
- **Confidence:** HIGH.

### 2.3 — WRONG/IMPRECISE — scope: not every Saturday for every 5-day worker
- **Verdict:** IMPRECISE (over-broad framing).
- **Snippet (verbatim, lines 8-11):** "Για εργαζόμενους με **5-ήμερη εβδομάδα** (Δευτ.–Παρ.), η εργασία Σαββάτου αποτελεί εργασία πέραν του εβδομαδιαίου ωραρίου…"
- **Issue:** The statutory **+40% 6th-day regime** (Ν.5053/2023 arts 25-26) applies **only** to (a) **continuous-operation** businesses on a 5-day system (art.25) and (b) non-continuous businesses operating **Mon–Sat, 24h, rotating shifts** under **exceptional/unforeseen increased workload** (art.26); **max 8h that day**, **no υπερεργασία/υπερωρία**, must be declared in ΕΡΓΑΝΗ ΙΙ; **excludes hotels/restaurants**. For an ordinary office 5-day worker asked to work Saturday, the applicable rules are **υπερεργασία (41–45h → +20%) / υπερωρία (+40%)**, not a blanket 6th-day premium.
- **Proposed:** clarify the two lawful 6th-day categories + limits, and route "ordinary" Saturday work to the [[Υπερωρίες]] rules. Keep militant framing (right to refuse illegal 6th-day demands; €10.500/εργαζόμενο ΕΡΓΑΝΗ penalty exposure).
- **Greek quote (Ν.5053/2023):** "Κατά την ημέρα αυτή **δεν επιτρέπεται η πραγματοποίηση υπερεργασίας και υπερωριακής απασχόλησης**."
- **Source:** https://www.taxheaven.gr/news/64928/
- **Confidence:** HIGH.

### 2.4 — OK
- 5-year prescription of the claim (line 20, "παραγράφεται σε 5 χρόνια") → OK (general 5-yr wage prescription).
- ΣΕΠΕ complaint channel 1555 → OK.

### 2.5 — Cross-note (stacking)
When the 6th day coincides with a **Sunday or public holiday**, premiums **stack**: +40% (6th day) **+** 75% (Sunday/αργία) = **+115%**. Worth adding to strengthen the worker's claim. (Source headline: powergame.gr "40% έως 115% προσαύξηση".) Confidence: HIGH.

---

## FILE 3 — `orario/argies.md` (Αργίες & Δημόσιες Εορτές)

### 3.1 — WRONG — Sunday premium is +75%, not +40% (TOP FIX)
- **Verdict:** WRONG.
- **Snippet (verbatim, lines 41-45):** "Για εργασία Κυριακής απαιτείται: … 3. Να σου καταβληθεί **προσαύξηση 40%** επί του ημερομισθίου."
- **Issue:** Sunday work carries the **same 75% premium** as obligatory holidays. Confirmed by 4 independent sources; **no 40% Sunday rate exists** in the primary law.
- **Proposed replacement:** "3. Να σου καταβληθεί **προσαύξηση 75%** επί του νόμιμου ωρομισθίου/ημερομισθίου — ίδια με τις υποχρεωτικές αργίες. Το +40% που ακούς είναι ΨΕΜΑ των αφεντικών· η Κυριακή πληρώνεται +75%."
- **Legal basis:** **ΝΔ 3755/1957 art.2**; **Ν.435/1976 art.2**; ΚΥΑ 8900/1946; ΚΥΑ 25825/1951 art.2.
- **Source:** https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/amoivi/kyriaki-argies-amoivi/amoivi-gia-apascholisi-kata-kyriaki-i-imera-argias-2/
- **Greek quote (verbatim, hli.gov.gr):** "προσαύξηση **εβδομήντα πέντε τοις εκατό (75%)** επί του νόμιμου ωρομισθίου τους" (applies to Sundays AND holidays alike).
- **Confidence:** HIGH.

### 3.2 — WRONG — obligatory-holidays list includes Καθαρά Δευτέρα; count is 9 not 10
- **Verdict:** WRONG.
- **Snippet (verbatim, lines 13 & 17):** "Οι αργίες αυτές είναι συνολικά **10**:" … "3. **Καθαρά Δευτέρα**"
- **Issue:** **Καθαρά Δευτέρα is NOT a private-sector υποχρεωτική αργία** — it is κατ'έθιμον/optional (like Μεγάλη Παρασκευή, Μεγάλο Σάββατο, Αγίου Πνεύματος). Remove it. The corpus's remaining nine entries exactly match the authoritative post-2021 list; the correct total is **9**, not 10.
- **Correct obligatory list (9):** 1η Ιανουαρίου (Ν.4808/2021 art.60), 6η Ιανουαρίου (Ν.4808/2021 art.60), 25η Μαρτίου, Δευτέρα του Πάσχα, 1η Μαΐου (Ν.4468/2017 art.14), 15η Αυγούστου, 28η Οκτωβρίου, 25η Δεκεμβρίου, 26η Δεκεμβρίου (Ν.4468/2017).
- **Proposed:** delete "Καθαρά Δευτέρα", change "συνολικά 10" → "συνολικά 9", and move Clean Monday to the κατ'έθιμον section.
- **Legal basis:** Ν.4808/2021 art.60 (added 1&6 Jan); Ν.4468/2017 art.14 (1 May, 26 Dec).
- **Source:** https://advisor.samoscci.gr/knowledgebase/το-πλαίσιο-των-όρων-αμοιβής-και-εργασί/ · https://www.e-forologia.gr/cms/viewContents.aspx?id=235855 · https://www.odigostoupoliti.eu/kathara-deftera-2026-ti-ischyei-gia-ergazomenous-kai-katastimata/
- **Greek quote (verbatim, odigostoupoliti):** "η Καθαρά Δευτέρα **δεν περιλαμβάνεται στις επίσημες αργίες που ορίζει ο νόμος** για τους εργαζόμενους στον ιδιωτικό τομέα."
- **Greek quote (verbatim, samoscci — NON-obligatory set):** "Καθαρά Δευτέρα, η Μεγάλη Παρασκευή, το Μεγάλο Σάββατο, η εορτή του Αγίου Πνεύματος" (listed as NOT obligatory).
- **Confidence:** HIGH that Clean Monday must be removed and count is 9. (Minor caveat: one mirror said "10" while listing 9 — treated as a source typo; two other sources give 9.)

### 3.3 — WRONG/IMPRECISE — citation block for the holiday/Sunday premium
- **Verdict:** WRONG (citation bugs, brief §9).
- **Snippet (verbatim, lines 15, 66-67):** "(άρθρο 2, Ν. 435/1968)" … "ΑΝ 586/1968 — Αργίες…" … "Ν. 435/1968 — Ρύθμιση αμοιβής αργιών"
- **Issues:**
  - "Ν. 435/1968" → should be **Ν.435/1976** (art.2 = 75% premium). Wrong year; brief §9 flags "435/1968 as both ΑΝ and Ν".
  - The 75% premium base is missing its principal source **ΝΔ 3755/1957 art.2** (and ΚΥΑ 8900/1946 / ΚΥΑ 25825/1951 art.2).
  - The obligatory-holiday **list** basis should cite **Ν.4808/2021 art.60** + **Ν.4468/2017 art.14** (modern additions), not (only) "ΑΝ 586/1968".
- **Proposed citation block:** ΝΔ 3755/1957 art.2 + Ν.435/1976 art.2 (75% Κυριακή/αργία); Ν.4808/2021 art.60 & Ν.4468/2017 art.14 (κατάλογος υποχρεωτικών αργιών); ΑΝ 789/1945 (εβδομαδιαία ανάπαυση).
- **Source:** ΕΛΙΝΥΑΕ Ν.435/1976; samoscci (legal cites for list).
- **Confidence:** HIGH on Ν.435/1976 & ΝΔ 3755/1957; HIGH on list cites.

### 3.4 — IMPRECISE/likely WRONG — κατ'έθιμον αργία "+30%"
- **Verdict:** IMPRECISE (unsupported figure).
- **Snippet (verbatim, line 37):** "Για εργασία σε κατ'έθιμον αργία δικαιούσαι **προσαύξηση 30%** επί του ημερομισθίου…"
- **Issue:** There is **no statutory +30%** for κατ'έθιμον/optional holidays. The statutory 75% premium is reserved for the υποχρεωτικές/εξαιρέσιμες αργίες and Sundays. For a κατ'έθιμον day: if the business normally **closes** and **exceptionally operates**, the prevailing view grants **1/25 ημερομισθίου + 75%**; otherwise pay is per ΣΣΕ or ordinary. The "+30%" is not grounded in primary law.
- **Proposed:** "Για εργασία σε κατ'έθιμον αργία: αν η επιχείρηση κανονικά αργεί και εξαιρετικά λειτουργεί → **1/25 του μισθού + 75%**· αλλιώς ό,τι ορίζει η ΣΣΕ σου. (Δεν υπάρχει νόμιμο 'σκέτο +30%'.)"
- **Greek quote (verbatim, odigostoupoliti re exceptional operation):** "workers are entitled to a **1/25 salary supplement plus 75%** wage increase for holiday work" (when a normally-closed firm exceptionally opens).
- **Source:** https://www.odigostoupoliti.eu/kathara-deftera-2026-ti-ischyei-gia-ergazomenous-kai-katastimata/ (+ KEPEA "Αμοιβή Κατ'έθιμον Αργιών")
- **Confidence:** MEDIUM (κατ'έθιμον treatment is genuinely ΣΣΕ/custom-dependent; but the specific +30% has no statutory anchor).

### 3.5 — IMPRECISE — mandatory-holiday "+ αναπληρωματικό ρεπό"
- **Verdict:** IMPRECISE.
- **Snippet (verbatim, line 28):** "…**προσαύξηση 75%** … PLUS ένα **αναπληρωματικό ρεπό** σε άλλη μέρα της ίδιας εβδομάδας."
- **Issue:** Statutory replacement rest (αναπληρωματική ανάπαυση) is a **Sunday / weekly-rest** mechanism (full 24h if Sunday work > 5h; proportional if ≤5h), **not** an automatic add-on for public holidays. Working a υποχρεωτική αργία gives the **75% premium** (→ 175% total for ημερομίσθιοι); a replacement day is not a general holiday entitlement.
- **Proposed:** move the "replacement rest / 5-hour" rule to the **Sunday** subsection; for holidays keep the 75% (→175% for ημερομίσθιοι) and drop the automatic ρεπό. Add μισθωτός vs ημερομίσθιος distinction.
- **Greek quote (Ν.435/1976 art.2 line):** "κάθε εργαζόμενος που απασχολείται **άνω των 5 ωρών** την Κυριακή δικαιούται αναπληρωματική 24ωρη εβδομαδιαία ανάπαυση."
- **Source:** e-forologia / hli.gov.gr (Sunday replacement-rest & 5h threshold).
- **Confidence:** MEDIUM-HIGH.

### 3.6 — IMPRECISE/OUTDATED — store-opening Sundays ("6 συγκεκριμένες Κυριακές")
- **Verdict:** OUTDATED/IMPRECISE.
- **Snippet (verbatim, line 50):** "Ο νόμος επιτρέπει στα εμπορικά καταστήματα να ανοίγουν **6 συγκεκριμένες Κυριακές** το χρόνο (Πάσχα, Χριστούγεννα κ.ά.)."
- **Issue:** Governing law is **Ν.4177/2013 art.16**, **as amended by Ν.5157/2024**. The nationally-permitted optional Sundays are the first Sunday of each εκπτωτική περίοδο, the two Sundays before Christmas, Κυριακή των Βαΐων, etc.; for 2026 the count is **~7–8**, not a fixed "6" (plus wider allowance in designated tourist zones). "6" is not the current figure.
- **Proposed:** "Ο νόμος (Ν.4177/2013 άρθρο 16, όπως τροπ. Ν.5157/2024) επιτρέπει προαιρετικό άνοιγμα σε ορισμένες Κυριακές (πρώτη Κυριακή εκπτώσεων, δύο Κυριακές προ Χριστουγέννων, Κυριακή Βαΐων κ.ά. — ~7-8 το 2026), και ευρύτερα σε τουριστικές ζώνες." Keep the militant point: even on an allowed store-Sunday, the employer must still pay the +75% and follow procedure.
- **Source:** nomoskopio Ν.4177/2013 art.16; Υπ. Ανάπτυξης opengov (Ν.5157/2024 τροποποίηση); parapolitika 2026 dates.
- **Confidence:** MEDIUM-HIGH (exact 2026 count varies by source; the "6 fixed" claim is outdated regardless).

### 3.7 — OK / UNVERIFIABLE
- Example arithmetic (line 31): 40€ + 30€ (75%) = 70€ → **OK** (75% of 40 = 30; correct for an ημερομίσθιος working a holiday). Keep but clarify μισθωτός vs ημερομίσθιος.
- Employer cannot force work on obligatory holiday without extra pay (line 13) → OK.
- 5-year prescription; ΣΕΠΕ 1555; gov.gr complaint (lines 55-59) → OK.
- "προηγούμενη έγκριση από τον ΣΕΠΕ" for Sunday work (line 43) → **UNVERIFIABLE/IMPRECISE**: Sunday operation is barred except for legally-exempted categories (ΒΔ 748/1966 & decrees) — per-instance ΣΕΠΕ "approval" is not the universal mechanism. Leave unless reframed to "νόμιμη εξαίρεση/άδεια όπου απαιτείται". Confidence MEDIUM.

---

## FILE 4 — `orario/index.md` (Ωράριο Εργασίας — landing)

### 4.1 — WRONG — "Νόμιμο ωράριο: 40 ώρες/εβδομάδα"
- **Verdict:** WRONG (conflates συμβατικό with νόμιμο; same error the brief flags for `ores-ergasias.md`).
- **Snippet (verbatim, lines 12-15):** "## Νόμιμο ωράριο\n\n- **40 ώρες/εβδομάδα** (5-ήμερη ή 6-ήμερη εβδομάδα)\n- Μέγιστο **8 ώρες/ημέρα** (5-ήμερη) ή **6,67 ώρες/ημέρα** (6-ήμερη)"
- **Issue:** 40h is the **contractual (συμβατικό)** full-time schedule. The **legal (νόμιμο) maximum** is **45h/εβδομάδα (9h/ημέρα) στο 5ήμερο** and **48h/εβδομάδα (8h/ημέρα) στο 6ήμερο**. Hours 41–45 (5ήμερο)/41–48 (6ήμερο) = **υπερεργασία +20%**. The daily "max 8h (5-day)" understates the legal max (9h); "6,67h (6-day)" is the contractual average, not the legal daily max (8h).
- **Proposed replacement:** "## Νόμιμο vs συμβατικό ωράριο\n- **Συμβατικό πλήρες:** 40 ώρες/εβδομάδα (η κανονική σύμβαση)\n- **Νόμιμο ανώτατο:** 45 ώρες/εβδ. (9 ώρες/ημέρα) στο 5ήμερο · 48 ώρες/εβδ. (8 ώρες/ημέρα) στο 6ήμερο\n- Οι ώρες 41–45 (5ήμερο)/41–48 (6ήμερο) είναι **υπερεργασία με +20%** — δεν είναι 'τσάμπα'."
- **Legal basis:** Brief §1 (Ν.3385/2005 / Ν.4808/2021; ΚΕΔ ΠΔ 62/2025).
- **Confidence:** HIGH.

### 4.2 — OK
- "Ελάχιστη ημερήσια ανάπαυση: 11 συνεχόμενες ώρες" → OK (ΠΔ 88/1999 art.3).
- "Εβδομαδιαία ανάπαυση: 35 συνεχόμενες ώρες (συμπ. Κυριακής)" → OK (24h ΠΔ 88/1999 art.5 + 11h daily = 35h; brief §1).

### 4.3 — OUTDATED (GAP) — no υπερεργασία tier, no Ν.5239/2025
- **Verdict:** OUTDATED.
- **Issue:** Landing omits the **υπερεργασία +20%** tier and the **Ν.5239/2025** 13-hour-day / 4-day-week / right-to-refuse framework and the **ΚΕΔ (ΠΔ 62/2025)** recodification.
- **Proposed:** add a nav entry + one-line critical note on the 13ωρη ημέρα and the right to refuse.
- **Legal basis:** Brief §0, §1.
- **Confidence:** HIGH (gap).

---

## UNVERIFIABLE / HUMAN-REVIEW

1. **vardiakia.md** shift premium "15–25% επί του βασικού" — ΣΣΕ-dependent, no statutory anchor. No edit. (§1.5)
2. **argies.md** "προηγούμενη έγκριση από τον ΣΕΠΕ" for Sunday work — mechanism imprecise; Sunday operation runs on legal-exemption categories, not universal per-instance approval. Human review before rewording. (§3.7)
3. **argies.md / ekti-imera.md** "Ν./ΑΝ 435/1968" — I am confident the intended instrument is **Ν.435/1976**; if any editor believes a genuine ΑΝ 435/1968 was meant, verify against ΦΕΚ before final wording. (brief §9)
4. **argies.md** exact **2026 store-opening Sundays count** (7 vs 8) varies by secondary source; the "6 fixed" claim is outdated regardless. Pin exact list via Υπ. Ανάπτυξης before publishing a number. (§3.6)
5. Obligatory-holiday **total 9 vs "10"** — two sources give 9 (no Clean Monday); one mirror said "10" while listing 9. Treated as source typo; recommend 9. Low residual risk. (§3.2)

## GAPS (for Phase D / cross-file)

- **Ν.5239/2025 (13-hour single-employer day, right to refuse, 4-day week all year) + ΚΕΔ ΠΔ 62/2025** absent from the entire `orario` cluster — material to vardiakia (shift scheduling/11h floor) and index. (brief §1)
- **υπερεργασία +20% tier** missing from index.md (and, by reference, from the 6th-day/overtime routing in ekti-imera.md).
- **Premium-stacking rule** (6th day +40% × Sunday/αργία +75% = +115%) not stated anywhere — add to ekti-imera.md and argies.md.
- **μισθωτός vs ημερομίσθιος** pay distinction for holiday work not drawn in argies.md (affects whether it's "+75%" on top of salary or "175%" total).
- **Digital work-card / ΕΡΓΑΝΗ penalty €10.500/εργαζόμενο** (Ν.5053/2023 art.22) could reinforce the enforcement sections of all four files.

---

*End of ledger — batch `orario-days`.*

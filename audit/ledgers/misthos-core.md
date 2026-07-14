# AUDIT LEDGER — Batch `misthos-core`

**Auditor role:** Greek labour lawyer (εργατολόγος), pro-worker.
**Audit date:** 2026-07-13
**Baseline:** `audit/CURRENCY-BRIEF.md` §2 (Pay) + fresh primary-source fetches (hli.gov.gr, ypergasias.gov.gr, e-nomothesia.gr, lawspot.gr, taxheaven, kepea.gr).
**Files:** `misthos/katotatos-misthos.md`, `misthos/oromisthio.md`, `misthos/ekkatharistiko.md`, `misthos/index.md`
**Corpus edits made:** NONE (audit only).

Legend: **OK** = accurate & current · **WRONG** = factually false · **OUTDATED** = was true, superseded · **IMPRECISE** = misleading/loose citation · **UNVERIFIABLE** = could not confirm against a primary source.

---

## VERDICT TALLY

| File | Claims checked | OK | WRONG | OUTDATED | IMPRECISE | UNVERIFIABLE |
|---|---|---|---|---|---|---|
| katotatos-misthos.md | 12 | 9 | 0 | 0 | 2 | 0 (+1 GAP) |
| oromisthio.md | 13 | 8 | 5 | 0 | 0 | 0 |
| ekkatharistiko.md | 11 | 8 | 1 | 1 | 1 | 0 |
| index.md | 6 | 4 | 0 | 1 | 1 | 0 |

**Headline:** the hourly-wage formula in `oromisthio.md` is WRONG and understates every hourly worker's minimum wage by 16,7% — it literally tells workers the legal floor is €4,40/h when it is €5,52/h. This is the single most damaging error in the batch (a pro-worker site publishing a below-legal wage floor). Second: the payslip legal basis in `ekkatharistiko.md` cites the wrong law entirely (Ν.4808/2021 art.62 is *unpaid leave*, not payslips).

---

## FILE 1 — `misthos/katotatos-misthos.md`

### OK claims (confirmed against primary source)
- **Minimum wage from 01.04.2026: €920,00/mo (υπάλληλοι), €41,09/day (εργατοτεχνίτες).** CONFIRMED. Source: e-nomothesia.gr "Κοινή Υπουργική Απόφαση 8934/2026 — ΦΕΚ 1759/Β/27-3-2026"; ypergasias.gov.gr. (+4,55% vs 2025.)
- **History: 2025 €880/€39,30; 2024 €830/€37,07.** CONFIRMED (2024 = ΥΑ 25058/2024, ΦΕΚ Β΄1974). OK.
- **Triennia: υπάλληλοι +10%/τριετία × max 3 = +30%; εργάτες +5%/τριετία × max 6 = +30%.** CONFIRMED verbatim by ΚΥΑ 8934/2026 text and kepea.gr tables. OK.
- **Counting window (service pre-14.02.2012 + from 01.01.2024 counts; 14.02.2012–31.12.2023 excluded).** CONFIRMED (Ν.5053/2023 art.33). OK.
- **Any-employer service counts.** CONFIRMED ("σε οποιονδήποτε εργοδότη", ypergasias.gov.gr εγκύκλιος art.33). OK.
- **Consultation process introduced by Ν.4808/2021.** OK (art.34 reformed the art.103 Ν.4172/2013 procedure).
- Adjustment "συνήθως 1η Απριλίου" via ΔΤΚ/ανεργία/ανάπτυξη indicators — OK.

### IMPRECISE-1 — "ΥΑ" should be "ΚΥΑ"
- **Verbatim (line 20):** `> Τελευταία αναπροσαρμογή: 1η Απριλίου 2026 (ΥΑ 8934/27.03.2026, ΦΕΚ Β΄ 1759).`
- **Verbatim (line 102):** `- ΥΑ 8934/27.03.2026 (ΦΕΚ Β΄ 1759) — Ισχύοντα ποσά από 01.04.2026`
- **Replacement:** `ΚΥΑ 8934/2026` (Κοινή Υπουργική Απόφαση — signed by Οικονομικών + Εργασίας jointly). Number, date and ΦΕΚ are otherwise correct.
- **Legal basis / source:** e-nomothesia.gr — title reads *"Κοινή Υπουργική Απόφαση 8934/2026 - ΦΕΚ 1759/Β/27-3-2026"*. https://www.e-nomothesia.gr/kat-ergasia-koinonike-asphalise/kya-8934-2026.html ; forin.gr filed under *"Κ.Υ.Α. 8934/2026"*.
- **Confidence:** High.

### IMPRECISE-2 / GAP — triennia legal basis and the 2027 re-suspension trap are missing
- **Verbatim (lines 56-57):** `Λόγω της οικονομικής κρίσης και των μνημονιακών νόμων, υπάρχει μία σύνθετη ρύθμιση για το ποιος χρόνος μετράει:`
- **Problem:** The file describes the freeze/unfreeze mechanics correctly but never cites the governing instruments, and OMITS the auto-re-suspension clause — a material omission for a worker planning ahead.
- **Replacement (add):** The triennia freeze was imposed by **ΠΥΣ 6/2012 άρθρο 4** (14.02.2012). It was lifted from **01.01.2024 by Ν.5053/2023 άρθρο 33** (παρ. 8 repealed ΠΥΣ 6/2012 art.4). **WARNING to add:** under **Ν.5053/2023 άρθρο 33 παρ. 6-7**, the triennia accrual **auto-re-suspends from 01.01.2027 if unemployment exceeds 10%**, and stays suspended until it falls back below 10%. Workers should not assume triennia keep accruing indefinitely.
- **Legal basis:** ΠΥΣ 6/2012 art.4 (freeze); Ν.5053/2023 (ΦΕΚ Α΄158/26.09.2023) art.33 (unfreeze + conditional re-suspension). Recodified context: individual labour law now sits in the **ΚΕΔ (ΠΔ 62/2025, ΦΕΚ Α΄121/11.07.2025)**.
- **Source / verbatim quote:** ypergasias.gov.gr εγκύκλιος on art.33: *"Από την 1η.1.2024 καταργείται με το άρθρο 33 παρ.8 του ν. 5053/2023 η διάταξη του άρθρου 4 της ΠΥΣ 6/2012…"*; and *"…την 1η.1.2027, θα ανασταλεί αυτοδικαίως η προσαύξηση των αποδοχών των εργαζομένων λόγω προϋπηρεσίας, εφόσον η ανεργία υπερβεί το 10%…"* (den.gr / epsilonnet KB, art.33 παρ.6-7). https://ypergasias.gov.gr/egkyklios-gia-tin-parochi-diefkriniseon-epi-tou-arthrou-33-tou-n-5053-2023...
- **Confidence:** High.

### Note (not a defect)
- Line 100 cites `Ν. 4093/2012 — Ορισμός κατώτατου μισθού ως νομοθετική πράξη`. Defensible (Ν.4093/2012 υποπαρ. ΙΑ.11 introduced the νομοθετημένος κατώτατος μισθός mechanism). Optional refinement: the *current* setting procedure runs under Ν.4172/2013 art.103 as amended by Ν.4808/2021 art.34. Marked OK.

---

## FILE 2 — `misthos/oromisthio.md`  ← most-damaged file

### WRONG-1 — hourly-wage formula (5-day) understates the wage by 16,7%
- **Verbatim (lines 15-18):**
  ```
  **5ήμερη εργασία (8 ώρες/ημέρα):**
  ωρομίσθιο = μηνιαίος μισθός ÷ 25 ÷ 8
  ```
- **Why wrong:** `÷25÷8` = `÷200` = `× 0,005`. The official method is `÷ 25 × 6 ÷ 40` = `× 0,006`. Understatement = (0,006−0,005)/0,006 = **16,67%**.
- **Replacement:** `ωρομίσθιο = μηνιαίος μισθός ÷ 25 × 6 ÷ 40  (= μισθός × 0,006)`
- **Legal basis:** Official conversion published by **Επιθεώρηση Εργασίας (hli.gov.gr)**, "Αποδοχές – Αναγωγή Μισθού σε Ημερομίσθιο / Ωρομίσθιο".
- **Source / verbatim quote:** *"μισθός : 25 x 6 : 40"* and daily = *"διαιρείται ο μισθός αυτός δια 25"*. https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/amoivi/misthos/apodoches-anagogi-misthou-se-imeromisthio-oromisthio/
- **Confidence:** High.

### WRONG-2 — hourly-wage formula (6-day)
- **Verbatim (lines 20-23):**
  ```
  **6ήμερη εργασία:**
  ωρομίσθιο = μηνιαίος μισθός ÷ 26 ÷ 8
  ```
- **Why wrong:** `÷26÷8` = `× 0,004808` — even further below the legal floor. For a monthly-salaried employee the ωρομίσθιο is `× 0,006` **regardless of 5- or 6-day schedule**, because the divisor (25) and the ×6/÷40 base are fixed conventions; the ×26 divisor applies only to the *reverse* conversion (ημερομίσθιο → μισθός), not to the hourly rate.
- **Replacement:** Use the single official formula `μισθός ÷ 25 × 6 ÷ 40 (= × 0,006)` for both schedules; delete the separate ÷26÷8 line. (If a distinct daily figure is wanted: ημερομίσθιο = μισθός ÷ 25.)
- **Legal basis / source:** same hli.gov.gr page. *"πολλαπλασιάζεται το ημερομίσθιο επί 26"* is the μισθός-from-ημερομίσθιο conversion, not the hourly rate.
- **Confidence:** High.

### WRONG-3 — worked example gives a below-legal hourly floor (and uses stale wage)
- **Verbatim (lines 25-28):**
  ```
  **Κατώτατο ωρομίσθιο 2025:**
  Κατώτατος μισθός 880 € ÷ 25 ÷ 8 = **4,40 €/ώρα**
  Αμοιβή κάτω από 4,40 €/ώρα είναι παράνομη ανεξαρτήτως συμφωνίας…
  ```
- **Why wrong:** two errors compound — wrong formula AND stale (2025) wage. Correct 2026 floor: `€920 × 0,006 = €5,52/h`. Even on the 2025 wage the correct figure was `€880 × 0,006 = €5,28/h`, never €4,40. Publishing €4,40 as "the legal floor" on a pro-worker site invites employers to underpay by >€1/h.
- **Replacement:**
  ```
  **Κατώτατο ωρομίσθιο (από 01.04.2026):**
  Κατώτατος μισθός 920 € ÷ 25 × 6 ÷ 40 = **5,52 €/ώρα**
  Αμοιβή κάτω από 5,52 €/ώρα είναι παράνομη ανεξαρτήτως συμφωνίας…
  ```
- **Legal basis / source:** ΚΥΑ 8934/2026 (€920) × official hli.gov.gr formula (×0,006). €920 × 0,006 = €5,52.
- **Confidence:** High.

### WRONG-4 — repeat of the wrong floor
- **Verbatim (line 76):** `Αν το ωρομίσθιό σου είναι κάτω από 4,40 €/ώρα:`
- **Replacement:** `Αν το ωρομίσθιό σου είναι κάτω από 5,52 €/ώρα:`
- **Confidence:** High.

### WRONG-5 — overtime/υπερεργασία premium table mislabels the tiers
- **Verbatim (lines 53-57):**
  ```
  | Νόμιμη υπερεργασία (41η–45η ώρα/εβδομάδα) | +40% |
  | Υπερωρία πέραν 45 ωρών | +60% |
  | Εργασία Κυριακή/αργία | +75% |
  ```
- **Why wrong:** the file conflates *υπερεργασία* with *υπερωρία*.
  - Υπερεργασία (41η–45η ώρα, 5ήμερο) = **+20%**, NOT +40%.
  - Νόμιμη υπερωρία (46η ώρα και άνω, έως 150 ώρες/έτος) = **+40%**, NOT +60%.
  - Υπερωρία πέραν των 150 ωρών/έτος (εγκεκριμένη) = **+60%**; μη νόμιμη/αδήλωτη = **+120%**.
  - Κυριακή/αργία **+75%** → **OK** (keep).
- **Replacement:**
  ```
  | Υπερεργασία (41η–45η ώρα/εβδομάδα) | +20% |
  | Νόμιμη υπερωρία (46η ώρα+, έως 150 ώρες/έτος) | +40% |
  | Υπερωρία πέραν 150 ωρών/έτος | +60% |
  | Παράνομη/αδήλωτη υπερωρία | +120% |
  | Εργασία Κυριακή/αργία | +75% |
  ```
- **Legal basis:** ΚΕΔ (ΠΔ 62/2025) art.194 as amended by Ν.5239/2025; underlying Ν.4808/2021, Ν.3385/2005. (Daily overtime cap raised 3h→4h by Ν.5239/2025.)
- **Source / verbatim quote:** hli.gov.gr & kepea.gr: *"οι ώρες από την 41η έως την 45η θεωρούνται υπερεργασία και το ωρομίσθιό σας προσαυξάνεται κατά 20%"*; *"Από την 46η ώρα και μετά… έως τις 150 ώρες το χρόνο, το ωρομίσθιο προσαυξάνεται κατά 40%"*. https://www.kepea.gr/pos-ameivetai-i-yperoria-kai-i-yperergasia ; https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/amoivi/ypervasi-chronikon-orion-amoivi/yperergasia-2/
- **Confidence:** High. (Cross-check the sibling `orario/yperoreis.md` audit — same tiers.)

### OK claims
- Ωρομίσθιοι δικαιούνται ετήσια άδεια όπως μισθωτοί (**ΑΝ 539/1945**) — OK.
- Leave-pay formula (ωρομίσθιο × ώρες/ημέρα × ημέρες άδειας) — OK (substantively correct).
- Δώρα: Χριστουγέννων 25 ημερομίσθια, Πάσχα 15 ημερομίσθια (πλήρες εξάμηνο) — OK (matches brief §2).
- 5ετής παραγραφή εργατικών αξιώσεων (αναδρομικά) — OK (ΑΚ 250).
- Payslip must show hours/rate/gross/ΕΦΚΑ/φόρο/net — OK.
- Ψηφιακό ωράριο (ΕΡΓΑΝΗ ΙΙ) — OK.
- Legislation block (ΑΝ 539/1945, Ν.4093/2012, Ν.4808/2021) — OK (optional: add ΚΕΔ ΠΔ 62/2025 for working-time).

---

## FILE 3 — `misthos/ekkatharistiko.md`

### WRONG-1 — payslip legal basis cites the wrong law (art.62 = unpaid leave, not payslips)
- **Verbatim (line 69):** `- **Ν. 4808/2021** (άρθρο 62) — Υποχρέωση χορήγησης εκκαθαριστικού σημειώματος μισθοδοσίας`
- **Why wrong:** **Article 62 of Ν.4808/2021 governs UNPAID LEAVE (άδεια άνευ αποδοχών, ≤1 έτος)** — it has nothing to do with payslips. The payslip obligation lives in a different, older statute.
- **Replacement:** `- **Ν. 1082/1980** (άρθρο 18 παρ. 1), όπως αντικαταστάθηκε από τον **Ν. 4254/2014** (υποπαρ. ΙΑ.5) — υποχρέωση χορήγησης αναλυτικού εκκαθαριστικού σημειώματος / ανάλυσης μισθοδοσίας. (Ν. 3227/2004 άρθρο 5 για κατ' αποκοπή αμοιβές. Διοικητικές κυρώσεις μέσω ΣΕΠΕ.)`
- **Legal basis:** Ν.1082/1980 art.18 §1, replaced by Ν.4254/2014 subpar. ΙΑ.5; Ν.3227/2004 art.5 (lump-sum). Individual labour law now recodified in **ΚΕΔ (ΠΔ 62/2025)** — exact ΚΕΔ article for payslips not independently confirmed, so do NOT assert a specific ΚΕΔ number.
- **Source / verbatim quote:**
  - Art.62 content: taxlive/taxheaven codified Ν.4808/2021 — art.62 = *"άδεια άνευ αποδοχών"* (employment suspended ≤1 yr).
  - Payslip basis: ergasiaka-gr.net / lsa.gr (Π. Ραπανάκης): *"Η παράγραφος 1 του άρθρου 18 του Ν.1082/80 αντικαταστάθηκε με το Ν.4254/2014… ο εργοδότης υποχρεούται κατά την εξόφληση των αποδοχών του προσωπικού να χορηγεί εκκαθαριστικό σημείωμα, ή σε περίπτωση εφαρμογής μηχανογραφικού συστήματος, ανάλυση μισθοδοσίας."* https://www.ergasiaka-gr.net/2014/10/analytika-ekkatharistika-simeiomata-misthodosias/ ; hli.gov.gr "Εκκαθαριστικά Σημειώματα Αποδοχών".
- **Confidence:** High.
- **NOTE FOR BRIEF MAINTAINERS:** `CURRENCY-BRIEF.md` §2 (Payslip row) ALSO cites "Ν.4808/2021 art.62" — the brief is wrong here too (its §6 correctly assigns art.62 to unpaid leave; the two are mutually exclusive). Correct the brief to Ν.1082/1980 art.18 (am. Ν.4254/2014).

### OUTDATED-1 — employee ΕΦΚΑ rate 13,87% is a pre-2025 figure
- **Verbatim (line 29):** `Ο εργαζόμενος καταβάλλει εισφορές ύψους **13,87%** επί των μεικτών αποδοχών (ποσοστό 2024 — ελέγχεται περιοδικά).`
- **Why outdated:** the employee-side health-in-kind contribution was cut on **01.01.2025** (e-EFKA εγκ. 38/2024, −0,50 pt employee share), lowering the employee total from 13,87% to **13,37%** (in force 2025–2026).
- **Replacement:** `…εισφορές ύψους **13,37%** επί των μεικτών αποδοχών (ποσοστό 2026 — ελέγχεται περιοδικά).`
- **Legal basis:** Ν.4387/2016 art.38; e-EFKA εγκ. 38/2024 (health-in-kind cut from 1.1.2025); e-EFKA εγκ. 4/2026 (2026 ceiling €7.761,94). Total employer+employee ≈ 35,16% (employee 13,37% + employer 21,79%).
- **Source:** katharosmisthos.gr / paymaster.gr / hrvault.gr 2026 payroll guides confirm employee = **13,37%**; ypergasias.gov.gr "Insurance contributions". Cross-ref brief §3.
- **Confidence:** High (total 13,37% firmly confirmed; sub-branch splits vary slightly by source but sum to 13,37%).

### IMPRECISE-1 — wage-payment obligation is ΑΚ 653, not ΑΚ 656
- **Verbatim (line 70):** `- **ΑΚ 656** — Υποχρέωση καταβολής αμοιβής`
- **Why imprecise:** **ΑΚ 653** ("Υποχρεώσεις του εργοδότη") is the general wage-payment obligation. **ΑΚ 656** covers the narrower case of *υπερημερία εργοδότη* (employer's default of acceptance — worker still gets paid when the employer refuses offered work). Citing 656 as the general pay duty is wrong-target.
- **Replacement:** `- **ΑΚ 653** — Υποχρέωση του εργοδότη να καταβάλει τον συμφωνημένο ή συνηθισμένο μισθό` (optionally keep ΑΚ 656 separately for μισθός υπερημερίας).
- **Legal basis / source:** lawspot.gr — Art.653 *"Ο εργοδότης έχει υποχρέωση να καταβάλει το συμφωνημένο ή το συνηθισμένο μισθό"*; Art.656 titled *"Υπερημερία του εργοδότη"*. https://www.lawspot.gr/nomikes-plirofories/nomothesia/astikos-kodikas/arthro-653-astikos-kodikas-ypohreoseis-toy-ergodoti
- **Confidence:** High.

### OK claims
- Payslip mandatory + electronic delivery permitted — **OK** (confirmed: έγγραφο "κατά την εξόφληση"; ηλεκτρονική χορήγηση επιτρεπτή, Υπ. Εργασίας 31637/2010; no employee signature required).
- Mandatory contents list (στοιχεία εργαζ./εργοδότη, περίοδος, μεικτά, ΕΦΚΑ ανά κλάδο, ΦΜΥ, λοιπές κρατήσεις, καθαρά) — OK (satisfies "πάσης φύσεως αποδοχές και κρατήσεις αναλυτικά").
- ΦΜΥ μπορεί να είναι μηδενικός για χαμηλά εισοδήματα — OK.
- Καθαρές = Μεικτές − ΕΦΚΑ − ΦΜΥ − λοιπές — OK.
- **ΑΚ 250** — πενταετής παραγραφή αξιώσεων μισθών — OK.
- ΕΡΓΑΝΗ vs εκκαθαριστικό mismatch = απάτη ΕΦΚΑ, χάσιμο ασφαλιστικών δικαιωμάτων — OK.

---

## FILE 4 — `misthos/index.md`

### OUTDATED-1 — stale "(2024)" label on the minimum-wage link
- **Verbatim (line 14):** `- **[[Κατώτατος Μισθός]]** — τα ελάχιστα νόμιμα όρια (2024)`
- **Replacement:** `- **[[Κατώτατος Μισθός]]** — τα ελάχιστα νόμιμα όρια (από 01.04.2026: €920/€41,09)` (or simply drop the year to avoid re-staling).
- **Confidence:** High (cosmetic but signals stale content on the landing page).

### IMPRECISE-1 — Easter-bonus period/deadline conflated
- **Verbatim (line 16):** `- **[[Δώρο Πάσχα]]** — 50% μηνιαίου μισθού, 1 Ιανουαρίου–πριν τη Μ. Δευτέρα`
- **Why imprecise:** the **reference (accrual) period** for the full Easter bonus is **1 Ιανουαρίου–30 Απριλίου**; the **payment deadline** is **Μ. Τετάρτη** (Holy Wednesday), not "πριν τη Μ. Δευτέρα". The line fuses the two and gets the deadline day wrong.
- **Replacement:** `- **[[Δώρο Πάσχα]]** — 50% μηνιαίου μισθού (period 1 Ιαν–30 Απρ· καταβολή έως τη Μ. Τετάρτη)`
- **Legal basis:** Ν.1082/1980 + ΚΥΑ 19040/1981 (ΦΕΚ Β΄742). Cross-ref sibling `misthos/doro-pasxa.md` audit.
- **Confidence:** Medium-High (deadline day = Μ. Τετάρτη is standard; verify against doro-pasxa.md batch).

### OK claims
- Δώρο Χριστουγέννων: 1 μηνιαίος μισθός, 1 Μαΐου–31 Δεκεμβρίου — OK (matches brief §2).
- Επίδομα Γάμου βάσει ΣΣΕ — OK (consistent; refine scope to ΕΓΣΣΕ signatory-member employers in the epidoma-gamou.md batch).
- Μισθός μηνιαία/τμηματικά, υποχρεωτική αναλυτική απόδειξη, απαγόρευση καθυστέρησης — OK.

---

## CROSS-CUTTING FINDINGS
1. **`oromisthio.md` is the priority fix** — the ×0,005 formula + €4,40 floor publishes a wage below the legal minimum on a workers'-rights site. Fix formula → ×0,006 and floor → €5,52/h everywhere.
2. **`ekkatharistiko.md` payslip citation** — swap Ν.4808/2021 art.62 → Ν.1082/1980 art.18 (am. Ν.4254/2014). **The CURRENCY-BRIEF itself repeats this error** — flag upstream.
3. **ΚΕΔ (ΠΔ 62/2025) recodification** absent across the whole batch — underlying-law citations remain valid, but overtime/working-time content should note the ΚΕΔ now houses these rules (as amended by Ν.5239/2025 for the 4h daily overtime cap).
4. **Triennia re-suspension trap (1.1.2027 if unemployment >10%)** — a worker-relevant warning missing from `katotatos-misthos.md`.

## GAPS / UNVERIFIABLE
- Exact **ΚΕΔ article numbers** for (a) payslip obligation and (b) overtime were not independently pinned to a primary quote → not asserted (left as underlying-law citations).
- Sub-branch split of the 13,37% employee ΕΦΚΑ rate varies across secondary calculators (e.g. aux shown 3,00% vs 3,25%); the **total 13,37%** is firm — do not publish a line-item breakdown without e-EFKA εγκ. 4/2026 in hand.

## SOURCES (primary/authoritative)
- hli.gov.gr — ωρομίσθιο formula; υπερεργασία/υπερωρία; εκκαθαριστικά σημειώματα.
- e-nomothesia.gr — ΚΥΑ 8934/2026 (ΦΕΚ Β΄1759/27-3-2026).
- ypergasias.gov.gr — εγκύκλιος άρθρο 33 Ν.5053/2023 (triennia); insurance contributions.
- lawspot.gr — ΑΚ 653 vs ΑΚ 656.
- ergasiaka-gr.net / lsa.gr — payslip basis Ν.1082/1980 art.18 (am. Ν.4254/2014).
- kepea.gr (ΓΣΕΕ) — υπερεργασία +20% / υπερωρία +40% cross-check.
- taxheaven / forin.gr — Ν.4808/2021 codified (art.62 = unpaid leave); ΚΥΑ 8934/2026.
- Secondary 2026 payroll guides (katharosmisthos.gr, paymaster.gr, hrvault.gr) — employee ΕΦΚΑ 13,37% cross-check.

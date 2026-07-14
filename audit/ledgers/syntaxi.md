# AUDIT LEDGER — Batch `syntaxi`

**Auditor role:** Greek labour lawyer / pension specialist (εργατολόγος – ασφαλιστικός), pro-worker.
**Audit date:** 2026-07-13
**Baseline:** `audit/CURRENCY-BRIEF.md` §5 (Pensions) + fresh primary/authoritative fetches (e-efka.gov.gr, e-nomothesia.gr, ypergasias.gov.gr, kepea.gr, odigostoupoliti.eu, siopi-law.gr, taxheaven).
**Files:** `syntaxi/ilikia-syntaxis.md`, `syntaxi/exagora-ensemon.md`, `syntaxi/index.md`
**Corpus edits made:** NONE (audit only).

Legend: **OK** = accurate & current · **WRONG** = factually false · **OUTDATED** = was true, superseded · **IMPRECISE** = misleading/loose citation · **UNVERIFIABLE** = could not confirm against a primary source.

---

## VERDICT TALLY

| File | Claims checked | OK | WRONG | OUTDATED | IMPRECISE | UNVERIFIABLE |
|---|---|---|---|---|---|---|
| ilikia-syntaxis.md | 19 | 8 | 6 | 1 | 3 | 1 |
| exagora-ensemon.md | 9 | 4 | 0 | 0 | 3 | 1 (+1 GAP) |
| index.md | 12 | 7 | 2 | 2 | 1 | 0 |

**Headline:** this batch is the most factually rotten in the corpus. Every headline pension number is stale or wrong: the **national pension is published at €386,69 when the legal figure from 1.1.2026 is €446,86** (a €60,17/mo — ~15,6% — understatement quoted to workers planning their retirement); the **proportional-reduction formula `×(έτη/20)` is invented** (the law reduces by −2 percentage points per year below 20, floor 90% at 15 yrs = €402,18); the **ΒΑΕ conditions are wrong on both figures** (corpus "25 yrs / 15 in ΒΑΕ" → law is 4.500 ημέρες / ≥3.600 in ΒΑΕ); the **working-pensioner "30% cut" was ABOLISHED 1.1.2024** (Art.114 Ν.5078/2023 → 10% e-EFKA πόρος); the disability schedule is missing a whole band and mislabels another; and the accrual ceiling is understated (1,25% → 2,55%). A worker using this page would under-estimate their own pension and mis-plan their retirement date.

---

## FILE 1 — `syntaxi/ilikia-syntaxis.md`  ← most-damaged file

### OK claims (confirmed against primary source)
- **Κανονική σύνταξη γήρατος: 67 έτη / 15 έτη (4.500 ημέρες) / πλήρης.** CONFIRMED (e-EFKA; brief §5). OK.
- **Πρόωρη πλήρης: 62 έτη / 40 έτη (12.000 ημέρες).** CONFIRMED. OK.
- **System established by Ν.4387/2016 (Κατρούγκαλου), amended by Ν.5078/2023.** OK (though Ν.4670/2020 is the more relevant amender for accrual rates — see WRONG-1).
- **«Πλήρης» = χωρίς μειωτικό συντελεστή, όχι σταθερό ποσό; ύψος εξαρτάται από εισφορές.** OK (sound framing).
- **Ασφαλιστική βάση = μέσος μισθός όλου του βίου με αναγωγή, όχι τελευταίος μισθός.** OK.
- **Αδήλωτη εργασία / μη καταβολή εισφορών: ο εργαζόμενος δεν χάνει δικαιώματα, ΕΦΚΑ καταλογίζει στον εργοδότη.** OK (militant note, legally sound — καταλογισμός εισφορών).
- **Εισφορά υγείας 6% επί της κύριας σύνταξης.** OK (6% υπέρ ΕΟΠΥΥ παρακρατείται από την κύρια σύνταξη).
- **Αίτηση ηλεκτρονικά μέσω e-ΕΦΚΑ, νόμιμη προθεσμία 3 μήνες, προκαταρκτική εκτίμηση μέσω υπολογιστή e-ΕΦΚΑ, Συνήγορος του Πολίτη.** OK (practical steps accurate).

### WRONG-1 — accrual coefficient upper bound (0,77%–1,25%) understates it by half
- **Verbatim (line 31):** `Ο **ανταποδοτικός συντελεστής** κυμαίνεται περίπου από **0,77% έως 1,25% ανά έτος ασφάλισης**`
- **Why wrong:** the ποσοστά αναπλήρωσης scale (Ν.4670/2020, from 1.10.2019) runs **0,77% (0–15 έτη) up to 2,55% (36,01–40 έτη)**, then +0,50%/έτος beyond 40. The upper bound is **2,55%, not 1,25%.** 1,25% is roughly the rate at ~27 years — the corpus caps the scale two-thirds of the way up and thereby hides the reward for long careers.
- **Replacement:** `κυμαίνεται από **0,77% έως 2,55% ανά έτος ασφάλισης** (κλίμακα ποσοστών αναπλήρωσης: 0,77% για 0–15 έτη, ανεβαίνει κλιμακωτά σε 1,98% για 30–33 έτη, 2,50% για 33–36 έτη και 2,55% για 36–40 έτη· άνω των 40 ετών +0,50%/έτος). Σωρευτικά: 15 έτη = 11,55%, 40 έτη = 50,01%.`
- **Legal basis:** Ν.4670/2020 άρθρο 24 (αντικατέστησε τον πίνακα ποσοστών αναπλήρωσης του άρθρου 8 Ν.4387/2016).
- **Source / verbatim quote:** karvellis-law.gr / staratalogia.gr codified table: *"0,77% (0–15), 0,84% (15,01–18), 0,90% (18,01–21), 0,96% (21,01–24), 1,03% (24,01–27), 1,21% (27,01–30), 1,98% (30,01–33), 2,50% (33,01–36), 2,55% (36,01–40), 0,50%/έτος >40"*. https://karvellis-law.gr/πίνακας-αναπλήρωσης-συντάξεων-1-10-2019/ ; https://www.syntaksi.com/ypologistis-syntaksis-efka/antapodotiki-syntaxi
- **Confidence:** High.

### WRONG-2 — worked example understates the ανταποδοτική (flat 0,77% instead of banded cumulative)
- **Verbatim (lines 35-38):**
  ```
  **Πρακτικό παράδειγμα:** Εργαζόμενος με 35 χρόνια ασφάλισης και μέσο ασφαλιστέο μηνιαίο μισθό €1.200:
  - Ανταποδοτική: €1.200 × 35 × 0,77% ≈ **€323/μήνα**
  - Εθνική σύνταξη (με 20+ χρόνια): **€386,69/μήνα**
  - **Εκτιμώμενη συνολική**: ~€710/μήνα μεικτά
  ```
- **Why wrong:** the ανταποδοτική is **not** `μισθός × έτη × 0,77%`. 0,77% is only the first-band (0–15 yrs) marginal rate; you **sum the banded marginal rates**. For 35 years the cumulative replacement rate ≈ **37,31%** (11,55% + 2,52% + 2,70% + 2,88% + 3,09% + 3,63% + 5,94% + 5,00%), not 35×0,77% = 26,95%. So ανταποδοτική ≈ €1.200 × 37,31% ≈ **€447,72/μήνα**, not €323. Both other figures are also wrong (εθνική stale — see OUTDATED-1). The example understates the worker's own pension by ~€185/mo.
- **Replacement:**
  ```
  **Πρακτικό παράδειγμα:** Εργαζόμενος με 35 χρόνια και μέσο ασφαλιστέο μισθό €1.200:
  - Ανταποδοτική: €1.200 × 37,31% (σωρευτικό ποσοστό αναπλήρωσης 35 ετών) ≈ **€448/μήνα**
  - Εθνική σύνταξη (20+ έτη, από 1.1.2026): **€446,86/μήνα**
  - **Εκτιμώμενη συνολική**: ~€895/μήνα μεικτά
  ```
- **Legal basis:** Ν.4670/2020 άρθρο 24 (banded ποσοστά αναπλήρωσης).
- **Source:** same as WRONG-1 (banded table). Cumulative arithmetic per the published bands.
- **Confidence:** High on direction/magnitude; exact €448 depends on precise band boundaries (± a few €).

### OUTDATED-1 — national pension €386,69 (appears 4× in this file)
- **Verbatim (line 37):** `- Εθνική σύνταξη (με 20+ χρόνια): **€386,69/μήνα**`
- **Verbatim (line 46):** `...ορίζεται στα **€386,69/μήνα** για όποιον έχει **20 ή περισσότερα χρόνια ασφάλισης**.`
- **Verbatim (line 51):** `Εθνική = €386,69 × (χρόνια ασφάλισης / 20)`
- **Verbatim (line 54):** `**Παράδειγμα:** 17 χρόνια → €386,69 × 17/20 = **€328,69/μήνα** εθνική σύνταξη.`
- **Why outdated/wrong:** the national pension (20 έτη) is **€446,86/μήνα from 1.1.2026** (+2,4%). €386,69 appears **nowhere** in the official trajectory (€384,00 in 2016 → €413,76 in 2023 → €426,17 in 2024 → €436,39 in 2025 → €446,86 in 2026) — it looks fabricated/misremembered, not merely stale.
- **Replacement:** `€446,86/μήνα` everywhere (20+ έτη). Recompute the 17-year example under the correct formula (see WRONG-3): **€420,05/μήνα**, not €328,69.
- **Legal basis:** εθνική σύνταξη base = Ν.4387/2016 άρθρο 7 §6; 2026 αναπροσαρμογή +2,4% = **ΚΥΑ 31854/2025 (Δ.Β.Α./οικ., 8.12.2025), ΦΕΚ Β΄6519**, ισχύς 1.1.2026.
- **Source / verbatim quote:** odigostoupoliti.eu: *"Το ποσό της εθνικής σύνταξης … €446,86 τον μήνα … από 1.1.2026 (αύξηση 2,4%)"*; insider.gr *"Στα 446,8[6] ευρώ αυξάνεται η εθνική σύνταξη το 2026"*; ΚΥΑ 31854/8-12-2025 (ΦΕΚ Β΄6519). https://www.odigostoupoliti.eu/ethniki-syntaksi-2026-eti-asfalisis-ilikia-kai-poso/
- **Confidence:** High (€446,86 confirmed by multiple independent sources + the ΚΥΑ/ΦΕΚ reference).

### WRONG-3 — the proportional-reduction formula `× (χρόνια / 20)` is invented
- **Verbatim (lines 48-54):**
  ```
  Αν έχεις **15–19 χρόνια**, η εθνική σύνταξη καταβάλλεται αναλογικά:
  Εθνική = €386,69 × (χρόνια ασφάλισης / 20)
  **Παράδειγμα:** 17 χρόνια → €386,69 × 17/20 = **€328,69/μήνα**
  ```
- **Why wrong:** the law does **not** scale linearly by `έτη/20`. Under Ν.4387/2016 art.7 §6 the national pension *"βαίνει μειούμενο κατά 2% για κάθε έτος ασφάλισης που υπολείπεται των 20 ετών"* — i.e. **−2 percentage points per year below 20**, with a **floor at 15 years = 90%**. The corpus formula gives 15 yrs = 75% (way below the legal 90%) and 17 yrs = 85% (legal is 94%). It understates every 15–19-year pension.
- **Replacement:**
  ```
  Αν έχεις 15–19 έτη, η εθνική σύνταξη μειώνεται κατά 2 ποσοστιαίες μονάδες για κάθε έτος
  κάτω από τα 20 (κατώτατο όριο τα 15 έτη = 90%):
  | Έτη ασφάλισης | Ποσοστό | Εθνική σύνταξη 2026 |
  |---|---|---|
  | 20+ | 100% | €446,86 |
  | 19  | 98%  | €437,92 |
  | 18  | 96%  | €428,99 |
  | 17  | 94%  | €420,05 |
  | 16  | 92%  | €411,11 |
  | 15  | 90%  | €402,18 |
  Κάτω από 15 έτη: καμία εθνική σύνταξη.
  ```
- **Legal basis:** Ν.4387/2016 άρθρο 7 §6 (μείωση 2%/έτος κάτω των 20, ελάχιστο 15 έτη).
- **Source / verbatim quote:** odigostoupoliti.eu: *"Το ποσό της εθνικής σύνταξης βαίνει μειούμενο κατά 2% για κάθε έτος ασφάλισης που υπολείπεται των 20 ετών"*; the 15-year figure **€402,18** confirmed for 2026 (= 90% × €446,86). https://www.odigostoupoliti.eu/ethniki-syntaksi-2026-eti-asfalisis-ilikia-kai-poso/
- **Confidence:** High. (Note: a stale cached table circulates showing €345,60 for 15 yrs — that is 90% × €384, the 2016 base, NOT the current figure. Use €402,18.)

### WRONG-4 — ΒΑΕ conditions wrong on both figures (table row + body, 2 occurrences)
- **Verbatim (line 18, table):** `| Βαρέα & ανθυγιεινά (ΒΑΕ) | 62 | 25 (εκ των οποίων 15 σε ΒΑΕ) | Πλήρης |`
- **Verbatim (line 69, body):** `...έχεις δικαίωμα πρόωρης συνταξιοδότησης στα **62 έτη** με 25 συνολικά χρόνια ασφάλισης, από τα οποία τουλάχιστον **15 σε ΒΑΕ θέσεις**.`
- **Why wrong:** the ΒΑΕ rule is measured in **ημέρες (ένσημα), not "25 χρόνια"**: **62 έτη + 4.500 ημέρες ασφάλισης συνολικά (≈15 έτη), εκ των οποίων τουλάχιστον 3.600 ημέρες (≈12 έτη) σε ΒΑΕ**, με **1.000 ημέρες ΒΑΕ την τελευταία 17ετία** πριν την αίτηση. The corpus inflates the total to "25 χρόνια" (should be ~15) and the ΒΑΕ portion to "15 έτη" (should be ~12 / 3.600 ημέρες). Both figures push workers to think they need far more heavy-work service than the law requires — the opposite of pro-worker.
- **Replacement:** `**62 έτη** με **4.500 ημέρες ασφάλισης συνολικά** (≈15 έτη), εκ των οποίων **τουλάχιστον 3.600 ημέρες (≈12 έτη) σε ΒΑΕ** και 1.000 ημέρες ΒΑΕ μέσα στην τελευταία 17ετία. (Εναλλακτική διάταξη: 10.500 ημέρες συνολικά / 7.500 σε ΒΑΕ.)`
- **Legal basis:** ΒΑΕ συνταξιοδοτικές προϋποθέσεις — Ν.3863/2010 άρθρο 17 (μεταβατικές ΒΑΕ) & πίνακας ΚΒΑΕ (ΥΑ Φ10221/οικ.26816/929/2011)· e-EFKA.
- **Source / verbatim quote:** siopi-law.gr / epoli.gr: *"4.500 ημέρες εργασίας … εκ των οποίων 3.600 σε ΒΑΕ και από αυτές, 1.000 τουλάχιστον την τελευταία 17ετία … συνταξιοδοτούνται στο 62ο έτος"*. https://siopi-law.gr/syntaxi-me-varea-ensima/ ; https://www.epoli.gr/syntaxi_barea_anthygieina_proypotheseis-a-168646.html
- **Confidence:** High.

### WRONG-5 — disability schedule missing a band and mislabels another (table row + body)
- **Verbatim (line 19, table):** `| Σύνταξη αναπηρίας | — | 5–15 (βάσει ηλικίας) | Βάσει ποσοστού αναπηρίας |` (schedule detailed in body)
- **Verbatim (lines 62-63):**
  ```
  - **Αναπηρία 67–79,9%**: Μερική σύνταξη αναπηρίας
  - **Αναπηρία 80% και άνω**: Πλήρης σύνταξη αναπηρίας
  ```
- **Why wrong:** there are **three** disability bands, and the corpus (a) omits the 50–66,99% band entirely and (b) mislabels 67–79,99% as *"μερική"* — "μερική" is the 50–66,99% band. Correct scheme: **≥80% (βαριά) → 100%**, **67–79,99% (συνήθης) → 75%**, **50–66,99% (μερική) → 50%** of the national pension. Someone at 55% disability reading this page would wrongly conclude they get nothing.
- **Replacement:**
  ```
  - **Βαριά αναπηρία (≥80%)**: πλήρης σύνταξη — 100% της εθνικής + πλήρης ανταποδοτική
  - **Συνήθης αναπηρία (67–79,99%)**: 75% της εθνικής σύνταξης
  - **Μερική αναπηρία (50–66,99%)**: 50% της εθνικής σύνταξης
  (Κατώτατο όριο θεμελίωσης: ποσοστό αναπηρίας ≥50%, πιστοποίηση αποκλειστικά από ΚΕΠΑ.)
  ```
- **Legal basis:** Ν.4387/2016 άρθρο 7 §? (εθνική σύνταξη αναπηρίας κλιμάκωση) — e-EFKA «Σύνταξη λόγω αναπηρίας / Ποσό».
- **Source / verbatim quote:** e-efka.gov.gr: *"για ποσοστό αναπηρίας από 50% μέχρι 66,99% κατά 50%, και για ποσοστό αναπηρίας από 67% μέχρι 79,99% κατά 25%"* (i.e. paid at 50% and 75% respectively; 100% at ≥80%). https://www.e-efka.gov.gr/el/sychnes-eroteseis/syntaxeis/aponomes-kyrion-syntaxeon/misthotoi/syntaxe-logo-anaperias/syntaxe-logo-anaperias-poso
- **Confidence:** High.

### WRONG-6 / OUTDATED — working-pensioner "30% cut" abolished 1.1.2024
- **Verbatim (line 90):** `...εφαρμόζεται **περικοπή 30%** για όσο διάστημα εργάζεσαι ταυτόχρονα … Εξαίρεση: όσοι έχουν **40+ χρόνια ασφάλισης** … εργάζονται χωρίς μείωση.`
- **Why wrong:** the 30% pension cut for working pensioners was **ABOLISHED from 1.1.2024** by **Art.114 Ν.5078/2023**. Pensioners now keep their **full pension** and instead pay a **non-contributory πόρος υπέρ e-ΕΦΚΑ = 10%** on their insurable earnings (μισθωτοί; μη μισθωτοί = 50% of the chosen contribution class). The "40+ years" exemption belonged to the old (abolished) regime and no longer describes the rule.
- **Replacement:**
  ```
  Από 1.1.2024 η παλιά περικοπή 30% ΚΑΤΑΡΓΗΘΗΚΕ (άρθρο 114 Ν.5078/2023). Ο εργαζόμενος
  συνταξιούχος κρατά ΟΛΟΚΛΗΡΗ τη σύνταξή του και αντ' αυτής καταβάλλει πόρο υπέρ e-ΕΦΚΑ:
  10% επί των ασφαλιστέων αποδοχών (μισθωτοί) ή 50% της επιλεγείσας ασφαλιστικής κλάσης
  (μη μισθωτοί). Ετήσιο ανώτατο όριο πόρου = 12πλάσιο της εθνικής σύνταξης. Υποχρέωση
  δήλωσης της απασχόλησης στον e-ΕΦΚΑ — πρόστιμο μη δήλωσης = 12 μηνιαίες συντάξεις.
  ```
- **Legal basis:** Άρθρο 114 Ν.5078/2023 (ΦΕΚ Α΄211/20.12.2023)· εφαρμοστική ΚΥΑ Δ.15/Δ΄/14831/2024.
- **Source / verbatim quote:** e-nomothesia.gr: *"καταργείται η περικοπή του 30% της σύνταξης … θεσπίζεται … πόρος υπέρ e-ΕΦΚΑ … 10% επί των ασφαλιστέων αποδοχών … Το συνολικό … ποσό … δεν μπορεί να υπερβαίνει το δωδεκαπλάσιο της εθνικής σύνταξης"*. https://www.e-nomothesia.gr/law-news/apaskholese-suntaxioukhon-katargeitai-i-perikopi-syntajis.html ; kepea.gr «Νέο νομικό πλαίσιο για την απασχόληση συνταξιούχων, Ν 5078/2023».
- **Confidence:** High.

### IMPRECISE-1 — "μητέρες ανηλίκων 62/20, μειωμένη κατά 1/200 ανά μήνα"
- **Verbatim (line 17, table):** `| Μητέρες ανηλίκων τέκνων | 62 | 20 | Μειωμένη κατά 1/200 ανά μήνα πριν τα 67 |`
- **Why imprecise:** the 62 + 20-year (6.000 ημέρες) threshold for mothers of minors is supported, but the flat "always μειωμένη κατά 1/200 ανά μήνα πριν τα 67" is an over-simplification. Whether a mother of a minor gets **full or reduced** pension at 62 depends heavily on the **year rights were vested (θεμελίωση)** (the pre-2013 Ν.3863/2010 art.10 windows allowed full — even earlier — exits for vested mothers). The 1/200-per-month reduction is the generic reduced-pension penalty; applying it uniformly here misstates the many full-pension vested cases.
- **Replacement:** `Μητέρες ανηλίκων: **62 έτη / 6.000 ημέρες (20 έτη)** — πλήρης ή μειωμένη ανάλογα με το έτος θεμελίωσης του δικαιώματος (ειδικές μεταβατικές διατάξεις για θεμελίωση πριν το 2013). Στη μειωμένη εφαρμόζεται μείωση 1/200 ανά μήνα αναμονής. Ζήτησε ατομικό υπολογισμό από τον e-ΕΦΚΑ.`
- **Legal basis:** Ν.3863/2010 άρθρο 10 (μεταβατικές μητέρων ανηλίκων)· Ν.4336/2015 (νέα όρια)· e-EFKA.
- **Source:** kepea.gr «Εγκύκλιος … συνταξιοδότηση μητέρων με ανήλικα»; aftodioikisi.gr «Πρόωρη σύνταξη για γονείς ανηλίκων». https://www.aftodioikisi.gr/ergasiaka-asfalistika/asfalistika/proori-syntaxi-gia-goneis-anilikon-oles-oi-proypotheseis/
- **Confidence:** Medium (core 62/20 supported; the reduced-vs-full nuance is the imprecision).

### IMPRECISE-2 — ΒΑΕ "χορηγεί πλασματικά έτη" (loose terminology)
- **Verbatim (line 78):** `Η εργασία σε ΒΑΕ επαγγέλματα χορηγεί επίσης **πλασματικά έτη** (bonus ημέρες ασφάλισης)...`
- **Why imprecise:** ΒΑΕ work grants a **προσαύξηση / bonus ημέρες** in the count, but calling these *"πλασματικά έτη"* muddles them with the bought/notional years covered in `exagora-ensemon.md` (those are recognised by purchase; the ΒΑΕ bonus is automatic from the βαρέα ένσημα). Substance OK, label loose.
- **Replacement:** `…χορηγεί επίσης **προσαύξηση (bonus ημέρες ασφάλισης)** που μετρούν επιπλέον στον χρόνο ασφάλισης — δεν είναι το ίδιο με τα εξαγοραζόμενα πλασματικά έτη.`
- **Legal basis / source:** oergatologos.gr «Βαρέα Ένσημα & Προσαύξηση Σύνταξης 2025». https://oergatologos.gr/ (βαρέα ένσημα / προσαύξηση)
- **Confidence:** Medium-High.

### IMPRECISE-3 — disability minimum insurance days ("300 έως 4.500 βάσει ηλικίας")
- **Verbatim (line 65):** `...πχ. από 300 ημέρες για νεότερους εργαζόμενους έως 4.500 ημέρες για μεγαλύτερης ηλικίας.`
- **Why imprecise:** broadly correct but simplified — the actual rule is a **sliding scale (300 ημέρες minimum, +120 ημέρες/έτος από το 21ο έτος, ανώτατο ~4.200/4.500), PLUS "πρόσφατη ασφάλιση" requirements** (ημέρες μέσα στην τελευταία 5ετία). Not wrong, but a worker can't self-assess eligibility from the stated range alone.
- **Replacement:** add the "recent insurance" (πρόσφατη ασφάλιση, π.χ. 1.500 ημέρες την τελευταία 5ετία) qualifier and the +120/έτος scaling.
- **Legal basis / source:** e-EFKA «Σύνταξη λόγω αναπηρίας / Προϋποθέσεις απονομής». https://www.e-efka.gov.gr/el/syntaxe-logo-anaperias-0
- **Confidence:** Medium.

### UNVERIFIABLE-1 — ΒΑΕ occupation list (indicative categories)
- **Verbatim (lines 72-76):** underground miners, asbestos/toxic-substance workers, certain night-industry workers, ionising-radiation workers, X-ray operators.
- **Assessment:** these are plausible ΒΑΕ categories but the **authoritative list is the ΚΒΑΕ table (ΥΑ Φ10221/οικ.26816/929/2011)** by ΚΑΔ/specialty, not a free-text list. Presented as "τυπικές κατηγορίες" it is defensible; do not assert it is exhaustive or that any listed role is automatically ΒΑΕ. Left UNVERIFIABLE (indicative, not a legal enumeration).
- **Confidence:** n/a (flagged, not asserted).

---

## FILE 2 — `syntaxi/exagora-ensemon.md`

### OK claims
- **Σπουδές τριτοβάθμιας: έως 4 έτη, ένας τίτλος, όχι μεταπτυχιακά/επιπλέον έτη φοίτησης.** OK (aligns with Art.34 recognisable-time rules).
- **Στρατιωτική θητεία: ολόκληρη η υποχρεωτική θητεία αναγνωρίζεται.** OK.
- **Εργασία εξωτερικού (ΕΕ/διμερείς): αθροίζεται μέσω συντονισμού, ΔΕΝ είναι χρηματική εξαγορά, Καν.(ΕΕ) 883/2004.** OK (correct distinction).
- **«Η εξαγορά δεν ακυρώνεται / δεν επιστρέφεται μετά την καταβολή· κάνε τα νούμερα πριν πληρώσεις.»** OK (sound warning).

### IMPRECISE-1 — cost formula underspecified; the real basis is 20% of monthly earnings
- **Verbatim (lines 29-35):**
  ```
  Το κόστος καθορίζεται με υπουργική απόφαση και ορίζεται τυπικά ως:
  Κόστος = τρέχων μέσος ημερήσιος μισθός × συντελεστής × αριθμός ημερών προς εξαγορά
  Ο συντελεστής και ο ακριβής τρόπος υπολογισμού αλλάζουν περιοδικά με υπουργικές αποφάσεις.
  ```
- **Why imprecise:** the cost is not an open "συντελεστής που αλλάζει με ΥΑ" — it is **fixed in primary law: 20% of the insured's earnings** (μισθωτοί: 20% επί των αποδοχών του τελευταίου μήνα πλήρους απασχόλησης πριν την αίτηση), per **άρθρο 34 Ν.4387/2016**. Leaving it as an unknown ministerial coefficient discourages workers from computing it themselves.
- **Replacement:** `Το μηνιαίο κόστος εξαγοράς για τον κλάδο κύριας σύνταξης = **20% επί των αποδοχών** του ασφαλισμένου (μισθωτοί: αποδοχές τελευταίου μήνα πλήρους απασχόλησης πριν την αίτηση· μη μισθωτοί: 20% επί της επιλεγείσας ασφαλιστικής κατηγορίας). Άρθρο 34 Ν.4387/2016.`
- **Legal basis:** Άρθρο 34 Ν.4387/2016 (όπως τροποποιήθηκε από Ν.4670/2020).
- **Source / verbatim quote:** e-a.gr / e-EFKA «Αναγνώριση πλασματικών ετών»: *"το μηνιαίο κόστος εξαγοράς … προσδιορίζεται για τους μισθωτούς σε ποσοστό 20% επί των αποδοχών του ασφαλισμένου κατά τον τελευταίο μήνα πλήρους απασχόλησης πριν από την υποβολή του αιτήματος"*. https://www.e-efka.gov.gr/el/sychnes-eroteseis/asphalisi-eisphores/asphalismenoi/anagnorise-plasmatikon-eton
- **Confidence:** High.

### IMPRECISE-2 — payment options incomplete
- **Verbatim (line 35):** `Το ποσό μπορεί να καταβληθεί **εφάπαξ ή σε δόσεις** — ρώτα τον ΕΦΚΑ...`
- **Why imprecise:** omits the **lump-sum discount (−2% ανά έτος εξαγοράς)** and the option to **deduct the cost from the pension (κράτηση έως ¼ της σύνταξης)** — both worker-favourable and material to the "συμφέρει ή όχι" analysis the article builds.
- **Replacement:** add: `**Εφάπαξ** (με έκπτωση 2% για κάθε έτος που εξαγοράζεται), **σε δόσεις** (ισάριθμες με τους μήνες που αναγνωρίζονται), ή **παρακράτηση έως το ¼ της σύνταξης** μετά τη συνταξιοδότηση.`
- **Legal basis:** Άρθρο 34 Ν.4387/2016 (τρόποι καταβολής).
- **Source:** e-EFKA «Αναγνώριση πλασματικών ετών» (τρόποι εξόφλησης). Same URL as IMPRECISE-1.
- **Confidence:** Medium-High.

### IMPRECISE-3 — legislation block should pin Άρθρο 34
- **Verbatim (lines 67-69):** `- **Ν. 4387/2016** — … άρθρα περί αναγνώρισης χρόνων ασφάλισης` / `- **Ν. 4670/2020** — … επικαιροποίηση διατάξεων πλασματικών χρόνων`
- **Replacement:** name the article: `**Ν.4387/2016 άρθρο 34** (αναγνώριση/εξαγορά πλασματικού χρόνου, κόστος 20%), όπως τροποποιήθηκε από **Ν.4670/2020**.`
- **Confidence:** High.

### UNVERIFIABLE-1 — "μερική απασχόληση top-up" as a recognisable πλασματικό
- **Verbatim (lines 21-22):** `**3. Περίοδοι μερικής απασχόλησης σε μειωμένο ημερομίσθιο** — … μπορείς να εξαγοράσεις τη διαφορά … «ανεβάσεις» την ασφάλιση στο επίπεδο πλήρους απασχόλησης.`
- **Assessment:** "topping up" part-time days to full-time is **not one of the standard Art.34 πλασματικά categories** (military, studies, τέκνα, γονική άδεια, ανεργία/απεργία, εκπαιδευτική άδεια, μάχιμη πενταετία, κενά μεταξύ φορέων). Could not confirm it as a recognised εξαγορά head against a primary source. Flag UNVERIFIABLE — either drop it or reclassify as προαιρετική συνέχιση ασφάλισης, which is a different mechanism.
- **Confidence:** Medium (absence-of-basis, not a positive refutation).

### GAP — well-established πλασματικά categories are MISSING
- **Problem:** the article lists only 4 categories and omits the most commonly used, worker-relevant ones under Art.34: **χρόνος τέκνων (1 έτος για το 1ο, έως 5 έτη συνολικά για 3+ τέκνα)**, **γονική άδεια ανατροφής**, **χρόνος ανεργίας / επιδότησης ανεργίας (έως 300 ημέρες ιδιωτικός τομέας)**, **χρόνος απεργίας**, **εκπαιδευτική άδεια**, **κενά μεταξύ ασφαλιστικών φορέων**, and **μάχιμη πενταετία** (ένστολοι). These are exactly the years that let parents and precarious workers hit thresholds — a pro-worker page must list them.
- **Legal basis:** Άρθρο 34 Ν.4387/2016 (κατάλογος αναγνωρίσιμων χρόνων).
- **Source:** e-a.gr / e-EFKA πλασματικά categories: *"στρατιωτική θητεία, σπουδές, χρόνος παιδιών, γονικές άδειες, χρόνος απεργίας ή ανεργίας (έως 300 ημέρες στον ιδιωτικό τομέα), μάχιμη πενταετία για ένστολους"*. https://www.e-a.gr/ (Οδηγός πλασματικών ετών)
- **Confidence:** High.

---

## FILE 3 — `syntaxi/index.md`

### OK claims
- **Two independent parts (εθνική + ανταποδοτική) that sum.** OK.
- **Εθνική = κρατική, ανεξάρτητη από μισθό; ανταποδοτική = βάσει εισφορών.** OK.
- **Ανταποδοτική βασίζεται στον μέσο ασφαλιστέο μισθό όλης της καριέρας.** OK.
- **Μη καταβληθείσες εισφορές μειώνουν τη σύνταξη· έλεγξε ιστορικό / κατάγγειλε.** OK (militant, accurate).
- **Table: Κανονική ηλικία 67.** OK.
- **Table: Ελάχιστα 15 χρόνια.** OK.
- **Table: Πρόωρη πλήρης 62 / 40 χρόνια.** OK.

### OUTDATED-1 — national pension €386,69 (2 occurrences)
- **Verbatim (line 17):** `Ορίζεται σε **€386,69/μήνα** για εργαζόμενους με 20 ή περισσότερα χρόνια ασφάλισης.`
- **Verbatim (line 34, table):** `| Εθνική σύνταξη πλήρης | €386,69/μήνα με 20+ χρόνια |`
- **Replacement:** `€446,86/μήνα (20+ έτη, από 1.1.2026)`.
- **Legal basis / source:** ΚΥΑ 31854/2025 (ΦΕΚ Β΄6519), ισχύς 1.1.2026 — same as FILE 1 OUTDATED-1.
- **Confidence:** High.

### WRONG-1 — proportional formula `× (χρόνια / 20)`
- **Verbatim (line 35, table):** `| Εθνική σύνταξη αναλογική | €386,69 × (χρόνια / 20) για 15–19 χρόνια |`
- **Why wrong:** same invented linear formula as FILE 1 WRONG-3. Legal rule = −2 μονάδες/έτος κάτω των 20, floor 90% at 15 έτη.
- **Replacement:** `| Εθνική σύνταξη αναλογική | −2% ανά έτος κάτω των 20 (15 έτη = 90% = €402,18· 17 έτη = 94% = €420,05) |`
- **Legal basis / source:** Ν.4387/2016 άρθρο 7 §6 — same as FILE 1 WRONG-3.
- **Confidence:** High.

### WRONG-2 — ΒΑΕ 62 / 25 (15 σε ΒΑΕ)
- **Verbatim (line 36, table):** `| ΒΑΕ (βαρέα & ανθυγιεινά) | 62 έτη με 25 χρόνια (15 σε ΒΑΕ) |`
- **Why wrong:** same error as FILE 1 WRONG-4. Correct: 62 / **4.500 ημέρες (≈15 έτη), εκ των οποίων ≥3.600 ημέρες (≈12 έτη) σε ΒΑΕ**.
- **Replacement:** `| ΒΑΕ | 62 έτη / 4.500 ημέρες (≈15 έτη), εκ των οποίων ≥3.600 ημέρες (≈12 έτη) σε ΒΑΕ |`
- **Legal basis / source:** same as FILE 1 WRONG-4 (siopi-law.gr / epoli.gr / e-EFKA).
- **Confidence:** High.

### OUTDATED-2 — "αναλογικό μέρος" wording carries the stale base
- **Verbatim (line 19):** `Αν έχεις 15–19 χρόνια, λαμβάνεις αναλογικό μέρος της.`
- **Why outdated/imprecise:** conceptually the word "αναλογικό" invites the wrong linear reading; and the underlying base (€386,69) is stale. Reword to the −2%/έτος rule with the €446,86 base.
- **Replacement:** `Αν έχεις 15–19 έτη, μειώνεται κατά 2 μονάδες για κάθε έτος κάτω των 20 (κατώτατο 90% στα 15 έτη = €402,18). Κάτω από 15 έτη: καμία εθνική σύνταξη.`
- **Confidence:** High.

### IMPRECISE-1 — μητέρες ανηλίκων 62/20 (μειωμένη)
- **Verbatim (line 37, table):** `| Μητέρες ανηλίκων | 62 έτη με 20 χρόνια (μειωμένη σύνταξη) |`
- **Why imprecise:** same nuance as FILE 1 IMPRECISE-1 — 62/20 (6.000 ημέρες) is right, but "μειωμένη" is not universal (depends on θεμελίωση year).
- **Replacement:** `| Μητέρες ανηλίκων | 62 έτη / 6.000 ημέρες — πλήρης ή μειωμένη ανάλογα με το έτος θεμελίωσης |`
- **Confidence:** Medium.

---

## CROSS-CUTTING FINDINGS
1. **€386,69 is fiction across the whole batch** (6+ occurrences over 2 files). It is neither current nor a past official value — replace with **€446,86** (20+ έτη, from 1.1.2026, ΚΥΑ 31854/2025, ΦΕΚ Β΄6519) everywhere, and rebuild the 15–19-year sub-table on the **−2%/έτος, floor 90% = €402,18** rule.
2. **The `×(έτη/20)` formula is invented** and understates every partial-service national pension — appears in both `ilikia-syntaxis.md` and `index.md`. Fix in lockstep with #1.
3. **ΒΑΕ in ημέρες, not "χρόνια"** — the "25 / 15 σε ΒΑΕ" error is duplicated in both files. Correct to 4.500 / ≥3.600 ημέρες.
4. **Working-pensioner regime is a whole generation out of date** — the 30% cut is gone (1.1.2024, Art.114 Ν.5078/2023). This is the corpus's newest-cited law, yet the file describes the pre-2024 world.
5. **Disability schedule** — restore the missing 50–66,99% (μερική→50%) band and relabel 67–79,99% as "συνήθης→75%".
6. **Ν.4670/2020 under-credited** — it, not just Ν.4387/2016, sets the current accrual scale (0,77–2,55%) and the πλασματικά cost mechanics; add it to citations where accrual/εξαγορά are discussed.

## GAPS / NEW-ARTICLE CANDIDATES
The `syntaxi/` folder covers only main-pension age/conditions, buy-back and a landing page. Missing whole pillars of the system (each has a confirmed legal basis — Phase D candidates):
- **Επικουρική σύνταξη / ΤΕΚΑ** — Ν.4826/2021 (κεφαλαιοποιητικό, 3%+3%, υποχρεωτικό για νεοεισερχόμενους από 1.1.2022; pre-2022 παραμένουν στο διανεμητικό ex-ΕΤΕΑΕΠ μέσω e-ΕΦΚΑ). → `syntaxi/epikouriki-teka.md`
- **Εφάπαξ** — Άρθρο 35 Ν.4387/2016. → `syntaxi/efapax.md`
- **Σύνταξη θανάτου / χηρείας (survivor's)** — Άρθρο 12 Ν.4387/2016 (am. Ν.4670/2020): **σύζυγος 70%** (από 50%), κανόνας 3ετούς γάμου, μείωση σε 35% μετά την 3ετία αν εργάζεται/έχει δική του σύνταξη (πλήρες 70% αν ≥67% ανάπηρος), τέκνα 25% έκαστο έως 24 ετών, ανώτατο άθροισμα = η σύνταξη του θανόντος. → `syntaxi/syntaxi-thanatou.md`
- **Working-pensioner 10% πόρος** — could be its own section/article given how many workers this affects (Art.114 Ν.5078/2023).

## UNVERIFIABLE / NOT ASSERTED
- ΒΑΕ occupation enumeration (FILE 1) — indicative only; authoritative source is the ΚΒΑΕ table (ΥΑ Φ10221/οικ.26816/929/2011), not asserted as exhaustive.
- "Μερική απασχόληση top-up" as an Art.34 εξαγορά head (FILE 2) — no primary basis found; likely a conflation with προαιρετική συνέχιση ασφάλισης.
- Exact 2026 15-year national-pension figure quoted as **€402,18** (= 90% × €446,86); one stale cached table shows €345,60 (= 90% × the 2016 base €384) — do NOT use €345,60.
- Precise cumulative accrual for the 35-year example (~37,31% → ~€448) depends on exact band boundaries; direction and magnitude are firm, the cent-level figure is not.

## SOURCES (primary/authoritative)
- e-efka.gov.gr — disability pension bands (100/75/50%); αναγνώριση πλασματικών ετών (20% cost, τρόποι εξόφλησης); disability eligibility days.
- e-nomothesia.gr — Art.114 Ν.5078/2023 (30% cut abolished → 10% πόρος, cap 12× εθνική).
- odigostoupoliti.eu — national pension €446,86 (2026) + "−2% ανά έτος κάτω των 20" rule + €402,18 at 15 yrs; ΚΥΑ 31854/2025, ΦΕΚ Β΄6519.
- insider.gr — εθνική σύνταξη 2026 uplift confirmation.
- siopi-law.gr / epoli.gr — ΒΑΕ conditions (4.500 / ≥3.600 / 1.000-in-17yr; alt 10.500 / 7.500).
- karvellis-law.gr / syntaksi.com / staratalogia.gr — ποσοστά αναπλήρωσης scale 0,77–2,55% (Ν.4670/2020 art.24).
- e-a.gr / e-EFKA — πλασματικά categories & 20% cost basis (Art.34 Ν.4387/2016).
- kepea.gr (ΓΣΕΕ) — working-pensioner Ν.5078/2023 framework; μητέρες ανηλίκων εγκύκλιος.
- aftodioikisi.gr — μητέρες/γονείς ανηλίκων προϋποθέσεις.

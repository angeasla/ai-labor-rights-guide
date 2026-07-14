# AUDIT LEDGER — Batch `adeies-other`

**Auditor role:** εργατολόγος (Greek labour-law fact-check), militant pro-worker voice
**Date:** 2026-07-13
**Files:** `src/main/resources/docs/adeies/{etisia-adia, astheneia, apozimiossi-adias, adia-gamos, eidikes-adeies, index}.md`
**Method:** every checkable claim extracted → verified vs CURRENCY-BRIEF §6 + fresh fetch of hli.gov.gr (Επιθεώρηση Εργασίας / ΠΙΝΑΚΑΣ ΑΔΕΙΩΝ), e-efka.gov.gr, taxheaven.gr (verbatim ΦΕΚ text of Ν.4808/2021), kepea.gr/ot.gr (ΕΓΣΣΕ + ΚΥΑ mirrors). No corpus files edited.

## Primary sources fetched (2026-07-13)

- Annual-leave day counts: https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/adeies-ergasiakes-scheseis/etisia-kanoniki-adeia/imeres-adeias/
- Leave splitting (κατάτμηση): kepea.gr/katatmisi-adeias · https://www.taxheaven.gr/news/71800 (mirrors art.61 Ν.4808/2021)
- Exam leave: https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/adeies-ergasiakes-scheseis/loipes-adeies/adeia-exetaseon/
- Bereavement leave: https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/adeies-ergasiakes-scheseis/loipes-adeies/adeia-logo-thanatou-syngenous/
- Blood-donation leave (private sector): kepea.gr/article.php?id=1656 (ΕΓΣΣΕ)
- Election leave (2023 ΚΥΑ): https://www.ot.gr/2023/04/20/... · taxheaven.gr/news/63507
- Sickness allowance: https://www.e-efka.gov.gr/el/sychnes-eroteseis/paroches-kai-ygeia/paroches-se-chrema/epidoma-astheneias/epidoma-astheneias-misthoton
- Verbatim ΦΕΚ text: Ν.4808/2021 art.29 https://www.taxheaven.gr/law/4808/2021/arthro/29 · art.30 /arthro/30 · art.37 /arthro/37 · art.38 /arthro/38 · art.39 /arthro/39 · art.42 /arthro/42 (+ opengov.gr/minlab/?p=4935) · art.43 /arthro/43

---

## FILE 1 — `etisia-adia.md` (Ετήσια Άδεια)

| # | Claim (line) | Verdict |
|---|---|---|
| 1 | Δικαίωμα ετήσιας άδειας, βάση ΑΝ 539/1945 (L9-11) | **OK** |
| 2 | 5ήμερο, ≤1 έτος → αναλογικά 1,67 ημ./μήνα (L19) | **OK** |
| 3 | 5ήμερο, «Από 1 έτος και άνω → **21 ημέρες**» (L20) | **IMPRECISE** (21 = μόνο 2ο έτος) |
| 4 | 5ήμερο, «10 έτη ίδιος / 12 συνολικά → **22 ημέρες**» (L21) | **WRONG** (→ 25) |
| 5 | 6ήμερο, ≤1 έτος → αναλογικά 2 ημ./μήνα (L27) | **OK** |
| 6 | 6ήμερο, «Από 1 έτος και άνω → **25 ημέρες**» (L28) | **IMPRECISE** (25 = μόνο 2ο έτος) |
| 7 | 6ήμερο, «10 έτη ίδιος / 12 συνολικά → **26 ημέρες**» (L29) | **WRONG** (→ 30) |
| 8 | Επίδομα άδειας = 50% μηνιαίου, cap 15 ημ. μισθωτοί / 13 ημερομ. (L36-39) | **OK** |
| 9 | Χορήγηση εντός ημερολογιακού έτους (L43) | **OK** |
| 10 | Ασθένεια στη διάρκεια άδειας «παγώνει» (ΑΠ 1351/2009, ΔΕΕ C-277/08) (L62-69) | **OK** |
| 11 | Μεταφορά: ΑΝ 539/1945 + Ν.4554/2018 (L73) | **IMPRECISE** (λείπει Ν.4808 art.61) |
| 12 | Απαγόρευση εξαγοράς άδειας εν ισχύι συμβάσεως (L78) | **OK** |
| 13 | Αποζημίωση στη λύση = ημέρες × ημερήσιο μισθό (L84-86) | **OK** |
| 14 | 5ετής παραγραφή από τη λύση (L88) | **OK** |
| 15 | Κατάτμηση: ένα τμήμα «**12 ή περισσότερες συνεχόμενες ημερολογιακές ημέρες**» (L92) | **WRONG** |
| 16 | Βιβλίο Αδειών, έλεγχος ΣΕΠΕ (L96-106) | **OK** (ΣΕΠΕ naming dated) |
| 17 | Οικιακοί μισθωτοί 26 εργάσιμες ημ. (Ν.4488/2017) (L112) | **UNVERIFIABLE** |
| 18 | Κυρώσεις: διπλάσια αποζημίωση + ΣΕΠΕ **350–500 €**/εργαζ. + ποινικά· Ν.4488/2017 art.36 (L119-125) | **IMPRECISE / UNVERIFIABLE** |

**Verdict tally:** OK 10 · WRONG 3 · IMPRECISE 3 · UNVERIFIABLE 2

### Non-OK detail

**#3, #4, #6, #7 — WRONG/IMPRECISE (confidence: HIGH)** — the headline error of the file: it caps leave far below the law and robs long-tenured workers of up to 4 (5ήμερο) / 5 (6ήμερο) days per year.
- Snippet (verbatim, 5ήμερο): `| Από 1 έτος και άνω | **21 ημέρες** |` / `| Από 10 έτη στον ίδιο εργοδότη ή 12 έτη συνολικά | **22 ημέρες** |`
- Snippet (verbatim, 6ήμερο): `| Από 1 έτος και άνω | **25 ημέρες** |` / `| Από 10 έτη στον ίδιο εργοδότη ή 12 έτη συνολικά | **26 ημέρες** |`
- Problem: the corpus assigns 22/26 to the 10-έτη tier and has **no tier above it**. The Επιθεώρηση Εργασίας table gives a five-step ladder. Corrected values:

  | Προϋπηρεσία | 5ήμερο (εργάσιμες) | 6ήμερο (εργάσιμες) |
  |---|---|---|
  | 1ο έτος (αναλογικά) | 20 | 24 |
  | 2ο έτος | 21 | 25 |
  | 3ο έτος και εφεξής | 22 | 26 |
  | **10 έτη στον ίδιο / 12 συνολικά** | **25** | **30** |
  | **25 έτη** | **26** | **31** |

- Basis: **ΑΝ 539/1945** as amended (Ν.3302/2004, Ν.4093/2012 for the 25-year day); the 25/26 & 30/31 steps are the standing Επιθεώρηση Εργασίας reading.
- Source: https://www.hli.gov.gr/.../etisia-kanoniki-adeia/imeres-adeias/
- Greek quote: «Μετά τη συμπλήρωση **10 ετών** υπηρεσίας στον ίδιο εργοδότη ή **12 ετών** σε οποιονδήποτε εργοδότη… **25 εργάσιμες ημέρες** (πενθήμερο) / **30 εργάσιμες ημέρες** (εξαήμερο)… μετά τη συμπλήρωση **25 ετών**… μία (1) επιπλέον εργάσιμη ημέρα» (→ 26 / 31).

**#15 — WRONG (confidence: HIGH)**
- Snippet (verbatim): `τουλάχιστον **ένα τμήμα πρέπει να είναι 12 ή περισσότερες συνεχόμενες ημερολογιακές ημέρες** (συμπεριλαμβανομένων Σαββατοκύριακων)`
- Problem: the statute counts **εργάσιμες** (working) days, not ημερολογιακές, and the minimum differs by week system: **12 εργάσιμες for 6ήμερο, 10 εργάσιμες for 5ήμερο** (12 for legally-working minors). Calling them "calendar days incl. weekends" understates the guaranteed continuous rest.
- Replacement: `…ένα τμήμα πρέπει να περιλαμβάνει τουλάχιστον 10 εργάσιμες ημέρες (5ήμερο) ή 12 εργάσιμες ημέρες (6ήμερο)`.
- Basis: **ΑΝ 539/1945 art.4 §1** as amended by Ν.3846/2010 art.6; carry-over to Q1 next year **Ν.4808/2021 art.61**.
- Source: kepea.gr/katatmisi-adeias · https://www.taxheaven.gr/news/71800
- Greek quote: «η μία [περίοδος] να περιλαμβάνει τουλάχιστον **12 εργάσιμες ημέρες** επί εξαημέρου ή **10 εργάσιμες ημέρες** επί πενθημέρου… κατόπιν έγγραφης αίτησης του εργαζομένου».

**#11 — IMPRECISE (confidence: HIGH):** carry-over is no longer only "within the year." **Ν.4808/2021 art.61** lets untaken leave be granted **up to the first quarter (τρίμηνο) of the following year**. Add it — it defeats the "use-it-or-lose-it" pressure employers apply.

**#16 — naming OUTDATED (confidence: HIGH):** "**ΣΕΠΕ**" / "sepe.gr" was replaced by the independent authority **«Επιθεώρηση Εργασίας»** (Ν.4808/2021 arts 101 ff.; portal **hli.gov.gr**). Recurs in #18 and in `astheneia.md`, `apozimiossi-adias.md`, `adia-gamos.md` — fix batch-wide. The **1555** service line is correct.

**#17 — UNVERIFIABLE (confidence: MEDIUM):** the specific "26 εργάσιμες ημέρες/έτος" for οικιακοί μισθωτοί under Ν.4488/2017 could not be confirmed against a primary source; Ν.4488/2017 extended labour-law coverage to domestic workers but the day figure is unconfirmed. Do not assert without a source.

**#18 — IMPRECISE / UNVERIFIABLE (confidence: MEDIUM):** the **διπλάσια** (100% surcharge) for culpable non-provision is real (ΑΝ 539/1945 art.5 §1 as am. Ν.3302/2004). The **"350–500 €/εργαζόμενο"** figure and the **"Ν.4488/2017 άρθρο 36"** citation are unconfirmed — ΣΕΠΕ/Επιθεώρηση fines are set by ΥΑ and vary by violation category; flag, don't assert the range.

---

## FILE 2 — `astheneia.md` (Άδεια Ασθένειας)

| # | Claim (line) | Verdict |
|---|---|---|
| 1 | Αναρρωτική άδεια με παροχές ΕΦΚΑ — υποχρέωση, όχι χάρη (L8-9) | **OK** |
| 2 | Πρώτες 3 ημέρες: εργοδότης 50% ημερομισθίου (ημέρες αναμονής) (L19,34) | **OK** |
| 3 | Από 4η ημέρα: επίδομα ΕΦΚΑ (L20) | **OK** |
| 4 | Ύψος ΕΦΚΑ: 50% (1–15 ημ.) / 50% (16+ ημ.) (L24-27,41) | **IMPRECISE** |
| 5 | Ελάχιστες ημέρες: «**100 ημέρες στα τελευταία 2 χρόνια (ή 200 συνολικά)**» (L29) | **WRONG** |
| 6 | Προϋπόθεση 10 ημερών εργασίας για ημέρες αναμονής, ΑΚ 657-658 (L34-36) | **OK** |
| 7 | Εργατικό ατύχημα: καμία ημέρα αναμονής, **100%** ημερομισθίου (L53-54) | **IMPRECISE** |
| 8 | Αναγγελία ατυχήματος στον ΕΦΚΑ εντός 24 ωρών (L59) | **OK** |
| 9 | Μακροχρόνια: έως 12 μήνες/επεισόδιο, παράταση έως 24 (L66) | **IMPRECISE** |
| 10 | Σύμβαση αναστέλλεται έως 12 μήνες· απαγόρευση απόλυσης λόγω ασθένειας (L72) | **IMPRECISE** |
| 11 | Νομοθεσία: ΑΝ 1846/1951, Ν.4387/2016, ΑΚ 657-658 (L76-79) | **OK** (add ΑΝ 178/1967) |
| 12 | (Υποχρέωση εργοδότη να συμπληρώνει τον μισθό ολόκληρο, ΑΚ 657-658) | **GAP — MISSING** |

**Verdict tally:** OK 6 · WRONG 1 · IMPRECISE 4 · GAP 1

### Non-OK detail

**#5 — WRONG (confidence: HIGH)**
- Snippet (verbatim): `Ελάχιστες ημέρες ασφάλισης για δικαίωμα: **100 ημέρες** στα τελευταία 2 χρόνια (ή 200 συνολικά).`
- Problem: for μισθωτούς (ex-ΙΚΑ) the requirement is **120 ημέρες ασφάλισης** either in the **previous calendar year** or in the **previous 15 months** (excluding the last quarter). "100 days" is the special threshold only for **ΤΑΞΙ**-insured; "2 years / 200 total" has no basis for the general case.
- Replacement: `120 ημέρες ασφάλισης το προηγούμενο ημερολογιακό έτος ή το προηγούμενο 15μηνο (χωρίς τους 3 τελευταίους μήνες).`
- Basis: **ΑΝ 1846/1951** as amended; e-EFKA administrative practice.
- Source: https://www.e-efka.gov.gr/.../epidoma-astheneias-misthoton
- Greek quote: «θα πρέπει να έχουν συμπληρώσει **120 τουλάχιστον ημέρες εργασίας** είτε κατά το προηγούμενο ημερολογιακό έτος, είτε το προηγούμενο 15μηνο».

**#12 — GAP / MISSING (confidence: HIGH)** — a serious pro-worker omission.
- The file implies that from day 4 the worker gets only the ΕΦΚΑ 50%. In reality the employer owes, under **ΑΚ 657-658**, the wage for the whole short-illness period — **up to one (1) month if service ≥1 year, otherwise half a month** — and may only **deduct** (συμψηφισμός, ΑΚ 659) what the ΕΦΚΑ pays. Net effect: the worker keeps **full pay** for that period, employer pays the difference.
- Add this. Source: e-efka / kepea confirm: «για τις υπόλοιπες ημέρες [ο εργοδότης καταβάλλει] τη διαφορά μεταξύ του ημερομισθίου και του επιδόματος ασθενείας που καταβάλλει ο ΕΦΚΑ».

**#4 — IMPRECISE (confidence: HIGH):** the benefit is **50% του τεκμαρτού ημερομισθίου της ασφαλιστικής κλάσης**, **+10% ανά προστατευόμενο μέλος**, and the **first 15 days are capped** ("50% του καθοριζόμενου ποσού"). The flat "50%" table omits the dependant supplements and the 15-day cap.
- Greek quote: «Το 50% του τεκμαρτού ημερομισθίου… προσαυξημένο κατά **10% για κάθε προστατευόμενο μέλος**».

**#9 — IMPRECISE (confidence: HIGH):** duration is **day-based**, not "12/24 months per episode": **έως 182 ημέρες**, extended to **έως 360** (and **έως 720 ημέρες for the same illness**) depending on accumulated ασφάλιση. Restate in days.
- Greek quote: «έως 182 ημέρες… ή έως 360 ή έως 720 ημέρες για την ίδια πάθηση».

**#7 — IMPRECISE (confidence: MEDIUM):** the "no waiting period / paid from day 1" for εργατικό ατύχημα is correct, but the **"100% ημερομισθίου"** figure is unconfirmed — the accident benefit is still computed on the ασφαλιστική-κλάση formula (paid from day 1, without the insurance-days precondition). Flag the 100% as unverified.

**#10 — IMPRECISE (confidence: MEDIUM):** dismissal purely for illness absence is indeed abusive/void, but the "contract suspended for up to 12 months" is not accurate: absence is protected within the **βραχείας ασθενείας** limits tied to tenure (roughly 1 μήνα ≤4 έτη, 3 μήνες 4-10, 4 μήνες 10-15, 6 μήνες >15 έτη); beyond them prolonged absence may be treated as deemed resignation. Reframe around these limits (confirm the exact tiers before publishing).

**#11 — OK, add basis (confidence: HIGH):** the 3-day / 50% employer rule for εργατοτεχνίτες rests on **ΑΝ 178/1967**; add it alongside ΑΚ 657-658.

---

## FILE 3 — `apozimiossi-adias.md` (Αποζημίωση Μη Ληφθείσας Άδειας)

| # | Claim (line) | Verdict |
|---|---|---|
| 1 | Αποζημίωση = αποδοχές άδειας + επίδομα άδειας (50%) (L15-17) | **OK** |
| 2 | Παράδειγμα €1.200/μήνα → ημερήσιος €48 (÷25); 10 ημ. → €480 + €240 = €720 (L20-24) | **OK** |
| 3 | Οφείλεται ανεξαρτήτως λόγου αποχώρησης (απόλυση/παραίτηση/λήξη) (L36-43) | **OK** |
| 4 | Ρήτρα «ολοσχερούς εξόφλησης» άκυρη για αναγκαστικά δικαιώματα (L47-49) | **OK** |
| 5 | 5ετής παραγραφή (ΑΚ 250) από τη λύση (L51-53) | **OK** |
| 6 | Βήματα: εξώδικο → ΣΕΠΕ → εργατοδικεία + τόκοι υπερημερίας (L57-59) | **OK** (ΣΕΠΕ naming) |
| 7 | Νομοθεσία: ΑΝ 539/1945, Ν.4554/2018, ΑΚ 250, ΑΚ 174 (L69-72) | **OK** |

**Verdict tally:** OK 7 · WRONG 0 · IMPRECISE 0 · OUTDATED 0

### Notes
- The strongest file in the batch — legally sound throughout. Daily-wage = μηνιαίος ÷ 25 (L20) matches the CURRENCY-BRIEF §2 daily-wage convention; the 50% επίδομα and 5-year παραγραφή (ΑΚ 250 №17, wage claims) are correct; ΑΚ 174 ακυρότητα of waiver clauses is correctly invoked.
- Only cosmetic: "ΣΕΠΕ" → "Επιθεώρηση Εργασίας / hli.gov.gr" (see File 1 #16).
- Consider adding that on termination the compensation is paid **χωρίς** the 100% surcharge (the surcharge is a *during-employment* penalty), so no false expectation of doubling arises. (Not an error — a clarity add.)

---

## FILE 4 — `adia-gamos.md` (Άδεια Γάμου & Τεκνοποίησης)

| # | Claim (line) | Verdict |
|---|---|---|
| 1 | Άδεια γάμου: 5 ημ. (5ήμερο) / 6 ημ. (6ήμερο), με αποδοχές, incl. σύμφωνο (L14-20) | **OK** |
| 2 | Αυτοτελής — δεν αφαιρείται από ετήσια· χωρίς ελάχιστη προϋπηρεσία (L19-21) | **OK** |
| 3 | Βάση: Ν.4808/2021 άρθρο 39 (L23) | **OK** |
| 4 | Σχολική παρακολούθηση: έως 4 εργάσιμες ημ./έτος, με αποδοχές (L33-37) | **OK** |
| 5 | Αφορά νηπιαγωγείο/δημοτικό/γυμνάσιο/λύκειο (L41) | **IMPRECISE** |
| 6 | Δικαίωμα αμφότερων γονέων ξεχωριστά (L42-43) | **OK** |
| 7 | Σχολική βάση: **Ν.1483/1984 άρθρο 9** (L47,75) | **OUTDATED** |
| 8 | Γονική άδεια 4 μήνες έως τα 8 έτη (L62-64) | **OK** |
| 9 | «Άδεια φροντίδας: εναλλακτικά της γονικής, μειωμένο ωράριο 1 ώρα/ημέρα» (L65) | **IMPRECISE** |

**Verdict tally:** OK 6 · OUTDATED 1 · IMPRECISE 2

### Non-OK detail

**#1/#3 — OK, CONFIRMED (confidence: HIGH):** verbatim ΦΕΚ matches exactly.
- Greek quote (art.39): «χορηγείται άδεια **έξι (6) εργασίμων ημερών, με αποδοχές**, εφόσον… **εξαήμερης**… και **πέντε (5) εργασίμων ημερών**, εφόσον… **πενθήμερης**… Η άδεια αυτή δεν υπολογίζεται στην κανονική ετήσια άδεια».
- Source: https://www.taxheaven.gr/law/4808/2021/arthro/39

**#7 — OUTDATED (confidence: HIGH)**
- Snippet (verbatim): `**Νομική βάση:** Ν. 1483/1984, άρθρο 9 (Άδεια για παρακολούθηση σχολικής επίδοσης παιδιών).`
- Problem: the operative provision today is **Ν.4808/2021 άρθρο 38** (Ν.1483/1984 art.9 is the historical base). Cite art.38 as primary; the 4-day / paid values are otherwise correct.
- Basis: **Ν.4808/2021 art.38**.
- Source: https://www.taxheaven.gr/law/4808/2021/arthro/38
- Greek quote: «να απουσιάζουν, **χωρίς περικοπή των αποδοχών τους**… ορισμένες ώρες ή ολόκληρη την ημέρα… μέχρι τη συμπλήρωση **τεσσάρων (4) εργάσιμων ημερών**, κάθε ημερολογιακό έτος».

**#5 — IMPRECISE (confidence: MEDIUM):** art.38 frames the right by child age (**up to 18**, and children with special educational needs regardless of age), not by school level; the νηπιαγωγείο→λύκειο enumeration is narrower than the law. Reword to "τέκνα έως 18 ετών".

**#9 — IMPRECISE (confidence: MEDIUM):** "Άδεια φροντίδας… εναλλακτικά της γονικής, μειωμένο ωράριο 1 ώρα/ημέρα" conflates two distinct rights: the **άδεια φροντίδας τέκνου** (30-month 1h/day reduction, art.37) is *not* an alternative to γονική άδεια, and the 5-day **άδεια φροντιστή** (art.29) is different again. Clarify or drop.

---

## FILE 5 — `eidikes-adeies.md` (Ειδικές Άδειες) — HIGH ERROR DENSITY

| # | Claim (line) | Verdict |
|---|---|---|
| 1 | Άδεια εκλογών: ≤100χλμ→1, 100-200→2, >200→3 ημ., αμειβόμενη (L19-25) | **WRONG / OUTDATED** |
| 2 | Άδεια αιμοδοσίας: ημέρα αιμοδοσίας αμειβόμενη (L32-33) | **OK** (incomplete) |
| 3 | Εκπαιδευτική (Ν.1346/1983): «**10 εργάσιμες ημέρες/εξεταστική** (2 ανά έτος)», μη αμειβόμενη (L44-48) | **WRONG** |
| 4 | Επαγγελματική κατάρτιση = χρόνος εργασίας, αμείβεται (L52-54) | **OK** |
| 5 | Απαλλαγή νυχτερινής: έναρξη εγκυμοσύνης → 1 έτος μετά τοκετό (L62-64) | **IMPRECISE** |
| 6 | Προγεννητικές εξετάσεις: αμειβόμενη άδεια (L66-68) | **OK** (add art.40) |
| 7 | Θηλασμός: 1 ώρα πλήρως αμειβ. **ή 2 ώρες με αντιστάθμιση 50%** (L70-73) | **WRONG** |
| 8 | ΑμεΑ τέκνο: «**6 εργάσιμες ημέρες/έτος** αμειβ. για Down ή αναπηρία >67%» (L79-82) | **WRONG** |
| 9 | Ασθένεια τέκνου <16: «**2 αμειβόμενες ημ.** (χωρίς γνωμάτευση) / **4 ημ.** για 3+ παιδιά» (L87-91) | **WRONG** |
| 10 | «Άδεια **φροντίδας οικογένειας**»: 5 ημ., άνευ αποδοχών, «**δεν απαιτείται ιατρική γνωμάτευση**» (L94-101) | **WRONG** |
| 11 | Στρατιωτικές: αναστολή σχέσης· επαναπρόσληψη εντός 1 μήνα (L106-108) | **UNVERIFIABLE** |
| 12 | Συνοπτικός πίνακας (επαναλαμβάνει #7-10) (L114-123) | **WRONG** |
| 13 | (Άδεια ανωτέρας βίας — art.30) | **GAP — MISSING** |
| 14 | (Άδεια πένθους/θανάτου — ΕΓΣΣΕ 2002-03 art.9) | **GAP — MISSING** |
| 15 | (Άδεια γυναικολογικού ελέγχου — Ν.5043/2023 art.96) | **GAP — MISSING** |

**Verdict tally:** OK 3 · WRONG 5 · IMPRECISE 1 · UNVERIFIABLE 1 · GAP 3

### Non-OK detail

**#7 — WRONG (confidence: HIGH)** — the flagged fabrication.
- Snippet (verbatim): `- **2 ώρες** μείωση με μισθολογική αντιστάθμιση 50%`
- Problem: **all** forms of the 30-month childcare/breastfeeding leave are **fully paid**. The "2h @ 50% pay" is invented; the real 2-hour option (first 12 months) is 100% paid.
- Replacement: `2 ώρες/ημέρα μείωση τους πρώτους 12 μήνες + 1 ώρα/ημέρα τους επόμενους 6 μήνες — πλήρως αμειβόμενη`.
- Basis: **Ν.4808/2021 art.37**.
- Source: https://www.taxheaven.gr/law/4808/2021/arthro/37
- Greek quote: «Η άδεια φροντίδας χορηγείται **με αποδοχές**… κατά δύο (2) ώρες… τους πρώτους δώδεκα (12) μήνες και κατά μία (1) ώρα… τους επόμενους έξι (6) μήνες».

**#8 — WRONG (confidence: HIGH)**
- Snippet (verbatim): `- **6 εργάσιμες ημέρες/έτος** αμειβόμενης ειδικής άδειας για φροντίδα τέκνου με σύνδρομο Down ή αναπηρία >67% (Ν. 4808/2021)`
- Problem: the parental leave for a child with serious illness/severe disability is **10 εργάσιμες ημέρες/έτος, με αποδοχές** (art.43). The "6 days" is a *different* right — the **άδεια αναπήρων εργαζομένων** (6 days for disabled *employees*, ΕΓΣΣΕ) — wrongly grafted onto the parent's right.
- Replacement: `10 εργάσιμες ημέρες/έτος, με αποδοχές` (τέκνο έως 18 με μεταγγίσεις/αιμοκάθαρση, νεοπλασματικά, μεταμόσχευση, σπάνια νοσήματα ≥67%· ή οποιασδήποτε ηλικίας με βαριά νοητική/σύνδρομο Down/αυτισμό). Optionally add the **1 ώρα/ημέρα μειωμένο ωράριο** in firms ≥50 (art.41), and note the separate 6-day disabled-*employee* leave.
- Basis: **Ν.4808/2021 art.43** (am. Ν.4892/2022); reduced-hours **art.41**.
- Source: https://www.taxheaven.gr/law/4808/2021/arthro/43
- Greek quote: «άδεια… **δέκα (10) εργασίμων ημερών κατ' έτος, με αποδοχές**… τέκνων ηλικίας έως δεκαοκτώ (18) ετών… καθώς και… βαριά νοητική στέρηση ή σύνδρομο Down ή αυτισμό».

**#9 — WRONG (confidence: HIGH)** — wrong on every count.
- Snippet (verbatim): `- **2 αμειβόμενες ημέρες/έτος** (άνευ ιατρικής γνωμάτευσης για πρώτα 2 παιδιά)` / `- **4 ημέρες/έτος** για 3 ή περισσότερα παιδιά`
- Problem: the child/dependant-sick leave is **6 / 8 / 14 εργάσιμες ημέρες** (1 / 2 / >2 dependants) and **ΑΝΕΥ ΑΠΟΔΟΧΩΝ (unpaid)**. Both the day counts and the "paid" characterisation are wrong.
- Replacement: `6 εργάσιμες ημέρες/έτος για 1 εξαρτώμενο, 8 για 2, 14 για >2 — άνευ αποδοχών`.
- Basis: **Ν.4808/2021 art.42** (base Ν.1483/1984 art.7); covers τέκνα έως 16 (or older with special-care need) & other dependants.
- Source: https://www.taxheaven.gr/law/4808/2021/arthro/42 · https://www.opengov.gr/minlab/?p=4935
- Greek quote: «δικαίωμα… **άδειας άνευ αποδοχών** που δεν υπερβαίνει τις **έξι (6) εργάσιμες ημέρες** κάθε ημερολογιακό έτος… αυξάνεται σε **οκτώ (8)**… εάν προστατεύει δύο παιδιά και σε **δεκατέσσερις (14)**… περισσότερα από δύο».

**#10 — WRONG (confidence: HIGH)** — name + certificate both wrong.
- Snippet (verbatim): `## Άδεια φροντίδας οικογένειας (Ν. 4808/2021)` … `- Δεν απαιτείται ιατρική γνωμάτευση`
- Problem: the correct name is **άδεια φροντιστή** (art.29). A **medical certificate is REQUIRED** — the statute conditions it expressly on ιατρική γνωμάτευση. (The 5-day / unpaid substance is otherwise OK; needs 6 months' tenure.)
- Replacement: rename to **«Άδεια φροντιστή»**; state `απαιτείται ιατρική γνωμάτευση που βεβαιώνει τη σοβαρή ανάγκη φροντίδας`; add the 6-month tenure precondition.
- Basis: **Ν.4808/2021 art.29** (Οδηγία 2019/1158 art.6).
- Source: https://www.taxheaven.gr/law/4808/2021/arthro/29
- Greek quote: «δικαιούται **άδεια φροντιστή**… έως **πέντε (5) εργάσιμων ημερών**… εφόσον το πρόσωπο αυτό έχει ανάγκη σημαντικής φροντίδας ή υποστήριξης για σοβαρό ιατρικό λόγο, **η οποία βεβαιώνεται με ιατρική γνωμάτευση**».

**#3 — WRONG (confidence: HIGH)**
- Snippet (verbatim): `- **10 εργάσιμες ημέρες/εξεταστική** για εξεταστικές περιόδους (2 ανά έτος)`
- Problem: the exam leave for working students is **30 εργάσιμες ημέρες/έτος, άνευ αποδοχών** (continuous or in installments), not "10 per exam period." (10 unpaid days is the separate **postgraduate/doctoral** leave.)
- Replacement: `30 εργάσιμες ημέρες/έτος, άνευ αποδοχών (μεταπτυχιακοί/υποψήφιοι διδάκτορες: 10 ημέρες)`.
- Basis: **Ν.1346/1983 art.2 + ΕΓΣΣΕ 1996 art.7** (κωδικοπ. Ν.2556/1997); >28 ετών only for normal study duration +2 έτη.
- Source: https://www.hli.gov.gr/.../loipes-adeies/adeia-exetaseon/
- Greek quote: «πρόσθετη άδεια **άνευ αποδοχών διάρκειας 30 εργάσιμων ημερών** για τη συμμετοχή τους στις εξετάσεις… συνεχών ή διακεκομμένων κατ' έτος».

**#1 — WRONG / OUTDATED (confidence: MEDIUM-HIGH)**
- Snippet (verbatim): `| Έως 100 χιλιόμετρα | 1 ημέρα |` / `| 100–200 χιλιόμετρα | 2 ημέρες |` / `| Άνω των 200 χιλιομέτρων | 3 ημέρες |`
- Problem: election leave is fixed by a **ΚΥΑ before each election**; the recurring/2023 scheme is **100–200 χλμ → 1 ημ.· 201–400 χλμ → 2 ημ.· 401+ χλμ (οδικώς) → 3 ημ.** — different tiers, and under ~100 χλμ generally grants none. The corpus's fixed table doesn't match the standing ΚΥΑ pattern.
- Replacement: state the recurring tiers and note "καθορίζεται με ΚΥΑ ανά εκλογική αναμέτρηση".
- Source: https://www.ot.gr/2023/04/20/... · taxheaven.gr/news/63507
- Greek quote (2023 ΚΥΑ): «σε απόσταση **100-200 χιλιομέτρων… μία (1) εργάσιμη ημέρα**… **201-400… δύο (2)**… **401 χιλιομέτρων και άνω… τρεις (3)** εφόσον κινηθούν εξ ολοκλήρου οδικώς».

**#2 — OK, incomplete (confidence: HIGH):** private-sector blood-donation leave = **the day of donation, fully paid** — the corpus value is correct. Add the missing conditions: **max 2×/year**, **≥5 working-days' advance notice** to the employer (except emergencies), and a **hospital certificate** required.
- Greek quote: «δικαιούται ειδικής άδειας απουσίας **με πλήρεις αποδοχές, μόνο για την ημέρα της αιμοληψίας**… το ανώτερο **δύο φορές το χρόνο**».

**#5 — IMPRECISE (confidence: MEDIUM):** night-work exemption for pregnant/breastfeeding workers exists (**ΠΔ 176/1997**) but is conditioned on a **medical certificate** that night work threatens safety/health; the flat "start of pregnancy → 1 year after birth" overstates automaticity. Add the ΠΔ 176/1997 basis and the certificate condition.

**#6 — OK, add basis (confidence: HIGH):** prenatal-exam leave = paid, **«χωρίς περικοπή αποδοχών»**, **Ν.4808/2021 art.40** (base Ν.3488/2006). Cite it.

**#11 — UNVERIFIABLE (confidence: LOW):** the "employer must rehire within 1 month of discharge" for conscripts is directionally right (suspension, not termination) but the specific 1-month figure/basis (ΝΔ 1044/1971 / Ν.3421/2005) was not confirmed this session. Flag; do not assert the number without a source.

**#13 — GAP / MISSING (confidence: HIGH):** **Άδεια ανωτέρας βίας** — **έως 2 φορές/έτος, έως 1 εργάσιμη ημέρα κάθε φορά, με αποδοχές**, for urgent family illness/accident needing the worker's immediate presence (**Ν.4808/2021 art.30**). A special-leaves aggregator must include it.
- Greek quote: «Έως δύο (2) φορές ετησίως και έως μία (1) εργάσιμη ημέρα κάθε φορά… δικαιούται να απουσιάσει… **με αποδοχές**, για λόγους ανωτέρας βίας».
- Source: https://www.taxheaven.gr/law/4808/2021/arthro/30

**#14 — GAP / MISSING (confidence: HIGH):** **Άδεια πένθους/θανάτου συγγενούς** — **2 ημέρες με αποδοχές** (σύζυγος, τέκνα, γονείς, αδέρφια, εξ αγχιστείας), **ΕΓΣΣΕ 2002-03 art.9** (+ ΕΓΣΣΕ 2010-12 art.8). Also note the newer **20-ήμερη** paid leave for a parent whose **child died** (**Ν.5018/2023 art.93**).
- Source: https://www.hli.gov.gr/.../loipes-adeies/adeia-logo-thanatou-syngenous/

**#15 — GAP / MISSING (confidence: HIGH):** **Άδεια γυναικολογικού ελέγχου** — **1 ημέρα/έτος, με αποδοχές, ιδιωτικός τομέας**, **Ν.5043/2023 art.96** (postdates the corpus; per CURRENCY-BRIEF §0/§6 it is 1×/yr, not twice-yearly).

---

## FILE 6 — `index.md` (Άδειες — landing)

| # | Claim (line) | Verdict |
|---|---|---|
| 1 | Οι άδειες = βασικό δικαίωμα (L8) | **OK** |
| 2 | Λίστα τύπων: Ετήσια, Ασθένειας, Μητρότητας, Πατρότητας (L12-15) | **GAP — INCOMPLETE** |

**Verdict tally:** OK 1 · GAP 1

### Non-OK detail
**#2 — GAP / INCOMPLETE (confidence: HIGH):** no legal error, but the landing page omits links to the batch's own articles — **[[Άδεια Γάμου]]**, **[[Ειδικές Άδειες]]**, **[[Αποζημίωση Μη Ληφθείσας Άδειας]]** — plus the parental-batch files (θηλασμού, γονική, ειδική μητρότητας). Readers can't discover them. Extend the index.

---

## BATCH SUMMARY

| File | OK | WRONG | OUTDATED | IMPRECISE | UNVERIFIABLE | GAP |
|---|---|---|---|---|---|---|
| etisia-adia.md | 10 | 3 | 0 | 3 | 2 | 0 |
| astheneia.md | 6 | 1 | 0 | 4 | 0 | 1 |
| apozimiossi-adias.md | 7 | 0 | 0 | 0 | 0 | 0 |
| adia-gamos.md | 6 | 0 | 1 | 2 | 0 | 0 |
| eidikes-adeies.md | 3 | 5 | 0 | 1 | 1 | 3 |
| index.md | 1 | 0 | 0 | 0 | 0 | 1 |
| **TOTAL** | **33** | **9** | **1** | **10** | **3** | **5** |

### Highest-priority corrections
1. **`eidikes-adeies.md` child-sick leave (#9): "2 paid / 4 for 3+" → 6/8/14 εργάσιμες ημέρες, ΑΝΕΥ ΑΠΟΔΟΧΩΝ** (Ν.4808/2021 art.42). Wrong on days *and* pay.
2. **`eidikes-adeies.md` disabled-child (#8): "6 paid days" → 10 εργάσιμες ημέρες με αποδοχές** (art.43); the 6-day figure is the unrelated disabled-*employee* leave.
3. **`eidikes-adeies.md` breastfeeding (#7): "2h @ 50% pay" → fully paid** (art.37); the 50% is fabricated.
4. **`eidikes-adeies.md` carer's leave (#10): rename «φροντίδας οικογένειας» → «φροντιστή» and fix "no certificate" → certificate REQUIRED** (art.29).
5. **`etisia-adia.md` annual-leave ladder (#4/#7): caps at 22/26 → must reach 25/30 (10ετία/12ετία) and 26/31 (25 έτη).** The corpus silently strips up to 4-5 days/year from long-tenured workers — the single most damaging error by worker impact.

### Gaps to add
- `eidikes-adeies.md`: **ανωτέρας βίας** (art.30, 2×/yr, 1 day, paid), **πένθους** (2 days, ΕΓΣΣΕ 2002-03 art.9; + 20-day child-death leave Ν.5018/2023 art.93), **γυναικολογικού ελέγχου** (Ν.5043/2023 art.96, 1 day/yr paid).
- `astheneia.md`: the **employer full-wage top-up** for the βραχεία-ασθένεια period (ΑΚ 657-659) — currently the file implies only the 50% ΕΦΚΑ benefit.
- `etisia-adia.md`: carry-over **to Q1 of next year** (Ν.4808/2021 art.61).
- `index.md`: links to γάμου / ειδικές / αποζημίωση + parental-batch articles.

### Citation / naming fixes (Phase E)
- **«ΣΕΠΕ» / «sepe.gr» → «Επιθεώρηση Εργασίας» / «hli.gov.gr»** across `etisia-adia.md`, `astheneia.md`, `apozimiossi-adias.md`, `adia-gamos.md` (renamed by Ν.4808/2021; 1555 line still valid).
- `adia-gamos.md` school-leave: **Ν.1483/1984 art.9 → Ν.4808/2021 art.38** (primary).
- `eidikes-adeies.md`: add art.40 (prenatal), art.29 (carer), art.37 (breastfeeding), art.42/43 (child leaves), ΠΔ 176/1997 (night-work), ΕΓΣΣΕ 1996 (exam leave).

### Unverifiable / flagged (not asserted)
- `etisia-adia.md`: οικιακοί μισθωτοί "26 ημ." (Ν.4488/2017); ΣΕΠΕ fine "350–500 €/εργαζ." + "Ν.4488/2017 art.36".
- `astheneia.md`: εργατικό-ατύχημα benefit "100%"; the flat "12-month contract suspension".
- `eidikes-adeies.md`: conscript re-employment "εντός 1 μήνα".

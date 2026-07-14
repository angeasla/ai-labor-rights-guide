# AUDIT LEDGER — Batch `symvasi-hiring-docs`

**Auditor role:** Greek labour lawyer (εργατολόγος), adversarial legal-currency fact-check.
**Date of audit:** 2026-07-13.
**Corpus path:** `src/main/resources/docs/symvasi/`
**Files:** anaggelia-proslipsis.md · anangestikes-proslixi.md · kanonismos-ergasias.md · vivlia-ergodoti.md · vevaiosi-ergasias.md · vevaiosi-proypiresias.md
**Method:** every checkable claim (thresholds, %, €, deadlines, law/article/ΦΕΚ) extracted, verified against CURRENCY-BRIEF §0 + KED-MAP **and** fresh primary/authoritative fetch (ypergasias.gov.gr, hli.gov.gr, e-nomothesia.gr, lawspot.gr [ΑΚ], ΦΕΚ mirrors on taxheaven). `kepea.gr` / `forin.gr` / `et.gr` 403 to WebFetch per brief; used their WebSearch snippets + non-blocked mirrors.
**Rule:** unconfirmable ⇒ UNVERIFIABLE. **No corpus files edited.**

---

## VERDICT TALLY

| File | OK | WRONG | OUTDATED | IMPRECISE | UNVERIFIABLE | GAP |
|---|---|---|---|---|---|---|
| anaggelia-proslipsis.md | 4 | 0 | 1 (ΣΕΠΕ ×4) | 1 | 0 | 2 (Ν.5239/2025 single-doc; Ν.5053/2023 essential-terms notice) |
| anangestikes-proslixi.md | 3 | 2 (quota "2–8%"; public-sector 6h) | 1 (ΣΕΠΕ) | 1 (threshold "50 και άνω") | 0 | 0 |
| kanonismos-ergasias.md | 4 | 1 (basis "Ν.3996/2011 art.16") | 1 (ΣΕΠΕ) | 2 (threshold "70+"; "διαβούλευση" vs συναπόφαση) | 0 | 0 |
| vivlia-ergodoti.md | 4 | 0 | 1 (ΣΕΠΕ ×5) | 2 (ΠΔ 88/1999 basis; Ε4 "real-time") | 0 | 1 (βιβλίο υπερωριών + μισθολόγιο) |
| vevaiosi-ergasias.md | 4 | 1 (ΑΚ 655) | 1 (ΣΕΠΕ) | 0 | 0 | 0 |
| vevaiosi-proypiresias.md | 3 | 1 (ΑΚ 655) | 1 (ΣΕΠΕ + sepe.gov.gr link) | 1 (Ν.2112/1920 / Ν.1545/1985 as cert. basis) | 0 | 0 |

**Headline:** No fabricated numbers, but the batch is systematically **stale on institutions and codification**. The single biggest factual error is the **compulsory-hire quota framed as a "2–8% range" — it is a flat 8%** (Ν.2643/1998 art.2). Two headline **wrong citations**: κανονισμός εργασίας attributed to Ν.3996/2011 art.16 (real basis **ΝΔ 3789/1957 art.1**), and the work certificate attributed to **ΑΚ 655** in both βεβαίωση files (real basis **ΑΚ 678**; ΑΚ 655 = "πότε καταβάλλεται ο μισθός"). **ΣΕΠΕ** is cited across every file though it was abolished and replaced by the Independent Authority **Επιθεώρηση Εργασίας** (Ν.4808/2021, operational 19.7.2022). Two real content gaps: the **Ν.5239/2025 single-document digital hiring** and the **Ν.5053/2023 essential-terms written notice** (Dir 2019/1152) — both directly on-topic for a hiring-docs batch and both absent.

---

## CROSS-CUTTING FINDING — ΣΕΠΕ → Επιθεώρηση Εργασίας (all 6 files)

**Verdict: OUTDATED (institutional).** Every file calls the enforcement body **"ΣΕΠΕ"** (Σώμα Επιθεώρησης Εργασίας). ΣΕΠΕ was **abolished**; Ν.4808/2021 established an **Independent Administrative Authority "Επιθεώρηση Εργασίας"**, which **from 19.07.2022** exercises the ΣΕΠΕ competences of art.2 Ν.3996/2011.

- **Replacement:** rename "ΣΕΠΕ" → **"Επιθεώρηση Εργασίας"** throughout (keep the **1555** phone line — still valid; website now **hli.gov.gr**, not sepe.gov.gr).
- **Legal basis:** Ν.4808/2021 (Ανεξάρτητη Αρχή «Επιθεώρηση Εργασίας»); ΚΥΑ οργανισμού.
- **Source (verbatim):** *"Με τον ν. 4808/21 συστάθηκε Ανεξάρτητη Διοικητική Αρχή με την επωνυμία 'Επιθεώρηση Εργασίας', η οποία από την έναρξη λειτουργίας της, την 19.07.2022, ασκεί τις αρμοδιότητες του Σώματος Επιθεώρησης Εργασίας (ΣΕΠΕ) που προβλέπονται στο άρθρο 2 του ν. 3996/2011."* — https://www.hli.gov.gr/en/organisation/profile/ ; https://el.wikipedia.org/wiki/Επιθεώρηση_Εργασίας
- **Confidence: HIGH.** Occurrences: anaggelia (body ×2 + tag + §), anangestikes (§ + tag), kanonismos (§), vivlia (title-implied + body ×5 + tag), vevaiosi-ergasias (body + tag), vevaiosi-proypiresias (body + tag + sepe.gov.gr hyperlink).

---

## FILE 1 — `anaggelia-proslipsis.md` (Αναγγελία Πρόσληψης)

### Checkable claims

| # | Claim (line) | Verdict | Note |
|---|---|---|---|
| 1.1 | Αναγγελία must be filed **before** work starts ("πριν ξεκινήσεις") (L13) | **OK** | Pre-commencement declaration is correct (Ε3 αναγγελία in ΕΡΓΑΝΗ). |
| 1.2 | Content list: ΑΜΚΑ/ΑΦΜ, start date/time, ωράριο, αποδοχές, τύπος σύμβασης, ειδικότητα (L15–21) | **OK** | Matches ΕΡΓΑΝΗ αναγγελία fields. |
| 1.3 | Undeclared-work fine "**από 10.500 ευρώ ανά εργαζόμενο**", multiplied on recidivism (L40) | **OK** | Confirmed. Basis missing (enhancement below). |
| 1.4 | Self-check via gov.gr / myEFKA (L31–34) | **OK** | Accurate. |
| 1.5 | Institution "**ΣΕΠΕ**" (L46, L50, tag, title of §) | **OUTDATED** | → Επιθεώρηση Εργασίας (see cross-cutting). |
| 1.6 | ΕΡΓΑΝΗ referred to generically (not "ΕΡΓΑΝΗ ΙΙ"); URL "ergani.gov.gr" (L12) | **IMPRECISE** | Current system is **ΕΡΓΑΝΗ ΙΙ**; employee self-service is **myErgani**. URL not load-bearing → left unflagged as error. |

### Enhancement — cite the penalty basis (claim 1.3)
- **Add basis:** **Ν.4554/2018 art.5** (ΦΕΚ Α΄130/18.7.2018). €10.500/undeclared worker; **reduced to €7.000** if the employer signs a **full-time contract of ≥3 months within 10 working days** of inspection (waiving appeal); **no reduction on recidivism**.
- **Source (verbatim):** *"το βασικό ποσό του προστίμου μειώνεται … στο ποσό των επτά χιλιάδων (7.000) ευρώ, εφόσον η σύμβαση εργασίας είναι διάρκειας τουλάχιστον τριών (3) μηνών."* — e-ΕΦΚΑ Εγκ. 36/2018 (forin.gr article 24938); https://www.lawspot.gr/nomika-nea/dimosieythike-o-nomos-4554-2018-...
- **Confidence: HIGH.**

### GAP 1a — Ν.5239/2025 single-document (ενιαία ψηφιακή) πρόσληψη  *(task focus)*
- **What's missing:** Ν.5239/2025 «Δίκαιη Εργασία για Όλους» (ΦΕΚ Α΄178/17.10.2025) **merges the four hiring forms into one digital form**: only the αναγγελία πρόσληψης is filed in ΕΡΓΑΝΗ, **without attaching a contract**; changes are declared by a special form **without an amending contract**; the employee can **digitally accept** the hire/change via **myErgani**.
- **Legal basis:** Ν.5239/2025 (amends ΕΡΓΑΝΗ ΙΙ / Ν.4808/2021 arts 73–74 framework).
- **Source (verbatim):** *"υποβάλλεται μόνο η αναγγελία πρόσληψης στο ΕΡΓΑΝΗ χωρίς υποχρέωση επισύναψης σύμβασης … οι μεταβολές δηλώνονται με ειδικό έντυπο χωρίς τροποποιητική σύμβαση … δυνατότητα ψηφιακής αποδοχής της πρόσληψης ή μεταβολής από τον εργαζόμενο μέσω myErgani."* — https://ypergasias.gov.gr/ergani/nomos-5239-2025-dikaii-ergasia-gia-olous/ ; https://daily.nb.org/nomothesia-nomologia/nomothesia/ergani-ii-kai-psifiaki-karta-ergasias-ti-allaxe-me-ton-n-5239-2025/
- **Confidence: HIGH.**

### GAP 1b — Ν.5053/2023 written **essential-terms notice** (γνωστοποίηση ουσιωδών όρων)  *(task focus)*
- **What's missing:** Beyond the ΕΡΓΑΝΗ αναγγελία, the employer must give the worker a **written notice of the essential terms** of the employment relationship. Ν.5053/2023 (transposing **Dir (EU) 2019/1152**) **repealed ΠΔ 156/1994** (which allowed 2 months) and **shortened the deadlines**: core information **within 1 week**, remaining terms **within 1 month**; changes notified **by the day they take effect**; documents uploaded to **ΕΡΓΑΝΗ ΙΙ**. New mandatory terms added: **probation duration/conditions, right to training, unpredictable-schedule terms**.
- **Legal basis:** Ν.5053/2023 (Dir 2019/1152) → now **ΚΕΔ (ΠΔ 62/2025) arts 70–77** — ΜΕΡΟΣ Γ, ΤΜΗΜΑ Ι «Γνωστοποίηση όρων εργασίας» (art.73 = υποχρέωση ενημέρωσης; art.75 = χρονοδιάγραμμα & μέσα ενημέρωσης).
- **Source (verbatim):** *"προθεσμία μίας (1) εβδομάδας … [και] ενός (1) μηνός … καταργήθηκε το π.δ. 156/1994 που προέβλεπε γνωστοποίηση εντός δύο μηνών."* — https://www.kepea.gr/oi-simantikoteres-diataxeis-n-5053-2023 ; ΚΕΔ ΤΜΗΜΑ Ι art.70+ https://www.elinyae.gr/ethniki-nomothesia/pd-622025-fek-121a-1172025
- **Confidence: HIGH** (existence, deadlines, Dir 2019/1152); **MEDIUM** on the exact ΚΕΔ sub-article split (70–77 cluster verified; 73/75 labels verified).

---

## FILE 2 — `anangestikes-proslixi.md` (Αναγκαστικές Προσλήψεις)  *(PRIORITY)*

### Checkable claims

| # | Claim (line) | Verdict | Correct value | Basis | Source |
|---|---|---|---|---|---|
| 2.1 | Applies to "**Ιδιωτικές επιχειρήσεις με 50 και άνω εργαζόμενους**" (L15) | **IMPRECISE** | Threshold is **more than 50** (περισσότερα/άνω των 50 → 51+), not "50 and above" | Ν.2643/1998 **art.2 §1** | hli.gov.gr; e-nomothesia |
| 2.2 | Quota "**ποικίλει ανά κλάδο και μέγεθος — συνήθως 2% έως 8%**" (L21) | **WRONG** | A **flat 8%** of total workforce (not a size/sector-varying 2–8% range); the 8% is *internally sub-allocated* among the protected categories of art.1, but the ceiling every 50+ firm owes is 8% | Ν.2643/1998 art.2 §1 | hli.gov.gr; kodiko |
| 2.3 | ΑμεΑ = disability "**50% και άνω** από ΚΕΠΑ" (L27) | **OK** | ≥50% disability is the ΑμεΑ threshold | Ν.2643/1998 art.1 | search-confirmed |
| 2.4 | Other categories: families of war/service victims/disabled (L28–29) | **OK** | Matches art.1 protected categories | Ν.2643/1998 art.1 | e-nomothesia |
| 2.5 | Process: employer declares vacancy to ΔΥΠΑ; ΔΥΠΑ register; placement mandatory; fines per position (L33–36) | **OK** (substance) | Placement is by the **Επιτροπή του art.9** and is compulsory | Ν.2643/1998 arts 4, 9 | search-confirmed |
| 2.6 | Public-sector ΑμεΑ: "**μειωμένο ωράριο 6 ωρών ημερησίως με πλήρεις αποδοχές, εφόσον το κρίνει ο ιατρός εργασίας**" (L50) | **WRONG** | Statutory entitlement is a **1-hour/day reduction with no pay cut**, for defined categories (blind/para-tetraplegic/end-stage renal, or **disability ≥67%**) — **not** a fixed "6-hour day", and **not** at the discretion of an "ιατρός εργασίας" | Υπ. Εσωτερικών circular; Δημοσιοϋπαλληλικός Κώδικας | ypes.gov.gr |
| 2.7 | Institution "**ΣΕΠΕ**" (L54) | **OUTDATED** | → Επιθεώρηση Εργασίας | Ν.4808/2021 | cross-cutting |
| 2.8 | Cite "Ν.4488/2017" as supplementary (L59) | **OK** | Ν.4488/2017 (Μέρος Δ΄) does carry disability-employment/accessibility provisions | Ν.4488/2017 | — |

### Detail — claim 2.2 (the headline error)
- **Snippet (verbatim):** *"Η **ποσόστωση** ποικίλει ανά κλάδο και μέγεθος — συνήθως **2% έως 8%** του εργατικού δυναμικού."*
- **Replacement:** *"Ο νόμος επιβάλλει ενιαία **ποσόστωση 8%** του συνόλου του προσωπικού σε κάθε ιδιωτική επιχείρηση με **πάνω από 50** εργαζόμενους. Το 8% κατανέμεται εσωτερικά ανά προστατευόμενη κατηγορία, αλλά η συνολική υποχρέωση είναι 8%."*
- **Legal basis:** Ν.2643/1998 **art.2 §1**.
- **Source (verbatim):** *"οι επιχειρήσεις ή εκμεταλλεύσεις … που απασχολούν προσωπικό πάνω από πενήντα (50) άτομα υποχρεούνται να προσλαμβάνουν προστατευόμενα πρόσωπα … σε ποσοστό οκτώ τοις εκατό (8%) επί του συνόλου του προσωπικού."* — https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/prostasia/amea-kai-alla-prostatefomena-prosopa/ypochreosi-proslipsis-kai-apascholisis/
- **Confidence: HIGH** on the flat 8% and the ">50" threshold; the exact per-category sub-split of the 8% was **not** obtainable verbatim (kodiko/taxheaven paywalled, ΦΕΚ PDF corrupt) → do **not** assert sub-percentages.

### Note — codification cross-reference (do not over-claim)
Per KED-MAP §2 structure, disability-employment-quota provisions sit at **ΚΕΔ arts 83–93**. The KED-MAP reference table does **not** explicitly map Ν.2643/1998 into the ΚΕΔ, and recent amendments to Ν.2643/1998 art.2 are **Ν.4611/2019 & Ν.4765/2021** (per kodiko metadata) — **not** Ν.4808/2021 as the task hypothesised. Keep the primary cite as **Ν.2643/1998**; flag the ΚΕΔ 83–93 mapping as *to-verify*, not asserted. **Confidence: MEDIUM.**

---

## FILE 3 — `kanonismos-ergasias.md` (Κανονισμός Εργασίας)

### Checkable claims

| # | Claim (line) | Verdict | Correct value | Basis | Source |
|---|---|---|---|---|---|
| 3.1 | Mandatory for firms with "**70 ή περισσότερους εργαζόμενους**" (L13) | **IMPRECISE** | **More than 70** (περισσότερο από 70 → 71+), not "70 or more" | ΝΔ 3789/1957 art.1 | hli.gov.gr |
| 3.2 | Legal basis = "**Ν. 3996/2011** … **Άρθρο 16** (υποχρέωση κανονισμού εργασίας)" (L13, L57) | **WRONG** | Basis is **ΝΔ 3789/1957 art.1**. Ν.3996/2011 is the labour-inspection law; its art.16 concerns inspection/doctors, **not** work regulations | ΝΔ 3789/1957 art.1 | hli.gov.gr; ypergasias.gov.gr |
| 3.3 | Διευθυντικό δικαίωμα = "**ΑΚ 652**" (L31, L58) | **OK** | ΑΚ 652 is the correct basis for the employer's διευθυντικό δικαίωμα | ΑΚ 652 | e-forosimv; taxheaven ΑΠ 939/2015 |
| 3.4 | Mandatory content (ωράρια, υγιεινή/ασφάλεια, πειθαρχική διαδικασία + ακρόαση) (L17–19) | **OK** | Consistent with ΝΔ 3789/1957 minimum content | ΝΔ 3789/1957 | hli.gov.gr |
| 3.5 | "Δικαίωμα **διαβούλευσης** … σε επιχειρήσεις με συμβούλιο εργαζομένων ο κανονισμός δεν μπορεί να αλλάξει χωρίς προηγούμενη διαβούλευση" (L25) | **IMPRECISE** | Works councils have **co-decision (συναπόφαση)** over the κανονισμός, not mere consultation | Ν.1767/1988 (→ ΚΕΔ arts 425–441) | KED-MAP; ypergasias |
| 3.6 | Illegal disciplinary penalties (μισθός-cut, fines, punitive transfer) (L37–41) | **OK** | Correct — pay-cuts/fines as discipline are unlawful | ΑΚ; case law | — |

### Detail — claim 3.2 (headline wrong citation)
- **Snippet (verbatim):** *"Σύμφωνα με τον Ν. 3996/2011, επιχειρήσεις με **70 ή περισσότερους εργαζόμενους** υποχρεούνται να έχουν γραπτό κανονισμό εργασίας."* and footer *"**Ν. 3996/2011** — Άρθρο 16 (υποχρέωση κανονισμού εργασίας για μεγάλες επιχειρήσεις)"*.
- **Replacement basis:** **ΝΔ 3789/1957 art.1** «Περί κανονισμών εργασίας». The κανονισμός may be established by (a) regulatory ΣΣΕ, (b) **joint decision of employer + works council (Ν.1767/1988)**, or (c) unilaterally by the employer under ΝΔ 3789/1957 **subject to approval by the Επιθεώρηση Εργασίας**.
- **Source (verbatim):** *"εφόσον απασχολούν προσωπικό περισσότερο από εβδομήντα (70) εργαζόμενους, έχουν υποχρέωση να καταρτίσουν κανονισμό εργασίας"* — https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/loipa-themata/kanonismoi-ergasias/kanonismoi-ergasias/ ; https://ypergasias.gov.gr/ergasiakes-scheseis/atomikes-ergasiakes-sxeseis/kanonismoi-ergasias-prosopikou/
- **Confidence: HIGH** (basis = ΝΔ 3789/1957 art.1; Ν.3996/2011 art.16 confirmed unrelated — deals with inspectors/doctors).

---

## FILE 4 — `vivlia-ergodoti.md` (Βιβλία & Αρχεία Εργοδότη)

### Checkable claims

| # | Claim (line) | Verdict | Correct value | Basis | Source |
|---|---|---|---|---|---|
| 4.1 | **Βιβλίο Αδειών** records annual leave dates/days/balance (L13–14) | **OK** | Correct; enhance with the **Ε11 / ΕΡΓΑΝΗ** mechanism (see below) | α.ν. 539/1945 art.4 | hli/ΕΡΓΑΝΗ |
| 4.2 | **Πίνακας Ωραρίου** submitted to ΕΡΓΑΝΗ **before any change** (L16–17) | **OK** | Schedule changes are pre-declared; actual hours now via ψηφιακή κάρτα | Ν.4808/2021; Ν.5053/2023 | brief §1/§3 |
| 4.3 | Falsifying hours is a criminal offence (ψευδής βεβαίωση) (L17, L34) | **OK** | Defensible characterisation | — | — |
| 4.4 | **Βιβλίο Εργατικών Ατυχημάτων** obligation (L19–20) | **OK** | Employer must keep an accident register | Κώδικας ΥΑΕ (Ν.3850/2010) | — |
| 4.5 | **Κατάσταση Προσωπικού (Ε4)** "ενημερωμένη σε **πραγματικό χρόνο**" (L22–23) | **IMPRECISE** | The Ε4 Πίνακας Προσωπικού is filed **annually + supplementary on changes**, not literally real-time | Ν.4225/2014; ΕΡΓΑΝΗ | — |
| 4.6 | "**ΠΔ 88/1999** — υποχρέωση τήρησης βιβλίων ωραρίου **και αδειών**" (L50) | **IMPRECISE** | ΠΔ 88/1999 organises **working time** (Dir 93/104); it is **not** the basis for the βιβλίο **αδειών** — that is **α.ν. 539/1945** | α.ν. 539/1945; ΠΔ 88/1999 | e-nomothesia |
| 4.7 | Institution "**ΣΕΠΕ**" (L32, L34, L39, L44, L48, tag) | **OUTDATED** | → Επιθεώρηση Εργασίας | Ν.4808/2021 | cross-cutting |

### Enhancement — claim 4.1 (βιβλίο αδειών mechanism)
- The **ειδικό Βιβλίο Αδειών** is reported to ΕΡΓΑΝΗ via **form Ε11** — *"εντός του μηνός Ιανουαρίου (από 01/01 έως και 31/01 εκάστου έτους)"* for the prior calendar year; non-compliance draws sanctions.
- **Source (verbatim):** *"Κάθε εργοδότης υποχρεούται να γνωστοποιεί, με το έντυπο Ε11 ηλεκτρονικά στο σύστημα ΕΡΓΑΝΗ … στοιχεία των εργαζομένων που έλαβαν την ετήσια άδεια … και έχουν καταχωρισθεί στο ειδικό Βιβλίο Αδειών."* — https://www.gov.gr/upourgeia/oloi-foreis/epitheorese-ergasias/etesies-adeies-ergane-e11 ; taxheaven 32143
- **Confidence: HIGH.**

### GAP 4 — missing employer books flagged by the task
- The file omits two mandatory records the task explicitly names: the **Ειδικό Βιβλίο Υπερωριών** (overtime register) and the **μισθολόγιο / payroll records** (analytical payroll retained for inspection). Both are standard Επιθεώρηση-Εργασίας inspection items. Recommend adding as new subsections. **Confidence: HIGH** they are real obligations; exact current citing instrument left to Phase D drafting (do not invent article numbers).

---

## FILE 5 — `vevaiosi-ergasias.md` (Βεβαίωση Εργασίας)

### Checkable claims

| # | Claim (line) | Verdict | Correct value | Basis | Source |
|---|---|---|---|---|---|
| 5.1 | Employer **must** issue on request, **free**, no false/extraneous content (no perf/discipline notes) (L33–35) | **OK** | Consistent with ΑΚ 678 (certificate limited to type/duration; quality/conduct only if the worker asks) | ΑΚ 678 | lawspot |
| 5.2 | Distinction βεβαίωση εργασίας (current) vs προϋπηρεσίας (past) (L20) | **OK** | Sound practical distinction | — | — |
| 5.3 | Salary shown **only if expressly requested** (L31) | **OK** | Reasonable; not contradicted | — | — |
| 5.4 | Legal basis "**ΑΚ 655** — Υποχρέωση εργοδότη να χορηγεί πιστοποιητικά εργασίας" (L55) | **WRONG** | The work-certificate article is **ΑΚ 678**. **ΑΚ 655 = "Πότε καταβάλλεται ο μισθός"** (timing of wage payment) — unrelated | ΑΚ 678 | lawspot |
| 5.5 | Institution "**ΣΕΠΕ**" (L43, tag) | **OUTDATED** | → Επιθεώρηση Εργασίας | Ν.4808/2021 | cross-cutting |

### Detail — claim 5.4
- **Snippet (verbatim):** *"**ΑΚ 655** — Υποχρέωση εργοδότη να χορηγεί πιστοποιητικά εργασίας"*.
- **Replacement:** *"**ΑΚ 678** — Πιστοποιητικό εργασίας"*.
- **Source (verbatim ΑΚ 678):** *"Κατά τη λήξη της σύμβασης ο εργαζόμενος μπορεί να απαιτήσει από τον εργοδότη πιστοποιητικό για το είδος και τη διάρκεια της εργασίας του. Μόνο αν το ζητήσει ειδικά ο εργαζόμενος, βεβαιώνεται και η ποιότητα της εργασίας του και η διαγωγή του."* — https://www.lawspot.gr/nomothesia/astikos-kodikas/arthro-678-astikos-kodikas-pistopoiitiko-ergasias/
- **Note:** ΑΚ 678 speaks of the certificate *"κατά τη λήξη της σύμβασης"*; for a *current-employment* βεβαίωση the duty rests on ΑΚ 678 applied by analogy + good faith (ΑΚ 288) — but ΑΚ 655 is simply the wrong article either way.
- **Confidence: HIGH.**

---

## FILE 6 — `vevaiosi-proypiresias.md` (Βεβαίωση Προϋπηρεσίας)

### Checkable claims

| # | Claim (line) | Verdict | Correct value | Basis | Source |
|---|---|---|---|---|---|
| 6.1 | Employer must issue a service certificate **regardless of reason for termination**, and during employment on request (L9, L22–23) | **OK** | Matches ΑΚ 678 | ΑΚ 678 | lawspot |
| 6.2 | Required content (name, title, start/end dates, contract type, reason for termination) (L13–18) | **OK** | Type & duration are core (ΑΚ 678); reason-of-termination is customary | ΑΚ 678 | lawspot |
| 6.3 | No false/misleading content; false "σπουδαίος λόγος" = αδικοπραξία (L26–27) | **OK** | Sound | ΑΚ 914 | — |
| 6.4 | Legal basis "**ΑΚ άρθρο 655** — Υποχρέωση χορήγησης βεβαίωσης" (L44) | **WRONG** | → **ΑΚ 678** (ΑΚ 655 = wage-payment timing) | ΑΚ 678 | lawspot |
| 6.5 | "**Ν. 2112/1920** — Λήξη σύμβασης" & "**Ν. 1545/1985** — Ρύθμιση αγοράς εργασίας" as bases (L45–46) | **IMPRECISE** | Neither establishes the certificate duty; they are **context** (Ν.2112/1920 = notice/severance; Ν.1545/1985 = ΟΑΕΔ/unemployment, why the certificate is needed for the ΔΥΠΑ benefit). The certificate duty is **ΑΚ 678** | ΑΚ 678 | lawspot |
| 6.6 | Institution "**ΣΕΠΕ**" + hyperlink **sepe.gov.gr** (L39, tag) | **OUTDATED** | → Επιθεώρηση Εργασίας; link → **hli.gov.gr** | Ν.4808/2021 | cross-cutting |

### Detail — claim 6.4 (same error as 5.4)
- **Snippet (verbatim):** *"ΑΚ άρθρο 655 — Υποχρέωση χορήγησης βεβαίωσης"*.
- **Replacement:** *"ΑΚ 678 — Πιστοποιητικό εργασίας"*.
- **Source:** as claim 5.4. **Confidence: HIGH.**

---

## SUMMARY OF HIGH-CONFIDENCE CHANGES (for Phase D/E)

1. **Quota fix (anangestikes 2.2):** "2% έως 8%, ποικίλει" → **flat 8%** of workforce; threshold **>50** employees. Basis **Ν.2643/1998 art.2 §1**. *(Biggest factual error.)*
2. **Certificate article (vevaiosi ×2, 5.4/6.4):** **ΑΚ 655 → ΑΚ 678** (Πιστοποιητικό εργασίας). ΑΚ 655 = wage-payment timing.
3. **Work-regulations basis (kanonismos 3.2):** **Ν.3996/2011 art.16 → ΝΔ 3789/1957 art.1**; threshold "**more than** 70".
4. **ΣΕΠΕ → Επιθεώρηση Εργασίας** across all six files (Ν.4808/2021, op. 19.7.2022); fix sepe.gov.gr → hli.gov.gr; keep 1555.
5. **Two on-topic gaps to add:** Ν.5239/2025 **single-document digital hiring** (myErgani acceptance) and Ν.5053/2023 **essential-terms written notice** (Dir 2019/1152; 1-week/1-month deadlines) → **ΚΕΔ arts 70–77**.

## GAPS / UNVERIFIABLE
- **Per-category sub-split of the Ν.2643/1998 8% quota** — not obtainable verbatim (paywalled/corrupt sources) → do not assert numbers.
- **βιβλίο υπερωριών + μισθολόγιο** — real obligations, absent from vivlia-ergodoti.md; add in Phase D without inventing article numbers.
- **Public-sector ΑμεΑ reduced hours (anangestikes 2.6)** — corrected to a **1-hour/day** statutory reduction for defined categories; the corpus's "6-hour day at the occupational physician's discretion" is wrong (**Confidence: MEDIUM**, peripheral public-sector point in a private-sector corpus).
- **ΚΕΔ arts 83–93 ↔ Ν.2643/1998 mapping** — flagged to-verify, not asserted.

---

## SOURCES
- ypergasias.gov.gr — Ν.5239/2025 (single-document hiring): https://ypergasias.gov.gr/ergani/nomos-5239-2025-dikaii-ergasia-gia-olous/ ; Κανονισμοί Εργασίας: https://ypergasias.gov.gr/ergasiakes-scheseis/atomikes-ergasiakes-sxeseis/kanonismoi-ergasias-prosopikou/
- hli.gov.gr — Κανονισμοί Εργασίας (ΝΔ 3789/1957, >70): https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/loipa-themata/kanonismoi-ergasias/kanonismoi-ergasias/ ; ΑμεΑ υποχρέωση πρόσληψης (8%, >50): https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/prostasia/amea-kai-alla-prostatefomena-prosopa/ypochreosi-proslipsis-kai-apascholisis/ ; Επιθεώρηση Εργασίας profile (ΣΕΠΕ→): https://www.hli.gov.gr/en/organisation/profile/
- lawspot.gr — ΑΚ 678 Πιστοποιητικό εργασίας: https://www.lawspot.gr/nomothesia/astikos-kodikas/arthro-678-astikos-kodikas-pistopoiitiko-ergasias/
- gov.gr / taxheaven — Ε11 βιβλίο αδειών (ΕΡΓΑΝΗ, Ιανουάριος): https://www.gov.gr/upourgeia/oloi-foreis/epitheorese-ergasias/etesies-adeies-ergane-e11 ; https://www.taxheaven.gr/circulars/32143/
- kepea.gr / elinyae.gr — Ν.5053/2023 deadlines (1 wk/1 mo, Dir 2019/1152, ΠΔ 156/1994 repeal): https://www.kepea.gr/oi-simantikoteres-diataxeis-n-5053-2023 ; ΚΕΔ ΠΔ 62/2025: https://www.elinyae.gr/ethniki-nomothesia/pd-622025-fek-121a-1172025
- Ν.4554/2018 art.5 penalty (€10.500 / €7.000): e-ΕΦΚΑ Εγκ.36/2018 (forin 24938); https://www.lawspot.gr/nomika-nea/dimosieythike-o-nomos-4554-2018-...
- ypes.gr — public-sector ΑμεΑ reduced hours (1h/day): https://www.ypes.gr/meiomeno-orario-ergasias-logo-anapirias/
- KED-MAP (internal): ΚΕΔ ΠΔ 62/2025 arts 70–77 (transparency), 425–441 (work rules), 83–93 (disability quota).

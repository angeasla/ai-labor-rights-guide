# NEW ARTICLES — Greek Labour-Law Corpus Audit

**Date:** 2026-07-13. Nine new articles were drafted to close confirmed coverage gaps, then put through an **adversarial (refutation-first) legal-accuracy review** — every day-count, %, €, age, date, law/article, ΚΕΔ article and wikilink was checked against a primary/authoritative source and an attempt made to refute it. **All 9 passed.** Two content corrections and five wikilink fixes were applied during review; one reference-doc bug they exposed (KED-MAP unpaid-leave originating article) was corrected this pass.

These 9 files are git-untracked (new); corpus total is now 102 files (93 modified + 9 new).

---

## adeies/ — leave articles (5)

### 1. `adeies/anoteras-vias.md` — «Άδεια Ανωτέρας Βίας»
- **Legal basis:** Ν.4808/2021 **άρθρο 30** (Οδηγία (ΕΕ) 2019/1158 art.7) → **ΚΕΔ (ΠΔ 62/2025) άρθρο 233**; Εγκύκλιος 47972/2021.
- **Core:** ≤2 φορές/έτος, ≤1 εργάσιμη ημέρα κάθε φορά, **με αποδοχές**, καμία προϋπόθεση προϋπηρεσίας; δικαιολογητικό = ιατρική γνωμάτευση.
- **Primary source:** opengov.gr/minlab (art.30 bill text) · hli.gov.gr «Απουσία για λόγους ανωτέρας βίας».
- **Adversarial review:** SOUND — no factual refutations. One broken wikilink fixed: `[[Γονικής Άδειας Ανατροφής|…]]` → `[[Γονική Άδεια Ανατροφής Τέκνων|…]]`.

### 2. `adeies/gynaikologikos-elegxos.md` — «Άδεια Γυναικολογικού Ελέγχου»
- **Legal basis:** Ν.5043/2023 **άρθρο 96** (τροποποιεί Ν.4808/2021 **άρθρο 40**) → **ΚΕΔ άρθρο 242**.
- **Core:** **1 ημέρα/έτος, με αποδοχές**; extended to the **private sector** in 2023 (already applied in the public sector). Correctly rebuts the "2×/year" hypothesis — it is 1×/yr; δικαιολογητικό = βεβαίωση θεράποντος ιατρού.
- **Primary source:** taxheaven (ΦΕΚ Ν.5043/2023 art.96) · kepea.gr · hli.gov.gr «Άδεια προγεννητικών εξετάσεων και γυναικολογικού ελέγχου».
- **Adversarial review:** SOUND — no wikilink/frontmatter issues.

### 3. `adeies/penthos.md` — «Άδεια Πένθους»
- **Legal basis:** **2 ημέρες με αποδοχές** = ΕΓΣΣΕ 2002-03 άρθρο 9 (εξ αγχιστείας: ΕΓΣΣΕ 2010-2012 άρθρο 8); **20 ημέρες με αποδοχές** για απώλεια τέκνου = Ν.5018/2023 **άρθρο 93** (ΦΕΚ Α΄25/9.2.2023) → **ΚΕΔ άρθρο 246**.
- **Core:** 2 days for σύζυγος/τέκνο/γονέα/αδελφό (+ εξ αγχιστείας same line/degree), no seniority gate; 20 paid days for bereaved parents (φυσικοί/θετοί/ανάδοχοι + τεκμαιρόμενες μητέρες), ιδιωτικός + δημόσιος.
- **Primary source:** hli.gov.gr «Άδεια λόγω θανάτου συγγενούς» · kepea.gr «άδεια πενθούντων γονέων» · elinyae (Ν.5018/2023, ΦΕΚ 25/Α).
- **Adversarial review:** SOUND — all wikilinks resolve. (Residual LOW: primary list also names «φροντιστές»; frontmatter tags omit Ν.5018/2023 — cosmetic.)

### 4. `adeies/aneu-apodoxon.md` — «Άδεια Άνευ Αποδοχών»
- **Legal basis:** Ν.4808/2021 **άρθρο 62** → **ΚΕΔ άρθρο 255**.
- **Core:** έως 1 έτος (παράταση με νέα έγγραφη συμφωνία); ατομική έγγραφη συμφωνία (δεν επιβάλλεται); σύμβαση σε **αναστολή** (όχι λύση); ανάρτηση ΕΡΓΑΝΗ + κοινοποίηση e-ΕΦΚΑ; **δεν οφείλονται ασφαλιστικές εισφορές**.
- **Primary source:** hli.gov.gr «Άδεια άνευ αποδοχών» (explicitly cites Ν.4808/2021 art.62).
- **Adversarial review:** SOUND — resolves a reference-doc conflict in the article's favour: primary (hli.gov.gr) + CURRENCY-BRIEF confirm originating **art.62**, whereas KED-MAP row 40 had listed **art.50** (M-confidence). **KED-MAP corrected to art.62 this pass.**

### 5. `adeies/frontisti.md` — «Άδεια Φροντιστή»
- **Legal basis:** Ν.4808/2021 **άρθρο 29** (Οδηγία (ΕΕ) 2019/1158 art.6) → **ΚΕΔ άρθρο 232**; Εγκύκλιος 47972/2021.
- **Core:** έως 5 εργάσιμες ημέρες/έτος, **ΑΝΕΥ αποδοχών**; προϋπόθεση **6 μήνες** συνεχούς/διαδοχικής απασχόλησης; μόνο δικαιολογητικό = ιατρική γνωμάτευση; comparison table vs ανωτέρα βία all cells verified.
- **Primary source:** hli.gov.gr «Άδεια φροντιστή».
- **Adversarial review:** SOUND — all wikilinks resolve.

---

## syntaxi/ — pension articles (3)

### 6. `syntaxi/epikouriki-teka.md` — «Επικουρική Σύνταξη & ΤΕΚΑ»
- **Legal basis:** Ν.4826/2021 (ΤΕΚΑ, κεφαλαιοποιητικό/defined-contribution; **άρθρο 53** Επιστροφή εισφορών, **άρθρο 60** Κρατική εγγύηση — real/indexed value floor). Auxiliary contribution **6% (3%+3%) from 1.6.2022** (6,5% until 31.5.2022). Πρωτοασφαλισμένοι από **1.1.2022 → ΤΕΚΑ**; pre-2022 → διανεμητικό (ex-ΕΤΕΑΕΠ, e-ΕΦΚΑ).
- **Primary source:** teka.gov.gr/contributions · taxheaven (Ν.4826/2021 TOC, art.53/60 titles) · opengov (art.60) · CURRENCY-BRIEF §5.
- **Adversarial review:** SOUND — no factual refutations; wikilinks fixed (`[[Εθνική & Ανταποδοτική Σύνταξη|…]]`→`[[Συνταξιοδότηση|…]]`, ×2).

### 7. `syntaxi/efapax.md` — «Εφάπαξ»
- **Legal basis:** **άρθρο 35 Ν.4387/2016** (αντικ. άρθρο 31 Ν.4670/2020); χορηγείται από τον **Κλάδο Εφάπαξ Παροχών e-ΕΦΚΑ** (πρ. ΕΤΕΑΕΠ). Two-part calc — Τμήμα Α΄ (έως 31.12.2013) 60%×αποδοχές αναφοράς×έτη for 4%-contributors; Τμήμα Β΄ (από 1.1.2014) NDC/νοητή κεφαλαιοποίηση.
- **Core (KEY):** coverage is **NOT universal** — only for those insured in a ταμείο/κλάδο/λογαριασμό πρόνοιας; article explicitly rebuts "όλοι παίρνουν εφάπαξ".
- **Primary source:** lawspot (Ν.4387/2016 art.35) · opengov (Ν.4670/2020 art.31).
- **Adversarial review:** SOUND — wikilinks fixed. (Residual LOW: 6-month processing deadline / αναπηρία-≥50% priority / 4%-from-2017 date unsourced but plausible.)

### 8. `syntaxi/syntaxi-thanatou.md` — «Σύνταξη λόγω Θανάτου»
- **Legal basis:** **άρθρο 12 Ν.4387/2016** (am. **άρθρο 19 Ν.4611/2019**, ισχύς 17.5.2019).
- **Core:** επιζών σύζυγος **70%**, τέκνα **25%** each έως 24 (lifelong if ≥67% ανάπηρα), aggregate cap = deceased's pension; 3-year marriage/σύμφωνο rule (5→3, age-55 abolished); post-3-year reduction to 35% if working/own pension (full 70% if ≥67% ανάπηρος); προσωρινή = 50% οριστικής; work-accident death min **€893,75** (1.1.2026); divorced-spouse conditions.
- **Primary source:** e-efka.gov.gr «Σύνταξη λόγω θανάτου / Προϋποθέσεις & Ποσό» · lawspot (Ν.4611/2019 art.19).
- **Adversarial review:** FIXED — αναβίωση/ανασύσταση combined-marriage duration **"≥5 έτη" → "≥3 έτη"** (the ≥5 was the pre-2019 threshold; Ν.4611/2019 cut 5→3); wikilink fixed. Otherwise SOUND.

---

## symvasi/ — contract/protection article (1)

### 9. `symvasi/prostasia-martyron.md` — «Προστασία Μαρτύρων Δημοσίου Συμφέροντος» (whistleblower)
- **Legal basis:** **Ν.4990/2022** (ΦΕΚ Α΄210/11.11.2022, ενσωμάτωση Οδηγίας (ΕΕ) 2019/1937). No ΚΕΔ article (separate transposition, correctly not codified in ΚΕΔ).
- **Core:** scope = EU-law violations only (art.4); internal channel + **ΥΠΠΑ** mandatory for **50+** employees (ιδιωτικός art.9); **ΕΑΔ** = external channel (art.11); ack ≤7 εργάσιμες, response ≤3 μήνες; **reversed burden of proof = άρθρο 20**; απαγόρευση αντιποίνων art.17; κυρώσεις art.23.
- **Primary source:** e-nomothesia.gr (Ν.4990/2022 full text + article titles).
- **Adversarial review:** SOUND — no change. The flagged burden-of-proof article was verified **CORRECT at art.20** (a secondary source had mis-stated "art.17"; the primary text vindicates the article).

---

## Summary of review outcomes
- **SOUND (no factual change):** anoteras-vias, gynaikologikos-elegxos, penthos, aneu-apodoxon, frontisti, epikouriki-teka, efapax, prostasia-martyron.
- **FIXED (factual correction applied):** syntaxi-thanatou (αναβίωση ≥5→≥3 έτη).
- **Wikilinks fixed during review:** anoteras-vias (×1) + epikouriki-teka (×2) + efapax (×1) + syntaxi-thanatou (×1) = 5.
- **Reference-doc bug exposed & fixed:** KED-MAP row 40 unpaid-leave originating article art.50 → **art.62** (corrected this pass).

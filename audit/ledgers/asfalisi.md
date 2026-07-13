# AUDIT LEDGER — Batch `asfalisi`

**Auditor role:** Greek social-insurance specialist, adversarial legal-currency fact-check.
**Date of audit:** 2026-07-13.
**Corpus path:** `src/main/resources/docs/asfalisi/`
**Files:** efka.md · eisfores.md · ergani.md · ergosimo.md · tekmarto-imeromisthio.md · index.md
**Method:** every checkable claim (%, €, law/ΦΕΚ, ΥΑ) extracted, verified against CURRENCY-BRIEF §3 **and** fresh primary/authoritative fetch (e-efka.gov.gr, ypergasias.gov.gr, hli.gov.gr, e-nomothesia.gr, ΦΕΚ mirrors on taxheaven/lawspot/forin/pim). `kepea.gr`, `aftodioikisi.gr`, `forin.gr` returned HTTP 403 to WebFetch; used their WebSearch snippets + non-blocked mirrors instead.
**Rule:** unconfirmable ⇒ UNVERIFIABLE. No corpus files edited.

---

## VERDICT TALLY

| File | OK | WRONG | OUTDATED | IMPRECISE | UNVERIFIABLE |
|---|---|---|---|---|---|
| efka.md | 5 | 3 | 1 | 1 | 0 |
| eisfores.md | 5 | 4 | 2 | 1 | 1 (ΔΥΠΑ internal split only) |
| ergani.md | 5 | 1 | 0 | 1 | 0 |
| ergosimo.md | 4 | 0 | 0 | 1 | 0 |
| tekmarto-imeromisthio.md | 3 | 0 | 0 | 2 | 0 |
| index.md | 3 | 0 | 0 | 1 | 0 |

**Headline:** `eisfores.md` is the critical file — **totals + both ceilings are RIGHT, but 4 of 6 line-items are wrong/outdated and the columns don't add up.** `ergani.md` has a fabricated ΥΑ number. `efka.md` mis-states the e-ΕΦΚΑ rebrand law, the ΝΑΤ status, and conflates εφάπαξ with ΤΕΚΑ.

---

## FILE 1 — `eisfores.md`  (PRIORITY)

### Contribution-rate table (lines 12–22)

Corpus table verbatim:

```
## Ποσοστά εισφορών (2025) — μισθωτοί ιδιωτικού τομέα
| Κλάδος | Εργαζόμενος | Εργοδότης | Σύνολο |
| Κύρια σύνταξη (e-ΕΦΚΑ) | 6,67% | 13,33% | 20,00% |
| Επικουρική σύνταξη (e-ΕΦΚΑ) | 3,00% | 3,00% | 6,00% |
| Υγεία — παροχές σε είδος (ΕΟΠΥΥ) | 2,15% | 4,30% | 6,45% |
| Υγεία — παροχές σε χρήμα | 0,40% | 0,75% | 1,15% |
| Ανεργία (ΔΥΠΑ) | 1,07% | 2,13% | 3,20% |
| Εφάπαξ (ΤΕΚΑ) | ~0,08% | ~0,28% | ~0,36% |
| **Σύνολο (2025)** | **~13,37%** | **~21,79%** | **~35,16%** |
```

| # | Claim | Verdict | Correct value | Legal basis | Source |
|---|---|---|---|---|---|
| 1.1 | Κύρια σύνταξη 6,67 / 13,33 / 20,00 | **OK** | — | art.38 Ν.4387/2016 | ypergasias.gov.gr |
| 1.2 | Επικουρική 3,00 / 3,00 / 6,00 | **OK** | (=ΤΕΚΑ/ΕΤΕΑΕΠ, 3+3 από 1.6.2022) | Ν.4826/2021 | ypergasias.gov.gr |
| 1.3 | Υγεία σε είδος 2,15 / 4,30 / 6,45 | **WRONG / OUTDATED** | **1,65 / 3,80 / 5,45** (από 1.1.2025) | art.12 **Ν.5162/2024** (ΦΕΚ Α΄198/5.12.2024) τροπ. art.41 §1 Ν.4387/2016 · e-ΕΦΚΑ **Εγκ. 38/2024** | taxheaven 69555 |
| 1.4 | Υγεία σε χρήμα 0,40 / 0,75 / 1,15 | **WRONG / OUTDATED** | **0,40 / 0,25 / 0,65** | ditto (συνολικά υγεία 6,10%) | taxheaven 69555 |
| 1.5 | Ανεργία (ΔΥΠΑ) 1,07 / 2,13 / 3,20 | **WRONG** | ΔΥΠΑ/λοιπά residual **1,65 / 1,41 / 3,06** | see derivation below | derived + brief §3 |
| 1.6 | Εφάπαξ (ΤΕΚΑ) ~0,08 / ~0,28 / ~0,36 | **WRONG (bogus row)** | **DELETE** — no separate εφάπαξ εισφορά for standard μισθωτούς; ΤΕΚΑ = the 6% επικουρική already in row 1.2 | brief §3 | katharosmisthos guide ("No separate εφάπαξ") |
| 1.7 | Σύνολο 13,37 / 21,79 / 35,16 | **OK** (totals) — but line-items do **not** sum to them | see arithmetic | brief §3 | multiple |
| 1.8 | Note "Οι επιμέρους ποσοστοί του ΤΕΚΑ εξαρτώνται από κλάδο και ειδικότητα" | **WRONG/misleading** | ΤΕΚΑ = 3%+3% flat; the note only exists to prop the bogus row 1.6 | Ν.4826/2021 | — |

**Verbatim health-branch quote (Εγκ. 38/2024):** *"η ασφαλιστική εισφορά υπέρ υγειονομικής περίθαλψης των μισθωτών ορίζεται σε ποσοστό 6,10% ... κατανέμεται κατά ποσοστό 5,45% για παροχές σε είδος, εκ του οποίου 1,65% βαρύνει τον ασφαλισμένο και 3,80% τον εργοδότη, και ποσοστό 0,65% για παροχές σε χρήμα, εκ του οποίου 0,40% βαρύνει τον ασφαλισμένο και 0,25% βαρύνει τον εργοδότη."*
Source: https://www.taxheaven.gr/news/69555 · primary PDF: e-efka.gov.gr Εγκ.38/2024.

**Arithmetic proof the corpus columns are broken.**
Corpus **employer** column: 13,33+3,00+4,30+0,75+2,13+0,28 = **23,79%** — but stated **21,79%** (off +2,00).
Corpus **total** column: 20,00+6,00+6,45+1,15+3,20+0,36 = **37,16%** — but stated **35,16%** (off +2,00).
(The employee column *happens* to sum to 13,37.) So the stated grand totals are correct, the line-items are not.

**Corrected, self-consistent table (2025 = 2026; branch rates unchanged, only ceiling rose):**

| Κλάδος | Εργαζόμενος | Εργοδότης | Σύνολο |
|---|---|---|---|
| Κύρια σύνταξη | 6,67% | 13,33% | 20,00% |
| Επικουρική (ΤΕΚΑ/ΕΤΕΑΕΠ) | 3,00% | 3,00% | 6,00% |
| Υγεία — σε είδος | 1,65% | 3,80% | 5,45% |
| Υγεία — σε χρήμα | 0,40% | 0,25% | 0,65% |
| ΔΥΠΑ / λοιπά (ανεργία, ΛΑΕΚ κ.λπ.) | 1,65% | 1,41% | 3,06% |
| **Σύνολο** | **13,37%** | **21,79%** | **35,16%** |

Derivation of the ΔΥΠΑ/λοιπά residual: 35,16 − (20,00 + 6,00 + 5,45 + 0,65) = **3,06%**; employee 13,37 − 11,72 = **1,65%**, employer 21,79 − 20,38 = **1,41%**. This is arithmetically forced by the (confirmed) grand totals and the (confirmed) four branches — **not invented**.
**UNVERIFIABLE:** the *internal* split of that 3,06% into ανεργία / ΛΑΕΚ / εργατική κατοικία-εστία for the current year — KEPEA (which publishes it) returns 403 and the non-blocked mirrors returned only stale pre-reform ΟΑΕΔ figures (e.g. "1,83/3,17"), which are inconsistent with a 35,16% total and were rejected. Present as a single aggregate line. Confidence: **high** on 3,06 aggregate; **low** on any finer split.

### Ceilings (lines 44–47)

| # | Claim | Verdict | Basis | Source |
|---|---|---|---|---|
| 1.9 | 2025 ανώτατο €7.572,62 | **OK** | Εγκ. 4/2025 · ΥΑ Δ.15/Δ'/1984/2025, ΦΕΚ Β΄241/29.1.2025 (+2,7%) | forin 83309; taxheaven 49495 |
| 1.10 | 2026 ανώτατο €7.761,94 | **OK** | e-ΕΦΚΑ **Εγκ. 4/2026** (+2,5% ΔΤΚ) | forin 88879; e-efka Εγκ.4/2026; aftodioikisi |

Verbatim (Εγκ. 4/2026): *"το ανώτατο όριο ασφαλιστέων αποδοχών διαμορφώνεται ... στο ποσό των 7.761,94 € μηνιαίως"* (effective 01.01.2026). Cross-check: 7.572,62 × 1,025 = 7.761,94 ✓.

### Penalty for non-payment (lines 87–89)

Corpus verbatim: *"ο εργοδότης διώκεται ποινικά βάσει **Ν. 86/1967** — η ποινή μπορεί να φθάσει έως **5 χρόνια κάθειρξη** για υπότροπους ή συστηματικούς παραβάτες."*

| # | Claim | Verdict | Correction |
|---|---|---|---|
| 1.11 | "Ν. 86/1967" | **WRONG (label)** | It is **ΑΝ 86/1967** (Αναγκαστικός Νόμος), not "Ν." |
| 1.12 | "έως 5 χρόνια **κάθειρξη**" | **WRONG (mis-classification)** | Penalty is **φυλάκιση** (πλημμέλημα), not κάθειρξη (κακούργημα, ≥5 έτη). ΑΝ 86/1967 **art.1** (εργοδοτικές εισφ.): **φυλάκιση τουλάχιστον 3 μηνών** + χρηματική ποινή, όταν οφειλή > €20.000. **art.2** (παρακρατηθείσες εισφ. εργαζομένου): **φυλάκιση τουλάχιστον 6 μηνών**, κατώφλι €10.000 (κατώφλια Ν.3904/2010). Το "5 χρόνια" απλώς είναι το γενικό ανώτατο της φυλάκισης, όχι ρητό όριο του ΑΝ 86/1967. |

Source: efotopoulou.gr; tpvlaw.gr (ΑΝ 86/1967); AΠ 229/2023 (taxheaven 43518). Confidence: **high**.

**Other eisfores.md claims — OK:** ασφαλισμένος χρόνος αναγνωρίζεται βάσει δήλωσης Εργάνη (line 56–57); e-ΕΦΚΑ έλεγχος ιστορικού (98–114); ΣΕΠΕ 1555 (61). No false numbers.

---

## FILE 2 — `efka.md`

| # | Claim (line) | Verdict | Finding / correction | Basis | Source |
|---|---|---|---|---|---|
| 2.1 | "δημιουργήθηκε με τον Ν. 4387/2016 από τη συγχώνευση ΙΚΑ-ΕΤΑΜ, ΟΑΕΕ, ΟΓΑ, ΕΤΑΑ…" (9-10) | **OK** | Accurate for the 1.1.2017 ΕΦΚΑ formation | Ν.4387/2016 | e-nomothesia |
| 2.2 | "Από **το 2022** λειτουργεί … με το brand name **e-ΕΦΚΑ**" (11) | **WRONG / OUTDATED** | Rename to "Ηλεκτρονικός Εθνικός Φορέας Κοινωνικής Ασφάλισης (e-ΕΦΚΑ)" took effect **1.3.2020** by **Ν.4670/2020** (ΦΕΚ Α΄43/28.2.2020), which also absorbed **ΕΤΕΑΕΠ** (επικουρική + εφάπαξ). Not 2022. | Ν.4670/2020 | forin law 3842; e-efka.gov.gr/el/eephka; e-nomothesia |
| 2.3 | Κλάδος "5. **Εφάπαξ — μέσω ΤΕΚΑ** για νεοεισερχόμενους" (21) | **WRONG** | Two conflations: (a) **Εφάπαξ** is paid by the **Κλάδος Εφάπαξ Παροχών του e-ΕΦΚΑ** (πρ. ΕΤΕΑΕΠ), art.35 Ν.4387/2016 — **not** ΤΕΚΑ. (b) **ΤΕΚΑ** (Ν.4826/2021) covers **ΕΠΙΚΟΥΡΙΚΗ** for first-insured from 1.1.2022 — i.e. row "2. Επικουρική", not εφάπαξ. Fix: "Επικουρική — μέσω ΤΕΚΑ για νεοεισερχόμενους (από 1.1.2022)" **και** "Εφάπαξ — Κλάδος Εφάπαξ Παροχών e-ΕΦΚΑ (art.35 Ν.4387/2016)". | Ν.4826/2021; art.35 Ν.4387/2016; Ν.4670/2020 | e-efka.gov.gr/el/eephka; teka.gov.gr |
| 2.4 | "Ναυτικοί ασφαλίζονται στο ΝΑΤ … **παραμένει ξεχωριστό και δεν ενσωματώθηκε στον ΕΦΚΑ**" (32-33) | **WRONG** | **ΝΑΤ** (μαζί με Κεφ. Δυτών & ΚΑΑΝ) **εντάχθηκε στον ΕΦΚΑ από 1.1.2017**, **art.53 §1 Ν.4387/2016**. Διατήρησε αυτοτελή νομική προσωπικότητα **μόνο για τις μη-ασφαλιστικές** αρμοδιότητες. Η ασφάλιση των ναυτικών γίνεται πλέον εντός e-ΕΦΚΑ (ΑΠΔ Ναυτικών). | art.53 §1 Ν.4387/2016; Εγκ. 48/2017 | e-efka .../naytikoi; forin 23138; opengov art.53 |
| 2.5 | Δημοσιογράφοι / Εικαστικοί / Αγρότες ειδικές διατάξεις εντός ΕΦΚΑ (34-37) | **IMPRECISE** | Κύρια σύνταξη ναι (ΟΓΑ πλήρως, ex-ΕΤΑΠ-ΜΜΕ). Nuance not asserted: journalists' **ΕΔΟΕΑΠ** (υγεία/επικ./πρόνοια) stayed outside ΕΦΚΑ — **not independently re-verified**, flagged not asserted. | — | — (UNVERIFIABLE nuance) |
| 2.6 | "ασφαλίζονται … από την πρώτη ημέρα εργασίας" / αναδρομική ασφάλιση / e-ΕΦΚΑ online (25-100) | **OK** | Accurate principles; no false figures | — | efka.gov.gr |
| 2.7 | Νομοθεσία list Ν.4387/2016 / Ν.4670/2020 / Ν.4808/2021 (108-110) | **OK** | Correct laws. Minor: Ν.4670/2020 label "Ασφαλιστική μεταρρύθμιση" should note it is the **e-ΕΦΚΑ rename + ΕΤΕΑΕΠ merger** law. | — | e-nomothesia |

Confidence 2.2 / 2.3 / 2.4: **high**.

---

## FILE 3 — `ergani.md`

| # | Claim (line) | Verdict | Finding / correction | Basis | Source |
|---|---|---|---|---|---|
| 3.1 | Πρόσληψη αναγγέλλεται **πριν** την έναρξη (13) | **OK** | — | Ν.4808/2021; Εργάνη | hli.gov.gr |
| 3.2 | Αποχώρηση/απόλυση δήλωση **εντός 4 εργάσιμων ημερών** (14) | **OK** | Confirmed: οικειοθελής αποχώρηση αναγγέλλεται ≤4 εργάσιμες από την αποχώρηση; αλλιώς τεκμαίρεται **άκυρη απόλυση**. (Enhancement, not error: add deemed-resignation μετά 5 συνεχείς εργάσιμες αδικαιολόγητης απουσίας, **art.23 Ν.5053/2023**.) | art.23 Ν.5053/2023 | hli.gov.gr; grammenoslegal |
| 3.3 | Ψηφιακή κάρτα "**Από το 2022**" σε κλάδους (18-20) | **OK** | Pilot 2022 (τράπεζες/σούπερ μάρκετ), σταδιακή επέκταση | Ν.4808/2021 arts 73-74 | hli.gov.gr |
| 3.4 | Πρόστιμο "**από 10.500 € ανά εργαζόμενο** για πρώτη παράβαση" (34) | **OK / MATCHES** | Basis to add: **art.5 Ν.4554/2018**. Reductions €7.000 (πρόσληψη 3 μήνες ΠΑ) / €3.000 (1 έτος); υποτροπή εντός 3ετίας +100% / +200%. (NB distinct from the **ψηφιακή-κάρτα** €10.500/εργαζ., art.22 Ν.5053/2023.) | art.5 Ν.4554/2018 | government.gov.gr; lawspot; e-efka prostima |
| 3.5 | Νομοθεσία "**Ν. 3996/2011 — Σύσταση πληροφοριακού συστήματος Εργάνη**" (45) | **IMPRECISE** | Ν.3996/2011 (ΦΕΚ Α΄170/5.8.2011) is the **enabling** law (αναμόρφωση ΣΕΠΕ· κάρτα εργασίας art.26). The **ΠΣ ΕΡΓΑΝΗ was actually established by ΥΑ 5072/6/25.2.2013 (ΦΕΚ Β΄449)**. Add that ΥΑ. | Ν.3996/2011 + ΥΑ 5072/6/2013 | elinyae; ergasiaka-gr |
| 3.6 | Νομοθεσία "Ν. 4808/2021 — Ψηφιακή κάρτα εργασίας" (46) | **OK** | ΕΡΓΑΝΗ ΙΙ arts 73-74 | — | opengov art.73 |
| 3.7 | Νομοθεσία "**ΥΑ 80488/2021** — Λεπτομέρειες εφαρμογής ΕΡΓΑΝΗ ΙΙ" (47) | **WRONG / UNVERIFIABLE** | No ΕΡΓΑΝΗ ΙΙ implementing decision found under **80488/2021**. Real instruments: **ΥΑ 49758/26.5.2022 (ΦΕΚ Β΄2668)** «Εφαρμογή Συστήματος Ψηφιακής Κάρτας Εργασίας … στο Π.Σ. ΕΡΓΑΝΗ ΙΙ» **και ΥΑ 80016/2022 (ΦΕΚ Β΄4629)** (κατηγοριοποίηση παραβάσεων/πρόστιμα). Κάρτα επεκτάθηκε με **ΥΑ 24595/2024 (Β΄1966)** & **ΥΑ 18047/2026 (Β΄3791)**. | ΥΑ 49758/2022; 80016/2022 | champier.gr; forin 91140 (ΥΑ 18047/2026); elinyae |

Verbatim (ΥΑ 49758/2022): *"49758/26-05-2022 Εφαρμογή Συστήματος Ψηφιακής Κάρτας Εργασίας … στο Π.Σ. ΕΡΓΑΝΗ ΙΙ"*. Confidence 3.7 replacement: **high** (real, current, correct ΦΕΚ); characterisation of 80488/2021 itself: **UNVERIFIABLE** (no matching instrument located).

---

## FILE 4 — `ergosimo.md`

| # | Claim (line) | Verdict | Finding | Basis | Source |
|---|---|---|---|---|---|
| 4.1 | "**~25%** αποδίδεται στον ΕΦΚΑ" / "~75% καθαρή αμοιβή" (23-24) | **OK / MATCHES** | 25% withholding confirmed (raised **from 20% to 25% on 23.5.2013**). | art.20 Ν.3863/2010 **as amended by art.74 Ν.4144/2013** | lawspot arthro-20; taxheaven |
| 4.2 | Μηχανισμός ΕΛ.ΤΑ. / τράπεζα / ψηφιακή πλατφόρμα (13-15) | **OK** | Broadly accurate (εργόσημο ΕΛΤΑ + τραπεζικό). Minor: increasingly digital/bank-issued. | — | epilogic.gr |
| 4.3 | "γεννά ημέρες ασφάλισης … από πολλούς εργοδότες" (30) | **OK** | Correct. Enhancement: cap **25 ημ./μήνα, 300/έτος** (διπλασιασμός καταργήθηκε). | Ν.4144/2013 | inegsee.gr PDF; taxheaven |
| 4.4 | Πεδίο εφαρμογής: οικιακοί, αγροτικοί, «άλλες κατηγορίες με ΥΑ» (34-38) | **OK** | Accurate | art.20 Ν.3863/2010 | lawspot |
| 4.5 | Νομοθεσία "Ν. 3863/2010, άρθρο 20" + "Σχετικές υπουργικές αποφάσεις" (50-51) | **IMPRECISE** | Correct primary basis but omits the amending laws — esp. **Ν.4144/2013 art.74** (the very law that set the 25% the article quotes), plus Ν.4225/2014, Ν.4554/2018, Ν.4611/2019. Add. | as listed | brief §3; taxheaven |

Confidence: **high**.

---

## FILE 5 — `tekmarto-imeromisthio.md`

| # | Claim (line) | Verdict | Finding / correction | Basis | Source |
|---|---|---|---|---|---|
| 5.1 | Concept: εισφορές on a **τεκμαρτό ημερομίσθιο** not on actual pay for certain categories (7-17) | **OK** | Accurate for the surviving categories | Ν.4387/2016; legacy ΙΚΑ κλάσεις | e-forologia 236479 |
| 5.2 | **Scope** framed around περιστασιακή/εποχιακή + **εργόσημο / οικιακοί / αγροτικοί** only (9,19-23) | **IMPRECISE** | Misses the core surviving μισθωτοί: **αμειβόμενοι με κυμαινόμενες αποδοχές** — **σερβιτόροι, βοηθοί σερβιτόρων, μπάρμαν, κομμωτές/κουρείς & βοηθοί, οδηγοί ταξί, πλασιέ (περιοδεύοντες πωλητές), αλιεργάτες, μαιτρ/αρχισερβιτόροι, εισπράκτορες**. For these the τεκμαρτό **is the legal base** (εισφορές = 25× το ΤΗ της ασφ. κλάσης), not under-declaration. Add these. | e-ΕΦΚΑ Εγκ. 13/2023, **Εγκ. 11/2025** (κλάσεις από 1.4.2025) | e-a.gr; e-forologia 236479; pim.gr |
| 5.3 | Legacy general framing implies τεκμαρτό is the norm for all «περιστασιακούς» | **IMPRECISE** | For regular μισθωτούς the ασφ. κλάσεις were **abolished** (εισφορές επί πραγματικών αποδοχών, Ν.4387/2016); τεκμαρτό **survives as the exception** for the fluctuating-earnings list in 5.2. State the abolition + the exception. | Ν.4387/2016 | e-forologia 236479 |
| 5.4 | Νομοθεσία: Ν.3863/2010 / Ν.4387/2016 / «ΥΑ ΕΦΚΑ ετήσιοι πίνακες» (59-61) | **OK** | Accurate; the annual tables are the e-ΕΦΚΑ κλάσεων circulars. Optionally cite the latest (Εγκ. 11/2025). | — | e-efka Εγκ.11/2025 PDF |

Data points captured for drafters: from **1.4.2025** κομμωτές/ταξί/αλιεργάτες → 10η κλάση (ΤΗ €39,42); for **2026** σερβιτόροι/μπάρμαν → 12η (€47,07), μαιτρ/αρχισερβιτόροι → 14η (€55,65), κομμωτές/ταξί → 10η (€40,37). Confidence: **high** on categories; figures indicative (annual circular).

---

## FILE 6 — `index.md`

| # | Claim (line) | Verdict | Finding |
|---|---|---|---|
| 6.1 | "ΕΦΚΑ (Ηλεκτρονικός Εθνικός Φορέας Κοινωνικής Ασφάλισης)" (8-9) | **IMPRECISE** | The "Ηλεκτρονικός…" name is that of **e-ΕΦΚΑ**; current full form is *"Ηλεκτρονικός Εθνικός Φορέας Κοινωνικής Ασφάλισης (e-ΕΦΚΑ)"* (Ν.4670/2020). Minor label conflation. |
| 6.2 | "καλύπτει σύνταξη, υγεία και κλάδο ασθένειας" (9-10) | **OK** | Slightly redundant (υγεία ≈ κλάδος ασθένειας) but not wrong |
| 6.3 | Θέματα links only [[ΕΦΚΑ]], [[Εισφορές]] (14-15) | **IMPRECISE (completeness gap)** | Same-category articles **Εργάνη, Εργόσημο, Τεκμαρτό Ημερομίσθιο** are not linked. Not a legal error. |
| 6.4 | Δικαιώματα ασφαλισμένου list (17-22) | **OK** | Accurate |

No legal-currency errors. Confidence: **high**.

---

## TOP 5 CHANGES (ranked by worker impact)

1. **`eisfores.md` — rebuild the whole rate table.** Health-in-kind **6,45→5,45%** (1,65+3,80) and health-in-cash **1,15→0,65%** (0,40+0,25), effective **1.1.2025** (Ν.5162/2024 art.12 / Εγκ.38/2024); **delete the bogus "Εφάπαξ (ΤΕΚΑ) 0,36%" row**; replace the wrong "Ανεργία (ΔΥΠΑ) 3,20%" with **ΔΥΠΑ/λοιπά 3,06% (1,65 empl / 1,41 employer)**. As-is, the employer column sums to 23,79% and the total to 37,16% — they must sum to the (correct) 21,79% / 35,16%. Re-label 2025→2026.
2. **`ergani.md` — kill the fabricated citation "ΥΑ 80488/2021."** Real ΕΡΓΑΝΗ ΙΙ / digital-card instruments: **ΥΑ 49758/2022 (Β΄2668)** + **ΥΑ 80016/2022 (Β΄4629)**; card expansion ΥΑ 24595/2024 (Β΄1966) & 18047/2026 (Β΄3791). Fix ΕΡΓΑΝΗ basis to Ν.3996/2011 **+ ΥΑ 5072/6/2013**.
3. **`efka.md` — three fixes:** e-ΕΦΚΑ rebrand is **Ν.4670/2020, from 1.3.2020** (not "2022"); **εφάπαξ ≠ ΤΕΚΑ** (εφάπαξ = Κλάδος Εφάπαξ Παροχών e-ΕΦΚΑ, art.35 Ν.4387/2016; ΤΕΚΑ = επικουρική για νεοεισερχόμενους); **ΝΑΤ was integrated into ΕΦΚΑ from 1.1.2017** (art.53 §1 Ν.4387/2016) — the "δεν ενσωματώθηκε" claim is false.
4. **`eisfores.md` — penalty fix:** "Ν. 86/1967 … 5 χρόνια **κάθειρξη**" → **ΑΝ 86/1967**, penalty is **φυλάκιση** (≥3 μηνών εργοδοτικές / ≥6 μηνών παρακρατηθείσες), a πλημμέλημα, not κάθειρξη.
5. **`tekmarto-imeromisthio.md` — widen scope:** add the fluctuating-earnings μισθωτοί (**σερβιτόροι, κομμωτές, οδηγοί ταξί, πλασιέ, αλιεργάτες…**) for whom τεκμαρτό is the actual legal base; note ασφ. κλάσεις were abolished for regular employees (Ν.4387/2016) and τεκμαρτό survives as the exception. Also add **Ν.4144/2013 art.74** to `ergosimo.md`.

## GAPS / OPEN ITEMS
- **ΔΥΠΑ internal sub-split (ανεργία/ΛΑΕΚ/λοιπά)** for 2025-26: UNVERIFIABLE via automated fetch (KEPEA 403; mirrors only had stale figures). Aggregate 3,06% is solid; leave finer split out or source from a live KEPEA/e-ΕΦΚΑ ΠΙΝΑΚΑΣ read by a human.
- **ΕΔΟΕΑΠ** (journalists) separateness (efka.md 2.5): flagged, not re-verified — do not assert either way without a fresh source.

## LEDGER PATH
`C:\Users\apfanak\Documents\projects\base-unions\ai-labor-rights-guide\audit\ledgers\asfalisi.md`

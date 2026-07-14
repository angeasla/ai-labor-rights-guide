# AUDIT LEDGER — Batch `adeies-parental`

**Auditor role:** εργατολόγος (Greek labour-law fact-check)
**Date:** 2026-07-13
**Files:** `src/main/resources/docs/adeies/{mitrotita, patrotita, goniki-adia, eidiki-adia-mitrotitas, thilasmou}.md`
**Method:** every checkable claim extracted → verified vs CURRENCY-BRIEF §6 + fresh fetch of hli.gov.gr (ΠΙΝΑΚΑΣ ΑΔΕΙΩΝ / Επιθεώρηση Εργασίας), ypergasias.gov.gr, taxheaven.gr (verbatim ΦΕΚ text). No corpus files edited.

## Primary sources fetched (2026-07-13)

- Maternity: https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/adeies-ergasiakes-scheseis/adeies-gia-tin-prostasia-tis-oikogeneias/adeia-mitrotitas-adeia-toketou-kai-locheias/
- Parental: https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/adeies-ergasiakes-scheseis/adeies-gia-tin-prostasia-tis-oikogeneias/goniki-adeia/
- Child-care/breastfeeding: https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/adeies-ergasiakes-scheseis/adeies-gia-tin-prostasia-tis-oikogeneias/adeia-frontidas-teknou/
- Paternity: https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/adeies-ergasiakes-scheseis/adeies-gia-tin-prostasia-tis-oikogeneias/adeia-patrotitas/
- Special maternity → father transfer: https://ypergasias.gov.gr/pos-metavivazetai-i-eidiki-adeia-prostasias-tis-mitrotitas-ston-patera/
- ΚΥΑ 39686/2024 (ΦΕΚ Β΄4099/12.7.2024): https://www.forin.gr/articles/article/79998/kua-39686-2024 · https://www.elinyae.gr/ethniki-nomothesia/ya-396862024-fek-4099b-1272024
- Verbatim ΦΕΚ text: Ν.4808/2021 art.27 https://www.taxheaven.gr/law/4808/2021/article/27/view · art.28 https://www.taxheaven.gr/law/4808/2021/article/28/view · art.37 https://www.taxheaven.gr/law/4808/2021/article/37/view · art.48 https://www.taxheaven.gr/law/4808/2021/article/48/view · Ν.4997/2022 art.43 https://www.taxheaven.gr/law/4997/2022/article/43/view

---

## FILE 1 — `mitrotita.md` (Άδεια Μητρότητας)

| # | Claim (line) | Verdict |
|---|---|---|
| 1 | 17 εβδομάδες / 119 ημέρες total (L12) | **OK** |
| 2 | 8 εβδ. (56 ημ.) πριν τον τοκετό (L13) | **OK** |
| 3 | 9 εβδ. (63 ημ.) μετά τον τοκετό (L14) | **OK** |
| 4 | Πρόωρος τοκετός → υπόλοιπες προγεννητικές μέρες στη μεταγεννητική (L16-17) | **OK** |
| 5 | ΕΦΚΑ επίδομα μητρότητας «ίσο με τον ημερήσιο μισθό (200 ημ. ασφάλισης / 2 χρόνια)» (L21-22) | **IMPRECISE** |
| 6 | Ειδική παροχή προστασίας μητρότητας ΔΥΠΑ = **6 μήνες** (L26-27) | **OUTDATED** |
| 7 | Απαγόρευση απόλυσης εγκυμοσύνη + 18 μήνες μετά τον τοκετό, άκυρη (L31) | **OK** (incomplete) |
| 8 | Νομοθεσία: Ν.1483/1984, Ν.3655/2008 (L35-36) | **IMPRECISE** |

**Verdict tally:** OK 4 · OUTDATED 1 · IMPRECISE 3 · WRONG 0

### Non-OK detail

**#6 — OUTDATED (confidence: HIGH)**
- Snippet (verbatim): `6 μήνες επίδομα από τη ΔΥΠΑ (ΟΑΕΔ).`
- Replacement: `9 μήνες επίδομα (ειδική παροχή προστασίας μητρότητας) από τη ΔΥΠΑ.`
- Basis: **Ν.4997/2022 άρθρο 43** (ΦΕΚ Α΄219/25.11.2022) — extended 6→9 mo. (Original: Ν.3655/2008 art.142.)
- Source: https://www.taxheaven.gr/law/4997/2022/article/43/view
- Greek quote: «ειδική άδεια προστασίας μητρότητας **εννέα (9) μηνών**»

**#8 — IMPRECISE (confidence: HIGH)**
- Snippet: `- Ν. 1483/1984 — Προστασία και διευκόλυνση οικογενειακής ζωής` / `- Ν. 3655/2008 — Ρυθμίσεις εργατικής νομοθεσίας`
- Problem: neither is the operative basis. The 17-wk leave rests on **ΕΓΣΣΕ 1993 & 2000-01 άρθρο 7** (κυρωμ. Ν.2874/2000 art.11) + **Ν.4808/2021 art.34**; the 18-month dismissal ban is **Ν.4808/2021 art.48**; Ν.3655/2008 is the (superseded, 6-mo) *special-leave* law, not general maternity. Add these.
- Source: https://www.hli.gov.gr/.../adeia-mitrotitas-adeia-toketou-kai-locheias/
- Greek quote: «17 εβδομάδες… 8 εβδομάδες πρέπει να πάρει η εργαζόμενη πριν από τον τοκετό… άρθρου 7 της ΕΓΣΣΕ 1993 και 2000-2001… ν. 4808/2021».

**#7 — OK but incomplete (confidence: HIGH):** add the **father's 6-month** post-birth protection and cite **Ν.4808/2021 art.48**.
- Greek quote (art.48): «Απαγορεύεται και είναι απόλυτα άκυρη η καταγγελία… κατά τη διάρκεια της εγκυμοσύνης… και για χρονικό διάστημα **δέκα οκτώ (18) μηνών** μετά τον τοκετό» + «εργαζόμενου πατέρα… **έξι (6) μηνών** μετά τον τοκετό».
- Source: https://www.taxheaven.gr/law/4808/2021/article/48/view

**#5 — IMPRECISE (confidence: MEDIUM):** the e-EFKA benefit (επίδομα κυοφορίας & λοχείας) needs 200 ημέρες ασφάλισης στα 2 προηγούμενα έτη, but the amount is computed on ασφαλιστική κλάση/τεκμαρτό, not literally "ημερήσιος μισθός"; full-pay is reached via employer complement (ΕΓΣΣΕ). Reword to avoid implying a flat "daily-wage" benefit.

---

## FILE 2 — `patrotita.md` (Άδεια Πατρότητας)

| # | Claim (line) | Verdict |
|---|---|---|
| 1 | 14 εργάσιμες ημέρες αμέσως μετά τον τοκετό, ανεξ. αριθμού παιδιών (L12) | **OK** |
| 2 | Υποχρεωτικά αμειβόμενη από τον εργοδότη, χωρίς άρνηση/καθυστέρηση (L13) | **OK** |
| 3 | Γονική: 4 μήνες / γονέα έως τα 8 έτη (L18) | **OK** |
| 4 | «Δύο μήνες αμείβονται από τον ΔΥΠΑ (**μη μεταβιβάσιμο μέρος**)» (L19) | **WRONG** |
| 5 | Δύο μήνες άνευ αποδοχών (εκτός ΣΣΕ) (L20) | **OK** |
| 6 | Νομοθεσία: Ν.4808/2021 + Οδηγία 2019/1158 (L24) | **OK** (add art. numbers) |

**Verdict tally:** OK 5 · WRONG 1 · IMPRECISE 0 · OUTDATED 0

### Non-OK detail

**#4 — WRONG (confidence: HIGH)**
- Snippet: `Δύο μήνες αμείβονται από τον ΔΥΠΑ (μη μεταβιβάσιμο μέρος)`
- Problem: the parenthetical implies the *other* 2 months are transferable. Under Greek law **all 4 months are ατομικό και αμεταβίβαστο** — the 2-vs-2 split is about **payment** (2 paid / 2 unpaid), NOT transferability.
- Replacement: `Δύο μήνες αμείβονται από τη ΔΥΠΑ (κατώτατος μισθός + αναλογία δώρων/επιδόματος αδείας)· και οι 4 μήνες είναι ατομικό και αμεταβίβαστο δικαίωμα κάθε γονέα.`
- Basis: **Ν.4808/2021 art.28**.
- Source: https://www.taxheaven.gr/law/4808/2021/article/28/view · https://www.hli.gov.gr/.../goniki-adeia/
- Greek quote: «Κάθε εργαζόμενος γονέας… έχει **ατομικό και αμεταβίβαστο δικαίωμα** γονικής άδειας».

**#6 — OK (confidence: HIGH):** paternity = **art.27**, parental = **art.28**; cite them. (art.27 confirms «άδεια πατρότητας **δεκατεσσάρων (14) εργάσιμων ημερών, με αποδοχές**… δεν εξαρτάται από… προϋπηρεσία».)

*Note:* this file duplicates the parental-leave content of `goniki-adia.md`; keep the two consistent when fixing #4.

---

## FILE 3 — `goniki-adia.md` (Γονική Άδεια Ανατροφής)

| # | Claim (line) | Verdict |
|---|---|---|
| 1 | Κάθε γονέας 4 μήνες (L13) | **OK** |
| 2 | Πίνακας: 2 μήνες μη-μεταβιβάσιμο + 2 μήνες **μεταβιβάσιμο** = 4 (L15-17) | **WRONG** |
| 3 | Οι 2 πρώτοι αυστηρά προσωπικοί, χάνονται αν δεν ληφθούν (L19) | **OK** (but all 4 προσωπικοί) |
| 4 | «Οι 2 επόμενοι μήνες είναι **μεταβιβάσιμοι**… εκχωρήσει στον άλλον» (L21) | **WRONG** |
| 5 | ΔΥΠΑ επίδομα = κατώτατος μισθός «**880 €/μήνα για το 2025**» (L25) | **OUTDATED** |
| 6 | Έως τα 8 χρόνια (παλαιότερα «τα 3 χρόνια») (L29) | **OK / IMPRECISE** |
| 7 | Έγγραφη ειδοποίηση ≥1 μήνα πριν (L33) | **OK** |
| 8 | Δεν αρνούνται· αναβολή ≤2 μήνες για σοβαρή λειτουργική ανάγκη (L33) | **OK** |
| 9 | Δυνατότητα τμηματικής / μειωμένου ωραρίου λήψης (L37-41) | **OK** |
| 10 | (Προϋπόθεση 1 έτους στον ίδιο εργοδότη) | **GAP — MISSING** |
| 11 | Υιοθεσία/παρένθετη ίδια δικαιώματα, 8ετία από ένταξη (L47-49) | **OK** |
| 12 | Νομοθεσία Ν.4808/2021 arts 27–38 + Ν.1483/1984 + Οδηγία (L60-62) | **OK** |

**Verdict tally:** OK 8 · WRONG 2 · OUTDATED 1 · IMPRECISE 1 · GAP 1

### Non-OK detail

**#2 & #4 — WRONG (confidence: HIGH)** — the single most important error in this file.
- Snippet (#4, verbatim): `Οι **2 επόμενοι μήνες είναι μεταβιβάσιμοι**: ο ένας γονέας μπορεί να τους εκχωρήσει στον άλλον.`
- Snippet (#2 table header): `| Γονέας | Μη μεταβιβάσιμο | Μεταβιβάσιμο | Σύνολο |`
- Problem: this describes the **EU Directive 2019/1158 minimum** (2 mo non-transferable), NOT the Greek transposition. **Ν.4808/2021 art.28 makes the ENTIRE 4-month leave ατομικό και αμεταβίβαστο** — no part may be assigned to the other parent. (Transferability belongs to the *special maternity* leave — ≤7 mo, Ν.4997/2022 — a different right; likely conflated.)
- Replacement: drop the transferable column; state all 4 months are individual & non-transferable; keep the payment distinction (first 2 paid by ΔΥΠΑ, last 2 unpaid).
- Basis: **Ν.4808/2021 art.28**.
- Source: https://www.hli.gov.gr/.../goniki-adeia/ · https://www.taxheaven.gr/law/4808/2021/article/28/view
- Greek quote: «Κάθε εργαζόμενος γονέας ή πρόσωπο που ασκεί τη γονική μέριμνα έχει **ατομικό και αμεταβίβαστο δικαίωμα** γονικής άδειας».

**#5 — OUTDATED (confidence: HIGH)**
- Snippet: `επίδομα ίσο με τον κατώτατο μισθό (880 €/μήνα για το 2025)`
- Replacement: `επίδομα ίσο με τον εκάστοτε κατώτατο μισθό (**920 €/μήνα από 1.4.2026**), πλέον αναλογίας δώρων εορτών και επιδόματος αδείας.`
- Basis: κατώτατος μισθός **ΚΥΑ 8934/2026 (ΦΕΚ Β΄1759/27.3.2026)** = €920· ΔΥΠΑ επίδομα = «ελάχιστος νομοθετημένος μισθός» + δώρα + επίδομα αδείας (Ν.4808/2021 art.28 §3).
- Source: https://www.hli.gov.gr/.../goniki-adeia/ (payment = «ποσού ίσου με τον ελάχιστο νομοθετημένο μισθό» + δώρα/επίδομα αδείας); min-wage value per CURRENCY-BRIEF §2.
- Note: the amount auto-tracks min wage, so best fix is to drop the hard number or state "εκάστοτε κατώτατος". Also add the δώρα/επίδομα-αδείας uplift the file currently omits.

**#10 — GAP / MISSING (confidence: HIGH)**
- The file never states the **1-year prior-employment condition**. art.28 requires **«ένα (1) έτος συνεχόμενης ή με διαδοχικές συμβάσεις… απασχόλησης στον ίδιο εργοδότη»** before the parental-leave entitlement arises. Add it (with the militant caveat that fixed-term chains count).
- Source: https://www.hli.gov.gr/.../goniki-adeia/ · https://www.taxheaven.gr/law/4808/2021/article/28/view

**#6 — IMPRECISE (confidence: MEDIUM):** "παλαιότερα το όριο ήταν τα 3 χρόνια" — the *immediately prior* limit was **6 έτη** (Ν.4075/2012 art.50); 3,5 έτη was the older Ν.1483/1984 regime. Either say "παλαιότερα έως τα 6" or generalise.

---

## FILE 4 — `eidiki-adia-mitrotitas.md` (Ειδική Άδεια Μητρότητας 9 Μηνών)

| # | Claim (line) | Verdict |
|---|---|---|
| 1 | 9 μήνες ειδική παροχή προστασίας μητρότητας (title, L7-13) | **OK** |
| 2 | Δικαιούχες: μισθωτές ιδιωτικού τομέα, ασφ. ΕΦΚΑ (L16-18) | **OK / NOW BROADER** |
| 3 | Προϋπόθεση «επέστρεψαν έστω και για μία ημέρα» (L19-21) | **IMPRECISE/OUTDATED** |
| 4 | Σύνολο ≈13 μήνες (17 εβδ. + 9 μήνες) (L13) | **OK** |
| 5 | ΔΥΠΑ = κατώτατος μισθός «**880 €/μήνα για το 2025**» (L25) | **OUTDATED** |
| 6 | Ο εργοδότης δεν πληρώνει· κρατική χρηματοδότηση (L25) | **OK** |
| 7 | Εισφορές ΕΦΚΑ συνεχίζονται, κρατικά καλυμμένες (L27-29) | **OK** |
| 8 | Απαγόρευση απόλυσης· 18 μήνες συνολικά μετά τοκετό (L41-46) | **OK** |
| 9 | Βάρος απόδειξης στον εργοδότη (τεκμήριο απόλυσης λόγω μητρότητας) (L52) | **OK** |
| 10 | Νομοθεσία: **Ν.3655/2008 art.142** + Ν.4808/2021 (L58-62) | **OUTDATED** |
| 11 | (Μεταβίβαση ≤7 μηνών στον πατέρα) | **GAP — MISSING** |

**Verdict tally:** OK 6 · OUTDATED 2 · IMPRECISE 1 · GAP 1

### Non-OK detail

**#10 — OUTDATED (confidence: HIGH)** — headline citation fix.
- Snippet: `- **Ν. 3655/2008** — Άρθρο 142 (καθιέρωση της ειδικής παροχής προστασίας μητρότητας)`
- Problem: art.142 Ν.3655/2008 established the leave at **6 μήνες**. The current **9-month** value is **Ν.4997/2022 art.43** (ΦΕΚ Α΄219/25.11.2022) — absent from the file (and the frontmatter tag still reads `Ν.3655/2008`).
- Replacement/add: **Ν.4997/2022 άρθρο 43** (9 μήνες + μεταβίβαση ≤7 στον πατέρα); **ΥΑ 47360/2023 (ΦΕΚ Β΄3104/10.5.2023)** (διαδικασία μεταβίβασης)· **ΚΥΑ 39686/2024 (ΦΕΚ Β΄4099/12.7.2024)**.
- Source: https://www.taxheaven.gr/law/4997/2022/article/43/view
- Greek quote: «ειδική άδεια προστασίας μητρότητας **εννέα (9) μηνών**».

**#11 — GAP / MISSING (confidence: HIGH)**
- The file omits that the mother may **transfer up to 7 months to the father** (working, dependent-employment). Add it — pro-worker angle: fathers can shoulder the leave.
- Basis: **Ν.4997/2022 art.43 §2**; procedure ΥΑ 47360/2023 (υπεύθυνη δήλωση στη ΔΥΠΑ μέσω gov.gr; προειδοποίηση εργοδότη 1 μήνα, εκτός αν υπόλοιπο <2 μήνες).
- Source: https://ypergasias.gov.gr/pos-metavivazetai-i-eidiki-adeia-prostasias-tis-mitrotitas-ston-patera/
- Greek quote: «Η μητέρα δικαιούται να μεταβιβάσει **έως επτά (7) μήνες**… προς τον πατέρα».

**#5 — OUTDATED (confidence: HIGH)**
- Snippet: `επίδομα ίσο με τον **κατώτατο μισθό** (880 €/μήνα για το 2025)`
- Replacement: `επίδομα ίσο με τον εκάστοτε κατώτατο μισθό (**920 €/μήνα από 1.4.2026**), πλέον αναλογίας δώρων εορτών και επιδόματος αδείας.`
- Basis: ΚΥΑ 8934/2026 (min wage €920); ΔΥΠΑ pays min wage + δώρα + επίδομα αδείας.
- Source: https://ypergasias.gov.gr/... («ποσό ίσο με τον κατώτατο μισθό, όπως κάθε φορά καθορίζεται, καθώς και αναλογία δώρων εορτών και επιδόματος αδείας»).

**#2 & #3 — IMPRECISE / NOW BROADER (confidence: MEDIUM-HIGH)**
- Since **ΚΥΑ 39686/2024** the benefit reaches **all μισθωτές του e-ΕΦΚΑ** (και έμμισθες δικηγόρους, ομόφυλους/-ες συζύγους), and per art.151 Ν.5078/2023 also **ελεύθερες επαγγελματίες / αυτοαπασχολούμενες / αγρότισσες** — no longer "private-sector μισθωτές" only.
- The current gating condition per ΚΥΑ 39686/2024 is **«ενεργή εργασιακή σχέση… και… απόφαση επιδότησης μητρότητας»** — the strict "return for 1 day" framing (L19-21) is the older rule; reword.
- Source: https://www.forin.gr/articles/article/79998/kua-39686-2024
- Greek quote: «Σε όλες τις μισθωτές του e-ΕΦΚΑ ή άλλου φορέα ασφάλισης ασθένειας μισθωτών παρέχεται ειδική άδεια και παροχή προστασίας της μητρότητας… να βρίσκεται σε ενεργή εργασιακή σχέση… και… να έχει εκδοθεί απόφαση επιδότησης μητρότητας».

---

## FILE 5 — `thilasmou.md` (Άδεια Θηλασμού & Μειωμένο Ωράριο)

| # | Claim (line) | Verdict |
|---|---|---|
| 1 | Μειωμένο ωράριο 30 μήνες, πληρωμένο, χωρίς περικοπή (L9,13) | **OK** |
| 2 | Επιλογές: «1 ώρα λιγότερη» ή «30′ πρωί + 30′ απόγευμα» (L15-16) | **IMPRECISE (incomplete)** |
| 3 | Και οι δύο επιλογές = πλήρης εργάσιμος χρόνος, αμείβονται (L18) | **OK** |
| 4 | Ο πατέρας το χρησιμοποιεί αντί της μητέρας με γραπτή συμφωνία (L21-26) | **OK (framing dated)** |
| 5 | Μερική απασχόληση → αναλογική μείωση (L28-30) | **OK** |
| 6 | **Πολύδυμη κύηση: +6 μήνες/παιδί· δίδυμα 36, τρίδυμα 42** (L32-34) | **WRONG** |
| 7 | Ξεχωριστό & επιπλέον της γονικής άδειας (L36-38) | **OK** |
| 8 | Άρνηση/ποινή παράνομη· πρόστιμο εργοδότη (L40-48) | **OK** |
| 9 | «Διευκόλυνση θηλασμού» — δεν χρειάζεται απόδειξη θηλασμού (L50-52) | **OK** |
| 10 | Νομοθεσία: Ν.1483/1984 art.9 + Ν.4808/2021 (L54-57) | **IMPRECISE** |
| 11 | (Εναλλακτικοί τρόποι λήψης: 2ω×12μ+1ω×6μ, πλήρεις ημέρες, ισόχρονη συνεχ. άδεια) | **GAP — MISSING** |

**Verdict tally:** OK 6 · WRONG 1 · IMPRECISE 2 · GAP 1

### Non-OK detail

**#6 — WRONG (confidence: HIGH)** — fabricated specific with no statutory basis.
- Snippet (verbatim): `Για κάθε επιπλέον παιδί από πολύδυμη κύηση, το διάστημα των 30 μηνών **παρατείνεται κατά 6 μήνες**. Για δίδυμα: 36 μήνες. Για τρίδυμα: 42 μήνες.`
- Problem: **Ν.4808/2021 art.37 contains NO multiple-births extension.** Both hli.gov.gr and the verbatim article text confirm the 30-month period is uniform regardless of twins/triplets. (An extension may exist only if a specific ΣΣΕ grants it — no general/statutory basis.)
- Replacement: delete the claim, or reframe as "μόνο εφόσον το προβλέπει ειδική ΣΣΕ" (no statutory extension).
- Basis: **Ν.4808/2021 art.37**.
- Source: https://www.hli.gov.gr/.../adeia-frontidas-teknou/ · https://www.taxheaven.gr/law/4808/2021/article/37/view
- Greek quote (Επιθεώρηση Εργασίας): the 30-month child-care leave «η διάρκεια… είναι η ίδια, ανεξαρτήτως αν πρόκειται για δίδυμα ή τρίδυμα» (no extension provision in art.37).

**#11 — GAP / MISSING (confidence: HIGH)** — the file omits the genuine legal alternatives.
- art.37 gives the parent, **by agreement**, alternatives to the daily 1-hour: (a) **2 ώρες/ημέρα τους πρώτους 12 μήνες + 1 ώρα/ημέρα τους επόμενους 6 μήνες**; (b) **πλήρεις ημέρες άδειας** κατανεμημένες εβδομαδιαία· (c) **ισόχρονη συνεχόμενη άδεια** (εφάπαξ ή τμηματικά); (d) όποιος άλλος συμφωνηθεί τρόπος. Add these — they materially expand worker options.
- Source: https://www.taxheaven.gr/law/4808/2021/article/37/view
- Greek quote: «α) Μειωμένο ωράριο… κατά δύο (2) ώρες… για τους πρώτους δώδεκα (12) μήνες και κατά μία (1) ώρα… για τους επόμενους έξι (6) μήνες. β) Πλήρεις ημέρες άδειας… γ) Ισόχρονη συνεχόμενη άδεια, χορηγούμενη εφάπαξ ή τμηματικώς».

**#2 — IMPRECISE (confidence: MEDIUM):** the statute frames the base option as **1 hour** (arrive late / leave early / interrupt work by 1h daily). The "30′+30′" split is a benign interpretation, but the file presents only these two variants and misses the real alternatives (see #11).

**#10 — IMPRECISE (confidence: HIGH):** operative provision is now **Ν.4808/2021 art.37** — cite the article explicitly (file cites only Ν.1483/1984 art.9 + bare "Ν.4808/2021"). art.37 also adds the enforcement teeth the file should quote: «η **παραίτηση** από τη λήψη της άδειας είναι **άκυρη**, η δε **άρνηση** χορήγησής της συνιστά **βλαπτική μεταβολή** των όρων εργασίας».

**#4 — OK, framing dated (confidence: MEDIUM):** art.37 makes it a right of **either parent alternately** (εναλλακτικώς μεταξύ τους), independent of the other parent's status; the "mother waives → father takes" framing is the older Ν.1483/1984 model. Entitlement is correct; modernise the framing.

---

## BATCH SUMMARY

| File | OK | WRONG | OUTDATED | IMPRECISE | GAP |
|---|---|---|---|---|---|
| mitrotita.md | 4 | 0 | 1 | 3 | 0 |
| patrotita.md | 5 | 1 | 0 | 0 | 0 |
| goniki-adia.md | 8 | 2 | 1 | 1 | 1 |
| eidiki-adia-mitrotitas.md | 6 | 0 | 2 | 1 | 1 |
| thilasmou.md | 6 | 1 | 0 | 2 | 1 |
| **TOTAL** | **29** | **4** | **4** | **7** | **3** |

### Highest-priority corrections
1. **`goniki-adia.md` + `patrotita.md`: "2 transferable months" is WRONG.** Ν.4808/2021 art.28 makes all 4 months **ατομικό και αμεταβίβαστο**. (Corpus reproduces the EU-directive minimum, not the Greek transposition.)
2. **`mitrotita.md`: special leave "6 μήνες" → 9 μήνες** (Ν.4997/2022 art.43).
3. **`thilasmou.md`: multiple-births "+6 mo/child (36/42)" is WRONG** — no statutory basis in art.37; duration is uniform.
4. **`eidiki-adia-mitrotitas.md`: citation stuck on Ν.3655/2008 art.142** (the old 6-mo law) — add **Ν.4997/2022 art.43**, **ΚΥΑ 39686/2024**, and the **≤7-month father transfer**.
5. **Hard-frozen "880 € για το 2025"** in `goniki-adia.md` & `eidiki-adia-mitrotitas.md` → **€920 (1.4.2026, ΚΥΑ 8934/2026)**; make it track the εκάστοτε min wage + add δώρα/επίδομα-αδείας uplift.

### Gaps to add
- `goniki-adia.md`: **1-year same-employer tenure** condition (art.28) — currently absent.
- `thilasmou.md`: the **2ω×12μ+1ω×6μ / πλήρεις ημέρες / ισόχρονη συνεχόμενη άδεια** alternatives (art.37).
- `eidiki-adia-mitrotitas.md`: broadened **eligibility** (all e-EFKA μισθωτές + free professionals/self-employed/farmers, ΚΥΑ 39686/2024) and **≤7-mo father transfer**.
- `mitrotita.md` / `eidiki-adia-mitrotitas.md`: father's **6-month** dismissal protection (art.48).

### Unverifiable / flagged (not asserted)
- Exact e-EFKA maternity-benefit *amount* mechanics (class-based + employer complement) — corpus's "ίσο με τον ημερήσιο μισθό" is a simplification (IMPRECISE, not asserted WRONG).
- Whether any κλαδική ΣΣΕ grants a multiple-births child-care extension — none found; statutory basis is nil.

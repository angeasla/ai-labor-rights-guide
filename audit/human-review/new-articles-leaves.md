# Audit — 5 new leave articles (`adeies/`)

**Auditor:** adversarial legal-accuracy pass (refutation-first). **Date:** 2026-07-13.
**Scope:** `anoteras-vias.md`, `gynaikologikos-elegxos.md`, `penthos.md`, `aneu-apodoxon.md`, `frontisti.md`.
**Method:** every legal claim (days / pay status / conditions / law+article / ΚΕΔ article / ΦΕΚ) checked
against a primary or authoritative source (hli.gov.gr Επιθεώρηση Εργασίας, opengov bill text,
taxheaven/ELINYAE ΦΕΚ mirrors, kepea.gr ΓΣΕΕ). ΚΕΔ article numbers cross-checked against
`audit/KED-MAP.md` (official ΦΕΚ Α΄121 extraction). Wikilinks checked against real doc titles + the
actual resolver in `WikiService.java` (resolves normalized title / filename-base / alias).

**Bottom line:** all five articles are legally SOUND. One broken wikilink fixed in `anoteras-vias.md`.
No factual refutations. One error found in a *reference doc* (KED-MAP), not in the articles.

---

## 1. `anoteras-vias.md` — Άδεια Ανωτέρας Βίας — **FIXED** (content SOUND)

| Claim | Verdict | Source |
|---|---|---|
| ≤ 2 φορές/έτος, ≤ 1 εργάσιμη ημέρα κάθε φορά (≤2 ημ. σύνολο) | **CONFIRMED** | opengov art.30 text + hli.gov.gr: «Έως δύο (2) φορές το χρόνο και από μία (1) εργάσιμη ημέρα κάθε φορά» |
| **Με αποδοχές** (paid) | **CONFIRMED** | idem: «…δικαιούται να απουσιάσει… **με αποδοχές**» |
| Δικαιούχος = εργαζόμενος γονέας ή φροντιστής | **CONFIRMED** | opengov / hli.gov.gr |
| Βεβαίωση: ιατρική γνωμάτευση νοσοκομείου ή θεράποντος ιατρού | **CONFIRMED** | hli.gov.gr wording matches verbatim |
| Καμία προϋπόθεση προϋπηρεσίας | **CONFIRMED** | Ν.4808/2021 art.30 imposes no seniority gate (contrast art.28 parental=1yr, art.29 carer's=6mo) |
| Ν.4808/2021 **άρθρο 30** (Οδηγία 2019/1158 **art.7**) | **CONFIRMED** | opengov page title = «Άρθρο 30 … (άρθρο 7 της Οδηγίας (ΕΕ) 2019/1158)» |
| **ΚΕΔ (ΠΔ 62/2025) άρθρο 233** | **CONFIRMED** | KED-MAP row 33, confidence H (official ΦΕΚ Α΄121) |
| Εγκύκλιος 47972/2021 | **CONFIRMED** | same circular cited by hli.gov.gr for the WLB-directive leaves (also on the carer's page) |

**Fix applied:** broken wikilink `[[Γονικής Άδειας Ανατροφής|γονική άδεια]]` → `[[Γονική Άδεια
Ανατροφής Τέκνων|γονική άδεια]]`. The old target normalized to `γονικης αδειας ανατροφης`, which
matches no title/filename/alias in the corpus (real title: "Γονική Άδεια Ανατροφής Τέκνων",
`adeies/goniki-adia.md`; `frontisti.md` already links it correctly). Would have 404'd in the wiki.

Sources: https://www.opengov.gr/minlab/?p=4947 ·
https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/adeies-ergasiakes-scheseis/adeies-gia-tin-prostasia-tis-oikogeneias/apousia-apo-tin-ergasia-gia-logous-anoteras-vias/

---

## 2. `gynaikologikos-elegxos.md` — Άδεια Γυναικολογικού Ελέγχου — **SOUND**

| Claim | Verdict | Source |
|---|---|---|
| **1 ημέρα/έτος, με αποδοχές** | **CONFIRMED** | kepea.gr / hli.gov.gr: «μία (1) ημέρα τον χρόνο άδεια με αποδοχές για… γυναικολογικού ελέγχου» |
| Επεκτάθηκε στον **ιδιωτικό** τομέα (ίσχυε ήδη στο Δημόσιο) το 2023 | **CONFIRMED** | «…θεσμοθετείται **και για τις εργαζόμενες στον ιδιωτικό τομέα**… που ήδη ισχύει για τον δημόσιο τομέα» |
| **Ν.5043/2023 άρθρο 96**, τροποποιεί Ν.4808/2021 **άρθρο 40** | **CONFIRMED** | taxheaven ΦΕΚ text + kepea: «άρθρο 96 του Ν.5043/2023, που τροποποιεί το άρθρο 40 του Ν.4808/2021» |
| **ΚΕΔ (ΠΔ 62/2025) άρθρο 242** (προγεννητικές + γυναικολογικός) | **CONFIRMED** | KED-MAP row 38, confidence H |
| Δικαιολογητικό = βεβαίωση θεράποντος ιατρού ότι έγινε ο έλεγχος | **CONFIRMED** | kepea/hli wording matches |
| Δεν προβλέπεται 2η ημέρα / χωριστή άδεια ανά εξέταση | **CONFIRMED** | no twice-yearly or test-specific basis exists (CURRENCY-BRIEF §6; refutes the user's "2×/yr" hypothesis — article correctly says 1×) |

No wikilink or frontmatter issues. Militant tone consistent with corpus.

Sources: https://www.taxheaven.gr/laws/view/index/law/5043/year/2023/article/96 ·
https://www.kepea.gr/article.php?id=2435 ·
https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/adeies-ergasiakes-scheseis/adeies-gia-tin-prostasia-tis-oikogeneias/adeia-progennitikon-exetaseon-kai-gynaikologikou-elegchou/

---

## 3. `penthos.md` — Άδεια Πένθους — **SOUND**

| Claim | Verdict | Source |
|---|---|---|
| **2 ημέρες με αποδοχές** για θάνατο στενού συγγενή | **CONFIRMED** | hli.gov.gr: «άδεια δύο (2) ημερών με αποδοχές σε περίπτωση θανάτου συζύγου, τέκνων, γονέων και αδελφών» |
| Καλύπτει σύζυγο / τέκνο / γονέα / αδελφό (εξ αίματος) | **CONFIRMED** | idem |
| Επέκταση στους **εξ αγχιστείας** ίδιας γραμμής/βαθμού (πεθερικά, γαμπρός/νύφη, κουνιάδος/α) | **CONFIRMED** | hli.gov.gr: «χορηγείται… στους εξ αγχιστείας συγγενείς στην ίδια γραμμή και στον ίδιο βαθμό». Correspondences (πεθερικά↔γονείς, γαμπρός/νύφη↔τέκνα, κουνιάδος/α↔αδέλφια) are correct |
| Νομ. βάση 2-ημέρων: **ΕΓΣΣΕ 2002-03 άρθρο 9**; εξ αγχιστείας: **ΕΓΣΣΕ 2010-2012 άρθρο 8** | **CONFIRMED** | hli.gov.gr states exactly these two ΕΓΣΣΕ/articles |
| Χωρίς προϋπόθεση προϋπηρεσίας | **CONFIRMED** | ΕΓΣΣΕ term, no seniority gate |
| **20 ημέρες με αποδοχές** για απώλεια τέκνου (πενθούντες γονείς) | **CONFIRMED** | kepea/enypekk: «πληρωμένη άδεια… είκοσι (20) ημερών… σε περίπτωση θανάτου τέκνου» |
| Δικαιούχοι: φυσικοί/θετοί/ανάδοχοι γονείς + τεκμαιρόμενες μητέρες; ιδιωτικός + δημόσιος | **CONFIRMED** | kepea text lists exactly these categories (also adds «φροντιστές» — see residual) |
| **Ν.5018/2023 άρθρο 93**, ΦΕΚ Α΄25/9.2.2023; **ΚΕΔ άρθρο 246** | **CONFIRMED** | ELINYAE (ΦΕΚ 25/Α 9.2.2023) + KED-MAP row 41 (H) |

No broken wikilinks (`[[Θάνατος Εργαζόμενου]]`, `[[Άδεια Γάμου & Τεκνοποίησης]]`, `[[Συνδικαλισμός]]`
all resolve by exact title). Tone consistent.

Sources: https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/adeies-ergasiakes-scheseis/loipes-adeies/adeia-logo-thanatou-syngenous/ ·
https://www.kepea.gr/adeia-penthoynton-goneon · https://www.elinyae.gr/ethniki-nomothesia/n-50182023-fek-25a-922023

---

## 4. `aneu-apodoxon.md` — Άδεια Άνευ Αποδοχών — **SOUND** (resolves a reference-doc conflict in the article's favour)

| Claim | Verdict | Source |
|---|---|---|
| Διάρκεια **έως 1 έτος**, παράταση με νέα έγγραφη συμφωνία | **CONFIRMED** | hli.gov.gr «Άδεια άνευ αποδοχών» |
| **Ατομική έγγραφη συμφωνία**· δεν επιβάλλεται από τον εργοδότη | **CONFIRMED** | hli: «κατόπιν ατομικής έγγραφης συμφωνίας με τον εργοδότη» |
| Σύμβαση σε **αναστολή** (όχι λύση) | **CONFIRMED** | hli.gov.gr |
| Ανάρτηση στο **ΕΡΓΑΝΗ** + κοινοποίηση **e-ΕΦΚΑ** | **CONFIRMED** | hli.gov.gr |
| **Δεν οφείλονται ασφαλιστικές εισφορές** | **CONFIRMED** | hli: «δεν οφείλονται ασφαλιστικές εισφορές» |
| Αναβίωση δικαιωμάτων/υποχρεώσεων μετά τη λήξη | **CONFIRMED** | hli.gov.gr |
| **Ν.4808/2021 άρθρο 62**; **ΚΕΔ άρθρο 255** | **CONFIRMED** | hli.gov.gr explicitly cites **Ν.4808/2021 art.62**; ΚΕΔ 255 per KED-MAP row 40 |
| Κάλυψη κενού με εξαγορά (art.34 Ν.4387/2016)· εκπαιδευτική άδεια άνευ αποδοχών έως 2 έτη | **CONFIRMED (plausible, well-hedged)** | CURRENCY-BRIEF §5 (art.34 covers parental/edu leave). Article correctly tells reader to verify own case with e-ΕΦΚΑ |

**Note (reference-doc bug, not an article error):** `audit/KED-MAP.md` row 40 lists the originating
article for ΚΕΔ 255 as **Ν.4808/2021 art.50 (confidence M)**. The primary source (hli.gov.gr) and
CURRENCY-BRIEF (§2, §6, §8) all say **art.62**. The article's citation (**art.62**) is CORRECT; the
KED-MAP entry is the one that is wrong. → KED-MAP.md should be corrected to art.62.

No wikilink issues (`[[Αναστολή Σύμβασης Εργασίας|…]]`, `[[Εξαγορά Ενσήμων (Πλασματικά Έτη
Ασφάλισης)|…]]` resolve exactly).

Source: https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/adeies-ergasiakes-scheseis/loipes-adeies/adeia-anef-apodochon/

---

## 5. `frontisti.md` — Άδεια Φροντιστή — **SOUND**

| Claim | Verdict | Source |
|---|---|---|
| **Έως 5 εργάσιμες ημέρες/έτος** | **CONFIRMED** | hli.gov.gr «Άδεια φροντιστή» |
| **ΑΝΕΥ αποδοχών** | **CONFIRMED** | hli: «για την οποία **δεν προβλέπεται καταβολή αποδοχών**» |
| **6 μήνες** συνεχούς/διαδοχικής απασχόλησης | **CONFIRMED** | hli: «συμπληρώσει **έξι (6) μήνες** συνεχόμενης ή με διαδοχικές συμβάσεις…» |
| **Ιατρική γνωμάτευση** το μόνο δικαιολογητικό | **CONFIRMED** | hli: «βεβαιώνεται με ιατρική γνωμάτευση» |
| Κύκλος προσώπων (σύζυγος/σύντροφος, τέκνα, γονείς, αδέλφια, εξ αίματος, ίδιο νοικοκυριό) | **CONFIRMED** | hli enumerates the same recipients |
| **Ν.4808/2021 άρθρο 29** (Οδηγία 2019/1158 **art.6**); **ΚΕΔ άρθρο 232** | **CONFIRMED** | hli (art.29) + KED-MAP row 32 (H); Εγκ. 47972/2021 |
| Σύγκριση πίνακα με ανωτέρα βία (5 vs ≤1×2 ημ.· άνευ vs με αποδοχές· 6μ vs καμία προϋπηρεσία) | **CONFIRMED** | every cell matches verified values above |

No wikilink issues (`[[Γονική Άδεια Ανατροφής Τέκνων|Γονική Άδεια]]`, `[[Άδεια Ανωτέρας Βίας]]`
resolve). Tone consistent.

Source: https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/adeies-ergasiakes-scheseis/adeies-gia-tin-prostasia-tis-oikogeneias/adeia-frontisti/

---

## Residual concerns for a human lawyer (all low-risk)

1. **KED-MAP.md bug (fix the reference, not the article):** unpaid leave originating article is
   **Ν.4808/2021 art.62** (primary-source confirmed), but KED-MAP row 40 says art.50 (it was flagged
   M-confidence). Correct KED-MAP so it doesn't misdirect future citation rewrites.
2. **`penthos.md` completeness (not an error):** the ΚΕΔ 246 / Ν.5018/2023 art.93 beneficiary list in
   the primary source also includes **«φροντιστές»** alongside natural/adoptive/foster parents and
   presumed mothers; the article omits that one category. Optional to add.
3. **`penthos.md` frontmatter tags** cite `ΕΓΣΣΕ` but not `Ν.5018/2023`, though the article covers the
   20-day statutory leave too. Cosmetic tag inconsistency; does not affect resolution or content.
4. **Force-majeure "no seniority" claim** is asserted by the article and is consistent with the art.30
   text (which imposes no tenure gate), but CURRENCY-BRIEF does not state it in so many words — a
   lawyer confirming against the full ΦΕΚ text would put it beyond doubt.
5. All ΚΕΔ numbers (232/233/242/246/255) were confirmed via KED-MAP's official ΦΕΚ Α΄121 extraction,
   not re-read line-by-line from the ΦΕΚ PDF here; four are H-confidence, 255 is M (but its number is
   consistent and the originating-law question is resolved in #1).

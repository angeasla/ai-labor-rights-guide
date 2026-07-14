# AUDIT LEDGER — Batch `symvasi-collective`

**Auditor role:** Greek labour lawyer (εργατολόγος), militant pro-worker.
**Audit date:** 2026-07-13
**Baseline:** `audit/CURRENCY-BRIEF.md` + `audit/KED-MAP.md` + fresh primary-source fetches (hli.gov.gr [Επιθεώρηση Εργασίας], ypergasias.gov.gr, lawspot.gr & taxheaven.gr [mirror ΦΕΚ], omed.gr, plus εργατολόγος secondary for cross-check).
**Files (7):** `symvasi/sse.md`, `egsee.md`, `syndikalismos.md`, `apergia.md`, `diavoulefsi.md`, `symboulia-ergazomenon.md`, `index.md`.
**Corpus edits made:** NONE (audit only).

Legend: **OK** = accurate & current · **WRONG** = factually false now · **OUTDATED** = was true, superseded · **IMPRECISE** = misleading/loose/mis-cited · **UNVERIFIABLE** = not confirmable against a primary source · **GAP** = correct-but-material-omission.

---

## VERDICT TALLY

| File | Claims checked | OK | WRONG | OUTDATED | IMPRECISE | UNVERIF. | GAP |
|---|---|---|---|---|---|---|---|
| sse.md | 12 | 6 | 3 | 1 | 2 | 0 | 1 |
| egsee.md | 10 | 6 | 1 | 0 | 2 | 1 | 0 |
| syndikalismos.md | 12 | 9 | 1 | 1 | 1 | 0 | 1 |
| apergia.md | 15 | 8 | 3 | 0 | 2 | 1 | 2 |
| diavoulefsi.md | 7 | 7 | 0 | 0 | 0 | 0 | 1 (currency) |
| symboulia-ergazomenon.md | 10 | 5 | 3 | 0 | 2 | 0 | 0 |
| index.md | 11 | 7 | 1 | 2 | 1 | 0 | 0 |

**Headline.** Two errors recur across files and are the batch's spine:

1. **Fabricated "40% extension threshold."** Both `sse.md` and `index.md` claim a ΣΣΕ can be extended (κήρυξη γενικώς υποχρεωτικής) when it covers **40%** of the sector, "reduced from 50%" — one attributes it to **Ν.4808/2021**, the other to a nonexistent **"Κοινωνική Συμφωνία του 2025."** Both are **false**. The threshold is **more than 50%** and the governing amendment is **Ν.4635/2019 art.56** (which restored the extension mechanism + favourability principle). Primary source verbatim: *«εργοδότες που απασχολούν ποσοστό μεγαλύτερο του πενήντα τοις εκατό (50%) των εργαζομένων του κλάδου ή του επαγγέλματος»* (hli.gov.gr).

2. **The two task-flagged bugs are confirmed:** `sse.md` line 72 mislabels **Ν.1767/1988** as "ΟΜΕΔ" and links it to a **ΠΔ-240/2006** URL (ΟΜΕΔ's real basis is **Ν.1876/1990**; Ν.1767/1988 = **Συμβούλια Εργαζομένων**); `apergia.md` writes **"συνταξιακό"** where it means **"συνταγματικό"** (twice).

Other worker-facing errors: the **union founding minimum is 20, not 10** (`syndikalismos.md`, repeated in the closing call-to-action as "9 more colleagues"); **strike notice for public utilities is 4 full days, not 48h** (`apergia.md`); works-council members' dismissal needs **no ΟΜΕΔ approval** and the term is **2 years, not 3**, with **bimonthly not quarterly** meetings (`symboulia-ergazomenon.md`); blue-collar seniority pay is **τριετίες (5%×6), not πενταετίες** (`egsee.md`); probation is now **6 months, not 12** (`index.md`). The whole batch is also **structurally stale**: all seven files predate the **ΚΕΔ / ΠΔ 62/2025** recodification of collective law (Βιβλίο Β΄, arts 368–490) and none cites it.

**Cross-cutting (applies to all files, logged once):**
- **Ν.4808/2021 raised the strike-vote απαρτία for πρωτοβάθμιες from 1/3 to 50%+1** of financially-active members — a major restriction on the right to strike that a militant guide should expose. Neither `apergia.md` nor `syndikalismos.md` mentions it. Verbatim: *«η Γενική Συνέλευση βρίσκεται σε απαρτία όταν παρευρίσκονται σ' αυτή το ½ τουλάχιστον των ταμειακά εντάξει μελών της»*; *«Για τις μείζονες αποφάσεις της ΓΣ … απαιτείται το 50%+1 των μελών (μείζονες αποφάσεις θεωρούνται οι αποφάσεις για απεργία…)».*
- **"ΣΕΠΕ" is an outdated name.** Ν.4808/2021 (arts 101 κ.επ.) reconstituted the Σώμα Επιθεώρησης Εργασίας as the **Επιθεώρηση Εργασίας** (Independent Authority). The 1555 line still works; the acronym should read Επιθεώρηση Εργασίας. Systemic — not re-logged per file.

---

## FILE 1 — `symvasi/sse.md`

### OK claims (confirmed)
- ΣΣΕ = γραπτή συμφωνία εργοδοτών/εργοδοτικών οργανώσεων ↔ συνδικαλιστικών οργανώσεων — **OK** (Ν.1876/1990; ΚΕΔ arts 394 κ.επ.).
- Four types (ΕΓΣΣΕ / κλαδική / επιχειρησιακή / ομοιοεπαγγελματική) — **OK** (Ν.1876/1990 art.3; minor imprecision on επιχειρησιακή signatory, below).
- Binds members of signatory organisations; extension reaches non-members — **OK** in principle (Ν.1876/1990 art.8, as amended Ν.4808/2021 art.97).
- Αρχή της ευνοϊκότερης ρύθμισης; ΣΣΕ overrides individual contract only where more favourable; no downgrade — **OK** (Ν.1876/1990 art.7 §2; favourability principle restored by Ν.4635/2019).
- ΟΜΕΔ two-step: μεσολάβηση (non-binding) → διαιτησία (binding, ΣΣΕ force) — **OK** (Ν.1876/1990 arts 15–16; optional refinement: μονομερής προσφυγή στη διαιτησία survives in limited cases under art.16 §2, and Ν.4808/2021 art.98 moved συμφιλίωση to ΟΜΕΔ).
- 5-year prescription of claims; ΣΕΠΕ/σωματείο/αγωγή enforcement route — **OK**.

### WRONG-1 (MAJOR) — the "40% extension threshold" is fabricated
- **Verbatim (line 26):** `Αν η ΣΣΕ καλύπτει **40% ή περισσότερους** εργαζόμενους του κλάδου (μηχανισμός επέκτασης, Ν. 4808/2021 — παλαιότερα 50%), το Υπουργείο Εργασίας μπορεί να την **επεκτείνει** υποχρεωτικά…`
- **Why wrong:** The extension (κήρυξη ως γενικώς υποχρεωτικής) requires that the ΣΣΕ already bind employers employing **more than 50%** of the sector's/occupation's workers. There is **no 40% threshold** and **no reduction** of the 50% figure. The mechanism was restored (after the memoranda suspension) by **Ν.4635/2019 art.56**, not Ν.4808/2021.
- **Replacement:** `Αν η ΣΣΕ δεσμεύει ήδη εργοδότες που απασχολούν **πάνω από το 50%** των εργαζομένων του κλάδου ή του επαγγέλματος, ο Υπουργός Εργασίας μπορεί, μετά από γνώμη του Ανώτατου Συμβουλίου Εργασίας, να την **κηρύξει γενικώς υποχρεωτική** για όλους τους εργαζόμενους του κλάδου, ακόμη και μη μέλη.`
- **Legal basis:** **Ν.1876/1990 άρθρο 11 §2**, as amended by **Ν.4635/2019 άρθρο 56** → **ΚΕΔ (ΠΔ 62/2025) arts 394–414** (KED-MAP #56).
- **Source / verbatim quote:** Επιθεώρηση Εργασίας — *«εργοδότες που απασχολούν ποσοστό μεγαλύτερο του πενήντα τοις εκατό (50%) των εργαζομένων του κλάδου ή του επαγγέλματος»*. https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/loipa-themata/syllogikes-symvaseis-ergasias-sse/desmefsi-apo-s-s-e/
- **Confidence:** High.

### WRONG-2 — legislation note repeats the 40% error + wrong article
- **Verbatim (line 71):** `[Ν. 4808/2021](…) — Τροποποίηση του μηχανισμού επέκτασης (40% αντί 50%), άρθρο 96`
- **Why wrong:** Same fabricated 40%. Ν.4808/2021 art.97 amended the *binding* rule (art.8 Ν.1876/1990); it did **not** set a 40% extension threshold. The extension amendment is Ν.4635/2019 art.56.
- **Replacement:** `[Ν. 4635/2019](https://www.e-nomothesia.gr/…/n-4635-2019.html) — Επαναφορά του μηχανισμού επέκτασης ΣΣΕ και της αρχής της ευνοϊκότερης ρύθμισης (τροποποίηση άρθρου 11 Ν.1876/1990)` and keep Ν.4808/2021 only for the binding-scope amendment (art.97).
- **Legal basis:** Ν.4635/2019 art.56; Ν.4808/2021 art.97.
- **Confidence:** High.

### WRONG-3 (TASK-FLAGGED) — Ν.1767/1988 mislabelled "ΟΜΕΔ" and mis-linked to ΠΔ-240/2006
- **Verbatim (line 72):** `[Ν. 1767/1988](https://www.e-nomothesia.gr/kat-ergasia-koinonike-asphalise/p-d-240-2006.html) — ΟΜΕΔ (ίδρυση και λειτουργία)`
- **Why wrong (triple error):** (a) **ΟΜΕΔ** was established by **Ν.1876/1990** (arts 14–17), already correctly listed on line 70 — not Ν.1767/1988. (b) **Ν.1767/1988** is the law on **Συμβούλια Εργαζομένων** (works councils), unrelated to ΟΜΕΔ. (c) The URL points to the **ΠΔ 240/2006** page (a third, different instrument — info & consultation).
- **Replacement:** `[Ν. 1767/1988](https://ypergasias.gov.gr/wp-content/uploads/2021/03/Ν.-1767-1988-ΦΕΚ-Α-63.pdf) — Συμβούλια Εργαζομένων` (and drop the erroneous "ΟΜΕΔ" description; ΟΜΕΔ stays on the Ν.1876/1990 line). Note: `sse.md` is about ΣΣΕ, so a Ν.1767/1988 entry is arguably out of scope here — could simply be removed.
- **Legal basis:** ΟΜΕΔ = Ν.1876/1990 arts 14–17 (ΚΕΔ 394–414); Συμβούλια Εργαζομένων = Ν.1767/1988 (ΚΕΔ 425–441, KED-MAP #52).
- **Source / verbatim quote:** omed.gr — ΟΜΕΔ *«συστάθηκε το 1990 με τον ν.1876/1990»*; Ν.1767/1988 ΦΕΚ Α΄63 «Συμβούλια εργαζομένων…». https://www.omed.gr/ ; https://ypergasias.gov.gr/wp-content/uploads/2021/03/Ν.-1767-1988-ΦΕΚ-Α-63.pdf
- **Confidence:** High.

### OUTDATED-1 — μετενέργεια described as a flat "6 months"
- **Verbatim (lines 36–37):** `τα καθορισμένα **ατομικά δικαιώματα** (μισθός, επιδόματα, βαθμολόγιο) συνεχίζουν να ισχύουν για **6 μήνες** μετά τη λήξη. Αυτό λέγεται **μετενέργεια**.`
- **Why outdated:** Two conflated concepts, both changed by **ΠΥΣ 6/2012**. (a) After expiry a ΣΣΕ continues **in full for a 3-month παράταση** (was 6 months) and applies to new hires in that window. (b) *After* the trimester, **μετενέργεια** retains only the **basic wage + four allowances** (ωρίμανσης/τριετίες, τέκνων, σπουδών, επικίνδυνης εργασίας) as individual-contract terms until a new ΣΣΕ/agreement — everything else drops to statutory minima. The corpus's "6 months" and "μισθός, επιδόματα, βαθμολόγιο" both overstate current protection.
- **Replacement:** `Μετά τη λήξη, η ΣΣΕ ισχύει αυτούσια για **3 μήνες** (παράταση). Αν δεν συναφθεί νέα, μετά το τρίμηνο διατηρούνται ως ατομικοί όροι μόνο ο **βασικός μισθός/ημερομίσθιο** και τέσσερα επιδόματα (**ωρίμανσης, τέκνων, σπουδών, επικίνδυνης εργασίας**) — τα υπόλοιπα καταργούνται. Αυτό λέγεται **μετενέργεια** (ΠΥΣ 6/2012).`
- **Legal basis:** **Ν.1876/1990 άρθρο 9 §§4–5** as amended by **ΠΥΣ 6/28.2.2012 άρθρο 2 §4**; settled case-law ΑΠ 1041/2020, ΑΠ 395/2021.
- **Source / verbatim quote:** ΚΕΠΕΑ/ΓΣΕΕ & pim.gr — *«…μετά την πάροδο του τριμήνου … εξακολουθούν να ισχύουν … ο βασικός μισθός ή το βασικό ημερομίσθιο και τα επιδόματα ωρίμανσης, τέκνων, σπουδών και επικινδύνου εργασίας…».* https://www.kepea.gr/metenergeia-s-s-e ; https://www.pim.gr/enimerosi/ergasiaka/nomologia/i-metenergeia-ton-sse-kai-da-meta-tin-pys-6-2012-areiou-pagou-395-2021
- **Confidence:** High.

### WRONG-4 / OUTDATED — "Η ΕΓΣΣΕ θέτει τον εθνικό κατώτατο μισθό"
- **Verbatim (line 20):** `Η ΕΓΣΣΕ θέτει τον **εθνικό κατώτατο μισθό** (ή ελάχιστα όρια) και αποτελεί το υπόδειγμα για όλες τις κατώτερες ΣΣΕ.`
- **Why wrong now:** Since 2012 the **νομοθετημένος κατώτατος μισθός** is fixed by the **State** — Υπουργική Απόφαση with Cabinet approval after a set consultation procedure — **not** by the ΕΓΣΣΕ. Any statutory reference to "ΕΓΣΣΕ minimum wage" is now read as a reference to the state-set minimum.
- **Replacement:** `Ο εθνικός κατώτατος μισθός καθορίζεται πλέον **νομοθετικά** (Υπουργική Απόφαση με έγκριση Υπουργικού Συμβουλίου, Ν.4172/2013 άρθρο 103) — όχι από την ΕΓΣΣΕ. Η ΕΓΣΣΕ θέτει ελάχιστους όρους που δεσμεύουν τα μέλη των υπογραφουσών οργανώσεων.`
- **Legal basis:** **Ν.4046/2012 / ΠΥΣ 6/2012**; **Ν.4172/2013 άρθρο 103** (διαδικασία); minimum-wage amount currently **ΚΥΑ 8934/2026 (Β΄1759)** = €920. ΚΕΔ codifies the process at art.141/141Α.
- **Source / verbatim quote:** ypergasias.gov.gr / taxheaven Ν.4172/2013 art.103 — *«…ο κατώτατος μισθός … καθορίζεται με απόφαση του Υπουργού Εργασίας … κατόπιν εγκρίσεως του Υπουργικού Συμβουλίου…»*. https://www.taxheaven.gr/law/4172/2013/arthro/103
- **Confidence:** High.

### IMPRECISE-1 — wrong "Υπουργείο Εργασίας" source
- **Verbatim (line 52):** `ψάξε στο **Υπουργείο Εργασίας** (ergasianews.gr) για τον κατάλογο κατατεθειμένων ΣΣΕ`
- **Why imprecise:** `ergasianews.gr` is a private news portal, not the Ministry. The ministry site is **ypergasias.gov.gr**; deposited ΣΣΕ are also traceable via ΟΜΕΔ (omed.gr).
- **Replacement:** `…στο Υπουργείο Εργασίας (**ypergasias.gov.gr**) ή στον ΟΜΕΔ (omed.gr)…`
- **Confidence:** High.

### IMPRECISE-2 — who signs an επιχειρησιακή ΣΣΕ when no enterprise union exists
- **Verbatim (line 17):** `Σωματείο επιχείρησης ή **ΓΣΕΕ** (αν δεν υπάρχει σωματείο) – εργοδότης`
- **Why imprecise:** Not the ΓΣΕΕ. Where no enterprise union exists, an επιχειρησιακή ΣΣΕ may be concluded by the relevant **κλαδική/ομοιοεπαγγελματική οργάνωση**, or by an **ένωση προσώπων** (min 3/5 of the workforce, Ν.1264/1982 art.1 §3 as amended).
- **Replacement:** `…ή η αντίστοιχη κλαδική/ομοιοεπαγγελματική οργάνωση, ή ένωση προσώπων (αν δεν υπάρχει σωματείο) – εργοδότης`
- **Legal basis:** Ν.1876/1990 art.6; ένωση προσώπων per Ν.1264/1982 art.1 §3 (as am.).
- **Confidence:** Medium (verify exact ένωση-προσώπων quorum before editing).

### GAP-1 — no mention that the extension mechanism was *suspended* 2011–2019
- Militant framing opportunity: the extension/favourability tools the file relies on were **frozen by the memoranda** (Ν.4024/2011, ΠΥΣ 6/2012) and only **restored by Ν.4635/2019**. Worth stating so readers grasp how fragile these protections are.

### Currency note
- ΣΣΕ + μεσολάβηση/διαιτησία (ΟΜΕΔ) now recodified at **ΚΕΔ (ΠΔ 62/2025) arts 394–414** (Βιβλίο Β΄, ΜΕΡΟΣ Β΄). Underlying Ν.1876/1990 cite stays valid; add the ΚΕΔ pointer.

---

## FILE 2 — `symvasi/egsee.md`

### OK claims (confirmed)
- ΕΓΣΣΕ = floor for the whole private sector, covers unionised and non-unionised alike — **OK**.
- Negotiated by ΓΣΕΕ ↔ central employer confederations — **OK** (signatory list dated, below).
- Αρχή ευνοϊκότερης ρύθμισης; ΕΓΣΣΕ fills gaps in κλαδικές — **OK**.
- Below-ΕΓΣΣΕ individual terms are void — **OK**.
- Post-2012 collapse of the extension mechanism — **OK** (good, accurate framing).
- Enforcement route (ΣΕΠΕ, κλαδικός σύνδεσμος, ΓΣΕΕ text) — **OK**.
- Επίδομα γάμου 10% — **OK** (still live; ΕΓΣΣΕ extended to 31.12.2026; binds employees of ΓΣΕΒΕΕ/ΕΣΕΕ/ΣΕΤΕ-member employers).
- Τριετίες (λευκοί) 10%/τριετία up to a cap — **OK** (3×10% = 30%, ≥9 yrs).

### WRONG-1 — "Πενταετίες (μπλε)… ανά πενταετία"
- **Verbatim (line 24):** `**Πενταετίες (μπλε)** — αντίστοιχη αύξηση για εργατοτεχνίτες ανά **πενταετία**`
- **Why wrong:** Blue-collar workers (εργατοτεχνίτες) also accrue seniority pay per **τριετία (3 years)** — **5% each, up to 6 τριετίες = 30%** at 18 years — **not** per πενταετία. There is no five-year increment in the current minimum-pay regime.
- **Replacement:** `**Τριετίες (εργατοτεχνίτες)** — 5% ανά τριετία, έως 6 τριετίες (30%) στα 18 έτη προϋπηρεσίας.`
- **Legal basis:** **Ν.4093/2012 (ΠΥΣ 6/2012)**; seniority increments now statutory, not contractual. (υπάλληλοι 3×10%; εργατοτεχνίτες 6×5%.)
- **Source / verbatim quote:** ΚΕΠΕΑ/ΓΣΕΕ — *«…για τους εργατοτεχνίτες 6 τριετίες με προσαύξηση 5% (συνολικά 30% για προϋπηρεσία 18 ετών και άνω)…».* https://www.kepea.gr/aarticle.php?id=2801
- **Confidence:** High.

### IMPRECISE-1 — basic wage "ιστορικά ανώτερο από τον νομοθετημένο κατώτατο"
- **Verbatim (line 21):** `**Βασικό μισθό / ημερομίσθιο** — ιστορικά ανώτερο από τον νομοθετημένο κατώτατο μισθό, αν και η απόκλιση αυτή μειώθηκε μετά τα μνημόνια`
- **Why imprecise:** Defensible as history, but the reader should know the ΕΓΣΣΕ **no longer determines** the national minimum wage (state-set by ΚΥΑ since 2012, Ν.4172/2013 art.103); the ΕΓΣΣΕ basic wage now binds only members of signatory employer organisations.
- **Replacement (add clause):** `…· από το 2013 όμως ο εθνικός κατώτατος μισθός ορίζεται νομοθετικά (ΚΥΑ), και ο βασικός μισθός της ΕΓΣΣΕ δεσμεύει πλέον μόνο τα μέλη των υπογραφουσών οργανώσεων.`
- **Confidence:** High.

### IMPRECISE-2 — dated signatory list
- **Verbatim (line 13):** `**ΣΕΒ** … **ΕΣΕΕ** … **ΓΣΕΒΕΕ** …`
- **Why imprecise:** Recent ΕΓΣΣΕ have been signed by **ΓΣΕΒΕΕ, ΕΣΕΕ and ΣΕΤΕ** (tourism confederation); **ΣΕΒ has not been a signatory** of the latest agreements. The marriage-allowance obligation, notably, binds only employees of ΓΣΕΒΕΕ/ΕΣΕΕ/ΣΕΤΕ-member employers.
- **Replacement:** add ΣΕΤΕ; note ΣΕΒ's non-participation in recent ΕΓΣΣΕ.
- **Source / verbatim quote:** *«…δεσμεύει μόνο τους εργαζόμενους … σε εργοδότες που ανήκουν στις Οργανώσεις που συνεβλήθησαν … ΓΣΕΒΕΕ, ΕΣΕΕ και ΣΕΤΕ».* https://www.kepea.gr/epidoma-gamou
- **Confidence:** Medium-High.

### IMPRECISE-3 — τριετίες framed as an ΕΓΣΣΕ benefit
- Lines 23–24 present τριετίες as ΕΓΣΣΕ output. They are **now statutory** (Ν.4093/2012), not ΕΓΣΣΕ-granted. Cross-ref `misthos-core.md`. Low priority (historically true).

### UNVERIFIABLE-1 — "Επίδομα τέκνων" as a current ΕΓΣΣΕ benefit
- **Verbatim (line 25):** `**Επίδομα τέκνων** — για εργαζόμενους με παιδιά`
- A general child allowance in the *current* ΕΓΣΣΕ could **not** be confirmed against a primary source (the live ΕΓΣΣΕ retains επίδομα γάμου + reference to τριετίες; a standalone επίδομα τέκνων appears historical/absorbed). **Do not edit** — flag for HUMAN-REVIEW to confirm whether any live ΣΣΕ still grants it.
- **Confidence:** Medium that it is stale; not asserting.

### Currency note
- ΚΕΔ arts 394–414 (ΣΣΕ). Add pointer.

---

## FILE 3 — `symvasi/syndikalismos.md`

### OK claims (confirmed)
- Right to found/join/leave a union, without consequence — **OK** (Const. art.23; Ν.1264/1982).
- Registration at Πρωτοδικείο confers legal personality — **OK**.
- Employer-interference prohibition (list) → penalties — **OK** (Ν.1264/1982 art.14, am. Ν.4808/2021 art.88).
- **ΔΣ dismissal-protection numbers: ≤200 → 5, ≤1.000 → 7, >1.000 → 9** — **OK, CONFIRMED verbatim** (art.14 §6).
- Protection during term **+ 1 year after** — **OK**.
- Founding-members protected 1 year — **OK** (refine: the first **21** founders, where the firm employs **>80** workers).
- **Union-leave table** (primary <500 → 3 days/mo; ≥500 → 5 days/mo; secondary → 9 days/mo members, 15 for officers) — **OK, CONFIRMED verbatim** (art.17).
- Union leave is paid, not deducted from annual leave — **OK**.
- Strike: called by primary/secondary unions; 24h notice; public utility 4 days + minimum service — **OK, CONFIRMED**.
- No strikebreakers (art.22); no lock-out; no pay cut beyond strike days; no reprisals — **OK**.
- Enforcement (Επιθεώρηση Εργασίας 1555, ασφαλιστικά μέτρα, δευτεροβάθμια, ΟΜΕΔ) — **OK**.

### WRONG-1 — union founding minimum is 20, not 10 (appears twice)
- **Verbatim (line 19):** `**Ελάχιστος αριθμός ιδρυτών:** 10 εργαζόμενοι για πρωτοβάθμιο σωματείο.`
- **Verbatim (line 141):** `Χρειάζεσαι **9 ακόμα** συναδέλφους…`
- **Why wrong:** A trade-union σωματείο is an association under **ΑΚ art.78**, requiring **at least 20** founding members. There is no special "10" rule for πρωτοβάθμια εργατικά σωματεία.
- **Replacement:** line 19 → `**Ελάχιστος αριθμός ιδρυτών:** 20 εργαζόμενοι για πρωτοβάθμιο σωματείο.`; line 141 → `Χρειάζεσαι **19 ακόμα** συναδέλφους…`.
- **Legal basis:** **ΑΚ άρθρο 78** applied to συνδικαλιστικά σωματεία via Ν.1264/1982.
- **Source / verbatim quote:** ypergasias.gov.gr — *«…για τη σύσταση εργατικών σωματείων, τα οποία αποτελούν πρωτοβάθμιες συνδικαλιστικές οργανώσεις, απαιτείται η σύμπραξη **20 τουλάχιστον** εργαζομένων (άρθρο 78 ΑΚ).»* https://ypergasias.gov.gr/ergasiakes-scheseis/syllogikes-ergasiakes-sxeseis/sychnes-erotiseis/syndikalistikes-organoseis-kai-syllogiki-organosi/
- **Confidence:** High.

### OUTDATED-1 — the closed list of "grave reasons" for dismissing a protected unionist
- **Verbatim (lines 67–69):** `Εξαιρέσεις υπάρχουν μόνο για πολύ σοβαρούς λόγους (ποινική καταδίκη για δόλια απάτη σε βάρος εργοδότη, βιομηχανική κατασκοπεία, σωματική βλάβη συναδέλφων, αδικαιολόγητη απουσία άνω των 7 ημερών).`
- **Why outdated:** **Ν.4808/2021 art.88** rewrote Ν.1264/1982 art.14: the old **closed enumerated list** was abolished and the **special Επιτροπή Προστασίας** pre-approval procedure was scrapped. Dismissal of a protected unionist is now permitted only for a **σπουδαίος/βάσιμος λόγος** (linked to the general dismissal-validity standard, Ν.4808/2021 art.66); otherwise it is **null** (αυτοδικαίως άκυρη). The listed items survive only as illustrations of "serious reasons."
- **Replacement:** `Η απόλυση προστατευόμενου στελέχους είναι **αυτοδικαίως άκυρη**, εκτός αν συντρέχει **σπουδαίος λόγος** (π.χ. βαριά παραβίαση καθηκόντων, ποινικό αδίκημα σε βάρος του εργοδότη). Δεν απαιτείται πλέον προηγούμενη έγκριση επιτροπής (καταργήθηκε με τον Ν.4808/2021).`
- **Legal basis:** Ν.1264/1982 art.14 as am. **Ν.4808/2021 art.88**; standard per art.66 (ΚΕΔ art.350).
- **Source / verbatim quote:** hli.gov.gr «Προστασία των Συνδικαλιστικών Στελεχών»; taxlaw.gr — *«καταργήθηκε … η προσφυγή σε Επιτροπή που προηγείτο της απόλυσης … πλέον απαιτείται βάσιμος λόγος (άρθρο 66)».* https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/prostasia/syndikalistes/prostasia-ton-syndikalistikon-stelechon/
- **Confidence:** High.

### GAP-1 — strike-vote απαρτία raised to 50%+1 (Ν.4808/2021) not mentioned
- **Problem:** The "Δικαίωμα απεργίας" section (lines 93–113) describes who can call a strike but omits that **Ν.4808/2021** raised the General-Assembly απαρτία for a **πρωτοβάθμια** organisation from **1/3 to 50%+1** of financially-active members — a serious hurdle a militant guide should flag.
- **Add:** `Προσοχή: με τον Ν.4808/2021, η απόφαση απεργίας πρωτοβάθμιου σωματείου απαιτεί απαρτία **50%+1** των ταμειακά εντάξει μελών στη Γενική Συνέλευση (πριν αρκούσε το 1/3) — σημαντικός περιορισμός.`
- **Legal basis:** Ν.4808/2021 art.86/91 amending Ν.1264/1982 arts 8/20 (ΚΕΔ 415–421).
- **Source / verbatim quote:** *«η Γενική Συνέλευση βρίσκεται σε απαρτία όταν παρευρίσκονται σ' αυτή το ½ τουλάχιστον των ταμειακά εντάξει μελών της».* (Υπ. Εργασίας εγκ. 62587/2021.)
- **Confidence:** High.

### IMPRECISE-1 — article citation for the join/found right
- Line 24 cites `Ν. 1264/1982, άρθρο 1 … και άρθρο 7 (δικαίωμα εγγραφής)`. Art.1 (levels/scope) is fine; the "art.7 = δικαίωμα εγγραφής" pin should be **verified** before relying on it (the substantive right is Const. art.23 + Ν.1264/1982 arts 1 & 7). Low priority.

### Currency note
- Trade-union law → **ΚΕΔ arts 368–386** (union leave 383, protection 381); strike → **ΚΕΔ 415–421**. Add pointers.

---

## FILE 4 — `symvasi/apergia.md`

### OK claims (confirmed)
- Definition: collective withdrawal of labour for labour/social interests — **OK**.
- Only unions (primary/secondary/tertiary) may lawfully call a strike — **OK**.
- **24h notice for private-sector strikes** — **OK, CONFIRMED verbatim**.
- Public-utility list (νοσοκομεία, ΔΕΗ, νερό, τηλεπικοινωνίες, μεταφορές) — **OK** (matches art.19 §2).
- No dismissal/discipline for lawful strike (art.22); leaves/benefits not stripped as reprisal — **OK**.
- No pay for strike days (lawful, expected) — **OK**; lock-out/provocation exception — **OK**.
- No strikebreakers, incl. group-company substitutes — **OK**.
- Illegal-strike civil liability lies against the **organisation**, not individual strikers — **OK** (damages; individuals' absence may separately count as unjustified).
- Purely political strike (no labour demand) is illegal — **OK**.
- Designated safety staff must attend and are paid normally — **OK**.

### WRONG-1 (TASK-FLAGGED) — "συνταξιακό" → "συνταγματικό" (twice)
- **Verbatim (line 10):** `Αποτελεί **συνταξιακό δικαίωμα** (άρθρο 23 παρ. 2 του Συντάγματος)…`
- **Verbatim (line 155):** `[Σύνταγμα, άρθρο 23](…) — **Συνταξιακό** δικαίωμα απεργίας`
- **Why wrong:** Pure typo. The strike is a **συνταγματικό** (constitutional) right — Σύνταγμα art.23 §2 — nothing to do with pensions (συνταξιακό).
- **Replacement:** both → **συνταγματικό**.
- **Legal basis:** Σύνταγμα άρθρο 23 §2; Ν.1264/1982 art.19.
- **Confidence:** High.

### WRONG-2 — public-utility strike notice stated as "48 hours"
- **Verbatim (line 24):** `**48 ώρες** πριν για επιχειρήσεις κοινής ωφέλειας (ΔΕΗ, ύδρευση, αποχέτευση κλπ.)`
- **Verbatim (line 25):** `**4 ημέρες** πριν για μέσα μαζικής μεταφοράς`
- **Verbatim (line 113):** `Η προειδοποίηση απεργίας (**48 ώρες** πριν)…`
- **Why wrong:** For **all** public/common-utility enterprises (which include ΔΕΗ, water, sewage **and** mass transport — art.19 §2), the strike may not start until **4 full days** after service of the demands. There is **no 48-hour tier**; the utility/transport split is invented.
- **Replacement:** collapse to one rule: `**4 πλήρεις ημέρες** πριν για όλες τις επιχειρήσεις κοινής ωφέλειας (νοσοκομεία, ΔΕΗ, νερό, αποχέτευση, τηλεπικοινωνίες, μέσα μεταφοράς).` Line 113 → `4 πλήρεις ημέρες`.
- **Legal basis:** **Ν.1264/1982 art.19 §2 → art.20 §2** (am. Ν.4808/2021 art.90); ΚΕΔ 415–421.
- **Source / verbatim quote:** hli.gov.gr — *«η κήρυξη απεργίας δεν μπορεί να πραγματοποιηθεί πριν περάσουν **τέσσερις (4) πλήρεις ημέρες**»*; lawspot art.19 — *«προειδοποίηση του εργοδότη … 24 τουλάχιστο ώρες πριν»* (the 24h being the ordinary-sector rule). https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/prostasia/syndikalistes/kiryxi-apergias/ ; https://www.lawspot.gr/nomothesia/n-1264-1982/arthro-19-nomos-1264-1982-dikaioma-apergias/
- **Confidence:** High.

### WRONG-3 — employer "designates" safety personnel (self-contradiction)
- **Verbatim (line 37):** `Ο εργοδότης ορίζει ποιοι εργαζόμενοι παραμένουν σε εργασία (**προσωπικό ασφαλείας**).`
- **Why wrong:** The **union** that declares the strike designates the προσωπικό ασφαλείας; the employer **cannot** unilaterally name workers. The file itself says the opposite correctly at line 115 (`ο εργοδότης δεν μπορεί να ορίσει μονομερώς`) — line 37 is an internal contradiction.
- **Replacement:** `Η **συνδικαλιστική οργάνωση** που κηρύσσει την απεργία ορίζει το προσωπικό ασφαλείας — όχι ο εργοδότης.`
- **Legal basis:** **Ν.1264/1982 art.21** as replaced by **Ν.4808/2021 art.95**; ΚΕΔ 415–421.
- **Source / verbatim quote:** hli.gov.gr — unions must *«designate safety personnel»* and, for utilities, minimum-service staff. https://www.hli.gov.gr/…/kiryxi-apergias/
- **Confidence:** High.

### IMPRECISE-1 — minimum service "30%"
- **Verbatim (line 139):** `υποχρεούνται να διατηρούν τουλάχιστον το **30% της κανονικής δυναμικότητας**`
- **Why imprecise:** The statutory minimum guaranteed service for public utilities is **one-third (1/3 ≈ 33,3%)** of normally-provided service, not 30%, and it is set as "στοιχειώδεις ανάγκες."
- **Replacement:** `…τουλάχιστον το **ένα τρίτο (1/3)** της συνήθως παρεχόμενης υπηρεσίας (προσωπικό ελάχιστης εγγυημένης λειτουργίας).`
- **Legal basis:** **Ν.4808/2021 art.95** (adding minimum-service duty to Ν.1264/1982 art.21); ΚΕΔ 415–421.
- **Source / verbatim quote:** *«…τουλάχιστον το ένα τρίτο (1/3) της συνήθως παρεχόμενης υπηρεσίας».* (Υπ. Εργασίας εγκ. 62587/2021.)
- **Confidence:** High.

### IMPRECISE-2 — "Συμπαθητική απεργία … Επιτρέπεται"
- **Verbatim (line 89):** `Απεργία αλληλεγγύης … **Επιτρέπεται** αλλά δεν αναστέλλει την υποχρέωση γνωστοποίησης`
- **Why imprecise:** Solidarity strikes are lawful **only** where the strikers have their own connected economic/labour/insurance interest, or in the specific multinational-dependency case of art.19 §1(b). A pure sympathy strike with no own-interest link is generally held **unlawful**. A flat "Επιτρέπεται" overstates.
- **Replacement:** `…νόμιμη μόνο όταν οι απεργοί έχουν δικό τους συνδεόμενο συμφέρον (ή στην ειδική περίπτωση πολυεθνικών, άρθρο 19 §1β)· η καθαρή απεργία συμπαράστασης χωρίς ίδιον συμφέρον κρίνεται συνήθως παράνομη.`
- **Legal basis:** Ν.1264/1982 art.19 §1.
- **Confidence:** Medium-High.

### UNVERIFIABLE-1 — "Απεργία πεχτρέβα (εν ψυχρώ)"
- **Verbatim (line 76):** `### Απεργία **πεχτρέβα** (εν ψυχρώ)`
- **"πεχτρέβα" is not standard Greek labour terminology** and could not be confirmed. The described conduct (strict rule-observance / withholding extra effort) is **work-to-rule = λευκή απεργία / απεργία κανονισμών / απεργία ζήλου** (whose legal status as a "strike" is itself contested). **Do not invent** a source; recommend relabelling to a recognised term (λευκή απεργία) — flag for HUMAN-REVIEW.
- **Confidence:** High that "πεχτρέβα" is non-standard; term choice for the fix left to review.

### GAP-1 — strike-vote απαρτία 50%+1 (Ν.4808/2021)
- Same omission as `syndikalismos.md` GAP-1: the primary-union απαρτία is now **50%+1** of financially-active members. Line 21 ("Απόφαση Γενικής Συνέλευσης **ή Διοικητικού Συμβουλίου**") is also loose — for a **primary** union the **GA** (at 50%+1) decides the strike; the ΔΣ route is for higher-tier bodies. Add the quorum + tighten.

### GAP-2 — pre-strike ΟΜΕΔ "public dialogue" prerequisite
- Ν.4808/2021 requires the calling union to **file a public-dialogue (δημόσιος διάλογος) request with ΟΜΕΔ** before the strike. The file lists notice to employer/ΣΕΠΕ but omits this precondition. Worth stating (again, a restriction to expose).
- **Source:** hli.gov.gr — *«File a public dialogue request with … O.M.E.D.»* before the strike. https://www.hli.gov.gr/…/kiryxi-apergias/

### Currency note
- Strike law → **ΚΕΔ (ΠΔ 62/2025) arts 415–421** (KED-MAP #54; art.420 = προσωπικό ασφαλείας/ελάχιστης λειτουργίας, am. Ν.5053/2023 art.31). Cite Ν.1264/1982 arts 19–22 **and** the ΚΕΔ.

---

## FILE 5 — `symvasi/diavoulefsi.md`

### OK claims (confirmed)
- Trigger events: collective redundancies (pre-ΣΕΠΕ filing), transfer of undertaking, major changes to working conditions, new technology affecting many — **OK**.
- Consultation ≠ announcement: timely adequate information, real time to respond, reasoned reply, no decision before completion (bar genuine emergency) — **OK** (ΠΔ 240/2006 art.4).
- Counterparties: works council or enterprise unions — **OK**.
- Consequences: collective redundancies **void** without ΣΕΠΕ-notice/consultation; transfer challengeable; ΣΕΠΕ fines — **OK**.
- Legislation: Ν.1767/1988, ΠΔ 240/2006 (Οδ. 2002/14/ΕΚ), Ν.1387/1983 — **OK** (all correctly cited — a clean file).

### GAP-1 (currency only)
- Recodification pointers: information & consultation → **ΚΕΔ arts 442–451** (European works councils 452–477); works councils → **ΚΕΔ 425–441**; collective redundancies → **ΚΕΔ 352–357**. Content is accurate; only the citations are pre-ΚΕΔ. **No factual defect.**

---

## FILE 6 — `symvasi/symboulia-ergazomenon.md`

### OK claims (confirmed)
- Works councils = elected bodies, parallel to unions, representing **all** employees regardless of union membership — **OK** (Ν.1767/1988).
- Information right (economic situation, business plans, major changes) — **OK**.
- Consultation right before collective redundancies / transfer / restructuring — **OK**.
- Secret ballot election — **OK** (add: also **άμεση**/direct).
- Comparison table (works council cannot call a strike or sign a ΣΣΕ; union can) — **OK**.
- ΣΕΠΕ complaint / fines route; right to constitute despite employer resistance — **OK**.

### WRONG-1 — term of office "3 years"
- **Verbatim (line 17):** `Η θητεία των εκλεγμένων μελών είναι **3 χρόνια**.`
- **Why wrong:** Works-council elections are held **every two (2) years** — the term is **2 years**, not 3.
- **Replacement:** `Η θητεία των εκλεγμένων μελών είναι **2 χρόνια** (εκλογές κάθε δύο έτη).`
- **Legal basis:** **Ν.1767/1988 άρθρο 4 §1**; ΚΕΔ 425–441.
- **Source / verbatim quote:** *«Οι εκλογές … γίνονται κάθε δύο (2) έτη … με άμεση και μυστική ψηφοφορία».* (Ν.1767/1988 art.4, syllogos.gr full text.) https://www.syllogos.gr/nomothesia/3024-νόμος-1767-88-συμβούλια-εργαζομένων
- **Confidence:** High.

### WRONG-2 — meetings "at least quarterly"
- **Verbatim (line 25):** `Το Συμβούλιο συναντάται με τη διοίκηση τουλάχιστον **ανά τρίμηνο**.`
- **Why wrong:** The law requires meetings **within the first ten days of every second month** — i.e. **bimonthly (every 2 months, ~6×/year)**, more frequent than quarterly. Stating "quarterly" **understates** the workers' right.
- **Replacement:** `Ο εργοδότης και το Συμβούλιο συσκέπτονται μέσα στο πρώτο δεκαήμερο **κάθε δεύτερου μήνα** (ανά δίμηνο).`
- **Legal basis:** **Ν.1767/1988 άρθρο 11 §1**; ΚΕΔ 425–441.
- **Source / verbatim quote:** *«Ο εργοδότης και το συμβούλιο εργαζομένων συσκέπτονται μέσα στο πρώτο 10ήμερο κάθε δεύτερου μήνα».* (Ν.1767/1988 art.11.)
- **Confidence:** High.

### WRONG-3 — dismissal needs "prior ΟΜΕΔ approval"
- **Verbatim (line 29):** `ο εργοδότης πρέπει να πάρει **προηγούμενη έγκριση του ΟΜΕΔ** για να τα απολύσει. Χωρίς αυτή, η απόλυση είναι άκυρη.`
- **Why wrong:** ΟΜΕΔ (mediation/arbitration for ΣΣΕ) has **no role** in dismissals. Works-council members enjoy the **same protection as trade-union officials** under **Ν.1264/1982 art.14 §§5 & 9** (via Ν.1767/1988 art.9): dismissal barred during the term **+ 1 year**, void unless a σπουδαίος λόγος. The **pre-approval committee was abolished by Ν.4808/2021** — there is now **no** prior approval body (neither ΟΜΕΔ nor committee); an unlawful dismissal is simply null and challenged in court.
- **Replacement:** `Τα μέλη του Συμβουλίου έχουν την **ίδια προστασία από απόλυση με τα συνδικαλιστικά στελέχη** (Ν.1264/1982 άρθρο 14): η απόλυση κατά τη θητεία και για 1 έτος μετά είναι **αυτοδικαίως άκυρη**, εκτός σπουδαίου λόγου. Δεν απαιτείται (ούτε υπάρχει πλέον) προηγούμενη έγκριση επιτροπής.`
- **Legal basis:** **Ν.1767/1988 άρθρο 9 §1** → **Ν.1264/1982 άρθρο 14 §§5,9** (am. Ν.4808/2021 art.88; committee abolished); ΚΕΔ 425–441 & 381.
- **Source / verbatim quote:** *«Τα μέλη των συμβουλίων εργαζομένων απολαμβάνουν την προστασία που παρέχεται στις διοικήσεις των συνδικαλιστικών οργανώσεων από τις διατάξεις των παρ. 5 και 9 του άρθρου 14 του ν. 1264/1982».* (Ν.1767/1988 art.9.)
- **Confidence:** High. (Also fix the `ΟΜΕΔ` entry in the file's YAML `tags:`.)

### IMPRECISE-1 — threshold "50 or more" omits the 20-employee route
- **Verbatim (line 13):** `Επιχείρηση με **50 ή περισσότερους εργαζόμενους**…`
- **Why imprecise:** A works council may also be formed in enterprises of **20–50 employees where no trade union exists**. Omitting this hides the right from smaller-firm workers.
- **Replacement:** `…με **50 ή περισσότερους** εργαζόμενους — ή **από 20**, αν δεν υπάρχει συνδικαλιστική οργάνωση στην επιχείρηση.`
- **Legal basis:** **Ν.1767/1988 άρθρο 1 §§1–2**.
- **Source / verbatim quote:** *«Οι εργαζόμενοι κάθε επιχείρησης, που απασχολεί τουλάχιστον πενήντα (50) άτομα … [ή] … 20 … αν δεν υπάρχει συνδικαλιστική οργάνωση».*
- **Confidence:** High.

### IMPRECISE-2 — "Ν.4808/2021 — Επικαιροποιημένο πλαίσιο"
- **Verbatim (line 47):** `Ν. 4808/2021 — Επικαιροποιημένο πλαίσιο εκπροσώπησης εργαζομένων`
- **Why imprecise:** Vague and slightly misleading — Ν.4808/2021 did not substantively overhaul works councils. The current recodified text is **ΚΕΔ (ΠΔ 62/2025) arts 425–441**. Replace/augment the citation accordingly.
- **Confidence:** High.

### Currency note
- Works councils → **ΚΕΔ arts 425–441** (KED-MAP #52). Cite Ν.1767/1988 + ΚΕΔ.

---

## FILE 7 — `symvasi/index.md`

### OK claims (confirmed)
- Contract concept; oral contract still binds — **OK** (ΑΚ 648 κ.επ.).
- Types (αορίστου / ορισμένου / μερική) — **OK**.
- Written-info contents list — **OK** (ΠΔ 156/1994 → superseded by Ν.4808/2021 arts 70–72 / Οδ. 2019/1152; now ΚΕΔ ΜΕΡΟΣ Γ΄).
- Αναγγελία πρόσληψης before starting work; undeclared → penalties — **OK** (ΕΡΓΑΝΗ; €10.500/worker, Ν.4554/2018).
- ΣΣΕ: minimum terms for sectors/occupations; individual contract cannot worsen — **OK**.
- Who a ΣΣΕ binds (members + extension) — **OK** in principle.
- How to find a ΣΣΕ (union, ΟΜΕΔ, ypergasias.gov.gr) — **OK**.

### OUTDATED-1 — probation "12 months"
- **Verbatim (line 37):** `η δοκιμαστική περίοδος ανέρχεται σε **12 μήνες**, εντός της οποίας μπορεί να λυθεί η σύμβαση χωρίς αποζημίωση.`
- **Why outdated:** Since **26.09.2023** the statutory **δοκιμαστική περίοδος is up to 6 months** (Ν.5053/2023 art.4). The corpus conflates it with the separate rule that dismissal in the **first 12 months** carries no notice/severance (Ν.5053/2023 art.19) — two distinct institutions.
- **Replacement:** `Η δοκιμαστική περίοδος για σύμβαση αορίστου είναι **έως 6 μήνες** (Ν.5053/2023). Χωριστά, η απόλυση μέσα στους **πρώτους 12 μήνες** υπηρεσίας γίνεται χωρίς προειδοποίηση/αποζημίωση.`
- **Legal basis:** **Ν.5053/2023 άρθρο 4** (→ ΚΕΔ art.2) + **άρθρο 19**; cross-ref `symvasi-contracts.md` / `apolysi-money.md`.
- **Source / verbatim quote:** *«…δοκιμαστική περίοδο χρονικού διαστήματος έως έξι (6) μηνών…».* https://www.taxheaven.gr/law/5053/2023
- **Confidence:** High.

### WRONG-1 (MAJOR) — "40% από το 2025 / Κοινωνική Συμφωνία του 2025"
- **Verbatim (lines 70–72):** `Από το 2025, η επέκταση απαιτεί η ΣΣΕ να καλύπτει εργοδότες που απασχολούν άνω του **40%** … (μειωμένο από 50% βάσει της **Κοινωνικής Συμφωνίας του 2025**).`
- **Why wrong:** No such "Κοινωνική Συμφωνία του 2025" reduced the threshold; the figure is **not 40%**. Extension requires coverage of **more than 50%**, under **Ν.1876/1990 art.11 as amended by Ν.4635/2019 art.56**.
- **Replacement:** `Η επέκταση προϋποθέτει ότι η ΣΣΕ δεσμεύει ήδη εργοδότες που απασχολούν **πάνω από το 50%** των εργαζομένων του κλάδου/επαγγέλματος (Ν.1876/1990 άρθρο 11, όπως ισχύει μετά τον Ν.4635/2019).`
- **Legal basis / source:** as WRONG-1 in `sse.md` (hli.gov.gr, >50%). https://www.hli.gov.gr/…/desmefsi-apo-s-s-e/
- **Confidence:** High.

### OUTDATED-2 — μετενέργεια "until a new ΣΣΕ"
- **Verbatim (line 76):** `Μετά τη λήξη μιας ΣΣΕ, οι ευνοϊκότεροι όροι εξακολουθούν να ισχύουν (**μετενέργεια**) μέχρι να συναφθεί νέα ΣΣΕ ή ατομική σύμβαση.`
- **Why outdated:** Reflects the **pre-2012** indefinite μετενέργεια. Post-**ΠΥΣ 6/2012**: 3-month full extension, then only basic wage + four allowances survive. (Same fix as `sse.md` OUTDATED-1.)
- **Replacement:** as `sse.md` OUTDATED-1.
- **Legal basis:** Ν.1876/1990 art.9 §§4–5 as am. ΠΥΣ 6/2012 art.2 §4.
- **Confidence:** High.

### IMPRECISE-1 — "ΟΜΕΔ … τηρεί αρχείο ΣΣΕ"
- **Verbatim (line 83):** `Ελέγξτε στον **ΟΜΕΔ** (omed.gr) που τηρεί αρχείο ΣΣΕ`
- **Why imprecise:** The authoritative registry of deposited ΣΣΕ is kept by the **Υπουργείο Εργασίας** (κατάθεση/πρωτοκόλληση); ΟΜΕΔ archives the agreements it mediated/arbitrated. Not wrong to check ΟΜΕΔ, but frame the ministry as the primary registry. Low priority.
- **Confidence:** Medium.

### Currency note
- Probation → ΚΕΔ art.2; written-info/transparency → ΚΕΔ ΜΕΡΟΣ Γ΄ (arts 70+); ΣΣΕ → ΚΕΔ 394–414. Also: "ΣΕΠΕ / Εργάνη" — hiring is declared in **ΠΣ ΕΡΓΑΝΗ ΙΙ**, and inspection body is **Επιθεώρηση Εργασίας**.

---

## SUMMARY OF TOP CHANGES (priority order)

1. **`sse.md` L26/L71 + `index.md` L70-72 — kill the "40%" extension myth.** Threshold is **>50%**; governing law **Ν.1876/1990 art.11 as amended by Ν.4635/2019 art.56** (not Ν.4808/2021, not a "2025 Social Agreement"). [High]
2. **`sse.md` L72 (task-flagged) — fix the Ν.1767/1988 entry.** It is **Συμβούλια Εργαζομένων**, not "ΟΜΕΔ"; ΟΜΕΔ = Ν.1876/1990; repoint the ΠΔ-240/2006 URL. [High]
3. **`apergia.md` L10/L155 (task-flagged) — "συνταξιακό" → "συνταγματικό."** Also L24/L25/L113: public-utility strike notice is **4 full days**, not 48h; and L37: **the union, not the employer, designates προσωπικό ασφαλείας**. [High]
4. **`symboulia-ergazomenon.md` — three errors:** term **2 yrs not 3** (L17); meetings **bimonthly not quarterly** (L25); dismissal needs **no ΟΜΕΔ approval** — protection is Ν.1264/1982 art.14 (L29). [High]
5. **`syndikalismos.md` L19/L141 — union founding minimum is 20, not 10** ("19 more colleagues"); and **`egsee.md` L24 — blue-collar get τριετίες (5%×6), not πενταετίες**; **`index.md` L37 — probation 6 months, not 12.** [High]

## GAPS / HUMAN-REVIEW
- **Ν.4808/2021 strike-vote απαρτία 50%+1** for primary unions — missing from both `apergia.md` and `syndikalismos.md` (a real restriction; militant voice should expose). [add]
- **Pre-strike ΟΜΕΔ public-dialogue request** (Ν.4808/2021) — missing from `apergia.md`. [add]
- **`apergia.md` "πεχτρέβα"** — non-standard term; likely means λευκή απεργία (work-to-rule). → HUMAN-REVIEW.
- **`egsee.md` "Επίδομα τέκνων"** — could not confirm as a current ΕΓΣΣΕ benefit. → HUMAN-REVIEW (no edit).
- **Whole batch:** cite the **ΚΕΔ (ΠΔ 62/2025), Βιβλίο Β΄** (unions 368–386, ΣΣΕ/ΟΜΕΔ 394–414, strike 415–421, works councils 425–441, info/consultation 442–451). Content-neutral currency upgrade.
- **Systemic:** "ΣΕΠΕ" → "Επιθεώρηση Εργασίας" (Ν.4808/2021); `sse.md` L52 "ergasianews.gr" → ypergasias.gov.gr.

## SOURCES (fresh fetches, 2026-07-13)
- Επιθεώρηση Εργασίας (hli.gov.gr) — Δέσμευση από ΣΣΕ (50% extension): https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/loipa-themata/syllogikes-symvaseis-ergasias-sse/desmefsi-apo-s-s-e/
- Επιθεώρηση Εργασίας — Κήρυξη Απεργίας (24h/4-day notice, 1/3 min service, safety staff, ΟΜΕΔ prerequisite): https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/prostasia/syndikalistes/kiryxi-apergias/
- Επιθεώρηση Εργασίας — Προστασία Συνδικαλιστικών Στελεχών (ΔΣ protection 5/7/9; 21 founders; term+1yr): https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/prostasia/syndikalistes/prostasia-ton-syndikalistikon-stelechon/
- lawspot.gr — Ν.1264/1982 άρθρο 19 (24h notice; public-utility list): https://www.lawspot.gr/nomothesia/n-1264-1982/arthro-19-nomos-1264-1982-dikaioma-apergias/
- ypergasias.gov.gr — Συνδικαλιστικές Οργανώσεις (20-member minimum; union-leave days): https://ypergasias.gov.gr/ergasiakes-scheseis/syllogikes-ergasiakes-sxeseis/sychnes-erotiseis/syndikalistikes-organoseis-kai-syllogiki-organosi/
- syllogos.gr — Ν.1767/1988 full text (50/20 threshold; 2-yr term; bimonthly meetings; art.9 protection): https://www.syllogos.gr/nomothesia/3024-νόμος-1767-88-συμβούλια-εργαζομένων
- ΚΕΠΕΑ/ΓΣΕΕ & pim.gr — μετενέργεια (3-month + 4 allowances, ΠΥΣ 6/2012): https://www.kepea.gr/metenergeia-s-s-e ; https://www.pim.gr/enimerosi/ergasiaka/nomologia/i-metenergeia-ton-sse-kai-da-meta-tin-pys-6-2012-areiou-pagou-395-2021
- ΚΕΠΕΑ/ΓΣΕΕ — τριετίες εργατοτεχνιτών (6×5%) + επίδομα γάμου 10% (ΓΣΕΒΕΕ/ΕΣΕΕ/ΣΕΤΕ): https://www.kepea.gr/aarticle.php?id=2801 ; https://www.kepea.gr/epidoma-gamou
- taxheaven.gr — Ν.4172/2013 art.103 (state-set minimum wage): https://www.taxheaven.gr/law/4172/2013/arthro/103 ; Ν.5053/2023 (probation 6 mo): https://www.taxheaven.gr/law/5053/2023
- omed.gr — ΟΜΕΔ established by Ν.1876/1990: https://www.omed.gr/

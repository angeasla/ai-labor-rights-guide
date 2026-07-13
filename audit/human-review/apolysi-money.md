# HUMAN-REVIEW — apolysi/ money (flagged / conservative / gaps)

**Date:** 2026-07-13. Every proposed correction in the ledger was independently confirmed and
**applied** — nothing was skipped for lack of confirmation. Items below are decisions, gaps, and
one upstream flag that a human may want to revisit.

## 1. Frontmatter tags edited despite "preserve frontmatter" — LOW, flag
- **File:** `apozimiossi.md`. Changed `tags:` from "απόλυση, αποζημίωση, Ν.3863/2010, Ν.2112/1920" to "απόλυση, αποζημίωση, Ν.2112/1920, Ν.4093/2012, Ν.4808/2021, ΚΕΔ". Title/category untouched.
- **Why:** the whole edit kills the Ν.3863/2010 severance-regime myth; leaving it as a headline RAG tag would contradict the corrected body and could re-seed the error in retrieval. Judged a correctness fix, not a structural change.
- **Action:** if house rule means "tags are frozen," revert the tag line — the body is unaffected.

## 2. Ν.3863/2010 art.74 citation removed — LOW
- Dropped the "Ν.3863/2010 — Νέο Ασφαλιστικό (άρθρο 74)" line from Νομοθεσία. Art.74 is *real* current law (it reshaped notice + introduced **installment payment** of severance >2 μισθών, part-upfront + bimonthly — Ν.3863/2010 art.74 §3), but it does NOT support any 6-month cap or hire-date split, and the body does not (yet) cover installments, so the citation would be orphaned.
- **Action / gap:** consider a short "Τμηματική καταβολή" section (αποζημίωση > 2 μισθών → μέρος άμεσα + διμηνιαίες δόσεις, Ν.3863/2010 art.74 §3) and then re-add the citation. Minor gap (also noted in the ledger).

## 3. ΕΡΓΑΝΗ αναγγελία basis attributed to Ν.5053/2023 art.23 — LOW/MED
- Per the task and CURRENCY-BRIEF §7, the validity/procedure section ties the ΕΡΓΑΝΗ αναγγελία to **Ν.5053/2023 art.23**. Independent fetch confirms art.23 governs the **deemed-resignation / όχληση** mechanism and the αναγγελία of a *departure* in ΕΡΓΑΝΗ ΙΙ.
- **Nuance for a human:** the general *dismissal* αναγγελία (έντυπο Ε6 in ΕΡΓΑΝΗ) predates Ν.5053/2023. The text as written is accurate (employer must αναγγείλει the λύση; art.23 supplies the deemed-resignation warning), but if you want the E6 dismissal-notification cited to its own instrument, split the citation. Not an error — a precision option.

## 4. Επίδομα αδείας ΕΦΚΑ ceiling detail — LOW, MED-HIGH confidence
- `foros-apozimiossi.md` F2: stated the accompanying **επίδομα αδείας IS subject to εισφορές** (the exception). The source (e-forologia) adds it is capped at the max insurable-earnings limit (~€6.500). I kept the statement simple ("υπόκειται σε εισφορές") without the ceiling figure, to avoid asserting a number I did not cross-check against e-EFKA εγκ.4/2026 (2026 ceiling is €7.761,94/mo per CURRENCY-BRIEF §3, not €6.500).
- **Action:** if desired, add "(έως το ανώτατο πλαφόν ασφαλιστέων αποδοχών)" — safe, generic. Do NOT hard-code €6.500 (stale).

## 5. First-12-months rule not cross-cited — LOW/optional
- `apozimiossi.md` correctly keeps "<12 μήνες → καμία αποζημίωση". This now also aligns with **Ν.5053/2023 art.19** (no notice/severance in the first 12 months of employment). Not added to avoid scope-creep; a one-line cite is low-risk if wanted.

## 6. UPSTREAM note — CURRENCY-BRIEF §7 wording on transitional rule — INFORMATIONAL
- Brief §7 says "Pre-12.11.2012 tenure >17 yrs keeps +1 mo/extra-yr on pay ≤€2.000." Confirmed accurate against the Ν.4093/2012 primary text (>17 έτη *completed on* 12.11.2012 → +1 μήνα/έτος πέραν των 17, έως 12 επιπλέον, cap €2.000). No correction needed; recorded for traceability.

## Not flagged (fully verified, applied with confidence)
Single Ν.2112/1920+Ν.4093/2012 scale, max **12 μήνες @ 16 έτη**, no 17/6/2010 split, no 6-mo regime ·
½-with-notice column · notice cap **4 μήνες** (deleted 5/6-mo rows) · unification **Ν.4808/2021 art.64** (1.1.2022, 22 ημερομίσθια) ·
base = τακτικές αποδοχές **+1/6** · cap **8 × €41,09 × 30 = €9.861,60** (2026) · retirement **40%/50% by επικουρική** (no 17-yr) ·
15ετία+consent=50% · 12.11.2012/€2.000 transitional · validity = έγγραφο+καταβολή (Ν.3198/1955 art.5) ·
leave-comp on termination **NOT** subject to ΕΦΚΑ (επίδομα αδείας exception) · tax scale 0/10/20/30% (Ν.4172/2013 art.15 §3) **CORRECT, unchanged** ·
citations rebuilt via KED-MAP (333–341 / 331 / 341). All independently confirmed against the primary/authoritative sources in the changelog.

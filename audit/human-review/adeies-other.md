# HUMAN-REVIEW — adeies/ other (skipped / conservative / flagged / gaps)

**Date:** 2026-07-13. Items NOT applied, applied differently than proposed, or needing a human decision.

## 1. κατάτμηση: ledger's proposed "12/10 εργάσιμες" is WRONG — applied PRIMARY-SOURCE "6/5" instead — HIGH / upstream ledger bug
- **File:** `etisia-adia.md` (Κατάτμηση section).
- **Ledger/task proposed:** replace "12 ημερολογιακές" with "**12 εργάσιμες (6ήμερο) / 10 (5ήμερο)**".
- **What I found:** the designated primary anchor (hli.gov.gr «Τμηματική Χορήγηση») states verbatim: «τουλάχιστον **έξι (6) εργάσιμες ημέρες επί εξαήμερης**… και **πέντε (5) εργάσιμες ημέρες επί πενθήμερης**… (ανηλίκων **δώδεκα (12)**)». Corroborated by insider.gr ("Τουλάχιστον 5 ημέρες η ελάχιστη διάρκεια") and ypergasias.gov.gr.
- **Conclusion:** the ledger's "12/10" conflates the **minors'** figure (12) and invents "10". I applied the verified **6 (6ήμερο) / 5 (5ήμερο), 12 for minors**. **Action:** correct the ledger `adeies-other.md` FILE 1 #15 upstream (its proposed replacement is factually wrong).

## 2. Election-leave distance/day tiers — numbers NOT changed, caveat added — MED
- **File:** `eidikes-adeies.md`.
- Election leave is fixed by a **ΚΥΑ issued before each election**; tiers vary per contest. The corpus's fixed table ("≤100→1, 100–200→2, >200→3") is doubtful (the recurring pattern the ledger cites is 100–200→1 / 201–400→2 / 401+→3, and <100 km often grants none), but I could not confirm the CURRENT (mid-2026) ΚΥΑ from a primary source this session. I left the numbers and added a "καθορίζεται με ΚΥΑ / ενδεικτικός πίνακας" caveat. **Action:** when a current election ΚΥΑ exists, replace the table with its exact tiers.

## 3. astheneia.md — unverified figures left in place / removed — MED
- **Εργατικό ατύχημα "100% ημερομισθίου"** (comparison table): NOT changed — the accident benefit is computed on the ασφαλιστική-κλάση formula (paid from day 1, no waiting days, no insurance-days precondition); the flat "100%" is unconfirmed. Flag; leave until a primary e-EFKA figure is in hand.
- **"Σύμβαση αναστέλλεται για έως 12 μήνες"**: the unverified "12 μήνες" suspension figure was **removed** and replaced with the confirmed protection (βραχεία ασθένεια ≠ λόγος απόλυσης, ΚΕΔ 349). The exact **tenure-based protected-absence limits** (roughly 1 μήνα ≤4 έτη / 3 μ. 4–10 / 4 μ. 10–15 / 6 μ. >15 — per ledger) were NOT asserted; confirm the tiers from ΦΕΚ/case law before adding.

## 4. etisia-adia.md — unverified items left untouched — MED/LOW
- **Οικιακοί μισθωτοί "26 εργάσιμες ημέρες/έτος (Ν.4488/2017)"**: could not confirm the specific day figure against a primary source; left as-is (do not assert without a source).
- **ΣΕΠΕ πρόστιμο "350–500 €/εργαζόμενο" + "Ν.4488/2017 άρθρο 36"**: fine amounts are set by ΥΑ and vary by violation category; the range and the article are unconfirmed. Left as-is; flag.

## 5. eidikes-adeies.md — night-work exemption NOT edited — MED
- The pregnancy/breastfeeding **night-work exemption** currently reads as automatic ("από έναρξη εγκυμοσύνης έως 1 έτος μετά τοκετό"). Per ledger it is conditioned on a **medical certificate** that night work threatens health (**ΠΔ 176/1997**). I did NOT fetch ΠΔ 176/1997 this session, so under the "no edit without independent confirmation" rule I left it. **Action:** verify ΠΔ 176/1997 and add the certificate condition + basis.

## 6. eidikes-adeies.md — conscript re-employment "εντός 1 μήνα" — LOW
- Directionally right (suspension, not termination) but the specific 1-month figure/basis (ΝΔ 1044/1971 / Ν.3421/2005) was not confirmed. Left as-is; flag.

## 7. Carer's leave (art.29) unpaid status — corroborated, not re-fetched — LOW
- The fetched art.29 excerpt confirmed name/5 days/medical certificate/6-month tenure but did **not** show the pay clause. The corpus's "άνευ αποδοχών" was kept (it is corroborated by CURRENCY-BRIEF §6 and the ledger). Low risk; a human may confirm the pay sub-paragraph.

## 8. "ΣΕΠΕ" → "Επιθεώρηση Εργασίας" naming — NOT done batch-wide — LOW/procedural
- "ΣΕΠΕ" / "sepe.gr" (renamed to the independent **Επιθεώρηση Εργασίας**, portal hli.gov.gr, by Ν.4808/2021) still appears in `etisia-adia.md`, `astheneia.md`, `adia-gamos.md` (and `apozimiossi-adias.md`). I did NOT do a scattershot naming sweep — it is cosmetic, not a worker-facing legal error, and `apozimiossi-adias.md` is under a "do not change" instruction. The **1555** service line stays valid. **Action:** optional batch cosmetic pass (skip apozimiossi-adias.md).

## 9. CONFIRMED GAPS — deferred to the new-articles phase (NOT written here, per instruction)
All have a confirmed basis; `eidikes-adeies.md` currently omits them:
- **Άδεια ανωτέρας βίας** — έως 2×/έτος, έως 1 εργάσιμη ημέρα, **με αποδοχές** (Ν.4808/2021 άρθρο 30 / ΚΕΔ 233).
- **Άδεια πένθους/θανάτου** — **2 ημέρες με αποδοχές** (ΕΓΣΣΕ 2002-03 άρθρο 9); plus the **20-ήμερη** paid leave for a parent whose child died (Ν.5018/2023 άρθρο 93 / ΚΕΔ 246).
- **Άδεια γυναικολογικού ελέγχου** — **1 ημέρα/έτος, με αποδοχές, ιδιωτικός τομέας** (Ν.5043/2023 άρθρο 96 / ΚΕΔ 242) — 1×/yr, NOT twice-yearly.
- (Also relevant: **άδεια άνευ αποδοχών** Ν.4808/2021 άρθρο 62 / ΚΕΔ 255 — corpus thin.)

## 10. adia-gamos.md scope note — LOW
- The school-monitoring **≤4 paid** value was confirmed OK and left unchanged; only the age-scope, the citation (→art.38/ΚΕΔ 240), and the "άδεια φροντίδας" conflation were fixed. Marriage 6/5 untouched.

## Not flagged (fully verified this session, applied with confidence)
Annual-leave ladder 22→25 (10/12 έτη) & 26 (25 έτη) 5ήμερο / 26→30 & 31 6ήμερο (hli.gov.gr) · κατάτμηση 6/5 εργάσιμες, 12 ανήλικοι (hli.gov.gr) · carry-over to α΄ τρίμηνο (Ν.4808 art.61) · sickness 120 ημ. prior year/15μηνο, 50% τεκμαρτού +10%/μέλος, 182/360/720 ημ. (e-EFKA) · employer full-wage top-up 15ημ./1μήνα + συμψηφισμός ΑΚ 657–659 · breastfeeding fully paid 1h or 2+1 (art.37) · disabled/serious-ill child 10 paid (art.43) + de-conflated 6-day employee leave · child-sick 6/8/14 unpaid (art.42) · carer renamed «φροντιστή» + certificate required + 6-mo tenure (art.29) · exam leave 30/10 unpaid (hli.gov.gr) · school-monitoring ≤18 + χωρίς περικοπή (art.38). All independently confirmed against the primary/authoritative sources listed in the changelog.

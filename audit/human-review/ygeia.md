# HUMAN-REVIEW — ygeia/ (flagged / conservatively edited / out-of-scope)

**Date:** 2026-07-13. Items needing a human decision. No directed correction was outright skipped —
all were independently confirmed and applied (see changelog). The notes below are (a) edits made
conservatively because the *original* claim was unverifiable, and (b) minor consistency gaps left
untouched to respect scope / "preserve frontmatter".

## 1. "φόρμα Ε1" work-accident form — RELABELLED, original label unverifiable — MED
- **File:** `index.md` Step 4 (was lines 43-45).
- **Action taken:** replaced the unverifiable "φόρμα Ε1 / (Ε1)" with the **verified** process name
  «**Δήλωση/Αναγγελία Εργατικού Ατυχήματος**, ηλεκτρονικά μέσω Επιθεώρησης Εργασίας / e-ΕΦΚΑ».
- **Why:** no e-ΕΦΚΑ work-accident form named "Ε1" was found (Ε1 = the income-tax return). The gov.gr
  process is titled «Αναγγελία Εργατικού Ατυχήματος». The original text **asserted** a form that
  cannot be verified; it was removed rather than kept.
- **Action for human:** if a precise application/form ID exists in the current e-ΕΦΚΑ/Επιθεώρηση
  e-services, add it; do NOT reinstate "Ε1".

## 2. Ιατρός εργασίας "μία φορά τον μήνα" — SOFTENED, not asserted — MED
- **File:** `index.md` Ιατρός Εργασίας section (was line 75).
- **Action taken:** "τουλάχιστον μία φορά τον μήνα" → "ανά τακτά διαστήματα, ανάλογα με τις
  προβλεπόμενες ελάχιστες ώρες απασχόλησης".
- **Why:** the statutory duty (Ν.3850/2010 art.21) is a **minimum number of hours** (scaling with
  headcount × risk category), not a hard monthly-visit rule; for small/low-risk firms the hours can
  translate to fewer than monthly visits. The specific "monthly" figure is unverifiable, so the false
  precision was removed. No new number asserted.
- **Action for human:** if a monthly cadence is desired as guidance, mark it explicitly as indicative.

## 3. kapnisma.md frontmatter tag still contains "ΣΕΠΕ" — LEFT (preserve frontmatter) — LOW
- **File:** `kapnisma.md` line 4 — `tags: [κάπνισμα, αντικαπνιστικός νόμος, υγεία, ΣΕΠΕ, εργασιακό περιβάλλον]`.
- **Action taken:** **NOT changed.** The ΣΕΠΕ→Επιθεώρηση Εργασίας correction was applied throughout the
  body, but the frontmatter was left intact per the "preserve frontmatter" instruction.
- **Action for human:** for full consistency, replace the `ΣΕΠΕ` tag with `Επιθεώρηση Εργασίας`
  (ΣΕΠΕ was abolished by Ν.4808/2021). Trivial; affects search tags only.

## 4. Heat-stress WBGT / temperature thresholds — DELIBERATELY OMITTED — LOW
- **File:** `index.md` heat-stress block.
- **What was added (verified):** the binding 12:00-17:00 stoppage, the €2.000/employee penalty, and the
  framework circular 34666/03.06.2024.
- **What was NOT added:** specific trigger criteria (e.g. WBGT > 32,2 or ≥40°C). Only the 2024
  circular's 40°C trigger appeared in the fetched source; criteria vary by circular, region and day, so
  a general "σε περιοχές και ημέρες υψηλού κινδύνου" phrasing was used to avoid asserting a fixed
  threshold.
- **Action for human:** if a precise index is wanted, cite the specific current-year καύσωνας circular.

## 5. "24 ώρες ημερολογιακές" characterization — DROPPED — LOW
- **File:** `index.md` Step 3.
- **Action taken:** the statute (Ν.3850/2010 art.43) says only «εντός 24 ωρών»; the corpus's
  "ημερολογιακές — δεν υπολογίζεται σε εργάσιμες" gloss was not literal and was removed. Defensible
  reading, but not asserted as statutory text.

## 6. "ΑΜΠ" vs "ΜΑΠ" acronym — OUT OF SCOPE, left unchanged — LOW
- **File:** `index.md` (line ~16 and reporting table) uses "ΑΜΠ" for Μέσα Ατομικής Προστασίας.
- **Note:** the standard acronym is **ΜΑΠ** (Μέσα Ατομικής Προστασίας; ΠΔ 396/1994). Not in the directed
  correction list and not a legal-currency error, so left as-is to limit scope.
- **Action for human:** optional global "ΑΜΠ"→"ΜΑΠ" consistency fix.

## 7. Enhancement not applied — ΑΚ 932 (ηθική βλάβη/ψυχική οδύνη) — LOW
- **File:** `index.md` work-accident civil-liability list (ΑΚ 914, Ν.551/1915, ΑΚ 300).
- **Note:** a real additional worker/family claim (χρηματική ικανοποίηση ηθικής βλάβης / ψυχικής
  οδύνης, ΑΚ 932) is omitted by the corpus. Not part of the directed corrections; left for a human to
  add if desired. Fact is correct but was outside this pass's scope.

## Not flagged (fully verified, applied with confidence)
Right to refuse = **art.45** not art.26 (×2) · **ΕΥΑΕ / Επιτροπή Υγείας και Ασφάλειας των Εργαζομένων**
(name+acronym) · member protection via **art.14/15 Ν.1264/1982** (art.7 Ν.3850/2010), **not ΟΜΕΔ**,
term+1yr kept · **ΙΕ** mandatory 50+ or special-hazard any size, fictional 6-49 band removed · **ΤΑ**
for all firms ≥1 worker (no "6" floor), employer-as-ΤΑ cat Β'/Γ' <50 (art.12) · accident report of
**all** accidents in 24h to **Επιθεώρηση Εργασίας + e-ΕΦΚΑ** (art.43) · accident benefit **50% τεκμ.
ημερομ. +10%/μέλος** (not 100%) · heat-stress binding **12:00-17:00** stoppage + **€2.000/employee** +
εγκ.**34666/2024** · **ΣΕΠΕ → Επιθεώρηση Εργασίας**, sepe.gov.gr → **hli.gov.gr**, 1555 kept ·
smoking fines **€100/€200/€1.500/€3.000** (Ν.4633/2019), business €500-10.000 kept · hotline **1565 →
1142** · smoking law chain incl. **Ν.4633/2019** + **Ν.4419/2016** (e-cig). All independently confirmed
against the primary/authoritative sources listed in the changelog.

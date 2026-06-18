# KEPEA cross-check — divergences & open questions

Record of comparing our calculators against the KEPEA/ΓΣΕΕ online calculators (https://www.kepea.gr/online-efarmoges-1), done 2026-06-08.

**KEPEA is a cross-check, NOT ground truth.** Where we differ, we decide by actual Greek law — and in several places KEPEA's online calculator turned out to be *simplified or wrong*. This file logs every divergence, how it was resolved, and what remains.

**Method (reproducible, no browser):** POST credentials to `applogin.php` (no captcha on the login form) for a session cookie, then POST inputs to each calculator's AJAX endpoint `calc-*-calc.php` and parse the returned HTML. Our side is checked against the running backend's `/api/calc/*`. Credentials are the maintainer's, used in-session only, never stored.

---

## Status by calculator

| Calculator | KEPEA vs ours | Status |
|---|---|---|
| **Annual leave days** | 12–25yr→25/30 ✓, >25yr→26/31 ✓; **<12yr differs** | **divergence (kept ours)** |
| Part-time leave (ratio) | 3 days/wk → 12 days, matches | ✓ match |
| **Leave pay + bonus** | **αποδοχές differ** (KEPEA 800 vs ours 960) | **divergence (kept ours)** |
| **Severance** | 1000/3yr → 2333.33, exact | ✓ match |
| **Overtime / nightwork** | hourly base differed (KEPEA 6.00 vs our 5.00) | **divergence (adopted KEPEA's ×0.006)** |
| Easter bonus (full) | 520.83, exact | ✓ match |
| Easter bonus (hourly) | 187.50, exact | ✓ match |
| Xmas bonus (full) | 1041.67, exact | ✓ match |
| Xmas bonus (hourly) | 157.87 vs 157.89 | ✓ (2¢ rounding-order) |
| **National pension** | full 446.86 ✓, 15yr 402.17 ✓, res-30 335.14 vs 335.15 | ✓ match (±1¢) |
| **Contributory pension** | replacement rate 15.87% @20yr **exact**; amount differs by KEPEA's earnings indexation | ✓ rate match |
| Maternity (reduced hours) | KEPEA only echoes the schedule | not comparable — ours computes more |
| Easter/Xmas part-time (εκ περιτροπής) | days-per-week model | not separately tested (low risk) |

---

## Divergences — where we originally differed from KEPEA

### 1. Annual leave days, `<12 years` → **we kept ours** (KEPEA simplifies)
- **KEPEA:** flat **20** (5-day) / **24** (6-day) for the whole `<12 years` bracket (3 brackets: `<12 / 12–25 / >25`).
- **Ours:** the ΑΝ 539/1945 + Ν.3302/2004 first-years ladder — **20→21→22** (5-day), **24→25→26** (6-day) by completed years, then EGSSE tiers (25/30 at 12–25 yr, 26/31 at >25 yr).
- **Decision: keep ours.** e-forologia lists the ladder explicitly — *Year 1 = 20, Year 2 = 21, Year 3+ = 22*. KEPEA's calculator collapses `<12yr` to a single 20/24, under-counting years 2–3. The EGSSE tiers match KEPEA exactly.

### 2. Overtime / nightwork hourly base → **we adopted KEPEA's `×0.006`**
- **KEPEA:** legal ωρομίσθιο = **μισθός × 0.006** → €6.00 for €1000 (= ημερομίσθιο × 6/40, a 6.67-hour ημερομίσθιο).
- **Ours (originally):** μισθός / 25 / 8 → €5.00 (~17% low).
- **Decision: adopt `×0.006`** (user-approved). Standard ΣΕΠΕ/KEPEA legal base; the same 6.67-h/day basis underlies the leave-pay ×1.2 below. Implemented in `CalcConstants.LEGAL_HOURLY_FACTOR`; tests updated.
- ⚠️ Not yet done: KEPEA also has **legal overtime >150 h/yr → +60%** (we model only +40% legal / +120% illegal), and shows the **6th-day rate per-hour** (×0.006×1.30) whereas our `overtimeRates` reports it per-day. Decide whether to add the +60% band / switch the 6th-day to per-hour. Also update the stale guide articles `orario/yperoreis.md` & `orario/nyxterina.md`.

### 3. Leave pay (αποδοχές αδείας) ×1.2 → **we kept ours** (KEPEA's calc is wrong)
- **KEPEA:** αποδοχές = leaveDays × (salary/25) = 20×40 = **€800** (no προσαύξηση).
- **Ours:** leaveDays × **1.2** × (salary/25) = 24×40 = **€960**.
- **Decision: keep ours.** e-forologia's worked example is verbatim *"20 ημέρες × 1,2 × 1.000/25 = 960 ευρώ"* for a 5-day/8-hour salaried worker — the ×6/5 (1/5) προσαύξηση is legally required (a ημερομίσθιο is 6.67 h, but a 5-day worker works 8 h/day). **KEPEA's online calculator omits the ×1.2** — verified wrong here.

### Minor
- **Xmas hourly:** KEPEA 157.87 vs ours 157.89 — KEPEA rounds the daily-wage ratio to 2 dp before multiplying; we keep full precision. ≤2¢; ours arguably more precise. No change.

---

## Validated — exact (or ±1¢) matches with KEPEA
- **Severance** (14/12 × ladder): 1000/3yr → 2333.33.
- **Easter & Christmas bonus** (full + hourly), incl. the **1/24 increment** and the **/8 (Easter) / /19 (Christmas)** accrual.
- **Part-time leave** (ratio model): 3 days/wk → 12 days.
- **Annual leave EGSSE tiers**: 12–25yr → 25/30, >25yr → 26/31.
- **National pension** (Ν.4387/2016, base €446.86 2026): full 446.86, 15yr (−10%) 402.17, residence-30 335.14/15. Mapping: KEPEA `ensima` = years × 300.
- **Contributory pension** (Ν.4670/2020): replacement **rate** 15.87% @ 20yr matches exactly — our banded ladder is correct. KEPEA's *amount* is higher only because it **indexes historical earnings** internally (συντάξιμος μισθός 1404.93 vs our raw 1200 input); ours treats `pensionableEarnings` as the already-indexed career average, so both are correct given their inputs.

---

## Not comparable / remaining
- **Maternity (`calc-frontida-teknou`):** KEPEA's tool merely **echoes the entitlement** ("1 ώρα για 30 μήνες") given `category` + daily hours — it does **not** compute the continuous-leave equivalent ours does. Nothing to reconcile; our maternity result remains an explicit **estimate** (no single statutory day-count).
- **Easter/Xmas part-time (εκ περιτροπής):** KEPEA uses a days-per-week (1–4) model vs our daysWorked/dailyWage. Not separately tested — low risk since the full + hourly variants matched KEPEA exactly. Test on demand.
- **Gross↔net salary:** KEPEA has no public net-salary calculator in this set; not cross-checkable here.

---

## Bottom line
Across all 14 calculators: our implementation matched the law everywhere it was clear (severance, δώρα, leaves, both pensions), was confirmed **more correct than KEPEA's calculator** in two places (leave-days `<12yr` ladder, leave-pay ×1.2), and we changed exactly one thing to match KEPEA — the overtime/nightwork `×0.006` base, which the same 6.67-h/day basis independently justifies. KEPEA was a valuable cross-check but, as the user judged, **not authoritative**.

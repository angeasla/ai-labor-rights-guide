# Calculator specifications (verified)

Verified Greek labor-law spec for the 16 calculators ported into this backend. This is the **executable spec** that the JUnit tests in `src/test/java/.../calc/` encode. Where the Angular dialog, the Node MCP server, or the original prototype disagreed, the **decision + citation** is recorded here.

> **Authoritative calibration (pending):** KEPEA/GSEE publishes official online calculators at https://www.kepea.gr/online-efarmoges-1 (e.g. vacation days: https://www.kepea.gr/appregister-ver.php). These require login (credentials to be supplied by the maintainer). After the initial port, decode each KEPEA calculator's logic and reconcile/lock our tests against it — KEPEA is the union confederation's reference implementation and the final arbiter. Track via the dedicated task.

Verification date: 2026-06-08. Constants reflect law in force for 2026. **Centralize all constants in `CalcConstants` so yearly updates are one-file changes.**

Rounding convention (all calculators): keep full precision internally; round **only final monetary outputs** to 2 decimals `HALF_UP`. Day counts round half-up to whole days.

---

## Cross-cutting: hourly wage from monthly salary

**hourly = monthlySalary × 0.006** — the legal ωρομίσθιο per ΣΕΠΕ/KEPEA (= ημερομίσθιο × 6/40). For €1000 → €6.00. If an explicit hourly wage is supplied, use it as-is.
*(Updated 2026-06-08 from `/25/8` = €5.00 after the KEPEA cross-check returned €6.00; `×0.006` is the standard Greek legal base for overtime/night pay. The Angular `dailyWage × (6/hours)` form remains rejected.)*

---

## 1. Gross ↔ Net salary  (Ν.4172/2013, 2026 reform Ν.5246/2025)

Constants (2026):
- EFKA employee **0.1337**, employer **0.2229** (employer informational; ±~0.5% sector variance).
- EFKA monthly ceiling **€7,761.94** → employee EFKA = `min(gross, 7761.94) × 0.1337`.
- Brackets (annual): **9% / 20% / 26% / 34% / 39% / 44%** at 10k / 20k / 30k / 40k / 60k / ∞. *(Both candidates used the stale 2025 9/22/28/36/44 — corrected.)*
- Credit base by children: 0→**777**, 1→900, 2→1120, 3→1340, 4→1580, 5→1780, >5→1780+220·(n−5).
- Credit reduction: **€20 per €1000 of taxable income above €12,000** (i.e. `(taxable−12000)/1000×20`); **0 if children ≥ 5**. *(Both candidates used 0.005 on gross — corrected to 0.02 on taxable.)*
- Disability +€200: **uncertain for 2026** — optional, default OFF.

Formula (gross→net): `mult = months(12|14)`; `monthlyEfka = min(gross,7761.94)*0.1337`; `annualGross = gross*mult`; `annualEfka = monthlyEfka*mult`; `taxable = max(0, annualGross-annualEfka)`; `bracketTax = progressive(taxable)`; `reduction = children>=5?0:max(0,(taxable-12000)/1000*20)`; `credit = max(0, base(children)-reduction) + (disability?200:0)`; `annualTax = max(0, bracketTax-credit)`; `net = gross - monthlyEfka - annualTax/mult`.
net→gross: bisection on `[target, target/(1-0.1337-0.44)]` until `|net-target|<0.005`.

**Flag — youth brackets not modeled:** 2026 law gives age<26 a 0% band to €20k and 26–30 a reduced rate. We assume **age ≥ 30**. Add an optional `age` later if needed.

Test vectors (age≥30, disability off, 2026 law):
| gross | children | months | → net / efka / tax |
|---|---|---|---|
| 920 | 0 | 14 | 780.86 / 122.90 / 16.24 |
| 1500 | 0 | 14 | 1164.79 / 200.55 / 134.66 |
| 2500 | 2 | 14 | 1818.94 / 334.25 / 346.81 |
| 5000 | 0 | 12 | 3200.55 / 668.50 / 1130.95 |
| net→gross target=1000, 0, 14 | assert net(gross)=1000 ±0.01 |

---

## 2. Overtime  (Ν.4808/2021 + Ν.5053/2023)

`hourly = resolveHourly()` (= salary × 0.006). `type ∈ {OVERWORK +0.20, LEGAL +0.40 (≤150h/yr), LEGAL_OVER_150 +0.60 (>150h/yr), ILLEGAL +1.20}`. Orthogonal stackable flags: `sunday +0.75`, `night +0.25`. `total = hourly*hours*(1 + typeRate + sunday?0.75 + night?0.25)`.
The `overtimeRates` table returns all rates **per-hour** off the ×0.006 base, incl. 6th-day +30% (5-day) / +40% (continuous) — matching KEPEA's table (€1000 → 6.00 / overwork 7.20 / legal 8.40 / >150h 9.60 / illegal 13.20 / night 7.50 / 6th-day 7.80 / 6th-day-continuous 8.40).
*(Sunday and night are separate axes — a Sunday-night illegal-OT hour stacks all three.)*

| input | hourly | mult | total |
|---|---|---|---|
| salary 920, 5h, OVERWORK | 5.52 | 1.20 | 33.12 |
| salary 1000, 10h, LEGAL | 6.00 | 1.40 | 84.00 |
| salary 1500, 8h, ILLEGAL | 9.00 | 2.20 | 158.40 |
| salary 1200, 6h, LEGAL+night | 7.20 | 1.65 | 71.28 |
| hourly 4.40, 0.5h, OVERWORK+sunday | 4.40 | 1.95 | 4.29 |

---

## 3. Night work  (ΠΔ 88/1999; 22:00–06:00)

`hourly = resolveHourly()`. `surcharge = 0.25 + (sundayOrHoliday?0.75:0)` → weekday night **+25%**, Sunday/holiday night **+100%** (stacks). `total = hourly*hours*(1+surcharge)`.
*(Node's "Sunday replaces with +75%" under-counts a Sunday-night hour — corrected to stack.)*

| input | hourly | surcharge | total |
|---|---|---|---|
| salary 920, 8h, weekday | 5.52 | 0.25 | 55.20 |
| salary 1000, 8h, weekday | 6.00 | 0.25 | 60.00 |
| salary 1000, 8h, Sunday | 6.00 | 1.00 | 96.00 |
| salary 1400, 6.5h, weekday | 8.40 | 0.25 | 68.25 |
| hourly 4.40, 2h, Sunday | 4.40 | 1.00 | 17.60 |

---

## 4. Annual leave days  (ΑΝ 539/1945 + Ν.3302/2004 + EGSSE)

Two-layer **max** model. base = 5-day 20 / 6-day 24.
- Base ladder: `<12 months → round((months/12)*base)`; `1 completed year → base+1` (21/25); `≥2 completed years → 22/26`.
- EGSSE tier: `tenureMonths≥120 OR totalCareerYears≥12 → 25/30`; `totalCareerYears≥25 → 26/31`.
- `days = max(baseLadder, egsse)`.

*(Both candidates capped at 22/26, dropping the EGSSE 25/30 entitlement — corrected. Flag: EGSSE general binding force is debated post-2012; we ship 25/30+26/31 as default per Labour Inspectorate/KEPEA practice.)*

| week | tenure | careerYears | days |
|---|---|---|---|
| 5 | 6mo | 0 | 10 |
| 5 | 1yr3mo | 1 | 21 |
| 5 | 4yr | 4 | 22 |
| 6 | 11yr | 11 | 30 |
| 5 | 3yr | 26 | 26 |

---

## 5. Part-time annual leave  (ratio model)

`days = roundHalfUp(fullTimeLeaveDays × ptRatio)`, ptRatio = PT weekly hours / FT weekly hours (or PT days/wk ÷ FT days/wk), clamp (0,1]; never exceed full-time.
*(Replaces Angular's opaque `(daysWorked/25)*(base/12)`. **Flag for KEPEA:** Greek law gives no single closed formula for part-time leave; KEPEA's calculator should settle the canonical input model — its app may take days-worked rather than a ratio.)*

| FT days | ratio | days |
|---|---|---|
| 22 | 0.5 | 11 |
| 21 | 0.5 | 11 |
| 25 | 0.6 | 15 |
| 22 | 0.75 | 17 |
| 20 | 0.4 | 8 |

---

## 6. Leave pay + leave bonus  (αποδοχές & επίδομα αδείας; ΑΚ657-660, Ν.4504/1966)

`paidDays = (week==5) ? leaveDays*1.2 : leaveDays`.
SALARY: `leavePay = paidDays*(amount/25)`, `bonusCap = amount*0.5`.
DAILY_WAGE: `leavePay = paidDays*amount`, `bonusCap = amount*13`.
`leaveBonus = min(leavePay, bonusCap)`; `total = leavePay + leaveBonus`.  *(Angular verified correct.)*

| payType | amount | leaveDays | week | leavePay / bonus / total |
|---|---|---|---|---|
| SALARY | 1200 | 20 | 5 | 1152.00 / 600.00 / 1752.00 |
| SALARY | 1200 | 21 | 5 | 1209.60 / 600.00 / 1809.60 |
| SALARY | 1500 | 4 | 5 | 288.00 / 288.00 / 576.00 |
| SALARY | 1200 | 26 | 6 | 1248.00 / 600.00 / 1848.00 |
| DAILY_WAGE | 50 | 24 | 6 | 1200.00 / 650.00 / 1850.00 |

---

## 7. Holiday bonuses (δώρα)  (Christmas ΑΝ 682/1945; Easter ΑΝ 435/1968; ΚΥΑ 19040/1981)

**Increment (all variants): `× (1 + 1/24)`** (επίδομα αδείας, legally mandatory). Use `1.0/24.0` exactly — not the truncated `0.04166`.
Period boundaries (legal reference): Easter **1 Jan–30 Apr** (full denom 120 days); Christmas **1 May–31 Dec** (full denom 237.5). Day counts inclusive `(end-start)+1`, ratio capped at 1. Daily wage from monthly = `/25`.

- **easter-full (salaried):** `base = salary*0.5 * min(worked/120,1)`. *(Drop Angular's `salary/30`; use `salary×days/120` which equals the ½-salary/15-per-8-days rule.)*
- **easter-part-time / daily:** `base = dailyWage * (worked/8)` (cap 15 units).
- **easter-hourly:** `avg = totalEarnings/actualDaysWorked`; `base = avg * (calDays/8)` (cap 15).
- **xmas-full (salaried):** full period → `base = salary`; else `base = (worked/19)*(salary*2/25)`.
- **xmas-part-time / daily:** `base = dailyWage * (worked/19)*2` (cap 25). **Corrected from Angular's `/8`.**
- **xmas-hourly:** `avg = totalEarnings/actualDaysWorked`; full → 25 units; else `(calDays/19)*2` (cap 25); `base = avg*units`.

Vectors (factor 25/24 ≈ 1.041667):
| variant | input | expected |
|---|---|---|
| easter-full | salary 1000, full | 520.83 |
| easter-full | salary 1000, worked 60 | 260.42 |
| easter-daily | dw 35, worked 64 | 291.67 |
| easter-hourly | earn 1200, actual 30, cal 64 | 333.33 |
| xmas-full | salary 1000, full | 1041.67 |
| xmas-full | salary 1000, worked 95 | 416.67 |
| xmas-daily | dw 38.46, worked 65 | 274.13 |
| xmas-hourly | earn 2500, actual 65, cal 65 | 274.13 |

---

## 8. Maternity reduced-hours equivalent (ισόχρονη άδεια)  (Ν.1483/1984, Ν.4808/2021)

Window 30 months (+6 per extra child of a multiple birth). `workingDays = calendarDays − weekends − statutoryHolidays(not on weekends) − round(annualLeaveDays × windowMonths/12)`. `hoursOwed = workingDays × 1`. `continuousDays = round(hoursOwed / (week==6 ? 40/6 : 8))`. Result ≈ 3.5 months (5-day) — **an estimate**, and an **employer-agreement option**, not an automatic right.
Statutory holidays: fixed 1/1, 6/1, 25/3, 1/5, 15/8, 28/10, 25/12, 26/12; movable vs Orthodox Easter — Clean Monday −48, Good Friday −2, Easter Monday +1, Holy Spirit +50. Orthodox Easter via correct computus (`EasterDate`, Gregorian-converted, `LocalDate`).
*(Flag: ±day-count varies by source ~73–109 days; KEPEA/official calculator should calibrate.)*

---

## 9. Severance  (Ν.2112/1920, Ν.3198/1955, Ν.3899/2010, Ν.4093/2012)

`calcSalary = grossMonthly × 14/12`. monthsWithoutNotice ladder by completed years:
`<1→0, <4→2, <6→3, <8→4, <10→5, <11→6, <12→7, <13→8, <14→9, <15→10, <16→11, ≥16→12 (cap)`.
With proper notice → `× 0.5`. Notice period (Ν.3899/2010, info): `<1→0, <2→1, <5→2, <10→3, ≥10→4 (cap)`.
*(Both candidates + the guide wrongly capped at 6 months — corrected to 12. The 14/12 uplift and ×0.5 are correct.)*

| gross | years | notice | expected |
|---|---|---|---|
| 1000 | 3 | no | 2333.33 |
| 1000 | 3 | yes | 1166.67 |
| 1500 | 10 | no | 10500.00 |
| 2000 | 16 | no | 28000.00 |
| 830 | 0 | no | 0.00 |

---

## 10. National pension  (Ν.4387/2016 art.7)

base **€446.86 (2026)**. `if insurance<15 → 0`. `if residence<40 → ×(residence/40)`. `if insurance<20 → ×(1-(20-insurance)*0.02)`. `if age<67 AND insurance<40 → ×(1-min((67-age)*0.06,0.30))` *(flagged approximation, e-ΕΦΚΑ convention)*.
*(Node's base 386.69 + `years/20` reduction were wrong/stale — corrected.)*

| insurance | residence | age | expected |
|---|---|---|---|
| 20 | 40 | 67 | 446.86 |
| 15 | 40 | 67 | 402.17 (±0.01) |
| 17 | 40 | 67 | 420.05 |
| 20 | 30 | 67 | 335.15 |
| 14 | 40 | 67 | 0.00 |

---

## 11. Contributory pension  (Ν.4670/2020 art.24, Πίνακας 2)

Per-year accrual %: 0–15 **0.77**, 15–18 0.84, 18–21 0.90, 21–24 0.96, 24–27 1.03, 27–30 1.21, 30–33 1.98, 33–36 2.50, 36–40 2.55, 40+ 0.50. `if years<15 → 0`. `pension = pensionableEarnings × cumulativeRate%/100` (earnings = career-average insurable wage). *(Verified cent-for-cent vs official table. Node's flat 0.70–1.25% tiers were wrong.)*

| earnings | years | rate% | expected |
|---|---|---|---|
| 1000 | 15 | 11.55 | 115.50 |
| 1200 | 20 | 15.87 | 190.44 |
| 1500 | 30 | 26.37 | 395.55 |
| 1200 | 35 | 37.31 | 447.72 |
| 2000 | 40 | 50.01 | 1000.20 |

---

## Flagged uncertainties (resolve during KEPEA pass)
1. Gross-to-net: disability +€200 for 2026; youth (age<30) brackets; employer rate 22.29 vs 21.79.
2. Part-time leave: canonical input model (ratio vs days-worked).
3. Maternity: exact day-count (no single statutory value).
4. National pension: per-tier rounding (402.17 vs EFKA 402.18) — use ±0.01 tolerance or hardcode EFKA table.
5. The guide articles `orario/yperoreis.md` and `orario/nyxterina.md` are **stale** (cite Ν.3385/2005, miss υπερεργασία +20% and +120% illegal) — recommend updating them to match these corrected calculators.

## Sources
Labour Inspectorate (hli.gov.gr), KEPEA/GSEE (kepea.gr), Ministry of Labour (ypergasias.gov.gr), Taxheaven (2026 brackets, art.16), e-ΕΦΚΑ (pensions), Ν.4670/2020 (opengov). Full URLs in the verification research transcript.

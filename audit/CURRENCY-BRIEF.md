# CURRENCY BRIEF — Greek Labour & Social-Insurance Law (as of 2026-07-13)

**Purpose.** Authoritative, primary-source baseline for the corpus legal-accuracy audit. Every
Phase-A verification agent consumes this. Values here are the *current* (mid-2026) legal truth,
each tied to a governing instrument + ΦΕΚ + effective date + source URL. Where a corpus claim is
listed as WRONG/OUTDATED, the correction is the value to apply — **after** the per-file adversarial
refutation gate re-confirms it against the primary source.

**Source hierarchy.** PRIMARY = e-nomothesia.gr / et.gr (ΦΕΚ) · ypergasias.gov.gr (Υπ. Εργασίας) ·
hli.gov.gr (Επιθεώρηση Εργασίας — esp. the `ΠΙΝΑΚΑΣ ΑΔΕΙΩΝ`) · e-efka.gov.gr · dypa.gov.gr ·
teka.gov.gr · aade.gr · mitos.gov.gr. AUTHORITATIVE cross-check = kepea.gr (ΓΣΕΕ/ΚΕΠΕΑ). SECONDARY
(locate only, never establish) = taxheaven.gr, lawspot.gr, kodiko.gr, media.

**Operational note for agents.** `kepea.gr`, `et.gr`, and `forin.gr` return **HTTP 403 to automated
fetch** — use `hli.gov.gr`, `ypergasias.gov.gr`, `e-nomothesia.gr`, `e-efka.gov.gr`, `dypa.gov.gr`
and `taxheaven.gr`/`lawspot.gr` (which mirror ΦΕΚ text) for verbatim quotes.

---

## 0. NEW post-2023 legislation the corpus is missing (the currency spine)

The newest statute cited anywhere in the corpus is **Ν.5078/2023**. Everything below postdates the
corpus and must be woven in where relevant.

| Instrument | ΦΕΚ | Effective | What it changed (audit relevance) |
|---|---|---|---|
| **Ν.5053/2023** «Για την ενίσχυση της εργασίας» | Α΄158/26.09.2023 | 26.9.2023; τριετίες unfrozen 1.1.2024; card penalties from 1.7.2024 | Probation ≤6 mo (art.4); parallel employment / no-exclusivity (→13h combined day); **6th-day work +40%**; **digital work-card penalty €10.500/employee** (art.22); dismissal in first 12 mo w/o notice/severance (art.19); **triennia unfreeze (art.33)**; ΕΡΓΑΝΗ αναγγελία & deemed-resignation (art.23); transposed EU Dir 2019/1152. |
| **Ν.5078/2023** (pension/insurance) | Α΄211/20.12.2023 | 20.12.2023 | **Working-pensioner 30% cut ABOLISHED → 10% e-EFKA πόρος** (art.114); raised insurable-earnings ceiling; occupational-insurance reform. |
| **ΠΔ 62/2025 «Κώδικας Εργατικού Δικαίου» (ΚΕΔ)** | Α΄121/11.07.2025 | 11.7.2025 | **Recodified all individual labour law into one Code** (replaced ΠΔ 80/2022). Working-time, leave, dismissal rules now *live here*. Citing the underlying laws is still fine, but content framed as "latest = Ν.4808/2021" is structurally stale. |
| **Ν.5239/2025 «Δίκαιη Εργασία για Όλους»** | Α΄178/17.10.2025 | 17.10.2025 | **13-hour working day with a SINGLE employer** (≤4h overtime/day @ +40%, ≤150h/yr ≈ 37,5 such days, 11h rest inviolable, right to refuse); **4-day week available ALL YEAR**; **daily overtime cap 3h→4h**; single-document digital hiring. Amends ΚΕΔ arts 194 (overtime) & 202 (ΔΧΕ). |
| **ΚΥΑ 54427/2024** (ΦΕΚ Β΄7047/20.12.2024) — new contributory unemployment benefit | 2024 | pilot Apr 2025 → 30.6.2026 | New **contributory** unemployment benefit (fixed 70% of min daily wage + seniority bonus + supplements, **up to €1.375/mo**, needs 175 days/14 mo). Pilot; as of 13.7.2026 the classic τακτικό επίδομα still governs. **CORRECTION: NOT Ν.5217/2025 — that is a fiscal-balance law (EU Dir 2024/1265), unrelated to unemployment.** |
| **Ν.5316/2026** (pay transparency) | Α΄105/06.07.2026 | 6.7.2026 | Equal-pay / pay-transparency regime (EU Dir 2023/970): disclosure duties, remedies, enforcement. Relevant to `isi-metaxeirisi.md`. |
| ΥΑ 24595/2024 (Β΄1966/29.3.2024) | — | card expansion | Digital work card → manufacturing (ΚΑΔ 10-33 excl.19) & retail (ΚΑΔ 47). |
| ΥΑ 18047/2026 (Β΄3791/29.6.2026) | — | 29.6.2026 | Digital work card expanded to further sectors. |
| Ν.4997/2022 | Α΄219/25.11.2022 | 25.11.2022 | **Special maternity protection leave 6 → 9 months** (art.43); ≤7 mo transferable to father. (Predates corpus's newest cite but absent.) |
| Ν.5043/2023 | Α΄91/13.04.2023 | 13.4.2023 | **Gynaecological-exam leave: 1 day/yr, paid, PRIVATE sector** (art.96). New topic — corpus gap. |

**UNVERIFIABLE in detail (flag, don't assert):** exact labour-code touches of **Ν.5297/2026**
(Α΄64/28.4.2026) and **Ν.5302/2026** (Α΄78/20.5.2026) — appear technical, not core working-time.

---

## 1. Working time  → files: orario/*, and any file citing 40h/overtime/rest

Governing text is now **ΚΕΔ (ΠΔ 62/2025) as amended by Ν.5239/2025** (underlying: Ν.4808/2021,
Ν.3385/2005, ΠΔ 88/1999).

| Topic | CORRECT current value | Corpus verdict |
|---|---|---|
| Weekly hours | **Legal (νόμιμο) max = 45h/5-day (9h/day), 48h/6-day (8h/day)**; 40h is the **contractual** full-time schedule. Hours 41–45 (5-day)/41–48 (6-day) = **υπερεργασία +20%**. | `ores-ergasias.md` "40h = legal max" **WRONG** (40h is contractual; legal max 45h). 6-day 48h **OK**. Missing υπερεργασία +20% tier. |
| 13-hour day | **Allowed with a single employer** (Ν.5239/2025): consent required, right to refuse, ≤4h overtime/day @ +40%, ≤150h/yr (≈37,5 days), weekly ≤48h avg / 4-mo ref, 11h rest inviolable. Also 13h across **two** employers (Ν.5053/2023). | Entire `orario` cluster **OUTDATED** — omits Ν.5239/2025. Add with the site's critical framing + the right-to-refuse. |
| Overtime (υπερωρία) | Νόμιμη ≤4h/day & ≤150h/yr → **+40%**; beyond 150h (approved) → **+60%**; illegal/undeclared → **+120%**. Daily cap now **4h** (was 3h). | `yperoreis.md` +40%/+120% **OK**; **add +60% tier**; "150h annual cap" is a rate threshold, not absolute cap; daily cap 4h. |
| Daily rest | **11 continuous h** per 24h — **ΠΔ 88/1999 art.3** (reduced 12→11 by Ν.4093/2012). | `ores-ergasias.md` cites **art.5 — WRONG** (art.5 = weekly rest). Value 11h OK. |
| Weekly rest | **≥24 continuous h** — ΠΔ 88/1999 **art.5** (norm 24h+11h=35h). | MATCHES. |
| Breaks | **⚠ CONTESTED — resolve from primary text before any edit.** Base ΠΔ 88/1999 art.4 = break when daily work > 6h; but Ν.4808/2021 art.56 may provide a 15–30 min break when work exceeds **4h** (two audit agents disagreed on threshold 4h-vs-6h and on a 30-min tier). Minors <18: 30 min after 4,5h (ΠΔ 62/1998). | Do **NOT** edit the corpus adult-break rule until the exact current art.4 / Ν.4808 art.56 wording is confirmed from ΦΕΚ/e-nomothesia; otherwise leave corpus text as-is and log to HUMAN-REVIEW. Minors rule OK. |
| Night work | Window **22:00–06:00** (ΠΔ 88/1999 art.2); premium **+25%** on legal min wage (ΚΥΑ 18310/1946 — exact number citation-uncertain). | `nyxterina.md` MATCHES (verify ΚΥΑ number). |
| 6th-day work | **+40%** for continuous-operation/24-7 & exceptional-load businesses (Ν.5053/2023). | `ekti-imera.md`: verify premium is +40% (not 50%). |
| ΔΧΕ (διευθέτηση) | ≤10h/day intensive; **12-month** reference; 4-day week (10×4) by individual written E4 in ΕΡΓΑΝΗ, now **all year** (Ν.5239/2025 art.8, ΚΕΔ art.202). | `ores-ergasias.md` substance MATCHES; citation "Ν.4808/2021" now = ΚΕΔ art.202 as amended by Ν.5239/2025. |

---

## 2. Pay  → files: misthos/*

| Topic | CORRECT current value | Corpus verdict |
|---|---|---|
| Minimum wage (01.04.2026) | **€920,00/mo (υπάλληλοι), €41,09/day (εργατοτεχνίτες)** — **ΚΥΑ 8934/2026, ΦΕΚ Β΄1759/27.03.2026**. History: 2025 €880/€39,30 (ΚΥΑ); 2024 €830/€37,07 (ΥΑ 25058/2024, Β΄1974). | `katotatos-misthos.md` **MATCHES** (all amounts web-confirmed). Refine: it is a **ΚΥΑ**, not ΥΑ. |
| Triennia | υπάλληλοι **+10%/τριετία, max 3 (=30%)**; εργάτες **+5%/τριετία, max 6 (=30%)**; frozen 14.2.2012 (**ΠΥΣ 6/2012 art.4**), **unfrozen 1.1.2024 by Ν.5053/2023 art.33**; 14.2.2012–31.12.2023 excluded; any-employer service counts. | MATCHES substance. Fix: unfreeze = **Ν.5053/2023 art.33**; freeze = ΠΥΣ 6/2012 (not Ν.4093/2012). Auto re-suspension clause from 1.1.2027 if unemployment >10%. |
| **Hourly wage formula** | **Official (hli.gov.gr): ωρομίσθιο = μηνιαίος ÷ 25 × 6 ÷ 40 = μισθός × 0,006.** Daily = μηνιαίος ÷ 25. At €920 → **€5,52/h**. | `oromisthio.md` (and any ÷25÷8 usage) **WRONG** — corpus ×0,005 **understates hourly wage ~16,7%**. Also fix worked examples (e.g. `yperoreis.md` "€1.000→€5,00/h" should be €6,00/h). |
| Christmas bonus | Full = **1 monthly salary** (or 25 ημερομίσθια), period 1 May–31 Dec; accrual **2/25 per 19-day period**; **× 1,041666** (επίδομα αδείας uplift). Basis **Ν.1082/1980 + ΚΥΑ 19040/1981 (Β΄742)**; penalties **ΑΝ 690/1945**. | `doro-xristougennon.md` amounts/period OK; **citation wrong** (corpus "ΑΝ 682/1945"→ should be Ν.1082/1980 + ΚΥΑ 19040/1981; penalties ΑΝ 690/1945); accrual omits ×1,041666 uplift. |
| Easter bonus | Full = **½ monthly salary** (15 ημερομίσθια), period 1 Jan–30 Apr; accrual **1/15 per 8-day period**; **× 1,041666**. Same basis as above. | `doro-pasxa.md` amounts/period OK; **citation wrong** (corpus "ΑΝ 435/1968"→ Ν.1082/1980 + ΚΥΑ 19040/1981); accrual omits uplift. |
| Marriage allowance | **10%**, owed only to employees of **ΕΓΣΣΕ signatory-member employers** (ΣΕΒ/ΓΣΕΒΕΕ/ΕΣΕΕ/ΣΕΤΕ/ΣΒΕ) or where a ΣΣΕ/contract grants it; not in the legislated min wage. Controlling: **ΑΠ 812/2023**. | `epidoma-gamou.md` MATCHES; refine scope to signatory-member test + cite ΑΠ 812/2023. No controlling CJEU ruling (don't assert one). |
| Hazard allowance | No general **private-sector** statutory hazard allowance; only via κλαδική/επιχ. ΣΣΕ. Statutory version is public-sector (ΚΥΑ). ΒΑΕ = pension category, not pay. | `epidoma-anthygieinis.md` MATCHES. |
| Payslip (εκκαθαριστικό) | Mandatory analytical payslip (αναλυτικό εκκαθαριστικό σημείωμα αποδοχών); digital delivery permitted. **NB: NOT Ν.4808/2021 art.62 — that article is UNPAID LEAVE.** Governing basis to confirm per file (candidate: Ν.1082/1980 art.18 §1 as am. Ν.4254/2014). | Verify contents + correct legal basis in `ekkatharistiko.md`. |

---

## 3. Social insurance  → files: asfalisi/*

| Topic | CORRECT current value | Corpus verdict |
|---|---|---|
| Contribution rates (μισθωτοί, 2026) | **Total ~35,16%** = employee **13,37%** + employer **21,79%**. Branches: κύρια σύνταξη **20%** (6,67+13,33); επικουρική/ΤΕΚΑ **6%** (3+3, from 1.6.2022); **υγεία σε είδος 5,45%** (1,65+3,80, cut from 1.1.2025 by e-EFKA εγκ.38/2024); **υγεία σε χρήμα 0,65%** (0,40+0,25); ΔΥΠΑ/λοιπά residual ~3,06%. Ceiling **€7.761,94/mo (2026)** (e-EFKA εγκ.4/2026). Basis Ν.4387/2016 art.38. | `eisfores.md` **totals + ceiling MATCH**; **line-items WRONG/OUTDATED**: health-in-kind 6,45%→5,45%; health-cash 1,15%→0,65%; bogus "ΤΕΚΑ 0,36%" row (ΤΕΚΑ = the 6% auxiliary); wrong ΔΥΠΑ split; line-items don't sum to the (correct) total. |
| e-EFKA | Single fund Ν.4387/2016 (op. 1.1.2017), reformed & rebranded e-ΕΦΚΑ by Ν.4670/2020 (merged ΕΤΕΑΕΠ). Undeclared-work penalty **€10.500/worker** (Ν.4554/2018, +100%/+200% recidivism; €7.000 if worker hired 3-mo FT). | `efka.md` MATCHES; `ergani.md` €10.500 MATCHES. |
| ΕΡΓΑΝΗ | **ΕΡΓΑΝΗ ΙΙ** (Ν.4808/2021 arts 73-74) linked to ψηφιακή κάρτα; relaunched 16.2.2026; card expanded by ΥΑ 24595/2024 & 18047/2026. | `ergani.md` substance OK but **"ΥΑ 80488/2021" UNVERIFIABLE/likely WRONG** → real refs ΥΑ 49758/2022 (Β΄2668) & 80016/2022 (Β΄4629). |
| Εργόσημο | **25%** of face value withheld for contributions (was 20%, not 10%). Basis Ν.3863/2010 art.20, +Ν.4144/2013, 4225/2014, 4554/2018, 4611/2019. | `ergosimo.md` 25% MATCHES; add amending laws. |
| Τεκμαρτό ημερομίσθιο | Classes abolished for employees (Ν.4387/2016); contributions on **actual earnings**. Survives (annual class tables) for **fluctuating-earnings** workers: σερβιτόροι, κομμωτές, ταξί, πλασιέ, etc. | `tekmarto-imeromisthio.md` MATCHES; **scope imprecise** — add fluctuating-earnings categories (corpus frames it around εργόσημο/domestic/agricultural only). |

---

## 4. Unemployment  → files: anergia/*

| Topic | CORRECT current value | Corpus verdict |
|---|---|---|
| Benefit amount | Min-wage-pegged **3-tier flat schedule** (mid-2026): avg gross ≥€493,09 → **€565/mo** (€22,60/day); €246,55–493,08 → €423,75; ≤€246,54 → €282,50. **+10% per dependent**. (Was €479/mo 2023-24.) | `epidoma.md` "55% of avg daily wage" **OUTDATED characterization**; no number given so not "wrong" — update to the pegged schedule (~€565). |
| **Duration table** | **5 brackets on a 14-month basis**: 125–149 → **5 mo**; 150–179 → 6; 180–219 → 8; 220–249 → 10; 250+ → 12. Min **5 months**. | `epidoma.md` table **WRONG** (corpus: 8 brackets, "125–149→2 mo", 4-year basis). **This is a major factual error.** |
| Eligibility | First-time: **125 days/14 mo** (excl. last **2** mo) **or** 200 days/2 yr (+80/yr prior). Registration **60 days**; appeal **30 days**. Basis Ν.1545/1985, Ν.4921/2022 (ΔΥΠΑ rebrand + ψηφιακό ατομικό σχέδιο). | `epidoma.md`: 125-day / 60-day / 30-day / +10% / laws **MATCH**; fix "excl. last month" → **last 2 months**; add the 200/2-yr alternative. |
| New benefit | **Ν.5217/2025** contributory benefit (up to €1.375/mo, 175 days/14 mo) — pilot ended 30.6.2026; classic benefit still governs mid-2026. | Add as a forward-looking note. |

---

## 5. Pensions  → files: syntaxi/*

| Topic | CORRECT current value | Corpus verdict |
|---|---|---|
| Retirement ages | 67 + 15 yrs (4.500 ημ.) full; 62 + 40 yrs (12.000 ημ.) full; 62 + 15 yrs reduced (−1/200 per month early, up to −30%). | `ilikia-syntaxis.md` (a)(b)(c) MATCH. |
| ΒΑΕ | **62 + 4.500 ημ. total (15 yrs), of which ≥3.600 ημ. (12 yrs) in ΒΑΕ** (+ recent-window rule). | Corpus "62 / 25 yrs / 15 in ΒΑΕ" **WRONG** on both figures. |
| Disability bands | **3 bands**: ≥80% → 100%; 67–79,99% (συνήθης) → **75%**; 50–66,99% (μερική) → **50%**. | Corpus lists **2 bands** and mislabels 67–79,9% as "μερική" — **WRONG/INCOMPLETE**. |
| National pension | **€446,86/mo (20 yrs), from 1.1.2026** (ΚΥΑ 31854/2025, Β΄6519). Reduction **−2 pts/yr below 20 yrs, floor 90% at 15 yrs** (15 yrs = €402,18). Trajectory: €384(2016)→€413,76(2023)→€426,17(2024)→€436,39(2025)→€446,86(2026). | Corpus **€386,69 OUTDATED** (never an official value); formula `×(έτη/20)` **WRONG**. Same stale figure in `index.md`. |
| Accrual (ανταποδοτική) | **0,77%–2,55%/yr** by band (Ν.4670/2020); cumulative 15y=11,55% … 40y=50,01%, +0,50%/yr after. | Corpus "0,77%–1,25%" **WRONG** on upper bound. |
| Working pensioner | 30% cut **ABOLISHED 1.1.2024**; replaced by **10% e-EFKA πόρος** (μισθωτοί; 7,7% κύρια+2,3% επικ.) — **Art.114 Ν.5078/2023**, ΚΥΑ Δ.15/Δ'/14831/2024. Cap 12× εθνική (2026 €5.362,44). Non-declaration penalty = 12 monthly pensions. | Corpus "περικοπή 30%" **WRONG (now)**. |
| Εξαγορά/πλασματικά | Art.34 Ν.4387/2016 (am. Ν.4670/2020): military, studies, children (1–5 yrs), parental/edu leave, unemployment gap, EU aggregation. Cost = **20% of pensionable earnings/month**; lump-sum (−2%/yr), instalments, or ≤¼-of-pension deduction. | `exagora-ensemon.md` MATCHES/underspecified — pin cost basis = 20% + Art.34. |

**For NEW gap articles:** Auxiliary/**ΤΕΚΑ** (Ν.4826/2021, capitalisation, 3%+3%, mandatory for first-insured from 1.1.2022; pre-2022 keep PAYG via e-EFKA/ex-ΕΤΕΑΕΠ); **εφάπαξ** (Art.35 Ν.4387/2016); **survivor's pension** (Art.12 Ν.4387/2016 am. Ν.4670/2020): **spouse 70%** (was 50%), ≥3-yr marriage rule, reduced to 35% after 3 yrs if working/own-pension (full 70% kept if ≥67% disabled), children 25% each to age 24, aggregate cap = deceased's pension.

---

## 6. Leaves  → files: adeies/*  (primary anchor: hli.gov.gr `ΠΙΝΑΚΑΣ ΑΔΕΙΩΝ`)

| Leave | CORRECT current value (law) | Corpus verdict |
|---|---|---|
| Maternity | 17 wks (56+63); dismissal protection **18 mo** post-birth (Ν.4808 art.48; father protected 6 mo). | `mitrotita.md` MATCHES. |
| Special maternity (ΔΥΠΑ) | **9 months** (Ν.**4997/2022 art.43**), paid at min wage + proportional δώρα/επίδομα αδείας; ≤7 mo transferable to father; opened to all e-EFKA women by ΚΥΑ 39686/2024. | `mitrotita.md` line 27 "6 μήνες" **OUTDATED → 9**. `eidiki-adia-mitrotitas.md` value OK but cite Ν.4997/2022 art.43 + add father transfer. |
| Paternity | **14 working days**, paid, no conditions (Ν.4808 art.27). | `patrotita.md` MATCHES. |
| Parental | 4 mo/parent to age 8; first 2 mo paid by ΔΥΠΑ at min wage (Ν.4808 art.28); needs 1 yr tenure. | `goniki-adia.md` MATCHES (its "€880" auto-tracks current min wage). |
| Breastfeeding/childcare | 30 mo; **1h/day reduction, FULLY PAID** (or 2h/day first 12 mo then 1h/6 mo, or continuous ΔΥΠΑ leave) — Ν.4808 art.37. | `thilasmou.md` MATCHES; **`eidikes-adeies.md` "2h @ 50% pay" WRONG** (all fully paid). |
| Force-majeure | **≤2×/yr, ≤1 working day each, PAID**, urgent family illness/accident, medically certified — Ν.4808 **art.30**. | Corpus **GAP** (no entry). Draft new article. |
| Carer's (φροντιστή) | **5 working days/yr, UNPAID**, medical certificate **required** — Ν.4808 **art.29**. | `eidikes-adeies.md`: pay OK; **"no certificate" WRONG**; rename "άδεια φροντίδας οικογένειας" → **άδεια φροντιστή**. |
| Child/dependant sick | **6 / 8 / 14 working days/yr (1 / 2 / >2 dependants), UNPAID** — Ν.4808 art.42 (base Ν.1483/1984 art.7). | `eidikes-adeies.md` "2 paid / 4 for 3+" **WRONG on every count**. |
| Disabled-child | **10 working days/yr PAID** (Ν.4808 art.43, am. Ν.4892/2022) for child w/ serious illness or severe mental disability/Down/autism; **or** 1h/day reduced-pay in firms ≥50 (art.41). | `eidikes-adeies.md` "6 paid days for Down/>67%" **WRONG** (6 days = the disabled-*employee* leave, different right). |
| School-monitoring | **≤4 days/yr, PAID** (Ν.4808 art.38, base Ν.1483/1984 art.9). | `adia-gamos.md` MATCHES; current article = 38. |
| Prenatal exams | Paid time off, **"χωρίς περικοπή αποδοχών"** (Ν.4808 art.40, base Ν.3488/2006). | `eidikes-adeies.md` MATCHES. |
| **Gynaecological-exam** | **1 day/yr, PAID, private sector** — **Ν.5043/2023 art.96** (extended the public-sector right). No twice-yearly/test-specific basis exists. | Corpus **GAP** (the user-flagged item — real basis, but 1×/yr not 2×). Draft new article. |
| Marriage | **6 days (6-day week) / 5 days (5-day week), PAID**; incl. σύμφωνο συμβίωσης (Ν.4808 art.39). | `adia-gamos.md` MATCHES. |
| Bereavement | **2 working days, PAID** (ΕΓΣΣΕ 2002-03 art.9). | Corpus thin/GAP — consider dedicated entry. |
| Unpaid leave | **≤1 yr** by written agreement, contract suspended (not terminated), in ΕΡΓΑΝΗ, revives after — Ν.4808 **art.62**. | Corpus thin/GAP — draft/expand. |

---

## 7. Dismissal / severance / tax  → files: apolysi/*

| Topic | CORRECT current value | Corpus verdict |
|---|---|---|
| Severance scale | **Single scale** Ν.2112/1920 + Ν.4093/2012: 1–4 yr → 2 mo; 4–6 → 3; 6–8 → 4; 8–10 → 5; 10 → 6; +1 mo/yr to **16+ → 12 (max)**. **With written notice = half; without = full.** Notice **capped at 4 months** (12mo–2yr→1, 2–5→2, 5–10→3, 10+→4). Pre-12.11.2012 tenure >17 yrs keeps +1 mo/extra-yr on pay ≤€2.000. | `apozimiossi.md` tables **WRONG/fabricated** ("Ν.3863/2010 6-mo cap", "17.6.2010 split" don't exist; real cap 12 mo, split 12.11.2012). Notice "up to 6 mo" **WRONG** (max 4). |
| Blue/white unification | Unified by **Ν.4808/2021 art.64** (2021); 1 month = **22 ημερομίσθια**; no separate day-based table now. | `apozimiossi.md` credits Ν.4093/2012 — **WRONG law** (substance correct). |
| Validity conditions | Written form + **payment of severance** = validity (Ν.3198/1955 art.5, long-standing); ΕΡΓΑΝΗ αναγγελία (Ν.5053/2023 art.23); deemed resignation after 5 days' unjustified absence. | Verify wording. |
| Severance tax | **0% ≤€60k · 10% €60–100k · 20% €100–150k · 30% >€150k** — Ν.4172/2013 art.15 §3, marginal, autonomous. In force 2025-26. | `foros-apozimiossi.md` / `apozimiossi.md` **MATCHES** — no change. |
| Unfair dismissal | Grounds (discrimination/reprisal/protected classes); **burden-of-proof shift** to employer (Ν.4808 art.66 §2); remedy = nullity+reinstatement OR **alternative comp: min 3 months' pay / max double statutory** (not "12 months"). 3-mo action deadline (Ν.3198/1955 art.6). | `adiki-apolysi.md` **INCOMPLETE** — add art.66 burden shift + alternative comp. |
| Collective redundancies | Thresholds 20–150 empl → ≤6/mo; >150 → ≤5% & max 30/mo. **Consultation 30 days**; ministerial **veto abolished** → ΑΣΕ legality check (10-day opinion), effect 20/60 days — **Ν.4472/2017 art.17** (post-CJEU *AGET Iraklis* C-201/15). | `omadikes-apolysi.md`: thresholds MATCH; consultation "20 days" **WRONG (→30)**; veto reform "Ν.4303/2014" **WRONG (→Ν.4472/2017)**. |
| Employer insolvency | ΔΥΠΑ Wage Guarantee Fund covers **3 months** unpaid wages within a 6-month reference; apply within **6 months**; basis **ΠΔ 1/1990** et seq. (Dir 2008/94); ΔΥΠΑ per Ν.4921/2022; insolvency per Ν.4738/2020. | `ptoxeisi-ergodoti.md`: "6 months" **WRONG (→3)**; deadline "3 months" **WRONG (→6)**; basis "Ν.3863/2010 art.34" unsupported (→ΠΔ 1/1990). |

---

## 8. Confirmed content GAPS (Phase D new-article candidates)

All have a confirmed legal basis unless noted:
- **Force-majeure leave** — Ν.4808/2021 art.30 (≤2×/yr, ≤1 day, paid). → `adeies/anoteras-vias.md`
- **Gynaecological-exam leave** — Ν.5043/2023 art.96 (1 day/yr, paid, private). → `adeies/gynaikologikos-elegxos.md` *(the user-flagged item)*
- **Bereavement leave** — ΕΓΣΣΕ 2002-03 art.9 (2 days, paid). → `adeies/penthos.md`
- **Unpaid leave** — Ν.4808/2021 art.62. → `adeies/aneu-apodoxon.md`
- **IVF / assisted-reproduction leave** — VERIFY basis before drafting; if unconfirmed → HUMAN-REVIEW.
- **Child health-monitoring / paediatric check-ups** — VERIFY distinct basis (vs sick-child); if none → note it's covered by force-majeure/sick-child, don't invent.
- **Auxiliary pension / ΤΕΚΑ** — Ν.4826/2021. → `syntaxi/epikouriki-teka.md`
- **Εφάπαξ (lump sum)** — Art.35 Ν.4387/2016. → `syntaxi/efapax.md`
- **Survivor's pension** — Art.12 Ν.4387/2016 (spouse 70%). → `syntaxi/syntaxi-thanatou.md`
- **Whistleblower protection** — Ν.4990/2022 (EU Dir 2019/1937). → `symvasi/prostasia-martyron-dimosiou-symferontos.md` *(verify in Phase A)*
- **Pay transparency** — Ν.5316/2026 (Dir 2023/970) — fold into `isi-metaxeirisi.md` or new article.

---

## 9. Known citation bugs (Phase E)

- `misthos/doro-pasxa.md` & `orario/ekti-imera.md`/`argies.md`: **435/1968** cited as both ΑΝ and Ν.
- `symvasi/sse.md`: Ν.1767/1988 hyperlinked to a **ΠΔ-240/2006 URL** and mislabelled **ΟΜΕΔ** (Ν.1767/1988 = Συμβούλια Εργαζομένων).
- `symvasi/apergia.md`: "**Συνταξιακό** δικαίωμα απεργίας" → "**Συνταγματικό**".
- `misthos/doro-xristougennon.md`: "ΑΝ 682/1945" likely a slip for ΑΝ 690/1945 (penalty law); real basis Ν.1082/1980 + ΚΥΑ 19040/1981.
- Tag spacing inconsistent (`Ν.4808/2021` vs `Ν. 4808/2021`).

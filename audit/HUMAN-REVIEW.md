# HUMAN-REVIEW — Greek Labour-Law Corpus Audit (consolidated)

**Date:** 2026-07-13. Consolidated queue of items a human εργατολόγος should verify, grouped by severity. Every item was either NOT edited, edited conservatively, or resolved-with-a-caveat under the adversarial gate ("no assertion without independent primary-source confirmation"). Counts: **HIGH 8 · MEDIUM 49 · LOW/cosmetic 77**.

---

## ⚠ HIGH — accuracy risk; a human εργατολόγος MUST check (8)

### 1. CONTESTED adult break rule (>4h vs >6h) — `orario/ores-ergasias.md` (lines ~27-28)
LEFT UNCHANGED per instruction. Base ΠΔ 88/1999 art.4 = break when work >6h; Ν.4808/2021 art.56 may set a 15–30 min break when work exceeds **4h**. Live hli.gov.gr (ΠΔ 88/1999 art.4 as replaced by Ν.4808/2021 art.56) gives the CURRENT rule as **"15–30 min when daily work exceeds 4 continuous hours"** → the corpus's separate ">6h → 30min" tier appears fabricated. CURRENCY-BRIEF reflects PRE-2021 text; primary reflects post-2021. **Reconcile ΠΔ 88/1999 art.4 as amended, then decide: consolidate to a single ">4h → 15–30min" tier or keep.** ΚΕΔ mapping if edited: art.172.

### 2. "+50% αυτόματη προσαύξηση" on unpaid δώρα (no primary basis) — `misthos/doro-xristougennon.md` & `doro-pasxa.md`
LEFT AS-IS (pre-existing corpus content; cannot prove the negative to gate standard). **No primary source supports an automatic 50% civil surcharge.** Confirmed consequences: δεδουλευμένη αποδοχή + τόκος υπερημερίας + 5-yr παραγραφή; criminal ΑΝ 690/1945 (≤6mo + fine, αυτόφωρο); administrative fine by Επιθεώρηση Εργασίας. One WebSearch loosely mentioned a *criminal fine* "25%–50%" (a range, not an automatic civil top-up). **Recommendation: remove "+50% αυτόματα" OR replace with the confirmed regime.** Src: odigostoupoliti.eu; tovima.gr.

### 3. "Αυτόματα 12 μήνες" ιατροφαρμακευτική κάλυψη post-unemployment (unverified) — `anergia/epidoma.md` (~line 74) + `anergia/index.md` (~24, ~44, ~53)
NOT EDITED (4 occurrences). No primary source confirms a flat, universal, automatic **12-month** health-coverage rule from the last insurance day. Historically ασφαλιστική ικανότητα for the unemployed **scales with insurance days/benefit status** (+ special extensions e.g. Ν.4611/2019). **Verify vs e-EFKA/ΕΟΠΥΥ + Ν.4611/2019, then correct all four spots consistently.** Confidence it is safe as written: LOW.

### 4. Apprentice-pay scheme breakdown — `symvasi/matiteia.md`
Correction NOT applied; proposed flat **95%** REFUTED as a universal figure. The rate is **scheme-specific**: ΙΕΚ/ΣΕΚ **75%** · ΕΠΑΣ Μαθητείας ΔΥΠΑ **80%** · ΕΠΑΛ Μεταλυκειακό Έτος & Π.ΕΠΑΣ τουρισμού **95%** (ΚΥΑ 132791/Κ5, ΦΕΚ Β΄6597/2023) — each as **% of the κατώτατο ημερομίσθιο (€41,09 από 1.4.2026) ανά ημέρα μάθησης**. Corpus's "75% / €660 / €880" is wrong in method (flat monthly) and base (2026 = €41,09/day). **Recommendation: replace single figure with a scheme table; do not conflate the separate ΔΥΠΑ €-subsidy strand.** Only ΣΕΠΕ→Επιθεώρηση terminology was changed. Src: dypa.gov.gr/mathitia; odigostoupoliti.eu.

### 5. "Child-health-monitoring" leave — NO distinct private-sector basis (preventive)
Confirmed the corpus contains **no** distinct "παρακολούθηση υγείας τέκνου" leave (the only monitoring leave present is the legitimate **school-performance** leave, Ν.4808/2021 art.38 / ΚΕΔ 240, in `adeies/adia-gamos.md` — correctly cited). **There is no separate statutory child-health-monitoring leave in the private sector**; such absences are covered by **force-majeure leave (art.30 / ΚΕΔ 233)** + **child-sick leave (art.42 / ΚΕΔ 244)**. Flag so no future edit or RAG answer invents a distinct entitlement.

### 6. Claims resting on secondary sources because a primary was blocked (cross-cutting)
Where kepea.gr / et.gr / forin.gr / ypes.gr / taxheaven-news returned 403/404/ECONNREFUSED, the claim was verified via non-blocked mirrors + WebSearch snippets, not the primary. A human with primary access should re-confirm: (a) `asfalisi/eisfores.md` ΔΥΠΑ/λοιπά **3,06% internal sub-split** (kepea 403); (b) `adeies/eidiki-adia-mitrotitas.md` **ΚΥΑ 39686/2024 gating** (forin 403 / elinyae ECONNREFUSED); (c) `symvasi/anangestikes-proslixi.md` **public-sector ΑμεΑ 1h/day** & **8% quota sub-split** (ypes.gr 403 / kodiko paywall); (d) `anergia/epidoma.md` figures (kepea/et.gr/forin 403); (e) `orario/karta-ergasias.md` **card sub-penalties** (taxheaven news 404). Aggregate/headline figures in each ARE independently confirmed; only the fine-grained sub-details rest on secondary sources.

### 7. Cross-border Framework Agreement — is Greece a signatory yet? (time-sensitive) — `orario/tilergasia-diasinoraiki.md`
Applied the corrected rule (in force 1.7.2023, "<50%" band) AND an ADVERSARIAL flag that **Greece is NOT among the signatory states** → no automatic application; pointer to e-ΕΦΚΑ Εγκ.33/2024 + individual art.16 Reg 883/2004 deals. Confirmed non-signatory through mid/late-2025 (EC C(2025)7020; EY; e-ΕΦΚΑ Εγκ.33/2024 "αναμένεται να υπογράψει"). **If Greece has signed since (2026), soften the "δεν συγκαταλέγεται" wording.**

### 8. Solidarity strike flat "Επιτρέπεται" overstatement — `symvasi/apergia.md` (~L89)
Only the factual sub-error (notice "24/48 ώρες" → "24 ώρες / 4 ημέρες") was fixed; the flat "Επιτρέπεται" characterization was NOT rewritten (no clean primary quote). A sympathy strike is lawful **only** where strikers have their own connected economic/labour interest (or art.19 §1(b) multinational-dependency). **Qualify with the own-interest test (Ν.1264/1982 art.19 §1).**

---

## MEDIUM (49)

**orario/**
1. `argies.md` — κατ'έθιμον αργία "+30%" has no statutory anchor; prevailing rule for exceptional operation = 1/25 ημερομισθίου + 75%. Replace after ΦΕΚ/hli confirmation.
2. `argies.md` — υποχρεωτική αργία "PLUS αναπληρωματικό ρεπό": αναπληρωματική ανάπαυση is a Sunday/weekly-rest mechanism, not an automatic per-holiday add-on. Move to Sunday subsection; add μισθωτός/ημερομίσθιος distinction.
3. `argies.md` — 26 Δεκ originating law contested (Ν.4468/2017 vs Ν.4554/2018 art.42); not pinned.
4. `vardiakia.md` — Ν.3385/2005 softened to "ρυθμίσεις χρόνου εργασίας"; verify actual scope (ΦΕΚ Α΄210/2005) or drop.
5. `ores-ergasias.md` — minors break "30 min μετά 4,5h" retained on brief authority (ΠΔ 62/1998 art.9 not fetched); primary check recommended (ΚΕΔ art.306).
6. `yperoreis.md` — Sunday ">5h → αναπληρωματική ανάπαυση" cutoff dropped (hli page silent); confirm ΒΔ 748/1966 / Ν.435/1976.
7. `nyxterina.md` — night × Sunday/holiday exact stacking base (additive vs compounded) not in a single primary quote; phrased "each on legal hourly wage".
8. `tilergasia.md` — "15 days" return-to-office notice removed (no primary source); reinstate with citation if a ΣΣΕ/Εργάνη form sets one.
9. `ektos-edras.md` — €50/€100 daily tax-free caps removed (unsupported, misattributed to Α.1138/2022); confirm intent; optionally add public-sector per-diem (Ν.4336/2015) as contrast.
10. `karta-ergasias.md` — card sub-penalties €3.000 / €4.000 / €10.500-non-activation (ΥΑ 49758/2022 art.10) omitted (taxheaven 404); add if verbatim confirmed. Only €10.500/employee (Ν.5053/2023 art.22) asserted.
11. `karta-ergasias.md` — "Location/GPS" softened; confirm whether the mobile-app punch captures location (GDPR framing) before restoring.

**misthos/**
12. `oromisthio.md` — daily overtime cap 4h NOT added here (confirmed in orario batch via Ν.5239/2025); add if desired.
13. `doro-xristougennon.md` / `doro-pasxa.md` — accrual method rewritten to per-19-days / per-8-days (a calculation-logic change, not just a citation fix); **CalculatorTools owner should confirm any downstream calculator matches the per-period rule.**
14. UPSTREAM `CURRENCY-BRIEF.md` §2 — cites Ν.4808/2021 art.62 as a payslip basis while §6 correctly assigns art.62 to unpaid leave (mutually exclusive). Verified payslip basis = Ν.1082/1980 art.18 §1 am. Ν.4254/2014. Correct the brief upstream.

**adeies/**
15. `eidikes-adeies.md` — election-leave distance/day tiers doubtful (ΚΥΑ-set per election); caveat added; replace with current ΚΥΑ tiers.
16. `astheneia.md` — εργατικό ατύχημα "100% ημερομισθίου" left (unconfirmed); tenure-based protected-absence limits (≈1/3/4/6 μ.) NOT asserted; confirm from ΦΕΚ/e-EFKA. (Unverified "12-month suspension" was removed.)
17. `eidikes-adeies.md` — pregnancy/breastfeeding night-work exemption left as automatic; the medical-certificate condition (ΠΔ 176/1997) was NOT added (not fetched). Verify + add.
18. `etisia-adia.md` — οικιακοί μισθωτοί "26 ημ./Ν.4488/2017" and "ΣΕΠΕ πρόστιμο 350–500 €/Ν.4488/2017 art.36" unconfirmed; verify or reframe.
19. `eidiki-adia-mitrotitas.md` — ΚΥΑ 39686/2024 gating wording (forin 403 / elinyae ECONNREFUSED); confirm ΦΕΚ Β΄4099 whether a physical return survives; if so, revert the step-2/docs rewording (category broadening stands regardless).
20. `eidiki-adia-mitrotitas.md` — extension to self-employed / free professionals / farmers (Ν.5078/2023 art.151) SKIPPED; add if confirmed.

**anergia/**
21. `epidoma.md` — reduced-tier 2026 € amounts (~€423,75 / ~€282,50) written as approximate; confirm exact figures + income thresholds on dypa.gov.gr and drop the "~". (Structure HIGH-confirmed; full €564,98 confirmed.)

**ygeia/**
22. `index.md` — "φόρμα Ε1" relabelled to "Δήλωση/Αναγγελία Εργατικού Ατυχήματος" (no e-ΕΦΚΑ form "Ε1"; Ε1 = income-tax return); add a precise form ID only if one exists.
23. `index.md` — Ιατρός Εργασίας "μία φορά τον μήνα" softened (statute = minimum hours, art.21, scaling with headcount×risk); mark any monthly cadence as indicative.

**apolysi/**
24. `omadikes-apolysi.md` — "12-month priority re-hire right" softened to accurate scope (no primary basis for a general binding duty; a 12-mo rule exists only for seasonal tourism, Ν.1346/1983 art.8). Restore only with a house source. (MED-HIGH)
25. `ptoxeisi-ergodoti.md` — "απλήρωτοι μισθοί τελευταίων 6 μηνών" (προνομιούχοι πιστωτές, ΑΚ 975 / Ν.4738/2020) NOT narrowed; verify the exact privileged period.
26. `omadikes-apolysi.md` — "6 ή περισσότεροι" (20–150 firm) trigger vs statute "μέχρι 6" (arguably 7+); settle against ΦΕΚ Ν.1387/1983 art.1.

**asfalisi/**
27. `eisfores.md` — ΔΥΠΑ/λοιπά **3,06%** internal sub-split (ανεργία/ΛΑΕΚ/εργ.κατοικία) unverifiable (kepea 403); the aggregate is arithmetically forced and correct. Expand only from a live ΠΙΝΑΚΑΣ.
28. `efka.md` — ΕΔΟΕΑΠ (δημοσιογράφοι) separateness from e-ΕΦΚΑ (υγεία/επικουρική/πρόνοια) NOT re-verified; add a clarifying clause only if confirmed.

**syntaxi/**
29. `ilikia-syntaxis.md` + `index.md` — Μητέρες ανηλίκων row "always μειωμένη κατά 1/200/μήνα" over-simplifies (full vs reduced depends on έτος θεμελίωσης); reword to "62 / 6.000 ημέρες — πλήρης ή μειωμένη ανάλογα με έτος θεμελίωσης" after e-ΕΦΚΑ.
30. `ilikia-syntaxis.md` — ΒΑΕ "χορηγεί πλασματικά έτη (bonus ημέρες)" likely WRONG (ΒΑΕ = earlier age + προσαύξηση from the βαρέα εισφορά, not bonus days); verify + reword.
31. `ilikia-syntaxis.md` — disability minimum-days omits sliding scale (+120 ημ/έτος από 21ο) + πρόσφατη-ασφάλιση qualifier; enrichment only.

**symvasi/**
32. `syndikalismos.md` — enumerated "grave reasons" for dismissing a protected unionist / committee-abolition NOT rewritten (hli page silent); confirm Ν.1264/1982 art.14 as am. Ν.4808/2021 art.88, then rewrite + cite.
33. `egsee.md` — signatory list (ΣΕΒ may not have signed the latest ΕΓΣΣΕ; add ΣΕΤΕ) NOT verified; scopes the marriage-allowance obligation.
34. `sse.md` — who signs an επιχειρησιακή ΣΣΕ with no enterprise union: "ΓΣΕΕ" is the wrong counterpart (should be κλαδική/ομοιοεπαγγελματική οργάνωση or ένωση προσώπων, Ν.1876/1990 art.6); pin the ένωση-προσώπων quorum.
35. `epochiaki.md` / `xenodoxoipalliloi.md` — hotel re-hire written-notice **deadline not dated** (set by live κλαδική ΣΣΕ ξενοδοχοϋπαλλήλων); confirm before publishing a concrete date. Mechanism statement is safe.
36. `pollapli-apasxolisi.md` — "13-hour combined cap" is a DERIVED figure (11h inviolable rest, ΠΔ 88/1999 art.3 → 24−11=13); Ν.5053/2023 art.9 does not state "13h" verbatim. Also ΚΕΔ art.199 §2 from KED-MAP (not re-fetched).
37. `anangestikes-proslixi.md` — Ν.2643/1998 8% internal per-category sub-split NOT asserted (kodiko/taxheaven paywalled); add from ΦΕΚ.
38. `anangestikes-proslixi.md` — ΚΕΔ 83–93 ↔ Ν.2643/1998 mapping NOT asserted (KED-MAP doesn't map it); cited Ν.2643/1998 art.2 §1 without a ΚΕΔ tag. Confirm from ΦΕΚ Α΄121.
39. `anangestikes-proslixi.md` — public-sector ΑμεΑ **1h/day, no pay cut** applied but primary ypes.gr was 403 (corroborated by 4 legal sources). Pin the exact statutory basis, or decide if this public-sector aside belongs in a private-sector corpus.
40. `anaggelia-proslipsis.md` — essential-terms notice cited as ΚΕΔ arts 70–77 (range per KED-MAP/task); exact sub-article MEDIUM. Pin from ΦΕΚ Α΄121.
41. `vlaptiki-metavoli.md` — "εξαναγκαστική λύση εντός 3 μηνών, μετά τεκμαίρεται αποδοχή" oversimplifies (case law = εύλογος χρόνος; conflates 3-mo δικαστική vs 6-mo severance deadline). Confirm ΑΠ line; reword to "εύλογος χρόνος" + 6-month severance note.
42. `sexualiki-parenoxlisi.md` — ΠΚ 337 §4 ex-officio prosecution NOT asserted (§4 still includes χρηματική ποινή; the έγκληση rule is doctrinally contested). Only the §4 workplace pinpoint applied. Settle from consolidated ΠΚ 337 (Ν.4619/2019 as in force).
43. `oikiakoi-misthwtoi.md` — "26 εργάσιμες ημέρες (Ν.4488/2017)" NOT verified; likely the ordinary α.ν.539/1945 6-day entitlement, not a Ν.4488/2017 grant. Verify or reframe.
44. `oikiakoi-misthwtoi.md` — working-time / Sunday-holiday / weekly-rest exclusion of live-in (οικόσιτο) domestic staff NOT added (a real protection gap); add once primary-confirmed.
45. `strateysi.md` — "suspension months count toward severance seniority" (+9-μήνα example) overstated; pre-service seniority IS preserved (Ν.3514/1928), but whether the service months themselves count is contested. Confirm ΑΠ line, soften.
46. `strateysi.md` — ">6-month service" precondition / reservist scope NOT asserted (would narrow a protection); pin the threshold from Ν.3514/1928.
47. `thanatos-ergodoti.md` — προσωποπαγής (personal-service) exception (death dissolves a person-dependent contract; heirs may owe reasonable compensation) NOT added (no crisp primary source). Add with a verbatim source. (MED-HIGH) The core fix ΑΚ 1847→1846+1901 was applied.
48. `diathesimotita.md` — "εισφορές ΕΦΚΑ υπολογίζονται επί του 50%" NOT confirmed against a primary source; verify vs e-ΕΦΚΑ.

**New articles / corpus-wide**
49. `[[Εισφορές]]` corpus-wide link (target title is **"Ασφαλιστικές Εισφορές"**, `asfalisi/eisfores.md`; the Greek text matches neither title nor the Latin slug `eisfores`). Pre-existing convention on category hubs (asfalisi/index, anergia/index & epidoma). **Decide corpus-wide: add `aliases: [Εισφορές]` to `asfalisi/eisfores.md` frontmatter (cleanest — WikiService already indexes aliases) OR bulk-convert every `[[Εισφορές]]` to `[[Ασφαλιστικές Εισφορές|Εισφορές]]`. Do NOT do it piecemeal.** (Note: separate from the 2 genuinely-dead links in the integrity audit — see report.)

---

## LOW / cosmetic (77)

**misthos-core:** (1) `katotatos-misthos.md` triennia not tagged "κωδικοποιημένο στον ΚΕΔ" (KED-MAP excludes the min-wage regime); confirm if codified. (2) `ekkatharistiko.md` ΑΚ 656 (μισθός υπερημερίας) not re-added (lawspot 404). (3) `ekkatharistiko.md` ΕΦΚΑ 13,37% is total only — no per-branch table without e-EFKA εγκ.4/2026 [info]. (4) `ekkatharistiko.md` exact ΚΕΔ article for payslip unconfirmed (generic pointer used).
**misthos-extras:** (5) ΚΥΑ 19040/1981 internal date discrepancy (Β΄742 consistent). (6) no ΚΕΔ tag on δώρα/επιδόματα (no KED-MAP row). (7) `epidoma-gamou.md` "εξαρτώμενα τέκνα" trigger dropped (conflation). (8) `epidoma-anthygieinis.md` %ranges (10–15/15–25) hedged as illustrative.
**orario:** (9) `argies.md` holiday count applied as 9 (one mirror printed "10" while listing 9). (10) `argies.md` store-opening Sundays 2026 count not asserted (7 vs 8). (11) `vardiakia.md` shift premium "15–25%" ΣΣΕ-dependent (accurate as framed). (12) ΚΕΔ article numbers (194/171/173/176/150/202/189; 130; 580–581) on KED-MAP authority — optional spot-check vs ΦΕΚ Α΄121.
**adeies:** (13) `eidikes-adeies.md` conscript re-employment "1 μήνα" figure/basis unconfirmed. (14) carer's leave (art.29) "άνευ αποδοχών" corroborated, pay clause not re-fetched. (15) residual "ΣΕΠΕ"/"sepe.gr" in etisia-adia/astheneia/adia-gamos/apozimiossi-adias not swept (apozimiossi-adias under do-not-change). (16) `adia-gamos.md` marriage 6/5 & school-monitoring ≤4 confirmed OK, unchanged. (17) `mitrotita.md` e-EFKA benefit "ίσο με ημερήσιο μισθό" left (computed on ασφ. κλάση); reword. (18) `goniki-adia.md` prior age-limit generalized ("χαμηλότερο"); restore 6 έτη (Ν.4075/2012) once confirmed. (19) father-transfer finer procedure (1-mo notice; ΥΑ 47360/2023) not added. (20) **KED-MAP paternity originating law art.26→art.27 — FIXED this pass (row 29).** (21) maternity 18-month dismissal protection has no KED-MAP article (cited Ν.4808/2021 art.48 + generic pointer).
**anergia:** (22) `epidoma.md` ΥΑ 42429/2022 basis unconfirmed (not edited); verify or drop. (23) `index.md` new-benefit pointer not added (pilot ended 30.6.2026). (24) "80 ημέρες/έτος" attached to the 200-day route only; confirm from Ν.1545/1985 arts 3-4.
**ygeia:** (25) `kapnisma.md` frontmatter tag still "ΣΕΠΕ" (body fixed). (26) `index.md` heat-stress WBGT/°C thresholds omitted; cite current καύσωνας circular if precise index wanted. (27) `index.md` "24 ώρες ημερολογιακές" gloss dropped. (28) `index.md` "ΑΜΠ" vs standard "ΜΑΠ" acronym left. (29) `index.md` ΑΚ 932 (ηθική βλάβη/ψυχική οδύνη) enhancement not added.
**apolysi:** (30) `apozimiossi.md` frontmatter tags edited despite preserve rule (correctness fix; revert if frozen). (31) `apozimiossi.md` Ν.3863/2010 art.74 cite removed; gap = add "Τμηματική καταβολή" (>2 μισθών → δόσεις) then re-add. (32) `apozimiossi.md` ΕΡΓΑΝΗ αναγγελία tied to Ν.5053/2023 art.23; E6 dismissal-notification predates it — split citation if precise attribution wanted. (33) `foros-apozimiossi.md` επίδομα αδείας ΕΦΚΑ ceiling kept generic (do not hard-code stale €6.500; 2026 = €7.761,94). (34) `apozimiossi.md` first-12-months no-severance now also aligns with Ν.5053/2023 art.19; cross-cite optional. (35) `adiki-apolysi.md` art.14 §10 grave-grounds enumeration generalized; re-add verified list. (36) `adiki-apolysi.md` enacted amending article (art.87 vs 88) dropped; confirm ΦΕΚ Α΄101/2021. (37) `ptoxeisi-ergodoti.md` deadline-lapse wording kept soft; frontmatter tag still "Ν.3863/2010". (38) `epischesi-ergasias.md` ΑΚ 325 gloss loose (paraphrases ΑΚ 374); citation correct. (39) deemed-resignation genuine-resignation "4-working-day ΕΡΓΑΝΗ" declaration dropped (unconfirmed).
**asfalisi:** (40) `index.md` relabel "ΕΦΚΑ"→"e-ΕΦΚΑ" + add wikilinks Εργάνη/Εργόσημο/Τεκμαρτό. (41) `tekmarto-imeromisthio.md` specific class €/numbers omitted (annual; cite e-ΕΦΚΑ Εγκ.11/2025). (42) `ergani.md` card-expansion ΥΑ 24595/2024 & 18047/2026 not appended (both real/current).
**syntaxi:** (43) `ilikia-syntaxis.md` ΒΑΕ occupation list hedged as "Τυπικές" (authoritative = ΚΒΑΕ πίνακας ΥΑ Φ10221/οικ.26816/929/2011). (44) €446,86 vs €446,87 rounding — used €446,86 throughout [immaterial]. (45) `ilikia-syntaxis.md` working-pensioner non-declaration penalty & 7,7+2,3 split of 10% omitted (unconfirmed). (46) ΒΑΕ alt category (10.500/7.500) & extra εξαγορά heads (απεργία, μάχιμη πενταετία) omitted.
**symvasi-collective:** (47) `apergia.md` "πεχτρέβα" term unverifiable; relabel to "λευκή απεργία/απεργία κανονισμών" + contested-status note. (48) `egsee.md` "Επίδομα τέκνων" as current ΕΓΣΣΕ benefit unverifiable; confirm/delete. (49) `sse.md`/`index.md` ΟΜΕΔ "τηρεί αρχείο ΣΣΕ" imprecise (registry = Υπ. Εργασίας). (50) `syndikalismos.md` "Ν.1264/1982 art.7 (δικαίωμα εγγραφής)" pinpoint unverified. (51) `sse.md` Ν.4808/2021 art.97/art.8 binding-scope amendment number not isolated-ΦΕΚ-confirmed (extension side IS). (52) several symvasi frontmatter `tags:` retain "ΣΕΠΕ"/"Ν.4808/2021" (preserve rule).
**symvasi-contracts:** (53) `orismenu.md` append "(και Ν.3986/2011 art.41)" to ΠΔ 81/2003 chain. (54) `aoristu.md` no ΚΕΔ number for first-12-months rule (art.325A of π.δ. 80/2022, recodified). (55) `prosorini-apasxolisi.md` strike-break "art.115" omitted; check Ν.5302/2026 (UNVERIFIABLE) didn't touch arts 113–133. (56) `pollapli-apasxolisi.md` e-EFKA ceiling / ≤3-employers detail not added (belongs to asfalisi).
**symvasi-hiring-docs:** (57) ΚΕΔ "κωδικοποιημένο" pointer added selectively (ΝΔ 3789/1957 only). (58) `vivlia-ergodoti.md` "Ειδικό Βιβλίο Υπερωριών" (reinstated) used; refine if a newer instrument governs. (59) `vivlia-ergodoti.md` Μισθολόγιο subsection has no statutory cite (wikilink to ekkatharistiko.md preferred). (60) `anaggelia-proslipsis.md` intro Ν.3996/2011 framing + generic "ergani.gov.gr" URL (current = ΕΡΓΑΝΗ ΙΙ/myErgani).
**symvasi-protections:** (61) `vlaptiki-metavoli.md` ΑΠ 1434/2019 & ΑΠ 1083/2018 unverifiable (existence/relevance). (62) `mobbing.md` "3.000–30.000€" ΑΚ 932 range unverifiable (illustrative). (63) `sexualiki-parenoxlisi.md` Ν.4604/2019 narrow title label. (64) `isi-metaxeirisi.md` exact repealing article of Ν.4443/2016 over Ν.3304/2005 not pinned (full repeal confirmed). (65) `parenoxlisi-egkyou.md` father-6-month protection figure not asserted (subscription source). (66) mobbing/sexualiki/isi-metaxeirisi/vlaptiki frontmatter `tags:` retain "ΣΕΠΕ".
**symvasi-sector:** (67) `aniliki.md` minor exam-leave day-counts (2/day, ≥14/yr, unpaid) not asserted. (68) `aniliki.md` "Ν.3144/2003" label mischaracterises the title (defensible cite). (69) `oikodomoi.md` ΒΑΕ alternative full-career category (10.500/7.500) not added. (70) sector "ΣΕΠΕ" tags/wikilinks left (corpus-wide pass).
**symvasi-status:** (71) `anastoli.md` ΚΕΔ 255 unpaid-leave pointer conflict (art.50 vs art.62) — **RESOLVED this pass** (KED-MAP row 40 fixed to art.62); the ΚΕΔ 255 pointer may now be added. (72) `anastoli.md` βραχεία-ασθένεια dual citation (Ν.4558/1930 art.3 + Ν.3986/2011 art.40) — intentional/resolved. (73) `diathesimotita.md` frontmatter tag "ΣΕΠΕ" left.
**new articles:** (74) `adeies/penthos.md` primary beneficiary list also includes "φροντιστές" (omitted); optional add. (75) `adeies/penthos.md` frontmatter tags cite ΕΓΣΣΕ but not Ν.5018/2023 (cosmetic). (76) `adeies/anoteras-vias.md` force-majeure "no seniority" claim consistent with art.30 but not verbatim in CURRENCY-BRIEF; confirm from full ΦΕΚ. (77) syntaxi new articles — minor unsourced procedural details (efapax 6-month deadline / αναπηρία-≥50% priority / 4%-from-2017; syntaxi-thanatou "γάμος μετά συνταξιοδότηση" 1–5%/έτος scale; epikouriki-teka born-≥2004 mandatory clause inferred). All plausible, not refuted.

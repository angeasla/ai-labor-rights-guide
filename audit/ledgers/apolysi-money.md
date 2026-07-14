# AUDIT LEDGER — Batch `apolysi-money`

**Auditor role:** εργατολόγος (Greek labour lawyer), pro-worker.
**Date:** 2026-07-13
**Files:** `src/main/resources/docs/apolysi/apozimiossi.md`, `.../foros-apozimiossi.md`
**Method:** every checkable claim extracted → verified vs CURRENCY-BRIEF §7 **and** fresh primary/authoritative fetch (hli.gov.gr, ypergasias.gov.gr, lawspot.gr ΦΕΚ mirror, e-forologia.gr, foroline.gr). kepea.gr = HTTP 403 (per brief), routed around.

**Bottom line:** `apozimiossi.md` is the worst offender in the whole corpus for fabricated numbers — the entire "two-regime" structure (Ν.3863/2010 vs Ν.2112/1920, split on 17/6/2010) is **invented**. There is ONE scale, max **12 months**, for everyone. `foros-apozimiossi.md` tax scale is **correct**, but it carries two real errors: an ΕΦΚΑ mistake on leave-compensation and the same bogus "17-year" retirement rule.

---

## Sources consulted (verbatim anchors)

| # | Source | URL | Used for |
|---|---|---|---|
| S1 | Lawspot — Ν.2112/1920 άρθρο 3 (ΦΕΚ mirror) | https://www.lawspot.gr/nomothesia/n-2112-1920/arthro-3-nomos-2112-1920/ | Full severance scale (max 12 @ 16 yrs) |
| S2 | Foroline — πίνακες αποζημίωσης | https://foroline.gr/archives/22225 | With/without-notice columns, +1/6 uplift, 12.11.2012/€2.000 rule |
| S3 | ypergasias.gov.gr — Λύση Σύμβασης Εργασίας (Υπ. Εργασίας) | https://ypergasias.gov.gr/ergasiakes-scheseis/atomikes-ergasiakes-sxeseis/lysi-symvasis-ergasias/ | Half-with-notice rule |
| S4 | hli.gov.gr — Αποζημίωση Απόλυσης (Επιθ. Εργασίας) | https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/atomikes-symvaseis/symvasi-aoristou-chronou/apozimiosi-apolysis/ | Scale, cap, €2.000/17-yr transitional |
| S5 | Lawspot — Ν.3198/1955 άρθρο 5 (ΦΕΚ mirror) | https://www.lawspot.gr/nomothesia/n-3198-1955/arthro-5-nomos-3198-1955/ | Salary cap (8× ημερομίσθιο × 30) |
| S6 | VlachopoulosLaw — αποζημίωση λόγω συνταξιοδότησης | https://vlachopouloslaw.gr/apozimiosi-logo-syntaxiodotisis/ | 40%/50% retirement rule (Ν.3198/1955 art.8) |
| S7 | VlachopoulosLaw — κατάργηση διάκρισης υπ./εργατ. | https://vlachopouloslaw.gr/katargisi-diakrisis-metaxy-ypallilon-kai-ergatotechniton/ | Ν.4808/2021 **art.64**, 1.1.2022 |
| S8 | WebSearch synthesis (taxheaven/hli/kepea) — προθεσμία προειδοποίησης | (taxheaven.gr/circulars/19819 et al.) | Notice periods 1/2/3/4 mo, cap 4 |
| S9 | Lawspot — Ν.4172/2013 άρθρο 15 (ΦΕΚ mirror) | https://www.lawspot.gr/nomikes-plirofories/nomothesia/n4172-2013/arthro-15-nomos-4172-2013 | Severance tax scale (§3) |
| S10 | e-forologia — αποδοχές/αποζημίωση αδείας & εισφορές | https://www.e-forologia.gr/cms/viewContents.aspx?id=218998 | Leave-comp NOT subject to ΕΦΚΑ on termination |

---

# FILE 1 — `apolysi/apozimiossi.md`

**Verdict tally:** WRONG ×6 · IMPRECISE ×2 · OK ×6 · GAP ×1

---

### A1 — "Two regimes" framing (Ν.3863/2010 "new" vs Ν.2112/1920 "old", split 17/6/2010) — **WRONG (FABRICATED)**

**Snippet (verbatim, lines 14–33):**
> ## Δύο καθεστώτα — ποιο σε αφορά
> ### Νέο καθεστώς (Ν. 3863/2010)
> Για εργαζόμενους που **προσλήφθηκαν μετά την 17/6/2010**: [πίνακας με ανώτατο 6 μηνιαίους μισθούς]
> ### Παλαιό καθεστώς (Ν. 2112/1920)
> Για εργαζόμενους **πριν από 17/6/2010**, το ανώτατο φτάνει τους 12 μηνιαίους μισθούς για πάνω από 20 έτη

**Why wrong:** No such split exists. There is **one** severance scale (Ν.2112/1920 as amended by Ν.4093/2012) applied to **all** employees regardless of hire date. Max = **12 months**, reached at **16 completed years** — not 6 months, not "20+/25–30 years". The only date that matters is **12.11.2012** (Ν.4093/2012), and it governs a *transitional accrued-rights* rule keyed to length of service, **not** hire date. "17/6/2010" and the "6-month new regime" are inventions.

**Replacement — delete both regime tables and the intro, replace with the single scale (without notice = full; with notice = half):**

| Χρόνια υπηρεσίας (συμπληρωμένα) | Χωρίς προειδοποίηση (πλήρης) | Με προειδοποίηση (½) |
|---|---|---|
| Κάτω από 12 μήνες | Καμία | Καμία |
| 1 έτος – 4 έτη | 2 μηνιαίοι μισθοί | 1 |
| 4 – 6 έτη | 3 | 1,5 |
| 6 – 8 έτη | 4 | 2 |
| 8 – 10 έτη | 5 | 2,5 |
| 10 έτη συμπλ. | 6 | 3 |
| 11 έτη | 7 | 3,5 |
| 12 έτη | 8 | 4 |
| 13 έτη | 9 | 4,5 |
| 14 έτη | 10 | 5 |
| 15 έτη | 11 | 5,5 |
| **16 έτη και άνω** | **12 (ανώτατο)** | **6** |

**Legal basis:** Ν.2112/1920 άρθρο 3· Ν.4093/2012 (υποπαρ. ΙΑ.12, ΦΕΚ Α΄222/12.11.2012)· half-with-notice = Ν.3198/1955 άρθρο 5.
**Verbatim (S1, Ν.2112/1920 art.3):** *"ΠΙΝΑΚΑΣ ΑΠΟΖΗΜΙΩΣΕΩΝ ΥΠΑΛΛΗΛΩΝ … 1–4 έτη συμπληρωμένα → 2 μηνών … 16 έτη συμπληρωμένα και άνω → 12 μηνών (ανώτατο)"* — max 12 months at 16 years, no hire-date split.
**Confidence:** HIGH.

---

### A2 — Blue/white-collar unification credited to Ν.4093/2012 — **WRONG LAW**

**Snippet (verbatim, lines 52–55):**
> Η διάκριση μεταξύ **υπαλλήλων** (λευκά κολάρα) και **εργατοτεχνιτών** (μπλε κολάρα) καταργήθηκε με τον Ν. 4093/2012 — και οι δύο κατηγορίες χρησιμοποιούν πλέον τον ίδιο πίνακα του Ν. 3863/2010.

**Why wrong:** The υπάλληλος/εργατοτεχνίτης distinction in dismissal/severance was abolished by **Ν.4808/2021 άρθρο 64**, effective **1.1.2022** — not Ν.4093/2012. And the shared table is the Ν.2112/1920 scale, **not** a "Ν.3863/2010 table" (which doesn't exist as described).

**Replacement:**
> Η διάκριση μεταξύ **υπαλλήλων** και **εργατοτεχνιτών** ως προς την αποζημίωση απόλυσης καταργήθηκε με το **άρθρο 64 του Ν. 4808/2021** (ισχύς από **1.1.2022**). Πλέον ισχύει ενιαία η κλίμακα του Ν. 2112/1920 για όλους· για τους εργατοτεχνίτες, ο μηνιαίος μισθός υπολογίζεται ως **22 ημερομίσθια** (εφόσον δεν αμείβονται ήδη με μηνιαίο μισθό).

**Legal basis:** Ν.4808/2021 άρθρο 64.
**Verbatim (S7):** *"Με βάση τη διάταξη του άρθρου 64 του ν. 4808/2021 … από την 1η Ιανουαρίου 2022"*; brief §7 confirms "1 month = 22 ημερομίσθια".
**Confidence:** HIGH.

---

### A3 — Notice-period table goes up to 6 months — **WRONG (cap is 4 months)**

**Snippet (verbatim, lines 67–76):**
> ### Προθεσμίες προειδοποίησης (νέο καθεστώς)
> | 12 μήνες – 2 έτη | 1 μήνας |
> | 2–5 έτη | 2 μήνες |
> | 5–10 έτη | 3 μήνες |
> | 10–15 έτη | 4 μήνες |
> | 15–20 έτη | 5 μήνες |
> | 20+ έτη | 6 μήνες |

**Why wrong:** The last two rows are fabricated. Notice (προθεσμία προειδοποίησης) is **capped at 4 months** for 10+ years (Ν.3899/2010, retained by Ν.4093/2012). There is no 5- or 6-month tier.

**Replacement:**

| Χρόνια υπηρεσίας | Απαιτούμενη προθεσμία |
|---|---|
| 12 μήνες συμπλ. – 2 έτη | 1 μήνας |
| 2 – 5 έτη | 2 μήνες |
| 5 – 10 έτη | 3 μήνες |
| **10 έτη και άνω** | **4 μήνες (ανώτατο)** |

**Legal basis:** Ν.2112/1920 άρθρο 1 όπως τροπ. Ν.3899/2010 άρθρο 17 §5.
**Verbatim (S8):** *"από δέκα (10) έτη συμπληρωμένα και άνω απαιτείται προειδοποίηση **τεσσάρων (4) μηνών** πριν την απόλυση"* (bands 1/2/3/4 mo).
**Confidence:** HIGH. (Note: two automated table-scrapes of ypergasias/aftodioikisi mis-read the halved-severance column, which runs …→6, as "notice"; the textual sources are unambiguous that notice caps at 4.)

---

### A4 — Calculation base omits the +1/6 uplift — **IMPRECISE**

**Snippet (verbatim, line 80):**
> Η αποζημίωση υπολογίζεται επί του **τελευταίου μισθού** (μεικτός).

**Why imprecise:** The base is the **regular earnings of the last month (full-time)**, **increased by 1/6** (= ×14/12) to embed the pro-rata Christmas/Easter bonuses and επίδομα αδείας. Omitting the 1/6 understates every payout by ~16,7%.

**Replacement:**
> Η αποζημίωση υπολογίζεται επί των **τακτικών αποδοχών του τελευταίου μήνα** (μεικτές, με καθεστώς πλήρους απασχόλησης), **προσαυξημένων κατά 1/6** — δηλ. συνυπολογίζονται αναλογικά τα δώρα εορτών και το επίδομα αδείας (×14/12).

**Legal basis:** Ν.2112/1920 άρθρο 3· πάγια νομολογία (τακτικές αποδοχές + 1/6).
**Verbatim (S2):** *"…including festival bonuses and vacation allowances plus 1/6 monthly salary."*
**Confidence:** HIGH.

---

### A5 — Salary cap "8× minimum wage" — **IMPRECISE / WRONG NUMBER**

**Snippet (verbatim, lines 80–82):**
> Υπάρχει ανώτατο όριο (cap): μισθός πάνω από **8 φορές τον κατώτατο** δεν προσμετράται.

**Why wrong:** The statutory cap is **8 × the daily wage of an unskilled worker (ημερομίσθιο ανειδίκευτου εργάτη) × 30** — not 8× the monthly minimum salary. With the 2026 ημερομίσθιο **€41,09** → cap = 8 × 41,09 × 30 = **€9.861,60/μήνα** (2025: 8 × 39,30 × 30 = €9.432). "8× the €920 minimum" would give €7.360, understating the cap by ~25%. The capped figure is **not** further increased by the 1/6 uplift.

**Replacement:**
> Υπάρχει ανώτατο όριο: οι μηνιαίες αποδοχές που λαμβάνονται υπόψη **δεν υπερβαίνουν το οκταπλάσιο του ημερομισθίου του ανειδίκευτου εργάτη επί 30** (Ν. 3198/1955 άρθρο 5). Για το 2026 (ημερομίσθιο €41,09): 8 × 41,09 × 30 = **€9.861,60/μήνα**. Το ποσό αυτό δεν προσαυξάνεται με το 1/6.

**Legal basis:** Ν.3198/1955 άρθρο 5 §1 εδ. β΄.
**Verbatim (S5):** *"αι μηνιαίαι αυτού αποδοχαί δεν λαμβάνονται υπ' όψει καθ' ο ποσόν υπερβαίνουν το **οκταπλάσιον του ημερομισθίου ανειδικεύτου εργάτου, πολλαπλασιαζόμενον επί τον αριθμόν 30**"*.
**Confidence:** HIGH.

---

### A6 — Retirement severance "50% ≤17 yrs / full >17 yrs" — **WRONG (FABRICATED THRESHOLD)**

**Snippet (verbatim, lines 100–110):**
> ## Αποζημίωση λόγω συνταξιοδότησης
> - Έως 17 έτη υπηρεσίας: **50%** της κανονικής αποζημίωσης απόλυσης
> - Πάνω από 17 έτη υπηρεσίας: **πλήρης** αποζημίωση απόλυσης

**Why wrong:** No "17-year" retirement threshold exists (it is a bleed-over confusion with the 12.11.2012/17-yr transitional rule for regular dismissals). The retirement reduction is keyed to **auxiliary insurance**, not years: an employee who meets **full old-age pension** conditions — whether leaving voluntarily or dismissed under this provision — gets **40%** (if covered by επικουρική/auxiliary insurance) or **50%** (if not) of the *without-notice* severance. Separately, an employee with **15 years** at the same employer who leaves **with the employer's consent** gets **50%**.

**Replacement:**
> Όταν ο εργαζόμενος **συμπληρώνει τις προϋποθέσεις πλήρους σύνταξης γήρατος** και αποχωρεί (οικειοθελώς ή απολυόμενος βάσει της διάταξης αυτής), δικαιούται **μειωμένη** αποζημίωση:
> - **40%** της αποζημίωσης απόλυσης (χωρίς προειδοποίηση), αν είναι ασφαλισμένος και σε **επικουρικό** ταμείο·
> - **50%**, αν **δεν** έχει επικουρική ασφάλιση.
>
> Χωριστά: μισθωτός με **15ετία** στον ίδιο εργοδότη που αποχωρεί **με τη συγκατάθεση** του εργοδότη δικαιούται **50%**.

**Legal basis:** Ν.3198/1955 άρθρο 8 (εδ. α΄ & β΄).
**Verbatim (S6):** *"…λαμβάνοντας το **40% της νόμιμης αποζημίωσης** απόλυσης εάν έχουν επικουρική ασφάλιση και το **50% εάν δεν έχουν**"*; *"15ετή υπηρεσία στον ίδιο εργοδότη … με τη συγκατάθεση του εργοδότη … 50%"*; *"no reference to a 17-year threshold providing full severance."*
**Confidence:** HIGH.

---

### A7 — Missing 12.11.2012 / €2.000 transitional rule — **GAP (supporting fix for A1)**

The file replaces the real transitional rule with the fake "17/6/2010 old regime". Add:
> **Μεταβατικό δικαίωμα:** Όσοι στις **12.11.2012** είχαν ήδη συμπληρώσει **πάνω από 17 έτη** υπηρεσίας διατηρούν επιπλέον **1 μήνα ανά επιπλέον έτος** πέραν των 17 (έως 12 επιπλέον, δηλ. έως 24 μήνες συνολικά), υπολογιζόμενο **μόνο** στο τμήμα του μισθού **έως €2.000**.

**Legal basis:** Ν.4093/2012 (υποπαρ. ΙΑ.12).
**Verbatim (S4/S2):** *"For employees with 17+ years as of 12-11-2012 … το πλαφόν των 2.000 ευρώ"*.
**Confidence:** HIGH.

---

### apozimiossi.md — verified **OK** (no change)

| Claim | Verdict | Note |
|---|---|---|
| "Με προειδοποίηση: αποζημίωση = **50%**" (lines 62–65) | **OK** | Correct half-with-notice rule (Ν.3198/1955 art.5); confirmed S3 *"μειώνεται στο ½"*. |
| Severance **not** subject to ΕΦΚΑ (line 98) | **OK** | Correct. |
| Tax scale 0/10/20/30% @ 60k/100k/150k (lines 89–94) | **OK** | Confirmed S9 — see F1 below. (Cite art.15 **§3**.) |
| Αποζημίωση μη ληφθείσας άδειας = separate claim, owed even on resignation (lines 112–119) | **OK** | Correct in substance. |
| Non-seizure / no advance-waiver / assignment only in writing after dismissal (lines 121–129) | **OK** | Correct in substance (protective, mandatory-law character). |
| 5-year prescription, ΑΚ 250 (lines 131–137) | **OK** | Correct for the *payment* claim. (Distinct from the 3-mo deadline to contest an unfair dismissal — that lives in `adiki-apolysi.md`.) |

**Minor terminology (optional):** line 59 calls no-notice dismissal *"αδρανής απόλυση"* — non-standard; the legal term is **"άτακτη καταγγελία"**. Line 155 cites *"Ν.3863/2010 … (άρθρο 74)"* as basis for the fake new regime: the law/article is real (it reshaped notice/installments) but does **not** support a 6-month cap or hire-date split — drop or reframe.

---

# FILE 2 — `apolysi/foros-apozimiossi.md`

**Verdict tally:** WRONG ×2 · OK ×9

---

### F1 — Severance tax scale — **OK** (verify, no change)

**Snippet (verbatim, lines 15–22):**
> | Έως €60.000 | 0% | | €60.001 – €100.000 | 10% | | €100.001 – €150.000 | 20% | | Άνω των €150.000 | 30% |
> …αποζημίωση €80.000 φορολογείται: €60.000 × 0% + €20.000 × 10% = **€2.000 φόρος**.

**Verdict:** **OK.** Marginal/autonomous scale is exactly right; the €80.000 → €2.000 worked example is correct.
**Legal basis:** Ν.4172/2013 **άρθρο 15 §3** (autonomous, εξαντλείται η φορολογική υποχρέωση).
**Verbatim (S9):** *"=£60.000 → 0% · 60.000,01–100.000 → 10% · 100.000,01–150.000 → 20% · >150.000 → 30%"*.
**Refinement (not an error):** cite the paragraph — **άρθρο 15 §3** — in the header (line 13) and in Νομοθεσία (line 79), currently just "άρθρο 15".
**Confidence:** HIGH.

---

### F2 — Αποζημίωση μη ληφθείσας άδειας "υπόκειται σε εισφορές ΕΦΚΑ" — **WRONG**

**Snippet (verbatim, lines 51–55 and table line 67):**
> Αν κατά την αποχώρησή σου σου οφείλονται ημέρες ετήσιας άδειας που δεν πήρες … Επίσης υπόκειται σε **εισφορές ΕΦΚΑ**.
> Η αποζημίωση άδειας **δεν** απαλλάσσεται από ασφαλιστικές εισφορές — λεπτομέρεια που τα αφεντικά σπάνια διευκρινίζουν.
> | Αποζημίωση μη ληφθείσας άδειας | Όχι — κανονικό εισόδημα | **Ναι** |

**Why wrong:** When the employment relationship is **terminated**, the compensation for untaken leave (**αποδοχές μη ληφθείσας αδείας**) is **NOT** subject to ΕΦΚΑ contributions — the contribution rule of Ν.1846/1951 applies only *while the relationship subsists*. The **income-tax** treatment the file states (regular employment income, normal scale) is **correct**; only the ΕΦΚΑ leg is inverted. Nuance to preserve: the accompanying **επίδομα αδείας** portion **is** subject to contributions.

**Replacement (lines 51–55):**
> Αν κατά την αποχώρησή σου σου οφείλονται ημέρες ετήσιας άδειας που δεν πήρες, η αντίστοιχη αποζημίωση φορολογείται **ως εισόδημα από εργασία** (κανονική κλίμακα, όχι αυτοτελής). Επειδή όμως καταβάλλεται **λόγω λύσης** της σχέσης, **δεν υπόκειται σε εισφορές ΕΦΚΑ** (σε αντίθεση με τις αποδοχές άδειας που λαμβάνεις όσο εργάζεσαι). Εξαίρεση: το αναλογούν **επίδομα αδείας** υπόκειται σε εισφορές.

**Replacement (table line 67):**
> | Αποζημίωση μη ληφθείσας άδειας | Όχι — κανονικό εισόδημα | **Όχι** (πλην του επιδόματος αδείας) |

**Legal basis:** Ν.1846/1951 άρθρα 2 §2 & 8 §2 (εισφορές μόνο εν ενεργεία σχέσει)· Γεν. Έγγραφα ΙΚΑ 150743/1953, 222697/Φ.Ε.219/1977, Γ99/1/112/5.6.2012· επίδομα αδείας: Ν.1846/1951 άρθρο 25 §4.
**Verbatim (S10):** *"Αποζημίωση Μη Ληφθείσας Άδειας … **NOT subject to ΕΦΚΑ** … 'μόνο σε περίπτωση που διαρκεί η σχέση εργασίας και όχι … που αυτή έχει λυθεί' … Επίδομα Αδείας … **IS subject to ΕΦΚΑ**."*
**Confidence:** MEDIUM-HIGH. (Well-settled ΙΚΑ/ΕΦΚΑ position confirmed by two accounting-law sources + statutory reasoning; a militant reading should still frame it as "employer must not over-withhold contributions from your leave compensation.")

---

### F3 — Retirement-severance "50% for <17 years" — **WRONG** (same defect as A6, in tax file)

**Snippet (verbatim, line 41):**
> …ακόμα και αν είναι μειωμένη (**50% για λιγότερο από 17 χρόνια** υπηρεσίας).

**Why wrong:** Same fabricated 17-year threshold as A6. The reduction is **40% (with επικουρική) / 50% (without)**, keyed to auxiliary insurance, not to 17 years. The file's actual tax point — that reduced retirement severance is still taxed on the **same** autonomous 0–30% scale — is **correct**; only the parenthetical is wrong.

**Replacement (line 41):**
> …ακόμα και αν είναι μειωμένη (**40% ή 50%** ανάλογα με το αν υπάρχει επικουρική ασφάλιση — βλ. [[Αποζημίωση Απόλυσης]]).

**Legal basis:** Ν.3198/1955 άρθρο 8. **Confidence:** HIGH.

---

### foros-apozimiossi.md — verified **OK** (no change)

| Claim | Verdict |
|---|---|
| Autonomous taxation, lower/progressive, often zero (lines 9, 11) | **OK** |
| Marginal application "μόνο στο τμήμα που υπερβαίνει" + €80k example (line 22) | **OK** |
| Tax applied on the amount **after** the salary cap (line 24) | **OK** |
| Severance & retirement severance **not** subject to ΕΦΚΑ (lines 28, 65–66) | **OK** |
| Employer withholds at source, remits to ΑΑΔΕ, βεβαίωση αποδοχών owed (lines 30–37) | **OK** |
| Autonomous tax ⇒ amount **not added** to annual income for other tax (line 37) | **OK** |
| Retirement severance taxed on the **same** 0–30% scale (line 41) | **OK** (tax point; 17-yr parenthetical fixed in F3) |
| Αποδοχές άδειας (taken **while employed**) = normal income + ΕΦΚΑ (lines 45–47) | **OK** |
| Αναλογικά δώρα εορτών at termination = normal income + ΕΦΚΑ (lines 57–59) | **OK** |

---

## Cross-file notes / gaps (not errors, worth Phase-D)

- **Validity conditions** absent from both files: dismissal is valid only with **written form + payment of severance** (Ν.3198/1955 άρθρο 5), plus **ΕΡΓΑΝΗ αναγγελία** (Ν.5053/2023 άρθρο 23); **deemed resignation** after 5 days' unjustified absence (Ν.5053/2023). Worth a short section in `apozimiossi.md`.
- **First-12-months rule:** `apozimiossi.md` correctly says "<12 μήνες → καμία", which now also aligns with Ν.5053/2023 άρθρο 19 (no notice/severance in the first 12 months). Could cite it.
- **Installment payment:** severance over 2 monthly salaries is paid part-upfront + bimonthly installments (Ν.3863/2010 art.74 §3) — not mentioned; minor gap.

---

## Summary for parent

- **apozimiossi.md:** 6 WRONG (fabricated two-regime tables, wrong unification law, notice up-to-6, fabricated retirement 17-yr rule) + 2 IMPRECISE (base uplift, salary cap) + 1 GAP + 6 OK.
- **foros-apozimiossi.md:** tax scale **CORRECT**; 2 WRONG (leave-comp ΕΦΚΑ inverted; 17-yr retirement parenthetical) + 9 OK.
- Highest priority: rebuild the single Ν.2112/1920+Ν.4093/2012 scale (max **12 mo @ 16 yrs**), fix unification → **Ν.4808/2021 art.64**, cap notice at **4 mo**, fix retirement → **40%/50% επικουρική**, correct the leave-comp ΕΦΚΑ statement.

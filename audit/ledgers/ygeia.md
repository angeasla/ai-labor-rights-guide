# LEDGER — ygeia/ health & safety fact-check

**Scope.** 2 files: `ygeia/index.md` (H&S hub — work accidents, ιατρός εργασίας, τεχνικός ασφαλείας,
ΕΥΑΕ, καύσωνα, right to refuse), `ygeia/kapnisma.md` (workplace smoking ban).
**Date:** 2026-07-13. **Method:** every checkable claim (headcounts, €, hours, %, laws/άρθρα, ΦΕΚ)
cross-checked against a live fetch of a primary/authoritative source. The CURRENCY-BRIEF does not cover
H&S, so this batch rests on fresh primary fetches. `kepea.gr`/`et.gr`/`forin.gr` return 403 to automated
fetch (per brief) → not used for verbatim; used lawspot/e-nomothesia (mirror ΦΕΚ text), hli.gov.gr
(Επιθεώρηση Εργασίας), e-efka.gov.gr, ypergasias.gov.gr, gov.gr/mitos, taxheaven/protothema (secondary,
locate-only for the ΚΥΑ smoking table). **No corpus file edited.**
**Verdict key:** OK / WRONG / OUTDATED / IMPRECISE / UNVERIFIABLE.

**Primary/authoritative sources used (quoted per row):**
- Ν.3850/2010 art.8 (ΤΑ/ΙΕ thresholds) — https://www.lawspot.gr/nomothesia/n3850-2010/arthro-8-nomos-3850-2010/
- Ν.3850/2010 art.45 (σοβαρός & άμεσος κίνδυνος / right to leave) — https://www.lawspot.gr/nomothesia/n3850-2010/arthro-45-nomos-3850-2010/
- Ν.3850/2010 art.26 (what it really is: Σ.Υ.Α.Ε.) — https://www.lawspot.gr/nomothesia/n3850-2010/arthro-26-nomos-3850-2010/
- Ν.3850/2010 art.43 (24h αναγγελία ατυχήματος) — https://www.lawspot.gr/nomothesia/n3850-2010/arthro-43-nomos-3850-2010/
- Ν.3850/2010 arts 4/5/6 (ΕΥΑΕ threshold, quarterly meeting, member count) — https://www.e-nomothesia.gr/kat-ergasia-koinonike-asphalise/n-3850-2010.html
- ΕΥΑΕ σύσταση (Επιθεώρηση Εργασίας) — https://www.hli.gov.gr/asfaleia-kai-ygeia/ergazomenoi-asfaleia-kai-ygeia/dikaiomata/systasi-epitropis-ygeias-kai-asfaleias-ton-ergazomenon/
- Ιατρός εργασίας υποχρέωση (50+ / special-hazard exception) — https://www.hli.gov.gr/asfaleia-kai-ygeia/ergodotes-asfaleia-kai-ygeia/eidikes-ypochreoseis-ergodoton/ypochreosi-apascholisis-iatrou-ergasias/apascholisi-iatrou-ergasias-2/
- Προστασία συνδικαλιστικών στελεχών (Ν.1264/1982 art.14/15; ΕΥΑΕ via art.7) — https://www.hli.gov.gr/ergasiakes-scheseis/nomothesia-ergasiakes-scheseis/prostasia/syndikalistes/prostasia-ton-syndikalistikon-stelechon/
- Επίδομα ασθενείας μισθωτών = 50% τεκμ. ημερομ. +10%/μέλος — https://www.e-efka.gov.gr/el/sychnes-eroteseis/paroches-kai-ygeia/paroches-se-chrema/epidoma-astheneias/epidoma-astheneias-misthoton (%: web-confirmed via kepea/e-nomothesia mirrors)
- Αναγγελία εργατικού ατυχήματος (Επιθ. Εργασίας + e-ΕΦΚΑ, 24h) — https://www.hli.gov.gr/asfaleia-kai-ygeia/ergodotes-asfaleia-kai-ygeia/eidikes-ypochreoseis-ergodoton/anangelia-ergatikou-atychimatos/anangelia-ergatikou-atychimatos/
- Καύσωνας — εγκύκλιος 34666/03.06.2024 + υποχρεωτική παύση 12:00-17:00 + €2.000/εργαζόμενο — https://ypergasias.gov.gr/ektakta-metra-gia-tin-prostasia-ergazomenon-apo-tin-epelasi-tou-kafsona/
- Αντικαπνιστικός: Ν.4633/2019 = ισχύον, πρόστιμα — https://karayiannislaw.gr/antikapnistikos-nomos-n-4633-2019/ ; https://www.taxheaven.gr/news/46336/ta-prostima-se-periptwsh-parabasewn-epi-ths-apagoreyshs-toy-kapnismatos
- Γραμμή 1142 (αντικαπνιστικός) — https://www.protothema.gr/greece/article/947464/adikapnistikos-nomos-me-eleghous-prostima-kai-1142-to-ethniko-shedio-drasis-kata-tou-tsigarou/
- ΣΕΠΕ→Επιθεώρηση Εργασίας (Ν.4808/2021), 1555, hli.gov.gr, ανώνυμη καταγγελία — https://www.hli.gov.gr/epikoinonia/ ; https://www.iefimerida.gr/oikonomia/ergasiako-nomoshedio-katargeitai-sepe

---

## FILE 1 — `ygeia/index.md`

**Counts:** WRONG 6 · OUTDATED 2 · IMPRECISE 4 · UNVERIFIABLE 2 · OK ~14.

### Y1.1 — committee acronym AND name both wrong: "ΕΑΥΕ / Επιτροπή Υγιεινής, Ασφάλειας και Περιβάλλοντος" — WRONG — confidence HIGH
- **Current (lines 98, 100, 103, 107, header):**
  > ## ΕΑΥΕ — Επιτροπή Υγιεινής, Ασφάλειας και Περιβάλλοντος
  > Η ΕΑΥΕ είναι το εσωτερικό συλλογικό όργανο ελέγχου των συνθηκών εργασίας.
- **Proposed replacement:**
  > ## ΕΥΑΕ — Επιτροπή Υγείας και Ασφάλειας των Εργαζομένων
  > Η ΕΥΑΕ είναι το εσωτερικό συλλογικό όργανο των εργαζομένων για τις συνθήκες εργασίας.
  (replace every "ΕΑΥΕ" → "ΕΥΑΕ" in the file)
- **Legal basis:** Ν.3850/2010 arts 2-7. The statutory name is **Επιτροπή Υγείας και Ασφάλειας των
  Εργαζομένων (Ε.Υ.Α.Ε.)** — not "Υγιεινής, Ασφάλειας και Περιβάλλοντος", and the acronym is **ΕΥΑΕ**,
  not "ΕΑΥΕ". (Note: the corpus's swapped letters "ΕΑΥΕ" collide with nothing real; "Σ.Υ.Α.Ε." is a
  *different* body — the ministerial council of art.26.)
- **Primary URL:** hli.gov.gr σύσταση ΕΥΑΕ; lawspot art.6.
- **Verbatim quote:** hli: «Επιτροπή Υγείας και Ασφάλειας των Εργαζομένων (ΕΥΑΕ)»; lawspot art.6 title:
  «Αριθμός μελών Ε.Υ.Α.Ε. - Υποχρεώσεις εργοδοτών».

### Y1.2 — right to refuse dangerous work cited as "Ν.3850/2010, άρθρο 26" — WRONG article (should be 45) — confidence HIGH
- **Current (lines 139 and 147, twice):**
  > Δικαιούσαι να αρνηθείς εργασία που εγκυμονεί σοβαρό και άμεσο κίνδυνο για τη ζωή ή υγεία σου
  > (Ν. 3850/2010, άρθρο 26).
  > …απολαύεις πλήρους προστασίας από τον Ν. 3850/2010 (άρθρο 26)…
- **Proposed replacement:** cite **άρθρο 45** (§§3γ, 4, 5) in both places:
  > …σοβαρό και άμεσο κίνδυνο για τη ζωή ή υγεία σου (Ν. 3850/2010, **άρθρο 45**).
- **Legal basis:** Ν.3850/2010 **art.45** «Πρώτες βοήθειες, πυρασφάλεια, εκκένωση των χώρων από τους
  εργαζομένους, σοβαρός και άμεσος κίνδυνος» transposes Οδηγία 89/391/ΕΚ art.8§4-5: worker may interrupt
  work / leave and suffers no adverse treatment. **Art.26 is a different subject** — it establishes the
  ministerial "Συμβούλιο Υγείας και Ασφάλειας των Εργαζομένων (Σ.Υ.Α.Ε.)" inside the Ανώτατο Συμβούλιο
  Εργασίας. The corpus attached the wrong number (and it's the *same* number twice).
- **Primary URL:** lawspot art.45; lawspot art.26.
- **Verbatim quote:** art.45 §3γ: εργοδότης μεριμνά ώστε οι εργαζόμενοι «να διακόπτουν την εργασία ή/και
  να απομακρύνονται αμέσως από τη θέση εργασίας» σε «σοβαρό, άμεσο και αναπόφευκτο κίνδυνο»; §4: ο
  εργαζόμενος «δεν επιτρέπεται να υποστεί δυσμενείς συνέπειες». art.26 title: «Συμβούλιο Υγείας και
  Ασφάλειας των Εργαζομένων (Σ.Υ.Α.Ε.)».

### Y1.3 — ΕΥΑΕ members "δεν μπορούν να απολυθούν χωρίς έγκριση του ΟΜΕΔ" — WRONG body — confidence HIGH
- **Current (lines 107-109):**
  > **Προστασία μελών**: οι εργαζόμενοι-μέλη της ΕΑΥΕ **δεν μπορούν να απολυθούν** χωρίς έγκριση του
  > ΟΜΕΔ κατά τη διάρκεια της θητείας τους και για **ένα χρόνο** μετά τη λήξη της.
- **Proposed replacement:**
  > **Προστασία μελών**: τα εργαζόμενα-μέλη της ΕΥΑΕ και οι εκπρόσωποι απολαμβάνουν την **αυξημένη
  > προστασία των συνδικαλιστικών στελεχών** (άρθρο 7 Ν. 3850/2010 → άρθρο 14 Ν. 1264/1982): η απόλυσή
  > τους απαγορεύεται κατά τη θητεία τους **και για ένα χρόνο μετά**, εκτός αν συντρέξει ένας από τους
  > περιοριστικούς λόγους του νόμου και τον **εγκρίνει η ειδική Επιτροπή Προστασίας Συνδικαλιστικών
  > Στελεχών** (άρθρο 15 Ν. 1264/1982) — **όχι** ο ΟΜΕΔ.
- **Legal basis:** protection is real but the approving organ is wrong. Ν.3850/2010 **art.7 §9** extends
  Ν.1264/1982 **art.14** protection to ΕΥΑΕ members/reps. Under Ν.1264/1982 art.14 §10 + **art.15**,
  dismissal needs a limited statutory ground confirmed by the **special committee (Επιτροπή Προστασίας
  Συνδικαλιστικών Στελεχών)**. **ΟΜΕΔ** (Ν.1876/1990) handles collective-bargaining mediation/arbitration
  — it has **nothing** to do with approving individual dismissals. The "term + 1 year" span is correct.
- **Primary URL:** hli.gov.gr προστασία συνδικαλιστικών στελεχών; e-nomothesia Ν.3850/2010 art.7.
- **Verbatim quote:** «κατ' αρχήν απαγορεύεται η απόλυση συνδικαλιστικών στελεχών, εκτός εάν συντρέχει
  ένας από τους λόγους … της παραγράφου 10 … και διαπιστωθεί … κατά τη διαδικασία που ορίζει το άρθρο 15»;
  «κατά τη διάρκεια της θητείας και **ένα χρόνο μετά τη λήξη** της».

### Y1.4 — ιατρός εργασίας "Επιχειρήσεις 6–49 εργαζομένων: υποχρεωτική πρόσβαση σε ιατρό εργασίας" — WRONG — confidence HIGH
- **Current (lines 71-74):**
  > - **Επιχειρήσεις 50+ εργαζομένων**: υποχρεωτική απασχόληση αποκλειστικού ιατρού εργασίας.
  > - **Επιχειρήσεις 6–49 εργαζομένων**: υποχρεωτική πρόσβαση σε ιατρό εργασίας (μπορεί να είναι
  >   κοινός/συμβεβλημένος με άλλες επιχειρήσεις).
- **Proposed replacement:**
  > - **Επιχειρήσεις 50+ εργαζομένων**: υποχρεωτική χρήση υπηρεσιών ιατρού εργασίας (ελάχιστες ώρες
  >   ανάλογα με τον αριθμό εργαζομένων· μπορεί να είναι εξωτερικός/ΕΞΥΠΠ, όχι κατ' ανάγκη αποκλειστικός).
  > - **Επιχειρήσεις κάτω των 50**: ιατρός εργασίας **δεν** είναι κατά κανόνα υποχρεωτικός — **εκτός**
  >   αν η εκτίμηση κινδύνου δείξει έκθεση σε **μόλυβδο, αμίαντο, καρκινογόνους, μεταλλαξιγόνους ή
  >   βιολογικούς παράγοντες**, οπότε γίνεται υποχρεωτικός **ανεξαρτήτως αριθμού εργαζομένων**.
- **Legal basis:** Ν.3850/2010 **art.8**: ΙΕ is mandatory at **50+**; there is **no general 6-49 ΙΕ
  obligation**. The only sub-50 trigger is the special-hazard exception (κατ' εξαίρεση του art.8). The
  corpus invents a blanket "6-49 must have access to an occupational doctor".
- **Primary URL:** lawspot art.8; hli.gov.gr ιατρός εργασίας.
- **Verbatim quote:** art.8: «Σε επιχειρήσεις που απασχολούν 50 και άνω εργαζόμενους, ο εργοδότης έχει
  την υποχρέωση να χρησιμοποιεί τις υπηρεσίες τεχνικού ασφάλειας **και ιατρού εργασίας**.»; hli/e-forologia:
  «…κίνδυνο … από μόλυβδο, αμίαντο, καρκινογόνους, μεταλλαξιγόνους και βιολογικούς παράγοντες ο εργοδότης
  έχει την υποχρέωση να χρησιμοποιεί τις υπηρεσίες ιατρού εργασίας **ανεξάρτητα από τον αριθμό
  εργαζομένων** … κατ' εξαίρεση του άρθρου 8».

### Y1.5 — τεχνικός ασφαλείας "6–49" band — IMPRECISE/WRONG lower bound — confidence HIGH
- **Current (lines 86-90):**
  > - **Επιχειρήσεις 50+ εργαζομένων**: υποχρεωτική απασχόληση αποκλειστικού τεχνικού ασφαλείας…
  > - **Επιχειρήσεις 6–49 εργαζομένων**: ο ίδιος ο εργοδότης μπορεί να αναλάβει το ρόλο, εφόσον έχει
  >   παρακολουθήσει εγκεκριμένο εκπαιδευτικό πρόγραμμα ασφαλείας, ή μπορεί να συνεργαστεί με εξωτερικό σύμβουλο.
- **Proposed replacement:**
  > - **Όλες οι επιχειρήσεις που απασχολούν έστω και έναν εργαζόμενο** υποχρεούνται να έχουν τεχνικό
  >   ασφαλείας — δεν υπάρχει κατώτατο όριο 6 ατόμων.
  > - **Επιχειρήσεις κάτω των 50** (κατηγορίες Β' και Γ' επικινδυνότητας): ο ίδιος ο εργοδότης μπορεί
  >   να αναλάβει καθήκοντα τεχνικού ασφαλείας εφόσον έχει τα προσόντα του νόμου και έχει παρακολουθήσει
  >   το προβλεπόμενο πρόγραμμα επιμόρφωσης — ή να συνεργαστεί με εξωτερικό ΕΞΥΠΠ/σύμβουλο.
- **Legal basis:** Ν.3850/2010 **art.8 §1** («λιγότερους από 50», no lower bound) + **art.12** (employer
  may serve as ΤΑ in **cat. Β'/Γ' businesses under 50**). The "6" excludes micro-firms (1-5 workers) that
  the law fully obliges. "αποκλειστικού" (50+) is also imprecise → the duty is **minimum hours**, not a
  dedicated full-timer.
- **Primary URL:** lawspot art.8; lawspot/oenet art.12.
- **Verbatim quote:** art.8§1: «Σε επιχειρήσεις που απασχολούν λιγότερους από 50 εργαζόμενους ο εργοδότης
  έχει την υποχρέωση να χρησιμοποιεί τις υπηρεσίες τεχνικού ασφάλειας»; art.12: «Στις επιχειρήσεις που
  υπάγονται στις κατηγορίες Β' και Γ' και απασχολούν λιγότερους από 50 εργαζόμενους, επιτρέπεται να
  αναλάβει ο ίδιος ο εργοδότης τις υποχρεώσεις του τεχνικού ασφάλειας».

### Y1.6 — "αποκλειστικού" ΤΑ/ΙΕ at 50+ — IMPRECISE — confidence MED
- **Current (lines 71, 86):** «υποχρεωτική απασχόληση **αποκλειστικού** ιατρού εργασίας / τεχνικού ασφαλείας».
- **Finding:** at exactly 50+ the law requires **minimum annual hours** (scaling with headcount × risk
  coefficient), not a dedicated/exclusive professional; small 50+ firms lawfully use a shared/external
  (ΕΞΥΠΠ) ΤΑ/ΙΕ. Only large firms effectively need a full-timer. Folded into Y1.4/Y1.5 replacements.
- **Legal basis:** Ν.3850/2010 arts 8, 21 (ελάχιστος χρόνος απασχόλησης).

### Y1.7 — work-accident benefit "100% του ημερομισθίου" — WRONG — confidence HIGH
- **Current (lines 47-49):**
  > 5. **Παροχές ΕΦΚΑ από την πρώτη ημέρα ατυχήματος.** … Το επίδομα ανικανότητας ανέρχεται σε
  >    **100% του ημερομισθίου** κατά τη διάρκεια της ανικανότητας εργασίας.
- **Proposed replacement:**
  > 5. **Παροχές ΕΦΚΑ χωρίς την τριήμερη αναμονή.** Για εργατικό ατύχημα δεν ισχύει ο τριήμερος χρόνος
  >    αναμονής της κοινής ασθένειας. Το επίδομα ανικανότητας του e-ΕΦΚΑ ισούται με **50% του τεκμαρτού
  >    ημερομισθίου** της ασφαλιστικής σου κλάσης, **+10% για κάθε προστατευόμενο μέλος** (με ανώτατα
  >    όρια). Παράλληλα, ο **εργοδότης** οφείλει να σου καταβάλει τις αποδοχές του πρώτου διαστήματος
  >    ανικανότητας (15 ημέρες αν έχεις <1 έτος υπηρεσίας, 1 μήνας αν >1 έτος — ΑΚ 657-658), συμψηφίζοντας
  >    το επίδομα του ΕΦΚΑ· έτσι για το αρχικό διάστημα προσεγγίζεις τον πλήρη μισθό.
- **Legal basis:** e-ΕΦΚΑ επίδομα ασθενείας/ατυχήματος = **50% τεκμ. ημερομισθίου + 10%/μέλος**, capped
  (≤ ημερομ. 8ης κλάσης / ≤70%); για ατύχημα καταβάλλεται **χωρίς τριήμερη αναμονή**. The flat "100%"
  is not the ΕΦΚΑ benefit; near-full pay comes only from the *employer's* wage obligation (ΑΚ 657-658 /
  Ν.2112/1920), which the corpus doesn't mention.
- **Primary URL:** e-efka.gov.gr επίδομα ασθενείας μισθωτών; e-nomothesia mirror.
- **Verbatim quote:** «Το επίδομα ασθενείας αντιστοιχεί στο **50% του τεκμαρτού ημερομισθίου** της
  ασφαλιστικής κλάσης … προσαυξάνεται κατά **10% για κάθε προστατευόμενο μέλος** … σε καμία περίπτωση
  δεν μπορεί να είναι ανώτερο … του 70% του ημερομισθίου»; «όταν πρόκειται για εργατικό ατύχημα …
  **χωρίς να υπολογίζεται τριήμερος χρόνος αναμονής**».
- **Note:** the "από την πρώτη ημέρα / χωρίς τριήμερη αναμονή" part is **OK**; only the 100% figure is wrong.

### Y1.8 — 24h αναγγελία framed as "ΕΦΚΑ (all) + ΣΕΠΕ only for serious" — WRONG/IMPRECISE + missing legal basis — confidence HIGH
- **Current (lines 37-41):**
  > 3. **Αναγγελία στον ΕΦΚΑ εντός 24 ωρών (ημερολογιακών).** … Για **σοβαρά ατυχήματα** (νοσηλεία,
  >    σοβαρός τραυματισμός) υποχρεούται επίσης να ειδοποιήσει το **ΣΕΠΕ** εντός 24 ωρών.
- **Proposed replacement:**
  > 3. **Αναγγελία εντός 24 ωρών — για ΟΛΑ τα ατυχήματα.** Ο εργοδότης υποχρεούται (Ν. 3850/2010 άρθρο 43)
  >    να αναγγείλει **όλα** τα εργατικά ατυχήματα, εντός 24 ωρών, **τόσο στην Επιθεώρηση Εργασίας όσο
  >    και στον e-ΕΦΚΑ** (και στην πλησιέστερη αστυνομική αρχή), ηλεκτρονικά. Δεν αφορά μόνο τα «σοβαρά»:
  >    η υποχρέωση προς την Επιθεώρηση ισχύει για κάθε ατύχημα. Ειδικά για **σοβαρό τραυματισμό ή θάνατο**
  >    ο εργοδότης οφείλει επιπλέον να **διατηρήσει αμετάβλητο τον χώρο** του ατυχήματος.
- **Legal basis:** Ν.3850/2010 **art.43 §2**: employer reports **ALL** accidents within 24h to the
  **Επιθεώρηση Εργασίας + police + insurance organisation (e-ΕΦΚΑ)**; only the scene-preservation duty
  is limited to serious/fatal. The corpus wrongly (a) confines the Inspectorate notice to "serious"
  accidents, (b) omits that the 24h report goes to the Inspectorate at all for ordinary accidents,
  (c) never cites art.43. ("ημερολογιακές 24 ώρες" is a defensible reading — statute says only "24 ωρών".)
- **Primary URL:** lawspot art.43; hli.gov.gr αναγγελία εργατικού ατυχήματος.
- **Verbatim quote:** «να αναγγέλλει στις αρμόδιες υπηρεσίες της Επιθεώρησης Εργασίας και στις αρμόδιες
  υπηρεσίες του e-Ε.Φ.Κ.Α., εντός 24 ωρών, **όλα τα εργατικά ατυχήματα**»; «εφόσον πρόκειται περί
  σοβαρού τραυματισμού ή θανάτου, να τηρεί αμετάβλητα όλα τα στοιχεία».

### Y1.9 — "ΣΕΠΕ" terminology + sepe.gov.gr throughout — OUTDATED — confidence HIGH
- **Current (lines 40, 78, 124-125, 156-158, 162):** repeated **ΣΕΠΕ**; reporting table row
  «**ΣΕΠΕ** | 1555, [sepe.gov.gr](https://www.sepe.gov.gr/) | …».
- **Proposed replacement:** replace every «ΣΕΠΕ» → «**Επιθεώρηση Εργασίας**»; table link
  → «1555, [hli.gov.gr](https://www.hli.gov.gr/)». (Keep 1555 — still correct.)
- **Legal basis:** **Ν.4808/2021** abolished ΣΕΠΕ and established the Ανεξάρτητη Αρχή «**Επιθεώρηση
  Εργασίας**»; official site is **hli.gov.gr** (Hellenic Labour Inspectorate). "ΣΕΠΕ" and "sepe.gov.gr"
  are dead branding. The **1555** citizen line and anonymous-complaint route are current → OK.
- **Primary URL:** hli.gov.gr/epikoinonia; iefimerida (ΣΕΠΕ κατάργηση).
- **Verbatim quote:** «ασκεί τις αρμοδιότητες του ΣΕΠΕ **το οποίο καταργείται**»; hli: complaints via
  «τη γραμμή εξυπηρέτησης πολιτών **1555**» + online «Ανώνυμη Καταγγελία».

### Y1.10 — heat-stress section outdated: omits the mandatory ministerial work-stoppage regime — OUTDATED/INCOMPLETE — confidence HIGH
- **Current (lines 118-130):** lists only soft measures (νερό, σκιά, αναδιάταξη, διαλείμματα); says
  «**Το ΣΕΠΕ** εκδίδει κάθε χρόνο **τεχνικές οδηγίες** … Βάση: ΠΔ 105/1995 και οδηγίες Υπουργείου
  Εργασίας»; frames stoppage only as a vague "δικαίωμα διακοπής" tied to the right-to-refuse.
- **Proposed replacement (add a hard-measures block):**
  > **Υποχρεωτική παύση εργασιών σε καύσωνα.** Το **Υπουργείο Εργασίας** (όχι πια «ΣΕΠΕ») εκδίδει
  > εγκυκλίους που επιβάλλουν **υποχρεωτική διακοπή** των υπαίθριων/χειρωνακτικών εργασιών (οικοδομές,
  > εργοτάξια, delivery με δίκυκλα κ.λπ.) τις ώρες αιχμής — τυπικά **12:00-17:00** — σε περιοχές/ημέρες
  > υψηλού κινδύνου, με δυνατότητα **τηλεργασίας** για ομάδες υψηλού κινδύνου. Κριτήρια: δείκτης **WBGT
  > > 32,2** ή/και πολύ υψηλές θερμοκρασίες (≥40°C, >38°C σε ναυπηγοεπισκευαστικές ζώνες). Η **Επιθεώρηση
  > Εργασίας** ελέγχει και επιβάλλει **πρόστιμο έως 2.000 € ανά θιγόμενο εργαζόμενο**. Ισχύον πλαίσιο:
  > **εγκύκλιος Υπ. Εργασίας 34666/03.06.2024** «Πρόληψη της θερμικής καταπόνησης των εργαζομένων» +
  > έκτακτες εγκύκλιοι ανά κύμα καύσωνα (βάση ΠΔ 105/1995).
- **Legal basis:** annual/ad-hoc **εγκύκλιοι Υπ. Εργασίας** (34666/2024 framework + dated emergency
  circulars, e.g. summer 2025), on ΠΔ 105/1995. The corpus (a) misattributes issuance to "ΣΕΠΕ",
  (b) understates them as mere "τεχνικές οδηγίες", (c) omits the binding midday **stoppage** and the
  **€2.000/employee** penalty — i.e. it *undersells* a real worker protection.
- **Primary URL:** ypergasias.gov.gr (έκτακτα μέτρα καύσωνα).
- **Verbatim quote:** «καθίσταται **υποχρεωτική η παύση εργασιών** κατά το χρονικό διάστημα
  **12.00΄-17.00΄**»; εγκύκλιος «**34666/03.06.2024** … Πρόληψη της θερμικής καταπόνησης των εργαζομένων»;
  penalty €2.000/εργαζόμενο.

### Y1.11 — "Συμπλήρωσε τη φόρμα Ε1 στον ΕΦΚΑ" / "δήλωση εργατικού ατυχήματος (Ε1)" — WRONG/UNVERIFIABLE form name — confidence MED
- **Current (lines 43-44):**
  > 4. **Συμπλήρωσε τη φόρμα Ε1 στον ΕΦΚΑ.** … τη δήλωση εργατικού ατυχήματος (Ε1) …
- **Finding:** no e-ΕΦΚΑ work-accident form named "Ε1" was found; the procedure is the electronic
  **«Αναγγελία Εργατικού Ατυχήματος»** submitted via the Επιθεώρηση Εργασίας e-services (and the e-ΕΦΚΑ
  δήλωση ατυχήματος application). "Ε1" is strongly associated with the **income-tax return** — likely a
  slip. Recommend replacing "φόρμα Ε1" with «**Αναγγελία/Δήλωση Εργατικού Ατυχήματος** (ηλεκτρονικά μέσω
  Επιθεώρησης Εργασίας / e-ΕΦΚΑ)». Not asserted as a fabricated *fact*, but the form label is unsupported.
- **Primary URL:** hli.gov.gr / gov.gr / mitos.gov.gr «Αναγγελία Εργατικού Ατυχήματος».
- **Verbatim quote:** gov.gr process is titled «**Αναγγελία Εργατικού Ατυχήματος**»; submission «μέσω της
  ιστοσελίδας της Επιθεώρησης Εργασίας … ηλεκτρονικών υπηρεσιών». (No "Ε1" appears.)

### Y1.12 — documents list "ΑΜΕΑ" — IMPRECISE (typo) — confidence MED
- **Current (line 45):** «Φέρε μαζί σου: αστυνομική ταυτότητα, ΑΜΚΑ, **ΑΜΕΑ**, ιατρικά έγγραφα…».
- **Finding:** "ΑΜΕΑ" (= Άτομα με Αναπηρία) is not a document. In context it should be **ΑΜΑ** (Αριθμός
  Μητρώου Ασφαλισμένου) or **ΑΦΜ**. Proposed: replace «ΑΜΕΑ» → «**ΑΜΑ/ΑΦΜ**».
- **Legal basis:** n/a (editorial). Low risk, but publicly confusing.

### Y1.13 — ιατρός εργασίας "Επισκέπτεται … τουλάχιστον μία φορά τον μήνα" — UNVERIFIABLE — confidence LOW (no edit)
- **Current (line 75):** «Επισκέπτεται την εργασία **τουλάχιστον μία φορά τον μήνα** — για επικίνδυνα
  περιβάλλοντα, συχνότερα.»
- **Finding:** the statutory duty is **minimum annual hours** (Ν.3850/2010 art.21, scaled by headcount ×
  category), distributed across visits — not a hard "once-a-month" rule; for small/low-risk firms the
  hours can translate to fewer than monthly visits. Plausible as guidance but not a clean statutory
  figure. **No edit**; soften to «ανά τακτά διαστήματα, ανάλογα με τις προβλεπόμενες ελάχιστες ώρες».

### OK (no change) in File 1
- **ΕΥΑΕ threshold "50+"** (line 102) — **OK** (art.4: «επιχειρήσεις που απασχολούν πάνω από πενήντα
  (50) άτομα»). Minor: it's a workers' **right** to set one up rather than a flat employer duty — but
  "υποχρεωτική" is a defensible shorthand.
- **ΕΥΑΕ «συνεδριάζει τουλάχιστον ανά τρίμηνο»** (line 105) — **OK** (art.5: «μέσα στο πρώτο δεκαήμερο
  κάθε τριμήνου»). Good catch by the corpus.
- **ΕΥΑΕ σύνθεση (ΤΑ + ΙΕ + εκλεγμένοι εκπρόσωποι), πρόσβαση σε χώρους/αρχεία** (lines 103-106) — OK.
- **ΕΥΑΕ member protection span "term + 1 year"** (line 108) — **OK** (only the *organ*, ΟΜΕΔ, is wrong → Y1.3).
- **Employer duties: γραπτή εκτίμηση κινδύνου, ΜΑΠ δωρεάν χωρίς κρατήσεις, βιβλίο ατυχημάτων, ενημέρωση/
  εκπαίδευση** (lines 14-19) — OK (Ν.3850/2010 arts 42-43; ΜΑΠ per ΠΔ 396/1994). Minor terminology:
  corpus writes "ΑΜΠ"; the standard acronym is **ΜΑΠ** (Μέσα Ατομικής Προστασίας).
- **Work accident incl. in itinere (εν τω μεταβαίνειν)** (lines 25-27) — OK (established ΕΦΚΑ/case-law coverage).
- **Civil liability ΑΚ 914 + Ν.551/1915; συντρέχον πταίσμα ΑΚ 300** (lines 51-58, 171-173) — OK.
  Enhancement: add **ΑΚ 932** (χρηματική ικανοποίηση ηθικής βλάβης / ψυχική οδύνη) — a real worker/family
  claim the corpus omits.
- **Right-to-refuse substance: written notice, burden on employer, dismissal void/καταχρηστική, exception
  if danger solely worker's fault** (lines 136-150) — OK (art.45 §§4-5). Only the article number is wrong (Y1.2).
- **Ποινική ευθύνη εργοδότη (σωματική βλάβη/ανθρωποκτονία από αμέλεια)** (lines 60-63) — OK.
- **Anonymous complaints accepted; 1555** (lines 156-163) — OK (only "ΣΕΠΕ"/sepe.gov.gr branding is stale → Y1.9).
- **Ν.3850/2010 = Κώδικας νόμων ΥΑΕ, εναρμ. Οδηγίας 89/391/ΕΚ** (line 169) — OK. Minor: Ν.1568/1985 was
  **κωδικοποιήθηκε** into Ν.3850/2010 rather than merely "εν μέρει αντικαταστάθηκε" (line 170).
- **ΠΔ 105/1995 = ελάχιστες απαιτήσεις χώρων εργασίας** (line 174) — OK.

---

## FILE 2 — `ygeia/kapnisma.md`

**Counts:** WRONG 1 · OUTDATED 2 · IMPRECISE 0 · GAP 1 · OK ~9.

### Y2.1 — individual smoker fine "50 € έως 500 €" — OUTDATED — confidence HIGH
- **Current (lines 35-36):**
  > **Για φυσικά πρόσωπα** που καπνίζουν:
  > - Πρόστιμο **50 € έως 500 €**
- **Proposed replacement:**
  > **Για φυσικά πρόσωπα** που καπνίζουν (Ν. 4633/2019 & σχετική ΚΥΑ):
  > - **100 €** ανά παράβαση σε κλειστούς χώρους εργασίας, καταστήματα υγειονομικού ενδιαφέροντος και
  >   μέσα μεταφοράς
  > - **200 €** σε χώρους με παρουσία ανηλίκων (σχολεία, παιδότοποι κ.λπ.)
  > - **1.500 €** για κάπνισμα σε ΙΧ όχημα με ανήλικο <12 ετών (**3.000 €** σε όχημα δημόσιας χρήσης)
- **Legal basis:** the "€50-500" range is the **superseded** 2010 ΚΥΑ (under Ν.3868/2010). Under the
  current **Ν.4633/2019** regime the base smoker fine is **€100**, with **€200 / €1.500 / €3.000**
  aggravated tiers — i.e. the corpus both understates the base (50→100) and caps too low (500 vs 1.500/3.000).
- **Primary URL:** karayiannislaw (Ν.4633/2019 πίνακας); taxheaven 46336.
- **Verbatim quote:** «**100 €** πρόστιμο για τον καπνιστή ανά παράβαση» (χώροι εργασίας/ΜΜΜ); «**200€**
  πρόστιμο για τον καπνιστή» (ανήλικοι); «**1500€** για τον καπνιστή επιβαίνοντα» (ΙΧ) / «**3000€** …
  οχήματος δημοσίας χρήσης».

### Y2.2 — law chain stops at Ν.4229/2014; misses Ν.4633/2019 (the governing statute) — OUTDATED — confidence HIGH
- **Current (lines 58-60):**
  > - Ν. 3868/2010 — Αρχικός αντικαπνιστικός νόμος
  > - Ν. 4229/2014 — Ενίσχυση της απαγόρευσης και αυστηροποίηση κυρώσεων
- **Proposed replacement:**
  > - Ν. 3730/2008 — πρώτος αντικαπνιστικός νόμος (προστασία ανηλίκων/δημόσιοι χώροι)
  > - Ν. 3868/2010 — γενική απαγόρευση σε κλειστούς χώρους
  > - Ν. 4229/2014 — ενίσχυση της απαγόρευσης
  > - **Ν. 4633/2019 — ισχύον πλαίσιο: επανενεργοποίηση ελέγχων, αυστηρά πρόστιμα, εθνικό σχέδιο δράσης
  >   (γραμμή 1142)** — αυτός είναι σήμερα ο κύριος αντικαπνιστικός νόμος
  > - Ν. 4419/2016 — εξίσωση ηλεκτρονικού τσιγάρου/ατμίσματος με το κάπνισμα
- **Legal basis:** **Ν.4633/2019 (ΦΕΚ 16.10.2019)** is the current operative anti-smoking law; citing
  only up to 2014 is stale. Ν.4419/2016 is the actual basis for the e-cigarette equivalence the file
  already asserts.
- **Primary URL:** karayiannislaw (Ν.4633/2019 = ισχύον); protothema/newsit (ΚΥΑ under 4633/2019).
- **Verbatim quote:** karayiannislaw: current governing statute = «**Ν. 4633/2019**».

### Y2.3 — anti-smoking hotline "1565" — WRONG (should be 1142) — confidence HIGH
- **Current (line 51):**
  > - Τηλεφωνική γραμμή υγείας: **1565** (αρμόδια για αντικαπνιστική νομοθεσία)
- **Proposed replacement:**
  > - Τηλεφωνική γραμμή **1142** (εθνική γραμμή κατά του καπνίσματος — ενημέρωση, βοήθεια διακοπής και
  >   **αναφορά παραβάσεων**)
- **Legal basis:** the dedicated anti-smoking line launched with the Ν.4633/2019 action plan is **1142**;
  "1565" is not the anti-smoking line.
- **Primary URL:** protothema 947464.
- **Verbatim quote:** «Καλώντας στο **1142**, οι πολίτες μπορούν να ενημερωθούν … καθώς και να
  **αναφέρουν παραβάσεις** της σχετικής νομοθεσίας».

### Y2.4 — reporting via "ΣΕΠΕ (1555)" — OUTDATED terminology — confidence HIGH
- **Current (line 53):** «**ΣΕΠΕ** (1555) — για παραβάσεις που αφορούν το εργασιακό περιβάλλον».
- **Proposed replacement:** «**Επιθεώρηση Εργασίας** (1555) — για παραβάσεις που αφορούν το εργασιακό
  περιβάλλον».
- **Legal basis:** same as Y1.9 — ΣΕΠΕ abolished by Ν.4808/2021; 1555 line still valid.
- **Primary URL:** hli.gov.gr/epikoinonia.

### GAP — e-cigarette equivalence has no cited basis — enhancement — confidence MED
- **Current (lines 38-40):** asserts e-cig/vape treated «νομικά ίδια» — correct, but no law cited.
- **Proposed:** add **Ν.4419/2016** (transposing EU Dir 2014/40) as the basis (also folded into Y2.2).

### OK (no change) in File 2
- **Business/employer fines "500 € έως 10.000 €"** (lines 32-33) — **OK** (current under Ν.4633/2019 ΚΥΑ;
  escalates to closure/license revocation on recidivism).
- **Full ban in all enclosed workplaces; no indoor smoking room; work vehicles (ταξί/λεωφορεία/φορτηγά);
  εστίαση/ξενοδοχεία; δημόσιοι χώροι** (lines 9-19) — OK.
- **Employer duties: σήμανση «Απαγορεύεται το κάπνισμα», μη ανοχή, ενεργή αντιμετώπιση παραβάσεων**
  (lines 22-26) — OK.
- **Optional outdoor smoking area** (line 28) — OK.
- **E-cig/vape banned in enclosed workspaces** (lines 38-40) — OK (add Ν.4419/2016 → GAP).
- **Right to complain without reprisal; βλαπτική μεταβολή framing** (lines 42-47) — OK (reasonable legal
  characterisation).
- **Anonymous complaint; τοπική Υγειονομική Υπηρεσία** (lines 49-55) — OK.

---

## UNVERIFIABLE / HUMAN-REVIEW

1. **"φόρμα Ε1" for work-accident declaration** (`index.md` lines 43-44) — no e-ΕΦΚΑ form of that name
   found; process is the electronic «Αναγγελία/Δήλωση Εργατικού Ατυχήματος». Recommend relabelling; do
   not keep "Ε1" (collides with the tax return). Confidence current label is right: LOW.
2. **Ιατρός εργασίας "μία φορά τον μήνα"** (`index.md` line 75) — statute sets minimum **annual hours**
   (art.21), not a monthly-visit mandate; soften rather than assert. No edit made.
3. **"24 ώρες ημερολογιακές" characterisation** (`index.md` line 39) — statute says only «εντός 24 ωρών»;
   calendar-hours reading is defensible but not literal. Low priority; keep or footnote.

## COVERAGE GAPS (content the cluster should add)

- **Correct article for the right to refuse = Ν.3850/2010 art.45** (§§3γ, 4, 5) — currently mis-cited as
  art.26 twice (Y1.2). This is the single most load-bearing legal-citation error in the batch.
- **Mandatory heat-stress work stoppage (12:00-17:00) + €2.000/employee penalty + Υπ. Εργασίας εγκύκλιος
  34666/2024** — a concrete worker protection the corpus omits (Y1.10).
- **Correct sub-50 rules:** ΤΑ obligatory for **all** firms (≥1 worker); ΙΕ obligatory at **50+** or on
  special-hazard exposure at any size (Y1.4/Y1.5) — corpus's "6-49" band is fictional.
- **Current anti-smoking regime = Ν.4633/2019 + €100/€200/€1.500/€3.000 smoker tiers + line 1142**
  (Y2.1/Y2.2/Y2.3).
- **ΣΕΠΕ → Επιθεώρηση Εργασίας / sepe.gov.gr → hli.gov.gr** everywhere (Y1.9, Y2.4).
- **Add ΑΚ 932** (moral-damages / ψυχική οδύνη) to the work-accident civil-liability toolkit (minor).

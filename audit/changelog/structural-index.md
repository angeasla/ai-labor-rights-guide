# CHANGELOG — index.md navigation / structural pass

**Date:** 2026-07-13 · **Scope:** `src/main/resources/docs/**/index.md` only.
**Goal:** eliminate orphaned articles (not linked from their folder `index.md`), add the missing
root **Ανεργία** section, and link the newly-added articles.

**Method:** wikilink resolution verified against `WikiService.build()` — the link map keys are
`normalize(title)` and `normalize(filename-slug)`, where `normalize` = NFD + strip diacritics +
lowercase. Greek link text never matches the ASCII filename keys, so every `[[…]]` uses the
article's **exact frontmatter `title`**. All titles were read from each file's frontmatter.

**Corpus tally:** 102 `.md` (10 `index.md` + 92 articles). After this pass **all 92 articles are
linked from their folder index — 0 orphans.** The 9 newly-added (git-untracked) articles are:
`adeies/{aneu-apodoxon, anoteras-vias, frontisti, gynaikologikos-elegxos, penthos}`,
`symvasi/prostasia-martyron`, `syntaxi/{efapax, epikouriki-teka, syntaxi-thanatou}`.
(`ygeia/kapnisma` was an older orphan from the original corpus, not a new article.)

---

## index.md (root) — +1 section, 1 fixed
- ADDED section **[[Ανεργία]]** → ΔΥΠΑ (πρώην ΟΑΕΔ), επίδομα ανεργίας, εγγραφή, ιατροφαρμακευτική κάλυψη (inserted after Απόλυση). Root now lists all 9 sections.
- FIXED broken short-form `[[Μισθός]]` → `[[Μισθός & Δώρα]]` (exact folder-index title).
- Preserved: intro + quote, Υπολογιστές (calculator links), Πηγές.

## adeies/index.md — +5 links (reorganized into 3 subgroups)
- ADDED `[[Άδεια Άνευ Αποδοχών]]`, `[[Άδεια Γυναικολογικού Ελέγχου]]`, `[[Άδεια Φροντιστή]]`, `[[Άδεια Ανωτέρας Βίας]]`, `[[Άδεια Πένθους]]`.
- Regrouped existing 10 links under H3: «Βασικές άδειες» / «Μητρότητα, πατρότητα & γονεϊκές άδειες» / «Ειδικές περιστάσεις». Dropped stale "φροντιστή" mention from the Ειδικές Άδειες blurb (now its own entry).
- Preserved: intro, Εφαρμογές. 15/15 articles linked.

## syntaxi/index.md — +4 links
- ADDED `[[Επικουρική Σύνταξη & ΤΕΚΑ]]`, `[[Εφάπαξ]]`, `[[Σύνταξη λόγω Θανάτου]]`, `[[Εξαγορά Ενσήμων (Πλασματικά Έτη Ασφάλισης)]]` under existing «## Θέματα».
- Preserved: two-part-pension explainer, tables, Εφαρμογές, Νομοθεσία. 5/5 articles linked.

## misthos/index.md — +2 links, 1 fixed
- ADDED `[[Ωρομίσθιο — Δικαιώματα Εργαζόμενων]]`, `[[Επίδομα Ανθυγιεινής & Επικίνδυνης Εργασίας]]`.
- FIXED `[[Εκκαθαριστικό Σημείωμα]]` → `[[Εκκαθαριστικό Σημείωμα Μισθοδοσίας]]`.
- Regrouped under H3 «Μισθός & αμοιβή» / «Δώρα & επιδόματα». Preserved: intro, Καταβολή μισθού, Εφαρμογές. 7/7 articles linked.

## apolysi/index.md — +5 links (reorganized into 2 subgroups)
- ADDED `[[Φόρος στην Αποζημίωση Απόλυσης]]`, `[[Ομαδικές Απολύσεις]]`, `[[Οικειοθελής Αποχώρηση (Παραίτηση)]]`, `[[Επίσχεση Εργασίας]]`, `[[Πτώχευση Εργοδότη]]`.
- Regrouped under H3 «Απόλυση & αποζημίωση» / «Λύση σύμβασης & διεκδίκηση». Preserved: intro, Διαδικασία νόμιμης απόλυσης, Εφαρμογές. 7/7 articles linked.

## asfalisi/index.md — +3 links, 1 fixed
- ADDED `[[Τεκμαρτό Ημερομίσθιο]]`, `[[Εργόσημο]]`, `[[ΕΡΓΑΝΗ — Ψηφιακό Σύστημα Εργασίας]]`.
- FIXED `[[Εισφορές]]` → `[[Ασφαλιστικές Εισφορές]]`. Preserved: intro, Δικαιώματα ασφαλισμένου. 5/5 articles linked.

## orario/index.md — +5 links, 1 fixed (reorganized into 3 subgroups)
- ADDED `[[Τηλεργασία (Εξ Αποστάσεως Εργασία)]]`, `[[Τηλεεργασία Διασυνοριακή]]`, `[[Ψηφιακή Κάρτα Εργασίας]]`, `[[Εφεδρεία / Ετοιμότητα (On-Call)]]`, `[[Εκτός Έδρας Απασχόληση]]`.
- FIXED `[[Βάρδιες]]` → `[[Βάρδιες και Βαρδιακή Εργασία]]`.
- Regrouped under H3 «Ώρες & όρια» / «Ειδικές μορφές & ώρες εργασίας» / «Τηλεργασία & ψηφιακά εργαλεία». Preserved: intro, Νόμιμο vs συμβατικό ωράριο, 13ωρο note, Εφαρμογές. 11/11 articles linked.

## symvasi/index.md — 38 links now resolving (36 orphans + 2 fixed), 6 new H2 sections
- FIXED `[[Αορίστου Χρόνου]]`→`[[Σύμβαση Αορίστου Χρόνου]]`, `[[Ορισμένου Χρόνου]]`→`[[Σύμβαση Ορισμένου Χρόνου]]`.
- EXPANDED «Τύποι σύμβασης» with: Εκ Περιτροπής Εργασία, Εποχιακή Απασχόληση, Εταιρείες Προσωρινής Απασχόλησης, Πολλαπλή Απασχόληση, Εθελοντική Εργασία, Μαθητεία, Απασχόληση Ανηλίκων.
- ADDED «Πρόσληψη & τυπικές υποχρεώσεις εργοδότη»: Αναγγελία Πρόσληψης (Εργάνη), Αναγκαστικές Προσλήψεις, Κανονισμός Εργασίας, Βιβλία & Αρχεία Εργοδότη, Βεβαίωση Εργασίας, Βεβαίωση Προϋπηρεσίας, Προσωπικά Δεδομένα στην Εργασία.
- ADDED «Προστασία & ίση μεταχείριση»: Ίση Μεταχείριση, Ηθική Παρενόχληση (Mobbing), Σεξουαλική Παρενόχληση στον Εργασιακό Χώρο, Παρενόχληση & Πίεση σε Εγκύους Εργαζόμενες, Προστασία Μαρτύρων Δημοσίου Συμφέροντος (NEW), Σύμφωνο Συμβίωσης — Εργασιακά Δικαιώματα.
- ADDED «Μεταβολές & αναστολή»: Αναστολή Σύμβασης Εργασίας, Διαθεσιμότητα, Βλαπτική Μεταβολή, Μεταβίβαση Επιχείρησης, Στράτευση — Εργασιακά Δικαιώματα.
- ADDED «Λήξη σχέσης & αξιώσεις»: Θάνατος Εργαζόμενου, Θάνατος Εργοδότη, Παραγραφή Εργατικών Αξιώσεων.
- ADDED «Συλλογικά δικαιώματα & δράση»: Συνδικαλισμός, Απεργία, Συλλογικές Συμβάσεις Εργασίας (ΣΣΕ), Εθνική Γενική Συλλογική Σύμβαση Εργασίας (ΕΓΣΣΕ), Διαβούλευση & Ενημέρωση Εργαζόμενων, Συμβούλια Εργαζομένων.
- ADDED «Ειδικοί κλάδοι»: Ξενοδοχοϋπάλληλοι, Οικοδόμοι (Κατασκευαστικός Τομέας), Οικιακοί Μισθωτοί.
- Preserved: intro, Τι πρέπει να περιέχει η σύμβαση, Δοκιμαστική περίοδος, Αναγγελία πρόσληψης, the ΣΣΕ explainer (incl. inline `[[Συνδικαλισμός]]`), Νομοθεσία. 40/40 articles linked.

## ygeia/index.md — +1 link
- ADDED section «## Ειδικά θέματα» with `[[Κάπνισμα στον Εργασιακό Χώρο]]` (was orphaned). Preserved: all prose sections, Νομοθεσία. 1/1 article linked.

## anergia/index.md — 0 new article links, 1 fixed
- FIXED cross-reference `[[Εισφορές]]` → `[[Ασφαλιστικές Εισφορές]]`. Its single article `[[Επίδομα Ανεργίας (ΔΥΠΑ)]]` was already linked inline. Preserved everything else.

---

**Totals:** 61 new article links + 1 new root section; 7 broken short-form links normalized to exact
titles (root ×1, misthos ×1, asfalisi ×1, orario ×1, anergia ×1, symvasi ×2). Orphans remaining: **none.**

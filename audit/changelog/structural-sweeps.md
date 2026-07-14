# CHANGELOG — corpus-wide text-consistency sweeps

**Date:** 2026-07-13 · **Scope:** all NON-`index.md` content articles under `src/main/resources/docs/**` (index files owned by another agent — see `structural-index.md`).

Two sweeps: **(1)** ΣΕΠΕ → «Επιθεώρηση Εργασίας» rename (Ν.4808/2021, ανεξάρτητη αρχή σε λειτουργία 19.7.2022, site hli.gov.gr); **(2)** broken `[[wikilink]]` repair.

**Link-resolution model (verified against `WikiService.build()`):** the link map keys are `normalize(title)`, `normalize(filename-slug)`, and `normalize(alias)`, where `normalize` = NFD + strip diacritics + lowercase + trim. **No `aliases:` frontmatter exists anywhere in the corpus**, and Greek link text never matches the ASCII filename slugs — so every `[[…]]` must equal an article's **exact frontmatter `title`** (accent-/case-insensitively). A link like `[[Εισφορές]]` does NOT resolve to title «Ασφαλιστικές Εισφορές» (no substring match), so it is genuinely broken and was fixed to `[[Ασφαλιστικές Εισφορές|Εισφορές]]`.

---

## TASK 1 — ΣΕΠΕ rename

**81 ΣΕΠΕ tokens replaced across 46 files**, with Greek grammar adjusted per case (feminine «η/την/στην/της Επιθεώρηση(ς) Εργασίας» vs. neuter/masculine «το/ο/στο/στον ΣΕΠΕ»). Two redundant parentheticals collapsed: `etisia-adia.md` «ΣΕΠΕ (Σώμα Επιθεώρησης Εργασίας)» → «Επιθεώρηση Εργασίας»; `apolysi/apozimiossi.md` «Επιθεώρηση Εργασίας (ΣΕΠΕ):» → «Επιθεώρηση Εργασίας:». All `(τηλ. 1555)` / `1555` preserved intact.

Files (occurrences): adeies/adia-gamos(1), adeies/astheneia(1), adeies/eidiki-adia-mitrotitas(1), adeies/apozimiossi-adias(3), adeies/etisia-adia(4), adeies/goniki-adia(2), adeies/mitrotita(1), adeies/thilasmou(1), anergia/epidoma(2), misthos/oromisthio(2), misthos/ekkatharistiko(4), misthos/katotatos-misthos(1), asfalisi/efka(2), asfalisi/eisfores(1), asfalisi/ergani(3), asfalisi/ergosimo(1), asfalisi/tekmarto-imeromisthio(1), ygeia/kapnisma(1), syntaxi/ilikia-syntaxis(1), orario/yperoreis(2), orario/ektos-edras(1), orario/ores-ergasias(4), orario/etoimotita(2), orario/karta-ergasias(4), orario/ekti-imera(1), orario/nyxterina(1), orario/vardiakia(2), orario/argies(2), apolysi/ptoxeisi-ergodoti(1), apolysi/apozimiossi(1), apolysi/oikeiotheleis-apoxorisi(1), apolysi/omadikes-apolysi(5, incl. heading «Ρόλος του ΣΕΠΕ»→«Ρόλος της Επιθεώρησης Εργασίας»), apolysi/epischesi-ergasias(2), apolysi/adiki-apolysi(2), symvasi/aniliki(1), symvasi/diavoulefsi(1), symvasi/diathesimotita(2), symvasi/epochiaki(2), symvasi/isi-metaxeirisi(1), symvasi/metavivasi-epixeirisis(1), symvasi/mobbing(1), symvasi/pollapli-apasxolisi(1), symvasi/prosorini-apasxolisi(4), symvasi/sexualiki-parenoxlisi(1), symvasi/anastoli(1), symvasi/vlaptiki-metavoli(1). Tag-frontmatter `ΣΕΠΕ` updated in 10 of these.

**Domain fixes — 8 URL strings across 6 files → `hli.gov.gr`:** asfalisi/ergani(sepe.gov.gr ×2: display+URL), asfalisi/efka(×2), misthos/katotatos-misthos(×1), misthos/oromisthio(×1), plus older-domain `sepe.gr` in adeies/apozimiossi-adias(×1) and adeies/etisia-adia(×1) — normalized to `hli.gov.gr` for consistency (extends the rule; flagged).

**ΣΕΠΕ deliberately RETAINED (6 occurrences, 4 files)** — accurate historical/legislative references, not stale current-name usage: symvasi/anaggelia-proslipsis(«πρώην ΣΕΠΕ»; «αντικατέστησε το ΣΕΠΕ»), symvasi/anangestikes-proslixi(«πρώην ΣΕΠΕ»), symvasi/vivlia-ergodoti(×2 «πρώην ΣΕΠΕ»), asfalisi/ergani(«Ν.3996/2011 — Αναμόρφωση ΣΕΠΕ», the 2011 law's own subject). Index files (4 ΣΕΠΕ in anergia/index, misthos/index, ygeia/index) left to the index-owning agent.

---

## TASK 2 — broken wikilinks

**34 broken links fixed across 25 files.** All resolve now except intentional unlinks (below).

- **Εισφορές → Ασφαλιστικές Εισφορές** (`[[Ασφαλιστικές Εισφορές|Εισφορές]]`): anergia/epidoma, syntaxi/epikouriki-teka(×2), syntaxi/efapax. **Εισφορές ΕΦΚΑ** same target: apolysi/ptoxeisi-ergodoti, symvasi/oikodomoi.
- **Επίδομα Ανεργίας → Επίδομα Ανεργίας (ΔΥΠΑ)**: apolysi/ptoxeisi-ergodoti.
- **Βάρδιες → Βάρδιες και Βαρδιακή Εργασία**: orario/ekti-imera, orario/argies.
- **Τηλεργασία → Τηλεργασία (Εξ Αποστάσεως Εργασία)**: orario/karta-ergasias, orario/tilergasia-diasinoraiki.
- **Εφεδρεία → Εφεδρεία / Ετοιμότητα (On-Call)**: orario/vardiakia.
- **Οικειοθελής Αποχώρηση → Οικειοθελής Αποχώρηση (Παραίτηση)**: apolysi/epischesi-ergasias(×2), symvasi/mobbing, symvasi/vlaptiki-metavoli, symvasi/vevaiosi-proypiresias.
- **Βλαπτική Μεταβολή Όρων Εργασίας → Βλαπτική Μεταβολή**: symvasi/diathesimotita, symvasi/ek-peritropis.
- **Υπερωρία → Υπερωρίες**: symvasi/pollapli-apasxolisi.
- **Σεξουαλική Παρενόχληση → Σεξουαλική Παρενόχληση στον Εργασιακό Χώρο**: symvasi/isi-metaxeirisi.
- **Γονική(ής) Άδεια(ς) Ανατροφής → Γονική Άδεια Ανατροφής Τέκνων**: adeies/thilasmou, symvasi/sympono-symviosis.
- **Άδεια Γάμου → Άδεια Γάμου & Τεκνοποίησης**: symvasi/sympono-symviosis.
- **Δώρα Εορτών** (no such article) → split to `[[Δώρο Χριστουγέννων]]` και `[[Δώρο Πάσχα]]`: symvasi/ek-peritropis.

**Judgement calls / flagged for human review:**
- **`[[ΣΕΠΕ]]` / `[[ΣΕΠΕ|Επιθεώρηση Εργασίας]]` (6 links)** — there is **no article titled «Επιθεώρηση Εργασίας»**, so these are permanently dangling. Unlinked to plain prose «Επιθεώρηση Εργασίας» (grammatically adjusted): symvasi/{anastoli, diathesimotita, metavivasi-epixeirisis, epochiaki, pollapli-apasxolisi, prosorini-apasxolisi}. *If an Επιθεώρηση Εργασίας article is created, re-link these.*
- **`[[Ακυρότητα Απόλυσης]]` (2 links, no such article)** → repointed to closest existing article `[[Άδικη Απόλυση|Ακυρότητα Απόλυσης]]`: symvasi/anastoli, symvasi/metavivasi-epixeirisis. Semantic best-guess — verify «Άδικη Απόλυση» adequately covers ακυρότητα, or create a dedicated article.
- **`[[Συλλογικές Διαπραγματεύσεις]]` (no such article)** → unlinked to plain text in symvasi/sse (kept display «συλλογικών διαπραγματεύσεων»). Candidate for a future article.

Links already resolving were left untouched (e.g. `[[Θάνατος Εργαζομένου|…]]` — normalizes identically to title «Θάνατος Εργαζόμενου»).

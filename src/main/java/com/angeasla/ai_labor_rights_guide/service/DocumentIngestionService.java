package com.angeasla.ai_labor_rights_guide.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Reads the categorized guide markdown under {@code resources/docs/**}, parses YAML frontmatter,
 * strips markdown, extracts headings, and indexes one document per article into BOTH search backends:
 * Meilisearch (always — powers the user search box and the default chat RAG) and, when a Chroma
 * {@link VectorStore} bean is present, ChromaDB (the alternative chat RAG, selected at runtime via
 * {@code app.rag.provider=chroma}). Indexing both keeps the trial flip instant — no re-ingest needed.
 * The Chroma write is best-effort: if Chroma is absent/unreachable it is skipped with a warning.
 */
@Service
public class DocumentIngestionService {

    private static final Logger log = LoggerFactory.getLogger(DocumentIngestionService.class);

    private static final Map<String, String> CATEGORY_LABELS = Map.of(
            "symvasi", "Σύμβαση Εργασίας",
            "orario", "Ωράριο Εργασίας",
            "misthos", "Μισθός & Δώρα",
            "adeies", "Άδειες",
            "asfalisi", "Ασφάλιση",
            "apolysi", "Απόλυση",
            "syntaxi", "Συνταξιοδότηση",
            "ygeia", "Υγεία & Ασφάλεια",
            "anergia", "Ανεργία"
    );

    private static final Pattern HEADING = Pattern.compile("(?m)^#{2,3}\\s+(.+)$");

    private final MeilisearchService meili;
    /** Optional — present only when the Chroma vector-store starter is configured/reachable. */
    private final ObjectProvider<VectorStore> chromaVectorStore;

    public DocumentIngestionService(MeilisearchService meili, ObjectProvider<VectorStore> chromaVectorStore) {
        this.meili = meili;
        this.chromaVectorStore = chromaVectorStore;
    }

    public String ingestData() {
        try {
            Resource[] resources = new PathMatchingResourcePatternResolver()
                    .getResources("classpath:/docs/**/*.md");
            List<Map<String, Object>> documents = new ArrayList<>();
            List<Document> chromaDocs = new ArrayList<>();

            for (Resource resource : resources) {
                String slug = slugOf(resource);
                if (slug == null) {
                    continue;
                }
                String raw;
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                    raw = reader.lines().collect(Collectors.joining("\n"));
                }

                Parsed p = parse(raw);
                String category = p.frontmatter.getOrDefault("category", categoryFromSlug(slug));
                String title = p.frontmatter.getOrDefault("title", slug);
                String plain = stripMarkdown(p.body);
                List<String> headings = headings(p.body);
                String excerpt = plain.length() > 300 ? plain.substring(0, 300).trim() + "…" : plain;
                String id = slug.replace("/", "-");
                String url = "#/" + slug;
                String categoryLabel = CATEGORY_LABELS.getOrDefault(category, category);

                Map<String, Object> doc = new LinkedHashMap<>();
                doc.put("id", id);
                doc.put("slug", slug);
                doc.put("url", url);
                doc.put("title", title);
                doc.put("category", category);
                doc.put("categoryLabel", categoryLabel);
                doc.put("headings", headings);
                doc.put("body", plain);
                doc.put("excerpt", excerpt);
                doc.put("_vectors", Map.of("default", meili.embed(title + "\n" + plain)));
                documents.add(doc);

                // Chroma doc: stable id (= slug) so re-ingest replaces; embed title+body (same input as
                // Meili, fair comparison); keep clean body in metadata so get_article returns plain text.
                Map<String, Object> meta = new LinkedHashMap<>();
                meta.put("slug", slug);
                meta.put("title", title);
                meta.put("url", url);
                meta.put("category", category);
                meta.put("categoryLabel", categoryLabel);
                meta.put("excerpt", excerpt);
                meta.put("body", plain);
                chromaDocs.add(Document.builder().id(id).text(title + "\n" + plain).metadata(meta).build());
            }

            if (documents.isEmpty()) {
                return "No markdown articles found under classpath:/docs/.";
            }
            meili.reindex(documents);
            return "Indexed " + documents.size() + " articles into Meilisearch." + indexIntoChroma(chromaDocs);
        } catch (Exception e) {
            log.error("Ingestion failed", e);
            return "Error during ingestion: " + e.getMessage();
        }
    }

    /**
     * Best-effort upsert into Chroma (delete-by-id then add, so it is idempotent). Returns a short
     * status suffix. Never throws — if Chroma is absent or down, the Meili ingest above still succeeds.
     */
    private String indexIntoChroma(List<Document> chromaDocs) {
        VectorStore vectorStore = chromaVectorStore.getIfAvailable();
        if (vectorStore == null) {
            return " Chroma not configured — skipped.";
        }
        try {
            List<String> ids = chromaDocs.stream().map(Document::getId).toList();
            try {
                vectorStore.delete(ids);
            } catch (Exception e) {
                log.debug("Chroma delete-before-add skipped (likely first run): {}", e.getMessage());
            }
            vectorStore.add(chromaDocs);
            return " Indexed " + chromaDocs.size() + " into ChromaDB.";
        } catch (Exception e) {
            log.warn("Chroma ingestion skipped: {}", e.getMessage());
            return " Chroma ingestion skipped (" + e.getMessage() + ").";
        }
    }

    // ---- parsing helpers ----

    private record Parsed(Map<String, String> frontmatter, String body) {
    }

    private static Parsed parse(String raw) {
        Map<String, String> fm = new LinkedHashMap<>();
        String body = raw;
        if (raw.startsWith("---")) {
            int end = raw.indexOf("\n---", 3);
            if (end > 0) {
                String block = raw.substring(3, end);
                body = raw.substring(raw.indexOf('\n', end + 1) + 1);
                for (String line : block.split("\n")) {
                    Matcher m = Pattern.compile("^([\\w-]+)\\s*:\\s*(.+)$").matcher(line.trim());
                    if (m.matches()) {
                        fm.put(m.group(1), m.group(2).trim());
                    }
                }
            }
        }
        return new Parsed(fm, body);
    }

    private static List<String> headings(String body) {
        List<String> out = new ArrayList<>();
        Matcher m = HEADING.matcher(body);
        while (m.find()) {
            out.add(m.group(1).trim());
        }
        return out;
    }

    /** Best-effort markdown → plain text for indexing/excerpts. */
    static String stripMarkdown(String md) {
        String s = md;
        s = s.replaceAll("(?s)```.*?```", " ");          // fenced code
        s = s.replaceAll("`[^`]*`", " ");                  // inline code
        s = s.replaceAll("!\\[[^\\]]*\\]\\([^)]*\\)", " "); // images
        s = s.replaceAll("\\[\\[([^\\]|]+)(?:\\|([^\\]]+))?\\]\\]", "$1"); // [[wiki|alias]] -> wiki text
        s = s.replaceAll("\\[([^\\]]+)\\]\\([^)]*\\)", "$1"); // [text](url) -> text
        s = s.replaceAll("(?m)^#{1,6}\\s*", "");            // heading markers
        s = s.replaceAll("(?m)^>\\s?", "");                 // blockquotes
        s = s.replaceAll("(?m)^\\s*[-*+]\\s+", "");         // list markers
        s = s.replaceAll("[*_~]", "");                      // emphasis
        s = s.replaceAll("\\s+", " ");                       // collapse whitespace
        return s.trim();
    }

    private static String slugOf(Resource resource) {
        try {
            String url = resource.getURL().toString();
            int idx = url.indexOf("/docs/");
            if (idx < 0) {
                return null;
            }
            String rel = url.substring(idx + "/docs/".length());
            return rel.endsWith(".md") ? rel.substring(0, rel.length() - 3) : rel;
        } catch (Exception e) {
            return null;
        }
    }

    private static String categoryFromSlug(String slug) {
        int slash = slug.indexOf('/');
        return slash > 0 ? slug.substring(0, slash) : "";
    }
}

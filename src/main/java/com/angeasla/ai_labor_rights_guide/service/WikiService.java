package com.angeasla.ai_labor_rights_guide.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.Collator;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Serves the guide articles to the frontend so they live in ONE place (the backend's
 * {@code resources/docs/**}, synced from the canonical content/ vault). Builds the navigation index
 * (categories + [[wiki-link]] resolution map) and serves raw markdown per article.
 */
@Service
public class WikiService {

    private static final Logger log = LoggerFactory.getLogger(WikiService.class);

    public record ArticleEntry(String title, String path, List<String> tags) {
    }

    public record WikiCategory(String category, String categoryTitle, String icon, List<ArticleEntry> articles) {
    }

    public record WikiIndex(List<WikiCategory> categories, Map<String, String> linkMap) {
    }

    private static final Map<String, String> TITLES = Map.ofEntries(
            Map.entry("adeies", "Άδειες"),
            Map.entry("anergia", "Ανεργία"),
            Map.entry("apolysi", "Απόλυση & Παραίτηση"),
            Map.entry("asfalisi", "Ασφάλιση & ΕΦΚΑ"),
            Map.entry("misthos", "Μισθός & Δώρα"),
            Map.entry("orario", "Ωράριο & Βάρδιες"),
            Map.entry("symvasi", "Σύμβαση Εργασίας"),
            Map.entry("syntaxi", "Συντάξεις"),
            Map.entry("ygeia", "Υγεία & Ασφάλεια"),
            Map.entry(".", "Γενικά")
    );
    private static final Map<String, String> ICONS = Map.ofEntries(
            Map.entry("adeies", "event_available"),
            Map.entry("anergia", "work_off"),
            Map.entry("apolysi", "person_remove"),
            Map.entry("asfalisi", "shield"),
            Map.entry("misthos", "payments"),
            Map.entry("orario", "schedule"),
            Map.entry("symvasi", "description"),
            Map.entry("syntaxi", "account_balance"),
            Map.entry("ygeia", "health_and_safety"),
            Map.entry(".", "folder")
    );

    private static final Pattern FM_LINE = Pattern.compile("^([\\w-]+)\\s*:\\s*(.+)$");
    private static final Pattern DIACRITICS = Pattern.compile("\\p{M}+");

    private volatile WikiIndex cached;

    /** Navigation index (cached after first build; content changes require a restart/redeploy). */
    public WikiIndex index() {
        WikiIndex i = cached;
        if (i == null) {
            synchronized (this) {
                if (cached == null) {
                    cached = build();
                }
                i = cached;
            }
        }
        return i;
    }

    /** Raw markdown for an article by its docs-relative path (e.g. "misthos/oromisthio.md"), or null. */
    public String rawMarkdownByPath(String rel) {
        if (rel == null || rel.isBlank() || rel.contains("..") || rel.contains("\\")) {
            throw new IllegalArgumentException("invalid path");
        }
        try (InputStream in = new ClassPathResource("docs/" + rel).getInputStream();
             BufferedReader r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            return r.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            return null;
        }
    }

    private WikiIndex build() {
        Map<String, List<ArticleEntry>> byCategory = new LinkedHashMap<>();
        Map<String, String> linkMap = new java.util.HashMap<>();
        try {
            Resource[] resources = new PathMatchingResourcePatternResolver()
                    .getResources("classpath:/docs/**/*.md");
            for (Resource resource : resources) {
                String path = relPath(resource);
                if (path == null) {
                    continue;
                }
                Map<String, String> fm = frontmatter(read(resource));
                String parent = path.contains("/") ? path.substring(0, path.indexOf('/')) : ".";
                String category = fm.getOrDefault("category", parent);
                String title = fm.getOrDefault("title", baseName(path));
                List<String> tags = parseList(fm.get("tags"));

                byCategory.computeIfAbsent(category, k -> new ArrayList<>())
                        .add(new ArticleEntry(title, path, tags));

                String titleKey = normalize(title);
                if (!titleKey.isEmpty()) {
                    linkMap.put(titleKey, path);
                }
                String fileKey = normalize(baseName(path));
                if (!fileKey.isEmpty() && !fileKey.equals("index") && !fileKey.equals("general_index")) {
                    linkMap.put(fileKey, path);
                }
                for (String alias : parseList(fm.get("aliases"))) {
                    String key = normalize(alias);
                    if (!key.isEmpty()) {
                        linkMap.put(key, path);
                    }
                }
            }
        } catch (IOException e) {
            log.error("Failed to build wiki index", e);
        }

        Collator collator = Collator.getInstance(Locale.forLanguageTag("el"));
        List<WikiCategory> categories = new ArrayList<>();
        for (Map.Entry<String, List<ArticleEntry>> e : byCategory.entrySet()) {
            List<ArticleEntry> articles = new ArrayList<>(e.getValue());
            articles.sort((a, b) -> collator.compare(a.title(), b.title()));
            categories.add(new WikiCategory(e.getKey(),
                    TITLES.getOrDefault(e.getKey(), e.getKey()),
                    ICONS.getOrDefault(e.getKey(), "folder"),
                    articles));
        }
        log.info("Wiki index built: {} categories, {} link entries.", categories.size(), linkMap.size());
        return new WikiIndex(categories, linkMap);
    }

    // ---- helpers ----

    private static Map<String, String> frontmatter(String raw) {
        Map<String, String> fm = new LinkedHashMap<>();
        if (raw != null && raw.startsWith("---")) {
            int end = raw.indexOf("\n---", 3);
            if (end > 0) {
                for (String line : raw.substring(3, end).split("\n")) {
                    Matcher m = FM_LINE.matcher(line.trim());
                    if (m.matches()) {
                        fm.put(m.group(1), m.group(2).trim());
                    }
                }
            }
        }
        return fm;
    }

    /** Parse a YAML-ish list: "[a, b]" or "a, b" → [a, b]. */
    private static List<String> parseList(String value) {
        if (value == null || value.isBlank()) {
            return List.of();
        }
        String v = value.trim();
        if (v.startsWith("[") && v.endsWith("]")) {
            v = v.substring(1, v.length() - 1);
        }
        List<String> out = new ArrayList<>();
        for (String part : v.split(",")) {
            String t = part.trim().replaceAll("^[\"']|[\"']$", "");
            if (!t.isEmpty()) {
                out.add(t);
            }
        }
        return out;
    }

    private static String normalize(String s) {
        if (s == null) {
            return "";
        }
        String n = Normalizer.normalize(s, Normalizer.Form.NFD);
        return DIACRITICS.matcher(n).replaceAll("").toLowerCase(Locale.ROOT).trim();
    }

    private static String baseName(String path) {
        String name = path.substring(path.lastIndexOf('/') + 1);
        return name.endsWith(".md") ? name.substring(0, name.length() - 3) : name;
    }

    private static String read(Resource r) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(r.getInputStream(), StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }

    private static String relPath(Resource r) {
        try {
            String url = r.getURL().toString();
            int idx = url.indexOf("/docs/");
            return idx < 0 ? null : url.substring(idx + "/docs/".length());
        } catch (IOException e) {
            return null;
        }
    }

}

package com.angeasla.ai_labor_rights_guide.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

/**
 * Thin client for Meilisearch over its REST API (Spring {@link RestClient}). Provides hybrid
 * (keyword + vector) search, document upsert, and index configuration. Vectors are computed locally
 * by the transformers {@link EmbeddingModel} and supplied to Meili as a {@code userProvided} embedder,
 * so there is no external embedding API and no separate vector database.
 */
@Service
public class MeilisearchService {

    private static final Logger log = LoggerFactory.getLogger(MeilisearchService.class);

    private final RestClient client;
    private final EmbeddingModel embeddingModel;
    private final String index;
    private final double semanticRatio;
    private final String embedder;

    public MeilisearchService(
            EmbeddingModel embeddingModel,
            @Value("${meilisearch.url}") String url,
            @Value("${meilisearch.key:}") String key,
            @Value("${meilisearch.index:articles}") String index,
            @Value("${meilisearch.semantic-ratio:0.5}") double semanticRatio,
            @Value("${meilisearch.embedder:default}") String embedder) {
        this.embeddingModel = embeddingModel;
        this.index = index;
        this.semanticRatio = semanticRatio;
        this.embedder = embedder;
        RestClient.Builder b = RestClient.builder().baseUrl(url);
        if (key != null && !key.isBlank()) {
            b = b.defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + key);
        }
        this.client = b.build();
    }

    /** Local embedding for a piece of text (length = the model's dimension, e.g. 384). */
    public float[] embed(String text) {
        return embeddingModel.embed(text);
    }

    /**
     * Create the index if missing and apply settings: searchable/filterable attributes, typo tolerance,
     * and a userProvided embedder whose dimension matches the local model. Best-effort and idempotent.
     */
    public void ensureIndexConfigured() {
        // Vector/hybrid search is experimental in some Meili versions — enable it, ignore if N/A.
        tryPatch("/experimental-features", Map.of("vectorStore", true));

        try {
            client.post().uri("/indexes").contentType(MediaType.APPLICATION_JSON)
                    .body(Map.of("uid", index, "primaryKey", "id"))
                    .retrieve().toBodilessEntity();
        } catch (Exception e) {
            log.debug("Index '{}' may already exist: {}", index, e.getMessage());
        }

        int dims = embed("dimension probe").length;
        Map<String, Object> settings = Map.of(
                "searchableAttributes", List.of("title", "headings", "body"),
                "filterableAttributes", List.of("category", "slug"),
                "typoTolerance", Map.of("enabled", true,
                        "minWordSizeForTypos", Map.of("oneTypo", 4, "twoTypos", 8)),
                "embedders", Map.of(embedder, Map.of("source", "userProvided", "dimensions", dims))
        );
        tryPatch("/indexes/" + index + "/settings", settings);
        log.info("Meilisearch index '{}' configured (embedder '{}', {} dims).", index, embedder, dims);
    }

    /** Replace the whole corpus: clear then add. */
    public void reindex(List<Map<String, Object>> documents) {
        ensureIndexConfigured();
        try {
            client.delete().uri("/indexes/" + index + "/documents").retrieve().toBodilessEntity();
        } catch (Exception e) {
            log.warn("Could not clear index before reindex: {}", e.getMessage());
        }
        client.post().uri("/indexes/" + index + "/documents")
                .contentType(MediaType.APPLICATION_JSON).body(documents)
                .retrieve().toBodilessEntity();
        log.info("Submitted {} documents to Meilisearch index '{}'.", documents.size(), index);
    }

    /** Hybrid search: embeds the query locally and blends keyword + vector results. */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> search(String query, int limit) {
        int clamped = Math.max(1, Math.min(limit, 10));
        Map<String, Object> body = Map.of(
                "q", query,
                "limit", clamped,
                "hybrid", Map.of("semanticRatio", semanticRatio, "embedder", embedder),
                "vector", embed(query),
                "attributesToRetrieve", List.of("title", "url", "category", "categoryLabel", "excerpt", "slug"),
                "attributesToHighlight", List.of("title", "excerpt"),
                "highlightPreTag", "<mark>",
                "highlightPostTag", "</mark>"
        );
        Map<String, Object> resp = client.post().uri("/indexes/" + index + "/search")
                .contentType(MediaType.APPLICATION_JSON).body(body)
                .retrieve().body(Map.class);
        if (resp == null || resp.get("hits") == null) {
            return List.of();
        }
        return (List<Map<String, Object>>) resp.get("hits");
    }

    /** Fetch a single article's full document by slug (e.g. "misthos/oromisthio"). */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getBySlug(String slug) {
        String id = slug.replace("/", "-");
        try {
            return client.get().uri("/indexes/" + index + "/documents/" + id)
                    .retrieve().body(Map.class);
        } catch (Exception e) {
            log.debug("Article '{}' not found: {}", slug, e.getMessage());
            return null;
        }
    }

    private void tryPatch(String uri, Map<String, Object> body) {
        try {
            client.patch().uri(uri).contentType(MediaType.APPLICATION_JSON).body(body)
                    .retrieve().toBodilessEntity();
        } catch (Exception e) {
            log.debug("PATCH {} skipped/failed: {}", uri, e.getMessage());
        }
    }
}

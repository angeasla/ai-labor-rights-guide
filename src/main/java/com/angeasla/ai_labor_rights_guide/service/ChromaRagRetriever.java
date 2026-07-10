package com.angeasla.ai_labor_rights_guide.service;

import com.angeasla.ai_labor_rights_guide.dto.ArticleContent;
import com.angeasla.ai_labor_rights_guide.dto.SearchResult;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.filter.FilterExpressionBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Alternative RAG backend: grounds the chat in ChromaDB vector similarity. Active when
 * {@code app.rag.provider=chroma}. Reads the documents that {@code DocumentIngestionService} writes to
 * Chroma (one per article; full body in metadata so {@code get_article} returns clean text). The local
 * transformers {@link org.springframework.ai.embedding.EmbeddingModel} embeds queries inside the
 * Chroma {@link VectorStore} — same model Meili uses, so the two backends are a fair comparison.
 *
 * <p>The user search box is unaffected — it always uses Meilisearch (see {@link RagRetriever}).
 */
@Service
@ConditionalOnProperty(name = "app.rag.provider", havingValue = "chroma")
public class ChromaRagRetriever implements RagRetriever {

    private final VectorStore vectorStore;

    public ChromaRagRetriever(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @Override
    public List<SearchResult> search(String query, int limit) {
        int k = Math.max(1, Math.min(limit, 10));
        List<Document> hits = vectorStore.similaritySearch(
                SearchRequest.builder().query(query).topK(k).build());
        List<SearchResult> out = new ArrayList<>();
        if (hits == null) {
            return out;
        }
        for (Document d : hits) {
            Map<String, Object> m = d.getMetadata();
            out.add(new SearchResult(
                    str(m.get("title")),
                    str(m.get("url")),
                    str(m.getOrDefault("categoryLabel", m.get("category"))),
                    str(m.get("excerpt")),
                    str(m.get("slug"))));
        }
        return out;
    }

    @Override
    public ArticleContent getArticle(String slug) {
        // Exact metadata filter (not similarity) so we fetch the one article by slug. topK=1.
        var filter = new FilterExpressionBuilder().eq("slug", slug).build();
        List<Document> hits = vectorStore.similaritySearch(
                SearchRequest.builder().query(slug).topK(1).filterExpression(filter).build());
        if (hits == null || hits.isEmpty()) {
            return null;
        }
        Document d = hits.getFirst();
        Object body = d.getMetadata().getOrDefault("body", d.getText());
        return new ArticleContent(slug, str(d.getMetadata().get("title")), str(body));
    }

    private static String str(Object o) {
        return o == null ? "" : o.toString();
    }
}

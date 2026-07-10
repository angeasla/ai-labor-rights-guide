package com.angeasla.ai_labor_rights_guide.service;

import com.angeasla.ai_labor_rights_guide.dto.ArticleContent;
import com.angeasla.ai_labor_rights_guide.dto.SearchResult;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default RAG backend: grounds the chat in Meilisearch hybrid (keyword + vector) results, reusing the
 * same {@link SearchService} that powers the user search box. Active when {@code app.rag.provider=meili}
 * (the default).
 */
@Service
@ConditionalOnProperty(name = "app.rag.provider", havingValue = "meili", matchIfMissing = true)
public class MeiliRagRetriever implements RagRetriever {

    private final SearchService searchService;

    public MeiliRagRetriever(SearchService searchService) {
        this.searchService = searchService;
    }

    @Override
    public List<SearchResult> search(String query, int limit) {
        return searchService.searchArticles(query, limit);
    }

    @Override
    public ArticleContent getArticle(String slug) {
        return searchService.getArticle(slug);
    }
}

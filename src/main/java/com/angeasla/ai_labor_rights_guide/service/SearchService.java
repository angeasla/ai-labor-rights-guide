package com.angeasla.ai_labor_rights_guide.service;

import com.angeasla.ai_labor_rights_guide.dto.ArticleContent;
import com.angeasla.ai_labor_rights_guide.dto.SearchResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Maps raw Meilisearch hits to typed results for the UI endpoint and the LLM tools. */
@Service
public class SearchService {

    private final MeilisearchService meili;

    public SearchService(MeilisearchService meili) {
        this.meili = meili;
    }

    public List<SearchResult> searchArticles(String query, int limit) {
        List<SearchResult> out = new ArrayList<>();
        for (Map<String, Object> hit : meili.search(query, limit)) {
            @SuppressWarnings("unchecked")
            Map<String, Object> formatted = (Map<String, Object>) hit.get("_formatted");
            String title = str(formatted != null ? formatted.get("title") : hit.get("title"));
            String excerpt = str(formatted != null ? formatted.get("excerpt") : hit.get("excerpt"));
            String category = str(hit.getOrDefault("categoryLabel", hit.get("category")));
            out.add(new SearchResult(title, str(hit.get("url")), category, excerpt));
        }
        return out;
    }

    public ArticleContent getArticle(String slug) {
        Map<String, Object> doc = meili.getBySlug(slug);
        if (doc == null) {
            return null;
        }
        return new ArticleContent(slug, str(doc.get("title")), str(doc.get("body")));
    }

    private static String str(Object o) {
        return o == null ? "" : o.toString();
    }
}

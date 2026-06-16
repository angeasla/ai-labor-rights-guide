package com.angeasla.ai_labor_rights_guide.service;

import com.angeasla.ai_labor_rights_guide.dto.ArticleContent;
import com.angeasla.ai_labor_rights_guide.dto.SearchResult;

import java.util.List;

/**
 * Retrieval source for the CHAT's grounding tools ({@code search_articles} / {@code get_article}).
 * Selectable at runtime via {@code app.rag.provider} (meili | chroma) for the Meili-hybrid-vs-Chroma
 * trial — see the two implementations.
 *
 * <p>NOTE: this is the LLM grounding path only. The user-facing {@code /api/search} box ALWAYS uses
 * Meilisearch (via {@link SearchService} directly) regardless of this setting.
 */
public interface RagRetriever {

    /** Ranked article hits for a query (excerpts only). */
    List<SearchResult> search(String query, int limit);

    /** Full article body by slug (e.g. {@code "misthos/oromisthio"}), or null if not found. */
    ArticleContent getArticle(String slug);
}

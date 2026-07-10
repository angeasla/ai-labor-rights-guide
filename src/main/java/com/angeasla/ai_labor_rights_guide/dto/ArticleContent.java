package com.angeasla.ai_labor_rights_guide.dto;

/** Full article text returned by the get_article tool so the LLM can ground its answer. */
public record ArticleContent(String slug, String title, String body) {
}

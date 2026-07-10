package com.angeasla.ai_labor_rights_guide.dto;

/** A single search hit returned to the UI and to the LLM's search_articles tool. */
public record SearchResult(String title, String url, String category, String excerpt, String slug) {
}

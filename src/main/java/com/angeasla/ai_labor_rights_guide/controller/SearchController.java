package com.angeasla.ai_labor_rights_guide.controller;

import com.angeasla.ai_labor_rights_guide.dto.SearchResult;
import com.angeasla.ai_labor_rights_guide.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** User-facing search endpoint backing the Angular search box (hybrid keyword + vector). */
@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public List<SearchResult> search(@RequestParam String q,
                                     @RequestParam(defaultValue = "5") int limit) {
        if (q == null || q.isBlank()) {
            return List.of();
        }
        return searchService.searchArticles(q, limit);
    }
}

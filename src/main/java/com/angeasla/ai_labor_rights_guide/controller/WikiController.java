package com.angeasla.ai_labor_rights_guide.controller;

import com.angeasla.ai_labor_rights_guide.service.WikiService;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

/**
 * Serves the guide content so it lives in a single place (the backend). The Angular wiki fetches the
 * navigation index and raw article markdown from here instead of bundling its own copy.
 */
@RestController
@RequestMapping("/api/wiki")
public class WikiController {

    private final WikiService wiki;

    public WikiController(WikiService wiki) {
        this.wiki = wiki;
    }

    private static final CacheControl WIKI_CACHE =
            CacheControl.maxAge(Duration.ofHours(24)).mustRevalidate().cachePublic();

    @GetMapping("/index")
    public ResponseEntity<WikiService.WikiIndex> index() {
        return ResponseEntity.ok().cacheControl(WIKI_CACHE).body(wiki.index());
    }

    @GetMapping(value = "/article/{*path}", produces = "text/markdown;charset=UTF-8")
    public ResponseEntity<String> article(@PathVariable String path) {
        String rel = path.startsWith("/") ? path.substring(1) : path;
        String markdown = wiki.rawMarkdownByPath(rel);
        return markdown == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok()
                        .cacheControl(WIKI_CACHE)
                        .contentType(MediaType.valueOf("text/markdown;charset=UTF-8"))
                        .body(markdown);
    }
}

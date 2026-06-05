package com.angeasla.ai_labor_rights_guide.controller;

import com.angeasla.ai_labor_rights_guide.service.DocumentIngestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// NOTE: This endpoint is protected by a secret header (X-Admin-Secret).
// In a production environment with no need for runtime re-ingestion, consider
// disabling this endpoint entirely using a Spring profile (@Profile("!prod")).
@RestController
@RequestMapping("/api/admin")
@Tag(name = "Admin", description = "Admin operations — not for public use")
public class AdminController {

    private final DocumentIngestionService ingestionService;

    @Value("${admin.secret}")
    private String adminSecret;

    public AdminController(DocumentIngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @Operation(summary = "Ingest documents", description = "Reads all markdown files from /docs, splits them into chunks, embeds them and stores in ChromaDB. Run once on first setup or when documents change. Requires X-Admin-Secret header.")
    @PostMapping("/ingest")
    public ResponseEntity<String> ingestDocuments(
            @RequestHeader(value = "X-Admin-Secret", required = false) String secret) {

        if (secret == null || !secret.equals(adminSecret)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        return ResponseEntity.ok(ingestionService.ingestData());
    }
}

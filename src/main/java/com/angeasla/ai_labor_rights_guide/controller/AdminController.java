package com.angeasla.ai_labor_rights_guide.controller;

import com.angeasla.ai_labor_rights_guide.service.DocumentIngestionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final DocumentIngestionService ingestionService;

    public AdminController(DocumentIngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    //Endpoint: POST /api/admin/ingest
    @PostMapping("/ingest")
    public String ingestDocuments() {
        return ingestionService.ingestData();
    }
}

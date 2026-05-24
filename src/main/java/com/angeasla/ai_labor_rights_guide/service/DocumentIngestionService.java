package com.angeasla.ai_labor_rights_guide.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DocumentIngestionService {

    private static final Logger logger = LoggerFactory.getLogger(DocumentIngestionService.class);

    //Spring Boot automatically injects Chroma VectorStore
    private final VectorStore vectorStore;

    // Automatically reads all .md files from src/main/resources/docs/
    @Value("classpath:/docs/*.md")
    private Resource[] markdownFiles;

    public DocumentIngestionService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public String ingestData() {
        try {
            org.springframework.core.io.support.PathMatchingResourcePatternResolver resourceResolver =
                    new org.springframework.core.io.support.PathMatchingResourcePatternResolver();

            // Read all .md files from target
            Resource[] resources = resourceResolver.getResources("classpath:/docs/*.md");
            List<org.springframework.ai.document.Document> allDocuments = new ArrayList<>();

            for (Resource resource : resources) {
                // Read the entire text of the file
                String content;
                try (java.io.BufferedReader reader = new java.io.BufferedReader(
                        new java.io.InputStreamReader(resource.getInputStream(), java.nio.charset.StandardCharsets.UTF_8))) {
                    content = reader.lines().collect(java.util.stream.Collectors.joining("\n"));
                }

                // Break the text into large paragraphs (chunks) based on empty lines
                String[] paragraphs = content.split("\n\n");

                for (int i = 0; i < paragraphs.length; i++) {
                    String text = paragraphs[i].trim();
                    if (text.isEmpty()) continue;

                    // Create a clean Document for Spring AI without auto-splitters
                    Map<String, Object> metadata = new HashMap<>();
                    metadata.put("source", resource.getFilename());
                    metadata.put("chunk_index", i);

                    allDocuments.add(new org.springframework.ai.document.Document(text, metadata));
                }

                logger.info("Successfully read file: {} with {} chunks.", resource.getFilename(), allDocuments.size());
            }

            // Send the clean text to ChromaDB
            if (!allDocuments.isEmpty()) {
                vectorStore.accept(allDocuments);
                return "Done! " + resources.length + " Markdown files read and saved (" + allDocuments.size() + " total chunks).";
            }

            return "No data found for ingestion.";

        } catch (Exception e) {
            return "Error during ingestion: " + e.getMessage();
        }
    }
}
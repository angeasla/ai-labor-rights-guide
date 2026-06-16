package com.angeasla.ai_labor_rights_guide.controller;

import com.angeasla.ai_labor_rights_guide.dto.ChatMessageDto;
import org.junit.jupiter.api.Test;
import org.springframework.ai.retry.NonTransientAiException;
import org.springframework.ai.retry.TransientAiException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pure-POJO tests for the chat fallback advice (no Spring context / MockMvc). Each handler must return the
 * static Greek fallback as a role="ai" bubble so the frontend renders it as a normal chat message.
 */
class ChatExceptionHandlerTest {

    private final ChatExceptionHandler handler = new ChatExceptionHandler();

    private static void assertFallback(ChatMessageDto dto) {
        assertNotNull(dto);
        assertEquals("ai", dto.getRole());
        assertNotNull(dto.getContent());
        assertTrue(dto.getContent().contains("Προσωρινό πρόβλημα με τον βοηθό"),
                "fallback should carry the Greek outage message");
        assertTrue(dto.getContent().contains("[τον οδηγό](/wiki)"),
                "fallback should include the clickable markdown link to the guide");
    }

    @Test
    void transientAiExceptionReturnsFallback() {
        assertFallback(handler.handleAiException(new TransientAiException("DeepSeek 503")));
    }

    @Test
    void nonTransientAiExceptionReturnsFallback() {
        assertFallback(handler.handleAiException(new NonTransientAiException("DeepSeek 400")));
    }

    @Test
    void restClientTimeoutReturnsFallback() {
        // ResourceAccessException (a RestClientException) models a read/connect timeout to DeepSeek.
        assertFallback(handler.handleRestClientException(new ResourceAccessException("read timed out")));
    }

    @Test
    void restClientExceptionReturnsFallback() {
        assertFallback(handler.handleRestClientException(new RestClientException("connection reset")));
    }

    @Test
    void catchAllReturnsFallback() {
        assertFallback(handler.handleAny(new RuntimeException("unexpected")));
    }
}

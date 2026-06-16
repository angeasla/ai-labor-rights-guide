package com.angeasla.ai_labor_rights_guide.controller;

import com.angeasla.ai_labor_rights_guide.dto.ChatMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.retry.NonTransientAiException;
import org.springframework.ai.retry.TransientAiException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

/**
 * Turns DeepSeek upstream failures into a graceful, user-facing fallback for {@code POST /api/chat} only.
 * Automatic retry is intentionally disabled ({@code spring.ai.retry.max-attempts=1}) to cap token/cost on a
 * flaky upstream, so the very first {@code .call()} failure surfaces here instead of being retried; this
 * advice catches it and returns a normal chat bubble rather than a raw HTTP 500. Scoped via
 * {@code assignableTypes = ChatController.class} so it never swallows exceptions from the calculator, search
 * or wiki controllers.
 */
@RestControllerAdvice(assignableTypes = ChatController.class)
public class ChatExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ChatExceptionHandler.class);

    // The SPA has no /search route — search is a toolbar box on every page; /wiki is a real route.
    private static final String FALLBACK_MESSAGE =
            "⚠️ Προσωρινό πρόβλημα με τον βοηθό — δοκίμασε ξανά σε λίγο. Στο μεταξύ, μπορείς να ψάξεις από τη "
                    + "μπάρα αναζήτησης στην κορυφή της σελίδας ή να δεις [τον οδηγό](/wiki).";

    /**
     * DeepSeek failures wrapped by Spring AI's retry layer. {@link TransientAiException} covers retryable
     * upstream errors (e.g. 5xx / rate limits) and {@link NonTransientAiException} the non-retryable ones;
     * with retry disabled, either can reach the controller on the first attempt.
     */
    @ExceptionHandler({TransientAiException.class, NonTransientAiException.class})
    public ChatMessageDto handleAiException(RuntimeException ex) {
        return fallback(ex);
    }

    /**
     * Failures from the {@code RestClient} the DeepSeek client uses. {@link RestClientException} is the
     * superclass of both {@code HttpStatusCodeException} (5xx HTTP errors) and {@code ResourceAccessException}
     * (read / connect timeouts), so this single handler covers timeouts and HTTP errors alike.
     */
    @ExceptionHandler(RestClientException.class)
    public ChatMessageDto handleRestClientException(RestClientException ex) {
        return fallback(ex);
    }

    /**
     * Logs the underlying outage at WARN (with the exception, so ops sees the stack trace) and returns the
     * static Greek fallback as a role="ai" bubble. Returns HTTP 200 by design: this is graceful degradation,
     * not an error — the Angular frontend renders {@code content} as ordinary chat markdown.
     */
    private ChatMessageDto fallback(Exception ex) {
        log.warn("DeepSeek chat call failed; returning graceful fallback to /api/chat", ex);

        ChatMessageDto response = new ChatMessageDto();
        response.setRole("ai");
        response.setContent(FALLBACK_MESSAGE);
        return response;
    }
}

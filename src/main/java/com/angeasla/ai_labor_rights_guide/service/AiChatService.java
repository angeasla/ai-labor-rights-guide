package com.angeasla.ai_labor_rights_guide.service;

import com.angeasla.ai_labor_rights_guide.calc.CalculatorTools;
import com.angeasla.ai_labor_rights_guide.dto.ChatMessageDto;
import com.angeasla.ai_labor_rights_guide.dto.ChatRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Chat orchestration. The LLM grounds answers via tools (search_articles → get_article) and computes
 * figures via the calculator tools — there is no pre-injected context. The system prompt is loaded from
 * {@code resources/prompts/system-prompt.md} (not hardcoded).
 *
 * <p>Incoming messages pass through {@link ChatInputGuard} (per-message truncation + total-budget
 * trimming) before the prompt is built, and every successful call's token usage is handed to
 * {@link UsageCostService} for cost logging and the daily-spend alert. Provider errors (DeepSeek 5xx /
 * timeouts) are intentionally left to propagate — outage fallback is handled by a controller advice.
 */
@Service
public class AiChatService {

    private static final Logger log = LoggerFactory.getLogger(AiChatService.class);

    private final ChatClient chatClient;
    private final ChatInputGuard inputGuard;
    private final UsageCostService usageCostService;

    public AiChatService(ChatClient.Builder chatClientBuilder,
                         CalculatorTools calculatorTools,
                         SearchTools searchTools,
                         ChatInputGuard inputGuard,
                         UsageCostService usageCostService,
                         @Value("classpath:prompts/system-prompt.md") Resource systemPrompt) throws IOException {
        String prompt = systemPrompt.getContentAsString(StandardCharsets.UTF_8);
        this.inputGuard = inputGuard;
        this.usageCostService = usageCostService;
        this.chatClient = chatClientBuilder
                .defaultSystem(prompt)
                .defaultTools(calculatorTools, searchTools)
                .build();
    }

    public String generateResponse(ChatRequestDto request) {
        List<ChatMessageDto> messages = request.getMessages();
        if (messages == null || messages.isEmpty()) {
            return "Παρακαλώ γράψτε μια ερώτηση.";
        }

        // Prompt-stuffing defense: truncate over-long messages and trim history to the input budget
        // before anything reaches the LLM.
        messages = inputGuard.sanitize(messages);

        List<Message> springMessages = new ArrayList<>();
        for (ChatMessageDto msg : messages) {
            if ("user".equalsIgnoreCase(msg.getRole())) {
                springMessages.add(new UserMessage(msg.getContent()));
            } else {
                springMessages.add(new AssistantMessage(msg.getContent()));
            }
        }

        ChatResponse response = this.chatClient.prompt()
                .messages(springMessages)
                .call()
                .chatResponse();

        recordUsage(response);

        if (response == null || response.getResult() == null || response.getResult().getOutput() == null) {
            log.warn("Chat response had no result/output (e.g. token budget exhausted mid-tool-chain)");
            return "Συγγνώμη, δεν μπόρεσα να ολοκληρώσω την απάντηση. Δοκίμασε ξανά.";
        }
        return response.getResult().getOutput().getText();
    }

    /**
     * Hands token usage to {@link UsageCostService} for cost logging. Usage metadata is best-effort:
     * if the provider omits it (null metadata/usage) we skip cost accounting with a single DEBUG note
     * rather than failing the response.
     */
    private void recordUsage(ChatResponse response) {
        Usage usage = response == null || response.getMetadata() == null
                ? null
                : response.getMetadata().getUsage();
        if (usage == null) {
            log.debug("CHAT_COST skipped — no usage metadata on the chat response");
            return;
        }
        usageCostService.record(tokenCount(usage.getPromptTokens()), tokenCount(usage.getCompletionTokens()));
    }

    /** Spring AI Usage token getters are {@code Integer} and may be null — treat absent as zero. */
    private static int tokenCount(Integer value) {
        return value == null ? 0 : value;
    }
}

package com.angeasla.ai_labor_rights_guide.service;

import com.angeasla.ai_labor_rights_guide.dto.ChatMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Prompt-stuffing defense applied to the conversation before it reaches the LLM. Two cheap, bounded
 * passes, in order:
 *
 * <ol>
 *   <li><b>Per-message cap</b> — any message longer than {@code app.chat.max-message-chars} is
 *       truncated to the first N chars (an ellipsis is appended as a hint to the model). We truncate
 *       rather than reject so a slightly long question still gets answered.</li>
 *   <li><b>Total budget</b> — if the summed content still exceeds {@code app.chat.max-input-chars},
 *       the oldest messages are dropped until it fits. The most-recent message is never dropped: it
 *       is the user's actual question and must always survive (even if it alone exceeds the budget).</li>
 * </ol>
 *
 * <p>Stateless and side-effect free apart from logging; it returns a new list and never mutates the
 * caller's {@link ChatMessageDto} instances. Logs only counts and lengths — never message content.
 */
@Service
public class ChatInputGuard {

    private static final Logger log = LoggerFactory.getLogger(ChatInputGuard.class);

    /** Appended to a message that was truncated, so the model can tell the input was clipped. */
    private static final String TRUNCATION_MARKER = "…";

    private final int maxMessageChars;
    private final int maxInputChars;

    public ChatInputGuard(@Value("${app.chat.max-message-chars:1500}") int maxMessageChars,
                          @Value("${app.chat.max-input-chars:20000}") int maxInputChars) {
        this.maxMessageChars = maxMessageChars;
        this.maxInputChars = maxInputChars;
    }

    /**
     * Returns a budgeted copy of {@code messages}: over-long messages truncated, oldest messages
     * dropped if the total is still over budget. The last message is always retained. A {@code null}
     * or empty input is returned unchanged.
     */
    public List<ChatMessageDto> sanitize(List<ChatMessageDto> messages) {
        if (messages == null || messages.isEmpty()) {
            return messages;
        }

        // Pass 1: per-message truncation.
        List<ChatMessageDto> capped = new ArrayList<>(messages.size());
        int truncatedCount = 0;
        for (ChatMessageDto msg : messages) {
            String content = msg.getContent();
            if (content != null && content.length() > maxMessageChars) {
                capped.add(copyWithContent(msg, content.substring(0, maxMessageChars) + TRUNCATION_MARKER));
                truncatedCount++;
            } else {
                capped.add(msg);
            }
        }
        if (truncatedCount > 0) {
            log.info("ChatInputGuard truncated {} of {} message(s) to the per-message cap ({} chars)",
                    truncatedCount, capped.size(), maxMessageChars);
        }

        // Pass 2: total-budget enforcement — drop OLDEST first, always keep the last message.
        long total = totalLength(capped);
        if (total <= maxInputChars) {
            return capped;
        }

        int droppedCount = 0;
        // Drop from the front while we're over budget and there is more than one message left.
        while (capped.size() > 1 && total > maxInputChars) {
            total -= length(capped.remove(0));
            droppedCount++;
        }
        if (droppedCount > 0) {
            log.info("ChatInputGuard dropped {} oldest message(s) to fit the total budget ({} chars); " +
                    "{} message(s) and {} chars remain", droppedCount, maxInputChars, capped.size(), total);
        }
        // If the single remaining (most-recent) message alone exceeds the budget we keep it anyway —
        // it has already been capped to maxMessageChars in pass 1, so it is bounded.
        if (total > maxInputChars) {
            log.debug("ChatInputGuard: most-recent message retained though it exceeds the total budget " +
                    "({} > {} chars)", total, maxInputChars);
        }
        return capped;
    }

    private static ChatMessageDto copyWithContent(ChatMessageDto source, String content) {
        ChatMessageDto copy = new ChatMessageDto();
        copy.setRole(source.getRole());
        copy.setContent(content);
        return copy;
    }

    private static long totalLength(List<ChatMessageDto> messages) {
        long sum = 0;
        for (ChatMessageDto msg : messages) {
            sum += length(msg);
        }
        return sum;
    }

    private static int length(ChatMessageDto msg) {
        String content = msg.getContent();
        return content == null ? 0 : content.length();
    }
}

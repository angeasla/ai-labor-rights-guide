package com.angeasla.ai_labor_rights_guide.service;

import com.angeasla.ai_labor_rights_guide.dto.ChatMessageDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pure-POJO tests for the prompt-stuffing input guard (no Spring context; limits are passed straight
 * to the constructor).
 */
class ChatInputGuardTest {

    private static ChatMessageDto msg(String role, String content) {
        ChatMessageDto m = new ChatMessageDto();
        m.setRole(role);
        m.setContent(content);
        return m;
    }

    private static ChatMessageDto user(int chars) {
        return msg("user", "a".repeat(chars));
    }

    @Test
    void overLongSingleMessage_isTruncatedToTheCap() {
        ChatInputGuard guard = new ChatInputGuard(100, 20_000);
        List<ChatMessageDto> out = guard.sanitize(List.of(user(500)));

        assertEquals(1, out.size());
        // 100 kept chars + the single-char ellipsis marker.
        assertEquals(101, out.get(0).getContent().length());
        assertTrue(out.get(0).getContent().startsWith("a".repeat(100)));
        assertTrue(out.get(0).getContent().endsWith("…"));
    }

    @Test
    void underBudgetInput_passesUnchanged() {
        ChatInputGuard guard = new ChatInputGuard(1500, 20_000);
        ChatMessageDto a = msg("user", "short question");
        ChatMessageDto b = msg("ai", "short answer");
        List<ChatMessageDto> in = List.of(a, b);

        List<ChatMessageDto> out = guard.sanitize(in);

        assertEquals(2, out.size());
        // No truncation needed, so the original instances are returned as-is.
        assertSame(a, out.get(0));
        assertSame(b, out.get(1));
        assertEquals("short question", out.get(0).getContent());
        assertEquals("short answer", out.get(1).getContent());
    }

    @Test
    void totalBudgetOverflow_dropsOldestFirst() {
        // Per-message cap high enough that no truncation happens; budget forces history trimming.
        ChatInputGuard guard = new ChatInputGuard(10_000, 250);
        ChatMessageDto oldest = msg("user", "1".repeat(100));
        ChatMessageDto middle = msg("ai", "2".repeat(100));
        ChatMessageDto newest = msg("user", "3".repeat(100));

        List<ChatMessageDto> out = guard.sanitize(new ArrayList<>(List.of(oldest, middle, newest)));

        // 300 > 250: drop the single oldest (200 <= 250), keep the two most recent.
        assertEquals(2, out.size());
        assertSame(middle, out.get(0));
        assertSame(newest, out.get(1));
    }

    @Test
    void mostRecentMessage_isAlwaysRetainedEvenWhenItAloneExceedsBudget() {
        // Cap 5000 (no truncation of the 4000-char message), budget only 50.
        ChatInputGuard guard = new ChatInputGuard(5000, 50);
        ChatMessageDto oldest = user(100);
        ChatMessageDto newest = user(4000);

        List<ChatMessageDto> out = guard.sanitize(new ArrayList<>(List.of(oldest, newest)));

        assertEquals(1, out.size(), "everything but the most-recent message is dropped");
        assertSame(newest, out.get(0));
    }

    @Test
    void truncationAndBudget_combine() {
        // Cap 50: each 100-char message becomes 51 chars (50 + ellipsis). Budget 120.
        ChatInputGuard guard = new ChatInputGuard(50, 120);
        List<ChatMessageDto> out = guard.sanitize(new ArrayList<>(List.of(user(100), user(100), user(100))));

        // After capping: 3 * 51 = 153 > 120 -> drop oldest -> 2 * 51 = 102 <= 120.
        assertEquals(2, out.size());
        out.forEach(m -> assertEquals(51, m.getContent().length()));
    }

    @Test
    void nullAndEmpty_areReturnedUnchanged() {
        ChatInputGuard guard = new ChatInputGuard(1500, 20_000);
        assertNull(guard.sanitize(null));
        List<ChatMessageDto> empty = new ArrayList<>();
        assertSame(empty, guard.sanitize(empty));
    }

    @Test
    void nullContentMessage_isHandledWithoutError() {
        ChatInputGuard guard = new ChatInputGuard(1500, 20_000);
        ChatMessageDto nullContent = msg("user", null);
        List<ChatMessageDto> out = guard.sanitize(List.of(nullContent));

        assertEquals(1, out.size());
        assertSame(nullContent, out.get(0));
    }
}

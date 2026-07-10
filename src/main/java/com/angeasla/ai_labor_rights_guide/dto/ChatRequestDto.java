package com.angeasla.ai_labor_rights_guide.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class ChatRequestDto {
    @NotEmpty
    private List<ChatMessageDto> messages;

    public List<ChatMessageDto> getMessages() { return messages; }
    public void setMessages(List<ChatMessageDto> messages) { this.messages = messages; }
}

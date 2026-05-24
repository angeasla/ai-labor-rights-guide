package com.angeasla.ai_labor_rights_guide.dto;

import java.util.List;

public class ChatRequestDto {
    private List<ChatMessageDto> messages;

    public List<ChatMessageDto> getMessages() { return messages; }
    public void setMessages(List<ChatMessageDto> messages) { this.messages = messages; }
}

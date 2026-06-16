package com.angeasla.ai_labor_rights_guide.controller;
import com.angeasla.ai_labor_rights_guide.dto.ChatMessageDto;
import com.angeasla.ai_labor_rights_guide.dto.ChatRequestDto;
import com.angeasla.ai_labor_rights_guide.service.AiChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final AiChatService aiChatService;

    public ChatController(AiChatService aiChatService) {
        this.aiChatService = aiChatService;
    }

    @PostMapping
    public ChatMessageDto chat(@RequestBody ChatRequestDto request) {
        String responseContent = aiChatService.generateResponse(request);

        // We are building the answer for Angular
        ChatMessageDto response = new ChatMessageDto();
        response.setRole("ai");
        response.setContent(responseContent);

        return response;
    }
}

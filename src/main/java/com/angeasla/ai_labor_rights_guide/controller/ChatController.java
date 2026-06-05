package com.angeasla.ai_labor_rights_guide.controller;
import com.angeasla.ai_labor_rights_guide.dto.ChatMessageDto;
import com.angeasla.ai_labor_rights_guide.dto.ChatRequestDto;
import com.angeasla.ai_labor_rights_guide.service.AiChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Chat", description = "AI labor rights chat endpoint")
public class ChatController {
    private final AiChatService aiChatService;

    public ChatController(AiChatService aiChatService) {
        this.aiChatService = aiChatService;
    }

    @Operation(summary = "Send a message", description = "Sends the conversation history to the AI and returns a response. The last message must be from the user.")
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

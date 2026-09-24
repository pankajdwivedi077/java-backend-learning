package com.example.step3SpringAi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/claude")
@CrossOrigin("*")
public class AnthropicController {

    private final ChatClient chatClient;

    // Inject the specific Anthropic model
    public AnthropicController(AnthropicChatModel chatModel) {
        this.chatClient = ChatClient.builder(chatModel).build();
    }

    @GetMapping("/ask")
    public ResponseEntity<String> getAnswer(@RequestParam String msg) {
        String response = chatClient.prompt().user(msg).call().content();
        return ResponseEntity.ok(response);
    }
}
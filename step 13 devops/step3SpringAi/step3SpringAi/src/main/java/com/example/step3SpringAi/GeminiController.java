package com.example.step3SpringAi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gemini")
@CrossOrigin("*")
public class GeminiController {

    private final ChatClient chatClient;

    // Inject the specific Google GenAI model
    public GeminiController(GoogleGenAiChatModel chatModel) {
        this.chatClient = ChatClient.builder(chatModel).build();
    }

    @GetMapping("/ask")
    public ResponseEntity<String> getAnswer(@RequestParam String msg) {
        String response = chatClient.prompt().user(msg).call().content();
        return ResponseEntity.ok(response);
    }
}
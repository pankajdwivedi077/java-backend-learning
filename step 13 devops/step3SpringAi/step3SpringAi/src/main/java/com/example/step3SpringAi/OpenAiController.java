package com.example.step3SpringAi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
@CrossOrigin("*")
public class OpenAiController {

    private final ChatClient chatClient;

  @Autowired
  public OpenAiController(OpenAiChatModel chatModel) {
      this.chatClient = ChatClient.builder(chatModel).build();
  }

    @GetMapping("/ask")
    public ResponseEntity<String> getAnswer(@RequestParam String msg) {
        String response = chatClient.prompt().user(msg).call().content();
        return ResponseEntity.ok(response);
    }

}

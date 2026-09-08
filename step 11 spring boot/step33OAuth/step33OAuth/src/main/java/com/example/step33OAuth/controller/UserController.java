package com.example.step33OAuth.controller;

import com.example.step33OAuth.entity.User2;
import com.example.step33OAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(){
        return """
                Public Home
                Login
                """;
    }

    @GetMapping("/profile")
    public Map<String, Object> profile(@AuthenticationPrincipal OidcUser oidcUser){
      User2 user = userService.findByProviderAndSubject("google", oidcUser.getSubject()).orElseThrow();
      Map<String, Object> response = new HashMap<>();
      response.put("internalUserid", user.getId());
      response.put("provider", user.getProvider());
      response.put("subject", oidcUser.getSubject());
      response.put("name", oidcUser.getClaimAsString("name"));
      response.put("email", oidcUser.getClaimAsString("email"));
      return response;
    }

}

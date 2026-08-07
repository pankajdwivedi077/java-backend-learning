package com.example.step17Config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class NotificationServiceImplDummy implements NotificationService{
    @Override
    public String send() {
        return "fake";
    }
}

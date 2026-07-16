package com.example.loose;

import org.springframework.stereotype.Component;

@Component
public class SmsNotificationService implements NotificationSerive {
    @Override
    public void send(String message) {
        System.out.println("Sms " + message);
    }
}

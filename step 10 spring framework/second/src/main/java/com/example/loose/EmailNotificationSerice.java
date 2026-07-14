package com.example.loose;

import org.springframework.stereotype.Component;

@Component
public class EmailNotificationSerice implements NotificationSerive{
    @Override
    public void send(String message) {
        System.out.println("Emial "+ message);
    }
}

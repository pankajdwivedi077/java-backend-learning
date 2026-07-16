package com.example.loose;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class EmailNotificationSerice implements NotificationSerive{
    @Override
    public void send(String message) {
        System.out.println("Emial "+ message);
    }
}

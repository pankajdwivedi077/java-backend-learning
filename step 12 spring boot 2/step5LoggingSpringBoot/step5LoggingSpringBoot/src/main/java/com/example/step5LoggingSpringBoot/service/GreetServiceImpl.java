package com.example.step5LoggingSpringBoot.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GreetServiceImpl implements GreetService{
    @Override
    public String generateWishes() {
        LocalDateTime dateTime = LocalDateTime.now();
        int hour = dateTime.getHour();
        String body = null;
        if(hour < 12)
            body = "Good Morning";
        else if(hour < 16)
            body = "Good AfterNoon";
        else if(hour < 20)
            body = "Good Evening";
        else
            body = "Good Night";
        return body;
    }
}

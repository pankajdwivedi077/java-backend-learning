package com.example.step17Config;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Override
    public String send() {
        return "Here is notification";
    }
}

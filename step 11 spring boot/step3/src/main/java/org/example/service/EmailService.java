package org.example.service;

public class EmailService implements Notification {

    @Override
    public void sendNotification() {
        System.out.println("Email notification send");
    }
}

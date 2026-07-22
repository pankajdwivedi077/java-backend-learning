package org.example.service;

public class OrderService {

    Notification notification = new EmailService();

    public void placeOrder(){
        System.out.println("order placed");
        notification.sendNotification();
    }


}

package org.example.service;

public class OrderService {

    // tight coupling

   //  Notification notification = new EmailService();

    // loose coupling
    Notification notification;

    public OrderService(){

    }

    public OrderService(Notification notification){
        this.notification = notification;
    }

    public void placeOrder(){
        System.out.println("order placed");
        notification.sendNotification();
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}

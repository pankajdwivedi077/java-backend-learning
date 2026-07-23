package org.example;

import org.example.service.EmailService;
import org.example.service.Notification;
import org.example.service.OrderService;
import org.example.service.SmsService;

public class Main {

    public static void main(String[] args) {

        // tight coupling

        // OrderService orderService = new OrderService();
        // orderService.placeOrder();

       // loose coupling

        Notification notification = new EmailService();
        OrderService order = new OrderService(notification);
        order.placeOrder();

        //  by setter

        Notification notification1 = new SmsService();
        OrderService order2 = new OrderService();
        order2.setNotification(notification1);
        order2.placeOrder();



    }

}

package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

      //  ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // get bean by name
     //   OrderService orderService = (OrderService) context.getBean("orderService");

        // get bean by type
      //  OrderService orderService1 = context.getBean(OrderService.class);

        OrderService orderService2 = context.getBean("orderService", OrderService.class);
        orderService2.placeOrder();

        // get bean by name of beanName from beans.xml 
     //   OrderService orderService3 = context.getBean("orderServiceBean2", OrderService.class);
      //  orderService3.placeOrder();

       // PaymentService paymentService = context.getBean("paymentService", PaymentService.class);
       // paymentService.pay();

        UserServide userServide = context.getBean(UserServide.class);
        System.out.println(userServide.getName());

        context.close();
    }

}

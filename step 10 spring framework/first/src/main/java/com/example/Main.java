package com.example;

import com.example.loose.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext conext = new ClassPathXmlApplicationContext("applicationBeanContext.xml");
        GreetingService greetingService = (GreetingService) conext.getBean("myBean");
        greetingService.sayHello();

        UserService userService = (UserService) conext.getBean("userService");
        userService.notifyUser("hey");

    }

}

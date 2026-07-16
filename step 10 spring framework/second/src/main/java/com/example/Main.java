package com.example;

import com.example.loose.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext conext = new AnnotationConfigApplicationContext(AppConfig.class);
      //  GreetingService greetingService = (GreetingService) conext.getBean("myBean");
        GreetingService greetingService =  conext.getBean(GreetingService.class);
        greetingService.sayHello();

        UserService userService =  conext.getBean(UserService.class);

        userService.notifyUser("hello");

        System.out.println("starting");

        LifeCycleBean lifeCycleBean = conext.getBean(LifeCycleBean.class);
        lifeCycleBean.performTask();
        System.out.println("closing");

    }

}

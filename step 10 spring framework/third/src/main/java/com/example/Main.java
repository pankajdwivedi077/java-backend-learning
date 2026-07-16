package com.example;

import com.example.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        UserController controller = context.getBean(UserController.class);
        controller.createUser("bete");
        controller.listUsers();
    }

}

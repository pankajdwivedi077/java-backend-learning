package com.example.step21Aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("")
    public void longBeforeMethod(){
        System.out.println("Method Intercepted");
    }


}

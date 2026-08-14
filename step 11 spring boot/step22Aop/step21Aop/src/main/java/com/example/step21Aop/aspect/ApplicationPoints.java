package com.example.step21Aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class ApplicationPoints {

    @Pointcut("within(com.example.step21Aop.controller..*)")
    public void controllerLayer(){

    }

    @Pointcut("within(com.example.step21Aop.service..*)")
    public void serviceLayer(){

    }

    @Pointcut("execution(public * *(..))")
    public void publicMethod(){

    }

    @Pointcut("serviceLayer() && publicMethod()")
    public void publicServiceMethod(){

    }

}

package com.example.step21Aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(String com.example.step21Aop.service.StudentService.createStudent())")
   public void logBeforeMethod(){
       System.out.println("student is going to be saved");
   }

}

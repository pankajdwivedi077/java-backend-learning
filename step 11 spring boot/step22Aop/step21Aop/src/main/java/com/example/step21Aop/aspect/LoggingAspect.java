package com.example.step21Aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(public String " +
//            "com.example.step21Aop.service.StudentService.getStudent(String))")
//    public void longBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("execution(com.example.step21Aop.dto.Student " +
//            "com.example.step21Aop.service.StudentService.createStudent" +
//            "(com.example.step21Aop.dto.Student))")
//    public void longBeforeMethod2(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("execution(* com.example.step21Aop.service.StudentService.*(*))")
//    public void longBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("execution(* com.example.step21Aop.service.*.*(*))")
//    public void longAllBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("execution(* *.*(*))")
//    public void longAllBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("execution(* *(*))")
//    public void longAllBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("execution(* com.example.step21Aop.service.StudentService.*(..))")
//    public void longBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("execution(* com.example.step21Aop.service..*(..))")
//    public void longBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("execution(* com.example.step21Aop..*(..))")
//    public void longBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("within(com.example.step21Aop.service.StudentService)")
//    public void longBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("@annotation(jdk.jfr.Timestamp)")
//    public void longBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("bean(studentService)")
//    public void longBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Pointcut("within(com.example.step21Aop.service..*) && execution(public * *(..))")
//    public void logPublicServiceMethod(){
//
//    }

//    @Before("logPublicServiceMethod")
//    public void logBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//        @Before("@within(org.springframework.stereotype.Service)")
//    public void logBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("@target(org.springframework.stereotype.Service)")
//    public void logBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("args(com.example.step21Aop.dto.Student) && com.example.step21Aop.service..* ")
//    public void logBeforeMethod2(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("@args(jdk.jfr.Timestamp)  ")
//    public void logBeforeMethod2(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("target(com.example.step21Aop.service.StudentService)")
//    public void logBeforeMethod2(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("this(com.example.step21Aop.service.StudentService)")
//    public void logBeforeMethod2(){
//        System.out.println("Method Intercepted");
//    }

    // will not work because of jdk proxy
    @Before("this(com.example.step21Aop.service.StudentServiceInterfaceImpl)")
    public void logBeforeMethod3(){
        System.out.println("Method Intercepted");
    }

}

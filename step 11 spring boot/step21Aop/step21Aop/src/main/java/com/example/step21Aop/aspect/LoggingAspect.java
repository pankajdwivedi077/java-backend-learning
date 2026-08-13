package com.example.step21Aop.aspect;

import com.example.step21Aop.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(String com.example.step21Aop.service.StudentService.createStudent())")
    public void logBeforeMethod(JoinPoint joinPoint){

       Object[] arr = joinPoint.getArgs();

       System.out.println("student is going to be saved");

//       boolean allowed = false;
//
//       if(!allowed){
//           throw  new RuntimeException("Method execution not allowed");
//       }

   }

//    @AfterReturning(
//            value = "execution(com.example.step21Aop.dto.Student com.example.step21Aop.service.StudentService" +
//                    ".createStudent(com.example.step21Aop.dto.Student))",
//            returning = "result"
//    )
//    public void logAfterReturningMethod(Student result){
//
//        System.out.println("after returning called");
//        System.out.println(result + " target method returned");
//
//    }

//    @AfterThrowing(value = "execution(* com.example.step21Aop.service.StudentService.createStudent(..))",
//    throwing = "exception")
//    public void logAfterThrowingMethod(Throwable exception){
//
//        System.out.println("after throwing");
//        System.out.println("an exception happed");
//        System.out.println("exception " + exception.getClass().getName());
//        System.out.println("exception " + exception.getMessage());
//    }

//    @After(value = "execution(* com.example.step21Aop.service.StudentService.createStudent(..))")
//    public void logAfterMethod(){
//
//        System.out.println("after method");
//    }

    @Around("execution(* com.example.step21Aop.service.StudentService.createStudent(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("before target method");

//        Object st = joinPoint.proceed();

        try{
            Object result = joinPoint.proceed();
            System.out.println("successful");
            return  result;
        }catch(Exception e){
            System.out.println("failed " + e.getMessage());
            throw e;
        }finally {
            System.out.println("completed");
        }

//        System.out.println("after target method");

//        return st;
    }

    @Around("execution(* com.example.step21Aop.service.StudentService.dummyMethod(..))")
    public Object logGetAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

       Object[] arr = joinPoint.getArgs();

       String originalString = (String) arr[0];

       String modifiedString = originalString.toUpperCase();

       Object[] modifiedArr = {modifiedString};

      return  joinPoint.proceed(modifiedArr);
    }

}

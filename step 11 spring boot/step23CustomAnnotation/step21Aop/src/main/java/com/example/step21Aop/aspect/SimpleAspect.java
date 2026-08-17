package com.example.step21Aop.aspect;

import com.example.step21Aop.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

//    @Before("@annotation()")
//    public void logBeforeMethod(){
//        System.out.println("method intercepted");
//    }

//    @Around("@annotation(com.example.step21Aop.annotation.TrackExecutionTime)")
//    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        long startTime = System.currentTimeMillis();
//        try{
//          return joinPoint.proceed();
//        }finally {
//
//            long endTime = System.currentTimeMillis();
//
//            long totalDuraryion = endTime-startTime;
//
//            String methodName = joinPoint.getSignature().getName();
//
//            System.out.println("Time taken by " + methodName + ": " + totalDuraryion);
//        }
//    }

    @Around("@annotation(trackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint,
                                       TrackExecutionTime trackExecutionTime)
                        throws Throwable {

        long startTime = System.currentTimeMillis();
        try{
            return joinPoint.proceed();
        }finally {

            long endTime = System.currentTimeMillis();

            long totalDuraryion = endTime-startTime;

            String op = trackExecutionTime.operation();

            if(op.isBlank()){
                op = joinPoint.getSignature().getName();
            }

//            String methodName = joinPoint.getSignature().getName();

            long warningThresold = trackExecutionTime.warnAfter();

            if(totalDuraryion >= warningThresold){
                System.out.println("Slow operation alert : Time taken by" +
                        " " + op + " " + totalDuraryion);

            }else{
                System.out.println("Time taken by " + op + ": " + totalDuraryion);
            }
        }
    }

}

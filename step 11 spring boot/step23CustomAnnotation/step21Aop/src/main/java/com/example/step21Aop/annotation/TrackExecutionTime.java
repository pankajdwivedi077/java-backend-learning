package com.example.step21Aop.annotation;

import java.lang.annotation.*;

// meta annotation
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {

   long warnAfter() default 2000;

   String operation() default "";

}

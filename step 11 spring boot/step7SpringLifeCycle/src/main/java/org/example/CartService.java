package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// initialization callbacks
 @Component
public class CartService /* implements InitializingBean */ /* implements DisposableBean */ {

    Map<Integer, String> mp;

    public CartService(){
        mp = new HashMap<>();
        System.out.println("CartService constructor called");
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Bean is ready");
//        mp.put(1,"raj");
//    }


    public void start(){
        System.out.println("Bean is ready");
        mp.put(1,"raj");
    }

    @PostConstruct
    public void start2(){
        System.out.println("Bean is ready");
        mp.put(1,"raj");
    }

    public void addToCart(){
        System.out.println("Added to cart");
    }

    public String getValue(int key){
        return mp.get(key);
    }

    @PreDestroy
    public void destroy2(){
       mp.clear();
    }

    public void stop(){
        mp.clear();
    }


//    @Override
//    public void destroy() throws Exception {
//        mp.clear();
//        System.out.println("bean is getting destroyed");
//    }
}

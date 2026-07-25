package org.example.circularproblem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class A {

    private B b;

    @Autowired
    public A(@Lazy B b){
        this.b = b;
        System.out.println("A is created");
    }

    public void pay(){
        b.create();
        System.out.println("pay");
    }


    public void getDetails() {
        System.out.println("details");
    }
}

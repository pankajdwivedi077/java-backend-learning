package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// solving circular dependency problem with postconstruct
@Component
public class A {

    private B b;

    @Autowired
    public A(B b){
        this.b = b;
    }

    @PostConstruct
    public void setB(){
        b.setA(this);
    }

}

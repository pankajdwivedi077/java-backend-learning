package org.example.circularproblem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class B {

    private A a;

    @Autowired
    public B(A a){
        this.a = a;
        System.out.println("b is created");
    }

    public void create() {
        System.out.println("done");
        a.getDetails();
    }
}

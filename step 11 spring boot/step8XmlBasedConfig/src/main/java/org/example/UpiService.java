package org.example;

public class UpiService implements PaymetServiceExmp {
    @Override
    public void pay() {
        System.out.println("Paying via upi");
    }
}

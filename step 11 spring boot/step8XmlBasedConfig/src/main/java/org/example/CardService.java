package org.example;

public class CardService implements PaymetServiceExmp {
    @Override
    public void pay() {
        System.out.println("Paying via Card");
    }
}

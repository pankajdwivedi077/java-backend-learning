package com.example.step34Junit.service;

import org.springframework.stereotype.Service;

@Service
public class PriceCalculator {

    public double calculatePrice(double price, double discount ){
        if(price < 0){
            throw new IllegalArgumentException("price cannot be negative");

        }
        if(discount < 0 || discount > 100){
            throw new IllegalArgumentException("discount within 0 to 100");

        }        return price - ((price * discount)/100);
    }

}

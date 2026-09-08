package com.example.step34Junit.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriceCalculatorTest {

    private PriceCalculator priceCalculator;
//            = new PriceCalculator();

    @BeforeEach()
    void setup(){
        priceCalculator = new PriceCalculator();
    }

//    @AfterEach()

    @Test
    void shouldAppliyDiscountToPrice(){
        // arrange -> initial input
        double price = 1000;
        double discount = 20;

        //act -> action performed
        double actualPrice = priceCalculator.calculatePrice(price,discount);

        // assertion -> expected output
        assertEquals(800,actualPrice);

    }

    @Test
    void shouldRejectDiscountAboveHundrered(){
      IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()->priceCalculator.calculatePrice(1000,120));
      assertEquals("discount within 0 to 100", exception.getMessage());
    }

}

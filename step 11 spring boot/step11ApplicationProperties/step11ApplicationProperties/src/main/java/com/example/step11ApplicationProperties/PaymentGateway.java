package com.example.step11ApplicationProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

//    @Value("${paymentGateway.type:phonepe}")
//    private String type;
//
//    @Value("${paymentGateway.retry-count}")
//    private int retryCount;

    private PaymentProperties paymentProperties;

//    public PaymentGateway(@Value("${paymentGateway.type}") String type, @Value("${paymentGateway.retry-count}") int retryCount) {
//        this.type = type;
//        this.retryCount = retryCount;
//    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getRetryCount() {
//        return retryCount;
//    }
//
//    public void setRetryCount(int retryCount) {
//        this.retryCount = retryCount;
//    }

    public PaymentGateway(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }

    public String getType() {
        return paymentProperties.getType();
    }

    public int getRetryCount() {
        return paymentProperties.getRetryCount();
    }

    public Boolean getEnabled() {
        return paymentProperties.getEnabled();
    }

    public int getTimeOut() {
        return paymentProperties.getTimeOut();
    }

    public void print(){
        System.out.println(getType());
        System.out.println(getRetryCount());
    }

}

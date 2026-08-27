package com.example.step31Transactional.service;

import com.example.step31Transactional.entity.Order;
import com.example.step31Transactional.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private PaymentAuditService paymentAuditService;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        PaymentAuditService paymentAuditService){
        this.orderRepository = orderRepository;
        this.paymentAuditService = paymentAuditService;
    }

    @Transactional
    public void placeOrder(Order order) {
       orderRepository.save(order);
       paymentAuditService.audit(order);
    }
}

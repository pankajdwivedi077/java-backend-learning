package com.example.step31Transactional.service;

import com.example.step31Transactional.entity.Order;
import com.example.step31Transactional.entity.PaymentAudit;
import com.example.step31Transactional.repository.PaymentAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {

   private PaymentAuditRepository paymentAuditRepository;

   @Autowired
    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository){
       this.paymentAuditRepository = paymentAuditRepository;
   }

    @Transactional(propagation = Propagation.REQUIRED,
    isolation = Isolation.SERIALIZABLE
    )
    public void audit(Order order) {
        PaymentAudit paymentAudit = new PaymentAudit(order.getAmount(), order.getId(),
                true);
        paymentAuditRepository.save(paymentAudit);
    }
}

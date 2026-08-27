package com.example.step31Transactional.repository;

import com.example.step31Transactional.entity.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentAuditRepository extends JpaRepository<PaymentAudit, Long> {


}

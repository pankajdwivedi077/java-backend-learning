package com.example.step31Transactional.repository;

import com.example.step31Transactional.entity.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRecordRepository extends JpaRepository<TransferRecord, Long> {



}

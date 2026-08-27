package com.example.step31Transactional.service;

import com.example.step31Transactional.entity.Account;
import com.example.step31Transactional.entity.TransferRecord;
import com.example.step31Transactional.repository.AccountRepository;
import com.example.step31Transactional.repository.TransferRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TransferService {

    private AccountRepository accountRepository;
    private TransferRecordRepository transferRecordRepository;

    @Autowired
    public TransferService(AccountRepository accountRepository,
                           TransferRecordRepository transferRecordRepository){
        this.accountRepository = accountRepository;
        this.transferRecordRepository = transferRecordRepository;
    }

    @Transactional
    public void transfer(Long fromTransactionId, Long toTransactionId,
                         BigDecimal balance
             ) {

        Account fromAccount = accountRepository.findById(fromTransactionId)
                .orElseThrow(()-> new RuntimeException("user not found"));

        Account toAccount = accountRepository.findById(toTransactionId)
                .orElseThrow(()-> new RuntimeException("user not found"));

        fromAccount.debitAccount(balance);
        toAccount.creditAccount(balance);


        transferRecordRepository.save(new TransferRecord(fromTransactionId, toTransactionId,
                balance, LocalDate.now()));
    }

}

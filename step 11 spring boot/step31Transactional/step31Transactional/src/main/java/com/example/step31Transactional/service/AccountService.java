package com.example.step31Transactional.service;

import com.example.step31Transactional.entity.Account;
import com.example.step31Transactional.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void createAccount(Account account) {
        accountRepository.save(account);
        System.out.println("saved");
    }
}

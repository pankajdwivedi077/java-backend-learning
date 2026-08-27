package com.example.step31Transactional.controller;

import com.example.step31Transactional.entity.Account;
import com.example.step31Transactional.service.AccountService;
import com.example.step31Transactional.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(
                             AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping()
    public ResponseEntity<String> createAccount(@RequestBody Account account){
       accountService.createAccount(account);
       return ResponseEntity.ok("Done");
    }

}

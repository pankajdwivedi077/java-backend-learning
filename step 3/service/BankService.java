package service;

import domain.Account;
import domain.Transaction;

import java.util.List;
import java.util.Map;

public interface BankService {

    String openAccount(String name, String email, String accountType);
    List<Account> listAccount();

    void deposit(String accNumber, Double amount, String deposit);

    void withdraw(String accNumber, Double amount, String withdrawal);

    void transfer(String from, String to, Double amount, String transfer);

    List<Transaction> getStatement(String accNumber);

    List<Account> searchAccountsByCustomerName(String q);
}

package service.impl;

import domain.Account;
import repository.AccountRepository;
import service.BankService;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService {

    private final AccountRepository ac = new AccountRepository();

    @Override
    public String openAccount(String name, String email, String accountType) {
        String customerId = UUID.randomUUID().toString();

        String accountNumber = getAccountNumber();
        Account account = new Account(accountNumber, accountType, (double) 0, customerId);

        //Save
        ac.save(account);
        return accountNumber;
    }

    @Override
    public List<Account> listAccount() {
        return ac.findAll().stream()
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
    }

    @Override
    public void deposit(String accNumber, Double amount, String deposit) {
      Account account = ac.findByNumber(accNumber)
              .orElseThrow(() -> new RuntimeException("Account not found " + accNumber));
      account.setBalance(Double.valueOf(account.getBalance() + amount));

    }

    private String getAccountNumber() {
        int size = ac.findAll().size()+1;
        String accountNumber = String.format("AC%6d", size);
        return accountNumber;
    }


}

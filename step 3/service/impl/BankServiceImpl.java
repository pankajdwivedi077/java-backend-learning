package service.impl;

import domain.Account;
import domain.Customer;
import domain.Transaction;
import domain.Type;
import repository.AccountRepository;
import repository.CustomerRepository;
import repository.TransactionRepository;
import service.BankService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService {

    private final AccountRepository ac = new AccountRepository();
    private final TransactionRepository trRepo = new TransactionRepository();
    private final CustomerRepository customerRepository = new CustomerRepository();

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
    public void deposit(String accNumber, Double amount, String note) {
      Account account = ac.findByNumber(accNumber)
              .orElseThrow(() -> new RuntimeException("Account not found " + accNumber));
      account.setBalance(account.getBalance() + amount);
        Transaction transaction = new Transaction(UUID.randomUUID().toString(), Type.DEPOSIT,account.getAccountNumber(), amount, LocalDateTime.now() , note);
        trRepo.add(transaction);

    }

    @Override
    public void withdraw(String accNumber, Double amount, String note) {
        Account account = ac.findByNumber(accNumber)
                .orElseThrow(() -> new RuntimeException("Account not found " + accNumber));
        if (account.getBalance().compareTo(amount) < 0){
            throw new RuntimeException("Insufficent Balance");
        }
        account.setBalance(account.getBalance() - amount);
        Transaction transaction = new Transaction(UUID.randomUUID().toString(), Type.WITHDRAW,account.getAccountNumber(), amount, LocalDateTime.now() , note);
        trRepo.add(transaction);
    }

    @Override
    public void transfer(String from, String to, Double amount, String transfer) {
        if (from.equals(to))
            throw new RuntimeException("Cannot transfer to your own account");
        Account accountFrom = ac.findByNumber(from)
                .orElseThrow(()-> new RuntimeException("Account not found"));
        Account accountTo = ac.findByNumber(to)
                .orElseThrow(()-> new RuntimeException("Account not found"));
        if (accountFrom.getBalance().compareTo(amount) < 0){
            throw new RuntimeException("Insufficent Balance");
        }
        accountFrom.setBalance(accountFrom.getBalance() - amount);
        accountTo.setBalance(accountTo.getBalance() + amount);

        Transaction transaction1 = new Transaction(UUID.randomUUID().toString(), Type.TRANSFER_OUT,accountFrom.getAccountNumber(), amount, LocalDateTime.now() , transfer);
        trRepo.add(transaction1);
        Transaction transaction2 = new Transaction(UUID.randomUUID().toString(), Type.TRANSFER_IN,accountTo.getAccountNumber(), amount, LocalDateTime.now() , transfer);
        trRepo.add(transaction2);
    }

    @Override
    public List<Transaction> getStatement(String accNumber) {
        return trRepo.findByAccount(accNumber).stream()
                .sorted(Comparator.comparing(Transaction::getTimestamp))
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> searchAccountsByCustomerName(String q) {
        String query = (q == null) ? "": q.toLowerCase();
        List<Account> result = new ArrayList<>();
        for(Customer c: customerRepository.findAll()){
           if(c.getName().toLowerCase().contains(query))
               result.addAll(ac.findByCustomer(c.getId()));
        }
        result.sort(Comparator.comparing(Account::getAccountNumber));
        return result;
    }

    private String getAccountNumber() {
        int size = ac.findAll().size()+1;
        String accountNumber = String.format("AC%6d", size);
        return accountNumber;
    }


}

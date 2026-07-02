package repository;

import domain.Account;

import java.util.*;

public class AccountRepository {

    private final Map<String, Account> accountsByNumber = new HashMap<>();

    public void save(Account acc){
        accountsByNumber.put(acc.getAccountNumber(), acc);
    }


    public List<Account> findAll() {
        return new ArrayList<>(accountsByNumber.values());
    }

    public Optional<Account> findByNumber(String accNumber) {
        return Optional.ofNullable(accountsByNumber.get(accNumber));
    }

    public List<Account> findByCustomer(String customerId) {
        List<Account> result = new ArrayList<>();
        for(Account c: accountsByNumber.values()){
            if(c.getCustomerId().equals(customerId))
                result.add(c);
        }
        return result;
    }
}

package gr.aueb.cf.ch19.AccountWithHashMap.dao;

import gr.aueb.cf.ch19.AccountWithHashMap.model.Account;

import java.util.*;

public class AccountDAOImpl implements IAccountDAO {
    private double amount;
    //private static final List<Account> accounts = new ArrayList<>();
    Map<Long, Account> accounts = new HashMap<>();

    @Override
    public Account createAccount(Account account) {
        accounts.put(account.getId(),account);
        return null;
    }


    @Override
    public Account deposit(Account account, double amount) {
        Account deposit = accounts.get(account.getId());
        deposit.setBalance(deposit.getBalance() + amount );
        return account;
    }

    @Override
    public Account withdraw(Account account, double amount) {
        Account withdraw = accounts.get(account.getId());
        withdraw.setBalance(withdraw.getBalance() - amount );
        return account;
    }


    @Override
    public Account get(Long id) {
        return accounts.get(id);
    }

    @Override
    public Account getByIban(String iban) {
        Optional<Account> account = accounts.values().stream()
                .filter(a -> a.getIban().equals(iban)).findFirst();
        return account.orElse(null);
    }

    @Override
    public List<Account> getAll() {
        return new ArrayList<>(accounts.values());
    }

    @Override
    public boolean ibanExists(String iban) {
        return accounts.values().stream()
                .anyMatch(a -> a.getIban().equals(iban));
    }

    @Override
    public boolean idExists(Long id) {
       return accounts.containsKey(id);
    }
}

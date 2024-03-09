package gr.aueb.cf.ch18.Account.dao;

import gr.aueb.cf.ch18.Account.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDAOImpl implements IAccountDAO {
    private double amount;
    private static final List<Account> accounts = new ArrayList<>();

    @Override
    public Account createAccount(Account account) {
        accounts.add(account);
        return null;
    }


    @Override
    public Account deposit(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        return account;
    }

    @Override
    public Account withdraw(Account account, double amount) {
        account.setBalance(account.getBalance() - amount);
        return account;
    }


    @Override
    public Account get(Long id) {
        Optional<Account> account = accounts.stream()
                .filter(a -> a.getId().equals(id)).findFirst();
        return account.orElse(null);
    }

    @Override
    public Account getByIban(String iban) {
        Optional<Account> account = accounts.stream()
                .filter(a -> a.getIban().equals(iban)).findFirst();
        return account.orElse(null);
    }

    @Override
    public List<Account> getAll() {
        return accounts;
    }

    @Override
    public boolean ibanExists(String iban) {
        return accounts.stream()
                .anyMatch(a -> a.getIban().equals(iban));
    }

    @Override
    public boolean idExists(Long id) {
        if (accounts == null) {
            return false;
        }
        return accounts.stream()
                .anyMatch(a -> a.getId().equals(id));
    }
}

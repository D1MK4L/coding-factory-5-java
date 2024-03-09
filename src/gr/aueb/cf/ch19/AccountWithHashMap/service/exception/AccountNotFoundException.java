package gr.aueb.cf.ch19.AccountWithHashMap.service.exception;

import gr.aueb.cf.ch19.AccountWithHashMap.model.Account;

public class AccountNotFoundException extends Exception{
    private final static long serialVersionUID = 1L;

    public AccountNotFoundException(Long id) {
        super("The Account with the id: " + id + "was not found");
    }

    public AccountNotFoundException(Account account) {
        super ("The Account with the id: " + account.getId() + "was not found");
    }
}

package gr.aueb.cf.ch19.AccountWithHashMap.service.exception;

import gr.aueb.cf.ch19.AccountWithHashMap.model.Account;

public class AccountIDAlreadyExistsException extends Exception{
    private final static long serialVersionUID = 1L;

    public AccountIDAlreadyExistsException(Account account) {
        super("The Account with the id: "+ account.getId() + "already exists");
    }
}

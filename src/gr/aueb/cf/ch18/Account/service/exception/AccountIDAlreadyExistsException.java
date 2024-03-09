package gr.aueb.cf.ch18.Account.service.exception;

import gr.aueb.cf.ch18.Account.model.Account;

public class AccountIDAlreadyExistsException extends Exception{
    private final static long serialVersionUID = 1L;

    public AccountIDAlreadyExistsException(Account account) {
        super("The Account with the id: "+ account.getId() + "already exists");
    }
}

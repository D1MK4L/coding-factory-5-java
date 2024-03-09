package gr.aueb.cf.ch18.Account.service.exception;

import gr.aueb.cf.ch18.Account.model.Account;

public class AccountNotFoundException extends Exception{
    private final static long serialVersionUID = 1L;

    public AccountNotFoundException(Long id) {
        super("The Account with the id: " + id + "was not found");
    }

    public AccountNotFoundException(Account account) {
        super ("The Account with the id: " + account.getId() + "was not found");
    }
}

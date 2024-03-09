package gr.aueb.cf.ch19.AccountWithHashMap.service;

import gr.aueb.cf.ch19.AccountWithHashMap.dto.AccountDTO;
import gr.aueb.cf.ch19.AccountWithHashMap.model.Account;
import gr.aueb.cf.ch19.AccountWithHashMap.service.exception.AccountIDAlreadyExistsException;
import gr.aueb.cf.ch19.AccountWithHashMap.service.exception.AccountNotFoundException;

import java.util.List;

public interface IAccountService {
    Account createAccount(AccountDTO accountDTO)
            throws AccountIDAlreadyExistsException;

    Account depositAccount(String iban, double amount)
            throws AccountNotFoundException;

    Account withdrawAccount(String iban, double amount)
            throws AccountNotFoundException;

    Account getAccount(Long id) throws AccountNotFoundException;

    List<Account> getAll();
}

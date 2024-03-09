package gr.aueb.cf.ch18.Account.service;

import gr.aueb.cf.ch18.Account.dto.AccountDTO;
import gr.aueb.cf.ch18.Account.dto.DepositAccountDTO;
import gr.aueb.cf.ch18.Account.dto.WithdrawAccountDTO;
import gr.aueb.cf.ch18.Account.model.Account;
import gr.aueb.cf.ch18.Account.service.exception.AccountIDAlreadyExistsException;
import gr.aueb.cf.ch18.Account.service.exception.AccountNotFoundException;

import java.util.List;

public interface IAccountService {
    Account createAccount(AccountDTO accountDTO)
            throws AccountIDAlreadyExistsException;

    Account depositAccount(String iban,double amount)
            throws AccountNotFoundException, AccountIDAlreadyExistsException;

    Account withdrawAccount(String iban,double amount)
            throws AccountNotFoundException, AccountIDAlreadyExistsException;

    Account getAccount(Long id) throws AccountNotFoundException;

    List<Account> getAll();
}

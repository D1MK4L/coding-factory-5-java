package gr.aueb.cf.ch19.AccountWithHashMap.service;

import gr.aueb.cf.ch19.AccountWithHashMap.dao.IAccountDAO;
import gr.aueb.cf.ch19.AccountWithHashMap.dto.AccountDTO;
import gr.aueb.cf.ch19.AccountWithHashMap.dto.UserDTO;
import gr.aueb.cf.ch19.AccountWithHashMap.model.Account;
import gr.aueb.cf.ch19.AccountWithHashMap.model.User;
import gr.aueb.cf.ch19.AccountWithHashMap.service.exception.AccountIDAlreadyExistsException;
import gr.aueb.cf.ch19.AccountWithHashMap.service.exception.AccountNotFoundException;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    //Composition
    private final IAccountDAO dao;
    //wiring
    public AccountServiceImpl(IAccountDAO dao){this.dao = dao;}

    @Override
    public Account createAccount(AccountDTO accountDTO) throws AccountIDAlreadyExistsException {
        Account account;
        User user;
        try {
            account = mapFromAccountDTO(accountDTO);
            user = mapFromUserDTO(new UserDTO());
            if (dao.ibanExists(account.getIban())) {
                throw new AccountIDAlreadyExistsException(account);
            }
            return dao.createAccount(account);
        } catch (AccountIDAlreadyExistsException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account depositAccount(String iban, double amount) throws AccountNotFoundException {
        Account account;

        try {
            account = dao.getByIban(iban);

            if (!dao.ibanExists(account.getIban())) {
                throw new AccountNotFoundException(account);
            }
            if (!dao.idExists(account.getId())) {
                throw new AccountNotFoundException(account);
            }
            return dao.deposit(account,amount);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account withdrawAccount(String iban, double amount) throws AccountNotFoundException {
        Account account;
//        double amount=0.0;

        try {
            account = dao.getByIban(iban);

            if (!dao.ibanExists(account.getIban())) {
                throw new AccountNotFoundException(account);
            }
            return dao.withdraw(account,amount);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account getAccount(Long id) throws AccountNotFoundException {
        Account account;

        try {
            account = dao.get(id);
            if (account == null) {
                throw new AccountNotFoundException(id);
            }
            return account;
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Account> getAll() {
        return dao.getAll();
    }


    private User mapFromUserDTO(UserDTO userDTO) {
        return new User(userDTO.getFirstname(), userDTO.getLastname(), userDTO.getSsn());
    }

    private Account mapFromAccountDTO(AccountDTO accountDTO){
        User user = mapFromUserDTO(accountDTO.getUserDTO());
        return new Account(accountDTO.getIban(), user, accountDTO.getBalance());
    }
}

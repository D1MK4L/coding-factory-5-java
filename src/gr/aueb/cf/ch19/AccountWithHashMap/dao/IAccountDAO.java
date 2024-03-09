package gr.aueb.cf.ch19.AccountWithHashMap.dao;

import gr.aueb.cf.ch19.AccountWithHashMap.model.Account;

import java.util.List;

public interface IAccountDAO {

    /**
     * Creates an Account into  {@link Account} in the datasource
     * @param account   model object that creates the Accounts.
     * @return          the details {@link Account}
     */
    Account createAccount(Account account);

    /**
     * deposit an amount into  {@link Account} in the datasource
     * @param account   model object that deposit to the Account's balance data.
     * @return          the details {@link Account}
     */
    Account deposit(Account account, double amount);

    /**
     * withdraw an amount from an {@link Account} instance.
     * @param account   model object that withdraws from the Account's balance data.
     * @return          the details {@link Account} .
     */
    Account withdraw(Account account, double amount);

    /**
     * Returns a {@link Account} based on the input id.
     * @param id    the {@link Account} instance to be returned.
     * @return      the result {@link Account}
     */
    Account get(Long id);

    Account getByIban(String iban);

    /**
     * Returns all the instances from the datasource.
     * @return      the results
     */
    List<Account> getAll();

    /**
     * Returns an Exception if the iban exists
     * @param iban  the iban
     * @return     Exception
     */
    boolean ibanExists(String iban);

    /**
     * Returns an Exception if the id exists
     * @param id  the Account id
     * @return    Exception
     */
    boolean idExists(Long id);

}

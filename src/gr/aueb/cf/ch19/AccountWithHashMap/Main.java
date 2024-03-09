package gr.aueb.cf.ch19.AccountWithHashMap;

import gr.aueb.cf.ch19.AccountWithHashMap.dao.AccountDAOImpl;
import gr.aueb.cf.ch19.AccountWithHashMap.dto.AccountDTO;
import gr.aueb.cf.ch19.AccountWithHashMap.dto.UserDTO;
import gr.aueb.cf.ch19.AccountWithHashMap.model.Account;
import gr.aueb.cf.ch19.AccountWithHashMap.service.AccountServiceImpl;
import gr.aueb.cf.ch19.AccountWithHashMap.service.IAccountService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IAccountService accountService = new AccountServiceImpl(new AccountDAOImpl());

        try {
            for (int i = 1; i <=5; i++) {
                UserDTO userDTO = new UserDTO("User" + i, "Lastname" + i, "ssn"+ i);
                AccountDTO accountDTO = new AccountDTO(userDTO, "GR123"+i, (10000*i)*0.1);
                accountService.createAccount(accountDTO);

            }

            List<Account> allAccounts = accountService.getAll();
            System.out.println("All Accounts before transactions: ");
            for (Account account : allAccounts){
                System.out.println(account);
            }

            accountService.depositAccount("GR1231",1000);
            accountService.depositAccount("GR1232",1000);
            accountService.withdrawAccount("GR1233",2000);
            accountService.withdrawAccount("GR1235",5000);

            List<Account> allAccounts2 = accountService.getAll();
            System.out.println("All Accounts after transactions: ");
            for (Account account : allAccounts2){
                System.out.println(account);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

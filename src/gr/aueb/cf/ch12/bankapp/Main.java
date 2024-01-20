package gr.aueb.cf.ch12.bankapp;


import gr.aueb.cf.ch12.bankapp.model.JointAccount;
import gr.aueb.cf.ch12.bankapp.model.OverDraftAccount;

/**
 * Testing the JointAccount and OverDraftAccount
 * for valid withdraw from 2 users.
 *
 * @author D1MK4L
 */
public class Main {

    public static void main(String[] args) {
    JointAccount user1 = new JointAccount(123,"GR123","John", "Doe", "321");
    JointAccount user2 = new JointAccount(123,"GR123","Sara", "Doe", "1234");
    OverDraftAccount account1 = new OverDraftAccount(user1,"GR123",2000);
    OverDraftAccount account2 = new OverDraftAccount(user2,"GR1234", 1000);

        try {
            System.out.println(account1);
            System.out.println(account2);

            account1.withdraw(1000, user1);
            System.out.println(account1);
            account1.withdraw(1000, user1);
            System.out.println(account1);
            account1.withdraw(3000,user2);
            System.out.println(account1);
            account1.withdraw(100,user2);
            System.out.println(account1);
            System.out.println(account2);
            account2.withdraw(3001, user1);
            System.out.println(account1);
            System.out.println(account2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

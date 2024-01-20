package gr.aueb.cf.ch12.bankapp.model;

/**
 * Class OverDraftAccount
 *
 * @author D1MK4L
 */
public class OverDraftAccount {
    private JointAccount holder;
    private String iban;
    private double balance;

    public OverDraftAccount() {
    }

    public OverDraftAccount(JointAccount holder, String iban, double balance) {
        this.holder = holder;
        this.iban = iban;
        this.balance = balance;
    }

    public JointAccount getHolder() {
        return holder;
    }

    public void setHolder(JointAccount holder) {
        this.holder = holder;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "OverDraftAccount{" +
                "holder: " + holder +
                ", iban:" + iban + '\'' +
                ", balance: " + balance +
                '}';
    }

    /**
     * API - withdraw until overdraft limit reached
     *
     * @param amount        The amount to withdraw
     * @param holder        The holder of the account
     * @throws Exception    Throws Wrong Account in case of wrong iBan account
     */
    public void withdraw(double amount, JointAccount holder) throws Exception{
       try {
           if (holder.getIban() != iban) {
               throw new Exception("Wrong Account");
           }
           if (balance >= -2999) {
               balance-=amount;
               System.out.println(holder.getFirstname() + " " + holder.getLastname() + " withdrew " + amount
                       + " from the account with iBan: " + iban);
           }else {
               System.out.println(holder.getFirstname() + " " + holder.getLastname() +
                       " reached the overdraft limit, withdraw failed!");
           }
       } catch (Exception e) {
           //e.printStackTrace();
           throw e;
       }
    }
}

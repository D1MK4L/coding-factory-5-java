package gr.aueb.cf.ch18.Account.model;

public class Account extends AbstractEntity {
    private String iban;
    private User user;
    private double balance;

    public Account() {
    }

    public Account(String iban, User user, double balance) {
        this.iban = iban;
        this.user = user;
        this.balance = balance;
    }

    public Account(Account account) {
        iban = account.getIban();
        user = account.getUser();
        balance = account.getBalance();
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account id:"+getId()+" {" +
                "iban:'" + iban + '\'' +
                ", " + user +
                ", Balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.balance, balance) != 0) return false;
        if (iban != null ? !iban.equals(account.iban) : account.iban != null) return false;
        return user != null ? user.equals(account.user) : account.user == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = iban != null ? iban.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

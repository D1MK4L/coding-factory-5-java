package gr.aueb.cf.ch12.bankapp.model;

/**
 * Class JointAccount
 *
 * @author D1MK4L
 */
public class JointAccount {
    private int id;
    private String iban;
    private String firstname;
    private String lastname;
    private String ssn;

    public JointAccount() {
    }

    public JointAccount(int id, String iban, String firstname, String lastname, String ssn) {
        this.id = id;
        this.iban = iban;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "JointAccount{" +
                "id:" + id +
                ", iban: " + iban + '\'' +
                ", firstname:" + firstname + '\'' +
                ", lastname: " + lastname + '\'' +
                ", ssn: " + ssn + '\'' +
                '}';
    }
}

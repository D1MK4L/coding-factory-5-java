package gr.aueb.cf.ch19.AccountWithHashMap.dto;

public class DepositAccountDTO extends BaseDTO {
    private UserDTO userDTO;
    private String iban;
    private double balance;

    public DepositAccountDTO() {
    }

    public DepositAccountDTO(UserDTO userDTO, String iban, double balance) {
        this.userDTO = userDTO;
        this.iban = iban;
        this.balance = balance;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
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
}

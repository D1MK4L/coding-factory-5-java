package gr.aueb.cf.ch11.model;

public class main {

    public static void main(String[] args) {
        User alice = new User(1234,"Alice","Smith");
        UserCredentials alice1 = new UserCredentials(4321,"The White Rabbit","123456");

        System.out.println(alice);
        System.out.println(alice1);
    }
}

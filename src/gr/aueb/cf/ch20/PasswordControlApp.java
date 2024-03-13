package gr.aueb.cf.ch20;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordControlApp {

    public static void main(String[] args) {
        String pass;
        boolean strong=false;
        Scanner in = new Scanner(System.in);

        while(!strong){
            System.out.println("Only the Strongest shall pass!");
            System.out.print("Try: ");
            pass = in.nextLine();
            Pattern pattern = Pattern.compile("(?=.*?[a-z])(?=.*[A-Z])(?=.*?[0-9])^.{8,}$");
            Matcher matcher = pattern.matcher(pass);
            if (matcher.find()) {
                System.out.println("...ok.... :(... you can pass.....@#$%^&*(!");
                strong = true;
            }
        }
    }
}

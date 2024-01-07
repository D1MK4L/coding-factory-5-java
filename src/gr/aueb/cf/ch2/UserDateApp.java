package gr.aueb.cf.ch2;

import java.util.Scanner;

/**
 *   Program
 */
public class UserDateApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int date = 0;
        int month = 0;
        int year = 0;

        System.out.print("Δώσε με ακέραιο αριθμό την ημέρα: ");
        date = in.nextInt();
        System.out.print("Δώσε με ακέραιο αριθμό το μήνα: ");
        month = in.nextInt();
        System.out.print("Δώσε με ακέραιο αριθμό το έτος ");
        year = in.nextInt();
        year = year % 100;
        System.out.printf("%02d / %d / %d ",date,month,year);
    }
}

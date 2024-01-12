package gr.aueb.cf.ch3;

import java.util.Scanner;

/**
 * Program that displays a menu,
 * controls the input from stdin
 * and is executed for as long as
 * the choice is not 5
 *
 * @author D1MK4L
 */
public class MenuChoicesApp {

    public static void main(String[] args) {
        int epilogi = 0;
        Scanner in =new Scanner(System.in);
        while (epilogi !=5) {

            System.out.println("Επιλέξτε μία από τις παρακάτω επιλογές: ");
            System.out.println("1. Εισαγωγή ");
            System.out.println("2. Διαγραφή ");
            System.out.println("3. Ενημέρωση");
            System.out.println("4. Αναζήτηση ");
            System.out.println("5. Έξοδος ");
            System.out.println();
            System.out.print("Δώστε αριθμό επιλογής: ");

            epilogi = in.nextInt();

            if (epilogi > 5){
                System.out.println("Λάθος Επιλογή!");
            } else if (epilogi < 1){
                System.out.println("Λάθος Επιλογή!");
            } else if (epilogi == 1){
                System.out.println("Επιλέξατε Εισαγωγή!");
            } else if (epilogi == 2){
                System.out.println("Επιλέξατε Διαγραφή!");
            } else if (epilogi == 3){
                System.out.println("Επιλέξατε Ενημέρωση!");
            } else if (epilogi == 4){
                System.out.println("Επιλέξατε Αναζήτηση!");
            }
        }

    }
}

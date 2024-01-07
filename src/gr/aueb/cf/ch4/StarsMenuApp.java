package gr.aueb.cf.ch4;

import java.util.Scanner;
/**
 * Homework  Ch4 :All 5 programs in one
 *  by using also function "case" as a selection
 *
 * @author DK
 */
public class StarsMenuApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int stars = 0;
        int choice = 0;


        while (choice !=6) {
            System.out.print("Δώστε τον αριθμό που αντιστοιχεί σε αστεράκια: ");
            stars = in.nextInt();
            System.out.println(" ");
            System.out.println("Επιλέξτε τρόπο απεικόνισης!");
            System.out.println("1. οριζόντια ");
            System.out.println("2. κάθετα ");
            System.out.println("3. τυπου πινακα (ν χ ν) ");
            System.out.println("4. Ο αριθμός που δώσατε κατά αύξουσα σειρά αριθμων , με βήμα 1 ");
            System.out.println("5. Ο αριθμός που δώσατε φθίνουσα σειρά αριθμών , με βήμα 1 ");
            System.out.println("6. Έξοδος ");
            System.out.print("Δωστε επιλογή: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 1; i <= stars; i++) {
                        System.out.print("* ");
                    }
                    break;
                case 2:
                    for (int i = 1; i <= stars; i++) {
                        System.out.println("* ");
                    }
                    break;
                case 3:
                    for (int i = 1; i <= stars; i++) {
                        for (int j = 1; j <= stars; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    for (int i = 1; i <= stars; i++) {
                        System.out.print(i + " ");
                    }
                    break;
                case 5:
                    for (int i = stars; i >= 1; i--) {
                        System.out.print(i + " ");
                    }
                    break;
                case 6:
                    System.out.print("Thanks for using stars program!!!! cy");
                    break;
                default:
                    System.out.println("Λάθος επιλογή, αποδεκτοί αριθμοί ακέραιοι 1-6! ");
            }
            System.out.println(" ");
        }
    }
}

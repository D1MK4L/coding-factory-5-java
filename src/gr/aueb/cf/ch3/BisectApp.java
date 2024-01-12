package gr.aueb.cf.ch3;

import java.util.Scanner;

/**
 * Πρόγραμμα που ελέγχει εάν
 * το έτος είναι δίσεκτο ή όχι
 *
 * @author D1MK4L
 */
public class BisectApp {

    public static void main(String[] args) {
        int year = 0;
        final int CONT1 = 4;
        final int CONT2 = 100;
        final int CONT3 = 400;
        boolean bisect = false;

        while(!bisect) {
            Scanner in = new Scanner(System.in);
            System.out.print("Δώσε με ακέραιο αριθμό το έτος: ");
            year = in.nextInt();
            if (year % CONT1 > 0) { //Συνθήκη ελέγχου δίσεκτου 'ετους

            } else if (year % CONT2 > 0) {

            } else if (year % CONT3 == 0) {
                bisect = true;
            }

            if (!bisect) {
                System.out.println("το " + year + " δεν είναι δίσεκτο!");

            } else if (bisect) {
                System.out.println("το " + year + " είναι δίσεκτο!");
            }
        }
    }
}

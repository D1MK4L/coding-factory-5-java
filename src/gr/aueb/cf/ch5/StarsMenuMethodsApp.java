package gr.aueb.cf.ch5;
/**
 * stars Menu program by using methods and arrays
 * and case for selection
 *
 * @author D1MK4L
 */

import java.util.Scanner;

public class StarsMenuMethodsApp {

    public static void main(String[] args) {
        int[] arr = new int[2];

        while (arr[1] !=6) {
            arr = printMenu();
            getChoice(arr);
            System.out.println();
        }
    }

    public static int[] printMenu() {    // Menu method
        int[] array = new int[2];
        Scanner in = new Scanner(System.in);
        System.out.print("Δώστε τον αριθμό που αντιστοιχεί σε αστεράκια: ");
        array[0] = in.nextInt();
        System.out.println(" ");
        System.out.println("Επιλέξτε τρόπο απεικόνισης!");
        System.out.println("1. οριζόντια ");
        System.out.println("2. κάθετα ");
        System.out.println("3. τυπου πινακα (ν χ ν) ");
        System.out.println("4. Ο αριθμός που δώσατε κατά αύξουσα σειρά με αστεράκια");
        System.out.println("5. Ο αριθμός που δώσατε φθίνουσα σειρά αστεράκια");
        System.out.println("6. Έξοδος ");
        System.out.print("Δωστε επιλογή: ");
        array[1] = in.nextInt();
        return array;
    }

    public static void starsH(int a) {  // Horizontal Sequence

        for (int i = 1; i <= a; i++) {
            System.out.print(" *");
        }
        return;
    }

    public static void starsV(int a) {  // Vertical Sequence

        for (int i = 1; i <= a; i++) {
            System.out.println(" *");
        }
        return;
    }

    public static int[] getChoice(int[] array) {  // Choice selection
        int a;                                    // pivot
        switch (array[1]) {
            case 1:
                starsH(array[0]);
                break;
            case 2:
                starsV(array[0]);
                break;
            case 3:
                for (int i = 1; i <= array[0]; i++) {
                    starsH(array[0]);
                    System.out.println();
                }
                break;
            case 4:
                for (int i = 1; i <= array[0]; i++) {
                    a = 1;
                    for (int j = 1; j <= i; j ++ ) {
                        starsH(a);
                    }
                    System.out.println();
                }
                break;
            case 5:
                for (int i = array[0]; i >= 1; i--) {
                    starsH(array[0]);
                    array[0]= array[0] - 1;
                    System.out.println();
                }
                break;
            case 6:
                System.out.println("Self destruct sequence initiated thanks for not loosing your mind! c y");
                break;
            default:
                System.out.println("Λάθος επιλογή, αποδεκτοί αριθμοί ακέραιοι 1-6! ");
                break;
        }
        return array;
    }
}


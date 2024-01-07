package gr.aueb.cf.ch8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Program That checks the InputMismatchException
 * and the IllegalArgumentException on a selection menu.
 *
 * @author D1MK4L
 */
public class ExceptionMenuApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            try {
                choice = getChoice(choice);
                if (choice >= 1 && choice <= 5) {
                    printChoice(choice);
                } else {
                    throw new IllegalArgumentException("Input out of limits(1-5)!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Out of Limits input!Choose from 1-5.Try again!");
                System.out.println();
            } catch (InputMismatchException e1) {
                System.out.println("Only Integers! Try again...!");
                System.out.println();
            }
        }
        System.out.println("...Έξοδος");
    }

    /**
     * Takes the selection of the user and checks with
     * a state-testing if the choice is integer.
     *
     * @param choice    Integer the choice.
     * @return          The choice.
     */
    public static int getChoice(int choice) {
        Scanner in = new Scanner(System.in);

        System.out.println("1. Choice No 1");
        System.out.println("2. Choice No 2");
        System.out.println("3. Choice No 3");
        System.out.println("4. Choice No 4");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        if (!in.hasNextInt()) {
            System.out.println("Invalid Input!");
            in.hasNextInt();
        }
        choice = in.nextInt();
        return choice;
    }

    /**
     * Case of choice.
     *
     * @param choice
     */
    public static void printChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("The 1st has been chosen!!!");
                break;
            case 2:
                System.out.println("The 2nd has been chosen!!!");
                break;
            case 3:
                System.out.println("The 3rd has been chosen!!!");
                break;
            case 4:
                System.out.println("The 4th has been chosen!!!");
                break;
            case 5:
                break;
        }
    }
}

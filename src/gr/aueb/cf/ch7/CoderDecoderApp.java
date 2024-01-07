package gr.aueb.cf.ch7;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The 2 homeworks has been combined in one
 * by using two methods, one method for coding a message,
 * and one method for Decoding a message.
 *
 * @author DK
 */
public class CoderDecoderApp {

    public static void main(String[] args) {
        int choice = -1;

        while (choice != 0) {

            choice = getChoice(choice);
            if (choice == 1) {
                stringCoding(choice);
            }
            if (choice == 2) {
                stringDecoding(choice);
            }
        }
    }

    /**
     * Menu option method. 0 to terminate.
     *
     * @param choice    the option 0-2
     * @return          choice for control
     */
    public static int getChoice(int choice) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("1. Code ");
            System.out.println("2. Decode ");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            if (choice < 0 || choice > 2) System.out.println("error! Only 0-2!!!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! try again!");
            in.hasNextLine();
        }
        return choice;
    }

    /**
     * Method that adds one byte to all the chars
     * inside a string given by the user.
     *
     * @param choice        option from control
     * @return              choice
     */
    public static int stringCoding(int choice) {
        Scanner in = new Scanner(System.in);

        System.out.print("Please give the String: ");
        String str = in.nextLine();

        byte[] byteArr = str.getBytes();
        for (int i = 0; i < byteArr.length; i++) byteArr[i]++;
        str = new String(byteArr);
        System.out.print("The new coded String is: ");
        System.out.println(str);
        return choice;
    }

    /**
     * Method that subtracts one byte
     * to all the chars inside a string
     * given by the user.
     *
     * @param choice        option from control
     * @return              choice
     */
    public static int stringDecoding(int choice) {
        Scanner in = new Scanner(System.in);

        System.out.print("Please give the String: ");
        String str = in.nextLine();

        byte[] byteArr = str.getBytes();
        for (int i = 0; i < byteArr.length; i++) byteArr[i]--;
        str = new String(byteArr);
        System.out.print("The new decoded String is: ");
        System.out.println(str);
        return choice;
    }
}

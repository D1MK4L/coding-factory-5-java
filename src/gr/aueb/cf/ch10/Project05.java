package gr.aueb.cf.ch10;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Project 05
 * A program that can book a position(or a seat)
 * and also make a cancel
 *
 * @author D1MK4L
 */
public class Project05 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char column = ' ';
        int row = 0;
        int columnRandom = 0;
        int choice = 0;
        boolean[][] seat = new boolean[2][2 ];
        boolean[] flag = {false};

        fillArray(seat);
        while (!flag[0]) {
            try {
                menu();

                choice = in.nextInt();

                if(choice < 1 || choice > 3) {
                    throw new IllegalArgumentException();
                }
                if (choice == 1) {
                    displayBook(seat);
                    book(column, row, seat);
                    System.out.println();
                }
                if (choice == 2) {
                    displayBook(seat);
                    cancel(column, row, seat);
                }
                if (choice == 3) {
                    flag[0] = true;
                }
                checkFull(flag, seat);
            } catch (InputMismatchException e) {
                System.out.println("Wrong choice! Integers only!No Chars or Strings!try again...");
                in.next();
            } catch (IllegalArgumentException e1) {
                System.out.println("Wrong integers 1 to 3 only...try again!");
                //in.next();
            }
        }
    }

    /**
     * Booking method
     *
     *
     * @param column    The Letter code of the position/seat
     * @param row       The Number code of the position/seat
     * @param seat      The array that stores booked or open position
     */
    public static void book(char column, int row, boolean[][] seat) {
        int columnToInt = 0;
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("To Book a seat give From A to L columns preference: ");
            column = in.next().charAt(0);
            if (Character.isLowerCase(column)) {
                column = Character.toUpperCase(column);
            }
            System.out.print("To finish the Booking select the row number from 0 to 30: ");
            row = in.nextInt();
            columnToInt = column - 'A';
            if (seat[columnToInt][row] == true) {
                System.out.println("The seat is already booked.Try another one!");
                book(column, row, seat);
            } else {
                seat[columnToInt][row] = true;
            }
        }catch (InputMismatchException e) {
            System.out.println("Wrong token try again: ");
            in.hasNext();
        }catch (ArrayIndexOutOfBoundsException e1){
            System.out.println("out of bounds...try again");
        }
    }

    /**
     * The cancel method
     *
     * @param column    The Letter code of the position/seat
     * @param row       The Number code of the position/seat
     * @param seat      The array that stores booked or open position
     */
    public static void cancel(char column, int row, boolean[][] seat) {
        int columnToInt = 0;
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("To Cancel a seat give From A to L columns preference: ");
            column = in.next().charAt(0);
            if (Character.isLowerCase(column)) {
                column = Character.toUpperCase(column);
            }
            System.out.print("To finish select the row number from 0 to 30: ");
            row = in.nextInt();
            columnToInt = column - 'A';
            if (seat[columnToInt][row] == true) {
                seat[columnToInt][row] = false;
                System.out.println("The seat has been canceled!");
            }else {
                System.out.println("The seat is free for Booking!");
            }
        }catch (InputMismatchException e) {
            System.out.println("Wrong token try again: ");
            in.hasNext();
        }catch (ArrayIndexOutOfBoundsException e1){
            System.out.println("out of bounds...try again");
        }
    }

    /**
     * Method that checks if the positions are all booked or not
     *
      * @param flag         To continue or to stop!
     * @param seat          The array
     * @return              String array Flag
     */
    public static boolean checkFull(boolean[] flag, boolean[][] seat){
        Scanner in = new Scanner(System.in);
        int check = 0;
        int end = 0;
        for(int i = 0; i < seat.length; i++){
            for(int j = 0; j < seat[i].length; j++) {
                if (seat[i][j] == false) {
                    check++;
                }
            }
        }
        try {
            if(end < 0 || end > 1) {
                throw new IllegalArgumentException();
            }
            if (check == 0) {
                System.out.print("The are no more Seats to Book! Restart?(0/no or 1/yes): ");
                end = in.nextInt();
                if (end == 1) {
                    fillArray(seat);
                } else if (end == 0) {
                    flag[0] = true;
                }else {
                    throw new IllegalArgumentException();
                }
            }
        }catch (InputMismatchException e) {
            System.out.println("Only Integers! try again: ");
            in.hasNext();
            checkFull(flag,seat);
        }catch (IllegalArgumentException e1){
            System.out.println("Only 0 (for No) or 1 (for Yes)...try again");
            checkFull(flag,seat);
        }
        return flag[0];
    }

    /**
     * Method that resets the Array.
     *
     * @param seat      The Array.
     */
    public static void fillArray(boolean[][] seat){
        for(int i = 0; i < seat.length; i++){
            for(int j = 0; j < seat[i].length; j++) {
                seat[i][j] = false;
            }
        }
    }

    /**
     * Console display of the booked or open positions
     *
     * @param seat      The Array
     */
    public static void displayBook(boolean[][] seat) {
        for(int i = 0; i < seat.length; i++) {
            for(int j = 0; j < seat[i].length; j++) {
                if(seat[i][j]==true){
                    System.out.print("[" + "  " + "]" +" ");
                }else {
                    System.out.print("[" + (char)(65+i) + j +"]"+" ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Displays the choice menu.
     */
    public static void menu() {
        System.out.println("1. Book a seat");
        System.out.println("2. Cancel a booked seat");
        System.out.println("3. Exit");
        System.out.print("Choose: ");
    }
}

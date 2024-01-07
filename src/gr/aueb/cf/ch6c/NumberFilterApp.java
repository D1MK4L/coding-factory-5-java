package gr.aueb.cf.ch6c;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Homework program that takes 6 numbers given from a user
 * and passes them from a sequences of number filtering.
 *
 * @author DK
 */
public class NumberFilterApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = {0, 0, 0, 0, 0, 0};
        int flag = 1;
        boolean result = false;

        while (flag == 1) {
            userNum(numbers);
            System.out.println();
            result = numFiltering(numbers, result);
            System.out.println();
            if (result) {
                System.out.println("In overall the numbers don't pass the sequence filters");
            } else {
                System.out.println("In overall the numbers pass the sequence filters");
            }
            System.out.println();
            System.out.print("For exit press 0: ");
            flag = in.nextInt();
        }
    }

    /**
     * Checks if the numbers pass the filters
     *
     * @param arr   The returned 6 array from userNum
     * @return      result true/false.
     */
    public static boolean numFiltering(int[] arr, boolean result) {
        int evens = 0;
        int odds = 0;
        int cons = 0;
        boolean ending = false;
        boolean sameDec = false;
        int num = 0;
        int maxNum = 0;

        System.out.print("The given numbers are: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();

        // evens filter
        for (int item : arr) {
            if (item % 2 == 0) evens++;
        }

        if (evens >= 4) {
            System.out.println("The numbers don't pass the evens filter,  Max Found: "+ evens);
        } else {
            System.out.println("The numbers pass the evens filter,  Max Found: "+ evens);
        }

        // odds filter
        for (int item : arr) {
            if (item % 2 != 0) odds++;
        }
        if (odds >= 4) {
            System.out.println("The numbers don't pass the odds filter,  Max Found: " + odds);
        } else {
            System.out.println("The numbers pass the odds filter,  Max Found: " + odds);
        }

        // continuous filter
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                cons++;
            }
        }
        if (cons >= 4) {
            System.out.println("The numbers don't pass the continuous numbers filter,  Max Found: "+ cons);
        } else {
            System.out.println("The numbers pass the continuous numbers filter,  Max Found: "+ cons);
        }

        //Endings filter
        for (int i = 0; i < arr.length; i++) {
            num = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] % 10 == arr[j] % 10) {
                    num++;
                } else {
                    if (num > maxNum) {
                        maxNum = num;
                    }
                }
                if (num > maxNum) {
                    maxNum = num;
                }
            }
        }
        if (maxNum >= 4) {
            ending = true;
            System.out.println("The numbers don't pass the same Ending filter,  Max Found: " + maxNum);
        } else {
            System.out.println("The numbers pass the same Ending filter,   Max Found: " + maxNum);
        }

        maxNum = 0;       // setting the maxNum to zero for the next control

        //Same Decal
        for (int i = 0; i < arr.length; i++) {
            num = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((arr[i] / 10) == (arr[j] / 10)) {
                    num++;
                } else {
                    if (num > maxNum) {
                        maxNum = num;
                    }
                }
                if (num > maxNum) {
                    maxNum = num;
                }
            }
        }

        if (maxNum >= 4) {
            sameDec = true;
            System.out.println("The numbers don't pass the same Decals filter,  Max Found: " + maxNum);
        } else {
            System.out.println("The numbers pass the same Decals filter,  Max Found: " + maxNum);
        }

        if (evens >= 4 || odds >= 4 || cons >= 4 || ending == true || sameDec == true) result = true;

        return result;
    }

    /**
     * Takes the given numbers and put them in an array
     *
     * @param arr the array
     */
    public static void userNum(int[] arr) {
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                int num = 1;
                for (int i = 0; i < arr.length; i++) {
                    if (num >= 1 && num <= 49) {
                        System.out.println("Please give a Number: ");
                        arr[i] = in.nextInt();
                        if (num == arr[i]){
                            System.out.println("The number has already been given");
                            throw new InputMismatchException();
                        }else {
                            num = arr[i];
                        }
                    } else {
                        throw new InputMismatchException();
                    }
                }
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid number between 1-49.");
                in.nextLine();
            }
        }
    }
}

package gr.aueb.cf.ch6a;

import java.util.Random;
import java.util.Scanner;

/**
 * Homework ch6 exercise getLowAndHighIndexOf but with some personal additions
 * Using random generated numbers to assign length and to populate the Array
 * the program searches for the User's given number and
 * continues with a different Array each time until user gives "0".
 *
 * @author DK
 */
public class ArrayRepetitiveIndexRange {

    public static void main(String[] args) {
        Random randomInt = new Random();
        Scanner in = new Scanner(System.in);

        int arrLength;
        int choice= 1;
        int number;

        while(choice !=0){
            arrLength = randomInt.nextInt(30); // assign random number from 0-30
            if (arrLength <= 7) {
                arrLength += 7;
            }
            int[] arr = new int[arrLength];   // create array with the random number
            System.out.print("Array[" + arrLength + "]" + ": { ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = randomInt.nextInt(10);   // populate with random numbers 0-10
                System.out.print(arr[i] + " ");
            }

            System.out.println("} Generated Array");

            for(int i = arr.length-1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if(arr[j] > arr[j+1]) swap(arr, j, j+1);
                }
            }
            System.out.print("Array[" + arrLength + "]" + ": { ");
            for (int num :arr) {
                System.out.print(num + " ");
            }
            System.out.println("} Assorted Array");
            System.out.print("give a number between 0-9 to search: ");
            number = in.nextInt();
            getLowAndHighIndexOf(arr, number);
            System.out.println();
            System.out.print("Press 0 for Exit or any number to continue: ");
            choice = in.nextInt();
            System.out.println();
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] =tmp;
    }

    public static int[] getLowAndHighIndexOf (int[] arr, int key) {
        int high = -1;
        int low = 100;   // flag: 100 always higher than arr.length

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                if(low >= i){
                    low = i;
                }
                high += 1;
            }
        }
        if (low==100) {
            System.out.println("The number "+key+" does not exist in this array!");
        }else {
            high = high + low;
            System.out.println("Index of Number "+key+" {Low , High} : " +"{" +low+" , "+high+"}");
        }
        return null;
    }
}

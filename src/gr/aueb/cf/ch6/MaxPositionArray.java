package gr.aueb.cf.ch6;

import java.util.Random;
import java.util.Scanner;

/**
 * Ch6 Homework, Finds the Max number and position in an Array,
 * and also the second low number and its position.
 * The program repeats until user gives "1" for exit
 *
 * @author DK
 */
public class MaxPositionArray {

    public static void main(String[] args) {
        Random randomInt = new Random();
        Scanner in = new Scanner(System.in);

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int arrlength;
        int choice= 0;

        while(choice !=1){
            arrlength = randomInt.nextInt(10); // assign random number from 0-10

            if (arrlength <= 0 || arrlength == 1 || arrlength == 2) {
                arrlength += 3;
            }
            int[] arr = new int[arrlength];   // create array with the random number
            System.out.print("Array[" + arrlength + "]" + ": { ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = randomInt.nextInt(10);   // populate with random numbers
                System.out.print(arr[i] + " ");
            }

            System.out.println("}");

            getMaxPosition(arr, minValue, maxValue);

            System.out.print("Press 1 for Exit or any number to continue: ");
            choice = in.nextInt();
            System.out.println();
        }
    }

    public static void getMaxPosition (int[] arr, int low, int high) {
        int minValue = Integer.MAX_VALUE;
        int minValue2 = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int maxPosition = 0;
        int minPosition = 0;

        for (int i = 0; i <arr.length; i++) {  //Max Sequence
            if (arr[i] > maxValue) {
                maxPosition = i;
                maxValue = arr[i];
            }
        }
        System.out.printf("Max value: %d, Max Position: %d\n", maxValue, maxPosition +1);

        for (int i = 0; i < arr.length; i++) {  // Low Sequence
            if (arr[i] < minValue) {
                minPosition = i;
                minValue = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {  // The second low number
            if ((arr[i] > minValue) && (minValue < minValue2) && (arr[i] < minValue2)) {
                minPosition = i;
                minValue2 = arr[i];
            }
        }
        System.out.printf("2nd Min value: %d, Min Position: %d\n", minValue2, minPosition +1);
    }

}

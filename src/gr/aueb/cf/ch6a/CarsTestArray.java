package gr.aueb.cf.ch6a;

import java.util.Arrays;

/**
 *  Homework to calculate the max number of parked cars
 *
 * @author DK
 */
public class CarsTestArray {

    public static void main(String[] args) {

        int[][] arr = {{1012, 1136},{1317, 1412},{1015, 1020}};

        System.out.println();
        arrayBreakDown(arr);
        System.out.println();
    }

    /**
     *  Method that calculates the maximum number of parked cars
     *  and print the result to the console.
     *
     * @param  arr              The array.
     * @return arrBreakDown     the new doubled length array.
     */
    public static int[][] arrayBreakDown(int[][] arr) {
        int maxNumberCars = 0;  //  The maximum number of cars that have passed
        int maxParkedCars = 0;  //  The number of cars parked at the same period of time
        int[][] arrBreakDown = new int[arr.length * 2][2]; // new array with double length of the given one
        System.arraycopy(arr, 0, arrBreakDown, 0, arr.length);
        System.out.println("given Array BreakDown: ");
        for (int i = 0; i < arrBreakDown.length; i++) {  // To allocate the 2nd column values to the 1st column
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    if (i < arr.length) {
                        arrBreakDown[i + arr.length][0] = arrBreakDown[i][1];
                        arrBreakDown[i][1] = 1;
                    } else {
                        arrBreakDown[i][1] = 0;
                    }
                    System.out.printf("[%d][%d] Time:  %04d   ", i, j, arrBreakDown[i][j]);
                } else {
                    System.out.printf("[%d][%d] ID:  %d   ", i, j, arrBreakDown[i][j]);
                }
            }
            System.out.println();
        }
        Arrays.sort(arrBreakDown, (a,b) -> a[0]-b[0]); // sort values ascending according to the 1st column[0]
        System.out.println();
        System.out.println("Array on Ascending order: ");
        for (int i = 0; i < arrBreakDown.length; i++) {  // for visual inspection
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    System.out.printf("[%d][%d] Time:  %04d   ", i, j, arrBreakDown[i][j]);
                } else {
                    System.out.printf("[%d][%d] ID:  %d   ", i, j, arrBreakDown[i][j]);
                }
            }
            System.out.println();
        }
        for (int i = 0; i < arrBreakDown.length; i++) {  // Checking for the number of cars parked at the same time
            if(arrBreakDown[i][1] == 1){
                maxNumberCars++;
            }else {
                if(maxNumberCars > maxParkedCars) {
                    maxParkedCars = maxNumberCars;
                }
                maxNumberCars--;
            }
        }
        System.out.println("The Max number of Parked cars at the same time is : "+maxParkedCars);
        return arrBreakDown;
    }
}

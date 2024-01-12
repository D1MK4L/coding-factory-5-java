package gr.aueb.cf.ch10;

/**
 * Kadane's algorithm
 *
 * @author DimKal
 */
public class Project02 {

    public static void main(String[] args) {

        int[] arr = {-2, 1,-3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArraySum(arr);
        System.out.println("Maximum subarray sum is: " + maxSum);
    }

    /**
     * the method  scans the array and sums the indexed element,
     * keeps the maximum sum as a result .In case of a negative
     * result it negates the negative sum subarray
     * and continues the scan until the end of the arrays length
     *
     * @param arr   The Array
     * @return      The result of a maximum sum subarray
     */
    public static int maxSubArraySum(int[] arr) {
        int maxSum = 0; // the max sum subarray
        int sumMax = 0;
        for (int i : arr) {  // Scan the array
            sumMax += i;  // add the indexed i Array
            if (sumMax < 0) {
                sumMax = 0;    // if negative replace with zero to discard any negative subarray
            }
            if (maxSum < sumMax) {
                maxSum = sumMax;  // Whenever you find a larger sum replace
            }
        }
        return maxSum;  //return the result for display
    }
}

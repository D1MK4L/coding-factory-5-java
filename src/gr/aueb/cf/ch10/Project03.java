package gr.aueb.cf.ch10;

/**
 * Shallow copy Vs Deep copy
 *
 * @author DimKal
 */
public class Project03 {

    public static void main(String[] args) {

        int row =2;
        int columns=2;
        int[][] firstArray=new int[row][columns];
        System.out.println("The firstArray:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                firstArray[i][j]++;
                System.out.print(" "+firstArray[i][j]);
            }
            System.out.println(" ");
        }

        shallowCopy(firstArray);

        deepCopy(firstArray);
        System.out.println("The firstArray:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(" "+firstArray[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println("??For some reason the arr values passes to firstArray even though we use void methods??");

    }

    /**
     * Shallow Copy of a 2d Array
     * @param arr   the original Array
     */
    private static void shallowCopy(int[][] arr) {
        int row =2;
        int columns=2;

        int[][] secondArray;
        System.out.println("The arr:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j]++;
                System.out.print(" "+arr[i][j]);
            }
            System.out.println(" ");
        }
        secondArray = arr; // same result with the .copyOf() and .arraycopy();
        secondArray[0][0] = 10;  //changing the first element of the Array
        System.out.println("shallow copy of secondArray:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(" "+ secondArray[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println("The arr after the shallow copy of secondArray:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(" "+ arr[i][j]);
            }
            System.out.println(" ");
        }

    }

    /**
     * Deep copy of an Array
     * @param arr   The original Array
     */
    private static void deepCopy(int[][] arr) {
        int row =2;
        int columns=2;
        int[][] thirdArray = new int[row][columns];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                thirdArray[i][j] = arr[i][j];
            }
        }
        thirdArray[0][0]=20; //changing the first element of the Array
        System.out.println("deep copy of thirdArray:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(" "+ thirdArray[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println("The arr after the deep copy of thirdArray:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(" "+ arr[i][j]);
            }
            System.out.println(" ");
        }
    }
}

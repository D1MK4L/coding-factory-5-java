package gr.aueb.cf.ch10;

import java.io.*;
import java.util.ArrayList;

/**
 * Project01
 * the numbers are generated from the program.
 * to a file.
 *
 * @author DimKal
 */
public class Project01 {
    public static int tag = 0; //similar to the global variable

    /**
     * The program has been optimized with the Arraylist
     * in order to run faster,that's why the start-end Time,
     * It used to run in 15min without the Arraylist!!
     * @param args      some args
     */
    public static void main(String[] args) {
        ArrayList<int[]> collectedArrays = new ArrayList<>();
        int[] arr = {0,0,0,0,0,0};
        createFile(); // create the numbers 1-49
        long startTime = System.currentTimeMillis();
        readFile(collectedArrays); // read the file with the numbers
        long endTime = System.currentTimeMillis();
        addArray(collectedArrays,arr);
        System.out.println("Time taken: " + (endTime - startTime)/1000 + " seconds");
    }

    /**
     * Creates the numbers Data file
     */
    public static void createFile() {
        try (PrintStream ps = new PrintStream("D:\\Programming\\Java\\CodingFactoryTestBed\\Files\\numbersFile.txt")) {
            for (int i = 1; i <= 49; i++) {
                ps.println(i);
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("File not found");
        }
    }

    /**
     * Reads the numbers File
     */
    public static void readFile(ArrayList<int[]> collectedArrays) {
        String line;
        int[] arr = new int[49];
        int[] combination = new int[6];
        int stringToNum;

        File dir = new File("D:\\Programming\\Java\\CodingFactoryTestBed\\Files\\");

        try (BufferedReader bf = new BufferedReader(new FileReader(dir + "/" + "numbersFile.txt"))) {

            while ((line = bf.readLine()) != null) {
                stringToNum = Integer.parseInt(line);
                arr[stringToNum - 1] = stringToNum;
            }
            // To see if the read file was successful without missing data
          /* for (int i = 0; i <= arr.length - 1; i++) {
                System.out.print(arr[i]);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        generateCombinations(arr, combination, 0, 0, collectedArrays);
    }

    /**
     * Generates the Combinations of 6 numbers out of 49
     *
     * @param arr         The array of numbers
     * @param combination The array of 6
     * @param start       Start of index
     * @param index       the index of combinations
     */
    public static void generateCombinations(int[] arr, int[] combination, int start, int index,ArrayList<int[]> collectedArrays) {
        if (index == combination.length) {
            // Print the combinations
            /*for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();*/
            numFiltering(collectedArrays ,combination);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            combination[index] = arr[i];
            generateCombinations(arr, combination, i + 1, index + 1, collectedArrays);
        }
    }

    /**
     * Checks if the numbers pass the filters
     *
     * @param arr       The returned 6 array from userNum
     *
     */
    public static void numFiltering(ArrayList<int[]> collectedArrays,int[] arr) {
        int evens = 0;
        int odds = 0;
        int cons = 0;
        boolean ending = false;
        boolean sameDec = false;
        int num = 0;
        int maxNum = 0;

        if (evensNum(arr,evens) <= 4 &&
                oddsNum(arr,odds) <= 4 &&
                consNum(arr,cons) <= 2 &&
                endingNum(arr,num,maxNum,ending) &&
                sameDecNum(arr,num,maxNum,sameDec)) {
            addArray(collectedArrays ,arr);
        }
    }

    public static void addArray(ArrayList<int[]> collectedArrays,int[] arr) {
        int[] clonedArray = arr.clone();
        collectedArrays.add(clonedArray);
        if (arr[0]==0){
           writeFile(collectedArrays);
        }
    }

    public static int evensNum(int[] arr,int evens) {
        for (int item : arr) {
            if (item % 2 == 0) evens++;
        }
        return evens;
    }

    public static int oddsNum(int[] arr, int odds) {
        for (int item : arr) {
            if (item % 2 != 0) odds++;
        }
        return odds;
    }

    public  static int consNum(int[] arr, int cons) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                cons++;
            }
        }
        return cons;
    }

    public static boolean endingNum(int[] arr, int num,int maxNum,boolean ending) {
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
        if (maxNum <= 3) {
            ending = true;
        }
        return ending;
    }

    public static boolean sameDecNum(int[] arr, int num,int maxNum,boolean sameDec) {
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
        if (maxNum <= 3) {
            sameDec = true;
        }
        return sameDec;
    }

    /**
     * Writes the passed combination
     * to the file.
     *
     * @param arr   the combination
     */
    public static void writeFile(ArrayList<int[]> arr) {

        try (PrintWriter ps = new PrintWriter(new BufferedWriter(new FileWriter("D:\\Programming\\Java\\CodingFactoryTestBed\\Files\\Passed Combinations.txt",true)
        ))) {
            tag++; // to numbers the lines in the file
            for (int[] array : arr) {
                ps.write(tag + ": ");
                // Write each array to the file
                for (int element : array) {
                    ps.write(element + " ");
                }
                ps.write(" \n");
                tag++; // to numbers the lines in the file
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

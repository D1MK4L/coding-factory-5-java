package gr.aueb.cf.ch2;

import java.util.Scanner;

/**
 * Program that convert the temperature
 * from Fahrenheit to Celsius scale.
 *
 * @author D1MK4L
 */
public class TempConverterApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tempC = 0;
        int tempF = 0;

        System.out.print("Δώστε την Θερμοκρασία σε κλίμακα Fahrenheit: ");
        tempF = in.nextInt();
        tempC = 5*(tempF-32)/9;
        System.out.printf("Η θερμοκρασία είναι %d βαθμούς Κελσίου.",tempC);
    }
}

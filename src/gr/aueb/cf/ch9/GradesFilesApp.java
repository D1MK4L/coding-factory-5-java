package gr.aueb.cf.ch9;

import java.io.*;
import java.nio.charset.StandardCharsets;
/**
 * Program that takes data from a txt file
 * with name, surname, and grades.
 * It calculates the average of grades and
 * create 2 txt file.
 * One for formatted names surnames and average grades
 * and one for error entries.
 *
 * @author DK
 */
public class GradesFilesApp {

    public static void main(String[] args) {

        File dir = new File("D:\\Programming\\Java\\CodingFactoryTestBed\\Files\\");

        if (!dir.exists()) {
            if (!dir.mkdir()) {
                System.err.println("Error in make dir");
                System.exit(1);
            }
        }
        readFile();
    }

    /**
     * Method that reads a txt file.
     * and creates two new ones.
     */
    public static void readFile() {
        String[] lines;
        String line;
        int countLines = 0;
        boolean status;

        File dir = new File("D:\\Programming\\Java\\CodingFactoryTestBed\\Files\\");
        //The next line is for console display purposes
        System.out.printf("%-12s %-13s %-15s %-12s %-12s\n", "Όνομα", "Επίθετο", "1ος Βαθμός", "2ος Βαθμός", "Μέσος Όρος");

        try (BufferedReader bf = new BufferedReader(new FileReader(dir + "/" + "grades.txt"))) {
            File averageGrades = new File(dir + "/" + "AverageGrades.txt");
            PrintStream psData = new PrintStream(averageGrades, StandardCharsets.UTF_8);
            File errorLog = new File(dir + "/" + "log.txt");
            PrintStream psErrorData = new PrintStream(errorLog, StandardCharsets.UTF_8);
            psData.printf("%-12s %-13s %-15s\n", "Όνομα", "Επώνυμο", "Μέσος Όρος");

            while ((line = bf.readLine()) != null) {
                lines = line.split(" +");
                countLines++;   //counts the lines of the file
                status = checkFile(lines);
                if (status) {
                    writeFile(psData, lines);
                } else {
                    errorFile(psErrorData, lines, countLines);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that checks for error entries on a txt file
     *
     * @param  lines     The entry data.
     * @return Boolean   status.
     */
    public static boolean checkFile(String[] lines) {
        float grade1 = Float.parseFloat(lines[2]);
        float grade2 = Float.parseFloat(lines[3]);
        boolean status;

        status = (grade1 >= 0.0 && grade1 <= 10.0) && (grade2 >= 0.0 && grade2 <= 10.0);
        return status;
    }

    /**
     * Method that writes the data entries to a new txt file.
     *
     * @param psData    The data written to the file.
     * @param lines     The Data to be written.
     */
    public static void writeFile(PrintStream psData, String[] lines) {
        String name;
        String surname;
        float firstGrade;
        float secondGrade;
        float averageGrade;

        name = lines[0];
        surname = lines[1];
        firstGrade = Float.parseFloat(lines[2]);
        secondGrade = Float.parseFloat(lines[3]);
        averageGrade = (firstGrade + secondGrade) / 2;  //The next line is for console display purposes
        System.out.printf("%-12s %-15s %-15.2f %-12.2f %-10.2f \n", name, surname, firstGrade, secondGrade, averageGrade);
        psData.printf("%-12s %-15s %-10.2f \n", name, surname, averageGrade);
    }

    /**
     * Method that writes the error entries to a log file
     *
     * @param psData      The error data.
     * @param lines       The entry.
     * @param countLines  The line that the error was found.
     */
    public static void errorFile(PrintStream psData, String[] lines, int countLines) {
        String msg = lines[0] + " " + lines[1] + " " + lines[2] + " " + lines[3];
        System.out.println();  //The next line is for console display purposes
        System.out.printf("Error on entry data starting with:\n %s at line: %d", msg, countLines);
        psData.printf("Error on entry data starting with:\n %s at line: %d", msg, countLines);
    }
}

package week4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class test_4_4 {
    public static void main(String[] args){
        
        int total; // sum of grades
        int counter; // number of grades entered
        int score; // grade value
        double average; // number with decimal point for average

        // Create Scanner object to read user input
        Scanner scan = new Scanner(System.in);

        // initialization phase
        total = 0; // initialize total
        counter = 0; // initialize loop counter

        do {
            // get score from user
            System.out.println("Enter Integer Score or -1 to Quit:");
            score = scan.nextInt();

            // Add score to total if it is not the sentinel value
            if (score != -1) {
                total = total + score; // add score to total
                counter++; // increment counter
            }
        } while (score != -1); // loop until sentinel value is read

        // Create DecimalFormat object for formatting the average
        DecimalFormat twoDigits = new DecimalFormat("0.00");

        // if user entered at least one score...
        if (counter != 0) {
            // calculate average of all scores entered
            average = (double) total / counter;

            // display average with two digits of precision
            System.out.println("Class average is " + twoDigits.format(average));
        } else {
            // if no grades entered, output appropriate message
            System.out.println("No scores were entered");
        }
    }
}

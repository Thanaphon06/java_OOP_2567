package week4;
import java.util.Scanner;
import java.text.DecimalFormat;
public class test4_3 {
public static void main(String[] args) {
    int total; // sum of score
    int counter; // number of scores entered
    int score; // score value
    double average; // number with decimal point for average
    Scanner scan = new Scanner(System.in);
    // initialization phase

    total = 0; // initialize total
    counter = 0; // initialize loop counter
    // processing phase

    // get first grade from user
    System.out.println( "Enter Integer Score or -1 to Quit:" );
    score = scan.nextInt();
    // loop until sentinel value read from user
    while ( score != -1 ) {
    total = total + score; // add score to total
    counter++; // increment counter
    // get next score from user
    System.out.println("Enter Integer Score or -1 to Quit:" );
    score = scan.nextInt();
    } // end while
    
    DecimalFormat twoDigits = new DecimalFormat( "0.00" );
    // if user entered at least one score...
    if ( counter != 0 ) {
    // calculate average of all scores entered
    average = (double) total / counter;
    // display average with two digits of precision
    System.out.println( "Class average is " +
    twoDigits.format( average ));
    } // end if part of if...else
    else // if no grades entered, output appropriate message
    System.out.println( "No scores were entered" );
 }
}
    


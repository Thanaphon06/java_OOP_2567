import java.util.Scanner;
import java.text.DecimalFormat;

public class Lab5_1 {

    public static void main(String[] args) {
        double value;
        Scanner scan = new Scanner(System.in);

        // Input value from user
        System.out.println("Enter floating number : ");
        value = scan.nextDouble();

        // Perform various mathematical operations and display results
        System.out.println("\nCeiling of " + value + " is " + Math.ceil(value));
        System.out.println("Floor of " + value + " is " + Math.floor(value));
        System.out.println("Square root of " + value + " is " + Math.sqrt(value));
        System.out.println("Exponential of " + value + " is " + Math.exp(value));
        System.out.println("Absolute of " + value + " is " + Math.abs(value));
        System.out.println("Natural logarithm of " + value + " is " + Math.log(value));
        System.out.println("Power three of " + value + " is " + Math.pow(value, 3));
        System.out.println();

        // Print separator line
        for (int n = 1; n <= 75; n++) {
            System.out.print("=");
        }
        System.out.println();

        // Header for trigonometric table
        System.out.println(" Angle\t\tSin\t\t\tCos\t\t\tTan");
        for (int n = 1; n <= 75; n++) {
            System.out.print("=");
        }
        System.out.println();

        // Decimal formatters
        DecimalFormat twoDigit = new DecimalFormat("0.00");
        DecimalFormat sixDigit = new DecimalFormat("0.000000");

        // Loop for calculating and printing trigonometric values
        for (double angle = 0.0; angle <= 360; angle += 40.0) {
            double radians = angle / 180.0 * Math.PI;

            System.out.print(twoDigit.format(angle) + "\t\t");
            System.out.print(sixDigit.format(Math.sin(radians)) + "\t\t");
            System.out.print(sixDigit.format(Math.cos(radians)) + "\t\t");
            System.out.println(sixDigit.format(Math.tan(radians)));
        }
    }
}

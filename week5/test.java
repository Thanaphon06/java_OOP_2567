// File Name: Lab5_3.java
import javax.swing.JOptionPane;

public class test {

    public static String ranyee(int start_num, int end_number) {
        int value;
        String output = "";

        // Loop 20 times
        for (int counter = 1; counter <= 20; counter++) {
            // Pick random integer between start_num and end_number
            value = start_num + (int) (Math.random() * end_number);
            // Append value to output string
            output += value + " ";

            // If counter is divisible by 5, append newline to output string
            if (counter % 5 == 0) {
                output += "\n";
            }
        } // End of for loop

        return output; // Return the output string
    }

    public static void main(String[] args) {
        // Call the ranyee method and store the result in output
        String output = ranyee(1, 5);

        // Display the output in a message dialog
        JOptionPane.showMessageDialog(null, output,
                "20 Random Numbers from 1 to 5", JOptionPane.INFORMATION_MESSAGE);

        // Terminate the application
        System.exit(0);
    }
}

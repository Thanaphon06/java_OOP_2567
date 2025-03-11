import javax.swing.JOptionPane;

public class lab5_2fix_funtion {
    
    public static void main(String[] args) {
        double number1, number2, number3;
        String s1, s2, s3;
        String output;
        lab5_2fix_funtion lab5 = new lab5_2fix_funtion();

        // Input values from the user
        s1 = JOptionPane.showInputDialog("Enter first floating-point value");
        s2 = JOptionPane.showInputDialog("Enter second floating-point value");
        s3 = JOptionPane.showInputDialog("Enter third floating-point value");

        // Convert user input to double values
        number1 = Double.parseDouble(s1);
        number2 = Double.parseDouble(s2);
        number3 = Double.parseDouble(s3);

        // Find maximum and minimum values
        double max = lab5.maximum(number1, number2, number3);
        double min = lab5.minimum(number1, number2, number3);

        // Prepare output string
        output = "number1: " + number1 + "\nnumber2: " + number2;
        output += "\nnumber3: " + number3 + "\nmaximum is: " + max;
        output += "\nminimum is: " + min;

        // Display result
        JOptionPane.showMessageDialog(null, output);

        // Exit the program
        System.exit(0);
    }

    // Method to find maximum of three numbers
    public  double maximum(double x, double y, double z) {
        return Math.max(x, Math.max(y, z));
    }

    // Method to find minimum of three numbers
    public  double minimum(double x, double y, double z) {
        return Math.min(x, Math.min(y, z));
    }
}


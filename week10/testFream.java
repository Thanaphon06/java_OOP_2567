// File Name : PointJFrame.java
import javax.swing.*;
import java.awt.*;

public class testFream extends javax.swing.JFrame {
    int size;
    Point p[];

    public testFream() {
        super("Program Inheritance Point");

        // Obtain user's choice
        //String input = JOptionPane.showInputDialog("Enter number of points:");

        // Convert input to integer
        //size = Integer.parseInt(input);
        //int size = 2000; test

        size = 10 + (int) (Math.random() * 21);
        p = new Point[size];

        //int test_size = 2000;
        //p = new Point[test_size];


        // Generate random points
        for (int n = 0; n < p.length; n++) {
            int x = 5 + (int) (Math.random() * 640);
            int y = 5 + (int) (Math.random() * 480);
            p[n] = new Point(x, y);
        }
    }

    // Draw shapes on JFrame's background
    public void paint(Graphics g) {
        super.paint(g); // Call inherited paint method

        for (int n = 0; n < p.length; n++) {
            // Set color to red
            g.setColor(new Color(255, 0, 0));

            // Plot point
            g.drawLine(p[n].getX(), p[n].getY(), p[n+1].getX(), p[n+1].getY());
        }

        //Display the number of Point objects (commented out because showStatus() is not available in JFrame)
        //showStatus("Number of Objects: " + Point.getCount());
    }

    public static void main(String[] args) {
        PointJFrame test = new PointJFrame();
        test.setSize(640, 480);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }
}
 
    


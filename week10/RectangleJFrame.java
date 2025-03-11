// File Name : RectangleJFrame.java
import javax.swing.*;
import java.awt.*;

public class RectangleJFrame extends javax.swing.JFrame {
    int x, y;
    Rectangle r;

    public RectangleJFrame() {
        super("Program Inheritance Rectangle");

        String input; // User's input

        // Obtain user's choice for x-coordinate
        input = JOptionPane.showInputDialog("Enter value x of left point: ");
        x = Integer.parseInt(input); // Convert input to int

        // Obtain user's choice for y-coordinate
        input = JOptionPane.showInputDialog("Enter value y of left point: ");
        y = Integer.parseInt(input); // Convert input to int

        // Generate random width and height
        int w = 10 + (int) (Math.random() * 280);
        int h = 10 + (int) (Math.random() * 180);

        r = new Rectangle(x, y, w, h);
    }

    public void paint(Graphics g) {
        super.paint(g); // Call inherited paint method

        // Set color and draw rectangle
        g.setColor(Color.ORANGE);
        g.drawRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());

        // Set color and draw text information
        g.setColor(Color.BLUE);
        g.drawString("Point Left : " + r.getX() + ", " + r.getY(), r.getX(), r.getY());
        g.drawString("Width : " + r.getWidth(), r.getX(), r.getY() + 15);
        g.drawString("Height : " + r.getHeight(), r.getX(), r.getY() + 30);
        g.drawString("Area : " + r.getArea(), r.getX(), r.getY() + 45);
    }

    public static void main(String[] args) {
        RectangleJFrame test = new RectangleJFrame();
        test.setSize(640, 480);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }
}

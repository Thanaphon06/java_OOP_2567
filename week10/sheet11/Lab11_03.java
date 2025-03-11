package sheet11;
// File Name : Lab11_03.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.image.BufferedImage;


public class Lab11_03 extends JFrame implements ActionListener {
    Timer swTimer;
    private int x = 150 , y = 150;
    private int dx = 5 , dy = 5;

    private int x2 = 203 , y2 = 170;
    private int dx2 = 5 , dy2 = 5;
    private BufferedImage buffer;

    public Lab11_03() {

        super("Program Using Timer");

        buffer = new BufferedImage(480, 300, BufferedImage.TYPE_4BYTE_ABGR);

        swTimer = new Timer(300, this);
        swTimer.start();
    }

    public void updatePosition(){
        x += dx;
        y += dy;
        
        x2 += dx2;
        y2 += dy2;
        // ตรวจจับขอบหน้าต่างแล้วเด้งกลับ
        if (x <= 100 || x + 20 >= 300) { // ขอบซ้าย-ขวาของสี่เหลี่ยม
            dx = -dx;
        }
        if (y <= 100 || y + 20 >= 250) { // ขอบบน-ล่างของสี่เหลี่ยม
            dy = -dy;
        }

        if (x2 <= 100 || x2 + 20 >= 300) { // ขอบซ้าย-ขวาของสี่เหลี่ยม
            dx2 = -dx2;
        }
        if (y2 <= 100 || y2 + 20 >= 250) { // ขอบบน-ล่างของสี่เหลี่ยม
            dy2 = -dy2;
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);


        
        
        // Generate random color
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        
        g.setColor(new Color(255,0,0));
        
        g.drawRect(100,100,200,150);

        
        g.setColor(new Color(red, green, blue));
        g.drawOval(x, y, 20, 20);

        g.setColor(new Color(red, green, blue));
        g.drawOval(x2, y2, 20, 20);

    }

    public void actionPerformed(ActionEvent event) {

        updatePosition();
        repaint();

    }

    public static void main(String[] args) {
    
        Lab11_03 test = new Lab11_03();
        test.setSize(480, 300);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    
    }
}

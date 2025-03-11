package sheet11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class lab1_1smooth extends JFrame implements ActionListener {
    private Timer swTimer;
    private int x, y;  // ตำแหน่งของลูกบอล
    private int dx = 3, dy = 3; // ความเร็วการเคลื่อนที่
    private BufferedImage buffer; // สำหรับลดการกระพริบ
    private Color circleColor; // สีของลูกบอล
    private static final int BALL_SIZE = 20; // ขนาดของลูกบอล

    // ตำแหน่งของสี่เหลี่ยมตรงกลาง
    private int rectX, rectY, rectWidth = 200, rectHeight = 150;

    public lab1_1smooth() {
        super("Ball Moving Inside Red Box");

        // กำหนดขนาดหน้าต่าง
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // สร้าง BufferedImage เพื่อใช้เป็น double buffer
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

        // คำนวณตำแหน่งของสี่เหลี่ยมตรงกลาง
        rectX = (getWidth() - rectWidth) / 2;
        rectY = (getHeight() - rectHeight) / 2;

        // กำหนดตำแหน่งเริ่มต้นของลูกบอล **ให้อยู่ภายในกรอบ**
        x = rectX + 10;
        y = rectY + 10;
        generateNewColor(); // กำหนดสีเริ่มต้น

        // ตั้งค่า Timer ให้ทำงานทุก 16ms (≈ 60 FPS)
        swTimer = new Timer(16, this);
        swTimer.start();
    }

    // สุ่มสีใหม่ให้ลูกบอล
    private void generateNewColor() {
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        circleColor = new Color(red, green, blue);
    }

    // อัปเดตตำแหน่งของลูกบอล **โดยให้เคลื่อนที่ภายในสี่เหลี่ยม**
    private void updatePosition() {
        x += dx;
        y += dy;

        // ตรวจสอบว่าชนขอบของ **สี่เหลี่ยม** แล้วหรือยัง
        if (x <= rectX || x + BALL_SIZE >= rectX + rectWidth) {
            dx = -dx; // เปลี่ยนทิศทางแนวนอน
        }
        if (y <= rectY || y + BALL_SIZE >= rectY + rectHeight) {
            dy = -dy; // เปลี่ยนทิศทางแนวตั้ง
        }
    }

    // ใช้ double buffering ในการวาด
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = buffer.createGraphics();

        // ล้างหน้าจอ
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // วาดสี่เหลี่ยม (พื้นหลังสีขาว + ขอบสีแดง)
        g2d.setColor(Color.WHITE); // พื้นหลังของกล่องเป็นสีขาว
        g2d.fillRect(rectX, rectY, rectWidth, rectHeight);

        g2d.setColor(Color.RED); // ขอบของกล่องเป็นสีแดง
        g2d.setStroke(new BasicStroke(3)); // ความหนาของขอบ 3px
        g2d.drawRect(rectX, rectY, rectWidth, rectHeight);

        // วาดลูกบอล **ให้อยู่ภายในสี่เหลี่ยม**
        g2d.setColor(circleColor);
        g2d.fillOval(x, y, BALL_SIZE, BALL_SIZE);

        // วาด BufferedImage ลงใน JFrame
        g.drawImage(buffer, 0, 0, this);
    }

    // Timer เรียกใช้ทุก 16ms
    @Override
    public void actionPerformed(ActionEvent event) {
        updatePosition(); // อัปเดตตำแหน่ง
        repaint(); // วาดใหม่
    }

    public static void main(String[] args) {
        new lab1_1smooth();
    }
}

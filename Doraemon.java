import java.awt.*;
import javax.swing.*;

public class Doraemon extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3));

        // วาดร่างกายหลักพร้อมสีพื้นหลัง
        g2.setColor(Color.BLACK);
        g2.drawOval(100, 50, 200, 200); // ศีรษะ

        g2.setColor(Color.BLUE);
        g2.fillOval(100, 50, 200, 200); // ศีรษะ
        g2.fillOval(100, 190, 200, 210); // ลำตัว
        
        g2.setColor(Color.BLACK);
        g2.drawOval(117, 240, 170, 160); //เส้นของตัว

        g2.setColor(Color.WHITE);
        g2.fillOval(117, 240, 170, 160); //เส้นของตัว

        // วาดใบหน้าสีขาว
        g2.setColor(Color.BLACK);
        g2.drawOval(117, 240, 170, 160); //เส้นของตัว
        g2.setColor(Color.WHITE);
        g2.fillOval(117, 85, 165, 165);
        
        // วาดดวงตา
        g2.setColor(Color.WHITE);
        g2.fillOval(160, 65, 40, 50); // ตาซ้าย
        g2.fillOval(200, 65, 40, 50); // ตาขวา
        g2.setColor(Color.BLACK);
        g2.drawOval(160, 65, 40, 50); // ตาซ้าย
        g2.drawOval(200, 65, 40, 50); // ตาขวา
        g2.setColor(Color.BLACK);
        g2.fillOval(175, 84, 10, 15); // ม่านตาซ้าย
        g2.fillOval(215, 84, 10, 15); // ม่านตาขวา

        // จมูก
        g2.setColor(Color.RED);
        g2.fillOval(185, 110, 30, 30);

        // ปากและหนวด
        g2.setColor(Color.BLACK);
        g2.drawLine(200, 140, 200, 200);
        g2.drawArc(150, 150, 100, 50, 0, -180);

        // กระเป๋าหน้าท้อง
        g2.setColor(Color.WHITE);
        g2.fillArc(145, 270, 110, 70, 0, -180);
        g2.setColor(Color.BLACK);
        g2.drawArc(145, 270, 110, 70, 0, -180);
        g2.drawLine(145, 304, 255, 304);

        // ปลอกคอ
        g2.setColor(Color.RED);
        g2.fillRect(120, 210, 160, 20);
        g2.setColor(Color.BLACK);
        g2.drawRect(120, 210, 160, 20);

        // กระดิ่ง
        g2.setColor(Color.YELLOW);
        g2.fillOval(180, 210, 40, 40);
        g2.setColor(Color.BLACK);
        g2.fillOval(195, 225, 10, 10);
        g2.drawOval(180, 210, 40, 40);
        g2.drawLine(200, 230, 200, 250);
        
        // แขนและมือ
        g2.setColor(Color.BLUE);
        g2.fillOval(90, 230, 50, 100);
        g2.fillOval(260, 230, 50, 100);
        g2.setColor(Color.BLACK);
        g2.drawOval(90, 230, 50, 100);
        g2.drawOval(260, 230, 50, 100);


        g2.setColor(Color.WHITE);
        g2.fillOval(90, 320, 50, 50);
        g2.fillOval(260, 320, 50, 50);
        g2.setColor(Color.BLACK);
        g2.drawOval(90, 320, 50, 50);
        g2.drawOval(260, 320, 50, 50);

        // ขาและเท้า
        g2.setColor(Color.BLUE);
        g2.fillRect(150, 386, 50, 55);
        g2.fillRect(200, 386, 50, 55);
        g2.setColor(Color.BLACK);
        g2.drawRect(150, 386, 50, 55);
        g2.drawRect(200, 386, 50, 55);


        g2.setColor(Color.WHITE);
        g2.fillOval(130, 420, 70, 50);
        g2.fillOval(200, 420, 70, 50);
        g2.setColor(Color.BLACK);
        g2.drawOval(130, 420, 70, 50);
        g2.drawOval(200, 420, 70, 50);

    //หนวด
        g2.drawLine(215, 155, 265, 140);
        g2.drawLine(215, 155, 265, 155);
        g2.drawLine(215, 155, 265, 170);

        g2.drawLine(185, 155, 135, 140);
        g2.drawLine(185, 155, 135, 155);
        g2.drawLine(185, 155, 135, 170);
 
       
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Doraemon Full Body Colored");
        Doraemon panel = new Doraemon();
        frame.add(panel);
        frame.setSize(450, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
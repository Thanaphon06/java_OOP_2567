package week11.sheet12;

// File Name : Lab12_01.java 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//MouseListener เมื่อเรียกใช้ ต้องเขียนฟังชั่นมันให้ครบ
public class Lab12_01 extends JFrame implements MouseListener {
    int x, y, size;
    Color fgcolor;
    boolean isDraw = true;

    public Lab12_01() {
        super("");
        x = 140;
        y = 100;
        size = 50;
        fgcolor = Color.BLUE;
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (isDraw) {
            //set color first then draw fillRect น่าจะเซ้ทก่อนทุกคำสั่ง
            g.setColor(fgcolor);
            g.fillRect(x, y, size, size);

            g.setColor(Color.BLACK);
            g.drawRect(x, y, size, size);
        }
    }

    public void mousePressed(MouseEvent event) { //เมื่อเมาส์ทำการคลิีกมันจะแสดงตำแหน่ง สำคัญมาก เอาไปเล่นกะวาดรูปได้
        Graphics g = getGraphics(); //paramiter graphics getGraphics สำคัญต้องประกาศก้่อน 
        //drawString คือกากรแสดงข้อความ
        g.drawString("(" + event.getX() + "," + event.getY() + ")", event.getX(), event.getY());
        
    }

    public void mouseReleased(MouseEvent event) {
        repaint();
    }

    public void mouseClicked(MouseEvent event) {
        boolean flag = isInside(x, y, size, event.getX(), event.getY());
        if (isDraw) {
            if (flag) isDraw = !isDraw;
        } else {
            x = event.getX();
            y = event.getY();
            isDraw = !isDraw;
        }
    }

    public void mouseEntered(MouseEvent event) {
        repaint();
    }

    public void mouseExited(MouseEvent event) {
        repaint();
    }

    //การเช็กเมาส์ อยู่นความกว้างของ 4 เหลี่ยม
    boolean isInside(int x1, int y1, int size, int posx, int posy) {
        
        int x2 = x1 + size; 
        int y2 = y1 + size;

        if (posx >= x1 && posx <= x2) 
            if (posy >= y1 && posy <= y2) return true; 
        return false;

        //แกน X: ไปทางขวา (เพิ่มค่า X ไปทางขวา)//
    //แกน Y: ไปทาง ล่าง (เพิ่มค่า Y ไปทางล่าง)
    }

    public static void main(String[] args) {
        Lab12_01 test = new Lab12_01();
        test.setSize(640, 480);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }
}

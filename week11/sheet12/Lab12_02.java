package week11.sheet12;

// File Name : Lab12_02.java 
// ใช้สำหรับเรียนรู้เรื่องตำแหน่งได้เป็นอย่างดี
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//MouseListener เมื่อเรียกใช้ ต้องเขียนฟังชั่นมันให้ครบ KeyListerner ก็เช่นกัน
public class Lab12_02 extends JFrame implements KeyListener, MouseListener , ActionListener {
    private int x, y, size, xCenter, yCenter;
    private int width, height;
    private char typeShape = 'R';
    private int coutMouseClick = 0;
    private JButton redBtn, greenBtn, blueBtn, clearBtn;
    private Color color;



    public Lab12_02() {

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        redBtn = new JButton("Red");
        redBtn.addActionListener(this);
        c.add(redBtn);

        greenBtn = new JButton("Green");
        greenBtn.addActionListener(this);
        c.add(greenBtn);

        blueBtn = new JButton("Blue");
        blueBtn.addActionListener(this);
        c.add(blueBtn);

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(this);
        c.add(clearBtn);

        width = 320;
        height = 240;
        xCenter = 160;
        yCenter = 120;
        size = 30;
        x = (width / 2) - (size / 2);
        y = (height / 2) - (size / 2);

  
        addKeyListener(this);
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        if (typeShape == 'R') {
            g.setColor(color);
            g.fillRect(x, y, size, size);
            g.setColor(color);
            g.drawRect(x, y, size, size);
        //ทำไมใช้ else และกดปุ่มอื่นจึงไม่เป็น วงกลม 
        // เพราะว่าปุ่มอื่นไม่ได้มีการรับค่าไว้ มีแค่ C ที่ได้ทำการรับไว้
        } else if (typeShape == 'C') {
            g.setColor(color);
            g.fillOval(x, y, size, size);
            g.setColor(color);
            g.drawOval(x, y, size, size);
        }else if (typeShape == 'O'){
            g.setColor(color);
            g.fillOval(x, y+20 , size, size - 40);
            g.setColor(color);
            g.drawOval(x, y+20 , size, size - 40);
        }

        
        g.setColor(Color.BLACK);
        g.drawLine(1, yCenter, 319, yCenter);
        g.drawLine(xCenter, 30, xCenter, 239);
    }

    public void mousePressed(MouseEvent event) {
        Graphics g = getGraphics();
        g.drawString("" + getSize(xCenter, event.getX()), event.getX(), event.getY());

        if (coutMouseClick == 0){
            typeShape = 'R';
            
        }

        if(coutMouseClick == 1){
            typeShape = 'C';
            
        }

        if (coutMouseClick == 2) {
            typeShape = 'O';
        }

        coutMouseClick++;

        if (coutMouseClick == 3) 
            coutMouseClick = 0;
        
    }

    public void mouseReleased(MouseEvent event) {
        repaint();
    }

    public void mouseClicked(MouseEvent event) {
        this.size = getSize(xCenter, event.getX());
        this.x = (width / 2) - (size / 2);
        this.y = (height / 2) - (size / 2);
        System.out.println(x + " , " + y);


    }

    public void mouseEntered(MouseEvent event) {}

    public void mouseExited(MouseEvent event) {}


    //รับค่าจาก keyboard
    public void keyPressed(KeyEvent event) {
        if (event.getKeyChar() == 'c') typeShape = 'C';
        if (event.getKeyChar() == 'r') typeShape = 'R';
        if (event.getKeyChar() == 'o') typeShape = 'O';
    }

    public void keyReleased(KeyEvent event) {
        repaint();
    }

    public void keyTyped(KeyEvent event) {}

    private int getSize(int xCenter, int x) {
        return Math.abs(xCenter - x) * 2;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redBtn) color = Color.RED;
        else if (e.getSource() == greenBtn) color = Color.GREEN;
        else if (e.getSource() == blueBtn) color = Color.BLUE;
        else if (e.getSource() == clearBtn) {
            color = Color.BLACK;
            Graphics g = getGraphics();
            clear(g);
        }
        repaint();
        
    }
    public void clear(Graphics g){
        
        repaint();
        g.setColor(color);
        g.fillRect((320 / 2) - (30 / 2), (240 / 2) - (30 / 2), 30, 30);
        g.setColor(color);
        g.drawRect((320 / 2) - (30 / 2), (240 / 2) - (30 / 2), 30, 30);

        

    }

    public static void main(String[] args) {
        Lab12_02 window = new Lab12_02();
        window.setSize(320, 240);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
// เมื่อคลิีกจะเปลี่ยนรูปทรง วงกลม วงรี สี่เหลี่ยม เอาเมาส์คลิ๊กนะ size คงเดิม when click change status add วงรี เป็น e ก็ได้ 
// 12 04 เอามาใส่ ให้ 12 02 เปลี่ยนสี กันนไป 
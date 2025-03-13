
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import javax.swing.*;
import java.util.Random;

public class test1 extends JFrame implements ActionListener , MouseMotionListener , MouseListener   {
   
    private JButton[] cardButtons = new JButton[16];
    private JButton btnStart , btnReset , randBtn;
    private int r1 = -1 , r2 = -1 , r3 = -1;
    private Random random = new Random();
    private int point = 0 , miss = 0;
    private JLabel  showX , showY ,showID;

    private Timer time;
    private int tdeley = 2000;
    private JLabel debugLabel;
    private JTextField debubField;



    public test1(){
        super("tun game");
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());

        showX = new JLabel("X = " , SwingConstants.CENTER);
        showY = new JLabel("Y = " , SwingConstants.CENTER);
        showID = new JLabel("ID = " , SwingConstants.CENTER);

        container.add(showX);
        container.add(showY);
        container.add(showID);
        container.add(new JLabel("            "));

        randBtn = new JButton("Random");
        container.add(randBtn);
        randBtn.addActionListener(this);

        btnStart = new JButton("Start");
        container.add(btnStart);
        btnStart.addActionListener(this);
        

        btnReset = new JButton("Stop");
        container.add(btnReset);
        btnReset.addActionListener(this);
        

        for(int i = 0; i < 16; i++){
            cardButtons[i] = new JButton(" " + i);
            cardButtons[i].setPreferredSize(new Dimension(100, 100));

            cardButtons[i].setBackground(Color.RED);
            container.add(cardButtons[i]);
            
            cardButtons[i].addActionListener(this);
            cardButtons[i].addMouseListener(this);

        }

        debugLabel = new JLabel("Debug information ");
        debubField = new JTextField(30);
        debubField.setEditable(false);

        container.add(debugLabel);
        container.add(debubField);




        time = new Timer(tdeley, this);


        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setSize(450,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void Moles_move(){

        if (r1 != -1) {
            cardButtons[r1].setBackground(Color.RED);
        }
        if (r2 != -1) {
            cardButtons[r2].setBackground(Color.RED);
        }
        if (r3 != -1) {
            cardButtons[r3].setBackground(Color.RED);   
        }
        r1 = random.nextInt(16);
        cardButtons[r1].setBackground(Color.GREEN);

        
         r2 = random.nextInt(16);
        cardButtons[r2].setBackground(Color.GREEN);

        r3 = random.nextInt(16);
        cardButtons[r3].setBackground(Color.GREEN);

    }




    public void Moles_clear(){
        
        r1 = -1;
        r2 = -1;
        r3 = -1;
        point = 0; 
        miss = 0;
    
        tdeley = 2000;
        time.setDelay(tdeley);
        for(int i = 0; i < 16; i++){

            cardButtons[i].setBackground(Color.RED);


        }
        
    }
    public void adjustSpeed() {
        
        tdeley -= 50;
        time.setDelay(tdeley);
    }

    public void showScore(){

        String mg = "";

        mg += "Your Score = " + point + "\n"
            + "Miss = " + miss;

        JOptionPane.showMessageDialog(null,mg,"Message",1);
    }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnStart) {
                time.start();
            }else if(e.getSource() == time){
                Moles_move();
                
            }else if(e.getSource() == randBtn){
                Moles_move();
                
            }else if(e.getSource() == btnReset){
                showScore();
                Moles_clear();
                time.stop();
            }

            if (e.getSource() == cardButtons[r1]) {
                cardButtons[r1].setBackground(Color.RED);
                point++;
                adjustSpeed();
           
            }
            if (e.getSource() == cardButtons[r2]) {
                cardButtons[r2].setBackground(Color.RED);
                point++;
                adjustSpeed();
                
             
            }
            if (e.getSource() == cardButtons[r3]) {
                cardButtons[r3].setBackground(Color.RED);
                point++;
                adjustSpeed();
                 
            }


        
    }

        
        public void mouseDragged(MouseEvent e) {
        }

        
        public void mouseMoved(MouseEvent e) {
                showX.setText("X = "+e.getX());
                showY.setText("Y = "+e.getY());

                //if (e.get() == cardButtons[1]) {
                  //  showX.setText("X = 1");
                
              //  }
        }

        public static void main(String[] args) {
            new test1();
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            for (int i = 0; i < cardButtons.length; i++) {
                if (e.getSource() == cardButtons[i]) {
                    if (e.getSource() == cardButtons[r1]) {
                        debubField.setText("Click on " + i + " : true");
                    }else if (e.getSource() == cardButtons[r2]) {
                        debubField.setText("Click on " + i + " : true");
                    }else if (e.getSource() == cardButtons[r3]) {
                        debubField.setText("Click on " + i + " : true");
                    }else{
                        debubField.setText("Click on " + i + " : false");
                        miss++;

                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
        }

        @Override
        public void mouseEntered(MouseEvent e) {

            for (int i = 0; i < cardButtons.length; i++) {
                if (e.getSource() == cardButtons[i]) {
                    showID.setText("ID = " + i);
                    break;
                }else{
                    showID.setText("ID = "); // ล้างค่าเมื่อเมาส์ออกจากปุ่ม
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }

      
}

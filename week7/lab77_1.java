import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab77_1 extends JFrame {

    JLabel nLabel1 , resultLabel ,forblankText;
    JTextField nField , forBlankField;
    JTextArea resultArea;
    JScrollPane scroll;
    public lab77_1(){


        super("Program display value n");

        Container contain = getContentPane();
        contain.setLayout(new FlowLayout());

        contain.add(new JLabel("           "));
        nLabel1 = new JLabel("Enter interger and press Enter : ");
        contain.add(nLabel1);

        nField = new JTextField(10);
        contain.add(nField);

        contain.add(new JLabel("        "));

        contain.add(new JLabel("          "));

        forblankText = new JLabel("Entrer interger under of blank : ");
        contain.add(forblankText);

        forBlankField = new JTextField(10);
        contain.add(forBlankField);

        
          ActionListener inputAct =   new ActionListener() {

                public void actionPerformed( ActionEvent event ){
                    int number , sumValue , numForBlank;
                    String blankspace = "";
                    resultArea.setText("");

                    number = Integer.parseInt(nField.getText());
                    numForBlank = Integer.parseInt(forBlankField.getText());
                    for (int space = 0; space < numForBlank; space++) {
                        blankspace += " ";
                    }

                    

                    for (int i = 1; i < number; i++) {
                        resultArea.append(blankspace+Integer.toString(i));  
                        if (i % 5 == 0 ) {
                            resultArea.append(blankspace);
                            resultArea.append("\n");};
                        }
                    
                    nField.setText("");   
                    forBlankField.setText("");
                    }
                };
            
                
            

            nField.addActionListener(inputAct);
            forBlankField.addActionListener(inputAct);
        
             

            resultArea = new JTextArea(10,30);
            resultArea.setEditable(false);
            scroll = new JScrollPane(resultArea);
            contain.add(new JLabel("        "));

            contain.add(scroll);
    }
    /*
    public JFrame blankWindow(boolean t){

        Container con = getContentPane();
        con.setLayout(new FlowLayout());
    

        JFrame frame = new JFrame("Blank Window");  // สร้าง JFrame
        frame.setSize(400, 300);  // กำหนดขนาดของหน้าต่าง
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ตั้งค่าการปิดหน้าต่าง
        
        JLabel label = new JLabel("Please enter Blank space !");
        con.add(label);

        frame.setVisible(t);  // แสดงหน้าต่าง
        return frame;  // คืนค่า JFrame ที่สร้างขึ้น
    }*/

    public static void main(String[] args){
        lab77_1 window = new lab77_1();
        window.setSize(500,270);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

       /*  if (window.forBlankField.getText().isEmpty()) {
            window.blankWindow(true);   
        }*/
   
    }
        
}


    


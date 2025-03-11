// File Name : Lab7_3.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab7_3 implements ActionListener {
    JLabel numberLabel;
    JTextField numberField;
    JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnClear, btnBackslash;
    JFrame window;

    public Lab7_3() {
        // Obtain content pane and set its layout to FlowLayout
        window = new JFrame("Program Show Text");
        Container container = window.getContentPane();
        container.setLayout(new FlowLayout());

        // Create numberLabel and attach it to content pane
        numberLabel = new JLabel("Show Number: ");
        container.add(numberLabel);

        numberField = new JTextField(10);
        // numberField.setEditable(false);
        container.add(numberField);


        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btnClear = new JButton("C");
        btnBackslash = new JButton("🔙");


        JButton[] buttons = {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnClear, btnBackslash};
        for(JButton button : buttons){
            button.addActionListener(this);
            container.add(button);
        }

        


        window.setSize(240, 210);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String str = numberField.getText();

        if (event.getSource() == btn0) {
            str += "0";
        } else if (event.getSource() == btn1) {
            str += "1";
        } else if (event.getSource() == btn2) {
            str += "2";
        } else if (event.getSource() == btn3) {
            str += "3";
        } else if (event.getSource() == btn4) {
            str += "4";
        } else if (event.getSource() == btn5) {
            str += "5";
        } else if (event.getSource() == btn6) {
            str += "6";
        } else if (event.getSource() == btn7) {
            str += "7";
        } else if (event.getSource() == btn8) {
            str += "8";
        } else if (event.getSource() == btn9) {
            str += "9";
        } else if (event.getSource() == btnClear) {
            str = "";  // Clear the text field
        } else if (event.getSource() == btnBackslash) {
            if (!str.isEmpty()) {
                str = str.substring(0, str.length() - 1);    
            }
            
        }
        numberField.setText(str);
    }

    public static void main(String[] args) {
        Lab7_3 gui = new Lab7_3();
    }
}

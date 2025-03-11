import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class yee extends JFrame implements ActionListener {
    JLabel textLabel;
    JTextField textField;
    JButton saveBtn, clearBtn, showBtn;
    JButton addBtn, subBtn, mulBtn, divBtn, equalBtn;
    Container container;
    JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnClear, btnBackslash;

    // ตัวแปรสำหรับการคำนวณ
    String operator = "";
    double firstNumber = 0;

    public yee() {
        super("Program Calculate Number");
        container = getContentPane();
        container.setLayout(new FlowLayout());

        textLabel = new JLabel("Enter number:");
        textLabel.setFont(new Font("Courier New", Font.BOLD, 20));
        container.add(textLabel);

        textField = new JTextField(10);
        textField.setFont(new Font("Courier New", Font.BOLD, 24));
        container.add(textField);
        JLabel line = new JLabel("        ");
        
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
        btnBackslash = new JButton("←");
        equalBtn = new JButton("=");

        JButton[] buttons = {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnClear, btnBackslash, equalBtn};
        for(JButton button : buttons){
            button.addActionListener(this);
            button.setFont(new Font("Courier New", Font.BOLD, 20));
            container.add(button);
        }

        container.add(line);

        saveBtn = new JButton("Save");
        saveBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        saveBtn.addActionListener(this);
        container.add(saveBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        clearBtn.addActionListener(this);
        container.add(clearBtn);

        showBtn = new JButton("Show");
        showBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        showBtn.addActionListener(this);
        container.add(showBtn);

        addBtn = new JButton("+");
        addBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        addBtn.addActionListener(this);
        container.add(addBtn);

        subBtn = new JButton("-");
        subBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        subBtn.addActionListener(this);
        container.add(subBtn);

        mulBtn = new JButton("*");
        mulBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        mulBtn.addActionListener(this);
        container.add(mulBtn);

        divBtn = new JButton("/");
        divBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        divBtn.addActionListener(this);
        container.add(divBtn);

        setSize(350, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Lab8_3 test = new Lab8_3();
        test.textField.setText("0");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String str = textField.getText();

        // Handle number buttons
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
        }

        // Handle operator buttons
        else if (event.getSource() == addBtn) {
            firstNumber = Double.parseDouble(str);
            operator = "+";
            str = "";
        } else if (event.getSource() == subBtn) {
            firstNumber = Double.parseDouble(str);
            operator = "-";
            str = "";
        } else if (event.getSource() == mulBtn) {
            firstNumber = Double.parseDouble(str);
            operator = "*";
            str = "";
        } else if (event.getSource() == divBtn) {
            firstNumber = Double.parseDouble(str);
            operator = "/";
            str = "";
        }

        // Handle equals button
        else if (event.getSource() == equalBtn) {
            double secondNumber = Double.parseDouble(str);
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        str = "Error: Division by Zero";
                        textField.setText(str);
                        return;
                    }
                    break;
            }

            str = String.valueOf(result);
        }

        // Handle clear button
        else if (event.getSource() == btnClear) {
            str = "";
            firstNumber = 0;
            operator = "";
        }

        // Handle backspace button
        else if (event.getSource() == btnBackslash) {
            if (!str.isEmpty()) {
                str = str.substring(0, str.length() - 1);
            }
        }

        textField.setText(str);
    }
}

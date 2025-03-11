import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorApp extends JFrame implements ActionListener {
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton addBtn, subBtn, mulBtn, divBtn, eqBtn, clearBtn, backBtn, dotBtn;
    private JButton saveDataBtn, clearDataBtn, showDataBtn;
    private String operator;
    private double num1, num2;
    private boolean isNewInput;
    NumberNew obj;

    public CalculatorApp() {
        super("Calculator");
        setLayout(new FlowLayout());

        displayField = new JTextField(20);
        displayField.setFont(new Font("Courier New", Font.BOLD, 24));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        add(displayField);

        clearBtn = new JButton("C");
        clearBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        clearBtn.addActionListener(this);
        add(clearBtn);
        
        backBtn = new JButton("←");
        backBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        backBtn.addActionListener(this);
        add(backBtn);
        
        
        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        eqBtn = new JButton("=");
        dotBtn = new JButton(".");
        saveDataBtn = new JButton("Save");
        clearDataBtn = new JButton("Clear");
        showDataBtn = new JButton("Show");

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Courier New", Font.BOLD, 20));
            numberButtons[i].addActionListener(this);
            add(numberButtons[i]);
        }

        JButton[] opButtons = {addBtn, subBtn, mulBtn, divBtn, eqBtn, dotBtn , saveDataBtn , clearDataBtn , showDataBtn};
        for (JButton btn : opButtons) {
            btn.setFont(new Font("Courier New", Font.BOLD, 20));
            btn.addActionListener(this);
            add(btn);
        }

        setSize(370, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        isNewInput = true;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (source == numberButtons[i]) {
                if (isNewInput) {
                    displayField.setText("");
                    isNewInput = false;
                }
                displayField.setText(displayField.getText() + i);
                return;
            }
        }

        if (source == dotBtn) {
            if (!displayField.getText().contains(".")) {
                displayField.setText(displayField.getText() + ".");
            }
        } else if (source == clearBtn) {
            displayField.setText("");
            num1 = num2 = 0;
            operator = null;
        } else if (source == backBtn) {
            String text = displayField.getText();
            if (!text.isEmpty()) {
                displayField.setText(text.substring(0, text.length() - 1));
            }
        } else if (source == addBtn || source == subBtn || source == mulBtn || source == divBtn) {
            num1 = Double.parseDouble(displayField.getText());
            operator = ((JButton) source).getText();
            isNewInput = true;
        } else if (source == eqBtn) {
            num2 = Double.parseDouble(displayField.getText());
            double result = 0;

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = (num2 != 0) ? num1 / num2 : 0; break;
            }

            displayField.setText(String.valueOf(result));
            isNewInput = true;
        }
        
        if (source == saveDataBtn) {
            int value = Integer.parseInt(displayField.getText());
            obj.setValue(value);
            displayField.setText("");
        } else if (source == clearDataBtn) {
            obj.setValue(0);
            displayField.setText("");
        } else if (source == showDataBtn) {
            displayField.setText(obj.toString());
        } 
    }

    public static void main(String[] args) {
        CalculatorApp test = new CalculatorApp();
        test.obj = new NumberNew();
        
    }
}
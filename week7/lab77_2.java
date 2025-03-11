
// File Name : lab77_2.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab77_2 implements ActionListener {
    JLabel salaryLabel, taxLabel, resultLabel;
    JTextField salaryField, taxField, resultField;
    JButton btnCalculate, btnExit;
    JFrame window;

    /** Creates a new instance of Test5_15 */
    public lab77_2() {
        // obtain content pane and set its layout to FlowLayout
        window = new JFrame("Program Calculate Tax");
        Container container = window.getContentPane();
        container.setLayout(new FlowLayout());

        // create salaryLabel and attach it to content pane
        salaryLabel = new JLabel("Enter salary employee : ");
        container.add(salaryLabel);
        salaryField = new JTextField(10);
        container.add(salaryField);
        salaryField.setEditable(true);
        container.add(salaryField);

        taxLabel = new JLabel("Result Tax of salary : ");
        container.add(taxLabel);
        taxField = new JTextField(10);
        taxField.setEditable(false);
        container.add(taxField);

        resultLabel = new JLabel("Result Net Salary : ");
        container.add(resultLabel);
        resultField = new JTextField(10);
        resultField.setEditable(false);
        container.add(resultField);

        btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(this);
        container.add(btnCalculate);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(this);
        container.add(btnExit);

        window.setSize(300, 150);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        double salary = Double.parseDouble(salaryField.getText());

        if (event.getSource() == btnCalculate) {
            double tax, netSalary, taxR;

            taxR = taxRate(salary);

            tax = salary * taxR;
            netSalary = salary - tax;

            taxField.setText(Double.toString(tax));
            resultField.setText(Double.toString(netSalary));
        }
        else if (event.getSource() == btnExit) {
            System.exit(0);
        }

        // end method actionPerformed
    }

    public static double taxRate(Double salary){
        double taxRate;
        if (salary < 20000) taxRate = 0.02;
        else if (salary < 50000) taxRate = 0.05;
        else if (salary < 100000) taxRate = 0.07;
        else if (salary < 500000) taxRate = 0.10;
        else taxRate = 0.15;
        return taxRate;
    }

    public static void main(String[] args) {
        lab77_2 gui = new lab77_2();
    }
}

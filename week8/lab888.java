
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lab888 extends JFrame implements ActionListener {

    JLabel textLabel;
    JTextField textField;
    JButton saveBtn , clearBtn , showBtn;
    Container container;
    private int number;

    public lab888(){

        super("Program Save Show Clear Delete Number");
        container = getContentPane();
        container.setLayout(new FlowLayout());
        
        textLabel = new JLabel("Enter Number :");
        container.add(textLabel);

        textField = new JTextField(10);
        container.add(textField);

        saveBtn = new JButton("Save");
        saveBtn.setFont(new Font("Courier New",Font.BOLD,20));
        saveBtn.addActionListener(this);
        container.add(saveBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setFont(new Font("Courier New",Font.BOLD,20));
        clearBtn.addActionListener(this);
        container.add(clearBtn);

        showBtn = new JButton("Show");
        showBtn.setFont(new Font("Courier New",Font.BOLD,20));
        showBtn.addActionListener(this);
        container.add(showBtn);

        setSize(1920,1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    

    public static void main(String[] args) {
        lab888 obj = new lab888();
        obj.setValue((int) (Math.random() * 100));
        obj.textField.setText(obj.toString());
    }

    public void setValue(int n){
        number = n;
    }

    public int getValue(){
        return number;
    }

    public String toString(){
        return (Integer.toString(getValue()));
    }

    public void actionPerformed(ActionEvent event){
        if (event.getSource() == saveBtn) {
            int value = Integer.parseInt(textField.getText());

            if (!textField.getText().isEmpty()) {
                this.setValue(value);
                textField.setText("");
            }
           
        }
        else if (event.getSource() == clearBtn) {
            this.setValue(0);
            textField.setText("");
        }
        else if (event.getSource() == showBtn) {
            textField.setText(this.toString());
        }
    }
}

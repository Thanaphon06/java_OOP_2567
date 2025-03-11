
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lab82 extends JFrame implements ActionListener {

    JLabel textLabel;
    JTextField textField;
    JButton saveBtn , clearBtn , showBtn;
    Container container;
  
    NumberNew obj;

    public lab82(){

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
        lab82 test = new lab82();
        test.obj = new NumberNew();
        test.textField.setText(test.obj.toString());

    }


    public void actionPerformed(ActionEvent event){
        if (event.getSource() == saveBtn) {
            int value = Integer.parseInt(textField.getText());

            if (!textField.getText().isEmpty()) {
                obj.setValue(value);
                textField.setText("");
            }
           
        }
        else if (event.getSource() == clearBtn) {
            obj.setValue(0);
            textField.setText("");
        }
        else if (event.getSource() == showBtn) {
            textField.setText(obj.toString());
        }
    }
}

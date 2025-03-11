import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Lab5_5 {
    public static void main(String[] args) {
        String menu, choiceStr;
        boolean done = true;
        int choice;
        DecimalFormat fourDigit = new DecimalFormat("0.0000");

        // เมนูหลัก
        menu = "Main Menu\n 1. Circle \n 2. Rectangle\n 3.rhombus\n 4.square\n 5. Exit";
        do {
            // รับค่าตัวเลือกจากผู้ใช้
            choiceStr = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceStr);

            if (choice >= 1 && choice <= 5) {
                // ถ้าเลือกตัวเลือกที่ 1: คำนวณพื้นที่วงกลม
                if (choice == 1) {
                    String radiusStr;
                    double radius;
                    radiusStr = JOptionPane.showInputDialog("Enter radius :");
                    radius = Double.parseDouble(radiusStr);
                    // แสดงผลพื้นที่วงกลม
                    JOptionPane.showMessageDialog(null, 
                        "Area circle is " + fourDigit.format(area(radius)),
                        "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                // ถ้าเลือกตัวเลือกที่ 2: คำนวณพื้นที่สี่เหลี่ยมผืนผ้า
                else if (choice == 2) {
                    String widthStr, heightStr;
                    double width, height;
                    widthStr = JOptionPane.showInputDialog("Enter width :");
                    width = Double.parseDouble(widthStr);
                    heightStr = JOptionPane.showInputDialog("Enter height :");
                    height = Double.parseDouble(heightStr);
                    // แสดงผลพื้นที่สี่เหลี่ยมผืนผ้า
                    JOptionPane.showMessageDialog(null,
                        "Area rectangle is " + fourDigit.format(area(width, height)),
                        "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (choice == 3){
                    String Diagonals1 , Diagonals2;
                    double d1 , d2;
                    Diagonals1 = JOptionPane.showInputDialog("Enter Diagonals 1 : ");
                    d1 = Double.parseDouble(Diagonals1);

                    Diagonals2 = JOptionPane.showInputDialog("Enter Diagonals 2 : ");
                    d2 = Double.parseDouble(Diagonals2);

                    JOptionPane.showMessageDialog(null, 
                    "Area rhombus is " + fourDigit.format(rhombus(d1, d2)),
                     "Result" , JOptionPane.INFORMATION_MESSAGE );
                }
                else if (choice == 4){
                    String width1Str , width2Str;
                    double w1 , w2;

                    width1Str = JOptionPane.showInputDialog("Enter Width 1 : ");
                    w1 = Double.parseDouble(width1Str);

                    width2Str = JOptionPane.showInputDialog("Enter width 2 : ");
                    w2 = Double.parseDouble(width2Str);

                    JOptionPane.showMessageDialog(null, 
                    "Area Square is " + fourDigit.format(area(w1, w2)),
                    "Result", JOptionPane.INFORMATION_MESSAGE);

                    
                }
                // ถ้าเลือกตัวเลือกที่ 3: ออกจากโปรแกรม
                else if (choice == 5) done = false;
            }
        } while (done);

        // ออกจากโปรแกรม
        System.exit(0);
    }

    // ฟังก์ชันคำนวณพื้นที่วงกลม
    public static double area(double r) {
        return (Math.PI * r * r); // สูตรพื้นที่วงกลม
    }

    // ฟังก์ชันคำนวณพื้นที่สี่เหลี่ยมผืนผ้า
    public static double area(double w, double h) {
        return (w * h); // สูตรพื้นที่สี่เหลี่ยมผืนผ้า
    }

    public static double rhombus(double w1 , double w2 ){
        return (2 /(w1 * w2));
    }
}
 
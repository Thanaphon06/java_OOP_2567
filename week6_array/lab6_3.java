package week6_array;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.text.DecimalFormat;

public class lab6_3 {
    public static void main(String[] args) {
        final int MaxData = 10; // กำหนดจำนวนข้อมูลที่ต้องการรับ
        String name[] = new String[MaxData]; // อาร์เรย์สำหรับชื่อ
        float salary[] = new float[MaxData]; // อาร์เรย์สำหรับเงินเดือน
        String output = ""; // ตัวแปรสำหรับเก็บข้อมูลทั้งหมด
        JTextArea textArea = new JTextArea(12, 25); // JTextArea สำหรับแสดงผล
        DecimalFormat number = new DecimalFormat("0,000,000.00"); // รูปแบบการแสดงตัวเลขเงินเดือน

        // เรียกฟังก์ชัน getData เพื่อรับข้อมูลจากผู้ใช้
        getData(name, salary);

        // สร้างข้อมูลแสดงผลในรูปแบบที่ต้องการ
        for (int n = 0; n < name.length; n++) {
            output += name[n] + "\t" + number.format(salary[n]) + "\n"; // เพิ่มชื่อและเงินเดือนลงใน output
        }

        // ตั้งค่าข้อความใน textArea
        textArea.setText(output);

        // แสดงกล่องข้อความ
        JOptionPane.showMessageDialog(null, textArea,
                "Display Employee", JOptionPane.INFORMATION_MESSAGE);
    }

    // ฟังก์ชันเพื่อรับข้อมูลชื่อและเงินเดือนจากผู้ใช้
    public static void getData(String name[], float salary[]) {
        for (int n = 0; n < name.length; n++) {
            name[n] = JOptionPane.showInputDialog("Enter name " + (n + 1) + " : ");
            salary[n] = Float.parseFloat(JOptionPane.showInputDialog("Enter salary " + (n + 1) + " : "));
        }
    }
}

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Lab5_6 {
    public static void main(String[] args) {
        JTextArea outputArea = new JTextArea(); // สร้าง JTextArea เพื่อแสดงผล
        String output;
        
        // เรียกฟังก์ชัน printTriangle เพื่อสร้างรูปสามเหลี่ยม
        output = printTriangle(6);
        
        // ตั้งค่าผลลัพธ์ที่ได้จาก printTriangle ใน outputArea
        outputArea.setText(output);
        
        // แสดงผลใน JOptionPane
        JOptionPane.showMessageDialog(null, 
        outputArea, "Result", JOptionPane.INFORMATION_MESSAGE);
    }

    // ฟังก์ชันเพื่อสร้างรูปสามเหลี่ยม
    public static String printTriangle(int n) {
        String s = "";
        
        // สร้างรูปสามเหลี่ยม
        for (int r = 1; r <= n; r++) {

            for(int space = 1; space <= n-r; space++){
                s += " ";
            }

                for (int c = 1; c <= ((2 * r) - 1); c++) {
                    s += "*"; // เพิ่มเครื่องหมาย * ในแต่ละแถว
                }
                s += "\n"; // เพิ่มบรรทัดใหม่หลังจากแต่ละแถว
        }

        for (int r = n - 1; r >= 1; r--) {

            for(int space = 1; space <= n-r; space++){
                s += " ";
            }

                for (int c = 1; c <= ((2 * r) - 1); c++) {
                    s += "*"; // เพิ่มเครื่องหมาย * ในแต่ละแถว
                }
                s += "\n"; // เพิ่มบรรทัดใหม่หลังจากแต่ละแถว
        }
        
        
        return s; // คืนค่าเป็นสตริงที่ประกอบไปด้วยรูปสามเหลี่ยม
    }
}

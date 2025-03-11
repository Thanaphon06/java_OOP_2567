import javax.swing.JOptionPane;

public class lab5_4 {
    public static void main(String[] args) {
        int num;
        String s1;
        int i = 1;

        // รับค่าจำนวนจากผู้ใช้
        s1 = JOptionPane.showInputDialog("Enter last number :");
        num = Integer.parseInt(s1);

        // คำนวณผลรวม
        int sum = 0;
        while (i <= 5) {
            sum += i;
            i++;
        }
        // แสดงผลลัพธ์
        String output = "Sum of 1 to " + num + " is " + sum;
        JOptionPane.showMessageDialog(null, output, "Summation", JOptionPane.INFORMATION_MESSAGE);
        
        
     
        // จบการทำงาน
        System.exit(0);
    }

    // ฟังก์ชันคำนวณผลรวมแบบ recursive
    public static int Sumation(int n) {
        if (n > 1) {
            return (n + Sumation(n - 1));  // เรียกฟังก์ชันตัวเอง
        } else {
            return 1;  // กรณี n == 1
        }
    }
}
/*การใช้ funtion recursive  คือเรียกใช้ตัวเอง ภายใน ตัวเอง แบบ inception*/
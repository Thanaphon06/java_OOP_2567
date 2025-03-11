// File Name: Lab5_3.java
import javax.swing.JOptionPane;

public class lab5_3 {

    public static String ranyee(int start_num , int end_number){
        int value;
        String output = "";

        // Loop 20 times
        for (int counter = 1; counter <= 20; counter++) {
        // Pick random integer between 1 and 6
        value = start_num + (int) (Math.random() * end_number);
        /*จะทำงานดังนี้:

        Math.random(): ฟังก์ชันนี้คืนค่าตัวเลขสุ่มในช่วง [0, 1) ซึ่งหมายถึงค่าที่ได้จะเป็นตัวเลขระหว่าง 0 (รวม) และ 1 (ไม่รวม) เช่น 0.234, 0.876 เป็นต้น

        Math.random() * 5: เมื่อคูณค่าที่ได้จาก Math.random() ด้วย 5 ค่าที่ได้จะอยู่ในช่วง [0, 5) ซึ่งหมายความว่า ค่าที่ได้จะเป็นค่าทศนิยมในช่วง 0 ถึง 5 (ไม่รวม 5)  เช่น 0.234 * 5 = 1.17 หรือ 0.876 * 5 = 4.38

        (int): การแปลงค่าจากทศนิยมเป็นจำนวนเต็ม (การทำ floor) ซึ่งจะตัดทิ้งทศนิยม เช่น 1.17 จะกลายเป็น 1 หรือ 4.38 จะกลายเป็น 4

        1 + (int) (Math.random() * 5): ค่าที่ได้จากการคำนวณในขั้นตอนที่แล้วจะถูกบวกกับ 1 ซึ่งทำให้ค่าผลลัพธ์สุดท้ายอยู่ในช่วง [1, 5) เช่น

        หากค่าจาก Math.random() เป็น 0.234 จะได้ผลลัพธ์ 1 + (int) (0.234 * 5) = 1 + 1 = 2
        หากค่าจาก Math.random() เป็น 0.876 จะได้ผลลัพธ์ 1 + (int) (0.876 * 5) = 1 + 4 = 5
    */

        // Append value to output string
        output += value + " ";

        // If counter is divisible by 5, append newline to output string
        if (counter % 5 == 0) {
        output += "\n";
    }
} // End of for loop
return output;
    }
    public static void main(String[] args) {
        
       String output = ranyee(1, 6);

        ranyee(1,6);
        // Display the output in a message dialog
        JOptionPane.showMessageDialog(null, output,
                "20 Random Numbers from 1 to 6", JOptionPane.INFORMATION_MESSAGE);

        // Terminate the application
        System.exit(0);
    }
}

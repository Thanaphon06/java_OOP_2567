package week6_array;
import javax.swing.JOptionPane;

public class Lab6_2 {
    public static void main(String[] args) {
        int score[] = new int[10]; // declare and allocate array
        String output = "";

        // Initial value: populate array with random scores between 100 and 500
        for (int n = 0; n < score.length; n++) {
            score[n] = rnd(100, 500);
        }

        // Prepare the output string to display scores
        for (int n = 0; n < score.length; n++) {
            output += "Score " + (n + 1) + " : " + score[n] + "\n";
        }

        // Add minimum, maximum, and average values to output
        // ฟังชั่นการรับค่า น้อย มาก เฉลี่ย
        output += "Minimum value is " + getMin(score) + "\n";
        output += "Maximum value is " + getMax(score) + "\n";
        output += "Average value is " + getAverage(score) + "\n";

        // Display the result in a message dialog
        JOptionPane.showMessageDialog(null, output, "Display Score in Array", JOptionPane.INFORMATION_MESSAGE);
    }

    // Function to get minimum value in the array
    public static int getMin(int data[]) {
        int min = data[0]; // Start with the first element as the minimum
        for (int i = 1; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i]; // Update min if a smaller value is found
            }
        }
        return min;
    }

    // Function to get maximum value in the array
    public static int getMax(int data[]) {
        int max = data[0]; // Start with the first element as the maximum
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i]; // Update max if a larger value is found
            }
        }
        return max;
    }

    // Function to calculate the average value of the array
    public static int getAverage(int data[]) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i]; // Add all elements to sum
        }
        return sum / data.length; // Return the average
    }

    // Function to generate a random number between st and ed (inclusive)
    public static int rnd(int st, int ed) {
        int offset = ed - st + 1;
        //ต้อง + 1 เพราะว่าการสุ้ม ถ้าใส่เข้าไป 400 มันจะสุ้มถึง 399 ถ้าบอก 1 ก็จะได้ 400 ตามที่เราต้องการ
        return (st + (int) (Math.random() * offset));

        // (st + (int) (Math.random()จะสุ่มระหว่าง 0.01-0.99 * offset มันจะคูณเข้าไป 400 แล้วก็ไปบวกกับ 100 ข้างหน้า ค่าที่ได้จะอยู่ระหว่าง 100 - 500 ))
    }
}

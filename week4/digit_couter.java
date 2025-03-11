package week4;

import java.util.Scanner;

public class digit_couter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // รับค่าตัวเลขแบบ long จากผู้ใช้
        System.out.print("Enter positive number: ");
        long number = scan.nextLong();

        // ตัวแปรนับตัวเลขคู่, คี่ และศูนย์
        int evenCount = 0;
        int oddCount = 0;
        int zeroCount = 0;

        // วนลูปเพื่อตรวจสอบแต่ละหลักของตัวเลข
        while (number > 0) {
            long digit = number % 10; // แยกตัวเลขหลักสุดท้าย

            if (digit == 0) {
                zeroCount++; // นับศูนย์
            } else if (digit % 2 == 0) {
                evenCount++; // นับเลขคู่
            } else {
                oddCount++; // นับเลขคี่
            }

            number = number / 10; // ตัดตัวเลขหลักสุดท้ายออก
        }

        // แสดงผลลัพธ์
        System.out.println("Odd digit = " + oddCount);
        System.out.println("Even digit = " + evenCount);
        System.out.println("Zero digit = " + zeroCount);
    }
}




package week4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class test45 {
    public static void main(String[] args){

        double amount , interest , principal , rate; 
 // จำนวนเงินหลังจากได้รับดอกเบี้ยในแต่ละปี
 // ดอกเบี้ยที่ได้รับในแต่ละปี
 // จำนวนเงินต้นก่อนคำนวณดอกเบี้ย
 // อัตราดอกเบี้ย (%)
        Scanner scan = new Scanner(System.in);

        // รับจำนวนเงินต้นจากผู้ใช้
        System.out.println("Enter principal: ");
        principal = scan.nextDouble();

        // รับอัตราดอกเบี้ยจากผู้ใช้
        System.out.println("Enter interest rate: ");
        rate = scan.nextDouble();
        rate = rate / 100; // แปลงอัตราดอกเบี้ยเป็นทศนิยม

        // สร้างรูปแบบการแสดงผลตัวเลข
        DecimalFormat twoDigits = new DecimalFormat("0.00"); // สำหรับจำนวนเงิน
        DecimalFormat threeDigits = new DecimalFormat("0.000"); // สำหรับดอกเบี้ย

        // แสดงหัวตาราง
        System.out.println("Year\tInterest\tAmount on deposit");

        // เริ่มต้นคำนวณเงินต้นและดอกเบี้ย
        amount = principal; // กำหนดจำนวนเงินต้นเริ่มต้น
        for (int year = 1; year <= 10; year++) {
            // คำนวณดอกเบี้ย
            interest = amount * rate;

            // เพิ่มดอกเบี้ยเข้าไปในจำนวนเงินรวม
            amount = amount + interest;

            // แสดงผลลัพธ์ในแต่ละปี
            System.out.println(year + "\t" +
                               threeDigits.format(interest) + "\t\t" +
                               twoDigits.format(amount));
        }
    }
}

    


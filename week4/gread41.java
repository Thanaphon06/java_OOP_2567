package week4;
import java.util.Scanner;
public class gread41 {
    
 public static void main(String[] args) {
 int score;
 Scanner scan = new Scanner(System.in);

 System.out.println("Program Calculate grade.");
 System.out.println("Enter student score : ");
 score = scan.nextInt();

 if ((score >= 0) && (score <= 100)) {
 String grade;
 if (score >= 80) grade = "A";
 else if (score >= 75) grade = "B+";
 else if (score >= 70) grade = "B";
 else if (score >= 65) grade = "C+";
 else if (score >= 60) grade = "C";
 else if (score >= 55) grade = "D+";
 else if (score >= 50) grade = "D";
 else grade = "F";

 System.out.println("Student gradde is " + grade );
 }
 else {
 System.out.println("Invalid student score.");
 }
 System.out.println("End Program.");
 }
} 


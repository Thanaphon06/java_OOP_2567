package week4;

import java.util.Scanner;

public class gread41_ifonly {
    
 public static void main(String[] args) {
 int score;
 

 Scanner scan = new Scanner(System.in);

 System.out.println("Program Calculate grade.");
 System.out.println("Enter student score : ");
 score = scan.nextInt();

 if ((score >= 0) && (score <= 100)) {
 String grade = "F";
 
 if (score >= 80) grade = "A";
 if (score >= 75 && score < 80) grade = "B+";
 if (score >= 70 && score < 75) grade = "B";
 if (score >= 65 && score < 70) grade = "C+";
 if (score >= 60 && score < 65) grade = "C";
 if (score >= 55 && score < 60) grade = "D+";
 if (score >= 50 && score < 55) grade = "D";

 
 System.out.println("Student gradde is " + grade );

 
 }else {
 System.out.println("Invalid student score.");
 }
 
 System.out.println("End Program.");
 }
}

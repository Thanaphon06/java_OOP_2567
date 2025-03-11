import java.util.Scanner;

public class test3_7 {
    public static void main(String[] args) {
        String message;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Your Name : ");
        message = scan.nextLine();
        System.out.println("You entered : \"" + message + "\"");
    }
}

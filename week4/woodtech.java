package week4;
import java.util.Scanner;
public class woodtech {
    

    //int x , y , m , n;
    // m โต๊ะใหญ่ n โต๊ะเล็ก
    // xไม้แผ่น yไม้ท่อน
    // m use x for 2 y for 6
    // n use x for 1 y for 4
public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);


    int x , y , m , n , i = 0 , j = 0
    ,usex = 0 , usey = 0;
    
    do {
        System.out.println("!Warning don't enter number below 1!");
        System.out.print("How many panmai do u have?[EX.10 20]");
        x = scan.nextInt();
        y = scan.nextInt();

        if (x <= 0) {
            System.out.println("panmai are can't below 1");
        }
        else if(y <= 0){
            System.out.println("Wood are can't below 1");
        }
    } while (x <= 0 || y<= 0);

    do {
        System.out.println("!Warning don't enter number below 1 on both order!");
        System.out.println("How many order do u have? [EX.5 6]");
        m = scan.nextInt();
        n = scan.nextInt();  
        if (m <= 0 && n <= 0) {
            System.out.println("Both Value can't below 1");
            
        }
    } while (m <= 0 && n <= 0);


    while (i < m) {
        usex += 2;
        usey += 6;
        i++;
    }

    while (j < n) {
        usex += 1;
        usey += 4;
        j++;
    }
    
    System.out.println(usex + " " + usey);
 
    
}
    


}

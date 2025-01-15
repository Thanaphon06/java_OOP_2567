import java.util.Scanner;
public class testcalculate {
    
    public static String month = "/01/2025";
    public static String days[] = {"05" + month, 
        "06" + month, 
        "07" + month,
        "08" + month,
        "09" + month};
    public static String line = "=======================" , menu = "Start Program";
    public static double timeIn[] , timeOut[];

    public static void main(String[] args) {

        int i = 0;
        
        Scanner scan = new Scanner(System.in);
        employee emp = new employee();
        double timeIn[] = new double[5];
        double timeOut[] = new double[5];
        
        System.out.println(menu);
        System.out.println(line);
        

        emp.calOT(days, timeIn, timeOut);


    }


    
} 
    

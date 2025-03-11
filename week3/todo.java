package week3;
import java.util.Scanner;
public class todo {

    public void degree(){

        float c_degree , f_degree;
        c_degree = 1;
        f_degree =  (c_degree*9/5) + 32;
        System.out.println("Degree" + f_degree);
        // F = (9/5)*c+32

    }

    public void withdraw(){
        float deposit , interate , year = 5 , i = 1;
        Scanner input = new Scanner(System.in);
        interate = 0.05F;
        deposit = input.nextFloat();

        while (i <= year) {
            deposit += (deposit * interate);
            System.out.println(deposit);
            i++;
            
        }
        input.close();
                
    }

    public void numba(){
        int numberi ,dgit1,dgit2,dgit3,dgit4;
        String Valueyeee;
        Scanner input = new Scanner(System.in);
        numberi = input.nextInt();
        dgit1 = numberi / 1000;
        dgit2 = (numberi / 100) % 10;    
        dgit3 = (numberi / 10) % 10;     
        dgit4 = numberi % 10;   

        Valueyeee = dgit1 + "   " + dgit2 + "   "
        + dgit3 + "   " + dgit4;
        System.out.println(Valueyeee);

        input.close();
        
        
    }
public static void main(String[]args){
    todo todoo = new todo();
    String line = "========================";
    todoo.degree();
    System.out.println(line);
    todoo.withdraw();
    System.out.println(line);
    todoo.numba();

}
}

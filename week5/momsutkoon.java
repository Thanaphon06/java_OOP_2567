import java.util.Scanner;
public class momsutkoon {


    public void formual_header(int cout_head){
        System.out.println("============================");
        System.out.println("   Formula " + cout_head + "  ");
        System.out.println("============================");
    }
 /*   public void show_txt_of_formula(int start_num , int end_number){
        System.out.print(start_num + " * " + end_number + " =");
    }*/
    public void calculateyee(int start_num)
    {
        int resulte,i = 1;
        while (i <= 12) {

        resulte = start_num * i;
        System.out.println(start_num + " * " + i + " = " + resulte);
        i++;
        
        }
        
    }
    public static void main(String[]arg){

        Scanner scan = new Scanner(System.in);
        int i , j;
        momsutkoon callfunt = new momsutkoon();

        System.out.println("Please enter 'Start' number.");
        i = scan.nextInt();
        System.out.println("Please enter 'End' number");
        j = scan.nextInt();

        while (i <= j) {

            callfunt.formual_header(i);
           // callfunt.show_txt_of_formula(i, j);
            callfunt.calculateyee(i);
            i++;
            
        }

    }
    
}
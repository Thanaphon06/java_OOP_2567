package tew;

import java.util.Scanner;

public class metTungyang {
    
    
    public void calTungYang(int water , int bread , int egg){

        int tungyang = 0;

        while (water >= 3 && bread >=4 && egg >=2) {
         
            tungyang ++;
            water = water - 3;
            bread = bread - 4;
            egg = egg - 2;
            
        }
        
        System.out.println(tungyang + " " + water + " " + bread + " " + egg);
        
    }

    public int enterWater(){

        int water=0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter water :");
        water = scan.nextInt();

        return water;
    }
    public int enterBread(){
        int bread = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter bread :");
        bread = scan.nextInt();
        return bread;
    }
    public int enterEgg(){
        int egg = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter egg :");
        egg = scan.nextInt();
        return egg;
    }
}

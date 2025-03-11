package tew.yee;

import javax.swing.JOptionPane;

public class coffemachine {
    
    public static void main(String[] args) {
        boolean yee;
        String  order = "";

        String menu ="[1] Suga coffee" + "\n" +
                     "[2] Milk coffee" + "\n" +
                    "[0] Exit"  ;

        String coffemikeMenu = "";
        int totalSC = 0 , totalMC = 0;
        String endProgram = "Total : \n";
        
        
    do {
        
        order = JOptionPane.showInputDialog(null,menu,"Order",3);

        String words[] = order.split(" ");

        //1 10
        //0 1
        if (words[0].equalsIgnoreCase("1")) { //equalsIgnoreCase ไม่สนพิมพ์เล็กพิมพ์ใหญ่  
            //String a = JOptionPane.showInputDialog(null,menu,"Order",3);
            int qty = Integer.parseInt(words[1]);
            totalSC += qty * 15;
            endProgram += "Sugar Coffee : " + qty + " " + totalSC +" Bath \n";            
        }

        if (words[0].equalsIgnoreCase("2")) {
            //String a = JOptionPane.showInputDialog(null,menu,"Order",3);
           
            int qty = Integer.parseInt(words[1]);
            totalMC += qty * 20;
            endProgram += "Milk Coffee : " + qty + " " + totalMC +" Bath \n";            
            JOptionPane.showMessageDialog(null, totalSC, "sugaarCoffee", 0);            
        }

        if (words[0].equalsIgnoreCase("0")) {
            break;
        }


    } while(true);  

    JOptionPane.showMessageDialog(null, endProgram, "Total", 3);
      



        

















    /* 
        int sugar = 5 , milk = 5 , coffee = 5;
        int sugarCoffee = 0 , milkCoffee = 0;

        
        if (coffee >= 1 && sugar >= 1) {
            sugarCoffee += 1;
            sugar -= 1;
            coffee -= 1;
        }

        if (coffee >= 1 && milk >= 2) {
            milkCoffee += 1;
            coffee -= 1;
            milk -= 2;
        }



        System.out.println(sugarCoffee +" "+ sugar+" " + coffee);
*/


    }
}


// 1 กาแฟน้ำตาล 2 กาแฟนม 3 ออกจากโปรแกมฃ
// วัตถุดิบ นม กาแฟ น้ำตาล
//กาแฟน้ำตาลล ใช้ กาแฟ 1 น้ำตาล 1
//กาแฟน๊มมมมมใช้ กาแฟ 1 นม 2
//หากไม่พอ ให้ตรวจสอบการขาด ว่าขาดเท่าไหร่
//การทำงาน 
//ให้แสดงออกมาเป็นหน้าต่าง
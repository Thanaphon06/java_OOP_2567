package week6_array;
import javax.swing.JOptionPane;
public class n1 {

    public static void main(String[]arg){
        String order = "" , 
        bill = "Your order :\n",
        detail = ":";
        

        int total = 0 , unit = 0;
        do{
            order = JOptionPane.showInputDialog(null , "test" , "test" , 1);
            String[] words = order.split(" ");
            for(String word : words){
                System.out.println(word);
            }
            if (words[0].equals("Exit") || 
            words[0].equals("exit")) {
                break;
            }
            if (words[0].equals("Coke")) {
                int price = 15,
                qty = Integer.parseInt(words[1]);

                unit = price * qty;
                total += unit;

                bill += "Coke 15 x " + qty + " = " +
                (price * qty) + "\n";
            }
            if  (detail.equals(":")) {
                detail += unit;
            }
            else{
                detail += " + " + unit;
            }
        }while(true);
    
        bill += "Total " + detail + " = " + total;
        JOptionPane.showMessageDialog(null, bill, "Order", 1);
    }
}

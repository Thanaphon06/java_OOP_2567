package week6_array;

import javax.swing.JOptionPane;

public class code_6706021410249 {
    public static void main(String[]args){
        boolean checkExchange = true;
        String [] nameMenu = {"[P] Pepsi","[F] Fanta","[C] Coffee","[S] Sprite","[M] Mineral Water"};
        int [] price = {15,13,25,20,18};
        String menu = nameMenu[0] + " " + price[0] +"Bath\n" + 
                        nameMenu[1] + " " + price[1] + "Bath\n" + 
                        nameMenu[2] + " " + price[2] + "Bath\n" +
                        nameMenu[3] + " " + price[3] + "Bath\n" +
                        nameMenu[4] + " " + price[4] + "Bath\n" +
                        "[0] End Order\n" +
                        "Enter your order :"
        , order = "" 
        , bill = "Your Order : \n"
        , detail = ":"
        , money = "",
        exchangetotal = "Remain "
        , exchangeDetail = "Result of Money exchange : \n";

        int total = 0 ,
        enterMoney = 0,
        totalExchnage = 0;

        do{
            order = JOptionPane.showInputDialog(null,menu,"Order",1);
            
            String words[] = order.split(" ");
            for (String word : words){
                System.out.println(word);
            }

            if (words[0].equals("0") || 
            words[0].equals("Exit") ||
            words[0].equals("exit")) {
                break;
            }

            // Handling different drink orders
            if (words[0].equals("P") || words[0].equals("p")) {
                int pepsiPrice = price[0];
                int qty = Integer.parseInt(words[1]);
                int unit = pepsiPrice * qty;
                total += unit;
                bill += "Pepsi 15 x " + qty + " = " + unit + "\n";
                if (detail.equals(":")) detail += unit;
                else detail += " + " + unit;
            }

            if (words[0].equals("F") || words[0].equals("f")) {
                int fantaPrice = price[1];
                int qty = Integer.parseInt(words[1]);
                int unit = fantaPrice * qty;
                total += unit;
                bill += "Fanta 13 x " + qty + " = " + unit + "\n";
                if (detail.equals(":")) detail += unit;
                else detail += " + " + unit;
            }

            if (words[0].equals("C") || words[0].equals("c")) {
                int coffeePrice = price[2];
                int qty = Integer.parseInt(words[1]);
                int unit = coffeePrice * qty;
                total += unit;
                bill += "Coffee 25 x " + qty + " = " + unit + "\n";
                if (detail.equals(":")) detail += unit;
                else detail += " + " + unit;
            }

            if (words[0].equals("S") || words[0].equals("s")) {
                int spritePrice = price[3];
                int qty = Integer.parseInt(words[1]);
                int unit = spritePrice * qty;
                total += unit;
                bill += "Sprite 20 x " + qty + " = " + unit + "\n";
                if (detail.equals(":")) detail += unit;
                else detail += " + " + unit;
            }

            if (words[0].equals("M") || words[0].equals("m")) {
                int mWaterPrice = price[4];
                int qty = Integer.parseInt(words[1]);
                int unit = mWaterPrice * qty;
                total += unit;
                bill += "Mineral Water 18 x " + qty + " = " + unit + "\n";
                if (detail.equals(":")) detail += unit;
                else detail += " + " + unit;
            }

        }while(true);

        bill += "total " + detail + " = " + total + "\nEnter Money : ";
        int pun, haroy, roy, hazip, yeezip, zip, ha, zong, nung;

        // Get money from user
        do {
            money = JOptionPane.showInputDialog(null, bill,"Detail",1);
            enterMoney = Integer.parseInt(money);
        } while (total > enterMoney);
        
        totalExchnage = enterMoney - total;

        exchangetotal = money +" - "+ total +" = "+ (totalExchnage) + "\n" + exchangeDetail;

        // Money exchange calculation
        pun = totalExchnage / 1000;
        totalExchnage %= 1000;

        haroy = totalExchnage / 500;
        totalExchnage %= 500;

        roy = totalExchnage / 100;
        totalExchnage %= 100;

        hazip = totalExchnage / 50;
        totalExchnage %= 50;

        yeezip = totalExchnage / 20;
        totalExchnage %= 20;

        zip = totalExchnage / 10;
        totalExchnage %= 10;

        ha = totalExchnage / 5;
        totalExchnage %= 5;

        zong = totalExchnage / 2;
        totalExchnage %= 2;

        nung = totalExchnage / 1;
        totalExchnage %= 1;

        exchangetotal += "1000 = " + pun + "\n" +
                         "500 = " + haroy + "\n" +
                         "100 = " + roy + "\n" +
                         "50 = " + hazip + "\n" +
                         "20 = " + yeezip + "\n" +
                         "10 = " + zip + "\n" +
                         "5 = " + ha + "\n" +
                         "2 = " + zong + "\n" +
                         "1 = " + nung + "\n";

        JOptionPane.showMessageDialog(null, exchangetotal, "Exchange", 1);
    }
}

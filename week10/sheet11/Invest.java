package sheet11;

// File Name : Invest.java
import java.awt.*;

public class Invest {
    private float interestRate;
    private float oldAmount, newAmount;
    private float dollars, cents;

    public Invest() {
    }

    public void setAmount(float amount) {
        oldAmount = amount;
    }

    public void setRate(float rate) {
        interestRate = rate;
    }

    public void anotherYear() {
        newAmount = oldAmount + (oldAmount * interestRate / 100.0f);
        dollars = (int) newAmount;
        cents = Math.round(100.0f * (newAmount - dollars));
        oldAmount = newAmount;
    }

    public void displayInterest(Graphics g) {
        g.drawString("Amount " + oldAmount, 10, 100);
        g.drawString("Interest " + interestRate, 10, 120);
        g.drawString("Your money at the end of the year is ", 10, 140);
        g.drawString(dollars + " dollars " + cents + " cents", 10, 160);
    }
}

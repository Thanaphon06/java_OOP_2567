import java.util.Scanner;

public class employee1 {

    private int hour,minutes,hourToMinute,totalTime;

    private double hourRate;
    private int timeInMinutes,timeOutMinutes,workMinutes;
    private int workHours , workExtraMinutes;

    public int changeTimeToMinute (double empTimeIn){
        
        hour = (int) empTimeIn;
        minutes = (int) (empTimeIn * 100) - (hour * 100);
        
        hourToMinute = hour * 60;
        totalTime = hourToMinute + minutes;
        
        return totalTime;
        
    }


public double calculateOvertimeOrDeduction(double empTimeIn, double empTimeOut) {
    // คำนวณเวลาการทำงานในวันเดียว โดยแปลงเวลาเป็นนาที
    hourRate = 50;
    timeInMinutes = changeTimeToMinute(empTimeIn);
    timeOutMinutes = changeTimeToMinute(empTimeOut);
    workMinutes = timeOutMinutes - timeInMinutes;

    // คำนวณชั่วโมงทำงาน
    workHours = workMinutes / 60;
    workExtraMinutes = workMinutes % 60;

    // ปัดเวลาเป็นชั่วโมง (30 นาทีขึ้นไปปัดขึ้น, น้อยกว่า 30 นาทีปัดลง)
    if (workExtraMinutes >= 30) {
        workHours += 1;  // ปัดขึ้น
    }

    // คำนวณค่าล่วงเวลา (โอที) หรือเงินที่ถูกหัก
    double total = 0;
    if (workHours > 8) {
        // คำนวณโอที
        total = (workHours - 8) * hourRate;  // คำนวณโอทีที่เกิน
    } else if (workHours < 8) {
        // คำนวณเงินที่หัก
        total = -(8 - workHours) * hourRate;  // หักเงินตามจำนวนชั่วโมงที่ขาด
    }
    return total;  // คืนค่าการหักหรือค่าโอที
}


public void calOT(String days[] , double timeIn[] , double timeOut[]){

    Scanner scan = new Scanner(System.in);
    double total = 0;
    int i = 0 ;
    while (i <= days.length) {
        System.out.println(days[i]);
        System.out.println("Enter time in (Ex.08.12): ");
        timeIn[i] = scan.nextDouble();
        double x = timeIn[i];

        System.out.println("Enter time out (Ex.17.12):");
        timeOut[i] = scan.nextDouble();
        double y = timeOut[i];
       // System.out.println("Your OT is : " + emp.calculateOvertimeOrDeduction(timeIn[i], timeOut[i]) + "Bath");
        System.out.println("Your OT is : " + calculateOvertimeOrDeduction(x, y) + "Bath");
        total += calculateOvertimeOrDeduction(x, y);

        i++;
        
    }
    System.out.println("Total OT : " + total + "Bath");

}

}
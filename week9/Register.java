// File Name : Register.java
public class Register { 
    private Student std; // ตัวแปรสำหรับเก็บข้อมูลของนักศึกษา
    private Subject sub[]; // อาร์เรย์ของ Subject ที่นักศึกษาลงทะเบียน
    private int max, count = -1; // max คือจำนวนวิชาสูงสุดที่ลงได้, count ใช้ติดตามจำนวนวิชาที่เพิ่มเข้าไปแล้ว

    // Constructor ไม่มีพารามิเตอร์ กำหนดค่าเริ่มต้นให้กับตัวแปร std และ max
    public Register() { 
        std = new Student(); 
        max = 0; 
    } 

    // Constructor ที่รับพารามิเตอร์ Student และจำนวนวิชา
    public Register(Student std, int n) { 
        this.std = std; // กำหนดนักศึกษาที่ลงทะเบียน
        max = n; // กำหนดจำนวนวิชาที่ลงทะเบียนได้สูงสุด
        createSubject(max); // เรียกเมธอดสร้างอาร์เรย์ของ Subject
    } 

    // เมธอดสำหรับสร้างอาร์เรย์ของ Subject ตามจำนวนที่กำหนด
    private void createSubject(int n) { 
        sub = new Subject[n]; 
    } 

    // เมธอดสำหรับกำหนดค่านักศึกษาใหม่
    public void setStudent(Student std) { 
        this.std = std; 
    } 

    // เมธอดสำหรับเพิ่มวิชาเข้าไปในอาร์เรย์
    public void setSubject(Subject sub) { 
        this.sub[++count] = sub; // เพิ่มค่าของ count ก่อน แล้วใช้เป็น index ในการเพิ่มวิชา
    } 

    // เมธอดสำหรับกำหนดวิชาที่ตำแหน่งที่ระบุ
    public void setSubject(Subject sub, int n) { 
        this.sub[n] = sub; // กำหนดค่าให้วิชาใน index ที่กำหนด
    } 

    // เมธอดสำหรับดึงข้อมูลนักศึกษาในรูปแบบ String
    public String getStudent() { 
        return std.toString(); 
    } 

    // เมธอดสำหรับดึงข้อมูลวิชาที่ index ที่กำหนดในรูปแบบ String
    public String getSubject(int n) { 
        return sub[n].toString(); 
    } 
}

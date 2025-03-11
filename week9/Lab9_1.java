// File Name : Lab9_1.java
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

public final class Lab9_1 extends JFrame implements ActionListener { 
    private Student std[]; // อาร์เรย์เก็บข้อมูลนักศึกษา
    private Subject sub[]; // อาร์เรย์เก็บข้อมูลวิชา
    private String[] studentStr, subjectStr; // อาร์เรย์สำหรับเก็บข้อมูลนักศึกษาและวิชาในรูปแบบ String เพื่อใช้ใน JComboBox
    private Container container; // ตัวจัดการ layout
    private JComboBox<String> stdCombo, subCombo; // ตัวเลือกแบบดรอปดาวน์สำหรับนักศึกษาและวิชา
    private JLabel stdLabel, subLabel; // ป้ายข้อความกำกับ JComboBox
    private JButton addstdBtn, addsubBtn, saveBtn, clearBtn, cancleBtn; // ปุ่มต่าง ๆ ในโปรแกรม
    private JTextField stdText; // ช่องแสดงข้อมูลนักศึกษาที่เลือก
    private JTextArea subTextArea; // ช่องแสดงข้อมูลวิชาที่ลงทะเบียน
    private JScrollPane subScroll; // ScrollPane สำหรับ JTextArea (เผื่อกรณีข้อมูลเยอะ)
    private Register reg; // ตัวแปร Register ใช้เก็บข้อมูลนักศึกษาและวิชาที่ลงทะเบียน
    private int count = 0; // ตัวแปรนับจำนวนวิชาที่เพิ่มเข้าไป (สูงสุด 8 วิชา)

    /** สร้างอินสแตนซ์ของ Lab9_1 และกำหนดค่าพื้นฐาน */
    public Lab9_1() { 
        super("Program Student Register"); // กำหนดชื่อหน้าต่าง
        initStudent(); // เรียกเมธอดกำหนดค่าข้อมูลนักศึกษา
        initSubject(); // เรียกเมธอดกำหนดค่าข้อมูลวิชา
        initGui(); // เรียกเมธอดกำหนด GUI
        reg = new Register(new Student(), 8); // สร้างอ็อบเจ็กต์ Register เพื่อเก็บข้อมูลนักศึกษาและวิชา (สูงสุด 8 วิชา)
    } 

    /** กำหนดข้อมูลนักศึกษา */
    public void initStudent() { 
        std = new Student[10]; 
        studentStr = new String[10]; 

        // สร้างนักศึกษา 10 คน
        std[0] = new Student("5066260010", "Alice", "Anderson"); 
        std[1] = new Student("5066260024", "Bob", "Brown"); 
        std[2] = new Student("5066260035", "Charlie", "Clarkson"); 
        std[3] = new Student("5066260048", "David", "Dawson"); 
        std[4] = new Student("5066260052", "Emma", "Evans"); 
        std[5] = new Student("5066260066", "Frank", "Foster"); 
        std[6] = new Student("5066260079", "Grace", "Greenwood"); 
        std[7] = new Student("5066260083", "Henry", "Harrison"); 
        std[8] = new Student("5066260095", "Isabella", "Ingram"); 
        std[9] = new Student("5066260101", "Jack", "Johnson");

        // แปลงเป็น String เพื่อนำไปแสดงใน JComboBox
        for (int i = 0; i < std.length; i++) {
            studentStr[i] = std[i].toString();
        }
    } 

    /** กำหนดข้อมูลวิชา */
    public void initSubject() { 
        sub = new Subject[10]; 
        subjectStr = new String[10]; 

        // สร้างวิชา 10 วิชา
        sub[0] = new Subject("662305", "IT Laboratory II", 1); 
        sub[1] = new Subject("662309", "Data Structure", 3); 
        sub[2] = new Subject("662310", "Database System", 3); 
        sub[3] = new Subject("662317", "Data Communication", 1); 
        sub[4] = new Subject("662327", "Computer Programming", 1); 
        sub[5] = new Subject("662330", "Computer Networks", 3);
        sub[6] = new Subject("662340", "Software Engineering", 3);
        sub[7] = new Subject("662350", "Artificial Intelligence", 3);
        sub[8] = new Subject("662360", "Cybersecurity Fundamentals", 3);
        sub[9] = new Subject("662370", "Cloud Computing", 3);

        // แปลงเป็น String เพื่อนำไปแสดงใน JComboBox
        for (int i = 0; i < sub.length; i++) {
            subjectStr[i] = sub[i].toString();
        }
    } 

    /** สร้าง GUI */
    public void initGui() { 
        container = getContentPane(); 
        container.setLayout(new FlowLayout()); 

        stdLabel = new JLabel("Select Student : "); 
        container.add(stdLabel); 

        stdCombo = new JComboBox<>(studentStr); 
        stdCombo.setMaximumRowCount(3); 
        container.add(stdCombo); 

        addstdBtn = new JButton("Add Student"); 
        addstdBtn.addActionListener(this); 
        container.add(addstdBtn); 

        stdText = new JTextField(40); 
        stdText.setEditable(false); 
        container.add(stdText); 

        subLabel = new JLabel("Select Subject : "); 
        container.add(subLabel); 

        subCombo = new JComboBox<>(subjectStr); 
        subCombo.setMaximumRowCount(5); 
        container.add(subCombo); 

        addsubBtn = new JButton("Add Subject"); 
        addsubBtn.setEnabled(false); 
        addsubBtn.addActionListener(this); 
        container.add(addsubBtn); 

        subTextArea = new JTextArea(5, 50); 
        subTextArea.setEditable(false); 
        subScroll = new JScrollPane(subTextArea); 
        container.add(subScroll); 

        saveBtn = new JButton(" Save "); 
        saveBtn.setEnabled(false); 
        saveBtn.addActionListener(this); 
        container.add(saveBtn); 

        cancleBtn = new JButton(" Cancle "); 
        cancleBtn.setEnabled(false); 
        cancleBtn.addActionListener(this); 
        container.add(cancleBtn); 

        setSize(600, 300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true); 
    } 

    /** จัดการเหตุการณ์ของปุ่มต่าง ๆ */
    public void actionPerformed(ActionEvent event) { 
        if (event.getSource() == addstdBtn) { 
            int n = stdCombo.getSelectedIndex(); //รับค่า นศ. ที่ถูกเลือก
            stdText.setText(std[n].toString()); //SetText
            reg.setStudent(std[n]);  
            //ส่วนปิด เปืดปุ่มให้กดได้ไม่ได้
            addstdBtn.setEnabled(false); 
            addsubBtn.setEnabled(true); 
            saveBtn.setEnabled(true); 
            cancleBtn.setEnabled(true); 
        } else if (event.getSource() == addsubBtn) { 
            int n = subCombo.getSelectedIndex(); // รับ index ของวิชาที่เลือก
            if (count < 8) {// ตรวจสอบว่ายังไม่เกิน 8 วิชา
                subTextArea.append(sub[n].toString() + "\n"); 
                reg.setSubject(sub[n], count); 
                count++; 
            }
            if (count == 8) addsubBtn.setEnabled(false); 
        } else if (event.getSource() == saveBtn) { 
            StringBuilder output = new StringBuilder();
            output.append("Student: ").append(reg.getStudent()).append("\nSubjects:\n"); 
            for (int n = 0; n < count; n++) {
                output.append(reg.getSubject(n)).append("\n"); 
            }
            JOptionPane.showMessageDialog(this, output.toString(), "Registration Data", JOptionPane.INFORMATION_MESSAGE); 
            resetBtn(); 
        } else if (event.getSource() == cancleBtn) { 
            resetBtn(); 
        } 
    } 

    public void resetBtn() { 
        addstdBtn.setEnabled(true); 
        addsubBtn.setEnabled(false); 
        saveBtn.setEnabled(false); 
        cancleBtn.setEnabled(false); 
        stdText.setText(""); 
        subTextArea.setText(""); 
        count = 0;
    } 

    public static void main(String[] args) { 
        new Lab9_1(); 
    } 
}

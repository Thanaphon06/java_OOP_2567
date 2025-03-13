import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;;


public class MemoryGame extends JFrame implements ActionListener {
    private JButton[] buttons = new JButton[8];  // ปุ่มทั้งหมด 8 ปุ่ม
    private ImageIcon[] icons = new ImageIcon[4];  // รูปภาพที่ใช้จับคู่ (จะใช้แต่ละภาพ 2 ครั้ง)
    private ImageIcon[] hiddenIcons = new ImageIcon[8];  // อาร์เรย์ของรูปที่สุ่มมา
    private int[] buttonStates = new int[8];  // เก็บสถานะของปุ่ม (0: ซ่อน, 1: แสดง)
    private int firstIndex = -1;  // ตัวแปรเก็บดัชนีของปุ่มที่ถูกคลิกครั้งแรก
    private int score = 0;  // คะแนนของผู้เล่น
    private JLabel scoreLabel;  // ป้ายแสดงคะแนน

    public MemoryGame() {
        super("Memory Game");

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 4, 10, 10));  // กำหนดการจัดเรียงปุ่มเป็นตาราง 2 แถว 4 คอลัมน์

        // โหลดภาพ
        icons[0] = new ImageIcon("pay.png");  // แทนที่ด้วยเส้นทางของภาพจริงที่คุณใช้
        icons[1] = new ImageIcon("mem.png");
        icons[2] = new ImageIcon("His.png");
        icons[3] = new ImageIcon("Stock.png");

        // สร้างปุ่มและตั้งค่าให้เป็นปุ่มที่สามารถคลิกได้
        for (int i = 0; i < 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setPreferredSize(new Dimension(100, 100));
            buttons[i].addActionListener(this);
            container.add(buttons[i]);
            buttonStates[i] = 0;  // ตั้งสถานะของปุ่มเป็น "ซ่อน"
        }

        // สร้างป้ายคะแนน
        scoreLabel = new JLabel("Score: " + score, SwingConstants.CENTER);
        container.add(scoreLabel);

        // สุ่มรูปภาพและเก็บไว้ใน hiddenIcons
        shuffleImages();

        // ตั้งค่าหน้าต่าง
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // ฟังก์ชันสุ่มตำแหน่งของรูปภาพ
    private void shuffleImages() {
        List<ImageIcon> imageList = new ArrayList<>();
        
        // เพิ่มรูปภาพที่ต้องจับคู่สองครั้ง
        for (int i = 0; i < 2; i++) {
            imageList.add(icons[0]);
            imageList.add(icons[1]);
            imageList.add(icons[2]);
            imageList.add(icons[3]);
        }

        // สุ่มการเรียงลำดับรูปภาพ
        Collections.shuffle(imageList);

        // เก็บผลการสุ่มลงใน hiddenIcons
        for (int i = 0; i < 8; i++) {
            hiddenIcons[i] = imageList.get(i);
        }
    }

    // ฟังก์ชันที่ใช้ในการเปิดปิดปุ่มและตรวจสอบการจับคู่
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();

        // หาอินเด็กซ์ของปุ่มที่ถูกคลิก
        int index = Arrays.asList(buttons).indexOf(sourceButton);

        // ถ้าปุ่มถูกคลิกและยังไม่เปิดอยู่
        if (buttonStates[index] == 0) {
            sourceButton.setIcon(hiddenIcons[index]);  // แสดงภาพที่อยู่ในปุ่มนั้น
            buttonStates[index] = 1;  // ตั้งสถานะปุ่มให้แสดงภาพ

            // ถ้าเป็นการคลิกครั้งแรก
            if (firstIndex == -1) {
                firstIndex = index;
            } else {
                // ถ้าคลิกครั้งที่สอง
                if (hiddenIcons[firstIndex] == hiddenIcons[index]) {
                    score++;  // ถ้าจับคู่ได้ เพิ่มคะแนน
                    scoreLabel.setText("Score: " + score);
                } else {
                    // ถ้าจับคู่ผิดให้ปิดภาพในปุ่ม
                    Timer timer = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            buttons[firstIndex].setIcon(null);
                            buttons[index].setIcon(null);
                            buttonStates[firstIndex] = 0;
                            buttonStates[index] = 0;
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
                firstIndex = -1;  // รีเซ็ตการจับคู่ครั้งแรก
            }
        }
    }

    public static void main(String[] args) {
        new MemoryGame();  // เรียกใช้งานเกม
    }
}
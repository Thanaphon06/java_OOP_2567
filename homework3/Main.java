
// ไฟล์ Main.java
public class Main {
    public static void main(String[] args) {
        String[] names = {"ณัฐ", "ปาล์ม", "มีมี่", "อาร์ท", "บีม", "แก้ว", "ต้น", "เอิร์ธ", "ฝน", "หมิว",
                          "นัท", "บอส", "มาย", "เติ้ล", "โอม", "แจ็ค", "ตูน", "เจน", "ฟ้า", "เก่ง"};
        int[] scores = {85, 72, 45, 90, 88, 67, 54, 76, 91, 80,
                        60, 49, 95, 77, 83, 70, 55, 40, 89, 65};

        for (int i = 0; i < 20; i++) {
            new Student(names[i], scores[i]);
        }

        for (Student student : Student.getStudents()) {
            if (student != null) {
                GradeRecord record = new GradeRecord(student.getName(), new GraduateStudent(student.getName(), student.getScore(), "").calculateGrade());
                System.out.println(record);
            }
        }
    }
}

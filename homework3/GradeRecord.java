
// ไฟล์ GradeRecord.java (เก็บข้อมูลเกรดของนักเรียน)
class GradeRecord {
    private String name;
    private String grade;

    public GradeRecord(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "GradeRecord: " + name + " - Grade: " + grade;
    }
}

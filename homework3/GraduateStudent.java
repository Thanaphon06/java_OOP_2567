// ไฟล์ GraduateStudent.java (สืบทอดจาก Student และมีฟังก์ชันตัดเกรด)
class GraduateStudent extends Student {
    private String thesisTitle;

    public GraduateStudent() {
        super();
        this.thesisTitle = "Untitled";
    }

    public GraduateStudent(String name, int score, String thesisTitle) {
        super(name, score);
        this.thesisTitle = thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public String calculateGrade() {
        if (score >= 80) return "A";
        else if (score >= 70) return "B";
        else if (score >= 60) return "C";
        else if (score >= 50) return "D";
        else return "F";
    }

    @Override
    public String toString() {
        return super.toString() + ", Thesis: " + thesisTitle + ", Grade: " + calculateGrade();
    }
}

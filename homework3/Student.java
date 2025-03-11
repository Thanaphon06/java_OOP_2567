// ไฟล์ Student.java
class Student {
    protected String name;
    protected int score;
    private static final int MAX_STUDENTS = 20;
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount = 0;

    public Student() {
        this.name = "Unknown";
        this.score = 0;
        addStudent(this);
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
        addStudent(this);
    }

    private static void addStudent(Student student) {
        if (studentCount < MAX_STUDENTS) {
            students[studentCount++] = student;
        } else {
            System.out.println("Cannot add more students. Maximum limit reached.");
        }
    }

    public static Student[] getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student: " + name + ", Score: " + score;
    }
}

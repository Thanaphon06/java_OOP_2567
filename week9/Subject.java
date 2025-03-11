//สร้างคลาส subject
public class Subject { 
    private String SubjectCode; 
    private String SubjectName; 
    private int SubjectCredit; 

    /** Creates a new instance of Subject */ 
    public Subject() { 
        setSubjectCode(""); 
        setSubjectName(""); 
        setSubjectCredit(0); 
    } 
    //method for enter ALL data (code,name,credit)
    public Subject(String Code, String Name, int Credit) { 
        setSubjectCode(Code); 
        setSubjectName(Name); 
        setSubjectCredit(Credit); 
    } 

    //set Subject code
    public void setSubjectCode(String Code) { 
        SubjectCode = Code; 
    } 
    //set Subject Name
    public void setSubjectName(String Name) { 
        SubjectName = Name; 
    } 

    public void setSubjectCredit(int Credit) { 
        SubjectCredit = Credit; 
    } 

    //get รับค่า
    public String getSubjectCode() { 
        return SubjectCode; 
    } 

    public String getSubjectName() { 
        return SubjectName; 
    } 

    public int getSubjectCredit() { 
        return SubjectCredit; 
    } 


    //toString String str and get all subject data
    public String toString() { 
        String str = ""; 
        str = getSubjectCode() + " " + getSubjectName() + " " + getSubjectCredit(); 
        return str; 
    } 
}

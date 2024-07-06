package Java.Mock1.JDBC.Practice;

public class Student {
    private int studentId;
    private String studentName;
    private String studentClass;
    private int studentPercentage;


    public Student() {
    }

    public Student(int studentId, String studentName, String studentClass, int studentPercentage) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentPercentage = studentPercentage;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public int getStudentPercentage() {
        return studentPercentage;
    }

    public void setStudentPercentage(int studentPercentage) {
        this.studentPercentage = studentPercentage;
    }

    
}

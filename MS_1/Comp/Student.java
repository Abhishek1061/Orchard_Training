package Java.Comp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Student implements Comparable<Student>, Comparator<Student> {
    private int studentId;
    private String studentName;
    private String studentClass;
    private Long studentPercentage;

    
    
    public Student() {

    }

    public Student(int studentId, String studentName, String studentClass, Long studentPercentage) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentPercentage = studentPercentage;
    }
    
    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentClass=" + studentClass
                + ", studentPercentage=" + studentPercentage + "]";
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
    public Long getStudentPercentage() {
        return studentPercentage;
    }
    public void setStudentPercentage(Long studentPercentage) {
        this.studentPercentage = studentPercentage;
    }

    @Override
    public int compare(Student arg0, Student arg1) {
        return Long.compare(arg0.studentPercentage, arg1.studentPercentage);
    }

    @Override
    public int compareTo(Student o) { 
        return this.studentName.compareTo(o.studentClass);
    }
    
}

class sortByStudentID implements Comparator<Student>{

    

    @Override
    public int compare(Student arg0, Student arg1) {

        return Integer.compare(arg0.getStudentId(), arg1.getStudentId());
        
        // if(arg0.getStudentId() == arg1.getStudentId()){
        //     return 0;
        // }else if(arg0.getStudentId() > arg1.getStudentId()){
        //     return 1;
        // }else{
        //     return -1;
        // }

    }
    

}

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> arr = new ArrayList<Student>();
        System.out.println("Enter the no of students:");
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            System.out.println("Enter students Id:");
            int studentId = sc.nextInt();
            System.out.println("Enter name:");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Enter Class:");
            String studentClass = sc.nextLine();
            System.out.println("Enter Student percentage:");
            long percentage = sc.nextInt();
            Student st = new Student(studentId, name, studentClass, percentage);
            arr.add(st);
        }
        Collections.sort(arr);
        // Iterator<TourPackage> it = arr.iterator();
        // System.out.println("Sorting by comparable method:");
        // while (it.hasNext()) {
        //     TourPackage tp = (TourPackage) it.next();
        //     System.out.println("Package Id:" + tp.packageID);
        //     System.out.println("Destination:" + tp.destination);
        //     System.out.println("Price:" + tp.price);
        // }
        System.out.println("Soreted by name");
    
            System.out.println(arr);

        Collections.sort(arr, new sortByStudentID());
        // Iterator<TourPackage> it1 = arr.iterator();
        // System.out.println("Sorting by Comparator method");
        // while (it1.hasNext()) {
        //     TourPackage tp = (TourPackage) it1.next();
        //     System.out.println("Package Id:" + tp.packageID);
        //     System.out.println("Destination:" + tp.destination);
        //     System.out.println("Price:" + tp.price);
        // }
            System.out.println("Soreted by id");
        System.out.println(arr);

        Student student = new Student();
        System.out.println("Soreted by percentage");
        arr.sort(student);
        System.out.println(arr);
    }


}

package Java.Comp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class PracticeComp implements Comparable<PracticeComp>, Comparator<PracticeComp> {
    int studentId;
    String studentName;
    int studentAge;

    

    public PracticeComp() {

    }

    public PracticeComp(int studentId, String studentName, int studentAge) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
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

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public static void main(String[] args) {
        ArrayList<PracticeComp> arrList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enetr num :");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {

            System.out.println("Enter student id : ");
            int id = sc.nextInt();
            System.out.println("Enter student name");
            String name = sc.next();
            // sc.next();
            System.out.println("Enter the students Age");
            int age = sc.nextInt();

            PracticeComp comp = new PracticeComp(id, name, age);
            arrList.add(comp);
        }
        System.out.println(arrList);

        System.out.println("Sorted by Name");
        Collections.sort(arrList);
        System.out.println(arrList);

        System.out.println("Sorted by age: ");
        PracticeComp com = new PracticeComp();

        arrList.sort(com);
        System.out.println(arrList);
    }

    @Override
    public int compare(PracticeComp arg0, PracticeComp arg1) {
        // TODO Auto-generated method stub
        return Integer.compare(arg0.getStudentAge(), arg1.getStudentAge());
    }

    @Override
    public int compareTo(PracticeComp o) {
        // TODO Auto-generated method stub
        return this.studentName.compareTo(o.studentName);
    }

    @Override
    public String toString() {
        return "PracticeComp [studentId= " + studentId + " " + studentName + " " + studentAge + "]" +"\n";
    }

}

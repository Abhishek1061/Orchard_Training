import java.io.*;
import java.util.*;
import java.lang.Math;

public class Employee {
    private int empID;
    private String empName;
    private double empBasicSalary;

    Employee(int empID, String empName, double empBasicSalary){
        this.empID = empID;
        this.empName = empName;
        this.empBasicSalary = empBasicSalary;
    }

    public void setEmpID(int empID){
        this.empID = empID;
    }

    public int getEmpID(){
        return empID;
    }

    public void setEmpName(String empName){
        this.empName = empName;
    }

    public String getEmpName(){
        return empName;
    }

    public void setEmpBasicSalary(double empBasicSalary){
        this.empBasicSalary = empBasicSalary;
    }

    public double getEmpBasicSalary(){
        return empBasicSalary;
    }

    public void calculateNetSalary(){
        double netSalary;
        double basicSalary = getEmpBasicSalary();
        double HRA = (basicSalary*20)/100;
        netSalary = (basicSalary +HRA)*10;
        System.out.println("Net Salary: " + netSalary);

        
    }
    public void displayEmployeeDetails(){
        
        System.out.print("Employee ID: " + empID+", ");
        System.out.print("Employee Name: " + empName+", ");
        calculateNetSalary();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int id1 = scan.nextInt();
        scan.nextLine();
        String name1 = scan.nextLine();
        double salary1 = scan.nextDouble();

        int id2 = scan.nextInt();
        scan.nextLine();
        String name2 = scan.nextLine();
        double salary2 = scan.nextDouble();

        Employee emp1  = new Employee(id1,name1,salary1);
        Employee emp2  = new Employee(id2,name2,salary2);

        System.out.println("Employee Details: ");
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
        

    }
}
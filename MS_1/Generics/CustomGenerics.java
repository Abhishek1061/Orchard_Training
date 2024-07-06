import java.io.*;
import java.util.*;
import java.lang.Math;


public class CustomGenerics {
  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0; i<= n; i++){
            int id = sc.nextInt();
            String name = sc.next();
            double salary = sc.nextDouble();
            double hra = sc.nextDouble();
            Employee<Integer> emp = new Employee<>(id, name, salary, hra);
            double netSalary = emp.calculateNetSalary();

            System.out.println(emp.getEmpId());
            System.out.println(emp.getEmpName());
            System.out.println(emp.getEmpBasicSalary());
            System.out.println(emp.calculateNetSalary());
            System.out.println(netSalary);

        }
        

    
       
    }
}

class Employee<T>{
    private T empId;
    private String empName;
    private double empBasicSalary;
    private double empHra;

    public Employee(T empId, String empName, double empBasicSalary, double empHra){
        this.empId = empId;
        this.empName = empName;
        this.empBasicSalary =empBasicSalary;
        this.empHra = empHra;
    }

    public T getEmpId() {
        return empId;
    }

    public void setEmpId(T empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpBasicSalary() {
        return empBasicSalary;
    }

    public void setEmpBasicSalary(double empBasicSalary) {
        this.empBasicSalary = empBasicSalary;
    }

    public double getEmpHra() {
        return empHra;
    }

    public void setEmpHra(double empHra) {
        this.empHra = empHra;
    }

    public double calculateNetSalary(){
        double hra = 0.12 * empBasicSalary;
        return empBasicSalary + hra;
    }
}
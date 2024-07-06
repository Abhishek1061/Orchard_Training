


import java.util.*;
import java.lang.Math;


public class Solution {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.nextLine();

        int id = sc.nextInt();
        sc.nextLine();

        String name = sc.nextLine();

        double salary = sc.nextDouble();

        if(type.equalsIgnoreCase("temp")){
            int daysWorked = sc.nextInt();

            TemporaryEmployee tempEmp = new TemporaryEmployee(id, name, salary,daysWorked);
            System.out.println(tempEmp);
            System.out.println("Temporary Employee Salary per day: " + tempEmp.calculateNetSalary());

        }else if(type.equalsIgnoreCase("permanent")){
            double hra = sc.nextDouble();

            PermanentEmployeee perEmp = new PermanentEmployeee(id, name, salary,hra);
            System.out.println(perEmp);
            System.out.println("Permanent Employee Net Salary: " + perEmp.calculateNetSalary());

        }else{
            System.out.println("Invalid employee type entered.");
        }


    
    
    }
}

class Employee{
    private int empId;
    private String empName;
    private double empBasicSalary;

    public Employee(int empId, String empName, double empBasicSalary){
        this.empId = empId;
        this.empName = empName;
        this.empBasicSalary = empBasicSalary;
    }

    public void setEmpId(int empId){
        this.empId = empId;
    }

    public int getEmpId(){
        return empId;
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

    public double calculateNetSalary(){
        double hra = empBasicSalary * 0.12;
        return empBasicSalary + hra;
    }

    @Override
    public String toString(){
        return "Employee ID: " + empId + ", Name: " + empName + ", Basic Salary: " + empBasicSalary;
    }

}

class PermanentEmployeee extends Employee{
    private double hra;
    
    public PermanentEmployeee(int empId, String empName, double empBasicSalary,double hra){
        super(empId, empName, empBasicSalary);
        this.hra=hra;
    }
    public double getHra() {
        return hra;
    }
    public void setHra(double hra) {
        this.hra = hra;
    }
    
    @Override
    public double calculateNetSalary(){
        double hraAmount = getEmpBasicSalary() * (hra/100);
        return getEmpBasicSalary() + hraAmount;
    }

    @Override
    public String toString(){
        return "Permanent Employee ID: " + getEmpId() + "\nPermanent Employee Name: " + getEmpName() + "\nPermanent Employee Basic Salary: " + getEmpBasicSalary() + "\nPermanent Employee HRA: " + hra;
    }  


}

class TemporaryEmployee extends Employee{
    private int noOfDaysWorked;
    // TemporaryEmployee te = new TemporaryEmployee();
    public TemporaryEmployee(int empId, String empName, double empBasicSalary, int noOfDaysWorked){
        super(empId,empName,empBasicSalary);
        this.noOfDaysWorked = noOfDaysWorked;
    }
    public void setNoOfDaysWorked( int noOfDaysWorked){
        this.noOfDaysWorked = noOfDaysWorked;
    }

    public int getNoOfDaysWorked(){
        return noOfDaysWorked;
    }
    @Override
    public double calculateNetSalary(){
    double dailySalary = getEmpBasicSalary()/ noOfDaysWorked;
    return dailySalary;
    }

    @Override
    public String toString(){
        return "Temporary Employee ID: " + getEmpId() + "\nTemporary Employee Name: " + getEmpName() + "\nTemporary Employee Basic Salary: " + getEmpBasicSalary() + "\nTemporary Employee Number of Days Worked: " + noOfDaysWorked;
    }  


}

 

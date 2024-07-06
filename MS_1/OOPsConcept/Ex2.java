import java.io.*;
import java.util.*;
import java.lang.Math;


public class Ex2 {
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

    
    
    }
}

class Employee{
    private int empId;
    private String empName;
    private double empBasicSalary;

    Scanner sc = new Scanner(System.in);
    public void calculateNetSalary(){
        double netSalary;
        double basicSalary = getEmpBasicSalary();
        double HRA = (basicSalary*12)/100;
        netSalary = (basicSalary +HRA)*10;
        System.out.println("Net Salary: " + netSalary);
    }
    
    Employee(int empId, empName, empBasicSalary ){
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


}

class PermanentEmployeee extends Employee{
    private double hra;
    private double netSalary;

    public double getHra() {
        return hra;
    }
    public void setHra(double hra) {
        this.hra = hra;
    }
    public double getNetSalary() {
        return netSalary;
    }
    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    @Override
    public void calculateNetSalary(){
        System.out.println()
    }


}

class TemporaryEmployee extends Employee{
    private int noOfDaysWorked;
    
    public TemporaryEmployee(int empId, String empName, double empBasicSalary, int noOfDaysWorked){
        super(empId,empName,empBasicSalary);
        this.noOfDaysWorked = noOfDaysWorked;

        public void setNoOfDaysWorked( int noOfDaysWorked){
            this.noOfDaysWorked = noOfDaysWorked
        }

        public int getNoOfDaysWorked(){
            return noOfDaysWorked;
        }

        @Override
        public void calculateNetSalary(){
        double netSalary;
        double basicSalary = getEmpBasicSalary();
        double HRA = (basicSalary*12)/100;
        netSalary = (basicSalary +HRA)*10;
        System.out.println("Net Salary: " + netSalary);
    }

    }

}


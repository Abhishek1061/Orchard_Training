
import java.io.*;
import java.util.*;
import java.lang.Math;


public class Solution {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        PermanentEmpl emp1 = new PermanentEmpl();
        emp1.setEmpName(scan.next());
        emp1.setEmpBasicSalary(scan.nextDouble());

        TemporaryEmpl temp1 = new TemporaryEmpl();
        temp1.setEmpName(scan.next());
        temp1.setEmpBasicSalary(scan.nextDouble());
        temp1.setNoOfDaysWorked(scan.nextInt());

        emp1.calculateNetSalary();

        System.out.println(emp1.getEmpName());
        System.out.println(emp1.getEmpBasicSalary());
        System.out.println(emp1.getEmpHra());
        System.out.println(emp1.getEmpNetSalary());

        System.out.println(temp1.getEmpName());
        System.out.println(temp1.getEmpBasicSalary());
        System.out.println(temp1.getNoOfDaysWorked());
        double netSalary1 = temp1.calculateNetSalary();
        System.out.println(netSalary1);








    }
}

interface Employee {
    public double calculateNetSalary();

}

class TemporaryEmpl implements Employee{
    private String empName;
    private double empBasicSalary;
    private int noOfDaysWorked;

    // public TemporaryEmpl(String empName, double empBasicSalary, int noOfDaysWorked){
    //     this.empName = empName;
    //     this.empBasicSalary = empBasicSalary;
    //     this.noOfDaysWorked = noOfDaysWorked;
    // }

    public void setEmpName( String empName){
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

    public void setNoOfDaysWorked(int noOfDaysWorked){
        this.noOfDaysWorked = noOfDaysWorked;
    }

    public int getNoOfDaysWorked(){
        return noOfDaysWorked;
    }

    @Override
    public double calculateNetSalary(){

        double dailyWages = empBasicSalary/ 30;
        return dailyWages*noOfDaysWorked;

    }
}

class PermanentEmpl implements Employee{
    private String empName;
    private double empBasicSalary;
    private double empHra;
    private double empNetSalary;
    private int noOfDaysWorked;

    // public TemporaryEmpl(String empName, double empBasicSalary,double empHra, double empNetSalary, int noOfDaysWorked){
    //     this.empName = empName;
    //     this.empBasicSalary = empBasicSalary;
    //     this.empHra = empHra;
    //     this.empNetSalary = empNetSalary;
    //     this.noOfDaysWorked = noOfDaysWorked;
    // }

    public void setEmpName( String empName){
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

    public void setEmpHra(double empHra){
        this.empHra = empHra;
    }

    public double getEmpHra(){
        return empHra;
    }

    public void setEmpNetSalary(double empNetSalary){
        this.empNetSalary = empNetSalary;
    }

    public double getEmpNetSalary(){
        return empNetSalary;
    }

    public void setNoOfDaysWorked(int noOfDaysWorked){
        this.noOfDaysWorked = noOfDaysWorked;
    }

    public int getNoOfDaysWorked(){
        return noOfDaysWorked;
    }

    @Override
    public double calculateNetSalary(){

        empHra = empBasicSalary *0.12;
        empNetSalary = empBasicSalary + empHra;
        return empNetSalary;


    }
}
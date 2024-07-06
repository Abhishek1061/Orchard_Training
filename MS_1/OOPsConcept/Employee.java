import java.io.*;
import java.util.*;
import java.lang.Math;

public class Employee implements Comparable<Employee> {
    private int empId;
    private String empName;
    private double empBasicSalary;

    Employee(int empId, String empName, double empBasicSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empBasicSalary = empBasicSalary;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpBasicSalary(double empBasicSalary) {
        this.empBasicSalary = empBasicSalary;
    }

    public double getEmpBasicSalary() {
        return empBasicSalary;
    }

    public static void displaySortByName(ArrayList<Employee> arrList) {
        System.out.println("List sorted by name in descending order:");
        Collections.sort(arrList);
        Iterator<Employee> iterator  = arrList.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }   
        
    }

    public static void displaySortBySalary(ArrayList<Employee> arrList) {
        System.out.println("List sorted by salary in ascending order:");
        Collections.sort(arrList, new salaryComparator());
        Iterator<Employee> iterator = arrList.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }   

    }

    @Override
    public int compareTo(Employee arg) {
        
        return arg.getEmpName().compareTo(this.getEmpName());
        
    }

    @Override
    public String toString(){
        return "Employee [id=" + empId + ", name=" + empName + ", salary=" + empBasicSalary + "]";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Employee em = new Employee();
        ArrayList<Employee> arrList = new ArrayList<Employee>();
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int empId = scan.nextInt();
            String empName = scan.next();
            double empBasicSalary = scan.nextDouble();
            Employee emp = new Employee(empId, empName, empBasicSalary);
            arrList.add(emp);
        }

        // System.out.println("Original List:");
        // for(int i : arrList){
        //     System.out.println(i);
        // }
        // for(int i = 0; i< arrList.size(); i++){

        // }
        Iterator<Employee> iterator = arrList.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }   

        System.out.println();
        displaySortByName(arrList);
        System.out.println();
        displaySortBySalary(arrList);
        


    }

}

class salaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee arg1, Employee arg2) {

        Employee emp1 = (Employee) arg1;
        Employee emp2 = (Employee) arg2;

        if (emp1.getEmpBasicSalary() == emp2.getEmpBasicSalary()) {
            return 0;
        } else if (emp1.getEmpBasicSalary() > emp2.getEmpBasicSalary()) {
            return 1;
        } else {
            return -1;
        }

    }

}


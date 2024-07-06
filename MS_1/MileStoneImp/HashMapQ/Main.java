package Java.MileStoneImp.HashMapQ;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManagement emp = new EmployeeManagement();
        Employee employee;

        System.out.println("Enter the number of employe details to add: ");
        int n = sc.nextInt();
        for(int i = 0; i<n; i++){
            System.out.println("Enter employee id: ");
            int employeeID = sc.nextInt();
            System.out.println("Enter employee name: ");
            String name = sc.next();
            System.out.println("Enter the employe grade: ");
            String grade = sc.next();

            employee = new Employee(employeeID, name, grade);
            emp.addEmployee(employee);

        }
        System.out.println("****List sorted by employee name****");
        System.out.println(emp.getAllEmployeesSortedByName());

        System.out.println("Enter the employee id for getting the results: ");
        int id1 = sc.nextInt();
        System.out.println(emp.getEmployee(id1));
        System.out.println("Enter the employee id for removing the record: ");
        int id2 = sc.nextInt();
        System.out.println(emp.removeEmployee(id2));
        System.out.println(emp.getAllEmployeesSortedByName());

        
        
    }
    
}

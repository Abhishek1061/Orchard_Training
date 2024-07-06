package Java.MileStoneImp.HashMapQ;
import java.util.*;

public class EmployeeManagement {
    private Map<Integer, Employee> employeeMap;

    public EmployeeManagement() {
        //Write a missing code here
        employeeMap = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
         //Write a missing code here

         employeeMap.put(employee.getEmployeeId(), employee);
    }

    public Employee getEmployee(int employeeID) {
        //Write a missing code here

        return employeeMap.get(employeeID);
    }

    public List<Employee> getAllEmployeesSortedByName() {
         //Write a missing code here

         List<Employee> list = new ArrayList<>(employeeMap.values());
         Collections.sort(list);
         return list;

    }

    public boolean removeEmployee(int employeeID) {
        // Write a missing code here

        return employeeMap.remove(employeeID) != null;
    }

    
}
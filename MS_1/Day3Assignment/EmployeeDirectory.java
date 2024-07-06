
import java.util.HashSet;
import java.util.Set;

public class EmployeeDirectory<T> {
    private Set<Employee<T>> employees;

    public EmployeeDirectory() {
        employees = new HashSet<>();
    }

    public void addEmployee(Employee<T> employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee<T> employee) {
        employees.remove(employee);
    }

    public Set<Employee<T>> getAllEmployees() {
        return employees;
    }
    public static void main(String[] args) {
        // Example usage
        Employee<Integer> emp1 = new Employee<>(101, "John Doe", "Manager");
        Employee<Integer> emp2 = new Employee<>(102, "Jane Smith", "Developer");

        EmployeeDirectory<Integer> directory = new EmployeeDirectory<>();
        directory.addEmployee(emp1);
        directory.addEmployee(emp2);

        System.out.println("All employees:");
        directory.getAllEmployees().forEach(System.out::println);
    }
}
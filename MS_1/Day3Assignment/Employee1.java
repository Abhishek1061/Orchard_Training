
public class Employee1<T> {
    private T employeeID;
    private String name;
    private String role;

    public Employee1(T employeeID, String name, String role) {
        this.employeeID = employeeID;
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}



package Java.MileStoneImp.HashMapQ;

public class Employee implements Comparable<Employee>  {
    private int employeeId;
    private String employeeName;
    private String employeeGrade;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String employeeGrade) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeGrade = employeeGrade;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getEmployeeGrade() {
        return employeeGrade;
    }
    public void setEmployeeGrade(String employeeGrade) {
        this.employeeGrade = employeeGrade;
    }

    @Override
    public int compareTo(Employee o) {
       return this.employeeName.compareTo(o.employeeName);
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeGrade="
                + employeeGrade + "]";
    }

    


    
    
}

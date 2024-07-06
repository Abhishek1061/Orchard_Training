package Java.JDBC_CODE;

public class EmployeeBean {
    private int EmployeeId;
    
    private String name;
    private String Department;
    private Long Salary;
    private String EmailId;
    private Long PhoneNo;


    public int getEmployeeId() {
        return EmployeeId;
    }
    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String department) {
        Department = department;
    }
    public Long getSalary() {
        return Salary;
    }
    public void setSalary(Long salary) {
        Salary = salary;
    }
    public String getEmailId() {
        return EmailId;
    }
    public void setEmailId(String emailId) {
        EmailId = emailId;
    }
    public Long getPhoneNo() {
        return PhoneNo;
    }
    public void setPhoneNo(Long phoneNo) {
        PhoneNo = phoneNo;
    }    
}

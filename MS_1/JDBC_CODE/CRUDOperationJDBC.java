package Java.JDBC_CODE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDOperationJDBC {

    EmployeeBean eb = new EmployeeBean();
    Scanner sc = new Scanner(System.in);

    void getData() {

        System.out.print("Enter the number of records to enter:");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter your Name: ");
            eb.setName(sc.next());
            System.out.print("Enter your Department: ");
            eb.setDepartment(sc.next());
            System.out.print("Enter your Salary: ");
            eb.setSalary(sc.nextLong());
            System.out.print("Enter your Email Id: ");
            eb.setEmailId(sc.next());
            System.out.print("Enter your Phone Number: ");
            eb.setPhoneNo(sc.nextLong());
            // this.inserDetails();
        }
    }

    void inserDetails() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees", "root",
                    "root");

            PreparedStatement ps = connection.prepareStatement("insert into EmployeeDetails (Name,Department,Salary,EmailId,PhoneNo) values (?,?,?,?,?); ");

            ps.setString(1, eb.getName());
            ps.setString(2, eb.getDepartment());
            ps.setLong(3, eb.getSalary());
            ps.setString(4, eb.getEmailId());
            ps.setLong(5, eb.getPhoneNo());

            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("Data Inserted Successfully");
            } else {
                System.out.println("Error! Inserting Data");
            }

        } catch (ClassNotFoundException cntp) {
            System.out.println(cntp);
        } catch (SQLException sqle) {
            System.out.println(sqle);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void retriveData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees", "root",
                    "root");

            PreparedStatement ps = connection.prepareStatement("Select * from EmployeeDetails;");

            ResultSet resSet = ps.executeQuery();

            while (resSet.next()) {
                System.out.println("Employee Id: " + resSet.getInt("EmployeeId"));
                System.out.println("Employee Id: " + resSet.getString("Name"));
                System.out.println("Employee Id: " + resSet.getString("Department"));
                System.out.println("Employee Id: " + resSet.getLong("Salary"));
                System.out.println("Employee Id: " + resSet.getString("EmailId"));
                System.out.println("Employee Id: " + resSet.getLong("PhoneNo"));
                System.out.println("******Next Record Details********");
            }

        } catch (ClassNotFoundException cntp) {
            System.out.println(cntp);
        } catch (SQLException sqle) {
            System.out.println(sqle);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void updateData() {
        System.out.print("Enter the EmployeeId of the employee for Phone number updation: ");
        eb.setEmployeeId(sc.nextInt());
        System.out.print("Enter the new mobile number of the employee for Phone number updation: ");
        eb.setPhoneNo(sc.nextLong());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees", "root",
                    "root");

            PreparedStatement ps = connection
                    .prepareStatement("UPDATE EmployeeDetails SET PhoneNo = ? WHERE EmployeeId = ?");
            ps.setLong(0, eb.getPhoneNo());
            ps.setInt(1, eb.getEmployeeId());
            int res = ps.executeUpdate();

            if (res > 0) {
                System.out.println("Updated Successfully");
            } else {
                System.out.println("Updation Failed!");
            }

        } catch (ClassNotFoundException cntp) {
            System.out.println(cntp);
        } catch (SQLException sqle) {
            System.out.println(sqle);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void deleteData() {
        System.out.print("Enter the EmployeeId of the employee for deleting the records: ");
        eb.setEmployeeId(sc.nextInt());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees", "root","root");
            PreparedStatement ps = connection.prepareStatement("DELETE FROM EmployeeDetails WHERE EmployeeId = ?;");
            ps.setInt(1, eb.getEmployeeId());
            int res = ps.executeUpdate();

            if (res > 0) {
                System.out.println("Deleted Successfully");
            } else {
                System.out.println("Deletion Failed!");
            }

        } catch (ClassNotFoundException cntp) {
            System.out.println(cntp);
        } catch (SQLException sqle) {
            System.out.println(sqle);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // void random(){
    // System.out.println("Enter the choice: \n 1 - Insert \n 2 - Retrive \n 3 -
    // Update \n 4 - Delete");
    // int choice = sc.nextInt();
    // // switch(choice)

    // }

    public static void main(String[] args) {
        CRUDOperationJDBC obj = new CRUDOperationJDBC();
        System.out.println("Enter the choice: \n 1 - Insert \n 2 - Retrive \n 3 - Update \n 4 - Delete");
        Scanner sc  =new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                obj.getData();
                obj.inserDetails();
                break;
            case 2:
                obj.retriveData();
                break;
            case 3:
                obj.retriveData();
                obj.updateData();
                break;
            case 4:
                obj.retriveData();
                obj.deleteData();
                break;
            default:
                System.out.println("Number entered is out of range!");
                break;
        }

    }

}

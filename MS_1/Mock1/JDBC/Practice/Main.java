package Java.Mock1.JDBC.Practice;

import Java.JDBCDataBaseDAO.RecordNotFoundException;

public class Main {
    public static void main(String[] args) {
        Student studentDAO = new Student();

        // Create a new student record
        student student1 = new student();
        student1.setstudentName("John Doe");
        student1.setMedicalHistory("High Sugar");
        studentDAO.createstudent(student1);

        // Create another student record
        student student2 = new student();
        student2.setstudentName("Jane Doe");
        student2.setMedicalHistory("Low Sugar");
        studentDAO.createstudent(student2);

        try {
            // total number of students
            System.out.println("Total number of students: " + studentDAO.getAllstudents().size());

            // Get a student record by ID
            student student = studentDAO.getstudentByID(student1.getstudentID());
            System.out.println("student ID: " + student.getstudentID());
            System.out.println("student Name: " + student.getstudentName());
            System.out.println("Medical History: " + student.getMedicalHistory());

            // Update a student record
            student.setMedicalHistory("Normal Sugar");
            studentDAO.updatestudent(student);
            student updatedstudent = studentDAO.getstudentByID(student1.getstudentID());
            System.out.println("Updated Medical History: " + updatedstudent.getMedicalHistory());

            // Delete a student
            studentDAO.deletestudent(student1.getstudentID());
            System.out.println("Total number of students after deletion: " + studentDAO.getAllstudents().size());

        } catch (RecordNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // Clean up and close the database connection
        studentDAO.close();
    }
}

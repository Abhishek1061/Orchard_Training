package Java.Mock1.JDBC.Practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class StudentDAO {

    private Connection connection;

    public StudentDAO() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createStudent(Student student) {

        String str = "INSERT INTO Students (StudentName,  medicalHistory) values(?,?,?);";
        // create Student
        try (PreparedStatement statement = connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, student.getStudentName());
            statement.setString(2, student.getStudentClass());
            statement.setLong(3 , student.getStudentPercentage());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                student.setStudentId(generatedKeys.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {


        // return all Students
        List<Student> Student =  new ArrayList<>();
        Student Student2 = new Student();

        String str = "SELECT * FROM Students;";
        try(Statement statement = connection.createStatement()){
           ResultSet resSet =  statement.executeQuery(str);
           while(resSet.next()){

                // return mapToStudent(resSet);
                Student2.setStudentID(resSet.getInt("StudentID"));
                Student2.setStudentName(resSet.getString("StudentName"));
                Student2.setMedicalHistory(resSet.getString("medicalHistory"));
                Student.add(Student2);
                // Student.add(mapToStudent(resSet));

        
           }
        return Student;

            

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    
    }

    public Student getStudentByID(int StudentID) throws RecordNotFoundException {

        // return Student by ID
        String str = "SELECT * FROM Students WHERE StudentID = ? ;";
        try (PreparedStatement statement = connection.prepareStatement(str)) {

            statement.setInt(1, StudentID);
            ResultSet res = statement.executeQuery();

            if (res.next()) {
                // Student Student = new Student();
                // Student.setStudentID(r.getInt("StudentID"));
                // Student.setStudentName(r.getString("StudentName"));
                // Student.setMedicalHistory(r.getString("medicalHistory"));
                // return Student;
                return mapToStudent(res);

            } else {
                throw new RecordNotFoundException("Record not found!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student updateStudent(Student Student) throws RecordNotFoundException {

        String str = "UPDATE Students SET StudentName = ?, medicalHistory = ? WHERE StudentID =? ;";
        
        try(PreparedStatement statement = connection.prepareStatement(str)){
            statement.setString(1, Student.getStudentName());
            statement.setString(2, Student.getMedicalHistory());
            statement.setInt(3, Student.getStudentID());
            int update = statement.executeUpdate();

            if(update > 0){
                return Student;
            }
            else{
                throw new RecordNotFoundException("Record not found! : " + Student.getStudentID());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }

    public void deleteStudent(int StudentID) throws RecordNotFoundException {
        // delete Student by id

        String str = "DELETE FROM Students WHERE StudentID = ?;";
        // update Student record
        try(PreparedStatement statement = connection.prepareStatement(str)){
             statement.setInt(1, StudentID);
            int del =  statement.executeUpdate();
            
            if(del == 0){
                throw new RecordNotFoundException("Record Not found ");
            }
                
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student mapToStudent(ResultSet r) throws SQLException{
                Student Student = new Student();
                Student.setStudentID(r.getInt("StudentID"));
                Student.setStudentName(r.getString("StudentName"));
                Student.setMedicalHistory(r.getString("medicalHistory"));
                return Student;
        
    }
}

package Java.JDBCRecall;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientDAO {

    private Connection connection;
    Patient patient = new Patient();

    public PatientDAO() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPatientRecord(Patient patient) {
        String sql = "Insert into patients(patientName, medicalHistory) values(?,?);";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Patient patient = new Patient();
            statement.setString(1, patient.getPatientName());
            statement.setString(2, patient.getMedicalHistory());
            int res = statement.executeUpdate();
            if (res > 0) {
                System.out.println("Insertion Succesfull");
            } else {
                System.out.println("Insertion Failled!!");
            }
            ResultSet resSet = statement.getGeneratedKeys();
            if (resSet.next()) {
                patient.setPatientId(resSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Patient retirvPatientById(int patientId) throws RecordNotFoundException{

        String sql = "Select * from  patients where patientId = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, patientId);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){

                Patient patient = new Patient();
                patient.setPatientId(rs.getInt("patientId"));
                patient.setPatientName(rs.getString("patientName"));
                patient.setMedicalHistory(rs.getString("medicalHistory"));
                return patient;
                
            }else{
                throw new RecordNotFoundException("Record not present in the Database");
            }
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        return null;
        

    }

    // public Patient updateData() throws RecordNotFoundException{

    //     System.out.println("Eneter the patient id for updating madical history: ");
    //     patient.setPatientId(sc.nextInt);

    // }

    public void close(){
        try{ 
            if(connection != null) 
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}

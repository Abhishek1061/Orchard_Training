package Java.JDBCDataBaseDAO;

import java.sql.Connection;

import java.sql.*;

// import com.mysql.cj.xdevapi.PreparableStatement;

public class PatientDAO {
    private Connection connection;

    public PatientDAO() {
        try {
            connection = DataBaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createPatient(Patient patient) {
        // String sql = "INSERT INTO patients(patientName, medicalHistory) values(?,?)";
        // try (PreparedStatement statement = connection.prepareStatement(sql,
        // Statement.RETURN_GENERATED_KEYS)) {
        // statement.setString(1, patient.getPatientName());
        // statement.setString(2, patient.getMedicalHistory());
        // int res = statement.executeUpdate();
        // if (res > 0) {
        // System.out.println("Iserted Successfully");
        // } else {
        // System.out.println("Insertion failed");
        // }

        // ResultSet generetedKeys = statement.getGeneratedKeys();
        // if (generetedKeys.next()) {
        // patient.setPatientID(generetedKeys.getInt(1));
        // }

        // } catch (SQLException e) {
        // e.printStackTrace();
        // }
        // }

        String str = "INSERT INTO patients(patientName, madicalHistroy) values(?,?);";

        try (PreparedStatement statement = connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, patient.getPatientName());
            statement.setString(2, patient.getMedicalHistory());
            statement.executeUpdate();

            ResultSet resSet = statement.getGeneratedKeys();

            if (resSet.next()) {
                patient.setPatientID(resSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Patient getPatientByID(int patientID) throws RecordNotFoundException {
        // String sql = "SELECT * FROM patients WHERE patientID = ?;";

        // try (PreparedStatement statement = connection.prepareStatement(sql)) {
        //     statement.setInt(1, patientID);
        //     ResultSet rSet = statement.executeQuery();

        //     if (rSet.next()) {
        //         Patient patient = new Patient();
        //         patient.setPatientID(rSet.getInt("patientID"));
        //         patient.setPatientName(rSet.getString("patientName"));
        //         patient.setMedicalHistory(rSet.getString("medicalHistory"));
        //         return patient;
        //     } else {
        //         throw new RecordNotFoundException("Patient with ID" + patientID + "not in record");
        //     }

        String str = "Select * from patients where patientId = ?";

        try(PreparedStatement statement = connection.prepareStatement(str){

            statement.setInt(0, patientID);

            ResultSet res = statement.executeQuery();

            if(res.next()){
                
                Patient patient = new Patient();
                patient.setPatientID(res.getInt("patientId"));
                patient.setPatientName(res.getString("patientName"));
                patient.setMedicalHistory(res.getString("medicalHistory"));
                return patient;
            }
            else{
                throw new RecordNotFoundException("Record not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // return null;
        }
        return null;

    }

    // public Patient deletePatientByID(int patientID) throws RecordNotFoundException{
    //     String SQL = "Delete from patients where patientId = ?; ";

    //     try(PreparedStatement statement = connection.prepareStatement(SQL)){
    //     statement.setInt(1, patientID);;
    
    //     statement.executeUpdate();

        
    //     }Catch(SQLException e){
    //         e.printStackTrace();
    //     }
    // }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

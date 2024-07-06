import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatientDAO {

    private Connection connection;

    public PatientDAO() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPatient(Patient patient) {

        String str = "INSERT INTO patients (patientName,  medicalHistory) values(?,?);";
        // create patient
        try (PreparedStatement statement = connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, patient.getPatientName());
            statement.setString(2, patient.getMedicalHistory());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                patient.setPatientID(generatedKeys.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Patient> getAllPatients() {


        // return all patients
        List<Patient> patient =  new ArrayList<>();
        Patient patient2 = new Patient();

        String str = "SELECT * FROM patients;";
        try(Statement statement = connection.createStatement()){
           ResultSet resSet =  statement.executeQuery(str);
           while(resSet.next()){

                // return mapToPatient(resSet);
                patient2.setPatientID(resSet.getInt("patientID"));
                patient2.setPatientName(resSet.getString("patientName"));
                patient2.setMedicalHistory(resSet.getString("medicalHistory"));
                patient.add(patient2);
                // patient.add(mapToPatient(resSet));

        
           }
        return patient;

            

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    
    }

    public Patient getPatientByID(int patientID) throws RecordNotFoundException {

        // return patient by ID
        String str = "SELECT * FROM patients WHERE patientID = ? ;";
        try (PreparedStatement statement = connection.prepareStatement(str)) {

            statement.setInt(1, patientID);
            ResultSet res = statement.executeQuery();

            if (res.next()) {
                // Patient patient = new Patient();
                // patient.setPatientID(r.getInt("patientID"));
                // patient.setPatientName(r.getString("patientName"));
                // patient.setMedicalHistory(r.getString("medicalHistory"));
                // return patient;
                return mapToPatient(res);

            } else {
                throw new RecordNotFoundException("Record not found!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Patient updatePatient(Patient patient) throws RecordNotFoundException {

        String str = "UPDATE patients SET patientName = ?, medicalHistory = ? WHERE patientID =? ;";
        
        try(PreparedStatement statement = connection.prepareStatement(str)){
            statement.setString(1, patient.getPatientName());
            statement.setString(2, patient.getMedicalHistory());
            statement.setInt(3, patient.getPatientID());
            int update = statement.executeUpdate();

            if(update > 0){
                return patient;
            }
            else{
                throw new RecordNotFoundException("Record not found! : " + patient.getPatientID());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }

    public void deletePatient(int patientID) throws RecordNotFoundException {
        // delete patient by id

        String str = "DELETE FROM patients WHERE patientID = ?;";
        // update patient record
        try(PreparedStatement statement = connection.prepareStatement(str)){
             statement.setInt(1, patientID);
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

    public Patient mapToPatient(ResultSet r) throws SQLException{
                Patient patient = new Patient();
                patient.setPatientID(r.getInt("patientID"));
                patient.setPatientName(r.getString("patientName"));
                patient.setMedicalHistory(r.getString("medicalHistory"));
                return patient;
        
    }
}

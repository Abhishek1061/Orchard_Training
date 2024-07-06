package Java.JDBCRecall;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        PatientDAO patientDAO = new PatientDAO();

        // Create a new patient record
        Patient patient1 = new Patient();
        patient1.setPatientName("Parad Bhodekar");
        patient1.setMedicalHistory("High BP");
        patientDAO.createPatientRecord(patient1);

        try{

            Patient retrive = patientDAO.retirvPatientById(patient1.getPatientId());
            System.out.println("ID of patient: " + retrive.getPatientId());
            System.out.println("Name of patient: " + retrive.getPatientName());
            System.out.println("Medical Histroy of patient: " + retrive.getMedicalHistory());
        
        }catch(RecordNotFoundException e){
            System.out.println(e.getMessage());
        }

        patientDAO.close();
        
    }

   
    
}

package Java.Mock1.JDBC;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        PatientDAO patientDAO = new PatientDAO();

        // Create a new patient record
        Patient patient1 = new Patient();
        patient1.setPatientName("John Doe");
        patient1.setMedicalHistory("High Sugar");
        patientDAO.createPatient(patient1);

        // Create another patient record
        Patient patient2 = new Patient();
        patient2.setPatientName("Jane Doe");
        patient2.setMedicalHistory("Low Sugar");
        patientDAO.createPatient(patient2);

        try {
            // total number of patients
            System.out.println("Total number of patients: " + patientDAO.getAllPatients().size());

            // Get a patient record by ID
            Patient patient = patientDAO.getPatientByID(patient1.getPatientID());
            System.out.println("Patient ID: " + patient.getPatientID());
            System.out.println("Patient Name: " + patient.getPatientName());
            System.out.println("Medical History: " + patient.getMedicalHistory());

            // Update a patient record
            patient.setMedicalHistory("Normal Sugar");
            patientDAO.updatePatient(patient);
            Patient updatedPatient = patientDAO.getPatientByID(patient1.getPatientID());
            System.out.println("Updated Medical History: " + updatedPatient.getMedicalHistory());

            // Delete a patient
            patientDAO.deletePatient(patient1.getPatientID());
            System.out.println("Total number of patients after deletion: " + patientDAO.getAllPatients().size());

        } catch (RecordNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // Clean up and close the database connection
        patientDAO.close();
    }

    
}

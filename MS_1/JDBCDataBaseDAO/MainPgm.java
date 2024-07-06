package Java.JDBCDataBaseDAO;

public class MainPgm {

    public static void main(String[] args) {
        
        PatientDAO patientDAO = new PatientDAO();

        Patient patient1 = new Patient();

        patient1.setPatientName("Jhon ");
        patient1.setMedicalHistory("High Sugar");

        patientDAO.createPatient(patient1);

        try{
            Patient retiveredPatient = patientDAO.getPatientByID(patient1.getPatientID());
            System.out.println("Retrived Patient: " + retiveredPatient.getPatientName());
            System.out.println("Medical History: " + retiveredPatient.getMedicalHistory());

        }catch(RecordNotFoundException e){
            System.out.println(e.getMessage());
            
        }
        patientDAO.close();

    }

}

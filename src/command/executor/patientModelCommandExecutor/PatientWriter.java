package src.command.executor.patientModelCommandExecutor;

import src.command.executor.AbstractCommandExecutor;
import src.model.Patient;

public class PatientWriter extends AbstractCommandExecutor {

    public int execute(){
        return writeAllPatients();
    }

    private int writeAllPatients(){
        System.out.println("idPatient\tName\tCreation date\n");

        for (Patient patient : patientRepository.getAll()) {
            System.out.println(patient.getId()+"\t\t"
                    + patient.getName() + "\t\t"
                    + patient.getCreationDate());
        }
        return 1;
    }
}

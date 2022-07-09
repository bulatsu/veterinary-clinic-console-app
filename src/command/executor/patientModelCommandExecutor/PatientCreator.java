package src.command.executor.patientModelCommandExecutor;

import src.command.executor.AbstractCommandExecutor;
import src.model.Patient;


public class PatientCreator extends AbstractCommandExecutor {

    public int execute(String patientInfo) {

        if (patientInfo.isEmpty()) {
            System.out.println("Input is empty");
            return -1;
        }

        return createPatient(patientInfo);
    }

    private int createPatient(String patientName){
        var newPatient = new Patient(patientName);
        patientRepository.create(newPatient);
        System.out.println("Patient added!");

        return 1;
    }


}

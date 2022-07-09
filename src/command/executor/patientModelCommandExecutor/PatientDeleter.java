package src.command.executor.patientModelCommandExecutor;

import src.command.executor.AbstractCommandExecutor;

public class PatientDeleter extends AbstractCommandExecutor {

    public int execute(String idPatient) {

        if (idPatient.isEmpty()) {
            System.out.println("Patient id not entered.");
            return -1;
        }

        return deletePatient(idPatient);
    }

    private int deletePatient (String idPatient) {
        int id;

        try {
            id = Integer.parseInt(idPatient);

        } catch (NumberFormatException e){
            System.out.println("ID is of integer type!");
            return -1;
        }

        var patientToRemove = findPatient(id);

        if (patientToRemove.isPresent()) {
            patientRepository.remove(patientToRemove.get());

            System.out.println("Patient deleted");
        } else {
            System.out.println("Patient id not exist");
            return -1;
        }

        return 1;
    }
}

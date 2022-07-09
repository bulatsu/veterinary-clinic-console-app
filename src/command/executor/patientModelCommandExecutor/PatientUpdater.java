package src.command.executor.patientModelCommandExecutor;

import src.command.executor.AbstractCommandExecutor;

public class PatientUpdater extends AbstractCommandExecutor {

    public int execute(String patientInfo) {

        var parameters = patientInfo.split(" ", 2);

        if (parameters.length != 2) {
            System.out.println("Enter 2 parameters!");
            return -1;
        }

        return updatePatient(parameters);
    }

    private int updatePatient(String [] parameters){
        int idPatient;

        try {
            idPatient = Integer.parseInt(parameters[0]);

        } catch (NumberFormatException e){
            System.out.println("ID is entered first, integer type!");
            return -1;
        }

        var patientToUpdate = findPatient(idPatient);

        if (patientToUpdate.isPresent()) {
            var index = patientRepository.getAll().indexOf(patientToUpdate.get());

            patientToUpdate.get().setName(parameters[1]);
            patientRepository.edit(index, patientToUpdate.get());

            System.out.println("Patient information changed!");
        } else {
            System.out.println("Patient id not exist");
            return -1;
        }

        return 1;
    }


}

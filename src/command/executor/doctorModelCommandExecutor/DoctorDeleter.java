package src.command.executor.doctorModelCommandExecutor;

import src.command.executor.AbstractCommandExecutor;

public class DoctorDeleter extends AbstractCommandExecutor {

    public int execute(String idDoctor) {

        if (idDoctor.isEmpty()) {
            System.out.println("Doctor id not entered.");
            return -1;
        }

        return deleteDoctor(idDoctor);
    }

    private int deleteDoctor (String idDoctor) {
        int id;

        try {
            id = Integer.parseInt(idDoctor);

        } catch (NumberFormatException e){
            System.out.println("ID is of integer type!");
            return -1;
        }

        var doctorToRemove = findDoctor(id);

        if (doctorToRemove.isPresent()) {
            doctorRepository.remove(doctorToRemove.get());

            System.out.println("Doctor deleted");
        } else {
            System.out.println("Doctor id not exist");
            return -1;
        }

        return 1;
    }
}

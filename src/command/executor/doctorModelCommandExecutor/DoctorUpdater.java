package src.command.executor.doctorModelCommandExecutor;

import src.command.executor.AbstractCommandExecutor;

public class DoctorUpdater extends AbstractCommandExecutor {

    public int execute(String doctorUpdInfo) {
        var parameters = doctorUpdInfo.split(" ", 5);

        if (parameters.length != 5) {
            System.out.println("Enter 5 parameters! -n counts");
            return -1;
        }

        return updateDoctor(parameters);
    }

    private int updateDoctor(String[] parameters){
        int idDoctor;

        try {
            idDoctor = Integer.parseInt(parameters[0]);

        } catch (NumberFormatException e){
            System.out.println("ID is entered first, integer type!");
            return -1;
        }

        var doctorToUpdate = findDoctor(idDoctor);

        if (doctorToUpdate.isEmpty()) {
            System.out.println("Doctor not exist");
            return -1;
        }

        if (!parameters[1].contains("-n")){
            doctorToUpdate.get().setSurname(parameters[1]);
        }

        if (!parameters[2].contains("-n")) {
            doctorToUpdate.get().setName(parameters[2]);
        }

        if (!parameters[3].contains("-n")){
            doctorToUpdate.get().setPatronymic(parameters[3]);
        }

        if (!parameters[4].contains("-n")){
            doctorToUpdate.get().setSpecialization(parameters[4]);
        }

        var index = doctorRepository.getAll().indexOf(doctorToUpdate.get());
        doctorRepository.edit(index, doctorToUpdate.get());
        System.out.println("Doctor information changed!");

        return 1;
    }

}



package src.command.executor.doctorModelCommandExecutor;

import src.command.executor.AbstractCommandExecutor;
import src.model.Doctor;

public class DoctorCreator extends AbstractCommandExecutor {

    public int execute(String doctorInfo) {
        var parameters = doctorInfo.split(" ", 4);

        if (parameters.length != 4) {
            System.out.println("Enter 4 parameters!");
            return -1;
        }

        return createDoctor(parameters);
    }

    private int createDoctor(String[] parameters) {
        var surname = parameters[0];
        var name = parameters[1];
        var patronymic = parameters[2];
        var specialization = parameters[3];

        var newDoctor = new Doctor(surname, name, patronymic, specialization);
        doctorRepository.create(newDoctor);

        System.out.println("Doctor added!");

        return 1;
    }
}

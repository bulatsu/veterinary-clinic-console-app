package src.command.executor.doctorModelCommandExecutor;

import src.command.executor.AbstractCommandExecutor;
import src.model.Doctor;

public class DoctorWriter extends AbstractCommandExecutor {

    public int execute(){
        return writeAllDoctors();
    }

    private int writeAllDoctors(){
        System.out.println("idDoctor\tSurname\tName\tPatronymic\tSpecialization\n");

        for (Doctor doctor : doctorRepository.getAll()) {
            System.out.println(doctor.getId()+"\t\t"
                    + doctor.getSurname() + "\t\t"
                    + doctor.getName() + "\t\t"
                    + doctor.getPatronymic() + "\t\t"
                    + doctor.getSpecialization());
        }
        return 1;
    }
}

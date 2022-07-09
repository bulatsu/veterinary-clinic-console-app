package src.command.executor.appointmentModelCommandExecutor;

import src.command.executor.AbstractCommandExecutor;
import src.model.Appointment;

public class AppointmentWriter extends AbstractCommandExecutor {

    public int execute() {
        return writeAllAppointments();
    }

    public int execute(String idPatient) {

        if (idPatient.isEmpty()) {
            System.out.println("Appointment id not entered");
            return -1;
        }
        return writePatientAppointments(idPatient);
    }

    private int writeAllAppointments(){
        System.out.println("id\tidPatient\tidDoctor\tAppointment date\tAppointment time\tStatus\n");

        for (Appointment appointment : appointmentRepository.getAll()) {
            System.out.println(appointment.getId()+"\t\t"
                    + appointment.getIdPatient() + "\t\t"
                    + appointment.getIdDoctor() + "\t\t"
                    + appointment.getAppointmentDate() + "\t\t"
                    + appointment.getAppointmentTime() + "\t\t"
                    + appointment.getCurrentStatus() + "\t\t");
        }
        return 1;
    }

    private int writePatientAppointments(String idPatient) {
        int id;

        try {
            id = Integer.parseInt(idPatient);

        } catch (NumberFormatException e){
            System.out.println("ID is of integer type!");
            return -1;
        }

        System.out.println("id\tidPatient\tidDoctor\tAppointment date\tAppointment time\tStatus\n");

        for (Appointment appointment : appointmentRepository.getAll()) {
            if (appointment.getIdPatient() == id){
                System.out.println(appointment.getId()+"\t\t"
                        + appointment.getIdPatient() + "\t\t"
                        + appointment.getIdDoctor() + "\t\t"
                        + appointment.getAppointmentDate() + "\t\t"
                        + appointment.getAppointmentTime() + "\t\t"
                        + appointment.getCurrentStatus() + "\t\t");
            }
        }
        return 1;
    }
}

package src.command.executor.appointmentModelCommandExecutor;

import src.command.executor.AbstractCommandExecutor;

public class AppointmentDeleter extends AbstractCommandExecutor {

    public int execute(String idAppointment) {

        if (idAppointment.isEmpty()) {
            System.out.println("Appointment id not entered.");
            return -1;
        }

        return deleteAppointment(idAppointment);
    }

    private int deleteAppointment (String idAppointment) {
        int id;

        try {
            id = Integer.parseInt(idAppointment);

        } catch (NumberFormatException e){
            System.out.println("ID is of integer type!");
            return -1;
        }

        var appointmentToRemove = findAppointment(id);

        if (appointmentToRemove.isPresent()) {
            appointmentRepository.remove(appointmentToRemove.get());

            System.out.println("Appointment deleted");
        } else {
            System.out.println("Appointment id not exist");
            return -1;
        }

        return 1;
    }
}

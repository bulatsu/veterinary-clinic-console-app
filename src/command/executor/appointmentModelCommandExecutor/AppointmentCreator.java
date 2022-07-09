package src.command.executor.appointmentModelCommandExecutor;

import src.command.executor.AbstractCommandExecutor;
import src.model.Appointment;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppointmentCreator extends AbstractCommandExecutor {

    public int execute(String appointmentInfo) {
        var parameters = appointmentInfo.split(" ", 4);

        if (parameters.length != 4) {
            System.out.println("Enter 4 parameters!");
            return -1;
        }

        return createAppointment(parameters);
    }

    private int createAppointment(String[] parameters) {

        int idPatient;
        int idDoctor;
        LocalDate date;
        LocalTime time;

        try {
            idPatient = Integer.parseInt(parameters[0]);
            idDoctor = Integer.parseInt(parameters[1]);
            date = LocalDate.parse(parameters[2]);

            DateTimeFormatter formatForTime = DateTimeFormatter.ofPattern("HH:mm");
            time = LocalTime.parse(parameters[3], formatForTime);

        } catch (NumberFormatException e){
            System.out.println("ID is of integer type!");
            return -1;
        } catch (DateTimeException e){
            System.out.println("Date or time format is incorrect");
            return -1;
        }

        var patient = findPatient(idPatient);
        var doctor = findDoctor(idDoctor);

        if (patient.isEmpty()) {
            System.out.println("Patient id not exist");
            return -1;
        }

        if (doctor.isEmpty()) {
            System.out.println("Doctor id not exist");
            return -1;
        }

        if (isBusy(idDoctor, date, time)){
            System.out.println("Date and time of appointment with this doctor is busy");
            return -1;
        }

        var newAppointment = new Appointment(patient.get().getId(), doctor.get().getId(), date, time);
        appointmentRepository.create(newAppointment);
        System.out.println("Appointment added!");

        return 1;
    }

    private boolean isBusy(int idDoctor, LocalDate date, LocalTime time) {

        for (Appointment appointment : appointmentRepository.getAll()) {
            if (appointment.getIdDoctor() == idDoctor && appointment.getAppointmentDate().isEqual(date)
                    && appointment.getAppointmentTime().compareTo(time) == 0) {
                return true;
            }
        }

        return false;
    }
}

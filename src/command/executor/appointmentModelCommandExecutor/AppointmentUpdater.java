package src.command.executor.appointmentModelCommandExecutor;

import src.command.executor.AbstractCommandExecutor;
import src.model.Appointment;
import src.model.AppointmentStatus;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppointmentUpdater extends AbstractCommandExecutor {

    public int execute(String appointmentUpdInfo) {
        var parameters = appointmentUpdInfo.split(" ", 6);

        if (parameters.length != 6) {
            System.out.println("Enter 6 parameters! -n counts");
            return -1;
        }

        return updateAppointment(parameters);
    }

    public int executeStatusUpdating(String status) {
        int idAppointment;
        var parameters = status.split(" ", 2);

        if (parameters.length != 2) {
            System.out.println("Enter 2 parameters: Appointment ID and status!");
            return -1;
        }

        try {
            idAppointment = Integer.parseInt(parameters[0]);
        } catch (NumberFormatException e) {
            System.out.println("ID is of integer type!");
            return -1;
        }

        var appointmentToUpdateStatus = findAppointment(idAppointment);

        if (appointmentToUpdateStatus.isEmpty()) {
            System.out.println("Appointment not exist");
            return -1;
        }

        return updateAppointmentStatus(appointmentToUpdateStatus.get(), parameters[1]);
    }

    private int updateAppointmentStatus(Appointment appointmentToUpdateStatus, String status) {

        if (status.contains("new")) {
            appointmentToUpdateStatus.setCurrentStatus(AppointmentStatus.NEW);
            return 1;
        }

        if (status.contains("in process")) {
            appointmentToUpdateStatus.setCurrentStatus(AppointmentStatus.IN_PROCESS);
            return 1;
        }

        if (status.contains("canceled")) {
            appointmentToUpdateStatus.setCurrentStatus(AppointmentStatus.CANCELED);
            return 1;
        }

        if (status.contains("awaiting payment")) {
            appointmentToUpdateStatus.setCurrentStatus(AppointmentStatus.AWAITING_PAYMENT);
            return 1;
        }

        if (status.contains("completed")) {
            appointmentToUpdateStatus.setCurrentStatus(AppointmentStatus.COMPLETED);
            return 1;
        }

        System.out.println("Status not found");
        return -1;
    }

    private int updateAppointment(String[] parameters) {
        int id;
        int idPatient = -1;
        int idDoctor = -1;
        LocalDate date = null;
        LocalTime time = null;

        try {
            id = Integer.parseInt(parameters[0]);

            if (!parameters[1].contains("-n") ) {
                idPatient = Integer.parseInt(parameters[1]);
            }

            if (!parameters[2].contains("-n") ) {
                idDoctor = Integer.parseInt(parameters[2]);
            }

            if (!parameters[3].contains("-n") ) {
                date = LocalDate.parse(parameters[3]);
            }

            if (!parameters[4].contains("-n") ) {
                DateTimeFormatter formatForTime = DateTimeFormatter.ofPattern("HH:mm");
                time = LocalTime.parse(parameters[4], formatForTime);
            }

        } catch (NumberFormatException e){
            System.out.println("ID is of integer type!");
            return -1;
        } catch (DateTimeException e){
            System.out.println("Date or time format is incorrect");
            return -1;
        }

        var appointmentToUpdate = findAppointment(id);

        if (appointmentToUpdate.isEmpty()) {
            System.out.println("Appointment not exist");
            return -1;
        }

        if (idPatient != -1) {
            if (findPatient(idPatient).isEmpty()) {
                System.out.println("Appointment not exist");
                return -1;
            }
            appointmentToUpdate.get().setIdPatient(idPatient);
        }

        if (idDoctor != -1) {
            if (findPatient(idDoctor).isEmpty()) {
                System.out.println("Appointment not exist");
                return -1;
            }
            appointmentToUpdate.get().setIdDoctor(idDoctor);
        }

        if (date != null) {
            appointmentToUpdate.get().setAppointmentDate(date);
        }

        if (time != null) {
            appointmentToUpdate.get().setAppointmentTime(time);
        }

        if (!parameters[5].contains("-n")) {
            updateAppointmentStatus(appointmentToUpdate.get(), parameters[5]);
        }

        if (isBusy(appointmentToUpdate.get().getIdDoctor(),
                appointmentToUpdate.get().getAppointmentDate(),
                appointmentToUpdate.get().getAppointmentTime())) {

            System.out.println("Date and time of appointmentToUpdate with this doctor is busy");
            return -1;
        }

        var index = appointmentRepository.getAll().indexOf(appointmentToUpdate.get());
        appointmentRepository.edit(index, appointmentToUpdate.get());
        System.out.println("Appointment information changed!");

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

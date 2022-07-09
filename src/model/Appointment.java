package src.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private static int largestID = 0;
    private final int id;
    private int idPatient;
    private int idDoctor;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private AppointmentStatus currentStatus;

    public Appointment(int idPatient, int idDoctor, LocalDate appointmentDate, LocalTime appointmentTime) {
        this.id = largestID++;
        this.idPatient = idPatient;
        this.idDoctor = idDoctor;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.currentStatus = AppointmentStatus.NEW;
    }

    public int getId() {
        return id;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public AppointmentStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(AppointmentStatus currentStatus) {
        this.currentStatus = currentStatus;
    }
}
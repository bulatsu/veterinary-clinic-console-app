package src.repository;

import src.model.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository implements GenericRepository<Appointment> {

    private static final List<Appointment> APPOINTMENTS = new ArrayList<>();

    private static final AppointmentRepository SINGLETON = new AppointmentRepository();

    private AppointmentRepository() {}

    public static AppointmentRepository getSingleton(){
        return SINGLETON;
    }

    @Override
    public List<Appointment> getAll() {
        return APPOINTMENTS;
    }

    @Override
    public void create(Appointment appointment) {
        APPOINTMENTS.add(appointment);
    }

    @Override
    public void edit(int index, Appointment appointment) {
        APPOINTMENTS.set(index, appointment);
    }

    @Override
    public void remove(Appointment appointment) {
        APPOINTMENTS.remove(appointment);
    }
}

package src.repository;

import src.model.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepository implements GenericRepository<Doctor> {

    private static final List<Doctor> DOCTORS = new ArrayList<>();

    private static final DoctorRepository SINGLETON = new DoctorRepository();

    private DoctorRepository() {}

    public static DoctorRepository getSingleton(){
        return SINGLETON;
    }

    @Override
    public List<Doctor> getAll() {
        return DOCTORS;
    }

    @Override
    public void create(Doctor doctor) {
        DOCTORS.add(doctor);
    }

    @Override
    public void edit(int index, Doctor doctor) {
        DOCTORS.set(index, doctor);
    }

    @Override
    public void remove(Doctor doctor) {
        DOCTORS.remove(doctor);
    }
}

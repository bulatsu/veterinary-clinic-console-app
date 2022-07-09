package src.repository;

import src.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientRepository implements GenericRepository<Patient> {

    private static final List<Patient> PATIENTS = new ArrayList<>();

    private static final PatientRepository SINGLETON = new PatientRepository();

    private PatientRepository() {}

    public static PatientRepository getSingleton(){
        return SINGLETON;
    }

    @Override
    public List<Patient> getAll() {
        return PATIENTS;
    }

    @Override
    public void create(Patient patient) {
        PATIENTS.add(patient);
    }

    @Override
    public void edit(int index, Patient patient) {
        PATIENTS.set(index, patient);
    }

    @Override
    public void remove(Patient patient) {
        PATIENTS.remove(patient);
    }
}

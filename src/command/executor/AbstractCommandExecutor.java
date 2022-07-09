package src.command.executor;

import src.model.Appointment;
import src.model.Doctor;
import src.model.Patient;
import src.repository.AppointmentRepository;
import src.repository.DoctorRepository;
import src.repository.PatientRepository;

import java.util.Optional;

public abstract class AbstractCommandExecutor {

    protected final PatientRepository patientRepository = PatientRepository.getSingleton();
    protected final DoctorRepository doctorRepository = DoctorRepository.getSingleton();
    protected final AppointmentRepository appointmentRepository = AppointmentRepository.getSingleton();

    protected Optional<Patient> findPatient(int id) {
        for (Patient patient : patientRepository.getAll()) {
            if (patient.getId() == id) {
                return Optional.of(patient);
            }
        }
        return Optional.empty();
    }

    protected Optional<Doctor> findDoctor(int id) {
        for (Doctor doctor : doctorRepository.getAll()) {
            if (doctor.getId() == id) {
                return Optional.of(doctor);
            }
        }
        return Optional.empty();
    }

    protected Optional<Appointment> findAppointment(int id) {
        for (Appointment appointment : appointmentRepository.getAll()) {
            if (appointment.getId() == id) {
                return Optional.of(appointment);
            }
        }
        return Optional.empty();
    }
}

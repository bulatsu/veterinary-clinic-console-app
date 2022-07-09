package src.command;

import src.command.executor.appointmentModelCommandExecutor.AppointmentCreator;
import src.command.executor.appointmentModelCommandExecutor.AppointmentDeleter;
import src.command.executor.appointmentModelCommandExecutor.AppointmentUpdater;
import src.command.executor.appointmentModelCommandExecutor.AppointmentWriter;
import src.command.executor.doctorModelCommandExecutor.DoctorCreator;
import src.command.executor.doctorModelCommandExecutor.DoctorDeleter;
import src.command.executor.doctorModelCommandExecutor.DoctorUpdater;
import src.command.executor.doctorModelCommandExecutor.DoctorWriter;
import src.command.executor.patientModelCommandExecutor.PatientCreator;
import src.command.executor.patientModelCommandExecutor.PatientDeleter;
import src.command.executor.patientModelCommandExecutor.PatientUpdater;
import src.command.executor.patientModelCommandExecutor.PatientWriter;

import java.util.Scanner;

public class CommandReader {

    public static void startReadCommand() {
        Scanner s = new Scanner(System.in);

        int i = 1;
        while (i != 0) {
            i = readCommand(s);
        }

        s.close();
    }

    private static int readCommand(Scanner s) {

        System.out.println("\nEnter command:");
        var commandString = s.nextLine();

        switch (commandString) {

            case ("add patient"):

                System.out.println("Enter NAME:");
                var patientInfo = s.nextLine();
                return new PatientCreator().execute(patientInfo);

            case ("add doctor"):

                System.out.println("Enter SURNAME NAME PATRONYMIC SPECIALIZATION separated by a space:");
                var doctorInfo = s.nextLine();
                return new DoctorCreator().execute(doctorInfo);

            case ("add appointment"):

                System.out.println("Enter ID_PATIENT ID_DOCTOR DATE(yyyy-mm-dd) TIME(HH:mm) separated by a space:");
                var appointmentInfo = s.nextLine();
                return new AppointmentCreator().execute(appointmentInfo);

            case ("display all patients"):

                return new PatientWriter().execute();

            case ("display all doctors"):

                return new DoctorWriter().execute();

            case ("display all appointments"):

                return new AppointmentWriter().execute();

            case ("display patient appointments"):

                System.out.println("Enter patient ID:");
                var idPatient = s.nextLine();
                return new AppointmentWriter().execute(idPatient);

            case ("update patient"):

                System.out.println("Enter patient ID and new NAME separated by a space:");
                var patientUpdInfo = s.nextLine();
                return new PatientUpdater().execute(patientUpdInfo);

            case ("update appointment status"):

                System.out.println("Enter appointment ID and STATUS to update separated by a space:");
                var appointmentStatus = s.nextLine();
                return new AppointmentUpdater().executeStatusUpdating(appointmentStatus);

            case ("update appointment"):

                System.out.println("""
                        Enter the appointment ID and updated info: ID_PATIENT ID_DOCTOR DATE TIME STATUS
                        separated by a space.
                        Write "-n" in the parameter that doesn't require updating!
                        Example: 1 -n -n 2022-08-01 12:00 -n
                        """);

                var appointmentUpdInfo = s.nextLine();
                return new AppointmentUpdater().execute(appointmentUpdInfo);

            case ("update doctor"):

                System.out.println("""
                        Enter the doctor ID and updated info: SURNAME NAME PATRONYMIC SPECIALIZATION
                        separated by a space.
                        Write "-n" in the parameter that doesn't require updating!
                        Example: 1 Ivanov -n Ivanovich -n
                        """);

                var doctorUpdInfo = s.nextLine();
                return new DoctorUpdater().execute(doctorUpdInfo);

            case ("delete patient"):

                System.out.println("Enter patient ID:");
                var patientID = s.nextLine();
                return new PatientDeleter().execute(patientID);

            case ("delete appointment"):

                System.out.println("Enter appointment ID:");
                var idAppointment = s.nextLine();
                return new AppointmentDeleter().execute(idAppointment);

            case ("delete doctor"):

                System.out.println("Enter doctor ID:");
                var idDoctor = s.nextLine();
                return new DoctorDeleter().execute(idDoctor);

            case ("exit"):
                return 0;
            default:
                System.out.println("No such command. \n");
                return 1;
        }
    }
}

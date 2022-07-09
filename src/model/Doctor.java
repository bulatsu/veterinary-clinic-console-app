package src.model;

public class Doctor {

    private static int largestID = 0;
    private final int id;
    private String surname;
    private String name;
    private String patronymic;
    private String specialization;

    public Doctor(String surname, String name, String patronymic, String specialization) {
        this.id = largestID++;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

}

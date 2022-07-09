package src.model;

import java.time.LocalDate;

public class Patient {

    private static int largestID = 0;
    private final int id;
    private String name;
    private final LocalDate creationDate;

    public Patient(String name) {
        this.id = largestID++;
        this.name = name;
        creationDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }


}

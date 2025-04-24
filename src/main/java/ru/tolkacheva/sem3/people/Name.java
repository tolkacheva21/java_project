package ru.tolkacheva.sem3.people;

public class Name {
    private String surname;
    private  final String name;
    private String fatherName;

    public Name(String surname, String name, String fatherName) {
        if (name.isEmpty() || surname.isEmpty() || fatherName.isEmpty())
            throw new IllegalArgumentException("name, surname and father name must be not null");
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
    }

    public void setSurname(String surname) {
        if (surname.isEmpty()) throw new IllegalArgumentException("surname must be not null");
        this.surname = surname;
    }

    public void setFatherName(String fatherName) {
        if (fatherName.isEmpty()) throw new IllegalArgumentException("father name must be not null");
        this.fatherName = fatherName;
    }

    public String getSurname() {
        return surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getName() {
        return name;
    }

    public Name(String name, String surname) {
        this(surname, name, null);
    }

    public Name(String name) {
        this(null, name, null);
    }

    public String toString(){
        if (name == null && fatherName == null) return surname;
        else if (surname == null && fatherName == null) return name;
        else if (fatherName == null) return surname + " " + name;
        else if (name == null) return surname + " " + fatherName;
        else if (surname == null) return name + " " + fatherName;
        return surname + " " + name + " " + fatherName;
    }
}

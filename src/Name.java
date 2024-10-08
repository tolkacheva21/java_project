public class Name {
    String surname;
    String name;
    String fatherName;

    public Name(String surname, String name, String fatherName) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
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

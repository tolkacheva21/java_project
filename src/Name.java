public class Name {
    String surname;
    String name;
    String fatherName;

    public Name(String surname, String name, String fatherName) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
    }

    public String toString(){
        if (name == null && fatherName == null) return surname;
        else if (fatherName == null) return surname + " " + name;
        return surname + " " + name + " " + fatherName;
    }
}

public class NameConstructor {
    String surname;
    String name;
    String fatherName;

    public NameConstructor setName(String name){
        this.name = name;
        return this;
    }

    public NameConstructor setSurname(String surname){
        this.surname = surname;
        return this;
    }

    public NameConstructor setFatherName(String fatherName){
        this.fatherName = fatherName;
        return this;
    }

    public Name create(){
        return new Name(surname, name, fatherName);
    }
}

public class Human {
    Name name;
    int height;
    Human father;

    public Human(Name name, int height, Human father) {
        this.name = name;
        this.height = height;
        this.father = father;
    }

    public String toString(){
        if (father != null && name.surname == null && name.fatherName != null) {
            return father.name.surname + name + " height: " + height;
        }
        else if (father != null && name.fatherName == null && father.name.name != null && name.surname == null){
            return father.name.surname + name + " " + father.name.name + "ovich" + " height: " + height;
        }
        if (father != null && name.fatherName == null && father.name.name != null){
            return name + " " + father.name.name + "ovich" + " height: " + height;
        }
        return name + " height: " + height;
    }
}

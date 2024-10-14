public class Human {
    private Name name;
    private int height;
    private final Human father;
    private String personalName;

    public Human(Name name, int height, Human father) {
        if (height < 24 || height > 500) throw new IllegalArgumentException("height must be adequate");
        this.name = name;
        this.height = height;
        this.father = father;
    }

    public void setHeight(int height) {
        if (height < 24 || height > 500) throw new IllegalArgumentException("height must be adequate");
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public Human getFather() {
        return new Human(father.name, father.height, father.father);
    }

    public Name getName() {
        return name;
    }

    public String getPersonalName() {
        return personalName;
    }

    public Human(String personalName, int height, Human father) {
        if (height < 24 || height > 500) throw new IllegalArgumentException("height must be adequate");
        this.personalName = personalName;
        this.height = height;
        this.father = father;
    }

    public Human(String personalName, int height) {
        this(personalName, height, null);
    }

    public Human(Name name, int height) {
        this(name, height, null);
    }

    public String toString(){
        if (father != null && name.getSurname() == null && name.getFatherName() != null) {
            return father.name.getSurname() + name + " height: " + height;
        }
        else if (father != null && name.getFatherName() == null
                && father.name.getName() != null
                && name.getSurname() == null){
            return father.name.getSurname() + name + " " + father.name.getName() + "ovich" + " height: " + height;
        }
        if (father != null && name.getFatherName() == null && father.name.getName() != null){
            return name + " " + father.name.getName() + "ovich" + " height: " + height;
        }
        return name + " height: " + height;
    }
}

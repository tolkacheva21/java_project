public class Department {
    public String name;
    public Worker boss;

    public Department(String name) {
        this.name = name;
    }

    public String toString(){
        String res = "department " + name;
        if (boss == null){
            return res + " without boss";
        }
        return res + " boss is " + boss.name;
    }
}

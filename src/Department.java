import java.util.Arrays;

public class Department {
    public String name;
    public Worker boss;
    public Worker[] workers;

    public Department(String name, Worker[] workers) {
        this.name = name;
        this.workers = workers;
    }

    public String toString(){
        String res = "department " + name + " with workers " + Arrays.toString(workers);
        if (boss == null){
            return res + " without boss";
        }
        return res + " boss is " + boss.name;
    }
}

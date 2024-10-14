import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Department {
    private String name;
    private Worker boss;
    private List<Worker> workers;

    public Department(String name, List<Worker> workers) {
        this.name = name;
        this.workers = workers;
    }

    public String getName() {
        return name;
    }

    public Worker getBoss() {
        return new Worker(boss.getName(), boss.getDepartment());
    }

    public List<Worker> getWorkers() {
        return new ArrayList<>(workers);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoss(Worker boss) {
        this.boss = new Worker(boss.getName(), boss.getDepartment());
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = new ArrayList<>(workers);
    }

    public String toString(){
        String res = "department " + name + " with workers " + workers;
        if (boss == null){
            return res + " without boss";
        }
        return res + " boss is " + boss.getName();
    }
}

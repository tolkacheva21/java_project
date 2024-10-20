import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private Worker boss;
    private List<Worker> workerList = new ArrayList<>();

    public Department(String name){
        this.name = name;
    }


    public void setBoss(Worker worker){
        if (!workerList.contains(worker)) throw new IllegalArgumentException("Person isn't worker of Department");
        this.boss = worker;
    }

    public void removeWorker(Worker worker){
        if (worker == null) return;
        if (!this.workerList.contains(worker)) return;
        if (boss == worker) boss = null;
        worker.setDepartment(null);
        workerList.remove(worker);
    }

    public void addWorker(Worker worker){
        if (worker == null) return;
        if (workerList.contains(worker) && worker.getDepartment() == this) return;
        if (worker.getDepartment() != this) {
            worker.setDepartment(this);
        }
        if (!this.workerList.contains(worker)) {
            workerList.add(worker);
        }
    }

    public String getInfoAbout(Worker worker) {
        if (workerList.contains(worker)) {
            if (boss == this.boss) {
                return worker.getName() + " is boss of " + this.name;
            }
            if (boss != null) {
                return worker.getName() + " work in " + this.name + " his boss is " + boss.getName();
            }
            return worker.getName() + " work in " + this.name;
        }
        return worker.getName() + "doesn't work in this department";
    }

    public List<Worker> getWorkerList() {
        return new ArrayList<>(workerList);
    }

    public String getInfoAboutWorkers(){
        String res = "Workers of " + name + " department:\n";
        for (Worker worker : workerList){
            res += worker.getName() + "\n";
        }
        return res;
    }

    public String toString(){ return "Department of " + name;}
}

package ru.tolkacheva.sem3.office;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    Worker boss;
    List<Worker> workerList = new ArrayList<>();

    public Department(String name){
        this.name = name;
    }


    public void setBoss(Worker boss){
        if (this.boss == boss) return;
        addWorker(boss);
        this.boss = boss;
    }

    public void removeWorker(Worker worker){
        if (worker == null) return;
        worker.setDepartment(null);
    }

    public void addWorker(Worker worker){
        if (worker == null) return;
        worker.setDepartment(this);
    }

    public String getInfoAbout(Worker worker) {
        if (workerList.contains(worker)) {
            if (boss == this.boss) {
                return worker.name + " is boss of " + this.name;
            }
            if (boss != null) {
                return worker.name + " work in " + this.name + " his boss is " + boss.name;
            }
            return worker.name + " work in " + this.name;
        }
        return worker.name + "doesn't work in this department";
    }

    public List<Worker> getWorkerList() {
        return new ArrayList<>(workerList);
    }

    public String getInfoAboutWorkers(){
        String res = "Workers of " + name + " department:\n";
        for (Worker worker : workerList){
            res += worker.name + "\n";
        }
        return res;
    }

    public String toString(){ return "Department of " + name;}
}

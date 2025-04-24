package ru.tolkacheva.sem3.office;

public class Worker {
    String name;
    Department department;

    public Worker(String name){
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        if (department == this.department) return;
        if (this.department != null) {
            if (this.department.boss == this)  this.department.boss = null;
            this.department.workerList.remove(this);
        }
        this.department = department;
        if (department != null) department.workerList.add(this);
    }

    public Department getDepartment() { return department; }

    public String getName(){
        return name;
    }

    public String toString(){
        return department.getInfoAbout(this);
    }
}

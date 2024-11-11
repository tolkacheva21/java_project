package ru.tolkacheva.office;

public class Worker {
    private String name;
    Department department;

    public Worker(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDepartment(Department department) {
        if (this.department == department) return;
        if (this.department != null){
            this.department.removeWorker(this);
        }
        this.department = department;
        if (department != null){
            this.department.addWorker(this);
        }
    }

    public Department getDepartment() { return department; }

    public String getName(){
        return name;
    }

    public String toString(){
        return department.getInfoAbout(this);
    }
}

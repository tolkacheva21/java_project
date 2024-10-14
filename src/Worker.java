public class Worker {
    private String name;
    private Department department;

    public Worker(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = new Department(department.getName(), department.getWorkers());
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return new Department(department.getName(), department.getWorkers());
    }

    public String toString() {
        if (department == null){
            return name + " has no work :(";
        }
        else if (department.getBoss() == this){
            return name + " is boss of " + department.getName();
        }
        return name + " works in " + department;
    }
}

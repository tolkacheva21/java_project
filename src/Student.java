import java.util.Arrays;

public class Student {
    public String name;
    public int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString(){
        return name + ": " + Arrays.toString(marks);
    }
}

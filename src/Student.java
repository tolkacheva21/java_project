import java.util.Arrays;

public class Student {
    public String name;
    public int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public Student(String name) {
        this(name, null);
    }

    public float srMark(){
        if (marks.length == 0) return 0;
        return (float) Arrays.stream(marks).sum() / marks.length;
    }

    public String status(){
        if (marks.length != 0 && srMark() == 5) return "Отличник";
        return "Не отличник";
    }

    public String toString(){
        return name + ": " + Arrays.toString(marks);
    }
}

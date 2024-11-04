package tolkacheva.people;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    Cheker rule;
    private List<Integer> marks;

    public Student(String name, List<Integer> marks) {
        setName(name);
        setMarks(marks);
    }

    public Student(String name, Integer...marks){
        this(name, Arrays.asList(marks));
    }

    public Student(String name) {
        this(name, (List<Integer>) null);
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name must not be empty");
        this.name = name;
    }

    public void setMarks(List<Integer> marks) {
        for (int x: marks){
            if (rule.check(x)) throw new IllegalArgumentException("mark must be (2-5)");
        }
        this.marks.addAll(marks);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarks() {
        return new ArrayList<>(marks);
    }

    public double srMark(){
        return marks.stream().mapToInt(x->x).average().orElse(0);
    }

    public boolean status(){
        return marks.size() != 0 && srMark() == 5;
    }

    public String toString(){
        return name + ": " + marks;
    }
}

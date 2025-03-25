package ru.tolkacheva.people;

import ru.tolkacheva.differentclasses.Comparable;

import java.util.*;

public class Student implements Comparable<Student> {
    private String name;
    Cheker rule = new AllGood();
    private List<Integer> marks = new ArrayList<>();
    private Deque<UndoOperation> operations =  new ArrayDeque<>();

    public Student(String name, List<Integer> marks) {
        setName(name);
        setMarks(marks);
    }

    public Student(String name, Integer... marks) {
        this(name, Arrays.asList(marks));
    }

    public Student(String name) {
        this(name, new ArrayList<>());
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name must not be empty");
        String temp = this.name;
        operations.push(()->this.name = temp);
        this.name = name;
    }

    public void setMarks(List<Integer> marks) throws IllegalGradeException {
        for (int x : marks) {
            if (!rule.check(x)) throw new IllegalArgumentException();
        }
        //int tmpMarks = new ArrayList<>(this.marks);
        //operations.push(()->this.marks = tmpMarks); - переделать
        this.marks.addAll(marks);
    }

    public void setMarks(Integer... marks) {
        setMarks(Arrays.asList(marks));
    }

    public String getName() {
        return name;
    }

    public int removeMark(int value){
        int ind = marks.indexOf(value); // подумать и переделать (но вроде правильно)
        int tempMark = marks.get(ind);
        operations.push(()->marks.add(tempMark));
        return marks.remove(value);
    }

    public List<Integer> getMarks() {
        return new ArrayList<>(marks);
    }

    public int srMark() {
        return (int)marks.stream().mapToInt(x -> x).average().orElse(0);
    }

    public boolean status() {
        return marks.size() != 0 && srMark() == 5;
    }

    public String toString() {
        return name + ": " + marks;
    }

    @Override
    public int compare(Student student) {
        if (this.srMark() > student.srMark()) return 1;
        else if (this.srMark() == student.srMark()) return 0;
        return -1;
    }

    public Save<Student> save(){
        return new SaveStudent(this.name, new ArrayList<>(this.marks));
    }

    public void undo(){
        operations.pop().make();
    }

    public class SaveStudent implements Save<Student>{
        private String name;
        private List<Integer> marks;

        public SaveStudent(String name, List<Integer> marks) {
            this.name = name;
            this.marks = marks;
        }

        @Override
        public void loadSave() {
            Student.this.name = this.name;
            Student.this.marks = new ArrayList<>(marks);
        }
    }
}

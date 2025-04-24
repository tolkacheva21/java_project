package ru.tolkacheva.spring.student;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.tolkacheva.spring.BeanConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StudentBean implements Comparable<StudentBean> {
    private String name;
    private List<Integer> grades = new ArrayList<>();


    public StudentBean(String name, List<Integer> grades) {
        setName(name);
        setGrades(grades);
    }

    public StudentBean(String name, Integer... grades) {
        this(name, Arrays.asList(grades));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name must not be empty");
        this.name = name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        BeanConfig config = new BeanConfig();
        for (int x : grades) {
            if (config.range().test(x)) throw new IllegalArgumentException();
        }
        this.grades.addAll(grades);
    }

    public void setGrades(Integer... grades) {
        setGrades(Arrays.asList(grades));
    }

    public int srGrade() {
        return (int)grades.stream().mapToInt(x -> x).average().orElse(0);
    }

    public boolean status() {
        return grades.size() != 0 && srGrade() == 5;
    }

    public String toString() {
        return name + ": " + grades;
    }

    @Override
    public int compareTo(StudentBean student) {
        if (this.srGrade() > student.srGrade()) return 1;
        else if (this.srGrade() == student.srGrade()) return 0;
        return -1;
    }
}

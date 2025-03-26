package ru.tolkacheva.spring.student;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class StudentsFactory {
    @Bean
    public StudentBean createStudent(String name) {
        return new StudentBean(name, new ArrayList<>());
    }

    @Bean
    public StudentBean createStudent(String name, List<Integer> grades) {
        return new StudentBean(name, grades);
    }
}

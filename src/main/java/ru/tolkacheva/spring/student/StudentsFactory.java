package ru.tolkacheva.spring.student;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
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

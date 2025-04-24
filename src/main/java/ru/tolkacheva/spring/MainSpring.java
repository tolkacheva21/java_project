package ru.tolkacheva.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.tolkacheva.spring.student.StudentBean;

public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext con = new AnnotationConfigApplicationContext("ru.tolkacheva.spring");
        StudentBean student = con.getBean(StudentBean.class);
        System.out.println(student);
    }
}

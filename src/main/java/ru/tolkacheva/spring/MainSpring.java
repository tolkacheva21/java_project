package ru.tolkacheva.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.tolkacheva.spring.feedback.Feedback;
import ru.tolkacheva.spring.student.StudentBean;

import java.util.List;
import java.util.function.Predicate;

public class MainSpring {
    public static void main(String[] args) {

        ApplicationContext con = new AnnotationConfigApplicationContext("ru.tolkacheva.spring");

        Object hi = con.getBean("hello");
        System.out.println(hi);

        Object rand1 = con.getBean("random");
        Object rand2 = con.getBean("random");
        System.out.println(rand1);
        System.out.println(rand2);

        Object date = con.getBean("dateBean");
        System.out.println(date);

        Predicate<Integer> num = (Predicate<Integer>) con.getBean("range");
        System.out.println(num.test(3));

        Object max = con.getBean("max");
        Object min = con.getBean("min");
        System.out.println(max);
        System.out.println(min);

        Feedback feedback1 = (Feedback) con.getBean("feedback");
        feedback1.setText("Очень хорошо");
        feedback1.setGrade(4);
        Feedback feedback2 = (Feedback) con.getBean("feedback");
        feedback2.setText("Сойдет");
        feedback2.setGrade(3);
        Feedback feedback3 = (Feedback) con.getBean("feedback");
        feedback3.setText("Сложно сказать");
        feedback3.setGrade((Integer) rand1);
        List<Feedback> lst = List.of(feedback1, feedback2, feedback3);
        System.out.println(feedback1);
        System.out.println(feedback2);
        System.out.println(feedback3);

//        Feedback best = (Feedback) con.getBean("bestFB");
//        System.out.println(best);

//        StudentBean std1 = con.getBean(StudentBean.class);
//        std1.setName("Petya");
//        std1.setGrades(3, 4, 4, 5);
//        StudentBean std2 = con.getBean(StudentBean.class);
//        std2.setName("Vasya");
//        std2.setGrades(2, 3, 2);
//        System.out.println(std1);
//        System.out.println(std2);
    }
}

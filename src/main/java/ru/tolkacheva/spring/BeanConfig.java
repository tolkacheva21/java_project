package ru.tolkacheva.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import ru.tolkacheva.spring.feedback.Feedback;
import ru.tolkacheva.spring.student.StudentBean;

import java.util.*;
import java.util.function.Predicate;

@Configuration
public class BeanConfig {
    private List<Integer> numsRand = new ArrayList<>();

    @Bean
    public String hello() {
        return "Hello world";
    }

    @Bean
    @Scope("prototype")
    public int random() {
        int randNum = (int) (Math.random() * max() - Math.abs(min()));
        if (!numsRand.contains(randNum)) {
            numsRand.add(randNum);
        }
        return numsRand.stream().filter(x -> x == randNum).toList().getFirst();
    }

    @Bean
    @Lazy
    public Date dateBean() {
        return new Date();
    }

    @Bean
    public Predicate<Integer> range() {
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 2 && integer <= 5;
            }
        };
    }

    @Bean
    public int max() {
        return 198976;
    }

    @Bean
    public int min() {
        return -198976;
    }

    @Bean
    public Feedback betterFB(List<Feedback> feedbacks) {
        Feedback better = feedbacks.get(0);
        for (int i = 0; i < feedbacks.size() - 1; i++) {
            if (feedbacks.get(i).getGrade() < feedbacks.get(i+1).getGrade()) {
                better = feedbacks.get(i+1);
            }
        }
        return better;
    }
}

package ru.tolkacheva.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import ru.tolkacheva.spring.feedback.Feedback;

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
        if (numsRand.isEmpty()) {
            for (int i = min(); i <= max(); i++) {
                numsRand.add(i);
            }
        }
        Random random = new Random();
        int randNum = random.nextInt(0, numsRand.size());
        return numsRand.remove(randNum);
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
    public Feedback bestFB(List<Feedback> feedbacks) {
        Feedback best = feedbacks.get(0);
        for (int i = 0; i < feedbacks.size() - 1; i++) {
            if (feedbacks.get(i).getGrade() < feedbacks.get(i+1).getGrade()) {
                best = feedbacks.get(i+1);
            }
        }
        return best;
    }
}

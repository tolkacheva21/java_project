package ru.tolkacheva.spring.feedback;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Feedback {
    private String text;
    private int grade;

    public void setText(String text) {
        this.text = text;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getText() {
        return text;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "text='" + text + '\'' +
                ", grade=" + grade +
                '}';
    }
}

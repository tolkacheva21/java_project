package ru.tolkacheva.spring.streamplatform;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("pirojok")
public class ExampleProcessorB implements DataProcessor{
    @Override
    public List<String> process(List<String> data) {
        return List.of();
    }
}

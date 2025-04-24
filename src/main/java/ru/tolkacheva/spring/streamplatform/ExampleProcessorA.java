package ru.tolkacheva.spring.streamplatform;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExampleProcessorA implements DataProcessor{
    DataProcessor nextProcessor;

    public ExampleProcessorA(@Qualifier("pirojok") DataProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public List<String> process(List<String> data) {
        return data.stream()
                .map(s -> s.toLowerCase())
                .map(s -> s.replace("a", ""))
                .toList();
    }
}

package ru.tolkacheva.spring.streamplatform;

import java.util.List;

public interface DataProcessor {
    List<String> process(List<String> data);
}

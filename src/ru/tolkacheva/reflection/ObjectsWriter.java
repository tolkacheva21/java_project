package ru.tolkacheva.reflection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

public class ObjectsWriter <T> {
    private String path;

    public ObjectsWriter(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void write(List<T> lst) throws IOException {
        File file = new File(path);
        FileWriter fw = new FileWriter(file);

        lst.stream().map(o -> o.getClass())
                .forEach(cls -> {
                    try {
                        fw.write(cls.getName() + " " + Arrays.stream(cls.getConstructors())
                                .map(c -> Arrays.stream(c.getParameters())
                                        .map(Parameter::getName)));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        fw.close();
    }
}

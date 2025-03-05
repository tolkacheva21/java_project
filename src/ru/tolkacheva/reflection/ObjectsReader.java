package ru.tolkacheva.reflection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ObjectsReader <T> {
    private String path;

    public ObjectsReader(String path) throws FileNotFoundException {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public List<T> read() throws IOException {
        File file = new File(path);
        List<T> lst = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        lst.add(scanner.nextLine());

        return lst;
    }
}

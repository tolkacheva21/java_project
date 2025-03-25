package ru.tolkacheva.annotations.reset;

import java.lang.reflect.Field;
import java.util.*;

public class MainReset {
    public static void main(String[] args) {

    }

    private static Set<Field> getAllFields(Object obj) {
        Set<Field> fields = new HashSet<>();
        fields.addAll(Set.of(obj.getClass().getDeclaredFields()));
        Class<?> parent = obj.getClass().getSuperclass();
        fields.addAll(getAllFields(parent));
        return fields;
    }

    public static void reset(Object ...objects) throws IllegalAccessException {
        Set<Field> fields;
        for (Object o: objects) {
            if (o.getClass().isAnnotationPresent(Default.class)) {
                fields = getAllFields(o);
                for (Field f: fields) {
                    f.setAccessible(true);
                    f.set(f, o.getClass().getAnnotation(Default.class).value());
                }
            }
            fields = getAllFields(o);
            for (Field f: fields) {
                if (f.isAnnotationPresent(Default.class)) {
                    f.setAccessible(true);
                    f.set(f, f.getAnnotation(Default.class).value());
                }
            }
        }
    }
}

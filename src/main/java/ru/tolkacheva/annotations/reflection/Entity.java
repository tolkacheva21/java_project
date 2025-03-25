package ru.tolkacheva.annotations.reflection;

import ru.tolkacheva.annotations.reset.Default;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Entity {
    private static Set<Field> getAllFields(Class<?> difClass) {
        if (difClass.equals(Object.class)) return Set.of();
        if (difClass.isAnnotationPresent(ToString.class)
                && Objects.equals(difClass.getAnnotation(ToString.class).value(), ToString.NO)){
            return Set.of();
        }
        Set<Field> fields = new HashSet<>();
        for (Field f: difClass.getDeclaredFields()) {
            if (f.isAnnotationPresent(ToString.class)
                    && Objects.equals(f.getAnnotation(ToString.class).value(), ToString.YES)) {
                fields.add(f);
            }
        }
        Class<?> classParents = difClass.getSuperclass();
        for (Field f: classParents.getDeclaredFields()) {
            if (f.isAnnotationPresent(ToString.class)
                    && Objects.equals(f.getAnnotation(ToString.class).value(), ToString.YES)) {
                fields.add(f);
            }
        }
        return fields;
    }

    private String getFieldsView(Field field) {
        try {
            return field.getName() + "=" + field.get(this);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() throws NullPointerException {
        return getClass().getSimpleName()+"{"
                + MainReflection.getAllFields(getClass())
                .stream()
                .map(this::getFieldsView)
                .collect(Collectors.joining())
                +"}";
    }
}

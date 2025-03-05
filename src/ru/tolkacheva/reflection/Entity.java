package ru.tolkacheva.reflection;

import ru.tolkacheva.main.Main;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Entity {
    private static Set<Field> getAllFields(Class<?> difClass) {
        if (difClass.equals(Object.class)) return Set.of();
        Set<Field> fields = new HashSet<>();
        fields.addAll(Set.of(difClass.getDeclaredFields()));
        Class<?> classParents = difClass.getSuperclass();
        fields.addAll(getAllFields(classParents));

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
    public String toString() {
        return getClass().getSimpleName()+"{"
                + MainReflection.getAllFields(getClass())
                .stream()
                .map(this::getFieldsView)
                .collect(Collectors.joining())
                +"}";
    }
}

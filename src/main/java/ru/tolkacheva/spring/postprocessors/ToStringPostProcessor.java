package ru.tolkacheva.spring.postprocessors;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.tolkacheva.annotations.reflection.MainReflection;
import ru.tolkacheva.annotations.reflection.ToString;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ToStringPostProcessor implements BeanPostProcessor {
    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Set<Field> fields = getAllFields(bean.getClass());
        if (fields.isEmpty()) return bean;
        return bean.toString();
    }

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

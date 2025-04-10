package ru.tolkacheva.spring.postprocessors;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.tolkacheva.annotations.reset.Default;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DefaultPostProcessor implements BeanPostProcessor {
    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Set<Field> fields;
        List<Method> defMet = new ArrayList<>();
        if (bean.getClass().isAnnotationPresent(Default.class)) {
            defMet.addAll(List.of(bean.getClass().getDeclaredMethods()));
        }

        for (Method m: defMet) {
            if (m.getReturnType() == Object.class
                    && m.getParameterCount() == 1
                    && m.getParameterTypes()[0] == Field.class) {
                try {
                    m.invoke(bean, m.getParameters()[0]);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        fields = getAllFields(bean);
        for (Field f: fields) {
            if (f.isAnnotationPresent(Default.class)) {
                f.setAccessible(true);
                try {
                    f.set(bean, bean);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bean;
    }

    private static Set<Field> getAllFields(Object obj) {
        Set<Field> fields = new HashSet<>();
        fields.addAll(Set.of(obj.getClass().getDeclaredFields()));
        Class<?> parent = obj.getClass().getSuperclass();
        fields.addAll(getAllFields(parent));
        return fields;
    }
}

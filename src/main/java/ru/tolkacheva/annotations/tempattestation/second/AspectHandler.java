package ru.tolkacheva.annotations.tempattestation.second;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AspectHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Aspect.class)) {
            Class<?> clazz = method.getAnnotation(Aspect.class).value();
            Method[] methods = clazz.getDeclaredMethods();
            List<Method> before = new ArrayList<>();
            List<Method> after = new ArrayList<>();
            List<Method> met = new ArrayList<>();
            for (Method m: methods) {
                if (m.isAnnotationPresent(Before.class)) {
                    before.add(m);
                }
                if (m.isAnnotationPresent(After.class)) {
                    after.add(m);
                }
                met.add(m);
            }
            before.stream().forEach(m -> {
                try {
                    m.invoke(proxy);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
            met.stream().forEach(m -> {
                try {
                    m.invoke(proxy);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
            after.stream().forEach(m -> {
                try {
                    m.invoke(proxy);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        return method.invoke(proxy, args);
    }
}

package ru.tolkacheva.annotations.collector;

import ru.tolkacheva.geometry.Point;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MainCollector {
    public static void main(String[] args) throws InvocationTargetException
            , NoSuchMethodException, InstantiationException, IllegalAccessException {

        Map<String, Object> methods = collect(TestClass.class);
        System.out.println(methods);
    }

    public static Map<String, Object> collect(Class<?> ...classes) throws NoSuchMethodException
            , InvocationTargetException, InstantiationException, IllegalAccessException {

        List<Method> methods = new ArrayList<>();
        Map<String, Object> res = new HashMap<>();
        List<Object> objects = new ArrayList<>();

        for (Class<?> cls: classes) {
            methods.addAll(Arrays.stream(cls.getDeclaredMethods())
                    .filter(m -> m.getParameterCount() == 0)
                    .filter(m -> m.getReturnType() != void.class)
                    .filter(m -> m.isAnnotationPresent(Invoke.class))
                    .toList());
            if (methods.isEmpty()) return res;
            objects.add(cls.getDeclaredConstructor().newInstance());
        }

        for (Method m: methods) {
            Object[] p = Arrays.stream(m.getParameterTypes()).toArray();
            for (Object obj: objects) {
                res.put(m.getName(), m.invoke(obj, p));
            }
        }

        return res;
    }
}

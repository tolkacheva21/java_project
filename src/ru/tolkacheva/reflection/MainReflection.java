package ru.tolkacheva.reflection;

import ru.tolkacheva.annotations.*;
import ru.tolkacheva.geometry.Line;
import ru.tolkacheva.geometry.Point;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@DefaultAn(MainReflection.class)
@ToStringAn("NO")
@ValidateAn(MainReflection.class)
@TwoAn(first = "first", second = 2)
@CacheAn()
public class MainReflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        System.out.println(getAllFields(Point.class));

        Line<Point> line1 = Line.of(new Point(1, 2), new Point(3, 4));
        Line<Point> line2 = Line.of(new Point(-5, -6), new Point(7, 8));
        lineConnector(line1, line2);
        System.out.println(line2);
    }

    @InvokeAn
    public static void lineConnector(Line<?> line1, Line<?> line2)
            throws NoSuchFieldException, IllegalAccessException {
        Field fl1 = line1.getClass().getDeclaredField("point2");
        Field fl2 = line2.getClass().getDeclaredField("point1");
        fl1.setAccessible(true);
        fl2.setAccessible(true);
        fl2.set(line2, fl1.get(line1));
    }

    public static Set<Field> getAllFields(Class<?> difClass) {
        if (difClass.equals(Object.class)) return Set.of();
        Set<Field> fields = new HashSet<>();
        fields.addAll(Set.of(difClass.getDeclaredFields()));
        Class<?> classParents = difClass.getSuperclass();
        fields.addAll(getAllFields(classParents));

        return fields;
    }

    public static void validate(Object obj, Class<?> cls) {
        List<Method> methods = List.of(cls.getMethods());
        Object o = null;
        try {
            Constructor<?> constr = cls.getDeclaredConstructor();
            constr.setAccessible(true);
            o = constr.newInstance();
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        Object finalO = o;
        methods.stream()
                .filter(m -> m.getParameterCount() == 1)
                .filter(m -> m.getParameterTypes()[0].isAssignableFrom(obj.getClass()))
                .peek(m -> m.setAccessible(true))
                .forEach(m -> {
                    try {
                        m.invoke(finalO, obj);
                    } catch (InvocationTargetException e) {
                        Throwable prob = e.getCause();
                        if (prob instanceof ValidateException tw) {
                            throw tw;
                        }
                        throw new RuntimeException(e);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public static <T> T cache(T obj) {
        Class<?> cls = obj.getClass();
        List<Method> methods = List.of(cls.getMethods());
        methods.stream().filter(m -> {
            try {
                return (boolean) m.invoke(obj);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }).count();
        return obj;
    }
}

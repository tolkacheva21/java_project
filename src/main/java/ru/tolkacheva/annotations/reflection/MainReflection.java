package ru.tolkacheva.annotations.reflection;

import ru.tolkacheva.annotations.*;
import ru.tolkacheva.annotations.cache.Cache;
import ru.tolkacheva.annotations.collector.Invoke;
import ru.tolkacheva.sem3.geometry.Line;
import ru.tolkacheva.sem3.geometry.Point;
import ru.tolkacheva.annotations.reset.Default;
import ru.tolkacheva.annotations.validate.Validate;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

@Default("MainReflection")
@ToString("NO")
@Validate(MainReflection.class)
@Two(first = "first", second = 2)
@Cache()
public class MainReflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        System.out.println(getAllFields(Point.class));

        Line<Point> line1 = Line.of(new Point(1, 2), new Point(3, 4));
        Line<Point> line2 = Line.of(new Point(-5, -6), new Point(7, 8));
        lineConnector(line1, line2);
        System.out.println(line2);
    }

    @Invoke
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

//    public static <T> T cache(T obj) {
//        Class<?> cls = obj.getClass();
//        List<Method> methods = List.of(cls.getMethods());
//        methods.stream().filter(m -> {
//            try {
//                return (boolean) m.invoke(obj);
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            } catch (InvocationTargetException e) {
//                throw new RuntimeException(e);
//            }
//        }).count();
//        return obj;
//    }
}

package ru.tolkacheva.annotations.validate;

import ru.tolkacheva.annotations.reflection.ValidateException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class TestExecutor {
    public static void validate(Object ...obj) {
        for (Object ob: obj) {
            try {
                validate(ob);
            } catch (NoSuchMethodException | IllegalAccessException
                     | InvocationTargetException | InstantiationException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void validate(Object obj) throws NoSuchMethodException
            , IllegalAccessException, InvocationTargetException
            , InstantiationException{

        Class<?> clazz = obj.getClass();
        if (!clazz.isAnnotationPresent(Validate.class)) {
            Annotation[] annotations = (Annotation[]) Arrays.stream(clazz.getAnnotations())
                    .filter(a -> a.getClass().isAnnotationPresent(Validate.class)).toArray();

            if (annotations.length != 0) {
                Class<?>[] validatorClasses = clazz.
                        getAnnotation(Validate.class)
                        .value();

                for (Class<?> testClass: validatorClasses) {
                    validate(obj, testClass);
                }
            }
        }

        Class<?>[] validatorClasses = clazz.
                getAnnotation(Validate.class)
                .value();

        for (Class<?> testClass: validatorClasses) {
            validate(obj, testClass);
        }
    }

    private static void validate(Object obj, Class<?> cls) throws NoSuchMethodException
            , InvocationTargetException, InstantiationException, IllegalAccessException {

        Constructor<?> constr = cls.getDeclaredConstructor();
        constr.setAccessible(true);
        Object testObj = constr.newInstance();


        List<Method> tests = Arrays.stream(cls.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(Test.class))
                .filter(m -> m.getParameterCount() == 1)
                .filter(m -> m.getParameterTypes()[0].isAssignableFrom(obj.getClass()))
                .peek(m -> m.setAccessible(true))
                .toList();

        for (Method m: tests) {
            try {
                m.invoke(testObj, obj);
            } catch (InvocationTargetException e) {
                Throwable tt = e.getCause();
                if (tt instanceof ValidateException tw) {
                    throw tw;
                }
                throw e;
            }
        }
    }
}

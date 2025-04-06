package ru.tolkacheva.annotations.tempattestation.second;

import java.lang.reflect.Proxy;

public class AspectProxyCreator {
    @SuppressWarnings("unchecked")
    public static <T> T create(T obj) {
        return (T) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new AspectHandler());
    }
}

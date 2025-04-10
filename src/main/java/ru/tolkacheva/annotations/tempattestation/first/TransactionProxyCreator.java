package ru.tolkacheva.annotations.tempattestation.first;

import java.lang.reflect.Proxy;

public class TransactionProxyCreator {
    @SuppressWarnings("unchecked")
    public static <T> T create(T obj) {
        return (T) Proxy
                .newProxyInstance(
                        obj.getClass().getClassLoader(),
                        obj.getClass().getInterfaces(),
                        new TransactionHandler(obj));
    }
}

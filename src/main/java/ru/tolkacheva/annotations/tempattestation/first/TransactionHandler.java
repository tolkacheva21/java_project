package ru.tolkacheva.annotations.tempattestation.first;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TransactionHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Transactional.class)
                && args.length == 1
                && args[0] == ArrayList.class) {
            try {
                method.invoke(proxy, args);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        return method.invoke(proxy, args);
    }
}

package ru.tolkacheva.annotations.tempattestation.first;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TransactionHandler implements InvocationHandler {
    private Object object;

    public TransactionHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Transactional.class)
                || args.length == 1
                || args[0] == ArrayList.class) {
            return method.invoke(object, args);
        }
        List<?> lst = (List<?>) args[0];
        return method.invoke(object, lst);
    }
}

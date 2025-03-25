package ru.tolkacheva.annotations.cache;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;

public class ProxyHandler implements InvocationHandler {
    private Object obj;
    private Map<Key, Object> cacheMap = new HashMap<>();
    private Map<Field, Object> objectState = new HashMap<>();
    private Set<String> methodNames = new HashSet<>();

    public ProxyHandler(Object obj) {
        this.obj = obj;
        String[] nameMethods = obj.getClass().getAnnotation(Cache.class).value();
        methodNames.addAll(List.of(nameMethods));
    }

    private boolean checkState() {
        Class<?> clazz = this.obj.getClass();
        List<Field> fields = new ArrayList<>();
        if (objectState.containsValue(obj)) {
            for (Map.Entry<Field, Object> entry: objectState.entrySet()) {
                fields.add(entry.getKey());
            }
        }
        return true;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        checkState();
        if (!(methodNames.isEmpty() || methodNames.contains(method.getName()))) {
            return method.invoke(this.obj, args);
        }
        Key key = new Key(method.getName(), args);
        if (cacheMap.containsKey(key)){
            return cacheMap.get(key);
        }
        Object obj2 = method.invoke(this.obj, args);
        cacheMap.put(key, obj2);
        return obj2;
    }
}

record Key(String methodName, Object[] args) {
}
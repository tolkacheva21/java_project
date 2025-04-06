package ru.tolkacheva.annotations.cache;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collector;

public class ProxyHandler implements InvocationHandler {
    private Object obj;
    private Map<Key, Object> cacheMap = new HashMap<>();
    private Set<String> cachedMethods = new HashSet<>();

    public ProxyHandler(Object obj) {
        this.obj = obj;
        this.cachedMethods = resolveCachedMethods(obj);
    }

    private Set<String> resolveCachedMethods(Object obj) {
        Set<String> methods = new HashSet<>();
        Cache cache = obj.getClass().getAnnotation(Cache.class);
        Method[] met = obj.getClass().getDeclaredMethods();
        if (cache != null && cache.value().length > 0) {
            methods.addAll(Set.of(cache.value()));
        }
        return methods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!(cachedMethods.isEmpty() || cachedMethods.contains(method.getName()))) {
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
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        Key key = (Key) object;
        if (!methodName.equals(key.methodName)) return false;
        return Arrays.deepEquals(args, key.args);
    }

    @Override
    public int hashCode() {
        int res = methodName.hashCode();
        res = 31 * res + Arrays.deepHashCode(args);
        return res;
    }
}

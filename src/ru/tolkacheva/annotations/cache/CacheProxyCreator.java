package ru.tolkacheva.annotations.cache;

import java.lang.reflect.Proxy;

public class CacheProxyCreator {
        @SuppressWarnings("unchecked")
        public static <T> T create(T o){
            if(o == null || !o.getClass().isAnnotationPresent(Cache.class)) {
                return o;
            }
            return (T) Proxy
                    .newProxyInstance(
                            o.getClass().getClassLoader(),
                            o.getClass().getInterfaces(),
                            new ProxyHandler(o)
                    );
        }
}

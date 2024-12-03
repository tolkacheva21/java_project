package ru.tolkacheva.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataStream {

    public static <T> Optional<T> reduce(List<T> values, Function<T> fun){
        if (values.isEmpty()) return Optional.empty();
        T res = values.get(0);
        for (T x: values.subList(1, values.size())){
            res = fun.apply(res, x);
        }
        return Optional.of(res);
    }

    public static <T> List<T> filter(List<T> values, FilterRule<T> rule){
        List<T> list = new ArrayList<>();
        for (T x: values){
            if (rule.check(x)){
                list.add(x);
            }
        }
        return list;
    }

    public static <T, R> List<R> map(List<T> lst, Method<T, R> fun){
        List<R> list = new ArrayList<>();
        for(T x: lst){
            list.add(fun.apply(x));
        }
        return list;
    }

    public static <P, T> P collect(List<T> values, Supplier<P> supplier, BiConsumer<P, T> adder){
        P result = supplier.get();
        for (T x: values){
            adder.accept(result, x);
        }
        return result;
    }
}

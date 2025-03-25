package ru.tolkacheva.functional;

import java.util.*;

public class DataStream <T>{

    private List<T> values;
    private List<MyOperation> operations = new ArrayList<>();

    private DataStream(List<T> values) {
        this.values = values;
    }

    public static  <T> DataStream<T> of(List<T> values){
        return new DataStream(values);
    }

    public T reduce(Function<T> fun, T init){
        T res = init;
        up:
        for (T x: values){
            for (MyOperation op: operations){
                x = (T)op.make(x);
                if (op.isEnd()) continue up;
            }
            res = fun.apply(res, x);
        }
        return res;
    }

    public DataStream<T> filter(FilterRule<T> rule){

        operations.add(new MyOperation() {
            boolean res;
            @Override
            public Object make(Object obj) {
                res = rule.check((T) obj);
                return obj;
            }

            @Override
            public boolean isEnd() {
                return !res;
            }
        });
        return this;
    }

    @SuppressWarnings("unchecked")
    public <R> DataStream<R> map(MyMethod<T, R> fun){
        operations.add(new MyOperation() {
            @Override
            public Object make(Object obj) {
                return fun.apply((T) obj);
            }

            @Override
            public boolean isEnd() {
                return false;
            }
        });
        return (DataStream<R>)this;
    }

    public <P> P collect(Supplier<P> supplier, BiConsumer<P, T> adder){
        P result = supplier.get();
        for (T x: values){
            adder.accept(result, x);
        }
        return result;
    }
}

interface MyOperation{
    Object make(Object obj);
    boolean isEnd();
}

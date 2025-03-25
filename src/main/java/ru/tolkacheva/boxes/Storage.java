package ru.tolkacheva.boxes;

public final class Storage <T>{
    private T obj;
    private static final Storage EMPTY_STORAGE = new Storage(null);

    private Storage(T obj) {
        this.obj = obj;
    }

    public T getObj(T altObj) {
        if (this.obj == null) return altObj;
        return obj;
    }

    @SuppressWarnings("unchecked")
    public static <T> Storage <T> emptyStorage(){
        return EMPTY_STORAGE;
    }

    public static <T> Storage <T> createNotNull(T obj){
        if (obj == null) throw new RuntimeException("object mustn't be empty");
        return new Storage(obj);
    }

    public static <T> Storage <T> createWithNull(T obj){
        return new Storage(obj);
    }

    @SuppressWarnings("unchecked")
    public static <T> Storage <T> of(T obj){
        if (obj == null) return EMPTY_STORAGE;
        return new Storage<>(obj);
    }
}

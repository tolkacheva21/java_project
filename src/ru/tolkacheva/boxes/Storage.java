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
    public static <T> Storage <T> empty(){
        return EMPTY_STORAGE;
    }

    @SuppressWarnings("unchecked")
    public static <T> Storage <T> of(T obj){
        if (obj == null) return EMPTY_STORAGE;
        return new Storage<>(obj);
    }
}

package ru.tolkacheva.differentclasses;

import java.util.ArrayList;

public final class Storage <T>{
    private T obj;

    public Storage(T obj) {
        this.obj = obj;
    }

    public T getObj(T altObj) {
        if (this.obj == null) return altObj;
        return obj;
    }
}

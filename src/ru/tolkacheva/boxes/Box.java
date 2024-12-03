package ru.tolkacheva.boxes;

public class Box <T>{
    private T obj;

    public T getObj() {
        if (obj == null) throw new RuntimeException();
        T temp = obj;
        obj = null;
        return temp;
    }

    public void setObj(T obj) {
        if (!isEmty()) throw new RuntimeException("box isn't empty");
        this.obj = obj;
    }

    public boolean isEmty(){
        return obj == null;
    }
}

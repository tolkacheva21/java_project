package ru.tolkacheva.sem3.differentclasses;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack <T>{
    public List<T> arr = new ArrayList<>();

    public void push(T x){
        arr.add(x);
    }

    public T pop(){
        if (arr == null || arr.isEmpty()) throw new EmptyStackException();
        T temp = arr.getLast();
        arr.remove(arr.getLast());
        return temp;
    }

    public T peek(){
        return arr.getLast();
    }

    public String toString(){
        return arr.toString();
    }
}

package ru.tolkacheva.differentclasses;

import java.util.ArrayList;
import java.util.List;

public class Stack <T>{
    public List<T> arr = new ArrayList<>();

    public void push(T x){
        arr.add(x);
    }

    public T pop(){
        T temp = arr.getLast();
        arr.remove(arr.getLast());
        return temp;
    }

    public void peek(){
        System.out.println(arr.getLast());
    }

    public String toString(){
        return arr.toString();
    }
}

package ru.tolkacheva.sem3.boxes;

public class TmpObj {
    public static Storage<Integer> count(){
        System.out.println("count num");
        int x = 5;
        return (Storage<Integer>) Storage.emptyStorage().getObj(x);
    }
}

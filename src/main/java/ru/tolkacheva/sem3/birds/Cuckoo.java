package ru.tolkacheva.sem3.birds;

public class Cuckoo implements Bird{
    public Cuckoo() {}

    @Override
    public void sing() {
        int n = (int)(Math.random() * 10) + 1;
        for (int i = 0; i < n; i++){
            System.out.println("ку-ку");
        }
    }
}

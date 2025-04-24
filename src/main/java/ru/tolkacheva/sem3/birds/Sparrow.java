package ru.tolkacheva.sem3.birds;

public class Sparrow implements Bird{
    public Sparrow() {}

    @Override
    public void sing() {
        System.out.println("чырык");
    }
}

package ru.tolkacheva.sem3.karate;

public class Punch implements Kickable{
    @Override
    public void make(Karateboy boy) {
        boy.punch();
    }
}

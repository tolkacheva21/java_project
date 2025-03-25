package ru.tolkacheva.karate;

public class Punch implements Kickable{
    @Override
    public void make(Karateboy boy) {
        boy.punch();
    }
}

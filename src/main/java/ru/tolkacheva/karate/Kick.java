package ru.tolkacheva.karate;

public class Kick implements Kickable{
    @Override
    public void make(Karateboy boy) {
        boy.kick();
    }
}

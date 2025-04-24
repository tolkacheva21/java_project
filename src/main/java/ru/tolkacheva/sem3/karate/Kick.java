package ru.tolkacheva.sem3.karate;

public class Kick implements Kickable{
    @Override
    public void make(Karateboy boy) {
        boy.kick();
    }
}

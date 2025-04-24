package ru.tolkacheva.sem3.karate;

public class Jump implements Kickable{
    @Override
    public void make(Karateboy boy) {
        boy.jump();
    }
}

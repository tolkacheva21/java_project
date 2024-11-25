package ru.tolkacheva.karate;

public class Jump implements Kickable{
    @Override
    public void make(Karateboy boy) {
        boy.jump();
    }
}

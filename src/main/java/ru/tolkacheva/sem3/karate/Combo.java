package ru.tolkacheva.sem3.karate;

import java.util.List;

public class Combo implements Kickable{
    String name;
    List<Kickable> kicks;

    public Combo(String name, List<Kickable> kicks) {
        this.name = name;
        this.kicks = kicks;
    }

    @Override
    public void make(Karateboy boy){
        for (Kickable x: kicks){
            x.make(boy);
        }
    }
}

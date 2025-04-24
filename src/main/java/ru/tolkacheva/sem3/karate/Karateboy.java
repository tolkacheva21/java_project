package ru.tolkacheva.sem3.karate;

public class Karateboy{
    String name;

    public Karateboy(String name) {
        this.name = name;
    }

    public void kick(){
        System.out.println(name + " : kyaaaa!!!");
    }

    public void punch(){
        System.out.println(name + " : uuuuuuuuuuuuuaaaaaaaaaa");
    }

    public void jump(){
        System.out.println(name + " : aaaaaaa");
    }
}

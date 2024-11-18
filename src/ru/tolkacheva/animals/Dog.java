package ru.tolkacheva.animals;

public class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    public void gav(){
        System.out.println(name + ": bow-wow");
    }
}

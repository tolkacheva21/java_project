package ru.tolkacheva.sem3.animals;

public class GavDog implements Meowable{
    Dog dog;

    public GavDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void meow() {
        dog.gav();
    }
}

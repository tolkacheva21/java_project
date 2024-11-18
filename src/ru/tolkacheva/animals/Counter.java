package ru.tolkacheva.animals;

public class Counter implements Meowable{
    public int count;
    Meowable cat;

    public Counter(Meowable cat) {
        this.cat = cat;
    }

    @Override
    public void meow() {
        cat.meow();
        count++;
    }
}

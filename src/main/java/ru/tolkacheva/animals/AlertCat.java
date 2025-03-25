package ru.tolkacheva.animals;

public class AlertCat implements Meowable{
    Meowable cat;

    public AlertCat(Meowable cat) {
        this.cat = cat;
    }

    @Override
    public void meow() {
        System.out.println("alert");
        cat.meow();
    }
}

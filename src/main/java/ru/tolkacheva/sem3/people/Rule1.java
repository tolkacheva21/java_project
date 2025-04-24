package ru.tolkacheva.sem3.people;

public class Rule1 implements Cheker{
    @Override
    public boolean check(int mark){
        return mark >= 2;
    }
}

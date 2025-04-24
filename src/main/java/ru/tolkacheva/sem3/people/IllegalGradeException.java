package ru.tolkacheva.sem3.people;

public class IllegalGradeException extends IllegalArgumentException{
    private int mark;

    public IllegalGradeException(int mark){
        super(String.format("Mark %d is not allowed", mark));
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }
}

package ru.tolkacheva.sem3.geometry;

public class Coordinates2D extends Attribute{
    public Coordinates2D(int x, int y) {
        super("ru.tolkacheva.geometry.Coordinates2D", new int[] {x, y});
    }

    public int getX(){
        return ((int[])super.getValue())[0];
    }

    public int getY(){
        return ((int[])super.getValue())[1];
    }
}

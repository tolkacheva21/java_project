package ru.tolkacheva.sem3.geometry;

public class Rectangle extends Square{
    private int len2;

    public Rectangle(Point point, int len1, int len2) {
        super(point, len1);
        setLen2(len2);
    }

    public Rectangle(int x, int y, int len1, int len2) {
        super(x, y, len1);
        setLen2(len2);
    }

    public void setLen2(int len2) {
        if (len2 <= 0) throw new IllegalArgumentException("len2 must be positive");
        this.len2 = len2;
    }

    public int getLen2() {
        return len2;
    }

    @Override
    public double figureArea() {
        if (super.getLen1() == len2) super.figureArea();
        return super.getLen1() * len2;
    }

    @Override
    public String toString() {
        return "Прямоугольник в точке " + super.pointStart + " со сторонами "
                + super.getLen1() + " и " + len2;
    }
}

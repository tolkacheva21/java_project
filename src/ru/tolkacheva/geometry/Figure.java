package ru.tolkacheva.geometry;

public abstract class Figure {
    Point pointStart;

    public Figure(Point pointStart) {
        this.pointStart = pointStart;
    }

    public abstract double figureArea();
}

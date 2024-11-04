package tolkacheva.geometry;

public abstract class Figure {
    Point2D pointStart;

    public Figure(Point2D pointStart) {
        this.pointStart = pointStart;
    }

    public abstract double figureArea();
}

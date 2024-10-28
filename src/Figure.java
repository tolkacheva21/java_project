public abstract class Figure {
    Point2D pointStart;

    public Figure(Point2D pointStart) {
        this.pointStart = pointStart;
    }

    abstract double figureArea();
}

package ru.tolkacheva.geometry;

public class Triangle extends Figure implements PolylineGetable{
    Point point2;
    Point point3;

    public Triangle(Point pointStart, Point point2, Point point3) {
        super(pointStart);
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public Polyline getPolyline() {
        return new Polyline(super.pointStart, point2, point3);
    }

    @Override
    public double figureArea() {
        return 0.5 * Math.abs((pointStart.x - point3.x) * (point2.y - point3.y) -
                (point2.x - point3.x) * (pointStart.y - point3.y));
    }
}

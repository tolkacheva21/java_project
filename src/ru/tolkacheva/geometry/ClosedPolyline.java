package ru.tolkacheva.geometry;

import java.util.List;

public class ClosedPolyline extends Polyline{
    public ClosedPolyline(List<Point> points) {
        super(points);
    }

    public ClosedPolyline(Point... points) {
        super(points);
    }

    @Override
    public long lengthLine() {
        if (points.size() < 3) return super.lengthLine();
        return super.lengthLine() + new Line(points.getFirst(), points.getLast()).lengthLine();
    }
}

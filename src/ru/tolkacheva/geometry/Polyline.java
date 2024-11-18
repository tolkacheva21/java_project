package ru.tolkacheva.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Polyline implements Lengthable, PolylineGetable{
    List<Point> points;

    public Polyline(List<Point> points) {
        this.points = points;
    }

    public Polyline(Point... points){
        this(Arrays.asList(points));
    }

    public Polyline() {}

    public boolean addPoints(List<Point> points2){
        return points.addAll(points2);
    }

    @Override
    public Polyline getPolyline() {
        return new Polyline(points);
    }

    public long lengthLine(){
        long res = 0;
        for (int i = 0; i < points.size() - 1; i++){
            res += new Line(points.get(i), points.get(i+1)).lengthLine();
        }
        return res;
    }

    @Override
    public String toString() {
        return "Polyline " + points;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polyline polyline)) return false;
        if (o.getClass() == this.getClass()) return Objects.equals(points, polyline.points);
        List<Point> other = new ArrayList<>(polyline.points);
        List<Point> my = new ArrayList<>(points);
        if (this.getClass() == ClosedPolyline.class) my.add(this.points.getFirst());
        if (polyline.getClass() == ClosedPolyline.class) other.add(polyline.points.getFirst());
        return Objects.equals(my, other);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}

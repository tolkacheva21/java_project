package ru.tolkacheva.geometry;

import java.util.Objects;

public class Line<T extends Point> implements Lengthable, Cloneable {
    private T point1;
    private T point2;

    private Line(T start, T end){
        setPoint1(start);
        setPoint2(end);
    }

    @SuppressWarnings("unchecked")
    public void setPoint1(T point1) {
        if (point2 != null && point2.getClass() != point1.getClass()) throw new RuntimeException();
        this.point1 = (T) point1.clone();
    }

    @SuppressWarnings("unchecked")
    public void setPoint2(T point2) {
        if (point1 != null && point1.getClass() != point2.getClass()) throw new RuntimeException();
        this.point2 = (T) point2.clone();
    }

    public T getPoint1() {
        return point1;
    }

    public T getPoint2() {
        return point2;
    }

    public static <V extends Point> Line<V> of(V start, V end){
        if (start.getClass() != end.getClass()) throw new RuntimeException();
        return new Line<>(start, end);
    }

    public static Line<Point> of(int x1, int y1, int x2, int y2) {
        return new Line<>(new Point(x1, y1), new Point(x2, y2));
    }

    public long lengthLine(){
        return point1.distance(point2);
    }

    public String toString(){
        return "line from " + point1 + " to " + point2;
    }

    @Override
    public Line clone() {
        try {
            Line line = (Line) super.clone();
            line.point1 = point1.clone();
            line.point2 = point2.clone();
            return line;
        } catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return point1.equals(line.point1) && point2.equals(line.point2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2);
    }
}

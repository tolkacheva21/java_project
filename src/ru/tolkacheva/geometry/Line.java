package ru.tolkacheva.geometry;

import java.util.Objects;

public class Line implements Lengthable, Cloneable{
    private Point point1;
    private Point point2;

    public Line(Point start, Point end){
        this.point1 = start;
        this.point2 = end;
    }

    public void setPoint1(Point point1) {
        this.point1.x = point1.x;
        this.point1.y = point1.y;
    }

    public void setPoint2(Point point2) {
        this.point2.x = point2.x;
        this.point2.y = point2.y;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public long lengthLine(){
        return Math.round(Math.sqrt(Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.y, 2)));
    }

    public String toString(){
        return "line from " + point1 + " to " + point2;
    }

    @Override
    public Line clone() {
        try {
            Point p1 = point1.clone();
            Point p2 = point2.clone();
            return (Line) super.clone();
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

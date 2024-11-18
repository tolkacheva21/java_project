package ru.tolkacheva.geometry;

import java.util.Objects;

public class Point implements Comparable<Point>, Cloneable{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "Point {" + x + ", " + y + "}";
    }

    @Override
    public int compareTo(Point o) {
        if (this.x != o.x) return this.x - o.x;
        return this.y - o.y;
    }

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e){
            throw new RuntimeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

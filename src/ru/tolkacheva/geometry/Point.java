package ru.tolkacheva.geometry;

public class Point implements Comparable<Point>{
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
    public Point clone() throws CloneNotSupportedException {
        int x1 = x, y1 = y;
        return new Point(x1, y1);
    }
}

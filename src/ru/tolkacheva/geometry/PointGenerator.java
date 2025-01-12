package ru.tolkacheva.geometry;

public class PointGenerator {
    public static Point createPoint(int x, int y){
        return new Point(x, y);
    }

    public static Point createPoint(int x, int y, int z){
        return new Point3D(x, y, z);
    }
}

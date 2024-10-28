public class Point3D extends Point2D{
    int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public String toString(){
        return "Point {" + x + ", " + y + ", " + z + "}";
    }
}

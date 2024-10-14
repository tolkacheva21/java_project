public class Square {
    Point point;
    private int len;

    public Square(Point point, int len) {
        if (len <= 0) throw new IllegalArgumentException("len must be positive");
        this.point = point;
        this.len = len;
    }

    public Square(int x, int y, int len){
        this(new Point(x, y), len);
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        if (len <= 0) throw new IllegalArgumentException("len must be positive");
        this.len = len;
    }

    public BrokenLine isPointsSquare(){
        return new BrokenLine(point, new Point(point.x + len, point.y),
                new Point(point.x + len, point.y - len),
                new Point(point.x - len, point.y));
    }

    public String toString(){
        return "Квадрат в точке " + point + " со стороной" + len;
    }
}

public class Line {
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

    public long lenghtLine(){
        return Math.round(Math.sqrt(Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.y, 2)));
    }

    public String toString(){
        return "line from " + point1 + " to " + point2;
    }
}

public class Line implements Lengthable{
    private Point2D point1;
    private Point2D point2;

    public Line(Point2D start, Point2D end){
        this.point1 = start;
        this.point2 = end;
    }

    public void setPoint1(Point2D point1) {
        this.point1.x = point1.x;
        this.point1.y = point1.y;
    }

    public void setPoint2(Point2D point2) {
        this.point2.x = point2.x;
        this.point2.y = point2.y;
    }

    public Point2D getPoint1() {
        return point1;
    }

    public Point2D getPoint2() {
        return point2;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point2D(x1, y1), new Point2D(x2, y2));
    }

    public long lengthLine(){
        return Math.round(Math.sqrt(Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.y, 2)));
    }

    public String toString(){
        return "line from " + point1 + " to " + point2;
    }
}

public class Line {
    Point point1 = new Point(4, -5);
    Point point2 = new Point(-1, 2);
    public Line(Point start, Point end){
        this.point1 = start;
        this.point2 = end;
    }
    public String toString(){
        return "line from " + point1 + " to " + point2;
    }
}

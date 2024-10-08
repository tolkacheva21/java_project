public class Line {
    Point point1;
    Point point2;

    public Line(Point start, Point end){
        this.point1 = start;
        this.point2 = end;
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

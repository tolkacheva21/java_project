public class Line {
    Dot point1 = new Dot(4, -5);
    Dot point2 = new Dot(-1, 2);
    public Line(Dot start, Dot end){
        this.point1 = start;
        this.point2 = end;
    }
    public String toString(){
        return "line from " + point1 + " to " + point2;
    }
}

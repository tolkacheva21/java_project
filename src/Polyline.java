import java.util.Arrays;
import java.util.List;

public class Polyline {
    List<Point> points;

    public Polyline(List<Point> points) {
        this.points = points;
    }

    public Polyline(Point... points){
        this(Arrays.asList(points));
    }

    public Polyline() {}

    public boolean addPoints(List<Point> points2){
        return points.addAll(points2);
    }

    public long lenghtPolyline(){
        long res = 0;
        for (int i = 0; i < points.size() - 1; i++){
            res += new Line(points.get(i), points.get(i+1)).lenghtLine();
        }
        return res;
    }

    @Override
    public String toString() {
        return "Polyline " + points;
    }
}

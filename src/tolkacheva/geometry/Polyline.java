package tolkacheva.geometry;

import java.util.Arrays;
import java.util.List;

public class Polyline implements Lengthable, PolylineGetable{
    List<Point2D> points;

    public Polyline(List<Point2D> points) {
        this.points = points;
    }

    public Polyline(Point2D... points){
        this(Arrays.asList(points));
    }

    public Polyline() {}

    public boolean addPoints(List<Point2D> points2){
        return points.addAll(points2);
    }

    @Override
    public Polyline getPolyline() {
        return new Polyline(points);
    }

    public long lengthLine(){
        long res = 0;
        for (int i = 0; i < points.size() - 1; i++){
            res += new Line(points.get(i), points.get(i+1)).lengthLine();
        }
        return res;
    }

    @Override
    public String toString() {
        return "tolkacheva.geometry.Polyline " + points;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrokenLine {
    List<Point> points;

    public BrokenLine(List<Point> points) {
        this.points = points;
    }

    public BrokenLine(Point... points){
        this(Arrays.asList(points));
    }

    public BrokenLine() {}

    public boolean addPoints(List<Point> points2){
        return points.addAll(points2);
    }

    public long lenghtBrokeLine(){
        long res = 0;
        for (int i = 0; i < points.size() - 1; i++){
            res += new Line(points.get(i), points.get(i+1)).lenghtLine();
        }
        return res;
    }

    @Override
    public String toString() {
        return "BrokenLine " + points;
    }
}

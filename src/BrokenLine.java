import java.util.Arrays;

public class BrokenLine {
    Point[] points;

    public BrokenLine(Point[] points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "BrokenLine " + Arrays.toString(points);
    }
}

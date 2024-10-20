import java.util.List;

public class ClosedPolyline extends Polyline{
    public ClosedPolyline(List<Point> points) {
        super(points);
    }

    public ClosedPolyline(Point... points) {
        super(points);
    }

    @Override
    public long lenghtPolyline() {
        if (points.size() < 3) return super.lenghtPolyline();
        return super.lenghtPolyline() + new Line(points.getFirst(), points.getLast()).lenghtLine();
    }
}

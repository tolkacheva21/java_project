public class Square extends Figure implements Lengthable, PolylineGetable{
    private int len1;

    public Square(Point2D point, int len1) {
        super(point);
        setLen1(len1);
    }

    public Square(int x, int y, int len1){
        this(new Point2D(x, y), len1);
    }

    public int getLen1() {
        return len1;
    }

    public void setLen1(int len1) {
        if (len1 <= 0) throw new IllegalArgumentException("len must be positive");
        this.len1 = len1;
    }

    @Override
    public Polyline getPolyline() {
        return isPointsSquare();
    }

    public Polyline isPointsSquare(){
        return new Polyline(super.pointStart, new Point2D(super.pointStart.x + len1, super.pointStart.y),
                new Point2D(super.pointStart.x + len1, super.pointStart.y - len1),
                new Point2D(super.pointStart.x - len1, super.pointStart.y));
    }

    @Override
    double figureArea() {
        return len1 * len1;
    }

    @Override
    public long lengthLine() {
        return ((ClosedPolyline)isPointsSquare()).lengthLine();
    }

    public String toString(){
        return "Квадрат в точке " + super.pointStart + " со стороной" + len1;
    }
}

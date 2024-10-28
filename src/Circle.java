public class Circle extends Figure{
    private int radius;

    public Circle(Point2D pointStart, int radius) {
        super(pointStart);
        setRadius(radius);
    }

    public void setRadius(int radius) {
        if (radius < 0) throw new IllegalArgumentException("radius must be positive");
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double figureArea() {
        return Math.PI*radius*radius;
    }
}

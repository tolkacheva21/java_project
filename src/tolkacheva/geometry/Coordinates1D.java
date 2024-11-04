package tolkacheva.geometry;

public class Coordinates1D extends Attribute{
    public Coordinates1D(int x) {
        super("tolkacheva.geometry.Coordinates1D", x);
    }

    public int getX(){
        return ((int)super.getValue());
    }
}

package tolkacheva.geometry;

public class Coordinates3D extends Attribute{
    public Coordinates3D(int x, int y, int z) {
        super("tolkacheva.geometry.Coordinates2D", new int[] {x, y, z});
    }

    public int getX(){
        return ((int[])super.getValue())[0];
    }

    public int getY(){
        return ((int[])super.getValue())[1];
    }

    public int getZ(){
        return ((int[])super.getValue())[2];
    }
}
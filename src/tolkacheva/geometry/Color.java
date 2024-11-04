package tolkacheva.geometry;

public class Color extends Attribute{
    public Color(String value) {
        super("tolkacheva.geometry.Color", value);
    }

    @Override
    public String getValue() {
        return super.getValue().toString();
    }
}

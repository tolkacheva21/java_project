public class Color extends Attribute{
    public Color(String value) {
        super("Color", value);
    }

    @Override
    public String getValue() {
        return super.getValue().toString();
    }
}

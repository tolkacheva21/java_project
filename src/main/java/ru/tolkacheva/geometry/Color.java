package ru.tolkacheva.geometry;

public class Color extends Attribute{
    public Color(String value) {
        super("ru.tolkacheva.geometry.Color", value);
    }

    @Override
    public String getValue() {
        return super.getValue().toString();
    }
}

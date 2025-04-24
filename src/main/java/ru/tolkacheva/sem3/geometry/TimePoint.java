package ru.tolkacheva.sem3.geometry;

public class TimePoint extends Attribute{
    public TimePoint(String value) {
        super("ru.tolkacheva.differentclasses.Time point", value);
    }

    @Override
    public String getValue(){
        return super.getValue().toString();
    }
}

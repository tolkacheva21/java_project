package tolkacheva.geometry;

public class TimePoint extends Attribute{
    public TimePoint(String value) {
        super("tolkacheva.differentclasses.Time point", value);
    }

    @Override
    public String getValue(){
        return super.getValue().toString();
    }
}

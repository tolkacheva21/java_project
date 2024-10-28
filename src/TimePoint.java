public class TimePoint extends Attribute{
    public TimePoint(String value) {
        super("Time point", value);
    }

    @Override
    public String getValue(){
        return super.getValue().toString();
    }
}

package tolkacheva.people;

public class RangeRule implements Cheker{
    int min;
    int max;

    public RangeRule(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean check(int mark) {
        return mark > min && mark < max;
    }
}

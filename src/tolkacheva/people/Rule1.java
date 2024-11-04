package tolkacheva.people;

public class Rule1 implements Cheker{
    @Override
    public boolean check(int mark){
        return mark >= 2;
    }
}

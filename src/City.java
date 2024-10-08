import java.util.Arrays;

public class City {
    String name;
    Way[] ways;

    public City(String name, Way[] ways) {
        this.name = name;
        this.ways = ways;
    }

    public City(String name) {
        this(name, null);
    }

    public String toString(){
        return name + " ways to " + Arrays.toString(ways);
    }
}

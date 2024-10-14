import java.util.ArrayList;
import java.util.List;

public class City {
    String name;
    private List<Way> ways;

    public City(String name, List<Way> ways) {
        this.name = name;
        this.ways = ways;
    }

    public City(String name) {
        this(name, null);
    }

    public List<Way> getWays() {
        return new ArrayList<>(ways);
    }

    public void setWays(List<Way> ways) {
        this.ways = new ArrayList<>(ways);
    }

    public void addWay(Way way){
        ways.add(way);
    }

    public Way removeWay(){
        return ways.removeLast();
    }

    public String toString(){
        return name + " ways to " + ways;
    }
}

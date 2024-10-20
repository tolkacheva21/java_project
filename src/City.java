import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class City {
    private String name;
    private List<Way> ways;

    public City(String name, List<Way> ways){
        this.name = name;
        this.ways = ways;
    }

    public City(String name, Way...ways) {
        this(name, Arrays.asList(ways));
    }

    public City(City city){
        this.name = city.getName();
        this.ways = city.getWays();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Way> getWays() {
        return new ArrayList<>(ways);
    }

    public boolean containsWay(City city){
        for (Way w : ways) {
            if (w.getToCity() == city) return true;
        }
        return false;
    }

    public void addWay(Way newWay){
        if (containsWay(newWay.getToCity())) return;
        ways.add(newWay);
    }

    public void addWay(City toCity, int price){
        addWay(new Way(toCity, price));
    }

    public void removeWay(Way way){
        if (!ways.contains(way)) return;
        ways.remove(way);
    }

    @Override
    public String toString(){
        String res = "";
        for (Way way : ways){
            res += way.getToCity().getName() + ": " + way.getPrice() +"\n";
        }
        return "City " + name + ":\n" + res;
    }
}

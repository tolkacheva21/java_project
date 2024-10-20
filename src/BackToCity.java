import java.util.List;

public class BackToCity extends City{
    public BackToCity(String name, List<Way> ways) {
        super(name, ways);
    }

    public void addWay(Way newWay, Way back){
        super.addWay(newWay);
        if (super.getWays().contains(back)) return;
        super.addWay(back);
    }

    public void addWay(City toCity, int price, City backCity){
        this.addWay(new Way(toCity, price), new Way(backCity, price));
    }
}

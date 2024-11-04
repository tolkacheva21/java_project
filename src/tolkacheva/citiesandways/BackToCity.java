package tolkacheva.citiesandways;

import java.util.List;

public class BackToCity extends City{
    public BackToCity(String name, List<Way> ways) {
        super(name, ways);
    }

    public BackToCity(String name, Way... ways) {
        super(name, ways);
    }

    @Override
    public void addWay(City city, int cost){
        super.addWay(city, cost);
        for (Way w: this.getWays()){
            if (this == w.getToCity()) return;
        }
        city.addWay(this, cost);
    }
}

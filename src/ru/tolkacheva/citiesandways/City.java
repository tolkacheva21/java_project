package ru.tolkacheva.citiesandways;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Way> getWays() {
        return new ArrayList<>(ways);
    }

    public void addWay(Way newWay){
        if (ways.contains(newWay)) return;
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
        return "ru.tolkacheva.citiesandways.City " + name + ":\n" + res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        return this.getWays().size() == city.getWays().size() && city.getWays().containsAll(this.getWays());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ways);
    }
}

package ru.tolkacheva.citiesandways;

import java.util.Objects;

public class Way {
    private final City toCity;
    private int price;

    public Way(City toCity, int price){
        this.toCity = toCity;
        this.price = price;
    }


    public City getToCity() {
        return toCity;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Way way = (Way) o;
        return price == way.price && toCity == way.toCity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toCity, price);
    }
}

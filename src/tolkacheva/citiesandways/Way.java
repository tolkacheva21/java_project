package tolkacheva.citiesandways;

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
}

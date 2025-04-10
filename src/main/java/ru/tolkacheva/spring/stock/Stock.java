package ru.tolkacheva.spring.stock;

public class Stock {
    private final String name;
    private int price;

    public Stock(String name, int price) {
        if (name.isBlank()) throw new IllegalArgumentException("name mustn't be empty");
        this.name = name;
        setPrice(price);
    }

    public void setPrice(int price) {
        if (price < 0) throw new IllegalArgumentException("price must be positive");
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

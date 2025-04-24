package ru.tolkacheva.sem3.temperature;

public class Temperature {
    private static Temperature instance;
    private String state;
    private int minTemp;
    private int maxTemp;

    private Temperature(int minTemp, int maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public static Temperature getInstance(int minTemp, int maxTemp){
        if (instance == null){
            instance = new Temperature(minTemp, maxTemp);
            if (minTemp == -50 && maxTemp == 10) {
                instance.state = "Холодно";
            } else if (minTemp == 10 && maxTemp == 25) {
                instance.state = "Нормально";
            } else if (minTemp == 25 && maxTemp == 60) {
                instance.state = "Жарко";
            } else {
                instance = null;
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "state='" + state + '\'' +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                '}';
    }
}

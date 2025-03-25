package ru.tolkacheva.trafficlight;

public class GreenLight implements State {
    static final State GREEN = new GreenLight();

    @Override
    public void next(TrafficLight tf) {
        tf.setState(YellowLight2.YELLOW2);
    }

    @Override
    public String getColor() {
        return "зеленый";
    }
}

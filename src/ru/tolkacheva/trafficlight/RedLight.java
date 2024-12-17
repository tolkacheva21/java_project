package ru.tolkacheva.trafficlight;

public class RedLight implements State {
    static final State RED = new RedLight();
    @Override
    public void next(TrafficLight tf) {
        tf.setState(YellowLight1.YELLOW1);
    }

    @Override
    public String getColor() {
        return "красный";
    }
}

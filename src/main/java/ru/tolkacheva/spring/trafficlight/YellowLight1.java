package ru.tolkacheva.spring.trafficlight;

public class YellowLight1 implements State {
    static final State YELLOW1 = new YellowLight1();
    @Override
    public void next(TrafficLight tf) {
        tf.setState(GreenLight.GREEN);
    }

    @Override
    public String getColor() {
        return "желтый";
    }
}

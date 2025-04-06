package ru.tolkacheva.spring.trafficlight;

public class YellowLight2 implements State{
    static final State YELLOW2 = new YellowLight2();
    @Override
    public void next(TrafficLight tf) {
        tf.setState(RedLight.RED);
    }

    @Override
    public String getColor() {
        return "желтый";
    }
}

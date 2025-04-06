package ru.tolkacheva.spring.trafficlight;

public interface State {
    void next(TrafficLight tf);
    String getColor();
}

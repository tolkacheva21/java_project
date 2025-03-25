package ru.tolkacheva.trafficlight;

public interface State {
    void next(TrafficLight tf);
    String getColor();
}

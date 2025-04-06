package ru.tolkacheva.spring.trafficlight;

public class TrafficLight {
    State state = GreenLight.GREEN;

    public void next(){
        System.out.println(state.getColor());
        state.next(this);
    }

    public void setState(State state){
        this.state = state;
    }
}

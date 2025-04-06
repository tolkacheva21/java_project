package ru.tolkacheva.spring.trafficlight;

public enum Light implements State{
    RED{
        @Override
        public void next(TrafficLight tf) {
            tf.setState(YELLOW1);
        }

        @Override
        public String getColor() {
            return "красный";
        }
    },
    YELLOW1{
        @Override
        public void next(TrafficLight tf) {
            tf.setState(GREEN);
        }

        @Override
        public String getColor() {
            return "желтый";
        }
    },
    GREEN{
        @Override
        public void next(TrafficLight tf) {
            tf.setState(YELLOW2);
        }

        @Override
        public String getColor() {
            return "зеленый";
        }
    },
    YELLOW2{
        @Override
        public void next(TrafficLight tf) {
            tf.setState(RED);
        }

        @Override
        public String getColor() {
            return "желтый";
        }
    }
}

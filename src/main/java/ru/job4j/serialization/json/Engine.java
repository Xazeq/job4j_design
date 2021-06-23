package ru.job4j.serialization.json;

public class Engine {
    private final int numberOfCylinders;
    private final double power;

    public Engine(int numberOfCylinders, double power) {
        this.numberOfCylinders = numberOfCylinders;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "numberOfCylinders=" + numberOfCylinders
                + ", power=" + power
                + '}';
    }
}

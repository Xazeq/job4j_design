package ru.job4j.serialization.json;

public class Engine {
    private int numberOfCylinders;
    private double power;

    public Engine() {

    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public double getPower() {
        return power;
    }

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

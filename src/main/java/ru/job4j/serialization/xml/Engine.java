package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "engine")
public class Engine {
    @XmlAttribute
    private  int numberOfCylinders;
    @XmlAttribute
    private  double power;

    public Engine() {

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

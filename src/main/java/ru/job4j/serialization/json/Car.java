package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Car {
    private final boolean is4WD;
    private final String manufacturer;
    private final int numberOfDoors;
    private final Engine engine;
    private final String[] options;

    public Car(boolean is4WD, String manufacturer, int numberOfDoors, Engine engine, String... options) {
        this.is4WD = is4WD;
        this.manufacturer = manufacturer;
        this.numberOfDoors = numberOfDoors;
        this.engine = engine;
        this.options = options;
    }

    @Override
    public String toString() {
        return "Car{"
                + "is4WD=" + is4WD
                + ", manufacturer='" + manufacturer + '\''
                + ", numberOfDoors=" + numberOfDoors
                + ", engine=" + engine
                + ", options=" + Arrays.toString(options)
                + '}';
    }

    public static void main(String[] args) {
        final Car car = new Car(true, "KIA", 4, new Engine(4, 149.5),
                "Leather seats", "Fog lights");
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));
        final String carJson =
                "{"
                    + "\"is4WD\":true,"
                    + "\"manufacturer\":\"KIA\","
                    + "\"numberOfDoors\":4,"
                    + "\"engine\":"
                        + "{"
                            + "\"numberOfCylinders\":4,"
                            + "\"power\":149.5"
                        + "},"
                    + "\"options\":"
                        + "[\"Leather seats\", \"Fog lights\"]"
                + "}";
        final Car carFromJson = gson.fromJson(carJson, Car.class);
        System.out.println(carFromJson);
    }
}

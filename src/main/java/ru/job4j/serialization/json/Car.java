package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.util.Arrays;

public class Car {
    private boolean is4WD;
    private String manufacturer;
    private int numberOfDoors;
    private Engine engine;
    private String[] options;

    public Car() {
    }

    public Car(boolean is4WD, String manufacturer, int numberOfDoors, Engine engine, String... options) {
        this.is4WD = is4WD;
        this.manufacturer = manufacturer;
        this.numberOfDoors = numberOfDoors;
        this.engine = engine;
        this.options = options;
    }

    public boolean isIs4WD() {
        return is4WD;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public Engine getEngine() {
        return engine;
    }

    public String[] getOptions() {
        return options;
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
        System.out.println("---------------------------------");
        //JSONObject из json-строки строки
        JSONObject jsonObjectFromString = new JSONObject(carJson);
        System.out.println(jsonObjectFromString);
        //JSONObject напрямую методом put
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("is4WD", car.isIs4WD());
        jsonObject.put("manufacturer", car.getManufacturer());
        jsonObject.put("numberOfDoors", car.getNumberOfDoors());
        jsonObject.put("engine", car.getEngine());
        jsonObject.put("options", car.getOptions());
        System.out.println(jsonObject);
        //car в json строку
        String jsonCar = new JSONObject(car).toString();
        System.out.println(jsonCar);
    }
}

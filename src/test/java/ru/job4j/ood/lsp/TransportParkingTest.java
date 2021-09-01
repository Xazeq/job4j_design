package ru.job4j.ood.lsp;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransportParkingTest {

    @Test
    public void whenAddCarToParking() {
        Parking parking = new TransportParking(4, 3);
        Transport car = new Car();
        assertTrue(parking.park(car));
    }

    @Test
    public void whenAddTruckToParking() {
        Parking parking = new TransportParking(2, 3);
        Transport truck = new Truck(3);
        assertTrue(parking.park(truck));
    }

    @Test
    public void whenAddCarAndTruckToParking() {
        Parking parking = new TransportParking(2, 4);
        Transport truck = new Truck(3);
        Transport car = new Car();
        assertTrue(parking.park(truck));
        assertTrue(parking.park(car));
    }

    @Test
    public void whenTruckOccupyCarPlace() {
        Parking parking = new TransportParking(4, 0);
        Transport truck = new Truck(3);
        assertTrue(parking.park(truck));
    }

    @Test
    public void whenNoPlaceToParkCar() {
        Parking parking = new TransportParking(1, 4);
        Transport car = new Car();
        Transport car2 = new Car();
        parking.park(car);
        assertFalse(parking.park(car2));
    }

    @Test
    public void whenNoPlaceToParkTruck() {
        Parking parking = new TransportParking(2, 0);
        Transport truck = new Truck(4);
        assertFalse(parking.park(truck));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenTransportSizeLessThen1() {
        Parking parking = new TransportParking(2, 2);
        Transport truck = new Truck(0);
        parking.park(truck);
    }
}
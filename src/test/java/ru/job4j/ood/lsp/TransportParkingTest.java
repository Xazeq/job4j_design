package ru.job4j.ood.lsp;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TransportParkingTest {

    /*@Ignore
    @Test
    public void whenAddCarToParking() {
        TransportParking parking = new TransportParking(4);
        Transport car = new Car();
        parking.park(car);
        assertThat(parking.getNumberOccupiedPlace(), is(1));
        assertThat(parking.getNumberAvailablePlace(), is(3));
    }

    @Ignore
    @Test
    public void whenAddTruckToParking() {
        TransportParking parking = new TransportParking(4);
        Transport truck = new Truck(3);
        parking.park(truck);
        assertThat(parking.getNumberOccupiedPlace(), is(3));
        assertThat(parking.getNumberAvailablePlace(), is(1));
    }

    @Ignore
    @Test
    public void whenAddCarAndTruckToParking() {
        TransportParking parking = new TransportParking(4);
        Transport truck = new Truck(3);
        Transport car = new Car();
        parking.park(truck);
        parking.park(car);
        assertThat(parking.getNumberOccupiedPlace(), is(4));
        assertThat(parking.getNumberAvailablePlace(), is(0));
    }

    @Ignore
    @Test
    public void whenNoPlaceToParkCar() {
        TransportParking parking = new TransportParking(1);
        Transport car = new Car();
        Transport car2 = new Car();
        parking.park(car);
        assertFalse(parking.park(car2));
    }

    @Ignore
    @Test
    public void whenNoPlaceToParkTruck() {
        TransportParking parking = new TransportParking(2);
        Transport truck = new Truck(4);
        assertFalse(parking.park(truck));
    }*/
}
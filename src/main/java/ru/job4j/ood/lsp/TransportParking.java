package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class TransportParking implements Parking {
    private int carsParkPlace;
    private int trucksParkPlace;
    private int occupiedCarPlace = 0;
    private int occupiedTruckPlace = 0;
    List<Transport> transports = new ArrayList<>();

    public TransportParking(int carParkPlace, int truckParkPlace) {
        this.carsParkPlace = carParkPlace;
        this.trucksParkPlace = truckParkPlace;
    }

    @Override
    public boolean park(Transport transport) {
        boolean result = false;
        if (transport.getSize() < 1) {
            throw new IllegalArgumentException("Размер транспорта меньше 1");
        } else if (transport.getSize() == 1) {
            if (carsParkPlace - occupiedCarPlace > 0) {
                transports.add(transport);
                occupiedCarPlace++;
                result = true;
            }
        } else {
            if (trucksParkPlace - occupiedTruckPlace > 0) {
                transports.add(transport);
                occupiedTruckPlace++;
                result = true;
            } else if (transport.getSize() <= carsParkPlace - occupiedCarPlace) {
                transports.add(transport);
                occupiedCarPlace += transport.getSize();
                result = true;
            }
        }
        return result;
    }

}

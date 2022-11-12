package org.jetbrains.station;

import org.jetbrains.car.Car;
import org.jetbrains.location.Location;
import org.jetbrains.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class StationsPool {

    private static StationsPool stations;
    private final List<Station> gasStations = new ArrayList<>();
    private final List<Station> chargingStations = new ArrayList<>();

    public static StationsPool getInstance() {
        if (stations == null) {
            stations = new StationsPool();
        }
        return stations;
    }

    private StationsPool() {
        // Add gas stations
        gasStations.add(new GasStation(1, new Location(10, 10)));
        gasStations.add(new GasStation(2, new Location(10, 25)));
        gasStations.add(new GasStation(3, new Location(10, 45)));
        gasStations.add(new GasStation(4, new Location(10, 67)));
        gasStations.add(new GasStation(5, new Location(10, 77)));
        gasStations.add(new GasStation(6, new Location(10, 89)));
        gasStations.add(new GasStation(7, new Location(10, 97)));
        // Add charging stations
        chargingStations.add(new ChargingStation(8, new Location(10, 15)));
        chargingStations.add(new ChargingStation(9, new Location(10, 35)));
        chargingStations.add(new ChargingStation(10, new Location(10, 47)));
        chargingStations.add(new ChargingStation(11, new Location(10, 59)));
        chargingStations.add(new ChargingStation(12, new Location(10, 70)));
        chargingStations.add(new ChargingStation(13, new Location(10, 86)));
        chargingStations.add(new ChargingStation(14, new Location(10, 96)));
    }

    public ChargingStation getClosestChargingStation(Car car) {
        return (ChargingStation) getClosestStation(car, this.chargingStations);
    }

    public GasStation getClosestGasStation(Car car) {
        return (GasStation) getClosestStation(car, this.gasStations);
    }

    private Station getClosestStation(Car car, List<Station> stations) {
        if (stations.size() == 0) {
            throw new IllegalArgumentException(Utils.EXCEPTION_NO_STATIONS);
        }
        double minDestination = car.getLocation().distanceTo(stations.get(0).getLocation());
        Station closestChargingStation = stations.get(0);
        for (Station chargingStation : stations) {
            double destination = car.getLocation().distanceTo(chargingStation.getLocation());
            if (destination < minDestination) {
                closestChargingStation = chargingStation;
                minDestination = destination;
            }
        }
        return closestChargingStation;
    }
}

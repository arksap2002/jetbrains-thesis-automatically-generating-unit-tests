package org.jetbrains.person;

import org.jetbrains.car.Car;
import org.jetbrains.car.ElectricCar;
import org.jetbrains.location.Location;
import org.jetbrains.station.ChargingStation;
import org.jetbrains.station.GasStation;
import org.jetbrains.station.StationsPool;
import org.jetbrains.utils.Utils;

public class Person {

    private final int age;
    private final Location homeLocation;
    private final Location workLocation;

    private Car car;


    public Person(int age, Location homeLocation, Location workLocation, Car car) {
        this.age = age;
        this.homeLocation = homeLocation;
        this.workLocation = workLocation;
        if (car == null) {
            throw new IllegalArgumentException(Utils.EXCEPTION_EMPTY_CAR);
        }
        this.car = car;
    }

    public void goToWork() {
        drive(workLocation);
    }

    public void goToHome() {
        drive(homeLocation);
    }

    private void drive(Location destinationLocation) {
        if (this.age < Utils.MIN_AGE_FOR_DRIVING) {
            System.out.println(Utils.TOO_YOUNG_TO_DRIVE_MESSAGE);
            return;
        }
        if (car.needsEnergy(destinationLocation)) {
            System.out.println(Utils.NEEDS_ENERGY_MESSAGE);
            addEnergy();
        }
        System.out.println(Utils.DRIVE_MESSAGE(destinationLocation, car.getLocation(), car.getEnergyValue()));
        car.driveTo(destinationLocation);
    }

    protected void addEnergy() {
        Location destination;
        if (car instanceof ElectricCar) {
            ChargingStation chargingStation = StationsPool.getInstance().getClosestChargingStation(car);
            destination = chargingStation.getLocation();
        } else {
            GasStation gasStation = StationsPool.getInstance().getClosestGasStation(car);
            destination = gasStation.getLocation();
        }
        car.refuel();
        System.out.println(Utils.DRIVE_MESSAGE(destination, car.getLocation(), car.getEnergyValue()));
        car.driveTo(destination);
    }

    public void changeCar(Car car) {
        this.car = car;
    }
}

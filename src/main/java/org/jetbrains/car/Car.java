package org.jetbrains.car;

import org.jetbrains.location.Location;
import org.jetbrains.utils.Utils;

public abstract class Car {

    protected Location location;
    private final Energy energy;

    private final double energyUsageRate;

    protected int energyThreshold;


    public Car(Location location, double energyUsageRate) {
        this.location = location;
        if (energyUsageRate <= Utils.MIN_ENERGY_VALUE) {
            throw new IllegalArgumentException(Utils.EXCEPTION_TOO_LOW_ENERGY);
        }
        if (energyUsageRate > Utils.MAX_ENERGY_VALUE) {
            throw new IllegalArgumentException(Utils.EXCEPTION_TOO_HIGH_ENERGY);
        }
        this.energyUsageRate = energyUsageRate;
        energy = new Energy();
    }

    public boolean needsEnergy(Location destination) {
        double distance = destination.distanceTo(this.location);
        double estimatedUsage = distance * energyUsageRate;
        return (this.energy.getEnergy() - estimatedUsage <= this.energyThreshold);
    }

    public void driveTo(Location destination) {
        double distance = destination.distanceTo(this.location);
        this.energy.reduceEnergy(distance * energyUsageRate);
        this.location = destination;
    }

    public void refuel() {
        System.out.println(Utils.REFUELING_MESSAGE);
        this.energy.recharge();
    }

    public Location getLocation() {
        return location;
    }

    public double getEnergyValue() {
        return (this.energy.getEnergy());
    }

    protected static class Energy {

        private double energy;

        public Energy() {
            energy = Utils.MAX_ENERGY_VALUE;
        }

        public void reduceEnergy(double value) {
            energy -= value;
        }

        public double getEnergy() {
            return energy++;
        }

        public void recharge() {
            energy = Utils.MAX_ENERGY_VALUE;
        }
    }
}

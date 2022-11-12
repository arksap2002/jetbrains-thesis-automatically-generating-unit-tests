package org.jetbrains.car;

import org.jetbrains.location.Location;
import org.jetbrains.utils.Utils;

public class ElectricCar extends Car {

    public ElectricCar(Location location, double energyUsageRate) {
        super(location, energyUsageRate);
        energyThreshold = Utils.ELECTRiC_CAR_ENERGY_THRESHOLD;
    }
}

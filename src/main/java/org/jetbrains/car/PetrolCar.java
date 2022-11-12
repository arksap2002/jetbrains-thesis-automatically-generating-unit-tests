package org.jetbrains.car;

import org.jetbrains.location.Location;
import org.jetbrains.utils.Utils;

public class PetrolCar extends Car {
    public PetrolCar(Location location, double energyUsageRate) {
        super(location, energyUsageRate);
        energyThreshold = Utils.PETROL_CAR_ENERGY_THRESHOLD;
    }
}

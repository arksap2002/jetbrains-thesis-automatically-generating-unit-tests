package org.jetbrains.utils;

import org.jetbrains.location.Location;

public class Utils {
    public static final int MIN_ENERGY_VALUE = 0;
    public static final int MAX_ENERGY_VALUE = 100;
    public static final int ELECTRiC_CAR_ENERGY_THRESHOLD = 40;
    public static final int PETROL_CAR_ENERGY_THRESHOLD = 20;
    public static final int MIN_AGE_FOR_DRIVING = 18;
    public static final String EXCEPTION_TOO_LOW_ENERGY = "energy usage rate should be higher than " + MIN_ENERGY_VALUE + ".";
    public static final String EXCEPTION_TOO_HIGH_ENERGY = "energy usage rate should be lower than " + MAX_ENERGY_VALUE + ".";
    public static final String EXCEPTION_EMPTY_CAR = "Car is empty";
    public static final String EXCEPTION_NO_STATIONS = "there are no stations.";
    public static final String REFUELING_MESSAGE = "Refueling";
    public static final String TOO_YOUNG_TO_DRIVE_MESSAGE = "This person is too young to drive!";
    public static final String NEEDS_ENERGY_MESSAGE = "Needs energy";

    public static String DRIVE_MESSAGE(Location destinationLocation, Location carLocation, double energy) {
        return "Drive to " + destinationLocation + ". Current location " + carLocation + ". Energy " + energy;
    }
}

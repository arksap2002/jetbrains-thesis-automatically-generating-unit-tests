package org.jetbrains.utils;

public class Utils {
    public static final int MIN_ENERGY_VALUE = 0;
    public static final int MAX_ENERGY_VALUE = 100;
    public static final int ELECTRiC_CAR_ENERGY_THRESHOLD = 40;
    public static final int PETROL_CAR_ENERGY_THRESHOLD = 20;
    public static final String EXCEPTION_TOO_LOW_ENERGY = "energy usage rate should be higher than " + MIN_ENERGY_VALUE + ".";
    public static final String EXCEPTION_TOO_HIGH_ENERGY = "energy usage rate should be lower than " + MAX_ENERGY_VALUE + ".";
    public static final String EXCEPTION_NO_STATIONS = "there are no stations.";
    public static final String REFUELING_MESSAGE = "Refueling";
}

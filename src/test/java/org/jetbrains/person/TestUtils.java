package org.jetbrains.person;

import org.jetbrains.location.Location;
import org.jetbrains.utils.Utils;

import java.util.Random;

public class TestUtils {
    public static final int ITERATIONS = 1000;
    public static final int MAX_AGE = 100;
    static Random random = new Random();

    public static Location getRandomLocation() {
        double LOCATION_BORDER = 1000;
        return new Location(random.nextDouble() * 2 * LOCATION_BORDER - LOCATION_BORDER, random.nextDouble() * 2 * LOCATION_BORDER - LOCATION_BORDER);
    }

    public static int getRandomEnergy() {
        return random.nextInt(2 * Utils.MAX_ENERGY_VALUE - 2 * Utils.MIN_ENERGY_VALUE) - 2 * Utils.MIN_ENERGY_VALUE;
    }

    public static int getCorrectRandomEnergy() {
        return random.nextInt(Utils.MAX_ENERGY_VALUE - Utils.MIN_ENERGY_VALUE - 1) + Utils.MIN_ENERGY_VALUE + 1;
    }
}

package org.jetbrains.person;


import org.jetbrains.car.Car;
import org.jetbrains.car.ElectricCar;
import org.jetbrains.car.PetrolCar;
import org.jetbrains.location.Location;
import org.jetbrains.utils.Utils;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @RepeatedTest(TestUtils.ITERATIONS)
    void badInitTest() {
        int energy = TestUtils.getRandomEnergy();
        if (energy <= 0 || energy > 100) {
            assertThrows(IllegalArgumentException.class, () -> {
                new ElectricCar(TestUtils.getRandomLocation(), energy);
                new PetrolCar(TestUtils.getRandomLocation(), energy);
            });
        } else {
            assertDoesNotThrow(() -> {
                new ElectricCar(TestUtils.getRandomLocation(), energy);
                new PetrolCar(TestUtils.getRandomLocation(), energy);
            });
        }
    }

    @RepeatedTest(TestUtils.ITERATIONS)
    void driveToTest() {
        int energy = TestUtils.getCorrectRandomEnergy();
        Car car = new ElectricCar(TestUtils.getRandomLocation(), energy);
        Location location = TestUtils.getRandomLocation();
        car.driveTo(location);
        assertTrue(energy > car.getEnergyValue());
        assertEquals(location, car.getLocation());
    }

    @RepeatedTest(TestUtils.ITERATIONS)
    void refuelTest() {
        Car car = new ElectricCar(TestUtils.getRandomLocation(), TestUtils.getCorrectRandomEnergy());
        car.refuel();
        assertEquals(Utils.MAX_ENERGY_VALUE, car.getEnergyValue());
    }
}

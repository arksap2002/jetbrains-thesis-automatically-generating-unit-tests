package org.jetbrains.person;


import org.jetbrains.car.Car;
import org.jetbrains.car.PetrolCar;
import org.jetbrains.location.Location;
import org.jetbrains.utils.Utils;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PersonTest {

    @RepeatedTest(TestUtils.ITERATIONS)
    void goToWorkTest() {
        int age = TestUtils.random.nextInt(TestUtils.MAX_AGE);
        Location homeLocation = TestUtils.getRandomLocation();
        Location workLocation = TestUtils.getRandomLocation();
        Car car = new PetrolCar(homeLocation, TestUtils.getCorrectRandomEnergy());
        Person person = new Person(age, homeLocation, workLocation, car);
        person.goToWork();
        if (age < Utils.MIN_AGE_FOR_DRIVING) {
            assertEquals(homeLocation, car.getLocation());
        } else {
            assertEquals(workLocation, car.getLocation());
        }
    }

    @RepeatedTest(TestUtils.ITERATIONS)
    void goToHomeTest() {
        int age = TestUtils.random.nextInt();
        Location homeLocation = TestUtils.getRandomLocation();
        Location workLocation = TestUtils.getRandomLocation();
        Car car = new PetrolCar(workLocation, TestUtils.getCorrectRandomEnergy());
        Person person = new Person(age, homeLocation, workLocation, car);
        person.goToHome();
        if (age < Utils.MIN_AGE_FOR_DRIVING) {
            assertEquals(workLocation, car.getLocation());
        } else {
            assertEquals(homeLocation, car.getLocation());
        }
    }

    @RepeatedTest(TestUtils.ITERATIONS)
    void addEnergyTest() {
        int age = TestUtils.random.nextInt(TestUtils.MAX_AGE);
        Location homeLocation = TestUtils.getRandomLocation();
        Location workLocation = TestUtils.getRandomLocation();
        Car car = new PetrolCar(workLocation, TestUtils.getCorrectRandomEnergy());
        Person person = new Person(age + 18, homeLocation, workLocation, car);
        person.addEnergy();
        assertNotEquals(Utils.MAX_ENERGY_VALUE, car.getEnergyValue());
    }

    @RepeatedTest(TestUtils.ITERATIONS)
    void changeCarTest() {
        int age = TestUtils.random.nextInt(TestUtils.MAX_AGE);
        Location homeLocation = TestUtils.getRandomLocation();
        Location workLocation = TestUtils.getRandomLocation();
        Car first_car = new PetrolCar(workLocation, TestUtils.getCorrectRandomEnergy());
        Car second_car = new PetrolCar(workLocation, TestUtils.getCorrectRandomEnergy());
        Person person = new Person(age + 18, homeLocation, workLocation, first_car);
        person.goToWork();
        person.changeCar(second_car);
        person.goToHome();
        assertEquals(workLocation, first_car.getLocation());
        assertEquals(homeLocation, second_car.getLocation());
    }

    @Test
    void testPerson() {
        Car car = new PetrolCar(new Location(0, 10), 2);
        Person person = new Person(19, new Location(0, 10.1), new Location(0, 46.10), car);
        person.goToWork();
        person.goToHome();
        person.goToWork();
        person.goToHome();
        person.goToWork();

        assert (car.getEnergyValue() > 0 && car.getEnergyValue() <= 100);
    }
}

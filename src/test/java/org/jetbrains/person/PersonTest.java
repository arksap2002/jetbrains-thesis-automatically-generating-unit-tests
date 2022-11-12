package org.jetbrains.person;


import org.jetbrains.car.Car;
import org.jetbrains.car.PetrolCar;
import org.jetbrains.location.Location;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void driveTest() {
        Car car = new PetrolCar(TestUtils.getRandomLocation(), TestUtils.getCorrectRandomEnergy());
        Person person = new Person(TestUtils.random.nextInt(100), TestUtils.getRandomLocation(), TestUtils.getRandomLocation(), car);
    }

    @Test
    void goToWorkTest() {
    }

    @Test
    void goToHomeTest() {
    }

    @Test
    void addEnergyTest() {
    }

    @Test
    void changeCarTest() {
    }

    @Test
    void commonTest() {
    }

    @Test
    void testPerson() {
        Car car = new PetrolCar(new Location(10, 10), 2);
        Person person = new Person(19, new Location(10, 10.1), new Location(10, 46.10), car);
        person.goToWork();
        person.goToHome();
        person.goToWork();
        person.goToHome();
        person.goToWork();

        assert (car.getEnergyValue() > 0 && car.getEnergyValue() <= 100);
    }
}

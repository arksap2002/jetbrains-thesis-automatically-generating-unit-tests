package org.jetbrains.person;


import org.jetbrains.car.Car;
import org.jetbrains.car.PetrolCar;
import org.jetbrains.location.Location;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CommonTest {

    @RepeatedTest(TestUtils.ITERATIONS)
    void commonTest() {
        int age = TestUtils.random.nextInt(TestUtils.MAX_AGE);
        Location homeLocation = TestUtils.getRandomLocation();
        Location workLocation = TestUtils.getRandomLocation();
        Car car = new PetrolCar(homeLocation, TestUtils.getCorrectRandomEnergy());
        Person person = new Person(age + 18, homeLocation, workLocation, car);
        for (int i = 0; i < TestUtils.ITERATIONS / 10; i++) {
            assertEquals(homeLocation, car.getLocation());
            person.goToWork();
            assertEquals(workLocation, car.getLocation());
            person.goToHome();
        }
    }
}

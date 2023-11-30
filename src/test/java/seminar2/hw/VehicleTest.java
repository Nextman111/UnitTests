package seminar2.hw;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    public void setup() {
        car = new Car(
                "CarCompany",
                "CarModel",
                2000
        );

        motorcycle = new Motorcycle(
                "MotoCompany",
                "MotoModel",
                2000
        );
    }


    @AfterEach
    public void teardown() {
        car = null;
        motorcycle = null;
    }


    /**
     * - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
     */
    @Test
    @DisplayName("Car instance of Vehicle")
    public void carInstanceOfVehicleTest() {
        assertTrue(car instanceof Vehicle);
    }

    /**
     * - доп. проверка без создания экземпляра класса Car
     */
    @Test
    @DisplayName("Car is assignable from Vehicle")
    public void carIsAssignableFromVehicleTest() {
        assertTrue(Vehicle.class.isAssignableFrom(Car.class));
    }

    /**
     * проверка того, объект Car создается с 4-мя колесами
     */
    @Test
    @DisplayName("Car и 4 колеса")
    public void carWithFourWheelsTest() {
        // класс Car не имеет возможности изменения numWheels в конструкторе, так же не имеет сеттера
        assertTrue(car.getNumWheels() == 4);
    }

    /**
     * проверка того, объект Car создается не с 4-мя колесами
     */
    @Test
    @DisplayName("Car и не 4 колеса")
    public void carWithNoFourWheelsTest() {
        // класс Car не имеет возможности изменения numWheels в конструкторе, так же не имеет сеттера
        assertFalse(car.getNumWheels() != 4);
    }

    /** проверка того, объект Motorcycle создается с 2-мя колесами */
    @Test
    @DisplayName("Motorcycle и 2 колеса")
    public void motorcysleWithFourWheelsTest() {
        // класс Motorcycle не имеет возможности изменения numWheels в конструкторе, так же не имеет сеттера
        assertTrue(motorcycle.getNumWheels() == 2);
    }
    /** проверка того, объект Motorcycle создается не с 2-мя колесами */
    @Test
    @DisplayName("Motorcycle и не 2 колеса")
    public void motorcysleWithNoFourWheelsTest() {
        // класс Motorcycle не имеет возможности изменения numWheels в конструкторе, так же не имеет сеттера
        assertFalse(motorcycle.getNumWheels() != 2);
    }

    /** - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
     */
    @Test
    @DisplayName("Car.testDrive скорость 60")
    public void carTestDriveTest() {
        car.testDrive();
        assertTrue(car.getSpeed() == 60);
    }

    /** - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
     */
    @Test
    @DisplayName("Car.testDrive скорость не 60")
    public void carTestDriveFalseTest() {
        car.testDrive();
        assertFalse(car.getSpeed() != 60);
    }


     /** - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
     */
     @Test
     @DisplayName("Motorcycle.testDrive скорость 75")
     public void motorcycleTestDriveTest() {
         motorcycle.testDrive();
         assertTrue(motorcycle.getSpeed() == 75);
     }

    /** - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
     */
    @Test
    @DisplayName("Motorcycle.testDrive скорость не 75")
    public void motorcycleTestDriveFalseTest() {
        motorcycle.testDrive();
        assertFalse(motorcycle.getSpeed() != 75);
    }


    /** - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
     */
    @Test
    @DisplayName("Car.testPark")
    public void carTestParkTest() {
        car.testDrive();
        var speedDrive = car.getSpeed();
        car.park();
        var speedPark = car.getSpeed();
        assertTrue(speedDrive > 0 && speedPark == 0);
    }

    /** - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина не останавливается (speed = 0)
     */
    @Test
    @DisplayName("Car.testPark speed != 0")
    public void carTestParkFalseTest() {
        car.testDrive();
        var speedDrive = car.getSpeed();
        car.park();
        var speedPark = car.getSpeed();
        assertFalse(speedDrive <= 0 && speedPark != 0);
    }


    /** - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
     */
    @Test
    @DisplayName("Motorcycle.testPark")
    public void motorcycleTestParkTest() {
        motorcycle.testDrive();
        var speedDrive = motorcycle.getSpeed();
        motorcycle.park();
        var speedPark = motorcycle.getSpeed();
        assertTrue(speedDrive > 0 && speedPark == 0);
    }

    /** - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина не останавливается (speed = 0)
     */
    @Test
    @DisplayName("Motorcycle.testPark speed != 0")
    public void motorcycleTestParkFalseTest() {
        motorcycle.testDrive();
        var speedDrive = motorcycle.getSpeed();
        motorcycle.park();
        var speedPark = motorcycle.getSpeed();
        assertFalse(speedDrive <= 0 && speedPark != 0);
    }

}
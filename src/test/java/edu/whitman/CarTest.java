package edu.whitman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

public class CarTest {

    private ICar car;

    @BeforeEach
    void setUp() {
        // Initialize the Car object with a unique ID before each test
        car = new Car(1);
    }

    @Test
    void testStartEngine() {
        car.startEngine();
        assertTrue(car.isEngineRunning());
    }

    @Test
    void testDriveWithEngineRunning() {
        car.startEngine();
        car.drive();
        assertTrue(car.isDriving());
    }

    @Test
    void testDriveWithoutStartingEngine() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            car.drive();
        });
    }

    @Test
    void testStop() {
        car.startEngine();
        car.drive();
        car.stop();
        assertFalse(car.isDriving());
        assertFalse(car.isEngineRunning());
    }

    @Test
    void testStopEngineWhileDriving() {
        car.startEngine();
        car.drive();
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            car.stopEngine();
        });
    }

    @Test
    void testStopEngineWhenNotDriving() {
        car.startEngine();
        car.stopEngine();
        assertFalse(car.isEngineRunning());
    }

    @Test
    void testGetId() {
        assertEquals(1, car.getId());
    }
}

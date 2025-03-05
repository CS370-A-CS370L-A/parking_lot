package edu.whitman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

public class ParkingLotTest {
    private IParkingLot parkingLot;
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    public void setUp() {
        parkingLot = new ParkingLot(2);  // Create a parking lot with a capacity of 2
        car1 = new Car(1);  // Create car with ID 1
        car2 = new Car(2);  // Create car with ID 2
        car3 = new Car(3);  // Create car with ID 3
    }

    @Test
    public void testAddCar() {
        parkingLot.addCar(car1);
        assertTrue(parkingLot.checkAvailability());  // There should still be space
        parkingLot.addCar(car2);
        assertFalse(parkingLot.checkAvailability());  // No more space after adding 2 cars
    }

    @Test
    public void testAddCarWhenParkingLotIsFull() {
         assertThrows(IllegalStateException.class, () -> {
            parkingLot.addCar(car1);
            parkingLot.addCar(car2);
            parkingLot.addCar(car3); 
        });   
    }

    @Test
    public void testRemoveCar() {
        parkingLot.addCar(car1);
        parkingLot.addCar(car2);
        parkingLot.removeCar(car1);  // Remove car1
        assertTrue(parkingLot.checkAvailability());  // There should be space after removal
        assertEquals(1, parkingLot.getAvailableSpaces());  // One space should be available
    }

    @Test
    public void testRemoveCarThatDoesNotExist() {
        assertThrows(IllegalStateException.class, () -> {
             parkingLot.addCar(car1);
             parkingLot.removeCar(car2); 
        }); 
    }

    @Test
    public void testGetAvailableSpaces() {
        parkingLot.addCar(car1);
        assertEquals(1, parkingLot.getAvailableSpaces());  // One space should be available
        parkingLot.addCar(car2);
        assertEquals(0, parkingLot.getAvailableSpaces());  // No spaces left
    }

    @Test
    public void testCheckAvailability() {
        assertTrue(parkingLot.checkAvailability());  // Parking lot should be available initially
        parkingLot.addCar(car1);
        parkingLot.addCar(car2);
        assertFalse(parkingLot.checkAvailability());  // No availability when parking lot is full
    }
}

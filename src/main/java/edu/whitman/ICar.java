package edu.whitman;

public interface ICar {
    // Returns the unique ID of the car
    int getId();
    
    // Starts the engine of the car
    void startEngine();
    
    // Starts driving the car (requires the engine to be running)
    void drive();
    
    // Stops driving the car and turns off the engine
    void stop();
    
    // Stops the engine (but only if the car is not driving)
    void stopEngine();
    
    // Returns whether the engine is running
    boolean isEngineRunning();
    
    // Returns whether the car is driving
    boolean isDriving();
}

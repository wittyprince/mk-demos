package com.mk.demos.mapstruct;

/**
 * Car
 *
 * @author WangChen
 * Created on 2021/7/22 13:41
 * @since 0.1
 */
public class Car {

    private String make;
    private int numberOfSeats;
    private CarType type;

    public Car() {
    }

    public Car(String make, int numberOfSeats, CarType type) {
        this.make = make;
        this.numberOfSeats = numberOfSeats;
        this.type = type;
    }

    //constructor, getters, setters etc.
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }
}

package com.example.design_patterns.creational.abstract_factory;

public abstract class Bike implements Vehicle {

    String bikeType;
    int baseCost;
    int chargesPerUnitDistance;

    @Override
    public void book(int distance) {
        setVehicleType();
        setBaseCost();
        setVehicleChargesPerUnitDistance();
        int cost = calculateCostOfBooking(distance);
        System.out.println("You have booked a " + bikeType + " Bike for a distance of " + distance + "km at a local cost of " + cost + ". ");
    }

    @Override
    public int calculateCostOfBooking(int distance) {
        return baseCost + chargesPerUnitDistance * distance;
    }
}

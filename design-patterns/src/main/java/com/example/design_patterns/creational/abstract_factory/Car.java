package com.example.design_patterns.creational.abstract_factory;

import java.util.HashMap;
import java.util.Map;

public abstract class Car implements Vehicle {

    String carType;
    int baseCost;
    int chargesPerUnitDistance;

    @Override
    public void book(int distance) {
        setVehicleType();
        setBaseCost();
        setVehicleChargesPerUnitDistance();
        int cost = calculateCostOfBooking(distance);
        System.out.println("You have booked a " + carType + " Car for a distance of " + distance + "km at a total cost of " + cost + ". ");
    }

    @Override
    public int calculateCostOfBooking(int distance) {
        int serviceCharge = 3;
        return baseCost + chargesPerUnitDistance * distance + serviceCharge;
    }
}

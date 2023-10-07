package com.example.design_patterns.creational.abstract_factory;

public interface Vehicle {

    void book(int distance);

    void setVehicleType();

    void setBaseCost();

    void setVehicleChargesPerUnitDistance();

    int calculateCostOfBooking(int distance);
}

package com.example.design_patterns.creational.abstract_factory;

public class SportsBike extends Bike {

    public SportsBike() {}

    @Override
    public void setVehicleType() {
        bikeType = "Sports";
    }

    @Override
    public void setBaseCost() {
        baseCost = 40;
    }

    @Override
    public void setVehicleChargesPerUnitDistance() {
        chargesPerUnitDistance = 15;
    }
}

package com.example.design_patterns.creational.abstract_factory;

public class MegaCar extends Car {

    public MegaCar() {}

    @Override
    public void setVehicleType() {
        carType = "Mega";
    }

    @Override
    public void setBaseCost() {
        baseCost = 150;
    }

    @Override
    public void setVehicleChargesPerUnitDistance() {
        chargesPerUnitDistance = 30;
    }
}

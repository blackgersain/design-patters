package com.example.design_patterns.creational.abstract_factory;

public class AutoFactory extends AbstractVehicleFactory {
    @Override
    public Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("Personal")) {
            return new PersonalAuto();
        }
        else if (type.equalsIgnoreCase("Shared")) {
            return new SharedAuto();
        }
        else {
            return new PersonalAuto();
        }
    }
}

package service.criteria;

public class SearchCriteria {
    public static enum Oven{
    powerConsumption, weight, capacity, depth, width
    }
    public static enum Laptop{
        batteryConsumption, os, memoryRom, systemMemory, cpu, displayInches
    }
    public static enum Fridge{
        manufacturer, construction, height, width, color, energyConsumptionClass
    }
    public static enum Tablet{
        batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color
    }
    public static enum Teapot{
        volumeInLiters, material, teaCompartment, maxTemperature
    }
    public static enum VacuumCleaner{
        type, suctionPower, pipeLength, powerAdjustment
    }
}

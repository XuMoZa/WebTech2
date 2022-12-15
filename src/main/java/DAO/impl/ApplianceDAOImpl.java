package DAO.impl;

import DAO.IApplianceDAO;
import entity.*;

import java.util.HashMap;
import java.util.List;

public class ApplianceDAOImpl implements IApplianceDAO {

    final HashMap<String, List<Appliance>> appliancesMap;

    public ApplianceDAOImpl(HashMap<String, List<Appliance>> appliances){
        this.appliancesMap = appliances;
    }

    @Override
    public Appliance findCheapestAppliance() {
        var targetItem = new Object(){
            double minPrice = Double.MAX_VALUE;
            Appliance cheapestAppliance = null;
        };

        appliancesMap.forEach((key, value) -> value.forEach(item -> {
            if (item instanceof Fridge fridge){
                if (fridge.getPrice() < targetItem.minPrice){
                    targetItem.minPrice = fridge.getPrice();
                    targetItem.cheapestAppliance = fridge;
                }
            } else if (item instanceof Laptop laptop) {
                if (laptop.getPrice() < targetItem.minPrice){
                    targetItem.minPrice = laptop.getPrice();
                    targetItem.cheapestAppliance = laptop;
                }
            } else if (item instanceof Oven oven) {
                if (oven.getPrice() < targetItem.minPrice){
                    targetItem.minPrice = oven.getPrice();
                    targetItem.cheapestAppliance = oven;
                }
            } else if (item instanceof Tablet tablet) {
                if (tablet.getPrice() < targetItem.minPrice){
                    targetItem.minPrice = tablet.getPrice();
                    targetItem.cheapestAppliance = tablet;
                }
            } else if (item instanceof Teapot teapot) {
                if (teapot.getPrice() < targetItem.minPrice){
                    targetItem.minPrice = teapot.getPrice();
                    targetItem.cheapestAppliance = teapot;
                }
            } else if (item instanceof VacuumCleaner vacuumCleaner) {
                if (vacuumCleaner.getPrice() < targetItem.minPrice){
                    targetItem.minPrice = vacuumCleaner.getPrice();
                    targetItem.cheapestAppliance = vacuumCleaner;
                }
            }
        }));

        return targetItem.cheapestAppliance;
    }

    @Override
    public List<Appliance> findAppliancesByType(String type) {
        return appliancesMap.get(type);
    }

}

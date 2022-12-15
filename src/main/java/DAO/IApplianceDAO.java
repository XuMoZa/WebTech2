package DAO;

import entity.Appliance;

import java.util.List;

public interface IApplianceDAO {
    Appliance findCheapestAppliance();

    List<Appliance> findAppliancesByType(String type);
}

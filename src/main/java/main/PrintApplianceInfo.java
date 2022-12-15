package main;

import DAO.IApplianceDAO;
import DAO.impl.ApplianceDAOImpl;
import service.database.DatabaseLoader;


public class PrintApplianceInfo {

    private final  IApplianceDAO applianceDAO;

    public PrintApplianceInfo(IApplianceDAO applianceDAO){
        this.applianceDAO = applianceDAO;
    }
    public static void printCheapestAppliance(){
        PrintApplianceInfo printInfo = new PrintApplianceInfo(new ApplianceDAOImpl(DatabaseLoader.LoadFromDB()));
        System.out.println("Cheapest appliance = " + printInfo.applianceDAO.findCheapestAppliance());
    }

    public static void printAllAppliancesByType(){
        PrintApplianceInfo printInfo = new PrintApplianceInfo(new ApplianceDAOImpl(DatabaseLoader.LoadFromDB()));
        printInfo.applianceDAO.findAppliancesByType("Teapot").forEach(appliance -> System.out.println("Appliance = " + appliance));
    }
}

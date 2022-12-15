package service.database;

import DAO.IApplianceDAO;
import entity.*;
import service.AppliancesFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class DatabaseLoader {

    private static final String DB_PATH = "./src/main/resources/DB.xml";
    private static final Path path = Paths.get(DB_PATH);

    public static HashMap<String, List<Appliance>> LoadFromDB(){
        String dbData = readDataFromFile();   //read xml DB to String
        HashMap<String, List<String>> dividedAppliances = mapStringByApplianceTypes(dbData);
        HashMap<String, List<Appliance>> appliancesMap = new HashMap<>();
        appliancesMap.put("Oven", AppliancesFactory.createAppliances(new Oven(), dividedAppliances.get("Oven")));
        appliancesMap.put("Laptop", AppliancesFactory.createAppliances(new Laptop(), dividedAppliances.get("Laptop")));
        appliancesMap.put("Fridge", AppliancesFactory.createAppliances(new Fridge(), dividedAppliances.get("Fridge")));
        appliancesMap.put("Tablet", AppliancesFactory.createAppliances(new Tablet(), dividedAppliances.get("Tablet")));
        appliancesMap.put("Teapot", AppliancesFactory.createAppliances(new Teapot(), dividedAppliances.get("Teapot")));
        appliancesMap.put("VacuumCleaner", AppliancesFactory.createAppliances(new VacuumCleaner(), dividedAppliances.get("VacuumCleaner")));
        return appliancesMap;
    }

    private static Pattern getAppliancePattern(Object applianceClass) {
        String fullClassName = applianceClass.getClass().getName();
        String className = fullClassName.substring(fullClassName.indexOf(".") + 1);
        return Pattern.compile("<" + className + ">(.*?)</" + className + ">");
    }

    private static HashMap<String, List<String>> mapStringByApplianceTypes(String dbData) {
        HashMap<String, List<String>> dividedAppliances = new HashMap<>();

        List<String> fieldsList = getAppliancePattern(new Oven()).matcher(dbData)
                .results()
                .map(matchResult -> matchResult.group(1))
                .toList();
        dividedAppliances.put("Oven", fieldsList);

        fieldsList = getAppliancePattern(new Laptop()).matcher(dbData)
                .results()
                .map(matchResult -> matchResult.group(1))
                .toList();
        dividedAppliances.put("Laptop", fieldsList);

        fieldsList = getAppliancePattern(new Fridge()).matcher(dbData)
                .results()
                .map(matchResult -> matchResult.group(1))
                .toList();
        dividedAppliances.put("Fridge", fieldsList);

        fieldsList = getAppliancePattern(new Tablet()).matcher(dbData)
                .results()
                .map(matchResult -> matchResult.group(1))
                .toList();
        dividedAppliances.put("Tablet", fieldsList);

        fieldsList = getAppliancePattern(new Teapot()).matcher(dbData)
                .results()
                .map(matchResult -> matchResult.group(1))
                .toList();
        dividedAppliances.put("Teapot", fieldsList);

        fieldsList = getAppliancePattern(new VacuumCleaner()).matcher(dbData)
                .results()
                .map(matchResult -> matchResult.group(1))
                .toList();
        dividedAppliances.put("VacuumCleaner", fieldsList);
        return dividedAppliances;
    }

    private static String readDataFromFile() {
        StringBuilder dbDataString = new StringBuilder();
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("")){
                    continue;
                }
                dbDataString.append(line.trim());
            }
            return new String(dbDataString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.menu;
import daos.CountryDao;
import daos.LocationDao;
import daos.RegionDAO;
import java.util.Scanner;
import tools.DBConnection;
import tools.countries.DeleteCountry;
import tools.countries.InsertCountry;
import tools.countries.SelectCountry;
import tools.countries.UpdateCountry;
import tools.locations.DeleteLocation;
import tools.locations.InsertLocation;
import tools.locations.SelectLocation;
import tools.locations.UpdateLocation;
/**
 *
 * @author ACER
 */
public class OperationMenu {
    Scanner scanner = new Scanner(System.in);
    public void showOperationMenu(String tableName) {
        DBConnection dbConnection = new DBConnection();
        CountryDao countryDao = new CountryDao(dbConnection.getConnection());
        LocationDao locationDao = new LocationDao(dbConnection.getConnection());
        RegionDAO regionDao = new RegionDAO(dbConnection.getConnection());
        int operationMenu = 0;
        do {
            System.out.println("\nPilihan operasi untuk table " + tableName + ":");
            System.out.println("1. Delete.");
            System.out.println("2. Insert.");
            System.out.println("3. Select.");
            System.out.println("4. Update.");
            System.out.println("5. Kembali.");
            System.out.print("Pilih operasi: ");
            operationMenu = scanner.nextInt();
            if (operationMenu == 1 && tableName.equals("Countries")) {
                DeleteCountry deleteCountry = new DeleteCountry();
                deleteCountry.deleteCountries(countryDao);
            } else if (operationMenu == 2 && tableName.equals("Countries")) {
                InsertCountry insertCountry = new InsertCountry();
                insertCountry.insertCountries(countryDao, regionDao);
            } else if (operationMenu == 3 && tableName.equals("Countries")) {
                SelectCountry selectCountry = new SelectCountry();
                selectCountry.selectCountries(countryDao);
            } else if (operationMenu == 4 && tableName.equals("Countries")) {
                UpdateCountry updateCountry = new UpdateCountry();
                updateCountry.updateCountries(countryDao, regionDao);
            } else if (operationMenu == 1 && tableName.equals("Departments")) {
            } else if (operationMenu == 2 && tableName.equals("Departments")) {
            } else if (operationMenu == 3 && tableName.equals("Departments")) {
            } else if (operationMenu == 4 && tableName.equals("Departments")) {
            } else if (operationMenu == 1 && tableName.equals("Employees")) {
            } else if (operationMenu == 2 && tableName.equals("Employees")) {
            } else if (operationMenu == 3 && tableName.equals("Employees")) {
            } else if (operationMenu == 4 && tableName.equals("Employees")) {
            } else if (operationMenu == 1 && tableName.equals("Jobs")) {
            } else if (operationMenu == 2 && tableName.equals("Jobs")) {
            } else if (operationMenu == 3 && tableName.equals("Jobs")) {
            } else if (operationMenu == 4 && tableName.equals("Jobs")) {
            } else if (operationMenu == 1 && tableName.equals("Locations")) {
                DeleteLocation deleteLocation = new DeleteLocation();
                deleteLocation.deleteLocations(locationDao);
            } else if (operationMenu == 2 && tableName.equals("Locations")) {
                InsertLocation insertLocation = new InsertLocation();
                insertLocation.insertLocations(locationDao, countryDao);
            } else if (operationMenu == 3 && tableName.equals("Locations")) {
                SelectLocation selectLocation = new SelectLocation();
                selectLocation.selectLocations(locationDao);
            } else if (operationMenu == 4 && tableName.equals("Locations")) {
                UpdateLocation updateLocation = new UpdateLocation();
                updateLocation.updateLocations(locationDao, countryDao);
            } else if (operationMenu == 1 && tableName.equals("Regions")) {
            } else if (operationMenu == 2 && tableName.equals("Regions")) {
            } else if (operationMenu == 3 && tableName.equals("Regions")) {
            } else if (operationMenu == 4 && tableName.equals("Regions")) {
            } else if (operationMenu == 5) {
            } else {
                System.out.println("Operasi tidak tersedia!");
            }
        } while (operationMenu < 1 || operationMenu > 5 || operationMenu != 5);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.menu;
import daos.CountryDao;
import daos.DepartmentDao;
import daos.JobDao;
import daos.EmployeeDAO;
import daos.LocationDao;
import daos.RegionDAO;
import java.util.Scanner;
import tools.DBConnection;
import tools.countries.DeleteCountry;
import tools.countries.InsertCountry;
import tools.countries.SelectCountry;
import tools.countries.UpdateCountry;
import tools.departments.DeleteDepartment;
import tools.departments.InsertDepartment;
import tools.departments.SelectDepartment;
import tools.departments.UpdateDepartment;
import tools.jobs.DeleteJob;
import tools.jobs.InsertJob;
import tools.jobs.SelectJob;
import tools.jobs.UpdateJob;
import tools.locations.DeleteLocation;
import tools.locations.InsertLocation;
import tools.locations.SelectLocation;
import tools.locations.UpdateLocation;
import tools.Employees.DeleteEmployee;
import tools.Employees.InsertEmployee;
import tools.Employees.SelectEmployee;
import tools.Employees.UpdateEmployee;
import tools.Regions.DeleteRegion;
import tools.Regions.InsertRegion;
import tools.Regions.SelectRegion;
import tools.Regions.UpdateRegion;
import tools.countries.SearchCountry;
import tools.locations.SearchLocation;
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
        DepartmentDao departmentDao = new DepartmentDao(dbConnection.getConnection());
        JobDao jobDao = new JobDao(dbConnection.getConnection());
        EmployeeDAO employeeDao = new EmployeeDAO(dbConnection.getConnection());
        int operationMenu = 0;
        do {
            System.out.println("\nPilihan operasi untuk table " + tableName + ":");
            System.out.println("1. Delete.");
            System.out.println("2. Insert.");
            System.out.println("3. Search.");
            System.out.println("4. Select.");
            System.out.println("5. Update.");
            System.out.println("Pilih 6 untuk kembali!");
            System.out.print("Pilih operasi: ");
            operationMenu = scanner.nextInt();
            if (operationMenu == 1 && tableName.equals("Countries")) {
                DeleteCountry deleteCountry = new DeleteCountry();
                deleteCountry.deleteCountries(countryDao);
            } else if (operationMenu == 2 && tableName.equals("Countries")) {
                InsertCountry insertCountry = new InsertCountry();
                insertCountry.insertCountries(countryDao, regionDao);
            } else if (operationMenu == 3 && tableName.equals("Countries")) {
                CountrySearchMenu countrySearchMenu = new CountrySearchMenu();
                countrySearchMenu.showCountrySearchMenu(countryDao);
            } else if (operationMenu == 4 && tableName.equals("Countries")) {
                SelectCountry selectCountry = new SelectCountry();
                selectCountry.selectCountries(countryDao);
            } else if (operationMenu == 5 && tableName.equals("Countries")) {
                UpdateCountry updateCountry = new UpdateCountry();
                updateCountry.updateCountries(countryDao, regionDao);
            } else if (operationMenu == 1 && tableName.equals("Departments")) {
                DeleteDepartment deleteDepartment = new DeleteDepartment();
                deleteDepartment.deleteDepartments(departmentDao);
            } else if (operationMenu == 2 && tableName.equals("Departments")) {
                InsertDepartment insertDepartment = new InsertDepartment();
                insertDepartment.insertDepartments(departmentDao);
            } else if (operationMenu == 4 && tableName.equals("Departments")) {
                SelectDepartment selectDepartment = new SelectDepartment();
                selectDepartment.selectDepartments(departmentDao);
            } else if (operationMenu == 5 && tableName.equals("Departments")) {
                UpdateDepartment updateDepartment = new UpdateDepartment();
                updateDepartment.updateDepartments(departmentDao);
            } else if (operationMenu == 1 && tableName.equals("Employees")) {
                DeleteEmployee deleteEmployee = new DeleteEmployee();
                deleteEmployee.deleteEmployee(employeeDao);
            } else if (operationMenu == 2 && tableName.equals("Employees")) {
                InsertEmployee insertEmployee = new InsertEmployee();
                insertEmployee.insertEmployee(employeeDao);
            } else if (operationMenu == 4 && tableName.equals("Employees")) {
                SelectEmployee selectEmployee = new SelectEmployee();
                selectEmployee.selectEmployee(employeeDao);
            } else if (operationMenu == 5 && tableName.equals("Employees")) {
                SelectEmployee selectEmployee = new SelectEmployee();
                selectEmployee.selectEmployee(employeeDao);
                UpdateEmployee updateEmployee = new UpdateEmployee();
                updateEmployee.updateEmployee(employeeDao);
            } else if (operationMenu == 1 && tableName.equals("Jobs")) {
                DeleteJob deleteJob = new DeleteJob();
                deleteJob.deleteJobs(jobDao);
            } else if (operationMenu == 2 && tableName.equals("Jobs")) {
                InsertJob insertJob = new InsertJob();
                insertJob.insertJobs(jobDao);
            } else if (operationMenu == 4 && tableName.equals("Jobs")) {
                SelectJob selectJob = new SelectJob();
                selectJob.selectJobs(jobDao);
            } else if (operationMenu == 5 && tableName.equals("Jobs")) {
                UpdateJob updateJob = new UpdateJob();
                updateJob.updateJobs(jobDao);
            } else if (operationMenu == 1 && tableName.equals("Locations")) {
                DeleteLocation deleteLocation = new DeleteLocation();
                deleteLocation.deleteLocations(locationDao);
            } else if (operationMenu == 2 && tableName.equals("Locations")) {
                InsertLocation insertLocation = new InsertLocation();
                insertLocation.insertLocations(locationDao, countryDao);
            } else if (operationMenu == 3 && tableName.equals("Locations")) {
                LocationSearchMenu locationSearchMenu = new LocationSearchMenu();
                locationSearchMenu.showLocationSearchMenu(locationDao);
            } else if (operationMenu == 4 && tableName.equals("Locations")) {
                SelectLocation selectLocation = new SelectLocation();
                selectLocation.selectLocations(locationDao);
            } else if (operationMenu == 5 && tableName.equals("Locations")) {
                UpdateLocation updateLocation = new UpdateLocation();
                updateLocation.updateLocations(locationDao, countryDao);
            } else if (operationMenu == 1 && tableName.equals("Regions")) {
                DeleteRegion deleteRegion = new DeleteRegion();
                deleteRegion.deleteEmployee(regionDao);
            } else if (operationMenu == 2 && tableName.equals("Regions")) {
                InsertRegion insertRegion = new InsertRegion();
                insertRegion.insertRegion(regionDao);
            } else if (operationMenu == 4 && tableName.equals("Regions")) {
                SelectRegion selectRegion = new SelectRegion();
                selectRegion.selectRegion(regionDao);
            } else if (operationMenu == 5 && tableName.equals("Regions")) {
                UpdateRegion updateRegion = new UpdateRegion();
                updateRegion.updateRegion(regionDao);
            } else if (operationMenu == 6) {
            } else {
                System.out.println("Operasi tidak tersedia!");
            }
        } while (operationMenu < 1 || operationMenu > 6 || operationMenu != 6);
    }
}
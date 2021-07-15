/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.CountryDao;
import daos.EmployeeDAO;
import daos.LocationDao;
import java.util.Scanner;
import models.Country;
import models.Location;
import daos.RegionDAO;
import java.sql.Date;
import models.Employee;
import models.Region;

/**
 *
 * @author Rory
 */
public class Kelompok_4 {
    static Scanner scanner = new Scanner(System.in);
    static Kelompok_4 kelompok_4 = new Kelompok_4();
    static int operationMenu = 0;
    public static void main(String[] args) {
        int tableMenu = 0;
        System.out.println("==================================================");
        System.out.println("     Selamat Datang Di Program CRUD HR Schema     ");
        System.out.println("==================================================");
        do {
            System.out.println("\nTabel yang tersedia:");
            System.out.println("1. Countries.");
            System.out.println("2. Departments.");
            System.out.println("3. Employees.");
            System.out.println("4. Jobs.");
            System.out.println("5. Locations.");
            System.out.println("6. Regions.");
            System.out.println("7. Keluar.");
            System.out.print("Pilih nomor table: "); tableMenu = scanner.nextInt();
            switch (tableMenu) {
                case 1:
                    kelompok_4.chooseOperation("Countries");
                    break;
                case 2:
                    kelompok_4.chooseOperation("Departments");
                    break;
                case 3:
                    kelompok_4.chooseOperation("Employees");
                    break;
                case 4:
                    kelompok_4.chooseOperation("Jobs");
                    break;
                case 5:
                    kelompok_4.chooseOperation("Locations");
                    break;
                case 6:
                    kelompok_4.chooseOperation("Regions");
                    break;
                case 7:
                    System.out.println("Terima kasih telah menggunakan program!");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
                    break;
            }
        } while (tableMenu < 1 || tableMenu > 7 || tableMenu != 7);
    } public void chooseOperation(String tableName) {
        DBConnection dbConnection = new DBConnection();
        CountryDao countryDao   = new CountryDao(dbConnection.getConnection());
        LocationDao locationDao = new LocationDao(dbConnection.getConnection());
        RegionDAO regionDao     = new RegionDAO(dbConnection.getConnection());
        EmployeeDAO employeeDAO = new EmployeeDAO(dbConnection.getConnection());
        do {
            System.out.println("\nPilihan operasi untuk table " + tableName + ":");
            System.out.println("1. Delete.");
            System.out.println("2. Insert.");
            System.out.println("3. Select.");
            System.out.println("4. Update.");
            System.out.println("5. Kembali.");
            System.out.print("Pilih operasi: "); operationMenu = scanner.nextInt();
            if (operationMenu == 1 && tableName.equals("Countries")) {
                deleteCountries(countryDao);
            } else if (operationMenu == 2 && tableName.equals("Countries")) {
                insertCountries(countryDao, regionDao);
            } else if (operationMenu == 3 && tableName.equals("Countries")) {
                selectCountries(countryDao);
            } else if (operationMenu == 4 && tableName.equals("Countries")) {
                updateCountries(countryDao, regionDao);
            } else if (operationMenu == 1 && tableName.equals("Departments")) {
                deleteDepartments();
            } else if (operationMenu == 2 && tableName.equals("Departments")) {
                insertDepartments();
            } else if (operationMenu == 3 && tableName.equals("Departments")) {
                selectDepartments();
            } else if (operationMenu == 4 && tableName.equals("Departments")) {
                updateDepartments();
            } else if (operationMenu == 1 && tableName.equals("Employees")) {
                deleteEmployees(employeeDAO);
            } else if (operationMenu == 2 && tableName.equals("Employees")) {
                insertEmployees();
            } else if (operationMenu == 3 && tableName.equals("Employees")) {
                selectEmployees();
            } else if (operationMenu == 4 && tableName.equals("Employees")) {
                updateEmployees();
            } else if (operationMenu == 1 && tableName.equals("Jobs")) {
                deleteJobs();
            } else if (operationMenu == 2 && tableName.equals("Jobs")) {
                insertJobs();
            } else if (operationMenu == 3 && tableName.equals("Jobs")) {
                selectJobs();
            } else if (operationMenu == 4 && tableName.equals("Jobs")) {
                updateJobs();
            } else if (operationMenu == 1 && tableName.equals("Locations")) {
                deleteLocations(locationDao);
            } else if (operationMenu == 2 && tableName.equals("Locations")) {
                insertLocations(locationDao, countryDao);
            } else if (operationMenu == 3 && tableName.equals("Locations")) {
                selectLocations(locationDao);
            } else if (operationMenu == 4 && tableName.equals("Locations")) {
                updateLocations(locationDao, countryDao);
            } else if (operationMenu == 1 && tableName.equals("Regions")) {
                deleteRegions();
            } else if (operationMenu == 2 && tableName.equals("Regions")) {
                insertRegions();
            } else if (operationMenu == 3 && tableName.equals("Regions")) {
                selectRegions();
            } else if (operationMenu == 4 && tableName.equals("Regions")) {
                updateRegions();
            } else if (operationMenu == 5) {
            } else {
                System.out.println("Operasi tidak tersedia!");
            }
        } while (operationMenu < 1 || operationMenu > 5 || operationMenu != 5);
    } public void deleteCountries(CountryDao countryDao) {
        String countryId = "";
        for (Country country : countryDao.getAll()) {
            System.out.println(country.toString());
        } do {
            System.out.print("Pilih Country ID yang ingin dihapus: "); countryId = scanner.next();
        } while (countryId.length() < 2 || countryId.length() > 2);
        if (countryDao.delete(countryId.toUpperCase())) {
            System.out.println("Delete data berhasil!");
        } else {
            System.out.println("Delete data gagal!");
        }
    } public void insertCountries(CountryDao countryDao, RegionDAO regionDao) {
        String countryId = "", countryName = "";
        int regionId = 0;
        do {
            System.out.print("Masukkan Country ID: "); countryId = scanner.next();
        } while (countryId.length() < 2 || countryId.length() > 2);
        System.out.print("Masukkan Country Name: "); scanner.nextLine(); countryName = scanner.nextLine();
        for (Region region : regionDao.getAll()) {
            System.out.println(region.toString());
        } System.out.print("Masukkan Region ID: "); regionId = scanner.nextInt();
        if (countryDao.insert(new Country(countryId, countryName, regionId))) {
            System.out.println("Insert data berhasil!");
        } else {
            System.out.println("Insert data gagal!");
        }
    } public void selectCountries(CountryDao countryDao) {
        System.out.println("");
        for (Country country : countryDao.getAll()) {
            System.out.println(country.toString());
        }
    } public void updateCountries(CountryDao countryDao, RegionDAO regionDao) {
        String countryId = "", countryName = "";
        int regionId = 0;
        System.out.println("");
        for (Country country : countryDao.getAll()) {
            System.out.println(country.toString());
        } do {
            System.out.print("Masukkan Country ID yang ingin diupdate: ");
            countryId = scanner.next();
        } while (countryId.length() < 2 || countryId.length() > 2);
        System.out.println("");
        for (Country country : countryDao.getAll()) {
            if (country.getCountryId().equalsIgnoreCase(countryId)) {
                System.out.println("Country Name sebelumnya: " + country.getCountryName() + ".");
                System.out.print("Masukkan Country Name yang baru: "); scanner.nextLine(); countryName = scanner.nextLine();
                for (Region region : regionDao.getAll()) {
                    System.out.println(region.toString());
                } System.out.println("Region ID sebelumnya: " + country.getRegionId());
                System.out.print("Masukkan Region ID yang baru: "); regionId = scanner.nextInt();
                if (countryDao.update(new Country(country.getCountryId().toUpperCase(), countryName, regionId))) {
                    System.out.println("Update data berhasil!");
                } else {
                    System.out.println("Update data gagal!");
                }
                break;
            }
        }
    } public void deleteDepartments() {
    } public void insertDepartments() {
    } public void selectDepartments() {
    } public void updateDepartments() {
    } public void deleteEmployees(EmployeeDAO employeeDAO) {
        int employee_id = 0;
        for (Employee employee : employeeDAO.getAll()) {
            System.out.println(employee.toString());
            }
        
        System.out.print("Pilih Employee ID yang ingin dihapus: "); employee_id = scanner.nextInt();
        
        if (employeeDAO.delete(employee_id)) {
            System.out.println("Delete data berhasil!");
        } else {
            System.out.println("Delete data gagal!");
        }
    } public void insertEmployees() {
        int phone_number = 0, job_id = 0, manager_id = 0, department_id = 0, employee_id = 0;
        String first_name = "", last_name = "", email = "", hire_date = "";
        double salary = 0, commission_pct = 0;
        
        System.out.print("Masukkan Employee ID: "          ); employee_id    = scanner.nextInt();
        System.out.print("Masukkan Employee First Name: "  ); first_name     = scanner.nextLine();
        System.out.print("Masukkan Employee Last Name: "   ); last_name      = scanner.nextLine();
        System.out.print("Masukkan Employee Email: "       ); email          = scanner.nextLine();
        System.out.print("Masukkan Employee Hire Date: "   ); hire_date      = scanner.nextLine();
        System.out.print("Masukkan Employee Phone Number: "); phone_number   = scanner.nextInt();
        System.out.print("Masukkan Job ID: "               ); job_id         = scanner.nextInt();
        System.out.print("Masukkan Manager ID: "           ); manager_id     = scanner.nextInt();
        System.out.print("Masukkan Department ID: "        ); department_id  = scanner.nextInt();
        System.out.print("Masukkan Salary: "               ); salary         = scanner.nextInt();
        System.out.print("Masukkan Commission PCT: "       ); commission_pct = scanner.nextInt();
        
    } public void selectEmployees() {
        for (Employee employee : employeeDAO.getAll()) {
            System.out.println(employee.getId_employee() + " || " + employee.getFirst_name()+
                    " || "+ employee.getLast_name()+
                    " || "+ employee.getEmail() + " || " + employee.getPhone_number()+
                    " || " + employee.getJob_id() + " || " + employee.getSalary() +
                    " || " + employee.getCommission_pct() + " || " + employee.getManager_id() +
                    " || " + employee.getDepartment_id() + " || " + employee.getHire_date());
        }
    } public void updateEmployees() {
    } public void deleteJobs() {
    } public void insertJobs() {
    } public void selectJobs() {
    } public void updateJobs() {
    } public void deleteLocations(LocationDao locationDao) {
        int locationId = 0;
        for (Location location : locationDao.getAll()) {
            System.out.println(location.toString());
        } System.out.print("Pilih Location ID yang ingin dihapus: "); locationId = scanner.nextInt();
        if (locationDao.delete(locationId)) {
            System.out.println("Delete data berhasil!");
        } else {
            System.out.println("Delete data gagal!");
        }
    } public void insertLocations(LocationDao locationDao, CountryDao countryDao) {
        String streetAddress = "", postalCode = "", city = "", stateProvince = "", countryId = "";
        System.out.print("Masukkan Street Address: "); scanner.nextLine(); streetAddress = scanner.nextLine();
        System.out.print("Masukkan Postal Code: "); postalCode = scanner.nextLine();
        System.out.print("Masukkan City: "); city = scanner.nextLine();
        System.out.print("Masukkan State Province: "); stateProvince = scanner.nextLine();
        for (Country country : countryDao.getAll()) {
            System.out.println(country.toString());
        } do {
            System.out.print("Masukkan Country ID yang baru: "); countryId = scanner.next();
        } while (countryId.length() < 2 || countryId.length() > 2);
        if (locationDao.insert(new Location(0, streetAddress, postalCode, city, stateProvince, countryId))) {
            System.out.println("Insert data berhasil!");
        } else {
            System.out.println("Insert data gagal!");
        }
    } public void selectLocations(LocationDao locationDao) {
        System.out.println("");
        for (Location location : locationDao.getAll()) {
            System.out.println(location.toString());
        }
    } public void updateLocations(LocationDao locationDao, CountryDao countryDao) {
        String streetAddress = "", postalCode = "", city = "", stateProvince = "", countryId = "";
        int locationId = 0;
        System.out.println("");
        for (Location location : locationDao.getAll()) {
            System.out.println(location.toString());
        } System.out.print("Masukkan Location ID yang ingin diupdate: "); locationId = scanner.nextInt();
        for (Location location : locationDao.getAll()) {
            if (location.getLocationId() == locationId) {
                System.out.println("Street Address sebelumnya: " + location.getStreetAddress() + ".");
                System.out.print("Masukkan Street Address yang baru: "); scanner.nextLine(); streetAddress = scanner.nextLine();
                System.out.println("Postal Code sebelumnya: " + location.getPostalCode() + ".");
                System.out.print("Masukkan Postal Code yang baru: "); postalCode = scanner.nextLine();
                System.out.println("City sebelumnya: " + location.getCity() + ".");
                System.out.print("Masukkan City yang baru: "); city = scanner.nextLine();
                System.out.println("State Province sebelumnya: " + location.getStateProvince() + ".");
                System.out.print("Masukkan State Province yang baru: "); stateProvince = scanner.nextLine();
                for (Country country : countryDao.getAll()) {
                    System.out.println(country.toString());
                } System.out.println("Country ID sebelumnya: " + location.getCountryId());
                do {
                    System.out.print("Masukkan Country ID yang baru: ");
                    countryId = scanner.next();
                } while (countryId.length() < 2 || countryId.length() > 2);
                if (locationDao.update(new Location(location.getLocationId(), streetAddress, postalCode, city, stateProvince, countryId))) {
                    System.out.println("Update data berhasil!");
                } else {
                    System.out.println("Update data gagal!");
                }
                break;
            }
        }
    } public void deleteRegions() {
    } public void insertRegions() {
    } public void selectRegions() {
    } public void updateRegions() {
    }
}

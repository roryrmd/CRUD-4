/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.locations;
import daos.CountryDao;
import daos.LocationDao;
import java.util.Scanner;
import models.Country;
import models.Location;
/**
 *
 * @author ACER
 */
public class InsertLocation {
    Scanner scanner = new Scanner(System.in);
    public void insertLocations(LocationDao locationDao, CountryDao countryDao) {
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
    }
}
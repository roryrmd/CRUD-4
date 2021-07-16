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
import tools.countries.SelectCountry;
/**
 *
 * @author ACER
 */
public class InsertLocation {
    Scanner scanner = new Scanner(System.in);
    SelectCountry selectCountry = new SelectCountry();
    public void insertLocations(LocationDao locationDao, CountryDao countryDao) {
        String streetAddress = "", postalCode = "", city = "", stateProvince = "", countryId = "";
        System.out.print("\nMasukkan Street Address: "); streetAddress = scanner.nextLine();
        System.out.print("Masukkan Postal Code: "); postalCode = scanner.nextLine();
        do {
            System.out.print("Masukkan City: "); city = scanner.nextLine();
            if (!isAlphabetWithSpace(city)) {
                System.out.println("City hanya boleh mengandung huruf!");
            }
        } while(!isAlphabetWithSpace(city));
        do {
            System.out.print("Masukkan State Province: "); stateProvince = scanner.nextLine();
            if (!isAlphabetWithSpace(stateProvince)) {
                System.out.println("State Province hanya boleh mengandung huruf!");
            }
        } while(!isAlphabetWithSpace(stateProvince));
        selectCountry.selectCountries(countryDao);
        do {
            System.out.print("Masukkan Country ID: "); countryId = scanner.next();
            if (countryDao.checkByCountryId(countryId.toUpperCase())) {
                System.out.println("Country ID tidak ditemukan!");
            }
        } while (countryDao.checkByCountryId(countryId.toUpperCase()));
        if (locationDao.insert(new Location(0, streetAddress, postalCode, city, stateProvince, countryId.toUpperCase()))) {
            System.out.println("Insert data berhasil!");
        } else {
            System.out.println("Insert data gagal!");
        }
    } public boolean isAlphabetWithSpace(String s) {
        return s != null && s.matches("^[a-zA-Z ]*$");
    }
}
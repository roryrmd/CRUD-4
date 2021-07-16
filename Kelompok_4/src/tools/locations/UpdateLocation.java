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
public class UpdateLocation {
    Scanner scanner = new Scanner(System.in);
    SelectLocation selectLocation = new SelectLocation();
    SelectCountry selectCountry = new SelectCountry();
    public void updateLocations(LocationDao locationDao, CountryDao countryDao) {
        String streetAddress = "", postalCode = "", city = "", stateProvince = "", countryId = "";
        int locationId = 0;
        selectLocation.selectLocations(locationDao);
        do {
            System.out.print("\nMasukkan Location ID yang ingin diupdate: "); locationId = scanner.nextInt();
            if (locationDao.checkByLocationId(locationId)) {
                System.out.println("Location ID tidak ditemukan!");
            }
        } while (locationDao.checkByLocationId(locationId));
        for (Location location : locationDao.getAll()) {
            if (location.getLocationId() == locationId) {
                System.out.println("Street Address sebelumnya: " + location.getStreetAddress() + ".");
                System.out.print("Masukkan Street Address yang baru: "); scanner.nextLine(); streetAddress = scanner.nextLine();
                System.out.println("Postal Code sebelumnya: " + location.getPostalCode() + ".");
                System.out.print("Masukkan Postal Code yang baru: "); postalCode = scanner.nextLine();
                do {
                    System.out.println("City sebelumnya: " + location.getCity() + ".");
                    System.out.print("Masukkan City yang baru: "); city = scanner.nextLine();
                    if (!isAlphabetWithSpace(city)) {
                        System.out.println("City hanya boleh mengandung huruf!");
                    }
                } while(!isAlphabetWithSpace(city));
                do {
                    System.out.println("State Province sebelumnya: " + location.getStateProvince() + ".");
                    System.out.print("Masukkan State Province yang baru: "); stateProvince = scanner.nextLine();
                    if (!isAlphabetWithSpace(stateProvince)) {
                        System.out.println("State Province hanya boleh mengandung huruf!");
                    }
                } while(!isAlphabetWithSpace(stateProvince));
                selectCountry.selectCountries(countryDao);
                System.out.println("Country ID sebelumnya: " + location.getCountryId());
                do {
                    System.out.print("Masukkan Country ID yang baru: "); countryId = scanner.next();
                    if (countryDao.checkByCountryId(countryId.toUpperCase())) {
                        System.out.println("Country ID tidak ditemukan!");
                    }
                } while (countryDao.checkByCountryId(countryId.toUpperCase()));
                if (locationDao.update(new Location(location.getLocationId(), streetAddress, postalCode, city, stateProvince, countryId.toUpperCase()))) {
                    System.out.println("Update data berhasil!");
                } else {
                    System.out.println("Update data gagal!");
                } break;
            }
        } selectLocation.selectLocations(locationDao);
    } public boolean isAlphabetWithSpace(String s) {
        return s != null && s.matches("^[a-zA-Z ]*$");
    }
}
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
public class UpdateLocation {
    Scanner scanner = new Scanner(System.in);
    public void updateLocations(LocationDao locationDao, CountryDao countryDao) {
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
    }
}
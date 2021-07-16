/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.locations;
import daos.LocationDao;
import java.util.Scanner;
import models.Location;
/**
 *
 * @author ACER
 */
public class SearchLocation {
    Scanner scanner = new Scanner(System.in);
    public void searchLocationById(LocationDao locationDao) {
        int locationId = 0;
        System.out.print("\nMasukkan Location ID yang ingin dicari: "); locationId = scanner.nextInt();
        if (locationDao.checkByLocationId(locationId)) {
            System.out.println("Data tidak ditemukan!");
        } else {
            for (Location location : locationDao.searchByIntegerType("LOCATION_ID", locationId)) {
                System.out.println(location.getLocationId() + " | " + location.getStreetAddress()+ " | " + location.getPostalCode()+ " | " + location.getCity() + " | " + location.getStateProvince() + " | " + location.getCountryId());
            }
        }
    } public void searchLocationByStreetAdderss(LocationDao locationDao) {
        String streetAddress = "";
        System.out.print("\nMasukkan Street Address yang ingin dicari: "); streetAddress = scanner.nextLine();
        if (locationDao.searchByStringType("STREET_ADDRESS", streetAddress).isEmpty()) {
            System.out.println("Data tidak ditemukan!");
        } else {
            for (Location location : locationDao.searchByStringType("STREET_ADDRESS", streetAddress)) {
                System.out.println(location.getLocationId() + " | " + location.getStreetAddress()+ " | " + location.getPostalCode()+ " | " + location.getCity() + " | " + location.getStateProvince() + " | " + location.getCountryId());
            }
        }
    } public void searchLocationByPostalCode(LocationDao locationDao) {
        String postalCode = "";
        System.out.print("\nMasukkan Postal Code yang ingin dicari: "); postalCode = scanner.nextLine();
        if (locationDao.searchByStringType("POSTAL_CODE", postalCode).isEmpty()) {
            System.out.println("Data tidak ditemukan!");
        } else {
            for (Location location : locationDao.searchByStringType("POSTAL_CODE", postalCode)) {
                System.out.println(location.getLocationId() + " | " + location.getStreetAddress()+ " | " + location.getPostalCode()+ " | " + location.getCity() + " | " + location.getStateProvince() + " | " + location.getCountryId());
            }
        }
    } public void searchLocationByCity(LocationDao locationDao) {
        String city = "";
        System.out.print("\nMasukkan City yang ingin dicari: "); city = scanner.nextLine();
        if (locationDao.searchByStringType("CITY", city).isEmpty()) {
            System.out.println("Data tidak ditemukan!");
        } else {
            for (Location location : locationDao.searchByStringType("CITY", city)) {
                System.out.println(location.getLocationId() + " | " + location.getStreetAddress()+ " | " + location.getPostalCode()+ " | " + location.getCity() + " | " + location.getStateProvince() + " | " + location.getCountryId());
            }
        }
    } public void searchLocationByStateProvince(LocationDao locationDao) {
        String stateProvince = "";
        System.out.print("\nMasukkan State Province yang ingin dicari: "); stateProvince = scanner.nextLine();
        if (locationDao.searchByStringType("STATE_PROVINCE", stateProvince).isEmpty()) {
            System.out.println("Data tidak ditemukan!");
        } else {
            for (Location location : locationDao.searchByStringType("STATE_PROVINCE", stateProvince)) {
                System.out.println(location.getLocationId() + " | " + location.getStreetAddress()+ " | " + location.getPostalCode()+ " | " + location.getCity() + " | " + location.getStateProvince() + " | " + location.getCountryId());
            }
        }
    } public void searchLocationByCountryId(LocationDao locationDao) {
        String countryId = "";
        System.out.print("\nMasukkan Street Address yang ingin dicari: "); countryId = scanner.nextLine();
        if (locationDao.searchByStringType("COUNTRY_ID", countryId.toUpperCase()).isEmpty()) {
            System.out.println("Data tidak ditemukan!");
        } else {
            for (Location location : locationDao.searchByStringType("COUNTRY_ID", countryId.toUpperCase())) {
                System.out.println(location.getLocationId() + " | " + location.getStreetAddress()+ " | " + location.getPostalCode()+ " | " + location.getCity() + " | " + location.getStateProvince() + " | " + location.getCountryId());
            }
        }
    }
}
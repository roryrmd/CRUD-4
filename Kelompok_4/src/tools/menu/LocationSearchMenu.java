/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.menu;

import daos.LocationDao;
import java.util.Scanner;
import tools.locations.SearchLocation;

/**
 *
 * @author ACER
 */
public class LocationSearchMenu {
    Scanner scanner = new Scanner(System.in);
    SearchLocation searchLocation = new SearchLocation();
    public void showLocationSearchMenu(LocationDao locationDao) {
        int nomorAttribute = 0;
        do {
            System.out.println("\nSearch Location berdasarkan:");
            System.out.println("1. Location ID.");
            System.out.println("2. Street Address.");
            System.out.println("3. Postal Code.");
            System.out.println("4. City.");
            System.out.println("5. State Province.");
            System.out.println("6. Country ID.");
            System.out.println("Pilih 7 untuk kembali!");
            System.out.print("Pilih attribute: "); nomorAttribute = scanner.nextInt();
            switch (nomorAttribute) {
                case 1:
                    searchLocation.searchLocationById(locationDao);
                    break;
                case 2:
                    searchLocation.searchLocationByStreetAdderss(locationDao);
                    break;
                case 3:
                    searchLocation.searchLocationByPostalCode(locationDao);
                    break;
                case 4:
                    searchLocation.searchLocationByCity(locationDao);
                    break;
                case 5:
                    searchLocation.searchLocationByStateProvince(locationDao);
                    break;
                case 6:
                    searchLocation.searchLocationByCountryId(locationDao);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
                    break;
            }
        } while (nomorAttribute < 1 || nomorAttribute > 7 || nomorAttribute != 7);
    }
}
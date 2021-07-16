/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.menu;

import daos.CountryDao;
import java.util.Scanner;
import tools.countries.SearchCountry;
/**
 *
 * @author ACER
 */
public class CountrySearchMenu {
    Scanner scanner = new Scanner(System.in);
    SearchCountry searchCountry = new SearchCountry();
    public void showCountrySearchMenu(CountryDao countryDao) {
        int nomorAttribute = 0;
        do {
            System.out.println("\nSearch Country berdasarkan:");
            System.out.println("1. Country ID.");
            System.out.println("2. Country Name.");
            System.out.println("3. Region ID.");
            System.out.println("Pilih 4 untuk kembali!");
            System.out.print("Pilih attribute: "); nomorAttribute = scanner.nextInt();
            switch (nomorAttribute) {
                case 1:
                    searchCountry.searchCountryByCountryId(countryDao);
                    break;
                case 2:
                    searchCountry.searchCountryByCountryName(countryDao);
                    break;
                case 3:
                    searchCountry.searchCountryByRegionId(countryDao);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
                    break;
            }
        } while (nomorAttribute < 1 || nomorAttribute > 4 || nomorAttribute != 4);
    }
}
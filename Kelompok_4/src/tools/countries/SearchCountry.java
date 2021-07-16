/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.countries;
import daos.CountryDao;
import java.util.Scanner;
import models.Country;
/**
 *
 * @author ACER
 */
public class SearchCountry {
    Scanner scanner = new Scanner(System.in);
    Country country = new Country();
    public void searchCountryByCountryId(CountryDao countryDao) {
        String countryId = "";
        System.out.print("\nMasukkan Country ID yang ingin dicari: "); countryId = scanner.nextLine();
        if (countryDao.searchByStringType("COUNTRY_ID", countryId.toUpperCase()).isEmpty()) {
            System.out.println("Data tidak ditemukan!");
        } else {
            for (Country country : countryDao.searchByStringType("COUNTRY_ID", countryId.toUpperCase())) {
                System.out.println(country.getCountryId() + " | " + country.getCountryName() + " | " + country.getRegionId());
            }
        }
    } public void searchCountryByCountryName(CountryDao countryDao) {
        String countryName = "";
        System.out.print("\nMasukkan Country Name yang ingin dicari: "); countryName = scanner.nextLine();
        if (countryDao.searchByStringType("COUNTRY_NAME", countryName).isEmpty()) {
            System.out.println("Data tidak ditemukan!");
        } else {
            for (Country country : countryDao.searchByStringType("COUNTRY_NAME", countryName)) {
                System.out.println(country.getCountryId() + " | " + country.getCountryName() + " | " + country.getRegionId());
            }
        }
    } public void searchCountryByRegionId(CountryDao countryDao) {
        int regionId = 0;
        System.out.print("\nMasukkan Region ID yang ingin dicari: "); regionId = scanner.nextInt();
        if (countryDao.searchByIntegerType("REGION_ID", regionId).isEmpty()) {
            System.out.println("Data tidak ditemukan!");
        } else {
            for (Country country : countryDao.searchByIntegerType("REGION_ID", regionId)) {
                System.out.println(country.getCountryId() + " | " + country.getCountryName() + " | " + country.getRegionId());
            }
        }
    }
}
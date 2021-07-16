/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.countries;
import daos.CountryDao;
import daos.RegionDAO;
import java.util.Scanner;
import models.Country;
import models.Region;
/**
 *
 * @author ACER
 */
public class InsertCountry {
    Scanner scanner = new Scanner(System.in);
    public void insertCountries(CountryDao countryDao, RegionDAO regionDao) {
        String countryId = "", countryName = "";
        int regionId = 0;
        boolean cek = false;
        do {
            System.out.print("\nMasukkan Country ID: "); countryId = scanner.next();
            if (!countryDao.checkByCountryId(countryId.toUpperCase())) {
                System.err.println("Country ID sudah digunakan!");
            } if (!isAlphabet(countryId)) {
                System.err.println("Country ID hanya boleh mengandung huruf!");
            } if (countryId.length() != 2) {
                System.err.println("Country ID harus terdiri dari 2 huruf!");
            }
        } while (countryId.length() != 2 || !countryDao.checkByCountryId(countryId.toUpperCase()) || !isAlphabet(countryId));
        scanner.nextLine();
        do {
            System.out.print("Masukkan Country Name: "); countryName = scanner.nextLine();
            if (!isAlphabetWithSpace(countryName)) {
                System.err.println("Country Name hanya boleh mengandung huruf!");
            }
        } while(!isAlphabetWithSpace(countryName));
        System.out.println(countryName);
        for (Region region : regionDao.getAll()) {
            System.out.println(region.getId() + " | " + region.getName());
        } do {
            System.out.print("Masukkan Region ID: "); regionId = scanner.nextInt();
            if (countryDao.checkByRegionId(regionId)) {
                System.err.println("Region ID tidak ditemukan!");
            }
        } while(countryDao.checkByRegionId(regionId));
        if (countryDao.insert(new Country(countryId.toUpperCase(), countryName, regionId))) {
            System.out.println("Insert data berhasil!");
        } else {
            System.err.println("Insert data gagal!");
        }
    } public boolean isAlphabet(String s) {
        return s != null && s.matches("^[a-zA-Z]*$");
    } public boolean isAlphabetWithSpace(String s) {
        return s != null && s.matches("^[a-zA-Z ]*$");
    }
}
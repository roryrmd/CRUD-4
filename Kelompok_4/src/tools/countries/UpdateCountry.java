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
import tools.Regions.SelectRegion;
/**
 *
 * @author ACER
 */
public class UpdateCountry {
    Scanner scanner = new Scanner(System.in);
    SelectCountry selectCountry = new SelectCountry();
    SelectRegion selectRegion = new SelectRegion();
    public void updateCountries(CountryDao countryDao, RegionDAO regionDao) {
        String countryId = "", countryName = "";
        int regionId = 0;
        selectCountry.selectCountries(countryDao);
        do {
            System.out.print("\nMasukkan Country ID yang ingin diupdate: ");
            countryId = scanner.next();
            if (countryDao.checkByCountryId(countryId.toUpperCase())) {
                System.out.println("Country ID tidak ditemukan!");
            }
        } while (countryDao.checkByCountryId(countryId.toUpperCase()));
        System.out.println("");
        for (Country country : countryDao.getAll()) {
            if (country.getCountryId().equalsIgnoreCase(countryId)) {
                scanner.nextLine();
                do {
                    System.out.println("Country Name sebelumnya: " + country.getCountryName() + ".");
                    System.out.print("Masukkan Country Name yang baru: "); countryName = scanner.nextLine();
                    if (!isAlphabetWithSpace(countryName)) {
                        System.err.println("Country Name hanya boleh mengandung huruf!");
                    }
                } while (!isAlphabetWithSpace(countryName));
                selectRegion.selectRegion(regionDao);
                System.out.println("Region ID sebelumnya: " + country.getRegionId());
                do {
                    System.out.print("Masukkan Region ID yang baru: ");
                    regionId = scanner.nextInt();
                    if (countryDao.checkByRegionId(regionId)) {
                        System.out.println("Region ID tidak ditemukan!");
                    }
                } while (countryDao.checkByRegionId(regionId));
                if (countryDao.update(new Country(country.getCountryId().toUpperCase(), countryName, regionId))) {
                    System.out.println("Update data berhasil!");
                } else {
                    System.out.println("Update data gagal!");
                } break;
            }
        } selectCountry.selectCountries(countryDao);
    } public boolean isAlphabetWithSpace(String s) {
        return s != null && s.matches("^[a-zA-Z ]*$");
    }
}
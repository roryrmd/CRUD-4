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
public class DeleteCountry {
    Scanner scanner = new Scanner(System.in);
    SelectCountry selectCountry = new SelectCountry();
    public void deleteCountries(CountryDao countryDao) {
        String countryId = "";
        selectCountry.selectCountries(countryDao);
        do {
            System.out.print("\nPilih Country ID yang ingin dihapus: "); countryId = scanner.next();
            if (countryDao.checkByCountryId(countryId.toUpperCase())) {
                System.out.println("Country ID tidak ditemukan!");
            }
        } while (countryDao.checkByCountryId(countryId.toUpperCase()));
        if (countryDao.delete(countryId.toUpperCase())) {
            System.out.println("Delete data berhasil!");
        } else {
            System.out.println("Delete data gagal!");
        } selectCountry.selectCountries(countryDao);
    }
}
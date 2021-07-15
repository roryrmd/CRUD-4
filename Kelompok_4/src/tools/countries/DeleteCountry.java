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
    public void deleteCountries(CountryDao countryDao) {
        String countryId = "";
        for (Country country : countryDao.getAll()) {
            System.out.println(country.toString());
        } do {
            System.out.print("Pilih Country ID yang ingin dihapus: "); countryId = scanner.next();
        } while (countryId.length() < 2 || countryId.length() > 2);
        if (countryDao.delete(countryId.toUpperCase())) {
            System.out.println("Delete data berhasil!");
        } else {
            System.out.println("Delete data gagal!");
        }
    }
}
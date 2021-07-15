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
public class UpdateCountry {
    Scanner scanner = new Scanner(System.in);
    public void updateCountries(CountryDao countryDao, RegionDAO regionDao) {
        String countryId = "", countryName = "";
        int regionId = 0;
        System.out.println("");
        for (Country country : countryDao.getAll()) {
            System.out.println(country.toString());
        } do {
            System.out.print("Masukkan Country ID yang ingin diupdate: ");
            countryId = scanner.next();
        } while (countryId.length() < 2 || countryId.length() > 2);
        System.out.println("");
        for (Country country : countryDao.getAll()) {
            if (country.getCountryId().equalsIgnoreCase(countryId)) {
                System.out.println("Country Name sebelumnya: " + country.getCountryName() + ".");
                System.out.print("Masukkan Country Name yang baru: "); scanner.nextLine(); countryName = scanner.nextLine();
                for (Region region : regionDao.getAll()) {
                    System.out.println(region.toString());
                } System.out.println("Region ID sebelumnya: " + country.getRegionId());
                System.out.print("Masukkan Region ID yang baru: "); regionId = scanner.nextInt();
                if (countryDao.update(new Country(country.getCountryId().toUpperCase(), countryName, regionId))) {
                    System.out.println("Update data berhasil!");
                } else {
                    System.out.println("Update data gagal!");
                }
                break;
            }
        }
    }
}
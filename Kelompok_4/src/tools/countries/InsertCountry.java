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
        do {
            System.out.print("Masukkan Country ID: "); countryId = scanner.next();
        } while (countryId.length() < 2 || countryId.length() > 2);
        System.out.print("Masukkan Country Name: "); scanner.nextLine(); countryName = scanner.nextLine();
        for (Region region : regionDao.getAll()) {
            System.out.println(region.toString());
        } System.out.print("Masukkan Region ID: "); regionId = scanner.nextInt();
        if (countryDao.insert(new Country(countryId, countryName, regionId))) {
            System.out.println("Insert data berhasil!");
        } else {
            System.out.println("Insert data gagal!");
        }
    }
}
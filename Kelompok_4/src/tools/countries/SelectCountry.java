/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.countries;
import daos.CountryDao;
import models.Country;
/**
 *
 * @author ACER
 */
public class SelectCountry {
    public void selectCountries(CountryDao countryDao) {
        System.out.println("");
        for (Country country : countryDao.getAll()) {
            System.out.println(country.toString());
        }
    }
}
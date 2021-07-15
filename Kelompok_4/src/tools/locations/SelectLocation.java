/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.locations;
import daos.LocationDao;
import models.Location;
/**
 *
 * @author ACER
 */
public class SelectLocation {
    public void selectLocations(LocationDao locationDao) {
        System.out.println("");
        for (Location location : locationDao.getAll()) {
            System.out.println(location.toString());
        }
    }
}
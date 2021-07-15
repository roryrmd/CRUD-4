/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Regions;

import daos.RegionDAO;
import models.Region;

/**
 *
 * @author Rory
 */
public class SelectRegion {
    public void selectRegion(RegionDAO regionDAO) {
        System.out.println("");
        for (Region region : regionDAO.getAll()) {
            System.out.println(region.toString());
        }
    }
}

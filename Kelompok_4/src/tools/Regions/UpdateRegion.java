/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Regions;

import daos.RegionDAO;
import java.util.Scanner;
import models.Region;

/**
 *
 * @author Rory
 */
public class UpdateRegion {
    Scanner scanner = new Scanner(System.in);
    public void updateRegion(RegionDAO regionDao) {
        String region_name = "";
        int region_id = 0;
        
        System.out.print("Masukkan Region ID  : "); region_id = scanner.nextInt();
        System.out.print("Masukkan Region Name: "); scanner.nextLine(); region_name = scanner.nextLine();
        
        Region region = new Region();
        
        region.setId(region_id);
        region.setName(region_name);
        
        if (regionDao.update(region)) {
            System.out.println("update data berhasil!");
        } else {
            System.out.println("update data gagal!");
        }
    }
}

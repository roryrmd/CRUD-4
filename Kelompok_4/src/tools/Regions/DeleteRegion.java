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
public class DeleteRegion {
    Scanner scanner = new Scanner(System.in);
    public void deleteEmployee(RegionDAO regionDao) {
        int region_id = 0;
        
        System.out.print("Pilih Region ID yang ingin dihapus: "); region_id = scanner.nextInt();
        
        Region region = new Region();
        region.setId(region_id);
        
        if (regionDao.delete(region)) {
            System.out.println("Delete data berhasil!");
        } else {
            System.out.println("Delete data gagal!");
        }
    }
}

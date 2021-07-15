/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Regions;

import daos.EmployeeDAO;
import daos.RegionDAO;
import java.util.Scanner;
import models.Employee;
import models.Region;

/**
 *
 * @author Rory
 */
public class InsertRegion {
    Scanner scanner = new Scanner(System.in);
    public void insertRegion(RegionDAO regionDao) {
        String region_name = "";
        int region_id = 0;
        
        System.out.print("Masukkan Region ID  : "); region_id = scanner.nextInt();
        System.out.print("Masukkan Region Name: "); scanner.nextLine(); region_name = scanner.nextLine();
        
        Region region = new Region();
        region.setId     (region_id);
        region.setName   (region_name);
        
        if (regionDao.insert(region)) {
            System.out.println("Insert data berhasil3!");
        } else {
            System.out.println("Insert data gagal!");
        }
    }
}

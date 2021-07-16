/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.locations;
import daos.LocationDao;
import java.util.Scanner;
/**
 *
 * @author ACER
 */
public class DeleteLocation {
    Scanner scanner = new Scanner(System.in);
    SelectLocation selectLocation = new SelectLocation();
    public void deleteLocations(LocationDao locationDao) {
        int locationId = 0;
        selectLocation.selectLocations(locationDao);
        do {
            System.out.print("\nMasukkan Location ID yang ingin dihapus: "); locationId = scanner.nextInt();
            if (locationDao.checkByLocationId(locationId)) {
                System.out.println("Location ID tidak ditemukan!");
            }
        } while (locationDao.checkByLocationId(locationId));
        if (locationDao.delete(locationId)) {
            System.out.println("Delete data berhasil!");
        } else {
            System.out.println("Delete data gagal!");
        }
    }
}
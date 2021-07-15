/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.locations;
import daos.LocationDao;
import java.util.Scanner;
import models.Location;
/**
 *
 * @author ACER
 */
public class DeleteLocation {
    Scanner scanner = new Scanner(System.in);
    public void deleteLocations(LocationDao locationDao) {
        int locationId = 0;
        for (Location location : locationDao.getAll()) {
            System.out.println(location.toString());
        } System.out.print("Pilih Location ID yang ingin dihapus: "); locationId = scanner.nextInt();
        if (locationDao.delete(locationId)) {
            System.out.println("Delete data berhasil!");
        } else {
            System.out.println("Delete data gagal!");
        }
    }
}
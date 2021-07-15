/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.menu;
import java.util.Scanner;
/**
 *
 * @author ACER
 */
public class MainMenu {
    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        OperationMenu operationMenu = new OperationMenu();
        int tableMenu = 0;
        System.out.println("==================================================");
        System.out.println("     Selamat Datang Di Program CRUD HR Schema     ");
        System.out.println("==================================================");
        do {
            System.out.println("\nTabel yang tersedia:");
            System.out.println("1. Countries.");
            System.out.println("2. Departments.");
            System.out.println("3. Employees.");
            System.out.println("4. Jobs.");
            System.out.println("5. Locations.");
            System.out.println("6. Regions.");
            System.out.println("7. Keluar.");
            System.out.print("Pilih nomor table: "); tableMenu = scanner.nextInt();
            switch (tableMenu) {
                case 1:
                    operationMenu.showOperationMenu("Countries");
                    break;
                case 2:
                    operationMenu.showOperationMenu("Departments");
                    break;
                case 3:
                    operationMenu.showOperationMenu("Employees");
                    break;
                case 4:
                    operationMenu.showOperationMenu("Jobs");
                    break;
                case 5:
                    operationMenu.showOperationMenu("Locations");
                    break;
                case 6:
                    operationMenu.showOperationMenu("Regions");
                    break;
                case 7:
                    System.out.println("Terima kasih telah menggunakan program!");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
                    break;
            }
        } while (tableMenu < 1 || tableMenu > 7 || tableMenu != 7);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.departments;

import daos.DepartmentDao;
import java.util.Scanner;
import models.Department;

/**
 *
 * @author abiyyuramadhan
 */
public class UpdateDepartment {
    Scanner scanner = new Scanner(System.in);
    
    public void updateDepartments(DepartmentDao departmentDao) {
        System.out.println("Masukkan Department id: ");
        int departmentId = scanner.nextInt();
        System.out.println("Masukkan Department name: ");
        scanner.nextLine();
        String departmentName = scanner.nextLine();
        System.out.println("Masukkan Manager id: ");
        int managerId = scanner.nextInt();
        System.out.println("Masukkan Location id:");
        int locationId = scanner.nextInt();
        
        if (departmentDao.update(new Department(departmentId, departmentName, managerId, locationId))) {
            System.out.println("Update data berhasil!");
        } else {
            System.out.println("Update data gagal!");
        }
    }
}


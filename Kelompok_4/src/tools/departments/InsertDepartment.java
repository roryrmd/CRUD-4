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
public class InsertDepartment {
    Scanner scanner = new Scanner(System.in);
    public void insertDepartments(DepartmentDao departmentDao) {
        System.out.println("Masukkan Department id: ");
        int departmentId = scanner.nextInt();
        System.out.println("Masukkan Department name: ");
        scanner.nextLine();
        String departmentName = scanner.nextLine();
        System.out.println("Masukkan Manager id: ");
        int managerId = scanner.nextInt();
        System.out.println("Masukkan Location id:");
        int locationId = scanner.nextInt();
        
        if (departmentDao.insert(new Department(departmentId, departmentName, managerId, locationId))) {
            System.out.println("Insert data berhasil!");
        } else {
            System.out.println("Insert data gagal!");
        }
    }
}

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
public class DeleteDepartment {
    Scanner scanner = new Scanner(System.in);
    
    public void deleteDepartments(DepartmentDao departmentDao) {
        System.out.println("Pilih Department id yang mau dihapus: ");
        int departmentId = scanner.nextInt();
        
        
        
        if (departmentDao.delete(departmentId)) {
            System.out.println("Delete data berhasil!");
        } else {
            System.out.println("Delete data gagal!");
        }
    }
}

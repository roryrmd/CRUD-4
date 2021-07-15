/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Employees;

import daos.CountryDao;
import daos.EmployeeDAO;
import java.util.Scanner;
import models.Country;
import models.Employee;

/**
 *
 * @author Rory
 */
public class DeleteEmployee {
    Scanner scanner = new Scanner(System.in);
    public void deleteEmployee(EmployeeDAO employeeDao) {
        int employee_id = 0;
        
        System.out.print("Pilih Employee ID yang ingin dihapus: "); employee_id = scanner.nextInt();
        
        Employee employee = new Employee();
        employee.setEmployee_id(employee_id);
        
        if (employeeDao.delete(employee)) {
            System.out.println("Delete data berhasil!");
        } else {
            System.out.println("Delete data gagal!");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Employees;

import daos.EmployeeDAO;
import java.util.Scanner;
import models.Employee;

/**
 *
 * @author Rory
 */
public class UpdateEmployee {
    Scanner scanner = new Scanner(System.in);
    public void updateEmployee(EmployeeDAO employeeDao) {
        String first_name = "", last_name = "", email = "", phone_number = "", hire_date = "", job_id = "";
        int employee_id = 0, manager_id = 0, department_id = 0;
        double salary = 0, commission_pct = 0;
        
        System.out.print("Masukkan Employee ID:         "); employee_id = scanner.nextInt();
        System.out.print("Masukkan Employee First Name: "); scanner.nextLine(); first_name = scanner.nextLine();
        System.out.print("Masukkan Employee Last Name:  "); last_name = scanner.nextLine();
        System.out.print("Masukkan Employee Email:      "); email = scanner.nextLine();
        System.out.print("Masukkan Employee Phone Number: "); phone_number = scanner.nextLine();
        System.out.print("Masukkan Employee Hire Date:  "); hire_date = scanner.nextLine();
        System.out.print("Masukkan Job ID:              "); job_id = scanner.nextLine();
        System.out.print("Masukkan Salary:              "); salary = scanner.nextDouble();
        System.out.print("Masukkan Commission_pct:      "); commission_pct = scanner.nextDouble();
        System.out.print("Masukkan Manager ID:          "); manager_id = scanner.nextInt();
        System.out.print("Masukkan Department ID:       "); department_id = scanner.nextInt();
        
        Employee employee = new Employee();
        employee.setFirst_name      (first_name);
        employee.setLast_name       (last_name);
        employee.setEmail           (email);
        employee.setPhone_number    (phone_number);
        employee.setHire_date       (hire_date);
        employee.setJob_id          (job_id);
        employee.setSalary          (salary);
        employee.setCommission_pct  (commission_pct);
        employee.setManager_id      (manager_id);
        employee.setDepartment_id   (department_id);
        employee.setEmployee_id     (employee_id);
        
        if (employeeDao.update(employee)) {
            System.out.println("update data berhasil!");
        } else {
            System.out.println("update data gagal!");
        }
    }
}

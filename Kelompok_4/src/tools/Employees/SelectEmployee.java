/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Employees;

import daos.EmployeeDAO;
import models.Employee;

/**
 *
 * @author Rory
 */
public class SelectEmployee {
    public void selectEmployee(EmployeeDAO employeeDAO) {
        System.out.println("");
        for (Employee country : employeeDAO.getAll()) {
            System.out.println(country.toString());
        }
    }
}

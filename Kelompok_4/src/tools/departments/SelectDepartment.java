/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.departments;

import daos.DepartmentDao;
import models.Department;

/**
 *
 * @author abiyyuramadhan
 */
public class SelectDepartment {
    public void selectDepartments(DepartmentDao departmentDao) {
        System.out.println("");
        for (Department department : departmentDao.getAll()) {
            System.out.println(department.toString());
        }
    }
}

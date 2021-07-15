/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Department;

/**
 *
 * @author abiyyuramadhan
 */
public class DepartmentDao {
    private Connection connection;
    
    public DepartmentDao(Connection connection) {
        this.connection = connection;
    }
    
    public List<Department> getAll() {
        List<Department> departmentList = new ArrayList<>();
        String query = "SELECT * FROM departments";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {                
                Department department = new Department();
                
                department.setDepartmentId(resultSet.getInt(1));
                department.setDepartmentName(resultSet.getString(2));
                department.setManagerId(resultSet.getInt(3));
                department.setLocationId(resultSet.getInt(4));
                
                departmentList.add(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departmentList;
    }
    
    public boolean insert(Department department) {
        boolean result = false;
        
        String query = 
                "INSERT INTO departments(department_id, department_name, manager_id, location_id) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, department.getDepartmentId());
            preparedStatement.setString(2, department.getDepartmentName());
            preparedStatement.setInt(3, department.getManagerId());
            preparedStatement.setInt(4, department.getLocationId());
            preparedStatement.executeQuery();
            
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    
    public boolean update(Department department) {
        boolean result = false;
        
        String query = "UPDATE departments SET department_name=?, manager_id=?, location_id=? WHERE department_id=?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setInt(2, department.getManagerId());
            preparedStatement.setInt(3, department.getLocationId());
            preparedStatement.setInt(4, department.getDepartmentId());
            preparedStatement.executeQuery();
            
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    
    public boolean delete(Department department) {
        boolean result = false;
        String query = "DELETE FROM departments WHERE department_id=?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, department.getDepartmentId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}

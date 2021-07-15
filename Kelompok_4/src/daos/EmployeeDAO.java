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
import models.Employee;

public class EmployeeDAO {
    private final Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<Employee>();
        String query = "SELECT * FROM EMPLOYEES";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet                 = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee e = new Employee();
                e.setEmployee_id    (resultSet.getInt   (1));
                e.setFirst_name     (resultSet.getString(2));
                e.setLast_name      (resultSet.getString(3));
                e.setEmail          (resultSet.getString(4));
                e.setPhone_number   (resultSet.getString(5));
                e.setHire_date      (resultSet.getString(6));
                e.setJob_id         (resultSet.getString(7));
                e.setSalary         (resultSet.getDouble(8));
                e.setCommission_pct (resultSet.getDouble(9));
                e.setManager_id     (resultSet.getInt   (10));
                e.setDepartment_id  (resultSet.getInt   (11));
                employees.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
      
    public boolean insert(Employee employee) {
        boolean result = false;
        String query = "INSERT INTO EMPLOYEES(employee_id, first_name, "
                     + "last_name, email, phone_number, hire_date, job_id, "
                     + "salary, commission_pct, manager_id, department_id) "
                     + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt    (1, employee.getEmployee_id());
            preparedStatement.setString (2, employee.getFirst_name());
            preparedStatement.setString (3, employee.getLast_name());
            preparedStatement.setString (4, employee.getEmail());
            preparedStatement.setString (5, employee.getPhone_number());
            preparedStatement.setString (6, employee.getHire_date());
            preparedStatement.setString (7, employee.getJob_id());
            preparedStatement.setDouble (8, employee.getSalary());
            preparedStatement.setDouble (9, employee.getCommission_pct());
            preparedStatement.setInt    (10, employee.getManager_id());
            preparedStatement.setInt    (11, employee.getDepartment_id());
            
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
            }
        return result;
    }
    
    public boolean update(Employee employee) {
        boolean result = false;
        String query = "UPDATE EMPLOYEES SET first_name =?, last_name =?, email =?, "
                     + "phone_number =?, hire_date =?, job_id =?, salary =?, commission_pct =?, "
                     + "manager_id =?, department_id =? WHERE employee_id =? ";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString (1, employee.getFirst_name());
            preparedStatement.setString (2, employee.getLast_name());
            preparedStatement.setString (3, employee.getEmail());
            preparedStatement.setString (4, employee.getPhone_number());
            preparedStatement.setString (5, employee.getHire_date());
            preparedStatement.setString (6, employee.getJob_id());
            preparedStatement.setDouble (7, employee.getSalary());
            preparedStatement.setDouble (8, employee.getCommission_pct());
            preparedStatement.setInt    (9, employee.getManager_id());
            preparedStatement.setInt    (10, employee.getDepartment_id());
            preparedStatement.setInt    (11, employee.getEmployee_id());
            
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
            }
        return result;
    }
    
    public boolean delete(Employee employee) {
        boolean result = false;
        String query = "DELETE FROM EMPLOYEES WHERE employee_id=? ";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, employee.getEmployee_id());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
            }
        return result;
    }
}

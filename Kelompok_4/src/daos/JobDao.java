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
import models.Job;

/**
 *
 * @author abiyyuramadhan
 */
public class JobDao {
    private Connection connection;
    
    public JobDao(Connection connection) {
        this.connection = connection;
    }
    
    public List<Job> getAll() {
        List<Job> jobList = new ArrayList<>();
        String query = "SELECT * FROM jobs";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                Job job = new Job();
                
                job.setJobId(resultSet.getString(1));
                job.setJobTitle(resultSet.getString(2));
                job.setMinSalary(resultSet.getInt(3));
                job.setMaxSalary(resultSet.getInt(4));
                
                jobList.add(job);
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobList;
    }
    
    public boolean insert(Job job) {
        boolean result = false;
        
        String query = 
                "INSERT INTO jobs(job_id, job_title, min_salary, max_salary) VALUES(?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, job.getJobId());
            preparedStatement.setString(2, job.getJobTitle());
            preparedStatement.setInt(3, job.getMinSalary());
            preparedStatement.setInt(4, job.getMaxSalary());
            preparedStatement.executeQuery();
            
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    
    public boolean update(Job job) {
        boolean result = false;
        
        String query = "UPDATE jobs SET job_title=?, min_salary=?, max_salary=? WHERE job_id=?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, job.getJobTitle());
            preparedStatement.setInt(2, job.getMinSalary());
            preparedStatement.setInt(3, job.getMaxSalary());
            preparedStatement.setString(4, job.getJobId());
            preparedStatement.executeQuery();
            
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    
    public boolean delete(String job) {
        boolean result = false;
        String query = "DELETE FROM jobs WHERE job_id=?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, job);
            preparedStatement.executeQuery();
            
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}

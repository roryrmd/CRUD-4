/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author abiyyuramadhan
 */
public class Department {
    private int departmentId;
    private String departmentName;
    private int managerId;
    private int locationId;

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getLocationId() {
        return locationId;
    }

    @Override
    public String toString() {
        return "Department{departmentId =" + this.departmentId + 
                ", departmentName =" + this.departmentName +
                ", managerId =" + this.managerId +
                ", locationId =" + this.locationId + "}";
    }
    
    
}

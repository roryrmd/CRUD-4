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
public class Job {
    private int jobId;
    private String jobTitle;
    private int minSalary;
    private int maxSalary;

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    @Override
    public String toString() {
        return "Job{jobId=" + this.jobId +
                ", jobTitle=" + this.jobTitle + 
                ", minSalary=" + this.minSalary +
                ", maxSalary=" + this.maxSalary + "}";
    }
    
    
}

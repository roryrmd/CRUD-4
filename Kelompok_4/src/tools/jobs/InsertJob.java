/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.jobs;

import daos.JobDao;
import java.util.Scanner;
import models.Job;

/**
 *
 * @author abiyyuramadhan
 */
public class InsertJob {
    Scanner scanner = new Scanner(System.in);
    public void insertJobs(JobDao jobDao) {
        System.out.println("Masukkan job id: ");
        String jobId = scanner.nextLine();
        System.out.println("Masukkan job title: ");
        String jobTitle = scanner.nextLine();
        System.out.println("Masukkan min salary: ");
        int minSalary = scanner.nextInt();
        System.out.println("Masukkan max salary: " + minSalary);
        int maxSalary = scanner.nextInt();
        
        if (jobDao.insert(new Job(jobId, jobTitle, minSalary, maxSalary))) {
            System.out.println("Insert data berhasil");
        } else {
            System.out.println("Insert data gagal");
        }
    }
}

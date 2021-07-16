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
public class UpdateJob {
    Scanner scanner = new Scanner(System.in);
    
    public void updateJobs(JobDao jobDao) {
        System.out.println("Masukkan job id: ");
        String jobId = scanner.nextLine();
        System.out.println("Masukkan job title: ");
        String jobTitle = scanner.nextLine();
        System.out.println("Masukkan min salary: ");
        int minSalary = scanner.nextInt();
        System.out.println("Masukkan max salary: ");
        int maxSalary = scanner.nextInt();
        
         if (jobDao.update(new Job(jobId, jobTitle, minSalary, maxSalary))) {
            System.out.println("Update data berhasil");
        } else {
            System.out.println("Update data gagal");
        }
    }
}

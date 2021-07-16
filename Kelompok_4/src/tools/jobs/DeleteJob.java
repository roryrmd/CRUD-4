/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.jobs;

import daos.JobDao;
import java.util.Scanner;

/**
 *
 * @author abiyyuramadhan
 */
public class DeleteJob {
    Scanner scanner = new Scanner(System.in);
    
    public void deleteJobs(JobDao jobDao) {
        System.out.println("Pilih job id yang mau dihapus: ");
        String jobId = scanner.nextLine();
        
        if (jobDao.delete(jobId)) {
            System.out.println("Delete data berhasil!");
        } else {
            System.out.println("Delete data gagal!");
        }
    }
}

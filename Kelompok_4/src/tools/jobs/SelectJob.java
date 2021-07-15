/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.jobs;

import daos.JobDao;
import models.Job;

/**
 *
 * @author abiyyuramadhan
 */
public class SelectJob {
    public void selectJobs(JobDao jobDao) {
        System.out.println("");
        for (Job job : jobDao.getAll()) {
            System.out.println(job.toString());
        }
    }
}

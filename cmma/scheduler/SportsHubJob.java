/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.scheduler;

/**
 *
 * @author A0120035A
 */
import com.ihpc.cmma.business.SportsHubBusiness;
import com.ihpc.cmma.exception.CmmaAppException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class SportsHubJob extends SpringBeanAutowiringSupport implements Job {

    @Autowired
    private SportsHubBusiness business;

    public SportsHubBusiness getBusiness() {
        return business;
    }

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        Logger.getLogger(SportsHubJob.class.getName()).log(Level.INFO, "::In Scheduler");
        try {
            Logger.getLogger(SportsHubJob.class.getName()).log(Level.INFO, "::Scheduler-Start()");
            business.updateCrowdBusiness();
            Logger.getLogger(SportsHubJob.class.getName()).log(Level.INFO, "::Scheduler-End()");
        } catch (CmmaAppException ex) {
            Logger.getLogger(SportsHubJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

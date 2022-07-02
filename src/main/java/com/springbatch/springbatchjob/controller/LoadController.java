package com.springbatch.springbatchjob.controller;

import com.springbatch.springbatchjob.models.BankTransaction;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@EnableScheduling
public class LoadController {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @GetMapping("/load")
    @Scheduled(cron = "0 */1 * * * ?") //Demarrage du job toutes les 1 minutes
    public BatchStatus load() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        Map<String, JobParameter> maps=new HashMap<>();
        maps.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters parameters=new JobParameters(maps);
        JobExecution jobExecution= jobLauncher.run(job,parameters);
        System.out.println("batch running...");
        while (jobExecution.isRunning()){
            System.out.println("...");
        }
        return jobExecution.getStatus();
    }
}

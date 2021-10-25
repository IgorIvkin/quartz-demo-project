package com.igorivkin.quartzdemo.config;

import com.igorivkin.quartzdemo.job.TypicalJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TypicalJobConfiguration {

    @Bean
    public JobDetail typicalJobDetail() {
        return JobBuilder.newJob(TypicalJob.class)
                .storeDurably(true)
                .withIdentity("typicalJob")
                .withDescription("Do a typical job")
                .build();
    }

    @Bean
    public Trigger typicalJobTrigger(JobDetail typicalJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(typicalJobDetail)
                .withIdentity("typicalJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * 1/1 * ? *"))
                .build();
    }
}

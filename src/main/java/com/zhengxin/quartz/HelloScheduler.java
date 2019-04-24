package com.zhengxin.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhengxin
 * @date 2018-08-12 11:07:50
 */
public class HelloScheduler {


    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("helloJob", "JobDetailGroup1").build();
        System.out.println("JobDetail name: " + jobDetail.getKey().getName());
        System.out.println("JobDetail group: " + jobDetail.getKey().getGroup());
        System.out.println("JobDetail class: " + jobDetail.getJobClass().getName());


        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("helloTrigger", "triggerGroup1")
                .startNow().withSchedule(SimpleScheduleBuilder
                        .simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();


        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time is : " + sf.format(date));

        scheduler.scheduleJob(jobDetail, trigger);

    }

}

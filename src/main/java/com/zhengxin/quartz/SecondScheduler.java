package com.zhengxin.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhengxin
 * @date 2018-08-12 11:07:50
 */
public class SecondScheduler {


    public static void main(String[] args) throws SchedulerException {


        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time is : " + sf.format(date));


        JobDetail jobDetail = JobBuilder.newJob(SecondJob.class)
                .withIdentity("secondJob", "JobDetailGroup1")
//                .usingJobData("jobMsg", "hello second job")
//                .usingJobData("jobFloatValue", 3.14F)
                .build();

        Date startTime = new Date(date.getTime() + 3000L);
        Date endTime = new Date(date.getTime() + 6000L);
        System.out.println("Start Time is : " + sf.format(startTime));
        System.out.println("End Time is : " + sf.format(endTime));

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("secondTrigger", "triggerGroup1")
//                .usingJobData("triggerMsg", "hello second trigger")
//                .usingJobData("triggerDoubleValue", 2.0D)
//                .startNow()
                .startAt(startTime)
                .endAt(endTime)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();


        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);

    }

}

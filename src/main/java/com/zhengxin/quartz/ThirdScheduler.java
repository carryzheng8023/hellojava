package com.zhengxin.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhengxin
 * @date 2018-08-12 11:07:50
 */
public class ThirdScheduler {


    public static void main(String[] args) throws SchedulerException {


        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time is : " + sf.format(date));


        JobDetail jobDetail = JobBuilder.newJob(ThirdJob.class)
                .withIdentity("secondJob", "JobDetailGroup1")
                .build();


        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("secondTrigger", "triggerGroup1")
                .withSchedule(CronScheduleBuilder
//                        /代表间隔的时间 ,代表和 -代表至
//                        .cronSchedule("* * * * * ? *"))//秒 分 小时 日 月 周 年
//                        .cronSchedule("0 15 10 ? * *"))//每天10点15分触发
//                        .cronSchedule("0 0/5 14 * * ?"))//每天下午2点到2分59分（整点开始，每隔5分钟触发）
//                        .cronSchedule("0 15 10 ? * MON-FRI"))//从周一到周五每天上午10点15分触发
//                        .cronSchedule("0 15 10 ? * 6#3"))//每月的第三个周的星期五的10点15分开始出发
//                        .cronSchedule("0 15 10 ? * 6L 2016-2017"))//从2016年到2017年每月最后一周的星期五的10点15分触发
//                        .cronSchedule("0 15 10 * * ? 2017"))//2017年每天10点15分触发一次
                        .cronSchedule("* * * * * ?"))
                .build();


        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);

        //schedule执行两秒后挂起
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.standby();
//        scheduler.shutdown();

        //schedule挂起3秒后继续执行
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduler.start();
    }

}

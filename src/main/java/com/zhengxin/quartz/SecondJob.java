package com.zhengxin.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhengxin
 * @date 2018-08-12 11:04:23
 */
public class SecondJob implements Job {

//    //通过属性注入传参 开始
//    private String jobMsg;
//    private Float jobFloatValue;
//    private String triggerMsg;
//    private Double triggerDoubleValue;
//
//    public String getJobMsg() {
//        return jobMsg;
//    }
//
//    public void setJobMsg(String jobMsg) {
//        this.jobMsg = jobMsg;
//    }
//
//    public Float getJobFloatValue() {
//        return jobFloatValue;
//    }
//
//    public void setJobFloatValue(Float jobFloatValue) {
//        this.jobFloatValue = jobFloatValue;
//    }
//
//    public String getTriggerMsg() {
//        return triggerMsg;
//    }
//
//    public void setTriggerMsg(String triggerMsg) {
//        this.triggerMsg = triggerMsg;
//    }
//
//    public Double getTriggerDoubleValue() {
//        return triggerDoubleValue;
//    }
//
//    public void setTriggerDoubleValue(Double triggerDoubleValue) {
//        this.triggerDoubleValue = triggerDoubleValue;
//    }
//    //通过属性注入传参 结束

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //打印当前的执行时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time is : " + sf.format(date));
        //编写具体的业务逻辑
        //TODO 书写定时任务代码

        JobKey jobKey = context.getJobDetail().getKey();
        System.out.println("jobName: " + jobKey.getName() + ", jobGroup:" + jobKey.getGroup());

        TriggerKey triggerKey = context.getTrigger().getKey();
        System.out.println("triggerName: " + triggerKey.getName() + ", triggerGroup:" + triggerKey.getGroup());




//        //通过JobDataMap获取传参 开始
//        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
//        JobDataMap triggerDataMap = context.getTrigger().getJobDataMap();
//        JobDataMap dataMap = context.getMergedJobDataMap();
//
//        String jobMsg = dataMap.getString("jobMsg");
//        Float jobFloatValue = dataMap.getFloatValue("jobFloatValue");
//
//        String triggerMsg = dataMap.getString("triggerMsg");
//        Double triggerDoubleValue = dataMap.getDoubleValue("triggerDoubleValue");
//
//        System.out.println("jobMsg: " + jobMsg);
//        System.out.println("jobFloatValue: " + jobFloatValue);
//        System.out.println("triggerMsg: " + triggerMsg);
//        System.out.println("triggerDoubleValue: " + triggerDoubleValue);
//        //通过JobDataMap获取传参 结束

    }
}

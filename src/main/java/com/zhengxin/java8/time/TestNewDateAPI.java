package com.zhengxin.java8.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * @author zhengxin
 * @date 2018-05-06 15:53:19
 */
public class TestNewDateAPI {

    //1. LocalDate、LocalTime、LocalDateTime
    @Test
    public void test1(){

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2018, 06, 06, 13, 10 ,43);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.plusYears(1);
        System.out.println(ldt3);

        LocalDateTime ldt4 = ldt.minusMonths(2);
        System.out.println(ldt4);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());


    }

    //2. Instant : 时间戳。 （使用 Unix 元年  1970年1月1日 00:00:00 到某个时间所经历的毫秒值）
    @Test
    public void test2(){

        Instant ins1 = Instant.now();//默认获取UTC时区
        System.out.println(ins1);

        OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(ins1.toEpochMilli());



    }

    //3.
    //Duration : 用于计算两个“时间”间隔
    @Test
    public void test3(){
        Instant ins1 = Instant.now();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant ins2 = Instant.now();
        Duration duration = Duration.between(ins1, ins2);
        System.out.println(duration.toMillis());

        System.out.println("---------------------------");

        LocalTime lt1 = LocalTime.now();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalTime lt2 = LocalTime.now();
        System.out.println(Duration.between(lt1, lt2).toMillis());

    }

    //Period : 用于计算两个“日期”间隔
    @Test
    public void test4(){
        LocalDate ld1 = LocalDate.of(2011, 7, 18);
        LocalDate ld2 = LocalDate.now();

        Period period = Period.between(ld1, ld2);
        System.out.println(period);
    }



    //4. TemporalAdjuster : 时间校正器
    @Test
    public void test5(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(2);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(ldt3);

        //自定义：下一个工作日
        LocalDateTime ldt4 = ldt.with((l) -> {
            LocalDateTime localDateTime = (LocalDateTime) l;
            DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY))
                return localDateTime.plusDays(3);
            else if(dayOfWeek.equals(DayOfWeek.SATURDAY))
                return localDateTime.plusDays(2);
            else return localDateTime.plusDays(1);
        });

        System.out.println(ldt4);
    }


    //5. DateTimeFormatter : 解析和格式化日期或时间
    @Test
    public void test6(){

        LocalDateTime ldt = LocalDateTime.now();

        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        String strDate = ldt.format(dtf);
        System.out.println(strDate);

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDate2 = ldt.format(dtf2);
        System.out.println(strDate2);

        LocalDateTime newDate = LocalDateTime.parse(strDate2, dtf2);
        System.out.println(newDate);

    }

    //6.ZonedDate、ZonedTime、ZonedDateTime ： 带时区的时间或日期
    @Test
    public void test7(){
        Set<String> set =  ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }

    @Test
    public void test8(){
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt);

        ZonedDateTime zdt = ldt.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);

    }

}

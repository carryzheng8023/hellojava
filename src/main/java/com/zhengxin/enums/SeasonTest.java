package com.zhengxin.enums;

/**
 * @author zhengxin
 * @date 2018-06-27 13:33:24
 */


class Season{

    public static final Season SPRING = new Season("Spring", "春暖花开");
    public static final Season SUMMER = new Season("Summer", "夏日炎炎");
    public static final Season AUTUMN = new Season("Autumn", "秋高气爽");
    public static final Season WINTER = new Season("Winter", "白雪皑皑");

    private final String name;
    private final String desc;

    private Season(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public void show(){
        System.out.println("这是一个季节");
    }



}

public class SeasonTest {

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
        Season.AUTUMN.show();
    }
}

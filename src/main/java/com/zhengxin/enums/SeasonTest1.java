package com.zhengxin.enums;

/**
 * @author zhengxin
 * @date 2018-06-27 13:33:24
 */


enum Season1 implements Info{

    SPRING("Spring", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("Summer", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天在哪里");
        }
    },
    AUTUMN("Autumn", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天在哪里");
        }
    },
    WINTER("Winter", "白雪皑皑"){
        @Override
        public void show() {
            System.out.println("冬天在哪里");
        }
    };

    private final String name;
    private final String desc;

    Season1(String name, String desc){
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

    @Override
    public void show(){
        System.out.println("这是一个季节");
    }


}

interface Info{
    void show();
}

public class SeasonTest1 {

    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring);
        Season1.AUTUMN.show();

        for(Season1 s : Season1.values())
            System.out.println(s);

        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);

//        for(Thread.State state : Thread.State.values())
//            System.out.println(state);


    }
}

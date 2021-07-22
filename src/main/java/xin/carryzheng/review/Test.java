package xin.carryzheng.review;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zhengxin
 * @date 2021-06-21 23:52:18
 */
public class Test {

    public Test() {
        System.out.println("Test类无参构造器");
    }

    {
        System.out.println("Main类代码块");
    }

    static {
        System.out.println("Main类静态代码块");

    }

    public static void main(String[] args) {
//        Thread t = new Thread();
//        t.start();
//        t.start();

//        long maxMemory = Runtime.getRuntime().maxMemory();
//        long totalMemory = Runtime.getRuntime().totalMemory();
//
//        System.out.println(maxMemory / 1024 / 1024);
//        System.out.println(totalMemory / 1024 / 1024);


//        byte[] bytes = new byte[40 * 1024 * 1024];


//        String str = "c";
//        while (true){
//            str += str + new Random().nextInt(88888888) + new Random().nextInt(99999999);
//        }

//        A a = new A();
//        System.out.println(a.m);

        System.out.println(System.getProperty("java.class.path"));


        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<MiniCat> miniCats = new ArrayList<>();

//        show(animals);
        show(cats);
        show(miniCats);

        show2(animals);
        show2(cats);
//        show2(miniCats);

        ArrayList<String>[] strArr = new ArrayList[5];

    }

    public static void show(List<? extends Cat> list){
//        list.add(new Animal());
//        list.add(new Cat());
//        list.add(new MiniCat());
    }

    public static void show2(List<? super Cat> list){
//        list.add(new Animal());
        list.add(new Cat());
        list.add(new MiniCat());
    }
}

class Animal{}
class Cat extends Animal{}
class MiniCat extends Cat{}

class A {

    {
        System.out.println("A类代码块");
    }

    static {
        System.out.println("A类静态代码块");
        m = 300;
    }



    static int m = 100;

    public A() {
        System.out.println("A类无参构造器");
    }
}

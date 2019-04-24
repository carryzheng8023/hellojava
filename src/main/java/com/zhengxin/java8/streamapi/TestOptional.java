package com.zhengxin.java8.streamapi;

/**
 * @author zhengxin
 * @date 2018-05-06 10:57:03
 */

import org.junit.Test;

import java.util.Optional;

/**
 * 一、Optional 容器类：用于尽量避免空指针异常
 * 	Optional.of(T t) : 创建一个 Optional 实例
 * 	Optional.empty() : 创建一个空的 Optional 实例
 * 	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * 	isPresent() : 判断是否包含值
 * 	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 * 	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * 	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * 	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class TestOptional {

    @Test
    public void test1(){
        Optional<Employee> op = Optional.of(null);
        Employee emp = op.get();
        System.out.println(emp);
    }

    @Test
    public void test2(){
        Optional<Employee> op = Optional.empty();
        System.out.println(op.get());
    }

    @Test
    public void test3(){
        Optional<Employee> op = Optional.ofNullable(null);
//        if(op.isPresent())
//            System.out.println(op.get());

        //默认值
//        Employee employee = op.orElse(new Employee(101, "张三", 18, 6666.66,Employee.Status.AVAILABLE));
//        System.out.println(employee);

        Employee employee2 = op.orElseGet(() -> {
            System.out.println("进行一些操作，然后返回需要的对象");
            return new Employee();
        });

    }

    @Test
    public void test4(){

        Optional<Employee> op = Optional.ofNullable(new Employee(101, "张三", 18, 6666.66,Employee.Status.AVAILABLE));

//        Optional<String> str = op.map(e -> e.getName());
//        System.out.println(str.get());

        Optional<String> str2 = op.flatMap(e -> Optional.of(e.getName()));
        System.out.println(str2.get());

    }

    //需求：获取一个男人心中女神的名字
    @Test
    public void test5(){

        Man man = new Man();
        String name = getGodnessName(man);
        System.out.println(name);
    }

    private String getGodnessName(Man man){
        if(null != man){
            Godness g = man.getGod();
            if(null != g){
                return g.getName();
            }
        }

        return "默认值";
    }


    //运用 Optional 的实体类
    @Test
    public void test6(){
        NewMan man = new NewMan(new Godness("g"));
        System.out.println(getGodnessName2(null));
    }

    private String getGodnessName2(NewMan man){

        return Optional.ofNullable(man)
                .orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("默认值"))
                .getName();

    }





}

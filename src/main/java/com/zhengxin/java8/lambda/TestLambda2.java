package com.zhengxin.java8.lambda;

/**
 * @author zhengxin
 * @date 2018-05-05 13:48:35
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 一、Lambda 表达式的基础语法：Java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或 Lambda 操作符
 * 						    箭头操作符将 Lambda 表达式拆分成两部分：
 *
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需执行的功能， 即 Lambda 体
 *
 * 语法格式一：无参数，无返回值
 * 		() -> System.out.println("Hello Lambda!");
 *
 * 语法格式二：有一个参数，并且无返回值
 * 		(x) -> System.out.println(x)
 *
 * 语法格式三：若只有一个参数，小括号可以省略不写
 * 		x -> System.out.println(x)
 *
 * 语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
 *		Comparator<Integer> com = (x, y) -> {
 *			System.out.println("函数式接口");
 *			return Integer.compare(x, y);
 *		};
 *
 * 语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
 * 		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 *
 * 语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 * 		(Integer x, Integer y) -> Integer.compare(x, y);
 *
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 *
 * 二、Lambda 表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
 * 			 可以检查是否是函数式接口
 */
public class TestLambda2 {

    @Test
    public void test1(){

        int num = 0; //jdk1.7之前，必须是final

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world" + num);
            }
        };

        r.run();

        Runnable r1 = () -> System.out.println("Hello Lambda");

        r1.run();

    }

    @Test
    public void test2(){

        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("consumer");
    }

    @Test
    public void test3(){

        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4(){

        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> comparator2 = Integer::compare;

    }

    @Test
    public void test5(){
        String[] strs = {"aaa", "bbb", "ccc"};
//        strs = {"aaa", "bbb", "ccc"};
    }

    @Test
    public void test6(){

        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);

    }

    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }


    /*
     * 练习
     * */

    private List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 50, 3333.33),
            new Employee("王五", 37, 6666.66),
            new Employee("赵六", 16, 5555.55),
            new Employee("田七", 8, 7777.77)
    );

    @Test
    public void test7(){
        Collections.sort(employees, (e1, e2) -> {
            if(e1.getAge() == e2.getAge())
                return e1.getName().compareTo(e2.getName());
            else
                return -Integer.compare(e1.getAge(), e2.getAge());
        });

        for (Employee employee : employees)
            System.out.println(employee);
    }

    @Test
    public void test8(){
        System.out.println(strHandle("hello world", (str) -> str.toUpperCase()));
        System.out.println(strHandle("hello world", String::toUpperCase));
    }

    public String strHandle(String str, MyFunction mf){
        return mf.getValue(str);
    }


    @Test
    public void test9(){
        System.out.println(op(100L, 200L, (x, y) -> x + y));
        System.out.println(op(100L, 200L, (x, y) -> x * y));
    }

    public <T> T op(T t1, T t2, MF<T> mf){
        return mf.getValue(t1, t2);
    }
}

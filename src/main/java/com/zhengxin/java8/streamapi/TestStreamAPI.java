package com.zhengxin.java8.streamapi;

/**
 * @author zhengxin
 * @date 2018-05-05 15:43:16
 */


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 一、Stream API 的操作步骤：
 *
 * 1. 创建 Stream
 *
 * 2. 中间操作
 *
 * 	  筛选与切片
 * 	  filter——接收 Lambda ， 从流中排除某些元素。
 * 	  limit——截断流，使其元素不超过给定数量。
 * 	  skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
 *    distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
 *
 *
 * 3. 终止操作(终端操作)
 */
public class TestStreamAPI {

    //创建stream
    @Test
    public void test1(){

        //1. Collection 提供了两个方法  stream()串行流 与 parallelStream()并行流
        java.util.List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2. 通过 Arrays 中的 stream() 获取一个数组流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);

        //3. 通过 Stream 类中静态方法 of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //4. 创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

    }

    //中间操作
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66, Employee.Status.AVAILABLE),
            new Employee(101, "张三", 18, 9999.99, Employee.Status.BUSY),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.AVAILABLE)
    );

    /**
     * 筛选与切片
        filter——接收 Lambda ， 从流中排除某些元素。
        limit——截断流，使其元素不超过给定数量。
        skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     * */

    @Test
    public void test2(){
        emps.stream()
                .filter((e) -> e.getAge() > 35)
                .forEach(System.out::println);

    }

    @Test
    public void test3(){
        emps.stream().limit(2)
                .forEach(System.out::println);

    }

    @Test
    public void test4(){
        emps.stream().skip(2)
                .forEach(System.out::println);

    }

    /**
		映射
		map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
	 */

    @Test
    public void test5(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");

        list.stream()
                .map((e) -> e.toUpperCase())
                .forEach(System.out::println);

        System.out.println("------------------------------------");

        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("------------------------------------");

        list.stream()
                .map(TestStreamAPI::filterCharacter)
                .forEach((sm) -> sm.forEach(System.out::println));

        System.out.println("------------------------------------");

        list.stream()
                .flatMap(TestStreamAPI::filterCharacter)
                .forEach(System.out::println);
    }


    private static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()){
            list.add(ch);
        }

        return list.stream();
    }


    /**
		sorted()——自然排序
		sorted(Comparator com)——定制排序
	 */
    @Test
    public void test6(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");

        list.stream()
                .sorted()
                .forEach(System.out::println);

        emps.stream()
                .sorted((e1, e2)-> {
                    if(e1.getAge() == e2.getAge()){
                        return e1.getName().compareTo(e2.getName());
                    }else {
                        return -Integer.compare(e1.getAge(), e2.getAge());
                    }

                })
                .forEach(System.out::println);

    }

    //3. 终止操作
	/**
     * 查找与匹配
		allMatch——检查是否匹配所有元素
		anyMatch——检查是否至少匹配一个元素
		noneMatch——检查是否没有匹配的元素
		findFirst——返回第一个元素
		findAny——返回当前流中的任意元素
		count——返回流中元素的总个数
		max——返回流中最大值
		min——返回流中最小值
	 */

	@Test
    public void test7(){
	    boolean b1 = emps.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
	    System.out.println(b1);

        boolean b2 = emps.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        boolean b3 = emps.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b3);

        Optional<Employee> op = emps.stream()
                .sorted((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary()))
//                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .findFirst();
        System.out.println(op.get());

        Optional<Employee> op2 = emps.parallelStream()
                .filter((e) -> e.getStatus().equals(Employee.Status.AVAILABLE))
                .findAny();
        System.out.println(op2.get());

        Long count = emps.stream()
                .count();
        System.out.println(count);

        Optional<Employee> op3 = emps.stream()
//                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
                    .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(op3.get());

        Optional<Double> op4 = emps.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(op4.get());

    }



	/**
		归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
    @Test
    public void test8(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        Integer sum = list.stream()
                .reduce(100, (x, y) -> x + y);
        System.out.println(sum);

        System.out.println("------------------------------------");

        Optional<Double> op = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(op.get());


    }

    /**
     * 收集
     * collect——将流转换为其他形式，接收一个Collector接口的实现，用于stream中元素做汇总的方法
     * */
    @Test
    public void test9(){
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("------------------------------------");

        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        System.out.println("------------------------------------");

        HashSet<String> hashSet = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);

    }

    @Test
    public void test10(){
        //总数
        Long count = emps.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        System.out.println("------------------------------------");

        //平均值
        Double avg = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        System.out.println("------------------------------------");

        //总和
        Double sum = emps.stream()
                .collect(Collectors.summingDouble(e -> e.getSalary()));
        System.out.println(sum);

        System.out.println("------------------------------------");
        //最大值
        Optional<Employee> max = emps.stream()
//                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
                    .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(max.get());

        //最小值
        Optional<Double> min = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());

    }

    //分组
    @Test
    public void test11(){
        Map<Employee.Status, List<Employee>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    //多级分组
    @Test
    public void test12(){
        Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
                    if(e.getAge() <= 35)
                        return "青年";
                    else if(e.getAge() <= 50)
                        return "中年";
                    else
                        return "老年";
                })));

        System.out.println(map);

    }

    //分片
    @Test
    public void test13(){
        Map<Boolean, List<Employee>> map = emps.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 8000));
        System.out.println(map);
    }

    @Test
    public void test14(){
        DoubleSummaryStatistics dss = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getAverage());
        System.out.println(dss.getMax());
        System.out.println(dss.getSum());
    }

    @Test
    public void test15(){
        String str = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "===", "==="));
        System.out.println(str);

    }

    /**
	  	1.	给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
		，给定【1，2，3，4，5】， 应该返回【1，4，9，16，25】。
	 */
    @Test
    public void test16(){
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        Arrays.stream(nums)
                .map(x -> x * x)
                .forEach(System.out::println);
    }

    /**
	 2.	怎样用 map 和 reduce 方法数一数流中有多少个Employee呢？
	 */
    @Test
    public void test17(){
        Optional<Integer> count = emps.stream()
                .map(e -> 1)
                .reduce(Integer::sum);
        System.out.println(count.get());
    }







}

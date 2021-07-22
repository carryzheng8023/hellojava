package com.zhengxin.java8.lambda;

import org.junit.Test;

import java.util.*;

/**
 * @author zhengxin
 * @date 2018-05-05 13:17:50
 */
public class TestLambda1 {

    @Test
    public void test1(){

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(comparator);

    }


    public void test2(){
//        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
//        Comparator<Integer> comparator = (Integer x, Integer y) -> Integer.compare(x, y);

        Comparator<Integer> comparator = Integer::compare;

        TreeSet<Integer> ts = new TreeSet<>(comparator);

    }

    private List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 50, 3333.33),
            new Employee("王五", 37, 6666.66),
            new Employee("赵六", 16, 5555.55),
            new Employee("田七", 8, 7777.77)
    );


    @Test
    public void test3(){
        List<Employee> list = filterEmployees(employees);

        for(Employee employee : list)
            System.out.println(employee);
    }

    public List<Employee> filterEmployees(List<Employee> list){

        List<Employee> emps = new ArrayList<>();

        for (Employee employee : list){
            if(employee.getAge() >= 35)
                emps.add(employee);
        }

        return emps;

    }

    public List<Employee> filterEmployees2(List<Employee> list){

        List<Employee> emps = new ArrayList<>();

        for (Employee employee : list){
            if(employee.getSalary() >= 5000)
                emps.add(employee);
        }

        return emps;

    }

    //优化方式1：策略模式

    @Test
    public void test4(){
        List<Employee> list = filterEmployees(employees, new FilterEmployeeByAge());
        for (Employee employee : list)
            System.out.println(employee);

        System.out.println("---------------------------");

        List<Employee> list2 = filterEmployees(employees, new FilterEmployeeBySalary());
        for (Employee employee : list2)
            System.out.println(employee);
    }


    public List<Employee> filterEmployees(List<Employee> list, MyPredicate<Employee> mp){

        List<Employee> emps = new ArrayList<>();

        for (Employee employee : list){
            if(mp.test(employee))
                emps.add(employee);
        }

        return emps;

    }


    //优化方式2：匿名内部类
    @Test
    public void test5(){
        List<Employee> list = filterEmployees(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() <= 5000;
            }
        });

        for (Employee employee : list)
            System.out.println(employee);
    }


    //优化方式3：lambda表达式
    @Test
    public void test6(){
        List<Employee> list = filterEmployees(employees, (e) -> e.getSalary() >= 5000);
        list.forEach(System.out::println);
    }

    //优化方式4：Stream API
    @Test
    public void test7(){
        employees.stream()
                .filter((e) -> e.getSalary() >= 5000)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("---------------------------");

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }



}

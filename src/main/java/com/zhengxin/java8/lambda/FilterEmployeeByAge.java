package com.zhengxin.java8.lambda;

/**
 * @author zhengxin
 * @date 2018-05-05 13:31:27
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}

package com.zhengxin.java8.lambda;

/**
 * @author zhengxin
 * @date 2018-05-05 13:36:21
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}

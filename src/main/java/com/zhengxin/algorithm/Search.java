package com.zhengxin.algorithm;

import java.util.Arrays;
import java.util.List;
import static com.zhengxin.j2se.net.mindview.util.Print.print;

/**
 * Created by zhengxin on 16/6/7.
 */
public class Search {

    public static void main(String[] a){

        List<Integer> numbers = Arrays.asList(1,5,7,7,8);

        print("数组：" + numbers);
        print("5是否在数组中：" + Search.binarySearch(numbers, 5));
        print("10是否在数组中：" + Search.binarySearch(numbers, 10));


    }


    public static boolean binarySearch(final List<Integer> numbers, final Integer value){

        if(numbers == null || numbers.isEmpty())
            return false;

        final Integer comparsion = numbers.get(numbers.size() / 2);

        if(numbers.size() == 1 && !value.equals(comparsion))
            return false;

        if(value.equals(comparsion))
            return true;

        if(value < comparsion)
            return binarySearch(numbers.subList(0, numbers.size() / 2), value);
        else
            return binarySearch(numbers.subList(numbers.size() / 2, numbers.size()), value);
    }

}

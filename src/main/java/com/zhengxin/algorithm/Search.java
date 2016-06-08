package com.zhengxin.algorithm;

import java.util.Arrays;
import java.util.List;
import static com.zhengxin.j2se.net.mindview.util.Print.print;

/**
 * Created by zhengxin on 16/6/7.
 */
public class Search {

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

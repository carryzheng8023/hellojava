package com.zhengxin.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhengxin on 16/6/7.
 */
public class Sort {

    public static List<Integer> insertSort(final List<Integer> numbers){

        final List<Integer> sortedList = new LinkedList<>();

        originalList : for(Integer number : numbers){
            for(int i=0; i<sortedList.size(); i++){
                if(number < sortedList.get(i)){
                    sortedList.add(i, number);
                    continue originalList;
                }
            }

            sortedList.add(sortedList.size(), number);
        }

        return sortedList;

    }

    public static List<Integer> quickSort(List<Integer> numbers){

        if(numbers.size() < 2)
            return numbers;

        final Integer pivot = numbers.get(0);

        final List<Integer> lower = new ArrayList<>();
        final List<Integer> higher = new ArrayList<>();

        for (int i=1; i <numbers.size(); i++){
            if(numbers.get(i) < pivot)
                lower.add(numbers.get(i));
            else
                higher.add(numbers.get(i));
        }

        final List<Integer> sorted = quickSort(lower);

        sorted.add(pivot);

        sorted.addAll(quickSort(higher));

        return sorted;

    }


    public static List<Integer> mergeSort(final List<Integer> values){


        if(values.size() < 2)
            return values;

        final List<Integer> leftHalf = values.subList(0, values.size() / 2);
        final List<Integer> rightHalf = values.subList(values.size() / 2, values.size());

        return merge(mergeSort(leftHalf), mergeSort(rightHalf));

    }

    private static List<Integer> merge(final List<Integer> left, final List<Integer> right){

        int leftPtr = 0;
        int rightPtr = 0;

        final List<Integer> merged = new ArrayList<>(left.size() + right.size());

        while (leftPtr < left.size() && rightPtr < right.size()){
            if(left.get(leftPtr) < right.get(rightPtr)){
                merged.add(left.get(leftPtr));
                leftPtr++;
            } else {
                merged.add(right.get(rightPtr));
                rightPtr++;
            }
        }

        while (leftPtr < left.size()){
            merged.add(left.get(leftPtr));
            leftPtr++;
        }

        while (rightPtr < right.size()){
            merged.add(right.get(rightPtr));
            rightPtr++;
        }

        return merged;
    }
}

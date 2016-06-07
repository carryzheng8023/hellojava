package com.zhengxin.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 136931 on 2016/2/26.
 */

/**
 * 1.hashcode是用来查找的，如果你学过数据结构就应该知道，在查找和排序这一章有
 * 例如内存中有这样的位置
 * 0  1  2  3  4  5  6  7
 * 而我有个类，这个类有个字段叫ID,我要把这个类存放在以上8个位置之一，如果不用hashcode而任意存放，那么当查找时就需要到这八个位置里挨个去找，或者用二分法一类的算法。
 * 但如果用hashcode那就会使效率提高很多。
 * 我们这个类中有个字段叫ID,那么我们就定义我们的hashcode为ID％8，然后把我们的类存放在取得得余数那个位置。比如我们的ID为9，9除8的余数为1，那么我们就把该类存在1这个位置，如果ID是13，求得的余数是5，那么我们就把该类放在5这个位置。这样，以后在查找该类时就可以通过ID除 8求余数直接找到存放的位置了。
 *
 * 2.但是如果两个类有相同的hashcode怎么办那（我们假设上面的类的ID不是唯一的），例如9除以8和17除以8的余数都是1，那么这是不是合法的，回答是：可以这样。那么如何判断呢？在这个时候就需要定义 equals了。
 * 也就是说，我们先通过 hashcode来判断两个类是否存放某个桶里，但这个桶里可能有很多类，那么我们就需要再通过 equals 来在这个桶里找到我们要的类。
 * 那么。重写了equals()，为什么还要重写hashCode()呢？
 * 想想，你要在一个桶里找东西，你必须先要找到这个桶啊，你不通过重写hashcode()来找到桶，光重写equals()有什么用啊
 */
public class HashTest {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return i % 10;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof HashTest)) {
            return false;
        }
        HashTest other = (HashTest) object;
        if (other.getI() == this.getI()) {
            return true;
        }
        return false;
    }

    public final static void main(String[] args) {

        HashTest a = new HashTest();
        HashTest b = new HashTest();
        HashTest c = new HashTest();
        a.setI(1);
        b.setI(1);
        c.setI(11);
        Set<HashTest> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(set);
    }
}

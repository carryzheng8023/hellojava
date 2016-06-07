package com.zhengxin.j2se.generics;//: generics/CompilerIntelligence.java

import java.util.Arrays;
import java.util.List;
import static com.zhengxin.j2se.net.mindview.util.Print.print;

public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0); // No warning
        print(flist.contains(a));
        print(flist.contains(new Apple())); // Argument is 'Object'
        print(flist.indexOf(new Apple())); // Argument is 'Object'
    }
} ///:~

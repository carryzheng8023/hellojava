package com.zhengxin.j2se.typeinfo;//: typeinfo/BoundedClassReferences.java

import com.zhengxin.A;

public class BoundedClassReferences {
  public static void main(String[] args) {
    Class<? extends Number> bounded = int.class;
    bounded = double.class;
    bounded = Number.class;

    // Or anything else derived from Number.
  }
} ///:~

package com.zhengxin.j2se.generics;//: generics/ExplicitTypeSpecification.java

import com.zhengxin.j2se.net.mindview.util.*;
import com.zhengxin.j2se.typeinfo.pets.*;

import java.util.List;
import java.util.Map;

public class ExplicitTypeSpecification {
  static void f(Map<Person, List<Pet>> petPeople) {}
  public static void main(String[] args) {
    f(New.<Person, List<Pet>>map());
  }
} ///:~

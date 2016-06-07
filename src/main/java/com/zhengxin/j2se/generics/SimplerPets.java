package com.zhengxin.j2se.generics;//: generics/SimplerPets.java

import com.zhengxin.j2se.net.mindview.util.*;
import com.zhengxin.j2se.typeinfo.pets.*;

import java.util.List;
import java.util.Map;

public class SimplerPets {
  public static void main(String[] args) {
    Map<Person, List<? extends Pet>> petPeople = New.map();
    // Rest of the code is the same...
  }
} ///:~

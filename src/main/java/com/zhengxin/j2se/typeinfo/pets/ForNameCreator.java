//: typeinfo/pets/ForNameCreator.java
package com.zhengxin.j2se.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types = new ArrayList<>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "com.zhengxin.j2se.typeinfo.pets.Mutt",
    "com.zhengxin.j2se.typeinfo.pets.Pug",
    "com.zhengxin.j2se.typeinfo.pets.EgyptianMau",
    "com.zhengxin.j2se.typeinfo.pets.Manx",
    "com.zhengxin.j2se.typeinfo.pets.Cymric",
    "com.zhengxin.j2se.typeinfo.pets.Rat",
    "com.zhengxin.j2se.typeinfo.pets.Mouse",
    "com.zhengxin.j2se.typeinfo.pets.Hamster"
  };

  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add((Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }

  public List<Class<? extends Pet>> types() {return types;}
} ///:~

package com.zhengxin.j2se.holding;//: holding/PetMap.java

import com.zhengxin.j2se.typeinfo.pets.*;

import java.util.HashMap;
import java.util.Map;

import static com.zhengxin.j2se.net.mindview.util.Print.print;

public class PetMap {
  public static void main(String[] args) {
    Map<String,Pet> petMap = new HashMap<>();
    petMap.put("My Cat", new Cat("Molly"));
    petMap.put("My Dog", new Dog("Ginger"));
    petMap.put("My Hamster", new Hamster("Bosco"));
    print(petMap);
    Pet dog = petMap.get("My Dog");
    print(dog);
    print(petMap.containsKey("My Dog"));
    print(petMap.containsValue(dog));
  }
} /* Output:
{My Cat=Cat Molly, My Hamster=Hamster Bosco, My Dog=Dog Ginger}
Dog Ginger
true
true
*///:~

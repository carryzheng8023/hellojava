//: enumerated/Competitor.java
// Switching one enum on another.
package com.zhengxin.j2se.enumerated;

public interface Competitor<T extends Competitor<T>> {
  Outcome compete(T competitor);
} ///:~

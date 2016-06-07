package com.zhengxin.j2se.generics;//: generics/CuriouslyRecurringGeneric.java

class GenericType<T> {}

public class CuriouslyRecurringGeneric extends GenericType<CuriouslyRecurringGeneric> {} ///:~

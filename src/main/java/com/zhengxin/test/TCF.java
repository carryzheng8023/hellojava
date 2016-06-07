package com.zhengxin.test;

/**
 * Created by 136931 on 2016/2/24.
 */
public class TCF {
    static int f1() {
        try {
            return 1;
        } finally {
            System.out.print("f1");
        }
    }

    static int f2() {
        try {
            throw new Exception("try error");
        } catch (Exception e) {
            return 2;
        } finally {
            System.out.print("f2");
        }
    }

    static int f3() {
        try {
            throw new RuntimeException("try error");
        } catch (ArithmeticException e) {
            return 3;
        } finally {
            System.out.print("f3");
        }
    }

    static int f4() {
        try {
            throw new Exception("try error");
        } catch (Exception e) {
            throw new RuntimeException("catch error");
        } finally {
            System.out.print("f4");
        }
    }

    static int f5() {
        try {
            throw new Exception("try error");
        } catch (Exception e) {
            throw new RuntimeException("catch error");
        } finally {
            System.out.print("f5");
            return 5;
        }
    }

    static int f6() {
        try {
            throw new Exception("try error");
        } catch (Exception e) {
            throw new RuntimeException("catch error");
        } finally {
            System.out.print("f6");
            throw new RuntimeException("finally error");
        }
    }

    public static void main(String[] args) {
        System.out.println(" : " + f1());

        try {
            System.out.println(" : " + f2());
        } catch (Exception e) {
            System.out.println(" : " + e.getMessage());
        }

        try {
            System.out.println(" : " + f3());
        } catch (Exception e) {
            System.out.println(" : " + e.getMessage());
        }

        try {
            System.out.println(" : " + f4());
        } catch (Exception e) {
            System.out.println(" : " + e.getMessage());
        }

        try {
            System.out.println(" : " + f5());
        } catch (Exception e) {
            System.out.println(" : " + e.getMessage());
        }

        try {
            System.out.println(" : " + f6());
        } catch (Exception e) {
            System.out.println(" : " + e.getMessage());
        }
    }
}

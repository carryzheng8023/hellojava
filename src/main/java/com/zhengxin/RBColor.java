package com.zhengxin;

/**
 * @author zhengxin
 * @date 2018-05-03 10:26:50
 */
public class RBColor {
    public static final RBColor RED = new RBColor("red");
    public static final RBColor BLACK = new RBColor("black");
    private String name;

    public String getName() {
        return this.name;
    }

    private RBColor(String name) {
        this.name = name;
    }
}

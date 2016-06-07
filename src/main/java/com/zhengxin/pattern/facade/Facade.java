package com.zhengxin.pattern.facade;

/**
 * Created by 136931 on 2016/2/23.
 */
public class Facade {

    private SubSystemOne subSystemOne = new SubSystemOne();
    private SubSystemTwo subSystemTwo = new SubSystemTwo();
    private SubSystemThree subSystemThree = new SubSystemThree();

    public void methodA(){
        System.out.println("Facade : methodA");
        subSystemOne.methodOne();
        subSystemTwo.methodOne();
    }

    public void methodB(){
        System.out.println("Facade : methodB");
        subSystemTwo.methodOne();
        subSystemThree.methodOne();
    }

    public void methodC(){
        System.out.println("Facade : methodC");
        subSystemOne.methodOne();
        subSystemTwo.methodOne();
        subSystemThree.methodOne();
    }

}

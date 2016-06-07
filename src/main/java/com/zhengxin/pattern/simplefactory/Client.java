package com.zhengxin.pattern.simplefactory;

/**
 * Created by 136931 on 2016/2/23.
 * 简单工厂模式
 */
public class Client {

    public static void main(String[] args){
        String loginType = "domain";
        String name = "name";
        String password = "password";
        Login login = LoginManager.factory(loginType);
        boolean bool = login.verify(name, password);
        if (bool) {
            /**
             * 业务逻辑
             */
            System.out.print("登录成功！");
        } else {
            /**
             * 业务逻辑
             */
            System.out.print("登录失败！");
        }

    }

}

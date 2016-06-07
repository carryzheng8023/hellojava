package com.zhengxin.pattern.simplefactory;

/**
 * Created by 136931 on 2016/2/23.
 */
public class LoginManager {


    public static Login factory(String type){

        Login login = null;

        switch (type){
            case "password" : login = new PasswordLogin(); break;
            case "domain" : login = new DomainLogin(); break;
            default : throw new RuntimeException("没有找到登录类型");
        }

        return login;
    }

}

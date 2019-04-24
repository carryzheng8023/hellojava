package com.zhengxin.pattern.proxy.dynamic;

/**
 * @author zhengxin
 * @date 2018-01-31 11:34:54
 */
public class Client {

    public static void main(String[] args){
        LogHandler logHandler = new LogHandler();
        UserManager userManager = (UserManager)logHandler.newProxyInstance(new UserManagerImpl());

//        userManager.addUser("1111", "张三");
        userManager.findUser("1111");

    }

}

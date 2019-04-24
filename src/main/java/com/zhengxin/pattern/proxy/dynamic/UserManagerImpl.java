package com.zhengxin.pattern.proxy.dynamic;

/**
 * 动态代理实现
 * @author zhengxin
 * @date 2018-01-31 11:32:13
 */
public class UserManagerImpl implements UserManager{

    @Override
    public void addUser(String userId, String userName) {
        System.out.println("UserManagerImpl.addUser");
    }

    @Override
    public void delUser(String userId) {
        System.out.println("UserManagerImpl.delUser");
    }

    @Override
    public String findUser(String userId) {
        System.out.println("UserManagerImpl.findUser");
        return "张三";
    }

    @Override
    public void modifyUser(String userId, String userName) {
        System.out.println("UserManagerImpl.modifyUser");

    }




}

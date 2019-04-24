package com.zhengxin.pattern.proxy.dynamic;

/**
 *
 * 动态代理接口
 * @author zhengxin
 * @date 2018-01-31 11:31:47
 */
public interface UserManager {


    void addUser(String userId, String userName);

    void delUser(String userId);

    String findUser(String userId);

    void modifyUser(String userId, String userName);

}

package com.zhengxin.pattern.simplefactory;

/**
 * Created by 136931 on 2016/2/23.
 */
public class DomainLogin implements Login {

    @Override
    public boolean verify(String username, String password) {
        return false;
    }
}

package com.zhengxin.database;


/**
 * Created by 136931 on 2016/2/25.
 */
public class Client {

    public static void main(String[] args){

        long curr = System.currentTimeMillis();

        for(int i=0; i<5; i++){
            System.out.println("id: " + JdbcUtil.insert("zhangsan", "123456", curr, curr));
        }

    }
}

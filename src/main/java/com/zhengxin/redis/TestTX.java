package com.zhengxin.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author zhengxin
 * @date 2018-07-21 23:18:47
 */
public class TestTX {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("server01", 6380);
        Transaction transaction = null;
        try {
            transaction = jedis.multi();
            transaction.set("k4","v4");
            transaction.set("k5","v5");

            transaction.exec();
        }catch (Exception e){
            transaction.discard();
        }finally {
                try {
                    transaction.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

        }




    }
}

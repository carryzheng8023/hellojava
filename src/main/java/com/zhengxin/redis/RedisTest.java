package com.zhengxin.redis;

import redis.clients.jedis.Jedis;

/**
 * @author zhengxin
 * @date 2018-07-20 18:46:37
 */
public class RedisTest {

    public static void main(String[] args) {


        Jedis jedis = new Jedis("server01", 6380);
        System.out.println(jedis.ping());

//        jedis.set("k4", "v4");

        System.out.println(jedis.keys("*"));
    }

}

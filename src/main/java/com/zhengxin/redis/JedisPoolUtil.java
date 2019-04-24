package com.zhengxin.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zhengxin
 * @date 2018-07-21 23:44:19
 */
public class JedisPoolUtil {


    private static volatile JedisPool jedisPool = null;

    private JedisPoolUtil(){}

    public static JedisPool getJedisPoolInstance(){
        if (null == jedisPool){
            synchronized (JedisPoolUtil.class){
                if (null == jedisPool){
                    jedisPool = new JedisPool("server01", 6380);
                }
            }
        }
        return jedisPool;
    }

    public static void release(JedisPool jedisPool, Jedis jedis){
        if(null != jedis){

        }
    }

}

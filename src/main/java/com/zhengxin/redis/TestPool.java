package com.zhengxin.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author zhengxin
 * @date 2018-07-21 23:52:58
 */
public class TestPool {

    public static void main(String[] args) {

        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();

        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.set("aa", "bb");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JedisPoolUtil.release(jedisPool, jedis);
        }

    }

}

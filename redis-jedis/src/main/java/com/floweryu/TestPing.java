package com.floweryu;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author Floweryu
 * @date 2021/5/26 21:37
 */
public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("175.24.147.35", 6379);
        jedis.auth("redis");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("name", "zhang");

        // 开启事务
        Transaction transaction = jedis.multi();
        String result = jsonObject.toJSONString();

        try {
            transaction.set("user1", result);
            transaction.set("user2", result);
            transaction.exec();
        }catch (Exception e) {
            transaction.discard();
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));

            jedis.close();
        }
    }
}

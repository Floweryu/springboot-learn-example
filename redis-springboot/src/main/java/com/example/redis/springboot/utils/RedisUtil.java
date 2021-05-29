package com.example.redis.springboot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 * @author Floweryu
 * @date 2021/5/29 15:24
 */
@Component
public final class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /* ----------------------------key相关操作--------------------------*/

    /**
     * 删除key
     * @param key 键值
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }



    /**
     * 设置缓存失效时间
     * @param key 键值
     * @param time 时间（秒）
     * @return Boolean
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

}

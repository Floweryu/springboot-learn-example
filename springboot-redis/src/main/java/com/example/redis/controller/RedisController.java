package com.example.redis.controller;

import com.example.redis.result.Result;
import com.example.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/get")
    @ResponseBody
    public Result<Object> getRedis(@RequestParam String key) {
        Object value = redisUtil.get(key);
        return Result.success(value);
    }
}

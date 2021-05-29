package com.example.redis.springboot;

import com.example.redis.springboot.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisSpringbootApplicationTests {

	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
		redisTemplate.opsForValue().set("key2", "value1发送发送");
		System.out.println(redisTemplate.opsForValue().get("key2"));
	}

	@Test
	void test() throws JsonProcessingException {
		User user = new User("zhanglei", 21);
		String jsonUser = new ObjectMapper().writeValueAsString(user);
		redisTemplate.opsForValue().set("user", user);
		System.out.println(redisTemplate.opsForValue().get("user"));
	}

}

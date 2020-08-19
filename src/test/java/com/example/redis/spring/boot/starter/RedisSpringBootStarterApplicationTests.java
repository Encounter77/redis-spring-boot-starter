package com.example.redis.spring.boot.starter;

import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RedisSpringBootStarterApplication.class)
class RedisSpringBootStarterApplicationTests {

	@Autowired
	private RedissonClient redissonClient;

	private static Logger logger = LoggerFactory.getLogger(RedisSpringBootStarterApplication.class);

	@Test
	void contextLoads() {
		for (String key : redissonClient.getKeys().getKeys()) {
			logger.info(key);
		}
	}

}

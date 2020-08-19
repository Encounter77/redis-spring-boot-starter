package com.example.redis.spring.boot.starter.config;


import com.example.redis.spring.boot.starter.properties.RedissonProperties;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jiangyanfei
 */
@Configuration
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonAutoConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(RedissonAutoConfiguration.class);

	@Bean
	RedissonClient redissonClient(RedissonProperties redissonProperties) {
		Config config = new Config();
		String prefix = "redis://";
		if (redissonProperties.isSsl()) {
			prefix = "rediss://";
		}
//		SingleServerConfig singleServerConfig = config.useSingleServer()
//				.setAddress(prefix + redissonProperties.getHost() + ":" + redissonProperties.getPort())
//				.setIdleConnectionTimeout(redissonProperties.getTimeout());
		config.useSingleServer().setAddress("redis://127.0.0.1:6379");
//		if (!StringUtils.isEmpty(redissonProperties.getPassword())) {
//			singleServerConfig.setPassword(redissonProperties.getPassword());
//		}
		RedissonClient redissonClient = Redisson.create(config);
		logger.info("redissonClient init success");
		return redissonClient;
	}
}

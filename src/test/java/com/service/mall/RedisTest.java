package com.service.mall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.redis.core.StringRedisTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Slf4j
public class RedisTest {
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Test
	public void test() {
		int i = 0;
		while (true) {
			i++;
			System.out.println("当前运行参数:" + i);
			log.error("i是:{}", i);
			try {

				this.stringRedisTemplate.opsForValue().set(String.valueOf(i), String.valueOf(i));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
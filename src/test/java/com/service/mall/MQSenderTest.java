package com.service.mall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.mall.mq.sender.RabbitMQSender;

@SpringBootTest()
public class MQSenderTest {
	@Autowired
	private RabbitMQSender rabbitTemplate;

	@Test
	public void send() {
		//rabbitTemplate.send("我去你大爷");
	}
}

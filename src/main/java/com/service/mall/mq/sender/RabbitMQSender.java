package com.service.mall.mq.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.mall.configration.RabbitFanoutConfig;
import com.service.mall.configration.RabbitTopicConfig;

@Service
public class RabbitMQSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(String message,String routingKey) {
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_EXCHANGE,routingKey, message);
	}
}

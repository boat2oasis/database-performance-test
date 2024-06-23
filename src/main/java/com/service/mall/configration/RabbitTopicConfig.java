package com.service.mall.configration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopicConfig {
	 public static final String TOPIC_EXCHANGE = "zhou.topic";

	    @Bean
	    public TopicExchange topicExchange() {
	        return new TopicExchange(TOPIC_EXCHANGE);
	    }

	    @Bean
	    public Queue top1() {
	        return new Queue("top1");
	    }

	    @Bean
	    public Queue top2() {
	        return new Queue("top2");
	    }

	    @Bean
	    public Binding binding4(TopicExchange topicExchange, Queue queue1) {
	        return BindingBuilder.bind(queue1).to(topicExchange).with("#.top1");
	    }

	    @Bean
	    public Binding binding5(TopicExchange topicExchange, Queue queue2) {
	        return BindingBuilder.bind(queue2).to(topicExchange).with("#.top1");
	    }
}

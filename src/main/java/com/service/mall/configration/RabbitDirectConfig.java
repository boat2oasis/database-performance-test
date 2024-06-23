package com.service.mall.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;


@Configuration
public class RabbitDirectConfig {
	    public static final String QUEUE_NAME = "direct";
	    public static final String EXCHANGE_NAME = "zhou.direct";
	    public static final String ROUTING_KEY = "direct";

	    @Bean
	    public Queue queue() {
	        return new Queue(QUEUE_NAME, false);
	    }

	    @Bean
	    public DirectExchange exchange() {
	        return new DirectExchange(EXCHANGE_NAME);
	    }

	    @Bean
	    public Binding binding(Queue queue, DirectExchange exchange) {
	        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	    }
}

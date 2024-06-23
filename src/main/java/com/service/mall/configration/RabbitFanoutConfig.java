package com.service.mall.configration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitFanoutConfig {

	
	public static final String FANOUT_EXCHANGE = "zhou.fanout";

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Queue queue1() {
        return new Queue("fanout1");
    }

    @Bean
    public Queue queue2() {
        return new Queue("fanout2");
    }
    
    @Bean
    public Queue queue3() {
        return new Queue("fanout3");
    }

    @Bean
    public Binding binding1(FanoutExchange fanoutExchange, Queue queue1) {
        return BindingBuilder.bind(queue1).to(fanoutExchange);
    }

    @Bean
    public Binding binding2(FanoutExchange fanoutExchange, Queue queue2) {
        return BindingBuilder.bind(queue2).to(fanoutExchange);
    }
    
    @Bean
    public Binding binding3(FanoutExchange fanoutExchange, Queue queue3) {
        return BindingBuilder.bind(queue3).to(fanoutExchange);
    }
    
    
}

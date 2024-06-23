package com.service.mall.mq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {

    @RabbitListener(queues = "top1")
    public void receiveMessage1(String message) {
        System.out.println("Received < top1" + message + ">");
    }
    
    @RabbitListener(queues = "top2")
    public void receiveMessage2(String message) {
        System.out.println("Received < top2" + message + ">");
    }
    
    /*
    @RabbitListener(queues = "fanout3")
    public void receiveMessage3(String message) {
        System.out.println("Received < fanout3" + message + ">");
    }
    */
}
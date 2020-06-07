package com.liyiruo.rabbitmq.liyiruobizsubscriber.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailReceive {
@RabbitListener(queues = "EmailQueue")
    public void receive(String msg) {
        System.out.println("收到的消失是：==》"+msg);

    }
}

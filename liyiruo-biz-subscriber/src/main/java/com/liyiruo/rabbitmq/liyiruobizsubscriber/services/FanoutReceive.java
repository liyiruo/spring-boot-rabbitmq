package com.liyiruo.rabbitmq.liyiruobizsubscriber.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FanoutReceive {
@RabbitListener(queues = "FanoutQueue1")
    public void receiveFanout1(String msg) {
        System.out.println("FanoutQueue1：==》"+msg);

    }

    @RabbitListener(queues = "FanoutQueue2")
    public void receiveFanout2(String msg) {
        System.out.println("FanoutQueue2：==》"+msg);

    }
}

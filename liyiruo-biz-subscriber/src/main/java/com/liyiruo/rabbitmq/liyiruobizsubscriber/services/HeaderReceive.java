package com.liyiruo.rabbitmq.liyiruobizsubscriber.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HeaderReceive {
@RabbitListener(queues = "headerQueue1")
    public void receive1(String msg) {
        System.out.println("headerQueue1：==》"+msg);
    }

    @RabbitListener(queues = "headerQueue2")
    public void receive2(String msg) {
        System.out.println("headerQueue2：==》"+msg);
    }

    @RabbitListener(queues = "headerQueue3")
    public void receive3(String msg) {
        System.out.println("headerQueue3：==》"+msg);
    }

    @RabbitListener(queues = "headerQueue4")
    public void receive4(String msg) {
        System.out.println("headerQueue4：==》"+msg);
    }
}

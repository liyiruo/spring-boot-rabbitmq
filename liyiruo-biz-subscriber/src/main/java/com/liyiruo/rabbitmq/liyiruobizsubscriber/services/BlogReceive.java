package com.liyiruo.rabbitmq.liyiruobizsubscriber.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BlogReceive {
    @RabbitListener(queues = "BlogJavaQueue")
    public void receiveJava(String msg) {
        System.out.println("BlogJavaQueue：==》" + msg);

    }


    @RabbitListener(queues = "BlogDotNetQueue")
    public void receiveDotNet(String msg) {
        System.out.println("BlogDotNetQueue：==》" + msg);

    }

    @RabbitListener(queues = "BlogAllQueue")
    public void receiveAll(String msg) {
        System.out.println("BlogAllQueue：==》" + msg);

    }

}

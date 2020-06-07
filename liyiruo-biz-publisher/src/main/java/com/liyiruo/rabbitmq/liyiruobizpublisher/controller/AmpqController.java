package com.liyiruo.rabbitmq.liyiruobizpublisher.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/amqp")
public class AmpqController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    //http://localhost:8071/amqp/direct?msg=123
    @RequestMapping("direct")
    public String sendEmail(@RequestParam Map<String, Object> params) {
        String msg = params.get("msg").toString();
        //发送到哪个交换机，routingkey 是什么，发送的内容是什么
        rabbitTemplate.convertAndSend("EmailExchage", "EmailRouting", msg);
        return "OK";
    }

    //http://localhost:8071/amqp/topic?msg=123
    @RequestMapping("topic")
    public String sendBlog(@RequestParam Map<String, Object> params) {
        String msg = params.get("msg").toString();
        String routingKey = params.get("key").toString();
        //发送到哪个交换机，routingkey 是什么，发送的内容是什么
        rabbitTemplate.convertAndSend("BlogExchange", routingKey, msg);
        return "OK";
    }


    //http://localhost:8071/amqp/fanout?msg=123
    //分发这种模式 不需要routingKey
    @RequestMapping("fanout")
    public String sendFanout(@RequestParam Map<String, Object> params) {
        String msg = params.get("msg").toString();
        //发送到哪个交换机，routingkey 是什么，发送的内容是什么
        rabbitTemplate.convertAndSend("FanoutExchage", null, msg);
        return "OK";
    }



    //http://localhost:8071/amqp/header?msg=123&token=&id=
    @RequestMapping("header")
    public String sendHeader(@RequestParam Map<String, Object> params) {
        String msg = params.get("msg").toString();
        MessageProperties messageProperties = new MessageProperties();
        if (params.get("token") != null) {
            messageProperties.setHeader("token",params.get("token").toString());
        }
        if (params.get("id") != null) {
            messageProperties.setHeader("id",params.get("id").toString());
        }

        Message message = new Message(msg.getBytes(), messageProperties);
        //发送到哪个交换机，routingkey 是什么，发送的内容是什么
        rabbitTemplate.convertAndSend("HeadersExchage", null, message);
        return "OK";
    }




}

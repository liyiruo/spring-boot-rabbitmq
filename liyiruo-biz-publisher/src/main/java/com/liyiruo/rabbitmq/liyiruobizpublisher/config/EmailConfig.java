package com.liyiruo.rabbitmq.liyiruobizpublisher.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {

    /**
     * 声明一个交换机
     * 消息发送者会将消息发送到此交换机
     * @return
     */
    @Bean
    DirectExchange EmailExchage(){
        return new DirectExchange("EmailExchage");
    }
}

package com.liyiruo.rabbitmq.liyiruobizpublisher.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderConfig {

    /**
     * 声明一个交换机 声明交换机的时候 它的类型就确定了
     * 消息发送者会将消息发送到此交换机
     * @return
     */
    @Bean
    HeadersExchange HeadersExchage(){
        return new HeadersExchange("HeadersExchage");
    }
}

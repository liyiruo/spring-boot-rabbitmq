package com.liyiruo.rabbitmq.liyiruobizsubscriber.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1。声明交换机
 * 2。声明队列
 * 3。binding 将交换机绑定到哪个队列，接收什么样的routingkey
 */
@Configuration
public class EmailConfig {

    @Bean
    DirectExchange EmailExchange() {
        return new DirectExchange("EmailExchage");
    }

    @Bean
    Queue EmailQueue() {
        return new Queue("EmailQueue");
    }

    @Bean
    Binding BindEmail() {
        return BindingBuilder.bind(EmailQueue()).to(EmailExchange()).with("EmailRouting");
    }
}

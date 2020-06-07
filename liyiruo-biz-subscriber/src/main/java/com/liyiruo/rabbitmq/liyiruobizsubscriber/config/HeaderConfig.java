package com.liyiruo.rabbitmq.liyiruobizsubscriber.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HeaderConfig {

    /**
     * 声明一个交换机 声明交换机的时候 它的类型就确定了
     * 消息发送者会将消息发送到此交换机
     *
     * @return
     */
    @Bean
    HeadersExchange HeadersExchage() {
        return new HeadersExchange("HeadersExchage");
    }

    @Bean
    Queue headerQueue1() {
        return new Queue("headerQueue1");
    }

    @Bean
    Queue headerQueue2() {
        return new Queue("headerQueue2");
    }

    @Bean
    Queue headerQueue3() {
        return new Queue("headerQueue3");
    }

    @Bean
    Queue headerQueue4() {
        return new Queue("headerQueue4");
    }

    @Bean
    Binding bindHeaderQueue1() {

        return BindingBuilder
                .bind(headerQueue1())
                .to(HeadersExchage())
                .whereAny("token", "id")
                .exist();
    }

    @Bean
    Binding bindHeaderQueue2() {
        return BindingBuilder
                .bind(headerQueue2())
                .to(HeadersExchage())
                .whereAll("token", "id")
                .exist();
    }

    @Bean
    Binding bindHeaderQueue3() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "123");
        map.put("id", "123");
        return BindingBuilder
                .bind(headerQueue3())
                .to(HeadersExchage())
                .whereAll(map)
                .match();
    }

    @Bean
    Binding bindHeaderQueue4() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "123");
        map.put("id", "123");
        return BindingBuilder
                .bind(headerQueue4())
                .to(HeadersExchage())
                .whereAny(map)
                .match();
    }

}

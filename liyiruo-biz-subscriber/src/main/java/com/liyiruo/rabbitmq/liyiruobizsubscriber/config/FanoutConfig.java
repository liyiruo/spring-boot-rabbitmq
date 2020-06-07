package com.liyiruo.rabbitmq.liyiruobizsubscriber.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    /**
     * 声明一个交换机 声明交换机的时候 它的类型就确定了
     * 消息发送者会将消息发送到此交换机
     * @return
     */
    @Bean
    FanoutExchange FanoutExchage(){
        return new FanoutExchange("FanoutExchage");
    }


    @Bean
    Queue FanoutQueue1() {
        return new Queue("FanoutQueue1");
    }

    @Bean
    Binding BindFanout1() {
        return BindingBuilder.bind(FanoutQueue1()).to(FanoutExchage());
    }



    @Bean
    Queue FanoutQueue2() {
        return new Queue("FanoutQueue2");
    }

    @Bean
    Binding BindFanout2() {
        return BindingBuilder.bind(FanoutQueue2()).to(FanoutExchage());
    }
}

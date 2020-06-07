package com.liyiruo.rabbitmq.liyiruobizsubscriber.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogConfig {
    //声明了交换机
    @Bean
    TopicExchange BlogExchange() {
        return new TopicExchange("BlogExchange");
    }

    //声明了队列1
    @Bean
    Queue BlogJavaQueue() {
        return new Queue("BlogJavaQueue", true);
    }

    //声明了队列2
    @Bean
    Queue BlogDotNetQueue() {
        return new Queue("BlogDotNetQueue", true);
    }


    //声明了队列3
    @Bean
    Queue BlogAllQueue() {
        return new Queue("BlogAllQueue", true);
    }


    //第一种绑定方式
    @Bean
    Binding BindToJavaBlog() {
        return BindingBuilder.bind(BlogJavaQueue()).to(BlogExchange()).with("blog.java");
    }
    //第二种绑定方式
    @Bean
    Binding BindToDotNetBlog() {
        return BindingBuilder.bind(BlogDotNetQueue()).to(BlogExchange()).with("blog.dotNet");
    }
    //第三种绑定方式
    @Bean
    Binding BindToAllBlog() {
        return BindingBuilder.bind(BlogAllQueue()).to(BlogExchange()).with("blog.#");
    }

}

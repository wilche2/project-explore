package com.xuexiangban.rabbitmq.springbootrabbitmqproducer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.xuexiangban.rabbitmq.springbootrabbitmqproducer.utils.RabbitMqConstants.*;

/**
 * @author caoweiquan
 * @date 2021/3/20 21:42
 */
@Configuration
public class RabbitMqConfiguration {

    /**
     * 创建fanout模式交换机
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_NAME_ORDER, true, false);
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(QUEUE_NAME_EMAIL, true);
    }

    @Bean
    public Queue smsQueue() {
        return new Queue(QUEUE_NAME_SMS, true);
    }

    @Bean
    public Queue weChatQueue() {
        return new Queue(QUEUE_NAME_WECHAT, true);
    }

    @Bean
    public Binding emailBind() {
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding smsBind() {
        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding weChatBind() {
        return BindingBuilder.bind(weChatQueue()).to(fanoutExchange());
    }

}

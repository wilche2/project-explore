package com.xuexiangban.rabbitmq.springbootrabbitmqproducer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.xuexiangban.rabbitmq.springbootrabbitmqproducer.utils.RabbitMqConstants.EXCHANGE_NAME_ORDER_DEAD_DIRECT;
import static com.xuexiangban.rabbitmq.springbootrabbitmqproducer.utils.RabbitMqConstants.QUEUE_NAME_DEAD_DIRECT;


/**
 * 死信队列
 *
 * @author caoweiquan
 * @date 2021/3/21 13:53
 */
@Configuration
public class DeadRabbitMqConfiguration {

    /**
     * 创建的direct模式交换机
     *
     * @return
     */
    @Bean
    public DirectExchange deadDirectExchange() {
        return new DirectExchange(EXCHANGE_NAME_ORDER_DEAD_DIRECT, true, false);
    }

    /**
     * 给队列设置ttl
     *
     * @return
     */
    @Bean
    public Queue deadDirectQueue() {
        return new Queue(QUEUE_NAME_DEAD_DIRECT, true);
    }

    @Bean
    public Binding deadDirectBind() {
        return BindingBuilder.bind(deadDirectQueue()).to(deadDirectExchange()).with("dead-test");
    }


}

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
public class FanoutRabbitMqConfiguration {

    /**
     * 创建fanout模式交换机
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_NAME_ORDER_FANOUT, true, false);
    }

    @Bean
    public Queue fanoutEmailQueue() {
        return new Queue(QUEUE_NAME_EMAIL_FANOUT, true);
    }

    @Bean
    public Queue fanoutSmsQueue() {
        return new Queue(QUEUE_NAME_SMS_FANOUT, true);
    }

    @Bean
    public Queue fanoutWeChatQueue() {
        return new Queue(QUEUE_NAME_WECHAT_FANOUT, true);
    }

    /**
     * 每个bean的签名最好不能冲突
     *
     * @return
     */
    @Bean
    public Binding fanoutEmailBind() {
        return BindingBuilder.bind(fanoutEmailQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutSmsBind() {
        return BindingBuilder.bind(fanoutSmsQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutWeChatBind() {
        return BindingBuilder.bind(fanoutWeChatQueue()).to(fanoutExchange());
    }

}

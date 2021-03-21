package com.xuexiangban.rabbitmq.springbootrabbitmqproducer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.xuexiangban.rabbitmq.springbootrabbitmqproducer.utils.RabbitMqConstants.*;

/**
 * @author caoweiquan
 * @date 2021/3/21 13:53
 */
@Configuration
public class DirectRabbitMqConfiguration {

    /**
     * 创建direct模式交换机
     *
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME_ORDER_DIRECT, true, false);
    }

    @Bean
    public Queue directEmailQueue() {
        return new Queue(QUEUE_NAME_EMAIL_DIRECT, true);
    }

    @Bean
    public Queue directSmsQueue() {
        return new Queue(QUEUE_NAME_SMS_DIRECT, true);
    }

    @Bean
    public Queue directWeChatQueue() {
        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        // return new Queue("TestDirectQueue",true,true,false);
        return new Queue(QUEUE_NAME_WECHAT_DIRECT, true);
    }

    /**
     * 每个bean的签名最好不能冲突
     *
     * @return
     */
    @Bean
    public Binding directEmailBind() {
        return BindingBuilder.bind(directEmailQueue()).to(directExchange()).with("email");
    }

    @Bean
    public Binding directSmsBind() {
        return BindingBuilder.bind(directSmsQueue()).to(directExchange()).with("sms");
    }

    @Bean
    public Binding directWeChatBind() {
        return BindingBuilder.bind(directWeChatQueue()).to(directExchange()).with("weChat");
    }

}

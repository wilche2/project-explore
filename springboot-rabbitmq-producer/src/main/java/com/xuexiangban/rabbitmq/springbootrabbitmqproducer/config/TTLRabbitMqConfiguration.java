package com.xuexiangban.rabbitmq.springbootrabbitmqproducer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static com.xuexiangban.rabbitmq.springbootrabbitmqproducer.utils.RabbitMqConstants.*;


/**
 * 过期时间
 *
 * @author caoweiquan
 * @date 2021/3/21 13:53
 */
@Configuration
public class TTLRabbitMqConfiguration {

    /**
     * 创建的direct模式交换机
     *
     * @return
     */
    @Bean
    public DirectExchange ttlDirectExchange() {
        return new DirectExchange(EXCHANGE_NAME_ORDER_TTL_DIRECT, true, false);
    }

    /**
     * 给队列设置ttl
     *
     * @return
     */
    @Bean
    public Queue ttlDirectQueue() {
        Map<String, Object> param = new HashMap<>(2);
        param.put("x-message-ttl", 5000);

        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        return new Queue(QUEUE_NAME_TTL_DIRECT, true, false, false, param);
    }

    @Bean
    public Binding ttlDirectBind() {
        return BindingBuilder.bind(ttlDirectQueue()).to(ttlDirectExchange()).with("ttl-test");
    }

    @Bean
    public Queue ttlMessageDirectQueue() {
        return new Queue(QUEUE_NAME_MESSAGE_TTL_DIRECT, true);
    }

    @Bean
    public Binding ttlMessageDirectBind() {
        return BindingBuilder.bind(ttlMessageDirectQueue()).to(ttlDirectExchange()).with("ttl-message-test");
    }

}

package com.xuexiangban.rabbitmq.springbootrabbitmqconsumer.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import static com.xuexiangban.rabbitmq.springbootrabbitmqconsumer.utils.RabbitMqConstants.EXCHANGE_NAME_ORDER_TOPIC;
import static com.xuexiangban.rabbitmq.springbootrabbitmqconsumer.utils.RabbitMqConstants.QUEUE_NAME_WECHAT_TOPIC;

/**
 * @author caoweiquan
 * @date 2021/3/20 21:59
 */
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = QUEUE_NAME_WECHAT_TOPIC, durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = EXCHANGE_NAME_ORDER_TOPIC, type = ExchangeTypes.TOPIC),
        key = "weChat.#"
))
@Component
public class TopicWeChatConsumerService {

    @RabbitHandler
    public void messageAccept(String message) {
        // 省略
        System.out.println("topic WeChat --------------> " + message);
    }

}

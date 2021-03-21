package com.xuexiangban.rabbitmq.springbootrabbitmqconsumer.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.xuexiangban.rabbitmq.springbootrabbitmqconsumer.utils.RabbitMqConstants.QUEUE_NAME_SMS_DIRECT;
import static com.xuexiangban.rabbitmq.springbootrabbitmqconsumer.utils.RabbitMqConstants.QUEUE_NAME_SMS_FANOUT;

/**
 * @author caoweiquan
 * @date 2021/3/20 21:59
 */
@RabbitListener(queues = QUEUE_NAME_SMS_DIRECT)
@Component
public class DirectSmsConsumerService {

    @RabbitHandler
    public void messageAccept(String message) {
        // 省略
        System.out.println("DIRECT sms--------------> " + message);
    }

}

package com.xuexiangban.rabbitmq.springbootrabbitmqconsumer.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.xuexiangban.rabbitmq.springbootrabbitmqconsumer.utils.RabbitMqConstants.QUEUE_NAME_SMS;

/**
 * @author caoweiquan
 * @date 2021/3/20 21:59
 */
@RabbitListener(queues = QUEUE_NAME_SMS)
@Component
public class FanoutSmsConsumerService {

    @RabbitHandler
    public void messageAccept(String message) {
        // 省略
        System.out.println("fanout sms--------------> " + message);
    }

}

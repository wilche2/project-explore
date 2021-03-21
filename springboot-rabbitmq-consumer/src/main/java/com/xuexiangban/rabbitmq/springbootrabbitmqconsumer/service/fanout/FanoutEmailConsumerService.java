package com.xuexiangban.rabbitmq.springbootrabbitmqconsumer.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.xuexiangban.rabbitmq.springbootrabbitmqconsumer.utils.RabbitMqConstants.QUEUE_NAME_EMAIL_FANOUT;

/**
 * @author caoweiquan
 * @date 2021/3/20 21:59
 */
@RabbitListener(queues = QUEUE_NAME_EMAIL_FANOUT)
@Component
public class FanoutEmailConsumerService {

    @RabbitHandler
    public void messageAccept(String message) {
        // 此处省略发邮件的逻辑
        System.out.println("fanout email--------------> " + message);
    }

}

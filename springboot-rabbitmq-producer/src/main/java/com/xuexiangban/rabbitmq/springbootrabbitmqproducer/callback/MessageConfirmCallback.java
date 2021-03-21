package com.xuexiangban.rabbitmq.springbootrabbitmqproducer.callback;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author caoweiquan
 * @date 2021/3/21 20:49
 */
@Component
public class MessageConfirmCallback implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("消息确认成功");
        } else {
            System.out.println("消息确认失败");
        }
    }

}
